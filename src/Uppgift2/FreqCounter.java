package Uppgift2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class FreqCounter {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/fredrikpettersson/IdeaProjects/Laboration3/src/Uppgift2/newtextfile.txt");
        System.setIn(new FileInputStream(file));
        int minlen = 10;
        int words = 0;
        int distinct = 0;
        int N=5;

        //BST<String, Integer> binarySearch = new BST<>();
        BinarySearchSt<String,Integer> binarySearch = new BinarySearchSt<>(500);
        int i = 0;
        while (!StdIn.isEmpty() && i<N*100)

        {
            String key = StdIn.readString();
            if (key.length() < minlen)
                continue;
            words++;
            if (binarySearch.contains(key)) {
                binarySearch.put(key, binarySearch.get(key) + 1);
            }
            else {
                binarySearch.put(key, 1);
                distinct++;
            }
            i++;
        }

        String max = "";
        binarySearch.put(max, 0);
        long startTime = System.nanoTime();
        for (String word : binarySearch.keys()) {
            if (binarySearch.get(word) > binarySearch.get(max))
                max = word;
        }
        long endTime = System.nanoTime();
        double time = (double) endTime - startTime;

        StdOut.println();
        System.out.println("Time: " +time/1000000+ " ms");
        StdOut.println("The word '"+max + "' is included: " + binarySearch.get(max)+ " times");
        StdOut.println("Number of unique words: "+distinct);
        StdOut.println("Number of total words: "+words);
    }
}
