package io;

import model.Medals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Alan.Ryan
 */
public class FileIO {

    static ArrayList<Medals> nameList = new ArrayList();

    public static ArrayList<Medals> readFile(String file) {

        Path p = Paths.get(file);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(p);
            lines.remove(0);//remove the headers
        } catch (IOException ex) {
            System.out.println(ex);
        }

        for (String line : lines) {
            nameList.add(parseLine(line));
        }

        return nameList;

    }

    private static Medals parseLine(String line) {
        int rank;
        String team;
        int goldTotal;
        int silverTotal;
        int bronzeTotal;
        int overallTotal;
        int rankByTotal;

        StringTokenizer st = new StringTokenizer(line);

        while (st.hasMoreElements()) {

            rank = Integer.parseInt(st.nextToken());
            team = st.nextToken();
            goldTotal = Integer.parseInt(st.nextToken());
            silverTotal = Integer.parseInt(st.nextToken());
            bronzeTotal = Integer.parseInt(st.nextToken());
            overallTotal = Integer.parseInt(st.nextToken());
            rankByTotal = Integer.parseInt(st.nextToken());

            return new Medals(rank, team, goldTotal, silverTotal, bronzeTotal, overallTotal, rankByTotal);
        }//end while

        return null; //shouldn't get here
    }

}
