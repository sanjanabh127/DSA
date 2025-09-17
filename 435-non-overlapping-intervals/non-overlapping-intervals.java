
import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int cnt = 1; 
        int lastEndingTime = intervals[0][1];
        int n = intervals.length;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastEndingTime) {
                cnt++;
                lastEndingTime = intervals[i][1];
            }
        }

        return n - cnt;  
    }
}
