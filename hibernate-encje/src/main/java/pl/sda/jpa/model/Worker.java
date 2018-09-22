package pl.sda.jpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "worker" )
public class Worker {

    @Id
    @Column(name = "worker_id", updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE) //ta adnotacja określa typ Daty jaki bedzie w SQL
    private Date hireDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name = "department_id", nullable = false, foreignKey=@ForeignKey(name = "Fk_department_id"))
    private Department department;

    public Worker() {
    }

    public Worker(String first_name, String last_name, int age, Department department) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.age = age;
        this.department = department;
    }

}
