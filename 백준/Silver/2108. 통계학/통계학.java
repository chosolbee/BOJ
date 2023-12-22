import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] check = new int[8001];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int median = 10000;
        int mode = 10000;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            check[arr[i] + 4000]++; // 해당 정수의 등장 횟수 증가

            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        Arrays.sort(arr);

        int checkMax = 0;

        // 최빈값을 저장할 ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 8001; i++) {
            // 가장 많이 등장하는 횟수를 구함
            if (check[i] > checkMax) {
                checkMax = check[i];
                // 최빈값을 업데이트
                arrayList.clear();
                arrayList.add(i - 4000);
            } else if (check[i] == checkMax) {
                // 최빈값이 여러 개일 경우를 대비하여 모든 최빈값을 저장
                arrayList.add(i - 4000);
            }
        }

        if (arrayList.size() == 1) { // 최빈값이 하나만 있는 경우
            mode = arrayList.get(0);
        } else {
            Collections.sort(arrayList); // 최빈값이 여러 개 있는 경우 두 번째로 작은 값을 선택
            mode = arrayList.get(1);
        }

        System.out.println((int)Math.round((double)sum / N));    // 산술평균
        System.out.println(arr[N / 2]);                          // 중앙값
        System.out.println(mode);                                // 최빈값
        System.out.println(max - min);                           // 범위
    }

}
