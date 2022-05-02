package P2;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Iterator class which iterate through all the mobile apps
 */
public class MobileAppIterator implements Iterator<MobileApp> {

  private List<MobileApp> mobileApps;
  private LocalDate release;
  private static final String PHOTO = "photo";
  private static final String MESSAGE = "message";
  private static final String LOCATION = "location";

  /**
   * Constructs a MobileAppIterator
   * @param mobileApps - the list of mobile apps
   */
  public MobileAppIterator(List<MobileApp> mobileApps){
    this.mobileApps = mobileApps;
    this.release = LocalDate.of(2017, 1,1);
  }

  /**
   * Method to get a list of app which are released after the date, and do not contain
   * provided permissions, and belongs to either Education or Productivity type
   * @return a list of apps
   */
  public List<MobileApp> filterMobileApp(List<MobileApp> mobileApps){
    return mobileApps.stream().filter(app->app.getDateOfOriginalRelease().isAfter(release))
        .filter(app-> belongCategory(app, MobileAppCategory.EDUCATIONAL_APP, MobileAppCategory.PRODUCTIVITY_APP))
        .filter(app->notContain(app, PHOTO, MESSAGE, LOCATION)).collect(Collectors.toList());
  }

  /**
   * Helper function to determine if an app contains these permission
   * @param app - the app we are looking at
   * @param PHOTO - photo
   * @param MESSAGE - message
   * @param LOCATION - location
   * @return boolean
   */
  private boolean notContain(MobileApp app, String PHOTO, String MESSAGE, String LOCATION){
    for(String permission: app.getRequestedPermissions()){
      if(permission.equals(PHOTO) || permission.equals(MESSAGE) || permission.equals(LOCATION)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Private method to determine if the app belongs to one of the category provided
   * @param app - the app we are looking at
   * @param c1 - the first category
   * @param c2 - the second category
   * @return boolean
   */
  private boolean belongCategory(MobileApp app, MobileAppCategory c1, MobileAppCategory c2){
    return app.getAppCategory().equals(c1) || app.getAppCategory().equals(c2);
  }

  /**
   * Return true if the iterator has more elements
   * @return boolean
   */
  @Override
  public boolean hasNext() {
    return (this.mobileApps.size() > 0);
  }

  /**
   * Return the next element in the iterator
   * @return the next element
   */
  @Override
  public MobileApp next() {
    return this.mobileApps.remove(0);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MobileAppIterator that = (MobileAppIterator) o;
    return Objects.equals(mobileApps, that.mobileApps) && Objects.equals(release,
        that.release);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mobileApps, release);
  }

  @Override
  public String toString() {
    return "MobileAppIterator{" +
        "mobileApps=" + mobileApps +
        ", release=" + release +
        '}';
  }
}