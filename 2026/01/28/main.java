import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int i = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){

            String str = br.readLine();

            if(str == null){
                System.out.println(i +"." + " 0");
                continue;
            }

            int answer = 0;
            if(str.contains("-")){
                break;
            }

            Stack<String> stack = new Stack<>();
            for(String s : str.split("")){
                if(s.equals("{")){
                    stack.push(s);
                } else if (s.equals("}")) {
                    if(stack.isEmpty()){
                        answer += 1;
                        stack.push("{");
                    } else {
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty()){
                answer += (stack.size() / 2);
            }

            System.out.println(i +"." + " " +answer);
            i += 1;

        }
        br.close();
    }
}
