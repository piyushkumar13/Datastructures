package com.datastructures.misc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Programme to find the distinct words in the file. */
@SuppressWarnings("ConstantConditions")
public class DistinctWordsInFile {

    public static void createFile(String name, String content) {
        File file = new File("/Users/kumarp9/Desktop/" + name);
        FileWriter fileWriter;

        try {
            if (file.createNewFile()) {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(content);
                fileWriter.flush();
                System.out.println("file is created with the content");

            } else {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(content);
                fileWriter.flush();
                System.out.println("Contents are written successfully.");
            }
        } catch (IOException e) {
            System.out.println("exception is ::: " + e);
        }
    }

    public static List<String> findDistinctWordsInFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader("/Users/kumarp9/Desktop/" + fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> distinctWords = new ArrayList<String>();
        String line;
        String tmp;

        while ((line = bufferedReader.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ,.;");

            while (stringTokenizer.hasMoreTokens()) {
                tmp = stringTokenizer.nextToken();
                if (!distinctWords.contains(tmp)) {
                    distinctWords.add(tmp);
                }
            }

        }
        return distinctWords;

    }

    public static void main(String[] args) {
        String content = "This is the content of the file.\n" +
                "This program is for finding distint words in a file.\n";

        createFile("examplefile", content);

        List<String> disctinctWords = null;
        try {
            disctinctWords = findDistinctWordsInFile("examplefile");
        } catch (IOException e) {
            System.out.println("IOException while reading the file ::: " + e);
        }

        System.out.println("The distinct words are : ");
        for (String word : disctinctWords) {
            System.out.println(word);
        }
    }
}
