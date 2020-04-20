package main.java.com.pluralsight.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("This is an example ");
        builder.append("of the builder pattern. ");
        builder.append("It has methods to append ");
        builder.append("almost anything to a string. ");
        builder.append(42);
        //System.out.println(builder);
        System.out.println(builder.toString());
    }
}