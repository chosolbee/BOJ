import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(groupWord(sc.next())) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean groupWord(String word) {
        boolean[] visited = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            if(!visited[word.charAt(i) - 'a']){ 
                visited[word.charAt(i) - 'a'] = true;
            }
            else if(word.charAt(i-1)!=word.charAt(i)){ 
                return false;
            }
        }
        return true;
    }
}
