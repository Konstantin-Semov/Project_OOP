import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CAR_CLASS")
public class Car_Class {
    @Id
    @Column(name = "CAR_CLASS_ID", nullable = false, updatable = false)
    @GeneratedValue(generator = "CCS")
    @SequenceGenerator(name="CCS", sequenceName="Car_Class_Seq", allocationSize=1)
    private long car_class_id;
    @Column(name = "CAR_CLASS")
    private String car_class;

    @OneToMany(mappedBy = "car_class", fetch = FetchType.LAZY)
    private static Set<Cars> car;

    public Car_Class(){}
    public Car_Class(String name){this.car_class = name;}

    public void setCar_class(String car_class) {this.car_class = car_class; }
    public void setCar_class_id(long car_class_id) {this.car_class_id = car_class_id; }
    public void set_Car(Set<Cars> car) {this.car = car;}

    public long getCar_class_id() {return car_class_id;}
    public String getCar_class() {return car_class; }
    public Set<Cars> get_Car(){return this.car;}
}
