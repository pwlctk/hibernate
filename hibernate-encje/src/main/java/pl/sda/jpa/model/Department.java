package pl.sda.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")

public class Department {

    @Id
    @Column(name = "department_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "department_name", length = 50)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", orphanRemoval = true, cascade={CascadeType.ALL})
    //Fetch to jak tworzymy zapytanie to LAzy zrobi tak ze wyciagnie tylko samych pracownikow (jesli chcemy tylko samych) bez informacji, ktore sa zbedne
    private Set<Worker> workers;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
