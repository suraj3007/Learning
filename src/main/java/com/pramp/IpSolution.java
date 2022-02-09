package main.java.com.pramp;

public class IpSolution {

    static boolean validateIP(String ip) {
        //12.34.5.6
        String[] singleIp = ip.split("\\."); //12 34 5 6
        if (singleIp.length != 4) {
            return false;
        }
        for (String s : singleIp) {
            try {
                int i = Integer.parseInt(s);
                if (i < 0 || i > 255)
                    return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.gc();
    }
}
