package pl.telephon.book;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManagment {
    private static FileManagment fileManagment = getFileManagment();

    private FileManagment() {
    }

    public static FileManagment getFileManagment() {
        if (fileManagment == null) {
            fileManagment = new FileManagment();
        }
        return fileManagment;
    }

    private void createFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Problem with creation file");
        }
    }

    public void writeLineToFile(File file, List<Contact> list) throws IOException {
        createFile(file);
        final List<String[]> listToFile = new ArrayList<>();
        final FileWriter fileWriter = new FileWriter(file);
        final CSVWriter csvWriter = new CSVWriter(
                fileWriter,
                ';',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END
        );
        for (Contact contact : list) {
            String[] toFile = {
                    contact.getName(),
                    contact.getTelNumber()
            };
            listToFile.add(toFile);
        }
        csvWriter.writeAll(listToFile);
        csvWriter.close();
    }

    public List<Contact> readFromFile(final File file) throws IOException {
        createFile(file);
        final FileReader fileReader = new FileReader(file);
        final CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build();
        return changeStringArrayToContact(csvReader.readAll());
    }

    public List<Contact> changeStringArrayToContact(List<String[]> list) {
        final List<Contact> localList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String allStringArray = Arrays.toString(list.get(i));
            String[] splitedStringArray = allStringArray.split(";");
            String telNummarWithoutSubstring = splitedStringArray[0];
            String nameWithoutSubstring = splitedStringArray[1];
            String contactTelNummer = telNummarWithoutSubstring.substring(1, telNummarWithoutSubstring.length());
            String contactName = nameWithoutSubstring.substring(0, nameWithoutSubstring.length() - 1);
            localList.add(new Contact(contactName, contactTelNummer));
        }
        return localList;
    }

}
