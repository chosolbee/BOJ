import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++){
            height[i] = sc.nextInt();
            sum += height[i]; // 모든 난쟁이의 키 합계
        }

        Arrays.sort(height);

        for(int i = 0; i < 9; i++){ // BruteForce
            for(int j = i+1; j < 9; j++){
                if(sum - height[i] - height[j] == 100){ // 두 명의 키를 빼서 100이면 성공
                    for(int k = 0; k < 9; k++){
                        if(k == i || k == j)
                            continue;
                        System.out.println(height[k]); // 그 i, j빼고 모두 출력
                    }
                    return;
                }
            }
        }
    }
}
