package Stack;
import java.util.*;
public class nxtGreaterElement {

    public static void main(String[] args) {
      int arr[] = {2,9,3,5,4};
      Stack<Integer> s = new Stack<>();
      int nxtGreater[] = new int[arr.length];

      for(int i = arr.length -1 ; i >= 0 ; i--){
        while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
            s.pop();
        }

        if(s.isEmpty()){
            nxtGreater[i] = -1;
        }
        else{
            nxtGreater[i] = arr[s.peek()];
        }
          s.push(i);
      }
          for(int i = 0 ; i < nxtGreater.length ; i++){
            System.out.print(nxtGreater[i]+" ");
          }
    }
}
