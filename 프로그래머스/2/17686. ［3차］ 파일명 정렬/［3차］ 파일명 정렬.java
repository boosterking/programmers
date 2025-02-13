import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = splitFileName(s1);
                String[] file2 = splitFileName(s2);
                
                int headCompare = file1[0].compareToIgnoreCase(file2[0]);
                if(headCompare != 0) {
                    return headCompare;
                }
                
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);
                return num1 - num2;
            }
        });
        
        return files;
    }
    
    private String[] splitFileName(String fileName) {
        String head = fileName.split("\\d+")[0];
        String number = fileName.substring(head.length()).split("\\D")[0];
        return new String[]{head, number};
    }
}
