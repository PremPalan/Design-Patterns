package com.ram.Adapter.example;

interface Printer{
    void print();
}

class PrinterAdapter implements Printer{

    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(){
        this.legacyPrinter = new LegacyPrinter();
    }

    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}

class LegacyPrinter {
    public void printDocument(){
        System.out.println("Legacy Printer printing Document......");
    }
}

public class Main {
    public static void clientCode(Printer printer) {
        printer.print();
    }

    public static void main(String[] args) {
        // Using the Adapter
        PrinterAdapter adapter = new PrinterAdapter();
        clientCode(adapter);
    }
}
