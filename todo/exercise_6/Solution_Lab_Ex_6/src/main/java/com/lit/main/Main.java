package com.lit.main;

import com.lit.io.FileIO;
import com.lit.model.Medals;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 *
 * @author Alan.Ryan
 */
public class Main {

    public static void main(String[] args) {

        List<Medals> list = FileIO.readFile("medals.txt");

        //task one
        System.out.println("---------------------------\nTASK 1");
        System.out.println("Percentage of countries whose rank is greater than their rank_by_total " + calculatePercRank(list, 1));

        //task two
        System.out.println("---------------------------\nTASK 2");
        printRank(list);

        //task three
        System.out.println("---------------------------\nTASK 3");
        getFilteredList(list, "stan", "land").forEach(System.out::println);

        //task four
        System.out.println("---------------------------\nTASK 4");
        Comparator<Medals> c = Comparator.comparing(Medals::getSilverTotal); //create Comparator
        getListSubset(list, 3, c).forEach(System.out::println);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //task one
    public static String calculatePercRank(List<Medals> medalList, int x) {

        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMaximumFractionDigits(x);

        int totalCount = medalList.size();

        long countValue = medalList
                .stream()
                .filter(m -> m.getRank() > m.getRankByTotal())
                .count();

        return format.format((double) countValue / totalCount);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //task two
    public static void printRank(List<Medals> medalList) {
        int random = ThreadLocalRandom.current().nextInt(1, 86 + 1);

        List<Medals> list = medalList.stream()
                .filter(medals -> medals.getRank() == random).toList();

        if (list.isEmpty())
            System.out.println("No record found with a rank of " + random);
        else
           list.forEach(System.out::println);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //task three
    public static List<Medals> getFilteredList(List<Medals> medalList, String suffix1, String suffix2) {
        return   medalList
                .stream()
                .filter(m ->m.getTeam().endsWith(suffix1) || m.getTeam().endsWith(suffix2))
                .sorted(Comparator.comparingInt(Medals::getRankByTotal))
                .collect(Collectors.toList());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //task four
    public static List<Medals> getListSubset(List<Medals> list, int offset, Comparator<Medals> condition) {

        list.sort(condition);
        Collections.reverse(list);
        return list.subList(0, offset);

    }
}//end class