package p2;

import java.util.Objects;

public class ContactInfo {

  private String streetAndNumber;
  private String city;
  private String state;
  private String ZIPcode;
  private String phoneNumber;
  private String emailAddress;

  public ContactInfo(String streetAndNumber, String city, String state, String ZIPcode,
      String phoneNumber, String emailAddress) {
    this.streetAndNumber = streetAndNumber;
    this.city = city;
    this.state = state;
    this.ZIPcode = ZIPcode;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public String getStreetAndNumber() {
    return streetAndNumber;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZIPcode() {
    return ZIPcode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfo that = (ContactInfo) o;
    return Objects.equals(streetAndNumber, that.streetAndNumber)
        && Objects.equals(city, that.city) && Objects.equals(state, that.state)
        && Objects.equals(ZIPcode, that.ZIPcode) && Objects.equals(phoneNumber,
        that.phoneNumber) && Objects.equals(emailAddress, that.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetAndNumber, city, state, ZIPcode, phoneNumber, emailAddress);
  }
}
