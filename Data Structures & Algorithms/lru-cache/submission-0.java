class LRUCache {

    public class ListNode {
        public int value;
        public int key;
        public ListNode prev, next;

        public ListNode(final int key, final int val) {
            this.value = val;
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }

    private int maxCapacity;
    private int currCapacity;
    ListNode head, tail;
    Map<Integer, ListNode> cache;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.cache = new HashMap<>();
        this.currCapacity = 0;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)) {
            int value = this.cache.get(key).value;
            this.remove(key);
            this.append(key, value);
            return value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.remove(key);
        }
        else if (this.currCapacity == this.maxCapacity) {
            this.removeHead();
        }
        this.append(key, value);
    }

    private void removeHead() {
        this.cache.remove(this.head.key);
        this.head = head.next;
        this.currCapacity--;
    }

    private void remove(final int key) {
        ListNode nodeToRemove = this.cache.get(key);
        ListNode prev = nodeToRemove.prev;
        ListNode next = nodeToRemove.next;

        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = prev;
        }

        if (nodeToRemove == this.head) {
            this.head = next;
        }

        if (nodeToRemove == this.tail) {
            this.tail = prev;
        }

        this.cache.remove(key);

        this.currCapacity--;
    }

    private void append(final int key, final int value) {
        ListNode newNode = new ListNode(key, value);
        newNode.prev = tail;
        newNode.next = null;
        if (this.tail != null) {
            this.tail.next = newNode;
        }
        this.tail = newNode;

        if (this.head == null) {
            this.head = newNode;
        }

        this.cache.put(key, newNode);
        this.currCapacity++;
    }
}
