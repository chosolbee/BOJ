import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nm = br.readLine();
        StringTokenizer st = new StringTokenizer(nm);
        int n = Integer.parseInt(st.nextToken()); //카드 개수
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = blackJack(arr, n, m);
        System.out.println(result);
    }

    private static int blackJack(int[] arr, int n, int m) {
        int result = 0;
        for (int i =0; i < n-2; i++) {
            for(int j = i+1; j<n-1; j++) {
                for(int k = j+1; k<n;k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(m == sum) {
                        return sum;
                    }
                    if((result < sum) && (sum < m)) {
                        result =sum;
                    }
                }
            }
        }
        return result;
    }
}
