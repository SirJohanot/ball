package com.epam.ball.logic;

import com.epam.ball.dao.DataException;
import com.epam.ball.dao.DataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final DataReader reader = new DataReader();

    @Test
    public void testReadShouldReadStringsWhenFileHasOneString() throws DataException {
        //given
        List<String> expectedLines = Arrays.asList("1.0 2.0 3.0 4.0");
        //when
        List<String> actualLines = reader.read("src/test/resources/oneLineTxtFile");
        //then
        Assert.assertEquals(expectedLines, actualLines);
    }

    @Test
    public void testReadShouldReadStringsWhenFileHasMultipleStrings() throws DataException {
        //given
        List<String> expectedLines = Arrays.asList("1.0 2.0 3.0 4.0", "line", "12345");
        //when
        List<String> actualLines = reader.read("src/test/resources/multipleLinesTxtFile");
        //then
        Assert.assertEquals(expectedLines, actualLines);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowDataExceptionWhenFileNotFound() throws DataException {
        //given
        //when
        List<String> result = reader.read("nonExistentFile");
    }
}
