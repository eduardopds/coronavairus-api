package coronavairusapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


public class CaseRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;

    private String gender;

    private int age;

    private String address;

    private String city;

    private String country;

    @Enumerated(EnumType.STRING)
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseRequest that = (CaseRequest) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(address, that.address) &&
                Objects.equals(city, that.city) &&
                Objects.equals(country, that.country) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, address, city, country, status);
    }
}
