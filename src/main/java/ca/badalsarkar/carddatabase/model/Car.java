package ca.badalsarkar.carddatabase.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String brand;
    private String model;
    private String color;
    private String registrationNumber;
    private int year;
    private int price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    public Car() {
    }

    public Car(String brand, String model, String color, String registrationNumber, int year, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.year = year;
        this.price = price;
        this.owner= owner;
    }

    public Long getId() {
        return Id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Id=" + Id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getYear() != car.getYear()) return false;
        if (getPrice() != car.getPrice()) return false;
        if (!getId().equals(car.getId())) return false;
        if (!getBrand().equals(car.getBrand())) return false;
        if (!getModel().equals(car.getModel())) return false;
        if (!getColor().equals(car.getColor())) return false;
        if (!getRegistrationNumber().equals(car.getRegistrationNumber())) return false;
        return getOwner() != null ? getOwner().equals(car.getOwner()) : car.getOwner() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getRegistrationNumber().hashCode();
        result = 31 * result + getYear();
        result = 31 * result + getPrice();
        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
        return result;
    }
}
