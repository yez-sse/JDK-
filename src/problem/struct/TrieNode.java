package problem.struct;

public class TrieNode {
    public boolean isEnd;
    public TrieNode[] next;

    public TrieNode() {
        isEnd = false;
        next = new TrieNode[26];
    }
}
