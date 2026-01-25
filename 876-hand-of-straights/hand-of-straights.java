class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0)return false;
        TreeMap<Integer,Integer> freq=new TreeMap<>();
        for(int card:hand){
            freq.put(card,freq.getOrDefault(card,0)+1);
        }
        while(!freq.isEmpty()){
            int start=freq.firstKey();
            int count=freq.get(start);
            for(int i=0;i<groupSize;i++){
                int card=start+i;
                if(!freq.containsKey(card)||freq.get(card)<count)return false;
                if(freq.get(card)==count) freq.remove(card);
                else freq.put(card,freq.get(card)-count);
            }
        }
        return true;
    }
}