import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "FUEL_TYPE")
public class Fuel_Type {
    @Id
    @Column(name = "FUEL_TYPE_ID", updatable = false, nullable = false)
    @GeneratedValue(generator = "FTS")
    @SequenceGenerator(name="FTS", sequenceName="Fuel_Type_Seq", allocationSize=1)
    private long fuel_type_id;
    @Column(name = "fuel_type_name")
    private String fuel_type_name;

    @OneToMany(mappedBy = "fuel_type", fetch = FetchType.LAZY)
    private static Set<Car_Model> model;

    public Fuel_Type(){}

    public Fuel_Type(String name) { this.fuel_type_name = name; }

    public void setFuel_type_id(long id){this.fuel_type_id = id;}
    public void setModels(Set<Car_Model> model) {this.model = model;}
    public void setFuel_type_name(String name){this.fuel_type_name = name;}

    public Set<Car_Model> getModels(){ return this.model; }
    public long getFuel_type_id() { return fuel_type_id; }
    public String getFuel_type_name(){return this.fuel_type_name;}

}