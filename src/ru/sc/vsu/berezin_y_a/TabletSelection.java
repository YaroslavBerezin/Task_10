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

    public String returnChosenTablet(List<Tablet> list, int index) {

        if (index == -1) {
            return "there are no such tablets";
        }

        Tablet gettingTablet = list.get(index);

        return gettingTablet.getName() + " " + gettingTablet.getMemory() + " " + gettingTablet.getRating() + " " +
                gettingTablet.getPrice();

    }

    public void fillListFromStrList(List<List<String>> listStr, List<Tablet> list) {
        for (int i = 0; i < listStr.size(); i++) {
            list.add(new Tablet(listStr.get(i).get(0), Integer.parseInt(listStr.get(i).get(1)),
                    Integer.parseInt(listStr.get(i).get(2)), Integer.parseInt(listStr.get(i).get(3))));
        }
    }

}
