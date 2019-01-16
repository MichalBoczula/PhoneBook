package pl.telephon.book;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TeleBookController teleBookController = new TeleBookController();
        teleBookController.controlLoop(new Scanner(System.in));
    }
}
