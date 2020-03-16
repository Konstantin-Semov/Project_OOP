import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator = "US")
    @SequenceGenerator(name="US", sequenceName="User_Seq", allocationSize=1)
    private long user_id;

    @Column(name = "USER_NAME")
    private String user_name;

    @Column(name = "USER_PHONE")
    private String user_phone;

    @Column(name = "USER_USERNAME")
    private String user_username;

    @Column(name = "USER_PASS")
    private String user_pass;

    @ManyToOne
    @JoinColumn(name = "USER_TYPE_ID")
    private User_Type user_type;

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    private Set<Rent_A_Car> rent_a_car;

    public User(){}
    public User(String user_name, String user_phone, String user_username, String user_pass, User_Type type)
    {
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_username = user_username;
        this.user_pass = user_pass;
        this.user_type = type;
    }

    public void setUser_id(long user_id) { this.user_id = user_id; }
    public void setUser_name(String user_name) { this.user_name = user_name; }
    public void setUser_phone(String user_phone){ this.user_phone = user_phone;}
    public void setUser_username(String user_username){this.user_username = user_username;}
    public void setUser_pass(String user_pass){this.user_pass = user_pass;}
    public void setUser_type(User_Type type){this.user_type = type;}
    public void setRent_a_car(Set<Rent_A_Car> rent){this.rent_a_car = rent;}

    public long getUser_id(){return this.user_id;}
    public String getUser_name(){return this.user_name;}
    public String getUser_phone(){return this.user_phone;}
    public String getUser_username(){return this.user_username;}
    public String getUser_pass(){return this.user_pass;}
    public User_Type getUser_type() { return user_type; }
    public Set<Rent_A_Car> getRent_a_car(){return rent_a_car;}
}





























