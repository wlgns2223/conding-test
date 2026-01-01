import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] str = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = str[0];
        int m = str[1];

        String[] nums = br.readLine().split(" ");
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(String num: nums){
            pq.offer(Long.parseLong(num));
        }

        for(int i=0; i<m; ++i){
            Long first = pq.poll();
            Long second = pq.poll();
            pq.add(first + second);
            pq.add(first + second);
        }

        long sum = 0L;
        for(Long i: pq){
            sum += i;
        }

        System.out.print(sum);


    }
}
