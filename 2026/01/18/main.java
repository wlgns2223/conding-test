import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static private final Map<String, Integer> NUM_MAP = Map.ofEntries(
            Map.entry("I", 1), Map.entry("II", 2), Map.entry("III", 3),
            Map.entry("V", 5), Map.entry("X", 10), Map.entry("XX", 20),
            Map.entry("XXX", 30),Map.entry("L", 50), Map.entry("C", 100),
            Map.entry("CC", 200), Map.entry("CCC", 300), Map.entry("D", 500),
            Map.entry("M", 1000),Map.entry("MM", 2000), Map.entry("MMM", 3000),
            Map.entry("IV", 4), Map.entry("IX", 9), Map.entry("XL", 40),
            Map.entry("XC", 90), Map.entry("CD", 400), Map.entry("CM", 900)
    );

    static private int convertToNum(String target){
        int result = 0;
        int i = 0;
        while (i < target.length()){
            int num = 0;
            int j = 0;
            if(NUM_MAP.containsKey(target.substring(i,i+1))){
                num = NUM_MAP.get(target.substring(i, i + 1));
                j = 1;
            }
            if( i < target.length() -1 && NUM_MAP.containsKey(target.substring(i,i+2))){
                num = NUM_MAP.get(target.substring(i, i + 2));
                j = 2;
            }
            if( i < target.length() - 2 && NUM_MAP.containsKey(target.substring(i,i+3))){
                num = NUM_MAP.get(target.substring(i, i + 3));
                j = 3;
            }
            i += j;
            result += num;
        }



        return result;
    }

    static private String convertToStr(int num){
        StringBuilder result = new StringBuilder();
        List<Map.Entry<String, Integer>> list = NUM_MAP.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        while(num != 0){
            for(Map.Entry<String,Integer> m : list){
                if(num - m.getValue() >= 0){
                    num -= m.getValue();
                    result.append(m.getKey());
                    break;
                }
            }
        }

        return result.toString();
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int sum = convertToNum(first) + convertToNum(second);
        String str = convertToStr(sum);
        System.out.println(sum);
        System.out.println(str);


    }
}
