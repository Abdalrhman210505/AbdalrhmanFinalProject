package yassen.salam.abdalrhmanfinalproject.data;

public class Appointment {
    private String key; //to identify the task by its own key
    private String nameofstudent;
    private String type;

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
                ", type='" + type + '\''
                ", Owner='" + Owner + '\'' +
                '}';
    }
}







