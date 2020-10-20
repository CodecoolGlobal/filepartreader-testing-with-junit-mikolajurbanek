import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader() {
        this.filePath = "filePath";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine){

        this.filePath = filePath;

        if(toLine<fromLine){
            throw new IllegalArgumentException("to line number has to be bigger than from line");
        }
        if (fromLine<1){
            throw new IllegalArgumentException("the from line has to be bigger than 1!");
        }

        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        return text;
    }

    public String readLines() throws IOException {
        String wholeFile = read();
        String[] linesStr = wholeFile.split("\n");
        List<String> lines = Arrays.asList(linesStr);
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer i=fromLine; i<=toLine; i++){
            stringBuilder.append(lines.get(i-1));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }




}
