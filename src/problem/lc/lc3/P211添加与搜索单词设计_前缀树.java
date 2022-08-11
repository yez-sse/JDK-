package problem.lc.lc3;

import problem.struct.TrieNode;

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (node.next[u] == null) {
                node.next[u] = new TrieNode();
            }
            node = node.next[u];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    boolean dfs(String word, TrieNode node, int depth) {
        if (depth == word.length()) {
            return node.isEnd;
        }
        if (word.charAt(depth) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.next[i] != null && dfs(word, node.next[i], depth + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.next[word.charAt(depth) - 'a'] == null) {
                return false;
            }
            return dfs(word, node.next[word.charAt(depth) - 'a'], depth + 1);
        }
    }
}
