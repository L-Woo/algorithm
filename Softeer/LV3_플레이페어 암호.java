import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = in.readLine();
        String code = in.readLine();

        boolean[] check = new boolean[26];
        char[][] map = new char[5][5];
        check['J' - 'A'] = true;

        int idx = 0;
        for(int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if(ch == 'J') ch = 'I';
            if(check[ch - 'A']) continue;
            check[ch - 'A'] = true;
            map[idx / 5][idx % 5] = ch;
            idx++;
        }

        for(int i = 0; i < 26; i++) {
            if(check[i]) continue;
            map[idx / 5][idx % 5] = (char)('A' + i);
            idx++;
        }

        List<String> list = new ArrayList<>();
        idx = 0;
        while(idx < str.length()) {
            char ch = str.charAt(idx);
            
            if(idx == str.length() - 1) {
                sb.append(ch).append('X');
            }else if(ch == str.charAt(idx + 1)) {
                if(ch == 'X') {
                    sb.append(ch).append('Q');
                }else {
                    sb.append(ch).append('X');
                }
            }else if(ch != str.charAt(idx + 1)) {
                sb.append(ch).append(str.charAt(idx + 1));
                idx += 1;
            }
            list.add(sb.toString());
            sb.setLength(0);
            idx += 1;
        }

        for(String target : list) {

            int[][] point = new int[2][2];

            for(int i = 0; i < target.length(); i++) {
                boolean flag = true;
                for(int r = 0; r < 5; r++) {
                    for(int c = 0; c < 5; c++) {
                        if(!flag) break;
                        if(target.charAt(i) == map[r][c]) {
                            point[i][0] = r;
                            point[i][1] = c;
                            flag = false;
                        }
                    }
                    if(!flag) break;
                }
            }
            // 행이 같을 때
            if(point[0][0] == point[1][0]) {
                point[0][1] = (point[0][1] + 1) % 5;
                point[1][1] = (point[1][1] + 1) % 5;
            }
            // 열이 같을 때
            else if(point[0][1] == point[1][1]) {
                point[0][0] = (point[0][0] + 1) % 5;
                point[1][0] = (point[1][0] + 1) % 5;
            }
            // 행과 열이 모두 다를 때
            else if(point[0][0] != point[1][0] && point[0][1] != point[1][1]) {
                int temp = point[0][1];
                point[0][1] = point[1][1];
                point[1][1] = temp;
            }
            sb.append(map[point[0][0]][point[0][1]]).append(map[point[1][0]][point[1][1]]);
        }
        System.out.println(sb.toString());
    }
}
