import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileWordAnalyzerTest {


    FilePartReader filePartReaderMock = mock(FilePartReader.class);
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReaderMock);



    @Test
    public void shouldReturnWordsOrderedAlphabetically() throws IOException {
        //Arrange
        when(filePartReaderMock.readLines()).thenReturn("darek buja, ala ma czuja");
        String [] proper = {"ala", "buja", "czuja", "darek", "ma"};
        //Act
        List list = fileWordAnalyzer.getWordsOrderedAlphabetically();
        //Asset
        Assert.assertEquals(list, Arrays.asList(proper));
    }

    @Test
    public void shouldReturnWordsContainingSubstring() throws IOException {
        when(filePartReaderMock.readLines()).thenReturn("przyjaźń, miłość");
        String [] proper = {"przyjaźń"};

        List list = fileWordAnalyzer.getWordsContainingSubstring("ja");

        Assert.assertEquals(list, Arrays.asList(proper));
    }

    @Test
    public void shouldReturnStringsWhichPalindromes() throws IOException {
        when(filePartReaderMock.readLines()).thenReturn("kajak, łódka");
        String [] proper = {"kajak"};

        List list = fileWordAnalyzer.getStringsWhichPalindromes();

        Assert.assertEquals(list, Arrays.asList(proper));
    }
}
