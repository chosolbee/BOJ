import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int len = s.length();
        String[] arr = new String[len];

        for(int i = 0; i < len; ++i) {
            arr[i] = s.substring(i);
        }
        
        Arrays.sort(arr);

        for(int i = 0; i < len; ++i) {
            sb.append(arr[i]).append("\n");
        }
        
        System.out.println(sb);

    }
}
