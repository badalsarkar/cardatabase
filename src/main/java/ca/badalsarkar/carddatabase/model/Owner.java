package ca.badalsarkar.carddatabase.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;
    private String firstname, lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;

    public Owner() {
    }

    public Owner(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;

        Owner owner = (Owner) o;

        if (!getOwnerId().equals(owner.getOwnerId())) return false;
        if (!getFirstname().equals(owner.getFirstname())) return false;
        if (getLastname() != null ? !getLastname().equals(owner.getLastname()) : owner.getLastname() != null)
            return false;
        return getCars() != null ? getCars().equals(owner.getCars()) : owner.getCars() == null;
    }

    @Override
    public int hashCode() {
        int result = getOwnerId().hashCode();
        result = 31 * result + getFirstname().hashCode();
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + (getCars() != null ? getCars().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + ownerId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cars=" + cars +
                '}';
    }
}
