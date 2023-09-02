/*
    프로그래머스 Lv3
    Title: 등산코스 정하기
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//노드(node)와 가중치(weight)를 저장할 클래스
class Node implements Comparable<Node> {
    int node;
    int weight;

    Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
    //노드를 가중치 기준으로 정렬하기 위해 오버라이딩
    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

class Solution {
    static ArrayList<ArrayList<Node>> list; //인접리스트
    static int[] dist; //각 정점으로 가는 등산코스의 intensity를 저장할 배열
    static boolean[] visited; //방문 확인
    static boolean[] isTop; //산봉우리(top) 확인용 배열
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int minIntensity = Integer.MAX_VALUE; //최소 intensity를 저장할 변수
        int summitsNum = 0; //intensity가 최소가 되는 등산코스의 산봉우리 번호

        list = new ArrayList<>();
        dist = new int[n + 1];
        isTop = new boolean[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        //그래프 인접 리스트 구현 (양방향)
        for (int i = 0; i < paths.length; i++) {
            int start = paths[i][0];
            int end = paths[i][1];
            int weight = paths[i][2];

            //start에서 end로 가는 weight (비용)
            list.get(start).add(new Node(end, weight));
            //end에서 start로 가는 weight (비용)
            list.get(end).add(new Node(start, weight));
        }
        //산봉우리 번호 배열 정렬
        Arrays.sort(summits);
        //산봉우리 확인용 배열 초기화
        for (int summit : summits) {
            isTop[summit] = true;
        }

        //시작지점(gates)을 인자로 다익스트라 알고리즘 호출
        dijkstra(gates);

        //산봉우리 번호가 저장된 배열(summits)을 순회하며,
        //intensity가 최소가 되는 등산코스에 포함된 산봉우리 번호와 intensity의 최솟값을 구함
        for (int summit : summits) {
            if(dist[summit] < minIntensity) {
                minIntensity = dist[summit];
                summitsNum = summit;
            }
        }
        //[산봉우리의 번호, intensity의 최솟값]을 리턴
        int[] answer = {summitsNum, minIntensity};
        return answer;
    }
    //다익스트라 알고리즘 변형 (우선순위 큐 활용)
    public static void dijkstra(int[] gates) {
        //모든 정점의 intensity를 Integer.MAX_VALUE로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        //정점과 해당 정점까지 가는 비용을 저장. 우선순위는 비용이 낮을수록 높음
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작 노드 설정 -> gates 배열의 모든 번호를 우선순위 큐에 추가
        for (int start : gates) {
            pq.offer(new Node(start, 0));
            dist[start] = 0;
        }

        //우선순위 큐가 비었을 때 다익스트라 알고리즘 종료
        while (!pq.isEmpty()) {
            //우선순위가 높은(비용이 낮은) 노드부터 꺼냄
            Node curNode = pq.poll();
            int cur = curNode.node;

            //해당 노드가 산봉우리일 때(산봉우리는 방문하지 않음) 혹은,
            //해당 노드로 가는 비용이 기존의 intensity보다 큰 경우 continue -> 다음 노드를 꺼냄
            if(isTop[cur] || dist[cur] < curNode.weight) {
                continue;
            }

            //방문하지 않은 노드라면 방문 체크 후, 인접 노드를 살펴봄
            if (!visited[cur]) {
                visited[cur] = true;
                //현재 노드(cur)를 기준으로 갈 수 있는(간선이 존재하는) 모든 노드를 순회
                for (Node node : list.get(cur)) {
                    //각 정점으로 가는 등산코스의 intensity를 갱신
                    if (Math.max(node.weight, dist[cur]) < dist[node.node]) {
                        dist[node.node] = Math.max(node.weight, dist[cur]);
                        pq.add(new Node(node.node, node.weight));
                    }
                }
            }
        }
    }
}