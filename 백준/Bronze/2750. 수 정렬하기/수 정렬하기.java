import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        for(int i = 0; i < N - 1; i++){ // loop 개수
            // 이미 돈 루프 개수만큼은 정렬이 완료되었으므로 i를 빼준만큼 돌아도 무관
            for(int j = 0; j < N - 1 - i; j++){ // 정렬하는 범위 (아직 정렬되지 않은 배열 영역)
                if(A[j] > A[j + 1]){
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        for (int i : A) {
            System.out.println(i);
        }
    }
}
