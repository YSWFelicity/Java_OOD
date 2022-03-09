package p1;

import java.util.Objects;

public class ContactInfo {

  public Name name;
  public String address;
  public String phoneNumber;
  public String emailAddress;

  public ContactInfo(Name name, String address, String phoneNumber, String emailAddress) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
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
    return Objects.equals(name, that.name) && Objects.equals(address,
        that.address) && Objects.equals(phoneNumber, that.phoneNumber)
        && Objects.equals(emailAddress, that.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, phoneNumber, emailAddress);
  }

  @Override
  public String toString() {
    return "ContactInfo{" +
        "name=" + name +
        ", address='" + address + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}
