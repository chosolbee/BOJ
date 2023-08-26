import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [][] arr = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                arr[i][j] = arr[i][j-1] + sc.nextInt();
            }
        }
        StringBuilder st = new StringBuilder();
        int k = sc.nextInt();

        while (k-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int result = 0;
            for (int z = i; z <= x; z++) {
                result += arr[z][y] - arr[z][j - 1];
            }
            st.append(result).append("\n");
        }

        System.out.println(st);
    }
}
