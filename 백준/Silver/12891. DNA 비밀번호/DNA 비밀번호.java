import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] checkArr = new int[4]; //비밀번호 체크 배열(A,C,G,T)
    public static int myArr[] = new int[4]; //현재 상태 배열
    public static int checkSecret = 0; //A,C,G,T 중 몇개가 요건에 만족하는가

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken()); //문자열 크기
        int P = Integer.parseInt(st.nextToken()); //부분 문자열 크기
        int Result = 0; //정답값
        char A[] = new char[S]; // 전체 문자열

        A = bf.readLine().toCharArray(); // 전체 문자열 입력받아 각 char로 변환
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){ //해당 문자는 더이상 신경쓸 필요 X
                checkSecret++; //해당 문자는 무조건 만족된다는 뜻(0개 이상 필요하므로)
            }
        }

        for(int i = 0; i < P; i++){ //부분 문자열 처음 받을 때 세팅
            Add(A[i]);
        }
        if(checkSecret == 4) Result++;

        // 슬라이딩 윈도우
        for(int i = P; i < S; i++){ // i는 우측 포인터
            // i - j == P가 되어야 하므로
            int j = i - P; // j는 좌측 포인터
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) Result++;
        }
        System.out.println(Result);
        bf.close();
    }

    private static void Add(char c) { //신규로 들어오는 문자열 개수 업데이트
        switch (c){
            case 'A' :
                myArr[0]++; //A에 해당하는 myArr 0번째 index개수 증가
                if(myArr[0] == checkArr[0]) checkSecret++; //checkArr와 동일할 시, checkSecret 증가
                break;
            case 'C' :
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G' :
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T' :
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
    private static void Remove(char c) { //빠지는 문자열 개수 업데이트
        switch (c){
            case 'A' :
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C' :
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G' :
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T' :
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
