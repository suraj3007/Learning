package main.java.striversSdeSheet.GreedyAlgorithm;

import java.util.*;

public class NMeetingInOneRoom {

    static class Meeting {
        int start, end, pos;

        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if (o1.pos < o2.pos)
                return -1;
            else
                return 1;
        }
    }

    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i));
        }

        //Sort meeting based on finishing time
        Collections.sort(meetings, new MeetingComparator());
        //since sorted, so meeting with minimum finishing time will be at top.
        int count = 1, endLimit = meetings.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > endLimit) {
                count++;
                endLimit = meetings.get(i).end;
            }
        }

        return count;
    }

    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        //Write your code here
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            //Meeting number is index 1 based
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        //Sort meeting based on finishing time
        Collections.sort(meetings, new MeetingComparator());
        //since sorted, so meeting with minimum finishing time will be at top.
        int count = 1, endLimit = meetings.get(0).end;
        List<Integer> res = new ArrayList<>();
        res.add(meetings.get(0).pos);

        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).start > endLimit) {
                res.add(meetings.get(i).pos);
                endLimit = meetings.get(i).end;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(maxMeetings(start, end, start.length));
    }
}
