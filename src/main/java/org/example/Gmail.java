package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gmail extends Email{

    private int inboxCapacity; //the maximum number of mails that can be stored in the inbox
    private List<Mail> inbox; //collection of mails
    private List<Mail> trash; //collection of mails

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

//The receiveMail method adds a new mail to the inbox. If the inbox is full
// , it moves the oldest mail in the inbox to the trash before adding the new mail.

    public void receiveMail(Date date, String sender, String message) {
        if(inbox.size() >=inboxCapacity){
            moveOldestMailToTrash();
        }
        inbox.add(new Mail(date,sender,message));

    }

   // The deleteMail method searches for a mail with the given message in the inbox.
   // If found, it moves the mail to the trash.
    public void deleteMail(String message) {
        for(Mail mail : inbox){
            if(mail.getMessage().equals(message)){
                moveMailToTrash(mail);
                break;
            }
        }
    }

 //  The findLatestMessage method returns the message of the latest mail in the inbox.
 //  If the inbox is empty, it returns null.
    public String findLatestMessage() {
        if(inbox.isEmpty()){
            return null;
        }
        Mail latestMail = inbox.get(inbox.size()-1);
        return latestMail.getMessage();
    }

   // The findOldestMessage method returns the message of the oldest mail in the inbox.
   // If the inbox is empty, it returns null.
    public String findOldestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        Mail oldestMail = inbox.get(0);
        return oldestMail.getMessage();
    }

   // The findMailsBetweenDates method counts the number of mails in the inbox
   // that were received between the given start and end dates (inclusive).
    public int findMailsBetweenDates(Date start, Date end){
        int count =0;
        for(Mail mail : inbox){
            if(mail.getDate().compareTo(start) >=0 && mail.getDate().compareTo(end)<=0){
                count++;
            }
        }
        return count;
    }

    //The getInboxSize method returns the number of mails in the inbox.

    public int getInboxSize() {
        return inbox.size();
    }

  // The getTrashSize method returns the number of mails in the trash.

    public int getTrashSize() {
        return trash.size();
    }


    //The emptyTrash method clears all the mails in the trash.

    public void emptyTrash() {
        trash.clear();
    }

    //The getInboxCapacity method returns the maximum number of mails that can be stored in the inbox.
    public int getInboxCapacity() {
        return inboxCapacity;
    }

    private void moveOldestMailToTrash() {
        Mail oldestMail = inbox.get(0);
        moveMailToTrash(oldestMail);
    }

    private void moveMailToTrash(Mail mail) {
        inbox.remove(mail);
        trash.add(mail);
    }

}
