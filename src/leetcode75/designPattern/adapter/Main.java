package leetcode75.designPattern.adapter;

public class Main {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new LegacyPrinter();
        NewPrinter printer = new PrinterAdapter(oldPrinter);

        printer.printNew("Hello, Adapter Pattern!");
    }
}