package ml.lazybug.basis.tree.trie;

import lombok.Getter;

import java.util.Optional;

public class Trie {
    @Getter
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode('0');
    }

    public void insert(String word, String paraphrase) {
        if (word == null || word.trim().isEmpty()) {
            return;
        }
        final char[] chars = word.toCharArray();
        TrieNode nextNode = root;
        for (char c : chars) {
            final Optional<TrieNode> nodeOpt = nextNode.getChild(c);
            if (nodeOpt.isEmpty()) {
                TrieNode node = new TrieNode(c);
                nextNode.addChild(node);
                nextNode = node;
            } else {
                nextNode = nodeOpt.get();
            }
        }
        nextNode.setWord(true).setParaphrase(paraphrase);
    }

    public String search(String word) {
        final char[] chars = word.toCharArray();
        TrieNode nextNode = root;
        for (char c : chars) {
            final Optional<TrieNode> childOpt = nextNode.getChild(c);
            if (childOpt.isEmpty()) {
                return null;
            }
            nextNode = childOpt.get();
        }
        return nextNode.isWord() ? nextNode.getParaphrase() : null;
    }
}
