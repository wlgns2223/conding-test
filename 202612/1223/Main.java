import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String[] deviceStrs = br.readLine().split(" ");
        List<Integer> devices = new ArrayList<>();
        for (String s : deviceStrs) {
            devices.add(Integer.parseInt(s));
        }
        Set<Integer> multitaps = new HashSet<>();

        int count = 0;
        for(int i=0; i<k; i++){
            if(multitaps.size() < n){
                multitaps.add(devices.get(i));
                continue;
            }

            if(multitaps.contains(devices.get(i))){
                continue;
            }


            Integer deviceToRemove = null;
            int idx = -1;
            for(Integer plugged: multitaps){
                List<Integer> subList = devices.subList(i+1, devices.size());

                if(!subList.contains(plugged)){
                    deviceToRemove = plugged;
                    break;
                }

                idx = Math.max(idx, subList.indexOf(plugged));
                deviceToRemove = subList.get(idx);
            }
            multitaps.remove(deviceToRemove);
            multitaps.add(devices.get(i));
            count++;
        }
        System.out.print(count);
    }
}
