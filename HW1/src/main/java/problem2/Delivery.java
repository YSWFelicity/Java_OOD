package problem2;

/*** Time is an object that has a unique starting time,
 * end time, starting location and end location. */
public class Delivery {
    public static final Integer SEXAGESIMAL = 60;
    private Time startingTime;
    private Time endTime;
    private String startingLocation;
    private String endLocation;

    /**
     * Constructor that creates a new Delivery object with the specified hour, minute and second.
     *
     * @param startingTime - starting time of the new Delivery object.
     * @param endTime - end time of the new Delivery.
     * @param startingLocation - starting location of the new Delivery.
     * @param endLocation - end location of the new Delivery.
     */
    public Delivery(Time startingTime, Time endTime, String startingLocation, String endLocation) {
        this.startingTime = startingTime;
        this.endTime = endTime;
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
    }

    /**
     * Returns the startingTime of the Delivery.
     *
     * @return the startingTime of the Delivery.
     */
    public Time getStartingTime() {
        return this.startingTime;
    }

    /**
     * Returns the endTime of the Delivery.
     *
     * @return the endTime of the Delivery.
     */
    public Time getEndTime() {
        return this.endTime;
    }

    /**
     * Returns the startingLocation of the Delivery.
     *
     * @return the startingLocation of the Delivery.
     */
    public String getStartingLocation() {
        return this.startingLocation;
    }

    /**
     * Returns the endLocation of the Delivery.
     *
     * @return the endLocation of the Delivery.
     */
    public String getEndLocation() {
        return this.endLocation;
    }

    /**
     * Returns the duration of the Delivery.
     *
     * @return the duration of the Delivery.
     */
    public Time getDuration() {
        Integer startingSecond = this.startingTime.getSecond();
        Integer startingMinute = this.startingTime.getMinute();
        Integer startingHour = this.startingTime.getHour();
        Integer endSecond = this.endTime.getSecond();
        Integer endMinute = this.endTime.getMinute();
        Integer endHour = this.endTime.getHour();

        if (endSecond < startingSecond) {
            endSecond += SEXAGESIMAL;
            endMinute -= 1;
        }

        if (endMinute < startingMinute) {
            endMinute += SEXAGESIMAL;
            endHour -= 1;
        }
        Integer second = endSecond - startingSecond;
        Integer minute = endMinute - startingMinute;
        Integer hour = endHour - startingHour;

        Time duration = new Time(hour, minute, second);
        return duration;
    }
}