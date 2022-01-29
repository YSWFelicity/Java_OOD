package problem2;

/**
 * Delivery class has start location, end location, start time, and end time.
 * */
public class Delivery {
    private String startingLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;
    private static final int SEXAGESIMAL = 60;

    /**
     * Constructor that creates a new delivery object with the specified start location, end location, start time,
     * and end time.
     * @param startingLocation - start location of the new Delivery object.
     * @param endLocation - end location of the new Delivery object.
     * @param startTime - start time of the new Delivery.
     * @param endTime - end time of the new Delivery.
     * */
    public Delivery(String startingLocation, String endLocation, Time startTime, Time endTime){
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the starting location of the Delivery.
     * @return the starting location of the Delivery.
     * */
    public String getStartingLocation() {
        return startingLocation;
    }

    /**
     * Returns the end location of the Delivery.
     * @return the end location of the Delivery.
     * */
    public String getEndLocation() {
        return endLocation;
    }

    /**
     * Returns the starting time of the Delivery.
     * @return the starting time of the Delivery.
     * */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Returns the end time of the Delivery.
     * @return the end time of the Delivery.
     * */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Sets the start location of the Delivery.
     * @param startingLocation - Set the starting location of the Delivery object.
     * */
    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    /**
     * Sets the end location of the Delivery.
     * @param endLocation - Set the ending location of the Delivery object.
     * */
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Sets the start time of the Delivery.
     * @param startTime - Set the start time of the Delivery object.
     * */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Sets the end time of the Delivery.
     * @param endTime - Set the end time of the Delivery object.
     * */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * Returns the total time of the Delivery.
     * @return the total time of the Delivery.
     * */
    public Time getDuration(){
        Time endTime = this.getEndTime();
        Time startTime = this.getStartTime();
        int durHour = endTime.getHour() - startTime.getHour();
        int durMinute = timeDifference(endTime.getMinute(),startTime.getMinute());
        int durSecond = timeDifference(endTime.getSecond(),startTime.getSecond());
        return new Time(durHour, durMinute, durSecond);
    }

    /**
     * helper method.
     * @param start - the start time.
     * @param end - the end time.
     * Returns the time difference.
     * @return the time difference.
     * */
    private int timeDifference(int start, int end){
        if (end > start){
            return end - start;
        }else{
            return end + SEXAGESIMAL - start;
        }
    }

}
