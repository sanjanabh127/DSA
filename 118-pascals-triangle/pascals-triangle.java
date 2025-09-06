

class Solution {
    private List<Integer> generateRow(int row){
        List<Integer> ans = new ArrayList<>();
        int an = 1;
        for(int col = 0; col <= row; col++){
            ans.add(an);
            an = an * (row - col) / (col + 1);
        }
        return ans;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> temp = generateRow(i);
            result.add(temp);
        }
        return result;
    }
}
