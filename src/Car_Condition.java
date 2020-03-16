import javax.net.ssl.CertPathTrustManagerParameters;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CAR_CONDITION")
public class Car_Condition {
    @Id
    @Column(name = "CAR_CONDITION_ID")
    @GeneratedValue(generator = "CD")
    @SequenceGenerator(name="CD", sequenceName="Car_Condition_Seq", allocationSize=1)
    private long car_condition_id;

    @Column(name = "CAR_CONDITION")
    private String car_condition;

    @OneToMany(mappedBy = "first_day", fetch = FetchType.LAZY)
    private static Set<Rent_A_Car> rent_first_day;

    @OneToMany(mappedBy = "last_day", fetch = FetchType.LAZY)
    private static Set<Rent_A_Car> rent_last_day;

    public Car_Condition(){}
    public Car_Condition(String cond){this.car_condition = cond;}

    public void setCar_condition_id(long id){this.car_condition_id = id;}
    public void setCar_condition(String cond){this.car_condition = cond;}
    public void setRent_fist_day(Set<Rent_A_Car> fday){this.rent_first_day = fday;}
    public void setRent_last_day(Set<Rent_A_Car> lday){this.rent_last_day = lday;}

    public long getCar_condition_id(){return this.car_condition_id;}
    public String getCar_condition(){return this.car_condition;}
    public Set<Rent_A_Car> getRent_first_day(){return this.rent_first_day;}
    public Set<Rent_A_Car> getRent_last_day(){return this.rent_last_day;}


}
