import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Occurance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i < n;i++){
            arr.add(in.nextInt());
        }
        HashMap<Integer,Integer> Mp = new HashMap<>();
        for(Integer num :arr){
            Mp.put(num,Mp.getOrDefault(num,0) + 1);
        }
        for(Map.Entry<Integer,Integer> e :Mp.entrySet()){
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
