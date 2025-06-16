package leetcode75.designPattern.abstractFactory;

interface Button {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Windows tugmasi yaratildi!");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Mac tugmasi yaratildi!");
    }
}

interface Checkbox {
    void render();
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Windows belgilash katagi yaratildi!");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Mac belgilash katagi yaratildi!");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Factory subclasslar
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        String os = "Windows"; // Yoki "Mac" tanlansa, MacFactory ishlaydi

        if (os.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}