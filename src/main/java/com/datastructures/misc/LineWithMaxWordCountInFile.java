package com.datastructures.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/* Programme to find the line with the maximum number of words in the file. */
public class LineWithMaxWordCountInFile {

    public static String fetchLineWithMaxCount(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String lineWithMaxCount = null;
        int count = 0;
        int max = 0;

        while ((line = bufferedReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " .,;:");

            while (stringTokenizer.hasMoreTokens()) {
                stringTokenizer.nextToken();
                count += 1;
            }
            if (count > max) {
                max = count;
                lineWithMaxCount = line;
            }
        }
        return lineWithMaxCount;
    }

    public static void main(String[] args) {
        String lineWithMaxCount = null;
        try {
            lineWithMaxCount = fetchLineWithMaxCount("/Users/kumarp9/Desktop/examplefile");
        } catch (IOException e) {
            System.out.println("Exception caught while reading file");
        }
        System.out.println("The line with max count is : " + lineWithMaxCount);
    }
}
