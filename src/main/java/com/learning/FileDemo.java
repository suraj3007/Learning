package main.java.com.learning;

import java.io.*;

public class FileDemo {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter("main/resources/merge.txt");

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource("main/resources/file1.txt").getFile());
        BufferedReader br1 = new BufferedReader(new FileReader(file));

        file = new File(classLoader.getResource("main/resources/file2.txt").getFile());
        BufferedReader br2 = new BufferedReader(new FileReader(file));

        String line1 = br1.readLine();
        String line2 = br2.readLine();

        while ((line1 != null) || (line2 != null)) {

            if (line1 != null) {
                pw.println(line1);
                line1 = br1.readLine();
            }
            if (line2 != null) {
                pw.println(line2);
                line2 = br2.readLine();
            }
        }

        pw.flush();
        br1.close();
        br2.close();
        pw.close();
    }
}

class Test123 implements Serializable {
    int i = 10;
    int j = 20;
}