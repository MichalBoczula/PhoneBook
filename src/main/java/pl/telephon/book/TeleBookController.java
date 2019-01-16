package pl.telephon.book;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TeleBookController {
    private TeleBook teleBook = new TeleBook();

    public void controlLoop(Scanner scanner) {
        boolean isOver = true;
        do {
            printOptions();
            ControlOptions controlOptions;
            try {
                controlOptions = ControlOptions.converToControlOption(chooseOption(scanner));
            } catch (InputMismatchException i) {
                System.out.println("input number from 1 to 5 NOT char or String");
                controlOptions = ControlOptions.converToControlOption(chooseOption(
                        new Scanner(System.in)
                ));
            }
            try {
                switch (controlOptions) {
                    case AddContact:
                        printDescription(controlOptions);
                        System.out.println(teleBook.addContact(new Contact(inputNameOrTelNummer(scanner), inputNameOrTelNummer(scanner))));
                        break;
                    case RemoveContact:
                        printDescription(controlOptions);
                        System.out.println(teleBook.removeContect(teleBook.findByNameOrTelNummer(inputNameOrTelNummer(scanner))));
                        break;
                    case FindContact:
                        printDescription(controlOptions);
                        System.out.println(teleBook.findByNameOrTelNummer(inputNameOrTelNummer(scanner)));
                        break;
                    case GetAllContacts:
                        printDescription(controlOptions);
                        if (teleBook.getContacts().size() < 1) {
                            System.out.println("There is NO contact, Library is empty");
                        } else {
                            teleBook.getContacts().forEach(System.out::println);
                        }
                        break;
                    case Exit:
                        printDescription(controlOptions);
                        teleBook.writeContactsToFile();
                        isOver = false;
                        break;
                    default:
                        break;
                }
            } catch (NullPointerException n) {
                System.out.println("input number from 1 to 5");
            } catch (IOException e) {
                System.out.println("Problem with saving data in file");
            }
        } while (isOver);
    }

    private int chooseOption(Scanner scanner) {
        return scanner.nextInt();
    }

    private String inputNameOrTelNummer(Scanner scanner) {
        return scanner.next();
    }

    private void printDescription(ControlOptions options) {
        System.out.println(options.getDescription());
    }

    private void printOptions() {
        System.out.println(Arrays.toString(ControlOptions.values()));
    }
}


