package kuromojiWrapper;

import java.util.LinkedList;
import java.util.Queue;

import junit.framework.Assert;

import org.junit.Test;

import com.atilika.kuromoji.jumandic.Token;

public class KuromojiWrapperTest {
    static KuromojiWrapper KW = new KuromojiWrapper();

    @Test
    public void test_surfaces() {
        final Queue<String> surfacesTrue = new LinkedList<String>() {
            {
                add("ほ");
                add("げ");
                add("ほ");
                add("げ");
            }
        };
        KW.surfaces("ほげほげ").forEach(v -> Assert.assertEquals(v, surfacesTrue.poll()));
    }

    @Test
    public void test_features() {
        final Queue<Token> tokens = new LinkedList<Token>();
        KW.token("ほげほげ").forEach(v -> tokens.add(v));
        KW.allFeatures("ほげほげ").forEach(v -> Assert.assertEquals(v, tokens.poll().getAllFeatures()));
    }
}
