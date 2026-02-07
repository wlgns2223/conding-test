import java.io.*;
import java.util.*;

public class Main {

    private static final int ALPHA_NUM = 52;

    private static class Pair{
        private final Integer first;

        private final Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[ALPHA_NUM][ALPHA_NUM];

        List<Pair> answer = new ArrayList<>();
        for(int i =0; i<n; i++){
            String[] s = br.readLine().split(" ");
            int a = convertToNum(s[0]);
            int b = convertToNum(s[2]);
            graph[a][b] = 1;
            answer.add(new Pair(a, b));
        }

        for(int k=0; k<ALPHA_NUM; k++){
            for(int a=0; a<ALPHA_NUM; a++){
                for(int b=0; b<ALPHA_NUM; b++){
                    if(graph[a][k] == 1 && graph[k][b] == 1 && graph[a][b] == 0){
                        graph[a][b] = 1;
                        answer.add(new Pair(a, b));
                    }
                }
            }
        }

        TreeSet<Pair> treeSet = new TreeSet<>(Comparator.comparingInt(Pair::getFirst).thenComparingInt(Pair::getSecond));
        treeSet.addAll(answer);
        int num = 0;
        for(Pair p : treeSet){
            if(p.getFirst().equals(p.getSecond())){
                continue;
            }
            num++;
        }

        System.out.println(num);
        for(Pair p: treeSet){
            if(p.getFirst().compareTo(p.getSecond()) == 0){
                continue;
            }
            System.out.println(convertToStr(p.getFirst()) + " => " + convertToStr(p.getSecond()));

        }



    }

    private static int convertToNum(String s){
        if(s.charAt(0) <= 'Z'){
            return s.charAt(0) - 'A';
        } else {
            return s.charAt(0) - 'a' + 26;
        }
    }

    private static String convertToStr(int num){
        if(num < 26){
            char c = (char) (num + 'A');
            return String.valueOf(c);
        } else {
            num -= 26;
            char c = (char) (num + 'a');
            return String.valueOf(c);
        }
    }
}
