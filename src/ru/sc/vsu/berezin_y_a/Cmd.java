package ru.sc.vsu.berezin_y_a;

import ru.sc.vsu.berezin_y_a.Utils.ListUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Cmd {

    public void runCmd(int countOfMoney) throws IOException {

        TabletSelection tablet = new TabletSelection();
        CmdCommands cmdCommand = CmdCommands.STATIC;
        Scanner scn = new Scanner(System.in);
        List<Tablet> list = new ArrayList<>();

        String command;
        String inputFile;
        String outputFile;

        printHelpPage();
        System.out.println();

        while (cmdCommand != CmdCommands.EXIT) {
            command = scn.next();
            if (Objects.equals(command, "-r")) {
                cmdCommand = CmdCommands.RUN;
            } else if (Objects.equals(command, "-h")) {
                cmdCommand = CmdCommands.HELP;
            } else if (Objects.equals(command, "-e")) {
                cmdCommand = CmdCommands.EXIT;
            } else if (Objects.equals(command, "-i")) {
                cmdCommand = CmdCommands.RUN_IN_CONSOLE_FROM_FILE;
            } else if (Objects.equals(command, "-o")) {
                cmdCommand = CmdCommands.RUN_IN_FILE;
            } else if (Objects.equals(command, "-a")) {
                cmdCommand = CmdCommands.ADD_TABLET;
            } else if (Objects.equals(command, "-c")) {
                cmdCommand = CmdCommands.CLEAR_LIST;
            } else if (Objects.equals(command, "-p")) {
                cmdCommand = CmdCommands.PRINT_LIST;
            } else {
                System.out.println("Error, this command is not found. Try again: ");
            }

            switch (cmdCommand) {
                case EXIT -> System.exit(1);
                case ADD_TABLET -> list.add(createTablet());
                case CLEAR_LIST -> list.clear();
                case PRINT_LIST -> printList(list);
                case RUN -> {
                    System.out.print("Answer: ");
                    printChosenTablet(list, tablet.returnIndex(list, countOfMoney));
                }
                case RUN_IN_CONSOLE_FROM_FILE -> {

                    System.out.print("Enter way to input file: ");
                    inputFile = scn.next();

                    List<List<String>> listStr = ListUtils.loadStringList2FromFile(inputFile);

                    list.clear();
                    assert listStr != null;
                    tablet.fillListFromStrList(listStr, list);

                    System.out.print("Answer: ");
                    printChosenTablet(list, tablet.returnIndex(list, countOfMoney));

                }
                case RUN_IN_FILE -> {

                    System.out.print("Enter way to output file: ");

                    outputFile = scn.next();
                    PrintWriter pw = new PrintWriter(outputFile);

                    pw.println("Answer: ");
                    pw.println(tablet.returnChosenTablet(list,
                            tablet.returnIndex(list, countOfMoney)));
                    pw.close();

                }
                case HELP -> printHelpPage();
            }

        }

    }

    private void printHelpPage() {
        System.out.println("Commands:");
        System.out.println("-r   - run program from console");
        System.out.println("-h   - show help page");
        System.out.println("-e   - exit from program");
        System.out.println("-i   - enter input file and run program");
        System.out.println("-o   - enter output file and run program");
        System.out.println("-a   - add a tablet");
        System.out.println("-c   - clear list");
        System.out.println("-p   - print list in console");
    }

    public void printChosenTablet(List<Tablet> list, int index) {

        Tablet gettingTablet = list.get(index);

        System.out.print(gettingTablet.getName() + " ");
        System.out.print(gettingTablet.getMemory() + " ");
        System.out.print(gettingTablet.getRating() + " ");
        System.out.print(gettingTablet.getPrice());
        System.out.println();

    }

    public void printList(List<Tablet> list) {

        for (int i = 0; i < list.size(); i++) {
            printChosenTablet(list, i);
        }

    }

    public Tablet createTablet() {

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the tablet name: ");
        String name = scn.next();
        System.out.print("Enter the tablet memory size: ");
        int memory = scn.nextInt();
        System.out.print("Enter the tablet rating: ");
        int rating = scn.nextInt();
        System.out.print("Enter the tablet price: ");
        int price = scn.nextInt();

        return new Tablet(name, memory, rating, price);

    }

}
