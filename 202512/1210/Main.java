import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc >0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int maxStock = 0;
            long profit = 0L;
            for(int i= arr.length-1; i>=0; --i){
                if(maxStock < arr[i]){
                    maxStock = arr[i];
                } else {
                    profit = profit + (maxStock - arr[i]);
                }
            }

            System.out.println(profit);
            tc --;
        }


    }
}
