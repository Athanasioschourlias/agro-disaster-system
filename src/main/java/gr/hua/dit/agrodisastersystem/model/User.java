package gr.hua.dit.agrodisastersystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="tin") //Taxpayer Identification Number
    private String tin;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="password")
    private String password;
    @Column(name="role") //ΕΛΓΑ employee, farmer, Admin
    private String role;
    @Column(name="email")
    private String email;

    public User(String tin, String firstName, String lastName, String password, String role,String email) {
        super();
        this.tin = tin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.email=email;
    }
    public User(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String tin, String firstName, String lastName, String password) {
        this.tin = tin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getIt() {
        return tin;
    }

    public void setIt(String it) {
        this.tin = tin;
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
        return Objects.equals(tin, user.tin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tin);
    }
}
