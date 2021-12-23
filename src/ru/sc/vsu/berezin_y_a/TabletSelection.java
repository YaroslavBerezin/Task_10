package ru.sc.vsu.berezin_y_a;

import java.util.*;

public class TabletSelection {

    public int returnIndex(List<Tablet> list, int countOfMoney) {

        list.sort(Comparator.comparing(Tablet::getMemory));
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() > countOfMoney) {
                list.remove(list.get(i));
            }
        }

        if (list.size() == 0) {
            return -1;
        }

        if ((list.size() == 1) || (list.get(0).getMemory() > list.get(1).getMemory())) {
            return 0;
        } else {
            int countSameMemory = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getMemory() == list.get(i + 1).getMemory()) {
                    countSameMemory++;
                }
            }
            for (int i = 0; i < countSameMemory; i++) {
                if (list.get(i).getRating() > list.get(i + 1).getRating()) {
                    return i;
                } else {
                    if ((Objects.equals(list.get(i).getName(), "Asus")) ||
                            (Objects.equals(list.get(i).getName(), "Samsung"))) {
                        return i;
                    } else {
                        return (int) (Math.random() * countSameMemory);
                    }
                }
            }

            return 0;

        }
    }

    public void printChosenTablet(List<Tablet> list, int index) {

        Tablet gettingTablet = list.get(index);

        System.out.print(gettingTablet.getName() + " ");
        System.out.print(gettingTablet.getMemory() + " ");
        System.out.print(gettingTablet.getRating() + " ");
        System.out.print(gettingTablet.getPrice());
        System.out.println();

    }

    public String returnChosenTablet(List<Tablet> list, int index) {

        if (index == -1) {
            return "there are no such tablets";
        }

        Tablet gettingTablet = list.get(index);

        return gettingTablet.getName() + " " + gettingTablet.getMemory() + " " + gettingTablet.getRating() + " " +
                gettingTablet.getPrice();

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

    public void printList(List<Tablet> list) {

        for (int i = 0; i < list.size(); i++) {
            printChosenTablet(list, i);
        }

    }

    public void fillListFromStrList(List<List<String>> listStr, List<Tablet> list) {
        for (int i = 0; i < listStr.size(); i++) {
            list.add(new Tablet(listStr.get(i).get(0), Integer.parseInt(listStr.get(i).get(1)),
                    Integer.parseInt(listStr.get(i).get(2)), Integer.parseInt(listStr.get(i).get(3))));
        }
    }

}
