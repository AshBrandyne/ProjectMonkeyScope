package com.projectmonkeyscope;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Michael on 2017-09-04.
 */

public class GrammarTest {

    @Test
    public void indefiniteArticlesTest() throws Exception {

        //General cases
        assertEquals("A(n) book.", "A book.", Grammar.fixGrammar("A book."));
        assertEquals("Read a(n) book.", "Read a book.", Grammar.fixGrammar("Read a book."));
        assertEquals("A(n) apple.", "An apple.", Grammar.fixGrammar("A apple."));
        assertEquals("Eat a(n) apple.", "Eat an apple.", Grammar.fixGrammar("Eat a apple."));

        //Special cases
        assertEquals("A(n) hour ago.", "An hour ago.", Grammar.fixGrammar("A hour ago."));
        assertEquals("It was a(n) hour ago.", "It was an hour ago.", Grammar.fixGrammar("It was a hour ago."));
        assertEquals("A(n) hourglass.", "An hourglass.", Grammar.fixGrammar("A hourglass."));
        assertEquals("A(n) university.", "A university.", Grammar.fixGrammar("A university."));
        assertEquals("Let's go to a(n) university.", "Let's go to a university.", Grammar.fixGrammar("Let's go to a university."));
    }
}
