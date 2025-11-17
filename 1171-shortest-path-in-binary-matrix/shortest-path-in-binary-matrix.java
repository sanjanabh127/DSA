class Solution {
    static class Tuple {
        int r, c, d;
        Tuple(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        if (n == 1) return 1;
        Queue<Tuple> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        q.add(new Tuple(0, 0, 1)); // distance = 1
        vis[0][0] = true;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {
            Tuple t = q.poll();

            for (int k = 0; k < 8; k++) {
                int nr = t.r + dr[k];
                int nc = t.c + dc[k];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n &&
                    !vis[nr][nc] && grid[nr][nc] == 0) {

                    if (nr == n - 1 && nc == n - 1) {
                        return t.d + 1; 
                    }

                    vis[nr][nc] = true;
                    q.add(new Tuple(nr, nc, t.d + 1));
                }
            }
        }

        return -1;
    }
}
