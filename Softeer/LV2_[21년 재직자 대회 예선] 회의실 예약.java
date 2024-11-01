import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, boolean[]> map = new HashMap<>();        
        for(int i = 0; i < N; i++) map.put(br.readLine(), new boolean[18]);


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String roomName = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boolean[] check = map.get(roomName);
            
            for(int j = start; j < end; j++) check[j] = true;
            
        }
        List<String> roomList = new ArrayList<>(map.keySet());
        Collections.sort(roomList);
        for(int idx = 0; idx < roomList.size(); idx++) {

            String roomName = roomList.get(idx);
            System.out.println("Room " + roomName + ":");
            boolean[] check = map.get(roomName);

            int cnt = 0;
            List<int[]> list = new ArrayList<>();
            int start = 0;
            int end = 1;
            for(int i = 9; i < check.length; i++) {
                if(!check[i] && (i == 9 || check[i - 1])) start = i;
                if(!check[i] && (i == check.length - 1|| check[i + 1])) {
                    end = i + 1;
                    list.add(new int[]{start, end});
                }
            }
            if(list.size() == 0) System.out.println("Not available");
            else {
                System.out.println(list.size() + " available:");
                for(int[] arr : list) {
                    System.out.println(String.format("%02d-%02d", arr[0], arr[1]));
                }
            }
            if(idx < roomList.size() - 1) System.out.println("-----");
        }
        
    }
}
