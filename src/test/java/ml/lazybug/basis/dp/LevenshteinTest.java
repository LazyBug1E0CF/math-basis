package ml.lazybug.basis.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevenshteinTest {
    @Test
    public void editDistance() {
        String s1 = "hello", s2 = "helo";
        assertEquals(1, Levenshtein.editDistance(s1, s2));
        s1 = "halo";
        s2 = "hell";
        assertEquals(2, Levenshtein.editDistance(s1, s2));
        s1 = "hell";
        s2 = "hello";
        assertEquals(1, Levenshtein.editDistance(s1, s2));
        s2 = null;
        assertEquals(4, Levenshtein.editDistance(s1, s2));
        s1 = null;
        assertEquals(0, Levenshtein.editDistance(s1, s2));
    }
}
