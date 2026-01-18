class Twitter {
    Map<Integer,List<int[]>> tweets;
    Map<Integer,Set<Integer>> following;
    int time;
    public Twitter() {
        tweets=new HashMap<>();
        following=new HashMap<>();
        time=0;
    }
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new int[]{time++,tweetId});   
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        if (tweets.containsKey(userId)) {
            for (int[] tweet : tweets.get(userId)) {
                pq.offer(tweet);
                if (pq.size() > 10)
                    pq.poll();
            }
        
        }
          if (following.containsKey(userId)) {
            for (int followee : following.get(userId)) {
                if (tweets.containsKey(followee)) {
                    for (int[] tweet : tweets.get(followee)) {
                        pq.offer(tweet);
                        if (pq.size() > 10)
                            pq.poll();
                    }
                }
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll()[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
            if (following.containsKey(followerId))
            following.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */