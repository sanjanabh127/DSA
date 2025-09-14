class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] words=new boolean[s.length()];
        for(int i=0;i<words.length;i++){
            for(int y=0;y<=i;y++){
                if(y==0||words[y-1]){
                    if(wordDict.contains(s.substring(y,i+1))){
                        words[i]= true;
                        break;
                    }
                }
            }
        }
        return words[words.length-1];
    }
}