package kuromojiWrapper;

import java.util.ArrayList;
import java.util.List;

import com.atilika.kuromoji.jumandic.Token;
import com.atilika.kuromoji.jumandic.Tokenizer;

public class KuromojiWrapper {
    public static final Tokenizer T = new Tokenizer();
    public static final KuromojiWrapper KW = new KuromojiWrapper();

    public List<String> surfaces(final String target) {
        final List<String> list = new ArrayList<String>();
        token(target).forEach(v -> list.add(v.getSurface()));
        return list;
    }

    public List<String> allFeatures(final String target) {
        final List<String> list = new ArrayList<String>();
        token(target).forEach(v -> list.add(v.getAllFeatures()));
        return list;
    }

    public List<Token> token(final String target) {
        return T.tokenize(target);
    }

    public static void main(final String[] args) {
        KW.surfaces("ほげほげ").forEach(v -> System.out.println(v));
        KW.allFeatures("ほげほげ").forEach(v -> System.out.println(v));
    }
}
