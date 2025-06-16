package leetcode75.designPattern.adapter;

public class LegacyPrinter implements OldPrinter {
    @Override
    public void printOld(final String text) {
        System.out.println("Legacy Printer " + text);
    }
}
