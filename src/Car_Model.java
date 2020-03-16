import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CAR_MODEL")
public class Car_Model {
    @Id
    @Column(name = "CAR_MODEL_ID")
    @GeneratedValue(generator = "CMS")
    @SequenceGenerator(name="CMS", sequenceName="Car_Model_Seq", allocationSize=1)
    private long car_model_id;
    @Column(name = "car_model_name")
    private String car_model_name;

    @ManyToOne
    @JoinColumn(name = "CAR_MODEL_BRAND_ID")
    private Car_Brand car_brand;
    @ManyToOne
    @JoinColumn(name = "CAR_MODEL_FUEL_TYPE_ID")
    private Fuel_Type fuel_type;

    @OneToMany(mappedBy = "car_model", fetch = FetchType.LAZY)
    private static Set<Cars> cars;


    public Car_Model(){}
    public Car_Model(String name, Car_Brand car_brand, Fuel_Type fuel_type)
    {
        this.car_model_name = name;
        this.car_brand = car_brand;
        this.fuel_type = fuel_type;
    }

    public void setCar_brand_id(Car_Brand car_brand) {
        this.car_brand = car_brand;
    }
    public void setFuel_type_id(Fuel_Type fuel_type) {
        this.fuel_type = fuel_type;
    }
    public void setCars(Set<Cars> car){this.cars = car;}
    public void setCar_model_id(long id){this.car_model_id = id;}
    public void setCar_model_name(String name){this.car_model_name = name;}


    public long getCar_model_id(){return this.car_model_id;}
    public String getCar_model_name(){return this.car_model_name;}
    public Set<Cars> getCars(){return this.cars;}
    public Car_Brand getCar_brand_id(Car_Brand brand){return this.car_brand;}
    public Fuel_Type getFuel_type_id() {
        return this.fuel_type;
    }



}
