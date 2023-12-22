package gr.hua.dit.agrodisastersystem.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "tin_number") // Taxpayer Identification Number
    private String tinNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password", columnDefinition = "VARCHAR(255) BINARY")
    private String password;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_tin_number", referencedColumnName = "tin_number"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

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

    public User(String tinNumber, String firstName, String lastName, String password, String userMail, Set<Role> userRole) {

        this.tinNumber = tinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = userMail;
        this.roles = userRole;

    }

    public String getTin_number() {
        return tinNumber;
    }

    public void setTin_number(String newTIN) {
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
