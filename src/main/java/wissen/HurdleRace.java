package main.java.wissen;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class HurdleRace {

    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        OptionalInt maxHeight = height.stream().mapToInt(Integer::intValue).max();
        int doses = maxHeight.getAsInt() - k;
        return doses < 0 ? 0 : doses;
    }
}
