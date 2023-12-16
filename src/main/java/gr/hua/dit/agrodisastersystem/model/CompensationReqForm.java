package gr.hua.dit.agrodisastersystem.model;

import javax.persistence.*;

@Entity
@Table(name="compensation_form")
public class CompensationReqForm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="location")
    private String location;
    @Column(name="damage_discription")
    private String damage_discription;
    @Column(name="acares")
    private int acares;
    @Column(name="crop_type")
    private String cropType;
    @Column(name="status")
    private String status;

    public CompensationReqForm(){

    }
    public CompensationReqForm(String firstName, String lastName, int age, String location, String damage_discription, int acares, String cropType, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location=location;
        this.damage_discription = damage_discription;
        this.acares = acares;
        this.cropType = cropType;
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDamageDiscription() {
        return damage_discription;
    }

    public void setDamageDiscription(String damage_discription) {
        this.damage_discription = damage_discription;
    }

    public int getAcares() {
        return acares;
    }

    public void setAcares(int acares) {
        this.acares = acares;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }


}
