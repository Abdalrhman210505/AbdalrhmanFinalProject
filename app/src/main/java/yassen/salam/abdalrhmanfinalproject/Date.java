package yassen.salam.abdalrhmanfinalproject;

/**
 * date
 */
public class Date {
    private int hours;
    private int minutes;
    private int DayOfMonth;
    private int Month;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours < 24) {
            this.hours = hours;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes < 60) {
            this.minutes = minutes;
        }
    }

    public int getDayOfMonth() {
        return DayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        if (dayOfMonth < 32) {

            DayOfMonth = dayOfMonth;
        }
    }

    public int getMonth() {
        return Month;
    }

    public void setMonthName(int month) {
        if (month < 13) {
            Month = month;
        }
    }


}
