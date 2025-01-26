package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16434_드래곤앤던전 {

    static class Room {
        int t, a, h;

        public Room(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long H = Integer.parseInt(st.nextToken());
        long start = 1, end = Long.MAX_VALUE - 1;

        Room[] rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(t, a, h);
        }

        while (start <= end) {
            long mid = (start + end) / 2;
            long curHp = mid;
            long curAtk = H;
            boolean flag = true;

            for (Room room : rooms) {
                if (room.t == 1) {
                    if (room.h % curAtk == 0) {
                        curHp -= room.a * ((room.h / curAtk) - 1);
                    } else {
                        curHp -= room.a * (room.h / curAtk);
                    }
                    if (curHp <= 0) {
                        flag = false;
                        break;
                    }
                } else {
                    curAtk += room.a;
                    curHp += room.h;
                    if (curHp > mid) curHp = mid;
                }
            }
            if (flag) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(start);
    }
}
