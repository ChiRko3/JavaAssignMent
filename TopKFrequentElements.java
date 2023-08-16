import javafx.util.Pair;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer n,K;
        n = in.nextInt();
        K = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i < n;i++){
            arr.add(in.nextInt());
        }
//        PriorityQueue<Pair<Integer,Integer>> Pq= new PriorityQueue<Pair<Integer,Integer>>();
        HashMap<Integer,Integer> Mp = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> Pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for(int e : arr){
            Mp.put(e,Mp.getOrDefault(e,0) + 1);
        }
        for(Map.Entry E : Mp.entrySet()){
            Pq.add(new Pair<Integer,Integer>((Integer) E.getValue(), (Integer) E.getKey()));
        }
//        System.out.println(Mp);
//        System.out.println(Pq);
        while(K > 0){
            Pair<Integer,Integer> Top = Pq.poll();
            if(Top == null) break;
            System.out.println(Top.getValue() + " " + Top.getKey());
        }
    }
}
