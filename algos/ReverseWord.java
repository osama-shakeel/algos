package com.au.algos;

public class ReverseWord {

    public String reverseSentence(String sentence) {
        String reversedSentence = sentence;

        if (sentence != null && sentence.length() > 1) {
            StringBuilder reversedStringBuilder = new StringBuilder();
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                reversedStringBuilder.append(reverseWord(words[i]));
                if (i+1 < words.length) {
                    reversedStringBuilder.append(" ");
                }
            }
            String reversedString = reversedStringBuilder.toString();
            reversedSentence = reverseWord(reversedString);
        }
        return reversedSentence;
    }

    public String reverseSentence2(String sentence) {
        String reversedSentence = sentence;

        if (sentence != null && sentence.length() > 1) {
            char[] sentenceChars = sentence.toCharArray();

            int i=0, j=0;
            for (; j < sentenceChars.length; j++) {
                if (sentenceChars[j] == ' ') {
                    if (j > i) {
                        reverseChars(sentenceChars, i, j-1);
                        i = j+1;
                    } else {
                        i++;
                    }
                }
            }
            if (j > i) {
                reverseChars(sentenceChars, i, j-1);
            }
            reverseChars(sentenceChars, 0, sentenceChars.length-1);
            reversedSentence = String.valueOf(sentenceChars);
        }
        return reversedSentence;
    }

    public void reverseChars(char[] chars, int begin, int end) {
        for (; begin < end; begin++, end--) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
        }
    }

    public String reverseWord(String word) {
        String reverseWord = word;

        if (word != null && word.length() > 1) {
            char[] letters = word.toCharArray();
            for (int i=0, j=letters.length-1; i < j; i++, j--) {
                char temp = letters[i];
                letters[i] = letters[j];
                letters[j] = temp;
            }
            reverseWord = String.valueOf(letters);
        }
        return reverseWord;
    }

    public static void main(String...args) {
        System.out.println(new ReverseWord().reverseSentence2("OSAMA SHAKEEL"));
    }
}
