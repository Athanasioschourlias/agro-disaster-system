package gr.hua.dit.agrodisastersystem.payload.response;

public class Forms {

    private String firstname;

    private String lastName;

    private String location;

    private String damage_discription;

    private int acares;

    private String cropType;

    private String status;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDamage_discription() {
        return damage_discription;
    }

    public void setDamage_discription(String damage_discription) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
