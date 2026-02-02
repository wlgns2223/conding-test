import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph[i][j] = 0;
            }
        }


        for(int i=0; i<n; i++){
            String[] row = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }

        for(int k=0; k<n; k++){
            for(int a=0; a<n; a++){
                for(int b=0; b<n; b++){
                    if(graph[a][k] != 0 && graph[k][b] != 0){
                        graph[a][b] = 1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }




    }


}
