package sit.tu_varna.bg.models;

public class Contact {
    private String email;
    private String phone;
    private Address address;

    public Contact(String email,
                   String phone,
                   Address address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}
