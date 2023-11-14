package org.example;

import java.time.LocalTime;
import java.util.Date;

public class Main2 {
    public static void main(String[] args) {
        Email person1 = new Email("saitejesh@gmail.com");
        person1.changePassword("Accio@123","Amazon@123");

        Gmail Human1 = new Gmail("saitejesh@gmail.com",5);


        Date date1 = new Date(2023, 10, 1); // Replace with your desired date
        Date date2 = new Date(2023, 10, 7); // Replace with your desired date
        Date date3 = new Date(2023, 10, 14); // Replace with your desired date
        Date date4 = new Date(2023, 10, 15);

        // Receive some mails
        Human1.receiveMail(date1, "sender1", "Hello, this is the first mail");
        Human1.receiveMail(date2 , "sender2", "Hello, this is the second mail");
        Human1.receiveMail(date3 , "sender3", "Hello, this is the third mail");
        Human1.receiveMail(date4 , "sender4", "Hello, this is the fourth mail");


        // Print the latest and oldest messages
        System.out.println("Latest message: " + Human1.findLatestMessage());
        System.out.println("Oldest message: " + Human1.findOldestMessage());

        // Delete a mail
        Human1.deleteMail("Hello, this is the second mail");


        // Find the number of mails between two dates
        Date startDate =  new Date(2023, 10, 1);; // Replace with your desired start date
        Date endDate =new Date(2023, 10, 15); // Replace with your desired end date
        int mailsBetweenDates = Human1.findMailsBetweenDates(startDate, endDate);
        System.out.println("Number of mails between dates: " + mailsBetweenDates);

        // Print the inbox and trash sizes
        System.out.println("Inbox size: " + Human1.getInboxSize());
        System.out.println("Trash size: " + Human1.getTrashSize());

        // Empty the trash
        Human1.emptyTrash();

        // Print the inbox and trash sizes after emptying the trash
        System.out.println("Inbox size after emptying trash: " + Human1.getInboxSize());
        System.out.println("Trash size after emptying trash: " + Human1.getTrashSize());

        // Get the inbox capacity
        System.out.println("Inbox capacity: " + Human1.getInboxCapacity());


        // Create a Workspace object
        Workspace workspace = new Workspace("saitejesh@gmail.com");

        Date WSdate1 = new Date(2023, 10, 1); // Replace with your desired date
        Date WSdate2 = new Date(2023, 10, 7); // Replace with your desired date
        Date WSdate3 = new Date(2023, 10, 14); // Replace with your desired date

        // Receive some mails
        workspace.receiveMail(WSdate1, "sender1", "Hello, this is the first workspace mail");
        workspace.receiveMail(WSdate2, "sender2", "Hello, this is the second workspace mail");
        workspace.receiveMail(WSdate3, "sender3", "Hello, this is the third workspace mail");



        // Delete a mail
        workspace.deleteMail("Hello, this is the second mail");

        // Print the latest and oldest messages
        System.out.println("Latest message: " + workspace.findLatestMessage());
        System.out.println("Oldest message: " + workspace.findOldestMessage());

        // Find the number of mails between two dates
        Date start = new Date(2023,10,1); // Replace with your desired start date
        Date end = new Date(2023,10,14); // Replace with your desired end date
        int numberOfMailsBetweenDates = workspace.findMailsBetweenDates(startDate, endDate);
        System.out.println("Number of mails between dates: " + numberOfMailsBetweenDates);


        // Print the inbox and trash sizes
        System.out.println("Inbox size: " + workspace.getInboxSize());
        System.out.println("Trash size: " + workspace.getTrashSize());

        // Empty the trash
        workspace.emptyTrash();

        // Print the inbox and trash sizes after emptying the trash
        System.out.println("Inbox size after emptying trash: " + workspace.getInboxSize());
        System.out.println("Trash size after emptying trash: " + workspace.getTrashSize());

        // Get the inbox capacity
        System.out.println("Inbox capacity: " + Human1.getInboxCapacity());


        // Create some meetings
        Meeting meeting1 = new Meeting(LocalTime.of(9, 0), LocalTime.of(10, 0));
        Meeting meeting2 = new Meeting(LocalTime.of(10, 30), LocalTime.of(11, 30));
        Meeting meeting3 = new Meeting(LocalTime.of(12, 0), LocalTime.of(13, 0));

        // Add meetings to the workspace calendar
        workspace.addMeeting(meeting1);
        workspace.addMeeting(meeting2);
        workspace.addMeeting(meeting3);

        // Find the maximum number of meetings that can be attended
        int maxMeetings = workspace.findMaxMeetings();
        System.out.println("Maximum number of meetings that can be attended: " + maxMeetings);

    }
}
