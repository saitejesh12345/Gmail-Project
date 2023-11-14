package org.example;



public class Email {

    private String emailId ;

    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123"; // Default password
    }

    public void changePassword(String oldPassword, String newPassword) {
    if(oldPassword.equals(password) && isPasswordValid(newPassword)){
        password =newPassword;
        System.out.println("Password changed successfully!");

    }else{
        System.out.println("Failed to change password. Please make sure the old password is correct and the new password meets all the requirements.");
    }
    }

    public Boolean isPasswordValid(String password){
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[^a-zA-Z0-9].*");

    }

}
