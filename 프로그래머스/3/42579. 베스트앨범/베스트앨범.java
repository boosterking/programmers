import java.util.*;

class Solution {
    private static class SongInfo {
        int play;
        int index;

        public SongInfo(int play, int index) {
            this.play = play;
            this.index = index;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<SongInfo>> genreSongsMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);

            if (!genreSongsMap.containsKey(genre)) genreSongsMap.put(genre, new ArrayList<>());
            genreSongsMap.get(genre).add(new SongInfo(play, i));
        }

        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((g1, g2) -> genreTotalPlays.get(g2) - genreTotalPlays.get(g1));

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<SongInfo> songs = genreSongsMap.get(genre);
            songs.sort((s1, s2) -> {
                if(s2.play != s1.play) return s2.play - s1.play;
                else return s1.index - s2.index;
            });

            int count = 0;
            for(SongInfo song : songs) {
                if(count >= 2) break;
                result.add(song.index);
                count++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
