package edu.epam.regex.service.impl;
import edu.epam.regex.service.TextService;

import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class TextServiceImpl implements TextService {

    private static final String SENTENCE_REGEX = "(?<=[.!?])\\s";
    private static final String PARAGRAPH_REGEX = "(?m)(?=^\\s{4})";
    private static final String WORD_REGEX = "\\W+";
    private static final Pattern VOWEL_PATTERN = Pattern.compile("[AaEeIiYyUuOo]");

    @Override
    public String countDuplicateWords(String text) {
        String[] words = text.split(WORD_REGEX);
        Map<String, Integer> wordsCount = new HashMap<>();
        String nextLine = "\n";
        String equally = " = ";

        for (String word : words) {
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word.toLowerCase(), wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }
        Set<String> wordsInText = wordsCount.keySet();
        String duplicates = "";
        for (String word : wordsInText) {
            if (wordsCount.get(word) > 1) {
                duplicates = duplicates + word + equally + wordsCount.get(word) + nextLine;
            }
        }
        return duplicates;
    }

    @Override
    public List<String> sortParagraphsBySentenceNumber(String text) {
        String[] paragraphs = text.split(PARAGRAPH_REGEX);
        List<String> sortedParagraphs = new ArrayList<>();
        for (String paragraph : paragraphs) {
            String amount = "";
            String[] sentences = paragraph.split(SENTENCE_REGEX);
            for (String sentence : sentences) {
                amount = amount + sentence;
            }
            sortedParagraphs.add(amount);
        }
        Collections.sort(sortedParagraphs);
        return sortedParagraphs;
    }

    @Override
    public int countVowels(String text) {
        int vowelsAmount = 0;
        String empty = "";
        for (int i = 0; i < text.length(); i++) {
            String result = empty + text.charAt(i);
            if (VOWEL_PATTERN.matcher(result).matches()) {
                vowelsAmount = vowelsAmount + 1;
            }
        }
        return vowelsAmount;
    }

    @Override
    public int countConsonants(String text) {
        int consonantsAmount = 0;
        String empty = "";
        for (int i = 0; i < text.length(); i++) {
            String result = empty + text.charAt(i);
            if (!(VOWEL_PATTERN.matcher(result).matches()) && !result.equals(empty)) {
                consonantsAmount = consonantsAmount + 1;
            }
        }
        return consonantsAmount;
    }

    @Override
    public String findSentenceWithLongestWord(String text) {
        String[] sentences = text.split(SENTENCE_REGEX);
        List<String> words = new ArrayList<>();

        for (String sentence : sentences) {
            String[] word = sentence.split(WORD_REGEX);
            for (String result : word) {
                words.add(result);
            }
        }
        String maxWord = "";
        for (String word : words) {
            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
        }
        String sentenceWithLongestWord = "";
        for (String sentence : sentences) {
            if (sentence.contains(maxWord)) {
                sentenceWithLongestWord = sentence;
            }
        }
        return sentenceWithLongestWord;
    }

    @Override
    public String deleteSentencesWithWordsLessThanGiven(String text, int amount) {
        String[] sentences = text.split(SENTENCE_REGEX);
        String deletedSentence = "";
        String space = " ";
        for (String sentence : sentences) {
           String[] words = sentence.split(WORD_REGEX);
            if (words.length < amount) {
                deletedSentence = deletedSentence + sentence + space;
            }
        }
        return deletedSentence.trim();
    }
}


