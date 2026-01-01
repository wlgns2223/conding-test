import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] courses = new int[n][];
        for(int i=0; i<n; i++){
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            courses[i] = temp;
        }

        Arrays.sort(courses, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(courses[0]);
        for(int i=1; i< courses.length; ++i){
            int[] latestCourse = pq.poll();
            assert latestCourse != null;

            if(courses[i][0] < latestCourse[1]){
                pq.add(latestCourse);
            }
            pq.add(courses[i]);
        }

        System.out.print(pq.size());
    }
}
