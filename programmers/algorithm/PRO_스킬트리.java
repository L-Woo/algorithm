class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        
        int answer = 0;
        
        for (String skillTree : skill_trees) {
            
            int idx = 0;
            boolean flag = true;
            
            for (char curSkill : skillTree.toCharArray()) {
                
                int sIdx = skill.indexOf(curSkill);
                
                if (sIdx == -1)
                    continue;
                else if (sIdx == idx)
                    idx++;
                else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                answer++;
        }
        return answer;
    }
}
