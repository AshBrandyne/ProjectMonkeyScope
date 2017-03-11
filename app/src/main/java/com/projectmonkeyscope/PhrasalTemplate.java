package com.projectmonkeyscope;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Michael on 2017-01-28.
 */

public class PhrasalTemplate {

    private Random random;
    private ArrayList<String> templates;
    private HashMap<String, ArrayList<String>> tokens;
    private static final String defaultTemplateFile = "testTemplates.txt";
    private Context context;

    public PhrasalTemplate() {
        random = new Random();
        templates = new ArrayList<>();
        tokens = new HashMap<>();
    }

    public PhrasalTemplate(long randomSeed) {
        this();
        random = new Random(randomSeed);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void loadTemplates() {
        loadTemplates(context, PhrasalTemplate.defaultTemplateFile);
    }

    public void loadTemplates(String[] templates) {
        for(int i = 0; i < templates.length; i++) {
            this.templates.add(templates[i]);
        }
    }

    public void loadTemplates(String filename) {
        this.templates.addAll(loadStringsFromFile(filename));
    }

    public void loadTemplates(Context context, String filename) {
        this.templates.addAll(loadStringsFromFile(context, filename));
    }

    public void parseTokensFromTemplates() {
        for(String t : templates) {
            parseTokens(t);
        }
    }

    public String getTestPhrase() {
        String testString = "";

        for(int i = 0; i < 10; i++) {
            testString += random.nextInt(10) + ", ";
        }

        return testString;
    }

    public String getPhrase() {
        String phrase = templates.get(random.nextInt(templates.size()-1));
        phrase = replaceTokensInPhrase(phrase);
        return phrase;
    }

    public int testGetNumTemplates() {
        return templates.size();
    }

    public int testGetNumTokens() {
        return tokens.size();
    }

    public int testGetTokenValues(String key) {
        return tokens.get(key).size();
    }

    public void clearTemplates() {
        templates.clear();
    }

    public void clearTokens() {
        tokens.clear();
    }

    private void parseTokens(String inputString) {
        int nextTokenStart = -1;
        int nextTokenEnd;
        do {
            nextTokenStart = inputString.indexOf('<', nextTokenStart + 1);
            nextTokenEnd = inputString.indexOf('>', nextTokenStart);

            if(nextTokenStart >= 0 && nextTokenEnd > nextTokenStart) {
                String nextToken = inputString.substring(nextTokenStart + 1, nextTokenEnd);
                loadTokenFile(nextToken);
                nextTokenStart = nextTokenEnd;
            }
        } while (nextTokenStart != -1);
    }

    private void loadTokenFile(String token) {
        if(tokens.containsKey(token))
            return;

        ArrayList<String> tokenValues = loadStringsFromFile(context, token.toLowerCase() + ".txt");

        tokens.put(token, tokenValues);
    }

    private ArrayList<String> loadStringsFromFile(String filename) {
        File templateFile = new File(filename);
        Scanner fileScanner;
        ArrayList<String> strings = new ArrayList<>();
        try {
            if (templateFile.exists()) {
                fileScanner = new Scanner(templateFile);

                while(fileScanner.hasNextLine()) {
                    strings.add(fileScanner.nextLine());
                }
            }
        } catch (IOException e) {
            Log.i("PhrasalTemplate", "IOException: Could not read file " + filename);
        }

        return strings;
    }

    private ArrayList<String> loadStringsFromFile(Context context, String filename) {
        AssetManager assetManager = context.getAssets();
        Scanner fileScanner;
        ArrayList<String> strings = new ArrayList<>();
        Log.i("PhrasalTemplate", "Attempting to open file: " + filename);
        try {
            InputStream inputStream = assetManager.open(filename);

            fileScanner = new Scanner(inputStream);

            while(fileScanner.hasNextLine()) {
                String next = fileScanner.nextLine();
                strings.add(next);
            }

        } catch (IOException e) {
            Log.i("PhrasalTemplate", "IOException: Could not read file " + filename);
        }

        return strings;
    }

    private String replaceTokensInPhrase(String inputString) {

        int nextTokenStart = -1;
        int nextTokenEnd;
        do {
            nextTokenStart = inputString.indexOf('<', nextTokenStart + 1);
            nextTokenEnd = inputString.indexOf('>', nextTokenStart);

            if(nextTokenStart >= 0 && nextTokenEnd > nextTokenStart) {
                String nextToken = inputString.substring(nextTokenStart + 1, nextTokenEnd);
                Log.i("PhrasalTemplate", "Next token: " + nextToken);
                if(!tokens.containsKey(nextToken)) {
                    loadTokenFile(nextToken);
                }
                inputString = inputString.replaceFirst(nextToken, getTokenReplacement(nextToken));
            }
        } while (nextTokenStart != -1);

        inputString = inputString.replace("<", "");
        inputString = inputString.replace(">", "");

        return inputString;
    }

    private String getTokenReplacement(String token) {
        ArrayList<String> t = tokens.get(token);
        if (t==null)
            return "";
        return t.get(random.nextInt(t.size()-1));
    }
}
