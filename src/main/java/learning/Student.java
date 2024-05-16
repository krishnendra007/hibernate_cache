package learning;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


//import jakarta.persistence.OneToOne;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Student {
    @Id
    private int rollno;
    private String name;
    private int marks;

    //@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
    @OneToMany(mappedBy="student")
    private Collection<Laptop> laptop = new ArrayList<>();

    public Collection<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(Collection<Laptop> laptop) {
        this.laptop = laptop;
    }
    
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

}
