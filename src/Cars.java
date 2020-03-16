import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CARS")
public class Cars {
    @Id
    @Column(name = "CAR_ID")
    @GeneratedValue(generator = "CS")
    @SequenceGenerator(name="CS", sequenceName="Cars_Seq", allocationSize=1)
    private long car_id;
    @Column(name = "CAR_SMOKE")
    private int car_smoke;
    @Column(name = "CAR_AVAILABILITY")
    private int car_availability;

    @ManyToOne
    @JoinColumn(name = "CAR_CLASS_ID")
    private Car_Class car_class;

    @ManyToOne
    @JoinColumn(name = "CAR_TYPE_ID")
    private Car_Type car_type;

    @ManyToOne
    @JoinColumn(name = "CAR_MODEL_ID")
    private Car_Model car_model;

    @OneToMany(mappedBy = "car_id", fetch = FetchType.LAZY)
    private Set<Rent_A_Car> rent_a_car;

    public Cars(){}
    public Cars(Car_Class car_class, Car_Type type, Car_Model model, int smoke, int avail)
    {
        this.car_class = car_class;
        this.car_type = type;
        this.car_model = model;
        this.car_smoke = smoke;
        this.car_availability = avail;
    }

    public void setCar_class(Car_Class car_class) { this.car_class = car_class; }
    public void setCar_type(Car_Type car_type) { this.car_type = car_type; }
    public void setCar_model(Car_Model car_model) {this.car_model = car_model; }
    public void setCar_availability(int a){this.car_availability = a;}
    public void setCar_id(long car_id) { this.car_id = car_id; }
    public void setCar_smoke(int a){this.car_smoke = a;}
    public void setRent_a_car(Set<Rent_A_Car> rent){this.rent_a_car = rent;}

    public Car_Model getCar_model(){return this.car_model;}
    public Car_Type getCar_type(){return this.car_type;}
    public Car_Class getCar_class(){return this.car_class;}
    public int getCar_availability() { return car_availability; }
    public long getCar_id() { return car_id; }
    public int getCar_smoke() { return car_smoke; }
    public Set<Rent_A_Car> getRent_a_car(){return this.rent_a_car;}
}
