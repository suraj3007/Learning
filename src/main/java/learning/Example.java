package main.java.learning;

public class Example {
    public static int peakElement(int[] arr,int n)
    {
        int maxIndex = 0;
        int maxValue = arr[0];
        for(int i = 1; i < n; i++){
            if(maxValue < arr[i]){
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 0};
        System.out.println(peakElement(arr, 5));
    }
}
