
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "RENT_A_CAR")
public class Rent_A_Car {
    @Id
    @Column(name = "RENT_ID")
    @GeneratedValue(generator = "RACS")
    @SequenceGenerator(name="RACS", sequenceName="Rent_A_Car_Seq", allocationSize=1)
    private long rent_id;

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Cars car_id;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Clients client_id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "RENT_FROM")
    private Date rent_from;

    @Temporal(TemporalType.DATE)
    @Column(name = "RENT_TO")
    private Date rent_to;

    @Column(name = "RENT_PRICE")
    private BigDecimal rent_price;

    @Column(name = "RENT_DISCOUNT")
    private BigDecimal rent_discount;

    @ManyToOne
    @JoinColumn(name = "CONDITION_FIRST_DAY")
    private Car_Condition first_day;

    @ManyToOne
    @JoinColumn(name = "CONDITION_LAST_DAY")
    private Car_Condition last_day;

    @Column(name = "DAYS_RENTED")
    private int days_rented;

    public Rent_A_Car(){}
    public Rent_A_Car(Cars car, Clients client, User userr, Date rent_from, Date rent_to, BigDecimal price, BigDecimal discount,
                      Car_Condition fday, Car_Condition lday, int days_rented)
    {
        this.car_id = car;
        this.user_id = userr;
        this.client_id = client;
        this.rent_from = rent_from;
        this.rent_to = rent_to;
        this.rent_price = price;
        this.rent_discount = discount;
        this.first_day = fday;
        this.last_day = lday;
        this.days_rented = days_rented;
    }

    public void setRent_id(long id){this.rent_id = id;}
    public void setCar(Cars car){this.car_id = car;}
    public void setClient(Clients client){this.client_id = client;}
    public void setUser(User userr){this.user_id = userr;}
    public void setRent_from(Date from){this.rent_from = from;}
    public void setRent_to(Date to){this.rent_to = to;}
    public void setRent_price(BigDecimal price){this.rent_price = price;}
    public void setRent_discount(BigDecimal disc){this.rent_discount = disc;}
    public void setFirst_day(Car_Condition fday){this.first_day = fday;}
    public void setLast_day(Car_Condition lday){this.last_day = lday;}
    public void setDays_rented(int rented){this.days_rented = rented;}

    public long getRent() { return rent_id; }
    public Cars getCar() { return car_id; }
    public Clients getClient(){return client_id;}
    public User getUser(){return user_id;}
    public Date getRent_from(){return rent_from;}
    public Date getRent_to(){return rent_to;}
    public BigDecimal getRent_price(){return rent_price;}
    public BigDecimal getRent_discount(){return rent_discount;}
    public Car_Condition getFirst_day(){return first_day;}
    public Car_Condition getLast_day(){return last_day;}
    public int getDays_rented(){return days_rented;}
}
