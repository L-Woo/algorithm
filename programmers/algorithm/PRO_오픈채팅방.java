import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<String[]> list = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        
        for(String str : record) {
            String[] arr = str.split(" ");
            if(arr[0].equals("Enter")) {
                list.add(new String[] {arr[1], arr[0]});
                user.put(arr[1], arr[2]);
            }else if(arr[0].equals("Leave")) {
                list.add(new String[] {arr[1], arr[0]});
            }else {
                user.put(arr[1], arr[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            
            StringBuilder sb = new StringBuilder();
            
            sb.append(user.get(list.get(i)[0]));
            if(list.get(i)[1].equals("Enter")) {
                sb.append("님이 들어왔습니다.");    
            }else {
                sb.append("님이 나갔습니다.");    
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
