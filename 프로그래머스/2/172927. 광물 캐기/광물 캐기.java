import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<int[]> chunkCosts = new ArrayList<>();
        int length = minerals.length;
        int chunkCount = (int) Math.ceil(length / 5.0);

        for(int i = 0; i < length; i += 5) {
            int end = Math.min(i + 5, length);
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < end; j++) {
                String mineral = minerals[j];
                switch(mineral) {
                    case "diamond":
                        dia += 1;
                        iron += 5;
                        stone += 25;
                        break;
                    case "iron":
                        dia += 1;
                        iron += 1;
                        stone += 5;
                        break;
                    case "stone":
                        dia += 1;
                        iron += 1;
                        stone += 1;
                        break;
                }
            }
            chunkCosts.add(new int[]{dia, iron, stone});
        }
        
        int maxDia = picks[0], maxIron = picks[1], maxStone = picks[2];
        int[][][][] dp = new int[chunkCosts.size() + 1][maxDia + 1][maxIron + 1][maxStone + 1];

        for(int i = 0; i <= chunkCosts.size(); i++) {
            for(int d = 0; d <= maxDia; d++) {
                for(int ir = 0; ir <= maxIron; ir++) {
                    Arrays.fill(dp[i][d][ir], Integer.MAX_VALUE);
                }
            }
        }
        dp[0][maxDia][maxIron][maxStone] = 0;

        for(int chunk = 0; chunk < chunkCosts.size(); chunk++) {
            for(int d = 0; d <= maxDia; d++) {
                for(int ir = 0; ir <= maxIron; ir++) {
                    for(int st = 0; st <= maxStone; st++) {
                        if(dp[chunk][d][ir][st] == Integer.MAX_VALUE) continue;
                        if(d > 0) {
                            int[] costs = chunkCosts.get(chunk);
                            int nextD = d - 1;
                            int nextIr = ir;
                            int nextSt = st;
                            int newCost = dp[chunk][d][ir][st] + costs[0];
                            if(newCost < dp[chunk + 1][nextD][nextIr][nextSt]) dp[chunk + 1][nextD][nextIr][nextSt] = newCost;
                        }

                        if(ir > 0) {
                            int[] costs = chunkCosts.get(chunk);
                            int nextD = d;
                            int nextIr = ir - 1;
                            int nextSt = st;
                            int newCost = dp[chunk][d][ir][st] + costs[1];
                            if(newCost < dp[chunk + 1][nextD][nextIr][nextSt]) dp[chunk + 1][nextD][nextIr][nextSt] = newCost;
                        }

                        if(st > 0) {
                            int[] costs = chunkCosts.get(chunk);
                            int nextD = d;
                            int nextIr = ir;
                            int nextSt = st - 1;
                            int newCost = dp[chunk][d][ir][st] + costs[2];
                            if(newCost < dp[chunk + 1][nextD][nextIr][nextSt]) dp[chunk + 1][nextD][nextIr][nextSt] = newCost;
                        }
                    }
                }
            }
        }

        int minFatigue = Integer.MAX_VALUE;
        for(int chunk = 0; chunk <= chunkCosts.size(); chunk++) {
            for(int d = 0; d <= maxDia; d++) {
                for(int ir = 0; ir <= maxIron; ir++) {
                    for(int st = 0; st <= maxStone; st++) {
                        if(dp[chunk][d][ir][st] == Integer.MAX_VALUE) continue;
                        if(chunk == chunkCosts.size() || (d + ir + st == 0)) minFatigue = Math.min(minFatigue, dp[chunk][d][ir][st]);
                    }
                }
            }
        }
        
        return minFatigue;
    }
}
