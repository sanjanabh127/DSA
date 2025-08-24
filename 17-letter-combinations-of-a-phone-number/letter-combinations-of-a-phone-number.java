class Solution {
    private static final String[] keypad={
        " "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits){
        List<String> result =new ArrayList<>();
        if(digits==null||digits.length()==0){
            return result;
        }
        solve(result,new StringBuilder(),digits,0);
        return result;
    }
    private void solve(List<String> result,StringBuilder temp,String digits,int index){
        if(index==digits.length()){
            result.add(temp.toString());
            return;
        }
         String letters = keypad[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()){
            temp.append(c);
            solve(result,temp,digits,index+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
   
       