package leetcode75.designPattern.adapter;

public class PrinterAdapter implements NewPrinter {
    private final OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void printNew(final String text) {
        oldPrinter.printOld(text);
    }
}
