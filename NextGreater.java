import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.*;
public class NextGreater{
    private static class Pair{
        int first,second;
        Pair(int f,int s){
            first = f;
            second = s;
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        Stack<Pair> st =  new Stack<>();
        ArrayList<Integer> nextGreaterElement = new ArrayList<>(Collections.nCopies(n,-1));
        for(int i = 0; i < n; i++){
            while(!st.empty() && st.peek().first < arr.get(i)){
                nextGreaterElement.set(st.peek().second,arr.get(i));
                st.pop();
            }
            st.push(new Pair(arr.get(i),i));
        }
        System.out.println(nextGreaterElement);
    }
}