import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.*;

public class FilePartReaderTest {

    FilePartReader filePartReader = new FilePartReader();


    @Test
    public void shouldReadFile() throws IOException {
        filePartReader.setup("src/test/resources/TestText.txt", 1, 1);

        String expectedString = filePartReader.read();

        Assert.assertEquals(expectedString, "sample txt\nthis is");
    }


    @Test
    public void shouldReadLines() throws IOException {
        filePartReader.setup("src/test/resources/TestText.txt", 1, 1);


        String expected = filePartReader.readLines();

        Assert.assertEquals(expected, "sample txt ");

    }
}
