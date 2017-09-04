package com.projectmonkeyscope;

/**
 * Created by Michael on 2017-09-04.
 */

public class Grammar {

    /**
     * Fixes grammar issues with a string.
     * @param string The string to fix the grammar of.
     * @return The string with grammar issues fixed.
     */
    public static String fixGrammar(String string) {
        string = fixIndefiniteArticles(string);

        return string;
    }

    /**
     * Fixes indefininite articles such as "a" and "an"
     * @param string The string to fix
     * @return The fixed string.
     */
    private static String fixIndefiniteArticles(String string) {

        //Fix general case, a word beginning with a vowel should use 'an' rather than 'a'
        //ie. 'a apple' to 'an apple'
        string = string.replaceAll("\\b(([Aa]) ([aeiouAEIOU]))", "$2n $3");

        //Fix special cases
        string = string.replaceAll("\\b(([Aa]) (hour|Hour))", "$2n $3");
        string = string.replaceAll("\\b((([Aa])n) (university|University))", "$3 $4");

        return string;
    }
}
