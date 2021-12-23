package ru.sc.vsu.berezin_y_a;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleMain {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("How much money do you have? ");
        int countOfMoney = 0;

        countOfMoney = scanner.nextInt();

        Cmd cmd = new Cmd();

        Locale.setDefault(Locale.ROOT);
        cmd.runCmd(countOfMoney);

    }

}
