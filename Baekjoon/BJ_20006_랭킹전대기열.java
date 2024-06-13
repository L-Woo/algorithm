package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_20006_랭킹전대기열 {

    static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean check;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Player[] players = new Player[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players[i] = new Player(level, name);
        }

        for (int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();
            if (!players[i].check) {
                for (int j = i; j < p; j++) {
                    if (room.size() == m) break;
                    if (!players[j].check &&
                            players[i].level - 10 <= players[j].level &&
                            players[i].level + 10 >= players[j].level) {
                        players[j].check = true;
                        room.add(players[j]);
                    }
                }
                Collections.sort(room);
                if (room.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }
                for (int j = 0; j < room.size(); j++) {
                    sb.append(room.get(j).level + " " + room.get(j).name).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

}
