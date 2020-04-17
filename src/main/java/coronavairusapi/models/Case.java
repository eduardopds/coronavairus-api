package coronavairusapi.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "\"Case\"")
public class Case implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotNull
    private int age;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate updated;

    private LocalDate created;

    public Case() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getUpdated() {

        return updated;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    @PreUpdate
    private void updateData(){

        this.updated = LocalDate.now();

    }

    @PrePersist
    private void createData(){

        this.created = LocalDate.now();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return age == aCase.age &&
                Objects.equals(id, aCase.id) &&
                Objects.equals(name, aCase.name) &&
                Objects.equals(gender, aCase.gender) &&
                Objects.equals(address, aCase.address) &&
                Objects.equals(city, aCase.city) &&
                Objects.equals(country, aCase.country) &&
                status == aCase.status &&
                Objects.equals(updated, aCase.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, age, address, city, country, status, updated);
    }
}
