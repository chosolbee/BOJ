import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = new String[5];
        for(int i = 0; i < 5; i++){
            words[i] = sc.nextLine();
        }

        StringBuilder result = new StringBuilder();

        int maxLength = 0;
        for(String word : words){
            if(maxLength < word.length()) maxLength = word.length();
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < words[j].length()) {
                    result.append(words[j].charAt(i));
                }
            }
        }

        System.out.println(result);
        sc.close();

    }



}
