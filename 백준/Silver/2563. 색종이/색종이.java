import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //색종이의 수
        int[][] white = new int[100][100]; //흰 도화지
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = x; j < x + 10; j++) { //색종이의 가로 크기 : 10
                for (int k = y; k < y + 10; k++) { //색종이의 세로 크기 : 10
                    white[j][k] = 1; //색종이에 해당하는 영역을 1로 set
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                sum += white[i][j]; //1로 set된 영역만 합해줌
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
