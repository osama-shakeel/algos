package com.au.algos;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<String> getWords(String literatureText, List <String> wordsToExclude) {
        List <String> frequentWords = null;

        if (literatureText != null && literatureText.length() > 0) {
            // Create word count map from the source file's text
            Map<String, Long> textCountMap =
                    Arrays.stream(literatureText.split(" "))
                            .filter(text -> !text.trim().isEmpty() && (wordsToExclude != null && !wordsToExclude.contains(text)))
                            .map(text -> new AbstractMap.SimpleEntry<>(text, 1L))
                            .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.counting()));

            frequentWords =
                    textCountMap.entrySet().stream().filter(entry -> entry.getValue() > 1)
                            .map(entry -> entry.getKey()).collect(Collectors.toList());
        }

        if (frequentWords == null) {
            frequentWords = new ArrayList<>();
        }
        return frequentWords;
    }

    public List <String> reorderLines(int logFileSize, List <String> logLines) {
        List <String> reorderedLines = new ArrayList<>();
        List <String> numberLines = new ArrayList<>();

        if (logLines != null && !logLines.isEmpty()) {
            List <Line> wordLines = new ArrayList<>();
            for(String logline : logLines) {
                Line line = new Line(logline);
                if (line.isNumberLine) {
                    numberLines.add(line.original);
                } else {
                    wordLines.add(line);
                }
            }
            Collections.sort(wordLines);
            wordLines.forEach(wordLine -> reorderedLines.add(wordLine.original));
            numberLines.forEach(numberLine -> reorderedLines.add(numberLine));
        }
        return reorderedLines;
    }

    private class Line implements Comparable <Line> {
        String identifier;
        String wordLine;
        String original;
        boolean isNumberLine;

        public Line(String original) {
            this.original = original;
            int spaceIndex = original.indexOf(' ');
            identifier = original.substring(0, spaceIndex);
            wordLine = original.substring(spaceIndex+1);
            try {
                Integer.parseInt(original.substring(spaceIndex+1, spaceIndex+2));
                isNumberLine = true;
            } catch (Exception ex) {

            }
        }

        @Override
        public int compareTo(Line wL) {
            int compareVal = wordLine.compareTo(wL.wordLine);
            if (compareVal == 0) {
                compareVal = identifier.compareTo(wL.identifier);
            }
            return compareVal;
        }
    }
    public static void main(String[] args) {
        List <String> list =
                new Solution().reorderLines(5,
                        Arrays.asList(
//                                "a1 9 2 4 1",
                                "g1 act zoo",
//                                "zo4 4 7",
//                                "ab1 off key dog",
                                "a8 act zoo"));
//                new Solution()
//                        .getWords("Jack and jill went to the market to buy cheese cheese is jack favourite food",
//                                Arrays.asList("and", "he", "is", "the", "to"));
        list.forEach(word -> System.out.println(word + " "));
    }
}
//replaceAll("[^A-Za-z0-9\\s]", " ").