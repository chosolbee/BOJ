import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int bitSet = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int num;

            switch(input[0]) {
                case "add": //x를 추가
                    num = Integer.parseInt(input[1]) - 1;
                    bitSet |= (1 << num);
                    break;
                case "remove": //x를 제거
                    num = Integer.parseInt(input[1]) - 1;
                    bitSet = bitSet & ~(1 << num);
                    break;
                case "check": //x의 체크 여부를 확인
                    num = Integer.parseInt(input[1]) - 1;
                    sb.append((bitSet & (1 << num)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle": //x의 연산을 뒤집
                    num = Integer.parseInt(input[1]) - 1;
                    bitSet ^= (1 << num);
                    break;
                case "all": //모든 비트를 체크
                    bitSet = (1 << 20) - 1;
                    break;
                case "empty": //공집합이므로 0으로 값을 변경
                    bitSet = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
