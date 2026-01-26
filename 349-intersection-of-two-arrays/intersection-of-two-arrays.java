class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set <Integer> set =new HashSet<>();
        for(int num:nums1){
            if(binarySearch(nums2,num)){
                set.add(num);
            }
        }
        int result[]=new int[set.size()];
        int i=0;
        for(int num:set){
            result[i++]=num;
        }
        return result;
    }
    private boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}