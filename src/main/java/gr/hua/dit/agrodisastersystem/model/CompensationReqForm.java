package gr.hua.dit.agrodisastersystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="compensation_form")
public class CompensationReqForm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "farmer_tin_number", referencedColumnName = "tin_number")
    private User user;
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
    public CompensationReqForm(User user, String location, String damage_discription, int acares, String cropType, String status) {
        this.user = user;
        this.location=location;
        this.damage_discription = damage_discription;
        this.acares = acares;
        this.cropType = cropType;
        this.status = status;
    }

    public User getUser(){return this.user;}
    public  void setUser(User newUser){this.user = newUser;}
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

    @Override
    public boolean equals(Object form) {
        if (this == form) return true;
        if (!(form instanceof CompensationReqForm that)) return false;
        return  acares == that.acares && Objects.equals(location, that.location) && Objects.equals(damage_discription, that.damage_discription) && Objects.equals(cropType, that.cropType) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, damage_discription, acares, cropType, status);
    }
}
