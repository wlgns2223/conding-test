import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for(int i=0; i<N; ++i){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        int[] sortedRopes = Arrays.stream(ropes)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int answer = 0;
        for(int i=0; i< sortedRopes.length; ++i){
            answer = Math.max(answer, sortedRopes[i] * (i + 1));
        }
        System.out.println(answer);

    }
}
