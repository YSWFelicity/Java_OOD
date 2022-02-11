package problem1;

import java.util.Objects;

public class BasicInformation {
  private String address;
  private PropertySize propertySize;
  private Boolean monthlySubscription;
  private Integer numberOfPreviousService;

  public BasicInformation(String address, PropertySize propertySize,
      Boolean monthlySubscription, Integer numberOfPreviousService) {
    this.address = address;
    this.propertySize = propertySize;
    this.monthlySubscription = monthlySubscription;
    this.numberOfPreviousService = numberOfPreviousService;
  }

  public PropertySize getPropertySize() {
    return propertySize;
  }

  public Boolean getMonthlySubscription() {
    return monthlySubscription;
  }

  public Integer getNumberOfPreviousService() {
    return numberOfPreviousService;
  }

  public void setNumberOfPreviousService(Integer numberOfPreviousService) {
    this.numberOfPreviousService = numberOfPreviousService;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicInformation that = (BasicInformation) o;
    return Objects.equals(address, that.address) && Objects.equals(propertySize,
        that.propertySize) && Objects.equals(monthlySubscription, that.monthlySubscription)
        && Objects.equals(numberOfPreviousService, that.numberOfPreviousService);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, propertySize, monthlySubscription, numberOfPreviousService);
  }

  @Override
  public String toString() {
    return "BasicInformation{" +
        "address='" + address + '\'' +
        ", propertySize=" + propertySize +
        ", monthlySubscription=" + monthlySubscription +
        ", numberOfPreviousService=" + numberOfPreviousService +
        '}';
  }
}
