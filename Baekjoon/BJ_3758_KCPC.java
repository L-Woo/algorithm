package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3758_KCPC {

    static class Team {
        int id;
        int[] scoreList;
        int submitCnt;
        int lastSubmit;
        int totalScore;

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int T = 0; T < testCase; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] record = new Team[n];
            for (int i = 0; i < m; i++) {

                st = new StringTokenizer(br.readLine());
                int teamID = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (record[teamID - 1] == null) {
                    record[teamID - 1] = new Team();
                    record[teamID - 1].id = teamID;
                    record[teamID - 1].scoreList = new int[k + 1];
                }

                record[teamID - 1].scoreList[problemNum] = Math.max(score, record[teamID - 1].scoreList[problemNum]);
                record[teamID - 1].submitCnt++;
                record[teamID - 1].lastSubmit = i;

            }
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += record[i].scoreList[j];
                }
                record[i].totalScore = sum;
            }

            Arrays.sort(record, ((o1, o2) -> {
                if(o1.totalScore == o2.totalScore) {
                    if(o1.submitCnt == o2.submitCnt) {
                        return o1.lastSubmit - o2.lastSubmit;
                    }
                    return o1.submitCnt - o2.submitCnt;
                }
                return o2.totalScore - o1.totalScore;
            }));

            for (int i = 0; i < n; i++) {
                if (record[i].id == t) System.out.println(i + 1);
            }
        }
    }

}
