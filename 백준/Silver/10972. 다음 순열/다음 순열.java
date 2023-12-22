import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 수열의 크기 N 입력 받기
        int N = sc.nextInt();
        int[] arr = new int[N];

        // 수열의 원소들 입력 받기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 다음 순열이 존재하면 출력, 없으면 -1 출력
        if (nextPermutation(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }

    public static boolean nextPermutation(int[] a) {
        // 1. a[i - 1] < a[i]를 만족하는 가장 큰 i를 찾는다
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }

        // 만약 이런 i가 없다면, 이는 마지막 순열이다
        if (i <= 0) {
            return false;
        }

        // 2. j >= i 이면서 a[j] > a[i - 1]를 만족하는 가장 큰 j를 찾는다
        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j--;
        }

        // 3. a[i - 1]과 a[j]를 바꾼다
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        // 4. a[i]부터 순열을 뒤집는다
        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
