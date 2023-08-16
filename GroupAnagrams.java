import java.util.*;

public class GroupAnagrams {
    static String GetSorted(String str){
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    static boolean isAnagram(String a,String b){
        char[] s1 = a.toCharArray();
        Arrays.sort(s1);
        char[] s2 = b.toCharArray();
        Arrays.sort(s2);
        return (new String(s1).equals(new String(s2)));
    }
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> Mp = new HashMap<>();
        Scanner in = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        Integer n = in.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(in.next());
        }
        for(int i = 0;i < n;i++){
            String a = GetSorted(arr.get(i));
            if(Mp.containsKey(a)) continue;
            ArrayList<String> temp = new ArrayList<>();
            for(int j = i + 1;j < n;j++){
                String b = GetSorted(arr.get(j));
                if(isAnagram(a,b))
                    temp.add(arr.get(j));
            }
            temp.add(arr.get(i));
            Mp.put(a,temp);
        }
        for(Map.Entry E : Mp.entrySet()){
            System.out.println(E.getValue());
        }
    }
}
