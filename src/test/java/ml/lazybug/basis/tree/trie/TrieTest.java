package ml.lazybug.basis.tree.trie;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TrieTest {
    @Test
    public void test() {
        String[] words = new String[]{"hello", "world", "java", "trie", "basis", "math", "mathematics", "job"};
        Trie trie = new Trie();
        Arrays.stream(words).forEach(w -> trie.insert(w, w));

        assertEquals("hello", trie.search("hello"));
        assertNull(trie.search("hell"));
        assertNull(trie.search("go"));
        assertNull(trie.search("jobs"));
        assertEquals("math", trie.search("math"));
        assertEquals("mathematics", trie.search("mathematics"));
    }
}
