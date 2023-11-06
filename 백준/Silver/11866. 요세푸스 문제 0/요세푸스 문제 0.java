import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> list = new LinkedList<>();

        for(int i = 1; i <= N; i++)
            list.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int index=0;
        while(list.size()>1){
            index=(index+(K-1))%list.size();
            sb.append(list.remove(index)).append(", ");
        }

        sb.append(list.remove(0)).append('>');
        System.out.println(sb);
    }
}
