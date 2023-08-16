import java.util.ArrayList;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        Integer n = in.nextInt();
        for(int i = 0;i < n;i++){
            arr.add(in.nextInt());
        }
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(arr.get(i) > arr.get(j)){
                    int temp = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,temp);
                }
            }
        }
        System.out.println(arr);
    }
}
