package pl.telephon.book;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FileManagmentTestSuite {
    private final PropertiesLoader propertiesLoader = PropertiesLoader.getInstance();

    @Test
    public void getInstance() {
        //given
        //when
        FileManagment fileManagment = FileManagment.getFileManagment();
        //then
        Assert.assertNotNull(fileManagment);
    }

    @Test
    public void writeLineToFile() throws IOException {
        //given
        final File file = new File(propertiesLoader.getProperties().getProperty("test.file.location"));
        final FileManagment fileManagment = FileManagment.getFileManagment();
        final List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("123456788", "Test"));
        //when
        fileManagment.writeLineToFile(file, contacts);
        final List<Contact> data = fileManagment.readFromFile(file);
        //then
        assertTrue(data.size() > 0);
    }

    @Test
    public void readFromFile() throws IOException {
        //given
        final File file = new File(propertiesLoader.getProperties().getProperty("test.file.location"));
        final FileManagment fileManagment = FileManagment.getFileManagment();
        //when
        final List<Contact> data = fileManagment.readFromFile(file);
        //then
        assertTrue(data.size() > 0);
    }
}