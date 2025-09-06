

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int n = nums.length;
        for (int num : nums) {
            if (ele1 == num) {
                cnt1++;
            } else if (ele2 == num) {
                cnt2++;
            } else if (cnt1 == 0) {
                ele1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                ele2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) cnt1++;
            else if (num == ele2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        int min = n / 3;
        if (cnt1 > min) result.add(ele1);
        if (cnt2 > min) result.add(ele2);

        return result;
    }
}
