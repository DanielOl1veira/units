package pt.ipp.isep.dei.project.io.ui;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.*;

public class FileInputUtilsTest {

    @Test
    public void validGridMetering() throws IOException, NumberFormatException {
        // Arrange

        FileInputUtils fileInputUtils = new FileInputUtils();

        // Act

        boolean result1 = fileInputUtils.validGridMetering();

        // Assert

        assertTrue(result1);
    }

    @Test
    public void readInvalidFile() {
        assertThrows(IOException.class,
                () -> {
                    Properties props = new Properties();
                    String propFileName = "resources/abcd.efgh";
                    FileInputStream input = new FileInputStream(propFileName);
                    props.load(input);
                });
    }

    @Test
    public void readInvalidNumber() {
        assertThrows(NumberFormatException.class,
                () -> {
                    Properties props = new Properties();
                    String propFileName = "resources/meteringPeriods.properties";
                    FileInputStream input = new FileInputStream(propFileName);
                    props.load(input);
                    String testNumber = props.getProperty("NumberFormatTest");
                    Integer.parseInt(testNumber);
                });
        assertThrows(NumberFormatException.class,
                () -> {
                    Properties props = new Properties();
                    String propFileName = "resources/meteringPeriods.properties";
                    FileInputStream input = new FileInputStream(propFileName);
                    props.load(input);
                    String testNumber = props.getProperty("NullTest");
                    Integer.parseInt(testNumber);
                });
    }

    @Test
    public void validGridMeteringPeriod() {
        int mp1 = 1;
        int mp2 = 60;
        int mp3 = 1440;
        FileInputUtils fileInputUtils = new FileInputUtils();
        //ACT
        boolean result1 = fileInputUtils.gridMeteringPeriodValidation(mp1);
        boolean result2 = fileInputUtils.gridMeteringPeriodValidation(mp2);
        boolean result3 = fileInputUtils.gridMeteringPeriodValidation(mp3);
        //ASSERT
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
    }

    @Test
    public void invalidGridMeteringPeriod() {
        int mp1 = 0;
        int mp2 = 14;
        int mp3 = 1441;
        FileInputUtils fileInputUtils = new FileInputUtils();
        //ACT
        boolean result1 = fileInputUtils.gridMeteringPeriodValidation(mp1);
        boolean result2 = fileInputUtils.gridMeteringPeriodValidation(mp2);
        boolean result3 = fileInputUtils.gridMeteringPeriodValidation(mp3);
        //ASSERT
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    public void validFileGridMeteringPeriod() throws IOException {
        Properties props = new Properties();
        String propFileName = "resources/meteringPeriods.properties";
        FileInputStream input = new FileInputStream(propFileName);
        props.load(input);
        String gridMP = props.getProperty("GridMeteringPeriod");
        FileInputUtils fileInputUtils = new FileInputUtils();
        //ACT
        int fileNumber = Integer.parseInt(gridMP);
        boolean result1 = fileInputUtils.gridMeteringPeriodValidation(fileNumber);
        //ASSERT
        assertTrue(result1);
    }
}