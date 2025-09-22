class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;

        for (int i = 0; i < n; i++) {
            int a = asteroids[i];
            boolean destroyed = false;


            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                if (st.peek() < -a) {
                    st.pop(); 
                    continue; 
                } else if (st.peek() == -a) {
                    st.pop(); 
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                st.push(a);
            }
        }

       
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}

