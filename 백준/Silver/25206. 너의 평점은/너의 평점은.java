import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = new String[20];
        double total = 0;
        double credits = 0;

        for(int i = 0; i < 20; i++){
            str[i] = br.readLine();
            StringTokenizer st = new StringTokenizer(str[i], " ");
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            total += credit * calculateRating(grade);
            if(!grade.equals("P")) credits += credit;
        }
        double avg = total/credits;
        System.out.printf("%.6f\n", avg);

    }
    public static double calculateRating(String grade) {
        if (grade.equals("A+")) return 4.5;
        if (grade.equals("A0")) return 4.0;
        if (grade.equals("B+")) return 3.5;
        if (grade.equals("B0")) return 3.0;
        if (grade.equals("C+")) return 2.5;
        if (grade.equals("C0")) return 2.0;
        if (grade.equals("D+")) return 1.5;
        if (grade.equals("D0")) return 1.0;
        else return 0.0;
    }
}
