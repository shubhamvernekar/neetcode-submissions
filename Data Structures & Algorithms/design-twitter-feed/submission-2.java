class Tweet {
    int id;
    int timestamp;
    Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}

class Node {
    int userId, idx;
    Tweet tweet = null;

    Node(int userId, int idx, Tweet tweet) {
        this.userId = userId;
        this.idx = idx;
        this.tweet = tweet;
    }
}

class Twitter {
    HashMap<Integer, ArrayList<Tweet>> tweets;
    HashMap<Integer, Set<Integer>> followers;
    int timestamp = 0;

    public Twitter() {
        tweets = new HashMap<Integer, ArrayList<Tweet>>();
        followers = new HashMap<Integer, Set<Integer>>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<Tweet>());
        }
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Node> queue = new PriorityQueue<Node>((a, b) -> Integer.compare(b.tweet.timestamp, a.tweet.timestamp));

        // User's own tweet
        if(tweets.containsKey(userId)) {
            int idx = tweets.get(userId).size()-1;
            queue.offer(new Node(userId, idx, tweets.get(userId).get(idx)));
        }

        if(followers.containsKey(userId)) {
            for(int follower : followers.get(userId)) {
                if(!tweets.containsKey(follower)) continue;
                int idx = tweets.get(follower).size()-1;
                queue.offer(new Node(follower, idx, tweets.get(follower).get(idx)));
            }
        }

        while(!queue.isEmpty() && result.size() < 10) {
            Node node = queue.poll();
            result.add(node.tweet.id);

            if(node.idx > 0) {
                queue.offer(new Node(node.userId, node.idx-1, tweets.get(node.userId).get(node.idx-1)));
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<Integer>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId))
        return;
        followers.get(followerId).remove(followeeId);
    }
}
