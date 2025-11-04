class Solution {
    List<String> result = new ArrayList<>();
    private boolean isValid(String curr) {
        int cnt = 0;
        for (char ch : curr.toCharArray()) {
            if (ch == '(') cnt++;
            else cnt--;
            if (cnt < 0) return false; 
        }
        return cnt == 0;
    }

    private void solve(String curr, int n) {
        if (curr.length() == 2 * n) {
            if (isValid(curr)) {
                result.add(curr);
            }
            return;
        }
        solve(curr + "(", n);
        solve(curr + ")", n);
    }

    public List<String> generateParenthesis(int n) {
        result.clear();
        solve("", n);
        return result;
    }
}
