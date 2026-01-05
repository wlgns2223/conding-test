import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int count = 0;
        for(char c : str){
            int ret = 0;
            if(c < 'a'){
                ret += 26;
                ret += c - 'A' + 1;
            } else {
                ret += (c - 'a' + 1);
            }
            count += ret;
        }

        if(isPrime(count)){
            System.out.print("It is a prime word.");
        } else {
            System.out.print("It is not a prime word.");
        }



    }

    static boolean isPrime(int num){
        if(num == 1){
            return true;
        }

        for(int i=2; i<= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
