package problem2;

public class Time {
    private int hour;
    private int minute;
    private int second;

    /**
     * Constructor that creates a new Time object with the specified hour, minute, and second.
     * @param hour - hour of the new Time object.
     * @param minute - minute of the new Time object.
     * @param second - second of the new Time object.
     * */
    public Time(int hour, int minute, int second){
        if(timeValid(hour,minute,second)){
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    /**
     * Helper method to valid the input of hour, minute, and second.
     * @param hour - hour of the new Time object.
     * @param minute - minute of the new Time object.
     * @param second - second of the new Time object.
     * @return true if inputs are valid.
     * */
    private boolean timeValid(int hour, int minute, int second){
        final int minHour = 0, minMinute = 0, minSecond = 0;
        final int maxHour = 23, maxMinute = 59, maxSecond = 59;
        if(hour >= minHour && hour <= maxHour && minute >= minMinute && minute <= maxMinute && second >= minSecond
                && second <= maxSecond){
            return true;
        }
        return false;
    }

    /**
     * Returns the hour of the Time.
     * @return the hour of the Time.
     * */
    public int getHour() {
        return hour;
    }

    /**
     * Sets the hour of the Time.
     * @param hour - Set the hour of the Time object.
     * */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Returns the minute of the Time.
     * @return the minute of the Time.
     * */
    public int getMinute() {
        return minute;
    }

    /**
     * Sets the minute of the Time.
     * @param minute - Set the minute of the Time object.
     * */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * Returns the second of the Time.
     * @return the second of the Time.
     * */
    public int getSecond() {
        return second;
    }

    /**
     * Sets the second of the Time.
     * @param second - Set the second of the Time object.
     * */
    public void setSecond(int second) {
        this.second = second;
    }
}
