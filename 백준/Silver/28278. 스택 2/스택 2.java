import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            if(num == 1){
                int n = Integer.parseInt(st.nextToken());
                stack.push(n);
            } else if (num == 2) {
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else{
                    sb.append(stack.pop()).append("\n");
                }
            } else if (num == 3) {
                sb.append(stack.size()).append("\n");
            } else if (num == 4) {
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (num == 5) {
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else{
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
