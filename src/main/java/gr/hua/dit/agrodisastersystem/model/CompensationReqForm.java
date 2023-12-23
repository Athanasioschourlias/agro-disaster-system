package gr.hua.dit.agrodisastersystem.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name="compensation_form")
public class CompensationReqForm {
    public enum FormStatus {
        PENDING, REJECTED, COMPLETED;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "farmer_id", referencedColumnName = "id")
    private User user;
    @Column(name="location")
    private String location;
    @Column(name="damage_description")
    private String damageDescription;
    @Column(name="acres")
    private int acres;
    @Column(name="crop_type")
    private String cropType;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private FormStatus status;

    public CompensationReqForm(){

    }
    public CompensationReqForm(User user, String location, String damage_description, int acres, String cropType, FormStatus status) {
        this.user = user;
        this.location=location;
        this.damageDescription = damage_description;
        this.acres = acres;
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

    public FormStatus getStatus() {
        return status;
    }

    public void setStatus(FormStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public int getAcres() {
        return acres;
    }

    public void setAcres(int acres) {
        this.acres = acres;
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
        return  acres == that.acres && Objects.equals(location, that.location) && Objects.equals(damageDescription, that.damageDescription) && Objects.equals(cropType, that.cropType) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, damageDescription, acres, cropType, status);
    }
}
