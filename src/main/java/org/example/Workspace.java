package org.example;

import java.util.ArrayList;
import java.util.List;

public class Workspace  extends Gmail  {

    private List<Meeting> calendar;


    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
    }

    /**The findMaxMeetings method in the Workspace class is designed to find the maximum number of
     non-overlapping meetings that can be attended.
    It iterates through each meeting in the calendar and checks how many meetings can be attended without
     overlapping with each other.**/

    /**
     Let's go through the findMaxMeetings method with an example:
     Suppose you have the following meetings:
     Meeting 1: 9:00 AM to 10:00 AM
     Meeting 2: 10:30 AM to 11:30 AM
     Meeting 3: 12:00 PM to 1:00 PM
     When you call workspace.findMaxMeetings(), the method will iterate through each meeting and check how many
     meetings can be attended without overlapping. It uses the overlaps method to determine if two meetings overlap.
     **/
    public int findMaxMeetings() {
        int maxMeetings = 0;
        for (Meeting currentMeeting : calendar) {
            int count = 0; // Initialize count to 0 for each current meeting
            for (Meeting otherMeeting : calendar) {
                if (currentMeeting != otherMeeting && overlaps(currentMeeting, otherMeeting)) {
                    count++; // Increment count if there is an overlap
                }
            }
            maxMeetings = Math.max(maxMeetings, calendar.size() - count); // Calculate the maximum non-overlapping meetings
        }
        return maxMeetings;
    }

    /**

     The overlaps method checks if two meetings overlap by comparing their start and end times.
     If the start time of one meeting is before the end time of the other meeting, and vice versa, then the meetings overlap.
     In the example:
     Meeting 1 and Meeting 2 do not overlap
     Meeting 1 and Meeting 3 do not overlap
     Meeting 2 and Meeting 3 do not overlap

     So, the maximum number of meetings that can be attended without overlapping is 3.
     Therefore, the output of System.out.println("Maximum number of meetings that can be attended: " + maxMeetings);
     will be "Maximum number of meetings that can be attended: 3".
     This is because all three meetings can be attended without overlapping with each other, and thus the
     maximum number of meetings that can be attended is 3.
     **/
    private boolean overlaps(Meeting meeting1, Meeting meeting2) {
        return meeting1.getStartTime().isBefore(meeting2.getEndTime()) &&
                meeting2.getStartTime().isBefore(meeting1.getEndTime());
    }
}
