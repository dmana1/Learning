/*
 * This class contains the collection of stopwords
 */
package com.info.search;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class StopWords {

    public static ArrayList<String> STOP_WORDS;

    public StopWords() {
        STOP_WORDS = new ArrayList<String>();
        populateStopWords();
    }

    public  boolean isStopWord(String word) {

        return STOP_WORDS.contains(word);
    }

    public static void populateStopWords() {
        STOP_WORDS.add("a");
        STOP_WORDS.add("an");
        STOP_WORDS.add("and");
        STOP_WORDS.add("are");
        STOP_WORDS.add("as");
        STOP_WORDS.add("at");
        STOP_WORDS.add("be");
        STOP_WORDS.add("but");
        STOP_WORDS.add("by");
        STOP_WORDS.add("for");
        STOP_WORDS.add("if");
        STOP_WORDS.add("in");
        STOP_WORDS.add("into");
        STOP_WORDS.add("is");
        STOP_WORDS.add("it");
        STOP_WORDS.add("no");
        STOP_WORDS.add("not");
        STOP_WORDS.add("of");
        STOP_WORDS.add("on");
        STOP_WORDS.add("or");
        STOP_WORDS.add("such");
        STOP_WORDS.add("that");
        STOP_WORDS.add("the");
        STOP_WORDS.add("their");
        STOP_WORDS.add("then");
        STOP_WORDS.add("there");
        STOP_WORDS.add("these");
        STOP_WORDS.add("they");
        STOP_WORDS.add("this");
        STOP_WORDS.add("to");
        STOP_WORDS.add("was");
        STOP_WORDS.add("will");
        STOP_WORDS.add("with");

    }
}
