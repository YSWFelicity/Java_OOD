package p1;

import java.util.Objects;

/**
 * Class Runner stores information about the runner - their best 5k time, best Half MarathonTime
 * and the favoriate Running Event.
 */
public class Runner extends Athlete{

    private Double best5KTime;
    private Double bestHalfMarathonTime;
    private String favoriateRunningEvent;

    /**
     * Constructs a new Runner, based upon all of the provided input parameters.
     * @param athletesName - object Name, containing athlete's first, middle and last name
     * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
     * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
     * @param league - athlete's league, expressed as String
     * @param best5KTime - runner's best 5K time, expressed as a Double
     * @param bestHalfMarathonTime - runner's best Half Marathon time, expressed as a Double
     * @param favoriateRunningEvent - runner's favorite running event, expressed as a String
     */
    public Runner(Name athletesName, Double height, Double weight, String league, Double best5KTime,
                  Double bestHalfMarathonTime, String favoriateRunningEvent) {
        super(athletesName, height, weight, league);
        this.best5KTime = best5KTime;
        this.bestHalfMarathonTime = bestHalfMarathonTime;
        this.favoriateRunningEvent = favoriateRunningEvent;
    }

    /**
     * returns baseball player's best 5K time as a Double
     * @return a Double
     */
    public Double getBest5KTime() {
        return best5KTime;
    }

    /**
     * Setter for best 5k time.
     * @param best5KTime - best 5k time, encoded as Double.
     */
    public void setBest5KTime(Double best5KTime) {
        this.best5KTime = best5KTime;
    }

    /**
     * returns baseball player's best Half Marathon as a Double
     * @return a Double
     */
    public Double getBestHalfMarathonTime() {
        return bestHalfMarathonTime;
    }

    /**
     * Setter for best half marathon time.
     * @param bestHalfMarathonTime - best half marathon, encoded as Double.
     */
    public void setBestHalfMarathonTime(Double bestHalfMarathonTime) {
        this.bestHalfMarathonTime = bestHalfMarathonTime;
    }

    /**
     * returns baseball player's favorite running event, expressed as a String
     * @return a String
     */
    public String getFavoriateRunningEvent() {
        return favoriateRunningEvent;
    }

    /**
     * Setter for Favoriate Running Event.
     * @param favoriateRunningEvent - Favoraite Running Event, encoded as String.
     */
    public void setFavoriateRunningEvent(String favoriateRunningEvent) {
        this.favoriateRunningEvent = favoriateRunningEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //obj1.equals(obj1);
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Runner runner = (Runner) o;
        return Objects.equals(best5KTime, runner.best5KTime) && Objects.equals(bestHalfMarathonTime, runner.bestHalfMarathonTime) && Objects.equals(favoriateRunningEvent, runner.favoriateRunningEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), best5KTime, bestHalfMarathonTime, favoriateRunningEvent);
    }

    @Override
    public String toString() {
        return "Runner{" +
                "best5KTime=" + best5KTime +
                ", bestHalfMarathonTime=" + bestHalfMarathonTime +
                ", favoriateRunningEvent='" + favoriateRunningEvent + '\'' +
                '}';
    }
}
