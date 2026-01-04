import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> m = Map.of(
                "000", "0",
                "001", "1",
                "010", "2",
                "011", "3",
                "100", "4",
                "101", "5",
                "110", "6",
                "111", "7");

        String num = br.readLine();
        if(num.length() % 3 == 1){
            num = "00" + num;
        } else if (num.length() % 3 == 2) {
            num = "0" + num;
        }

        List<String> l = new ArrayList<>();
        for(int i=0; i<num.length(); i+= 3){
            String s = num.substring(i, i + 3);
            l.add(m.get(s));
        }

        System.out.print(String.join("", l));


    }
}
