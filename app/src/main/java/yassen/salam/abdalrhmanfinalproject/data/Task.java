package yassen.salam.abdalrhmanfinalproject.data;

public class Task {
    private String key; //to identify the task by its own key
    private String Title;
    private String Subject;
    private int TaskImportance; //to know about importance
    private String Owner; //name of task owner

    public Task(){

    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getTaskImportance() {
        return TaskImportance;
    }

    public void setTaskImportance(int taskImportance) {
        TaskImportance = taskImportance;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }
    @Override
    public String toString() {
        return "Task{" +
                "key='" + key + '\'' +
                ", Title='" + Title + '\'' +
                ", Subject='" + Subject + '\'' +
                ", TaskImportance='" + TaskImportance + '\'' +
                ", Owner='" + Owner + '\'' +
                '}';
    }

}




