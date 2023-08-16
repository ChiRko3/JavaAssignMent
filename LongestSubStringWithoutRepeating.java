import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubStringWithoutRepeating {
    static ArrayList<String> GetSubStrings(String str){
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0;i < str.length();i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i;j < str.length();j++){
                sb.append(str.charAt(j));
                arr.add(sb.toString());
            }
        }
        return arr;
    }
    static boolean CheckSubString(String str){
        Set<Character> st = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if(st.contains(str.charAt(i))){
                return false;
            }
            st.add(str.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Inp;
        Inp = in.next();
        ArrayList<String> SubStrs = GetSubStrings(Inp);
        Integer Len = 0;
        String ANS = null;
        for(String Str : SubStrs){
            if(CheckSubString(Str)){
                if(ANS == null){
                    ANS = Str;
                }
                if(Str.length() > ANS.length()){
                    Len = Str.length();
                    ANS = Str;
                }
            }
        }
        System.out.println(Len);
        System.out.println(ANS);
    }
}
