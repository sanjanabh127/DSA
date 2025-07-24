public class Solution {
    public int missingNumber(int[] arr) {
      int n=arr.length;
      int result =n;
      for(int i=0;i<n;i++){
        result=result^i;
        result=result^arr[i];
      }
      return result;
    }
}