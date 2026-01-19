class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
    Node get(char c) {
        return links[c - 'a'];
    }
    void endSet() {
        flag = true;
    }
    boolean isEnd() {
        return flag;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.endSet();
    }

    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();   
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}
