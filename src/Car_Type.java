import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Car_Type")
public class Car_Type {
    @Id
    @Column(name = "CAR_TYPE_ID")
    @GeneratedValue(generator = "CTS")
    @SequenceGenerator(name = "CTS", sequenceName = "car_type_sequence", allocationSize = 1)
    private long car_type_id;
    @Column(name = "CAR_TYPE")
    private String car_type;

    @OneToMany(mappedBy = "car_type", fetch = FetchType.LAZY)
    private static Set<Cars> car;

    public Car_Type(){}
    public Car_Type(String name){ this.car_type = name; }

    public void setCar_type(String car_type) { this.car_type = car_type; }
    public void setCar_type_id(long car_type_id) {this.car_type_id = car_type_id; }
    public void set_Car(Set<Cars> car) {this.car = car; }

    public long getCar_type_id() {return this.car_type_id; }
    public String getCar_type(){return this.car_type;}
    public Set<Cars> get_Car(){return this.car; }

}
