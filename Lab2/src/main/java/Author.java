import java.util.Objects;

/**
This class stores information about an author. The stored information includes name, email address and address.
 */
public class Author {

    private String name;
    private String emailAdress;
    private String address;

    public Author(String name, String emailAdress, String address) {
        this.name = name;
        this.emailAdress = emailAdress;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(emailAdress, author.emailAdress) && Objects.equals(address, author.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emailAdress, address);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
