import java.util.*;

public class FindUnique {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        for(int i = 0;i < n;i++){
            arr.add(in.nextInt());
        }
        HashMap<Integer,Integer> Mp = new HashMap<>();
        for(Integer num : arr){
            Mp.put(num,Mp.getOrDefault(num,0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : Mp.entrySet()){
            if(e.getValue() == 1)
                ans.add(e.getKey());
        }
        System.out.println(ans);
    }
}