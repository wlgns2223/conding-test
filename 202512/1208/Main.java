import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] flowers = new int[n][];
        for(int i=0; i< n; i++){
            int[] dates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            flowers[i] = new int[]{dates[0] * 100 + dates[1], dates[2] * 100 + dates[3]};
        }

        Arrays.sort(flowers, Arrays::compare);

        int current = 301;
        int endDate = 1130;
        int count = 0;
        int idx = 0;

        while(current <= endDate){

            int maxEnd = 0;

            while(idx < n && flowers[idx][0] <= current){
                maxEnd = Math.max(maxEnd, flowers[idx][1]);
                idx += 1;
            }

            if(maxEnd == 0){
                count = 0;
                break;
            }

            count += 1;
            current = maxEnd;
        }

        System.out.print(count);

    }
}
