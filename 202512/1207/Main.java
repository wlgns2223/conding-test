import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        final int LIMIT = 101;

        String line = br.readLine();
        int[] a = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        line = br.readLine();

        int[] inputB = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();


        int[] b = new int[LIMIT];
        Arrays.sort(a);

        for(int k: inputB){
            b[k]++;
        }

        int i = 0;
        int sum = 0;
        for(int k = LIMIT - 1; k >= 0; --k){
            while(b[k] > 0){
                sum = sum + (a[i] * k);
                b[k] -= 1;
                i += 1;
            }
        }

        System.out.println(sum);


    }
}
