package java;

public class Outerclass {
    private int outerData = 1000;

    class InnerClass {
        private int innerData = 3000;

        public void invoke() {
            System.out.println("InnerClass:invoke method is Called :" + outerData);
            display();
        }
    }

    public void display() {
        System.out.println("OuterClass:display method is Clled..");
        InnerClass innerClass = new InnerClass();
        System.out.println("Accwssing innerClass Data::" + innerClass.innerData);
    }

}
