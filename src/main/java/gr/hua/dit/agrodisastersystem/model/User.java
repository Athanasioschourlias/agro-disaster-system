package gr.hua.dit.agrodisastersystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "tin_number") // Taxpayer Identification Number
    private int tinNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password", columnDefinition = "VARCHAR(255) BINARY")
    private String password;

    @Column(name = "role") // ΕΛΓΑ employee, farmer, Admin
    private String role;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int tinNumber, String firstName, String lastName, String password, String userMail, String userRole) {

        this.tinNumber = tinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = userMail;
        this.role = userRole;

    }

    public int getTin_number() {
        return tinNumber;
    }

    public void setTin_number(int newTIN) {
        this.tinNumber = newTIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(tinNumber, user.tinNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
