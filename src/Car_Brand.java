import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "CAR_BRAND")
public class Car_Brand {
    @Id
    @Column(name = "CAR_BRAND_ID", nullable = false, updatable = false)
    @GeneratedValue(generator = "CBS")
    @SequenceGenerator(name="CBS", sequenceName="Car_Brand_Seq", allocationSize=1)
    private long car_brand_id;
    @Column(name ="car_brand_name")
    private String car_brand_name;

    @OneToMany(mappedBy = "car_brand", fetch = FetchType.LAZY)
    private static Set<Car_Model> model;


    public Car_Brand(){}
    public Car_Brand(String name){this.car_brand_name = name;}

    public void setCar_brand_id(long id){this.car_brand_id = id;}
    public void setCar_brand_name(String name){this.car_brand_name = name;}
    public void setModels(Set<Car_Model> model) {this.model = model;}

    public Set<Car_Model> getModels(){return this.model;}
    public long getCar_brand_id(){return this.car_brand_id;}
    public String getCar_brand_name(){return this.car_brand_name;}

}
