package main.java.com.learning;

class Test1234 {

    public static void main(String[] args) {
        System.out.println("Started...");
        System.out.println(2/0);
        System.out.println("Ended..");
    }
}

@FunctionalInterface
interface Square
{
    int calculate(int x);
}

class Test65768
{
    public static void main(String args[])
    {
        int a = 5;
        Square s = x -> x * x;

        System.out.println(s.calculate(a));
    }
}