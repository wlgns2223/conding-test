import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        char[] goal = br.readLine().toCharArray();
        List<String> firstLadder = new ArrayList<>();
        List<String> secondLadder = new ArrayList<>();
        for(int i=0; i<n; i++){
            String ladder = br.readLine();
            if(ladder.contains("?")){
                firstLadder = secondLadder;
                secondLadder = new ArrayList<>();
                continue;
            }
            secondLadder.add(ladder);
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<k; i++){
            char c = (char)('A' + i);
            builder.append(c);
        }
        char[] people = builder.toString().toCharArray();

        for(String ladder: firstLadder){
            for(int i=0; i<ladder.length(); i++){
                if(ladder.charAt(i) == '-'){
                    char tmp = people[i];
                    people[i] = people[i + 1];
                    people[i + 1] = tmp;

                }
            }
        }

        Collections.reverse(secondLadder);
        for(String ladder: secondLadder){
            for(int i=0; i<ladder.length(); i++){
                if(ladder.charAt(i) == '-'){
                    char tmp = goal[i];
                    goal[i] = goal[i + 1];
                    goal[i + 1] = tmp;
                }
            }
        }

        char[] answer = "*".repeat(k-1).toCharArray();

        for(int i=0; i<k-1; i++){
            if(people[i] == goal[i+1] && people[i+1] == goal[i]){
                answer[i] = '-';
                char tmp = people[i];
                people[i] = people[i+1];
                people[i + 1] = tmp;
            }
        }

        String peopleInStr = new String(people);
        String goalInStr = new String(goal);
        if(!peopleInStr.equals(goalInStr)){
            answer = "x".repeat(k - 1).toCharArray();
        }

        String answerInStr = new String(answer);
        System.out.println(answerInStr);

    }
}
