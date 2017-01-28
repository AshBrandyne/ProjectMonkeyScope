package com.projectmonkeyscope;

import java.util.Random;

/**
 * Created by Michael on 2017-01-28.
 */

public class PhrasalTemplate {

    private Random random;
    private String[] templates;

    public PhrasalTemplate() {
        random = new Random();
    }

    public PhrasalTemplate(long randomSeed) {
        random = new Random(randomSeed);
    }

    public void loadTemplates(String[] templates) {
        this.templates = templates;
    }

    public void loadTemplates(String filename) {

    }

    public String getTestPhrase() {
        String testString = "";

        for(int i = 0; i < 10; i++) {
            testString += random.nextInt(10) + ", ";
        }

        return testString;
    }
}
