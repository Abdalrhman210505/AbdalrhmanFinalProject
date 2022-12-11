package yassen.salam.abdalrhmanfinalproject.data;

import java.util.Date;

public class Appointment {
    private String key; //to identify the task by its own key
    private String nameofstudent;
    private Boolean AutomaticType;
    private Boolean ManualType;
    private String Identity;
    private String PhoneNumber;
    private String Time;
    private String Date;
    private int NumberOfClass;
    private String Owner; //name of task owner

    public Boolean getAutomaticType() {
        return AutomaticType;
    }

    public void setAutomaticType(Boolean automaticType) {
        AutomaticType = automaticType;
    }

    public Boolean getManualType() {
        return ManualType;
    }

    public void setManualType(Boolean manualType) {
        ManualType = manualType;
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
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
                ", AutomaticType='" + AutomaticType + '\'' +
                ", ManualType='" + ManualType + '\'' +
                ", Identity='" + Identity + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Time='" + Time + '\'' +
                ", Date='" + Date + '\'' +
                ", NumberOfClass=" + NumberOfClass +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}







