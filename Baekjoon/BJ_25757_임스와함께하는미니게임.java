package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        int ans = 0;

        for(int i = 0; i < N; i++) set.add(br.readLine());
        char ch = st.nextToken().charAt(0);
        if(ch == 'Y') ans = set.size();
        else if(ch == 'F') ans = set.size() / 2;
        else ans = set.size() / 3;

        System.out.println(ans);
    }

}
