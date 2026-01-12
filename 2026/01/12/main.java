import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int i = 0;
        int count = 0;

        while(i<m-2){
            if(str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I'){
                int pattern = 0;

                while( i < m -2 && str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I'){

                    pattern += 1;

                    if(pattern >= n){
                        count += 1;
                    }

                    i += 2;
                }
            } else {
                i += 1;
            }
        }

        System.out.println(count);

    }
}
