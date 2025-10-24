class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) {
            return "1";
        }
        String say = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < say.length()) {
            char ch = say.charAt(i);
            int count = 0;
            while (i < say.length() && say.charAt(i) == ch) {
                count++;
                i++;
            }

            result.append(count).append(ch);
        }

        return result.toString();
    }
}
