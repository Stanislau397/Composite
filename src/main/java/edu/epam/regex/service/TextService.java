package edu.epam.regex.service;

import java.util.List;

public interface TextService {

    String findSentenceWithLongestWord(String text);
    String deleteSentencesWithWordsLessThanGiven(String text, int amount);
    String countDuplicateWords(String text);
    List<String> sortParagraphsBySentenceNumber(String text);
    int countVowels(String text);
    int countConsonants(String text);
}
