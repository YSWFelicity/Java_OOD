package p1;

import java.util.List;
import java.util.Objects;

/*
Class EmailAccount contains information about an owner of a specific email account (owner’s name),
email address of the account, as well as information about all the emails sent and received by that email account.
*/
public class EmailAccount {

  private Name owner;
  private String emailAddress;
  private List<Email> receivedEmails;
  private List<Email> sentEmails;

  public EmailAccount(Name owner, String emailAddress, List<Email> receivedEmails,
      List<Email> sentEmails) {
    this.owner = owner;
    this.emailAddress = emailAddress;
    this.receivedEmails = receivedEmails;
    this.sentEmails = sentEmails;
  }

  public Name getOwner() {
    return owner;
  }

  public void setOwner(Name owner) {
    this.owner = owner;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public List<Email> getReceivedEmails() {
    return receivedEmails;
  }

  public void setReceivedEmails(List<Email> receivedEmails) {
    this.receivedEmails = receivedEmails;
  }

  public List<Email> getSentEmails() {
    return sentEmails;
  }

  public void setSentEmails(List<Email> sentEmails) {
    this.sentEmails = sentEmails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailAccount that = (EmailAccount) o;
    return Objects.equals(owner, that.owner) && Objects.equals(emailAddress,
        that.emailAddress) && Objects.equals(receivedEmails, that.receivedEmails)
        && Objects.equals(sentEmails, that.sentEmails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, emailAddress, receivedEmails, sentEmails);
  }

  @Override
  public String toString() {
    return "EmailAccount{" +
        "owner=" + owner +
        ", emailAddress='" + emailAddress + '\'' +
        ", receivedEmails=" + receivedEmails +
        ", sentEmails=" + sentEmails +
        '}';
  }
}