package yassen.salam.abdalrhmanfinalproject.data;

public class Task {
    private String key; //to identify the task by its own key
    private String Title;
    private String Subject;
    private String TaskImportance; //to know about importance
    private String Owner; //name of task owner


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

    public String getTaskImportance() {
        return TaskImportance;
    }

    public void setTaskImportance(String taskImportance) {
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


public Task(){
//another time
}

