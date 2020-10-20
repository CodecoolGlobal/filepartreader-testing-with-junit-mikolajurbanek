import java.io.IOException;
import java.util.*;

public class FileWordAnalyzer {


    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically() throws IOException {
        String content = filePartReader.readLines().replace(",", "");
        String[] words = content.split(" ");
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word.toLowerCase());
        }

        Collections.sort(list);

        for (String word: list) {
            System.out.println(word);
        }

            return list;
        }

        public List getWordsContainingSubstring (String subString) throws IOException {
            String content = filePartReader.readLines().replace(",", "");
            String[] words = content.split(" ");
            List<String> subStringWords = new ArrayList<>();
            for (String word : words) {
                if (word.contains(subString)) {
                    subStringWords.add(word);
                }
            }
            return subStringWords;
        }

        public List getStringsWhichPalindromes() throws IOException {
            String content = filePartReader.readLines().replace(",", "");
            String[] words = content.split(" ");
            List<String> palindromeWords = new ArrayList<>();
            for (String word : words) {
                StringBuilder sb = new StringBuilder(word);
                if (sb.reverse().toString().toLowerCase().equals(word.toLowerCase())) {
                    System.out.println(word);
                    palindromeWords.add(word);
                }
            }
            return palindromeWords;
        }


    }
