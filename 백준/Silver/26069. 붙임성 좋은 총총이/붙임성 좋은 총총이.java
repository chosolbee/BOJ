import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        String userA, userB;

        HashSet<String> dancer = new HashSet();
        dancer.add("ChongChong");

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            userA = st.nextToken();
            userB = st.nextToken();

            if (dancer.contains(userA) || dancer.contains(userB)) {
                dancer.add(userA);
                dancer.add(userB);
            }
        }
        System.out.println(dancer.size());
    }
}
