package com.epam.ball.logic;

import com.epam.ball.dao.DataException;
import com.epam.ball.dao.DataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest {

    @Test
    public void testShouldReadStringsWhenFileHasOneString() throws DataException {
        //given
        DataReader reader=new DataReader();
        //when
        List<String> strings=new ArrayList<>();
        strings.add("1.0 2.0 3.0 4.0");
        List<String> result=reader.read("src/test/resources/oneLineTxtFile");
        //then
        Assert.assertEquals(strings, result);
    }

    @Test
    public void testShouldReadStringsWhenFileHasMultipleStrings() throws DataException {
        //given
        DataReader reader=new DataReader();
        //when
        List<String> strings=new ArrayList<>();
        strings.add("1.0 2.0 3.0 4.0");
        strings.add("line");
        strings.add("12345");
        List<String> result=reader.read("src/test/resources/multipleLinesTxtFile");
        //then
        Assert.assertEquals(strings, result);
    }

    @Test(expected = DataException.class)
    public void testShouldThrowDataExceptionWhenFileNotFound() throws DataException {
        //given
        DataReader reader=new DataReader();
        //when
        List<String> result=reader.read("nonExistentFile");
    }
}
