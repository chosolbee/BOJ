import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        int[] parents = new int[N+1];

        ArrayList<Integer>[] connections = new ArrayList[N+1];

        for(int i = 0; i <= N; i++) {
            connections[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            connections[node1].add(node2);
            connections[node2].add(node1);
        }

        boolean[] visited = new boolean[N+1]; // 각 노드의 방문 여부를 저장하는 배열
//        printTree(connections, 1, "", visited); // 루트 노드부터 트리를 출력

        // 각 노드를 Queue에 저장하고 방문하며, 노드에 연결된 노드들을 child로 한다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // root 노드부터 방문

        while(! queue.isEmpty()) {
            int now = queue.poll();
//            System.out.println("now"+ now);
            for(int child: connections[now]) {
                // 만약 부모노드가 결정되었다면 continue
//                System.out.println("child"+child);
                if (parents[child] != 0) continue;
                parents[child] = now; //now가 해당 child의 parents
                queue.add(child); // 해당 child 방문했고, 이에 대한 자식노드를 탐색해야 함을 의미
            }
        }

        for(int i = 2; i <= N; i++) {
            out.write(parents[i] + "\n");
        }

        out.flush();
        out.close();
    }
    // 트리를 시각화 함수
    static void printTree(ArrayList<Integer>[] connections, int currentNode, String indent, boolean[] visited) {
        visited[currentNode] = true; // 현재 노드를 방문했다고 표시
        System.out.println(indent + "Node " + currentNode); // 현재 노드 출력

        // 현재 노드와 연결된 모든 노드에 대해
        for (int i = 0; i < connections[currentNode].size(); i++) {
            int nextNode = connections[currentNode].get(i);
            if (!visited[nextNode]) { // 아직 방문하지 않은 노드라면
                printTree(connections, nextNode, indent + "  ", visited); // 해당 노드를 방문
            }
        }
    }
}
