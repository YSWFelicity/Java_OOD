package problem2;

public class Person {

    private Name name;
    private String email;
    private String address;

    public Person(Name name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Name getName() {

        return name;
    }

    public String getEmail() {

        return email;
    }

    public String getAddress() {

        return address;
    }
}
