import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        Map<Character, Integer> s1Count = new HashMap<>();
        for (char c : s1) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> s2Count = new HashMap<>();
        for(char c: s2){
            s2Count.put(c, s2Count.getOrDefault(c, 0) + 1);
        }

        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int count = 0;
        for(char c: alphabets){

            if(s1Count.containsKey(c) && s2Count.containsKey(c)){
                count += Math.abs(s1Count.get(c) - s2Count.get(c));
            } else if(s1Count.containsKey(c) && !s2Count.containsKey(c)){
                count += s1Count.get(c);
            } else if(!s1Count.containsKey(c) && s2Count.containsKey(c) ){
                count += s2Count.get(c);
            }
        }

        System.out.print(count);


    }
}
