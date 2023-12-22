import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
    }
    static void dfs(int N, int M, int depth) {
        // 현재 depth가 M과 같다면 (즉, M개의 숫자를 모두 선택했다면)
        if (depth == M) {
            // 배열 arr에 저장된 숫자들을 출력
            for (int val : arr) {
                System.out.print(val + 1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) { // 아직 선택하지 않은 숫자라면
                visit[i] = true; // 선택했다는 표시
                arr[depth] = i; // 선택한 숫자를 배열에 저장
                dfs(N, M, depth + 1); // 다음 숫자를 선택하러 들어감 (depth를 1 증가시킴)
                visit[i] = false; // 현재 선택한 숫자를 다시 선택하지 않은 상태로 돌림 (다른 경우의 수를 위해)
            }
        }
    }
}
