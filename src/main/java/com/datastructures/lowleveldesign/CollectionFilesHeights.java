/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.lowleveldesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Piyush Kumar.
 * @since 30/03/23.
 */
public class CollectionFilesHeights {

    private Map<String, FileSystemAttributes> directoryDetailsMap;
    private PriorityQueue<Directory> directoryHeap;
    private int totalFileSize;
    private Set<Directory> isDirectoryPresentInHeap;

    public CollectionFilesHeights() {
        directoryDetailsMap = new HashMap<>();
        directoryHeap = new PriorityQueue<>((dir1, dir2) -> dir2.getSize() - dir1.getSize());
        isDirectoryPresentInHeap = new HashSet<>();
    }

    public int getTotalFileSize() {
        return this.totalFileSize;
    }

    public List<Directory> getTopNCollection(int N) {

        PriorityQueue<Directory> tempHeap = new PriorityQueue<>((dir1, dir2) -> dir2.getSize() - dir1.getSize());
        List<Directory> topNCollections = new ArrayList<>();
        for (int i = 0; i < N; i++) {

            Directory directory = directoryHeap.poll();
            topNCollections.add(directory);
            tempHeap.add(directory);
        }

        for (int i = 0; i < N; i++) {
            directoryHeap.add(tempHeap.poll());
        }

        return topNCollections;
    }

    public void addFiles(String fileName, int size, String directoryName) {

        if ("".equals(directoryName)) {

            directoryDetailsMap.put(fileName, new File(fileName, size));
        } else {

            Directory directory = (Directory) directoryDetailsMap.getOrDefault(directoryName, new Directory(directoryName));

            directory.setSize(directory.getSize() + size);
            directory.getFiles().add(new File(fileName, size));

            if (!isDirectoryPresentInHeap.contains(directory)) {
                isDirectoryPresentInHeap.add(directory);
                directoryHeap.add(directory);
            }

            directoryDetailsMap.put(directoryName, directory);
        }

        totalFileSize += size;

    }

    public static void main(String[] args) {
        CollectionFilesHeights CollectionFilesHeights = new CollectionFilesHeights();

        CollectionFilesHeights.addFiles("file1.txt", 100, "");
        CollectionFilesHeights.addFiles("file2.txt", 200, "collection1");
        CollectionFilesHeights.addFiles("file3.txt", 200, "collection1");
        CollectionFilesHeights.addFiles("file4.txt", 300, "collection2");
        CollectionFilesHeights.addFiles("file5.txt", 400, "");

        System.out.println(CollectionFilesHeights.getTotalFileSize());
        List<Directory> topNCollections = CollectionFilesHeights.getTopNCollection(2);

        for (Directory collection : topNCollections)
            System.out.println(collection.getDirectoryName() + " " + collection.getSize() + " ");
    }
}


interface FileSystemAttributes {
}

class File implements FileSystemAttributes {

    private String fileName;
    private int size;

    public File(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Directory implements FileSystemAttributes {

    private String directoryName;
    private int size;
    private List<File> files;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.size = 0;
        this.files = new ArrayList<>();
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}