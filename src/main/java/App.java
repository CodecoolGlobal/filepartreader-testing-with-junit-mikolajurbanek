import java.io.IOException;

public class App {


    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/example.txt", 1, 4);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
//        fileWordAnalyzer.getWordsOrderedAlphabetically();
//        System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
//        System.out.println(fileWordAnalyzer.getWordsContainingSubstring("jes"));
        System.out.println(filePartReader.read());
    }
}
