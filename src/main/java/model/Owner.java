package model;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
public class Owner{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Pet> petsSet = new HashSet<>();

    public Owner(){}

    public Owner(long id, String firstName, String lastName, int age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Owner(long id, String firstName, String lastName, int age, Set<Pet> petsSet) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.petsSet = petsSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<Pet> getPetsSet() {
        return petsSet;
    }

    public void setPetsSet(Set<Pet> petsSet) {
        this.petsSet = petsSet;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    //@Formula(value = "select avg() from pet where pet.ownerId = id")
    //private Double average;
}
