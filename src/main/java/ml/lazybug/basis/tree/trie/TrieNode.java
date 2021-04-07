package ml.lazybug.basis.tree.trie;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.*;

@Data
@Accessors(chain = true)
public class TrieNode {
    private final char c;
    private TrieNode parent;
    private Map<Character, TrieNode> childrenMap;
    private String paraphrase;
    private boolean word;

    public TrieNode(char c) {
        this.c = c;
        this.childrenMap = new HashMap<>();
    }

    public boolean hasChildren() {
        return this.childrenMap.size() > 0;
    }

    public Optional<TrieNode> getChild(char c) {
        return Optional.ofNullable(this.childrenMap.get(c));
    }

    public void addChild(TrieNode child) {
        this.childrenMap.put(child.getC(), child);
    }
}
