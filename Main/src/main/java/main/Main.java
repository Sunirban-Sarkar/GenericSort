package main;

import quicksort.QuickSort;
import support.ArraySwapper;
import support.ArrayWrapper;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        final var fileName = args[0];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
            final var lines = new LinkedList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            String[] lineArray = lines.toArray(new String[0]);
            var sort = new QuickSort<>(String::compareTo, new ArraySwapper<>(lineArray));
            sort.sort(new ArrayWrapper<>(lineArray));
            for(final String outLine: lineArray){
                System.out.println(outLine);
            }
        } finally {
            if(br!=null){
                br.close();
            }
        }
    }
}