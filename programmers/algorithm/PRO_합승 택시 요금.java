// 출발지점에서 A, B 각각의 도착지점에 도착할때 예상 최저 택시요금을 계산
// n개의 지점 수 1 ~ n
// 출발지점 s, A의 도착지점 a, B의 도착지점 b
// 양방향 이동 가능 4 -> 1 이면 1 -> 4 가능
// 만약 합승을 하지 않고 각자 이동하는 경우의 예상 택시요금이 더 낮으면, 합승을 하지 않아도 된다.

// 노드의 개수가 200개 이므로 플로이드 와샬을 사용


import java.util.*;

class Solution {
    
    static final int INF = (int)1e9;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        
        int[][] dist = new int[n + 1][n + 1];
        
        for(int[] arr : dist) {
            Arrays.fill(arr, INF);
        }
        
        for(int[] fare : fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }
        // 플로이드 와샬 실행
        for(int k = 1; k < n+1; k++){
            for(int i = 1; i < n+1; i++){
                for(int j = 1; j < n+1; j++){
                    if(i == j) dist[i][j] = 0;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        // 시작 지점에서 각 정점으로 가는 값을 더 하고 도착한 정점에서 A, B의 도착지점을 가는 값을 더 한다.
        // 그 값이 answer보다 작으면 answer에 저장
        for(int i = 1; i < n+1; i++){
            // 만약 시작 지점에서 정점으로 가는 값과 A, B의 도착 지점으로 가는 값이 INF면 갈 수 없는 정점이기에 다음 노드로
            if(dist[s][i] != INF && dist[s][a] != INF && dist[s][b] != INF){
                answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
            }
        }
        
        return answer;
    }
    
}
