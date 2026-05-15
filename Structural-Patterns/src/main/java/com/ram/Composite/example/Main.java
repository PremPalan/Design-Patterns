package com.ram.Composite.example;

import java.util.ArrayList;
import java.util.List;

abstract class FileSystemComponent{
    abstract public void display();
}

class File extends FileSystemComponent{
    private String name;
    private int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("File: " + name + " (" + size + " bytes)");
    }
}

class Directory extends FileSystemComponent{
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create leaf objects (files)
        FileSystemComponent file1 = new File("document.txt", 1024);
        FileSystemComponent file2 = new File("image.jpg", 2048);

        // Create a composite object (directory)
        Directory directory = new Directory("My Documents");

        // Add leaf objects to the directory
        directory.addComponent(file1);
        directory.addComponent(file2);

        // Display the directory (including its contents)
        directory.display();
    }
}