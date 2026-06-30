class Node {
    int key, value;
    Node prev, next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        this.remove(node);
        this.insertToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            this.remove(map.get(key));
        } else if(map.size() == this.capacity) {
            Node lru = tail.prev;
            this.remove(lru);
            map.remove(lru.key);
        }
        Node node = new Node(key, value);
        this.insertToFront(node);
        map.put(key, node);
    }
}
