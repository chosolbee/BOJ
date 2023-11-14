import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data;

        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            data = br.readLine();

            for(int j = 0; j < data.length(); j++){
                char ch = data.charAt(j);

                if (ch == '('){
                    stack.push(ch);
                }else{ 
                    if(stack.size() == 0){
                        stack.push(ch);
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
            stack.clear();
        }
    }
}
