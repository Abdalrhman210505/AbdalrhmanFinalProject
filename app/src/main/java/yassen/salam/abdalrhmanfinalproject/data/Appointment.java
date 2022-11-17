package yassen.salam.abdalrhmanfinalproject.data;

import java.util.Date;

public class Appointment {
    private String key; //to identify the task by its own key
    private String nameofstudent;
    private String type;
    private String Identity;
    private String PhoneNumber;
    private Date Time;
    private Date Date;
    private int NumberOfClass;


    public int getNumberOfClass() {
        return NumberOfClass;
    }

    public void setNumberOfClass(int numberOfClass) {
        NumberOfClass = numberOfClass;
    }





    public String getIdentity() {
        return Identity;
    }

    public void setIdentity(String identity) {
        Identity = identity;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public java.util.Date getTime() {
        return Time;
    }

    public void setTime(java.util.Date time) {
        Time = time;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    private String Owner; //name of task owner

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNameofstudent() {
        return nameofstudent;
    }

    public void setNameofstudent(String nameofstudent) {
        this.nameofstudent = nameofstudent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "key='" + key + '\'' +
                ", nameofstudent='" + nameofstudent + '\'' +
                ", type='" + type + '\'' +
                ", Identity='" + Identity + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Time=" + Time +
                ", Date=" + Date +
                ", NumberOfClass=" + NumberOfClass +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}







