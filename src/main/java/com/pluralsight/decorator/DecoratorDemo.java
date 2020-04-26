package main.java.com.pluralsight.decorator;

import java.io.*;

public class DecoratorDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("./output.txt");

        OutputStream outputStream = new FileOutputStream(file); //
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.writeChars("text");

        dataOutputStream.close();
        outputStream.close();

    }
}

//FileOutputStream is used create an output stream, which is used to write byte/bytes to a file.
//With DataOutputStream class we can write primitive data types such as short, char, int, float, double, boolean to an output stream.
//You wrap an OutputStream in a DataOutputStream and then you can write primitives to it.
//That is why it is called a DataOutputStream - because you can write int, long, float and double values to the OutputStream, and not just raw bytes.
//Often you will use the Java DataOutputStream together with a Java DataInputStream.
//You use the DataOutputStream to write the data to e.g. a file, and then use the DataInputStream to read the data again.

class DataOutputStreamExample {

    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream =
                new DataOutputStream(
                        new FileOutputStream("data.bin"));

        //We can write int, float, long with DataOutputStream
        dataOutputStream.writeInt(123);
        dataOutputStream.writeFloat(123.45F);
        dataOutputStream.writeLong(789);

        dataOutputStream.close();

        //We can read int, float, long with DataInputStream
        DataInputStream dataInputStream =
                new DataInputStream(
                        new FileInputStream("data.bin"));

        int   int123     = dataInputStream.readInt();
        float float12345 = dataInputStream.readFloat();
        long  long789    = dataInputStream.readLong();

        dataInputStream.close();

        System.out.println("int123     = " + int123);
        System.out.println("float12345 = " + float12345);
        System.out.println("long789    = " + long789);
    }
}