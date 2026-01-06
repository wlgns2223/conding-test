import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        for(int i=0; i<3;i++){
            lines.add(br.readLine());
        }

        for(String line: lines){
            String prev = line.substring(0, 1);
            String[] rest = line.substring(1).split("");
            int count = 1;
            int answer = 1;

            for(String s: rest){
                if(prev.equals(s)){
                    count += 1;
                } else {
                    count = 1;
                    prev = s;
                }

                answer = Math.max(answer, count);
            }
            System.out.println(answer);

        }

    }
}
