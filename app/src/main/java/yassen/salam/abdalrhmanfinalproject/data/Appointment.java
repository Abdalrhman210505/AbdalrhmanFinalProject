package yassen.salam.abdalrhmanfinalproject.data;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
    private String key; //to identify the task by its own key
    private String nameofstudent;
    private Boolean iSManualType;// if it manual

    private String Identity;
    private String PhoneNumber;
    private String Time;
    private String Location;
    private Date date = new Date();
    private int NumberOfClass;
    private String Owner; //name of task owner

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

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

    public Boolean getiSManualType() {
        return iSManualType;
    }

    public void setiSManualType(Boolean iSManualType) {
        this.iSManualType = iSManualType;
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

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfClass() {
        return NumberOfClass;
    }

    public void setNumberOfClass(int numberOfClass) {
        NumberOfClass = numberOfClass;
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
                ", iSManualType=" + iSManualType +
                ", Identity='" + Identity + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Time='" + Time + '\'' +
                ", Location='" + Location + '\'' +
                ", date=" + date +
                ", NumberOfClass=" + NumberOfClass +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}