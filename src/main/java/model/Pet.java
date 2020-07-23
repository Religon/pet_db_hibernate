package model;

import lombok.Builder;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String ownerName;
    private double weight;
    @Enumerated(value = EnumType.STRING)
    private Race race;
    @ManyToOne
    @ToString.Exclude
    private Owner owner;

    public Pet(){}

    public Pet(long id, String name, int age, String ownerName, double weight, Race race, Owner owner) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ownerName = ownerName;
        this.weight = weight;
        this.race = race;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ownerName='" + ownerName + '\'' +
                ", weight=" + weight +
                ", race=" + race +
                ", owner=" + owner +
                '}';
    }
}
