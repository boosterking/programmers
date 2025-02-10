import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int validCount = 0;

        for(String skillTree : skill_trees) {
            if(isValidSkillTree(skill, skillTree)) {
                validCount++;
            }
        }

        return validCount;
    }

    private boolean isValidSkillTree(String skill, String skillTree) {
        int skillIndex = 0;

        for(char c : skillTree.toCharArray()) {
            if(skill.indexOf(c) != -1) {
                if(skill.charAt(skillIndex) == c) skillIndex++;
                else return false;
            }
        }

        return true;
    }
}
