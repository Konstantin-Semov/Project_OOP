import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Clients")
public class Clients {
    @Id
    @Column(name = "CLIENT_ID")
    @GeneratedValue(generator = "CliS")
    @SequenceGenerator(name="CliS", sequenceName="Clients_Seq", allocationSize=1)
    private long client_id;

    @Column(name = "NAME")
    private String client_name;

    @Column(name = "PERSONAL_IDN")
    private long personal_idn;

    @Column(name = "PHONE")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "RISK_ID")
    Risk_Assessment risk;

    @OneToMany(mappedBy = "client_id", fetch = FetchType.LAZY)
    private static Set<Rent_A_Car> rent_a_car;

    public Clients(){}
    public Clients(String name, long idn, String phone, Risk_Assessment risk)
    {
        this.client_name = name;
        this.personal_idn = idn;
        this.phone = phone;
        this.risk = risk;
    }

    public void setClient_name(String name){this.client_name = name;}
    public void setPersonal_idn(long personal_idn) { this.personal_idn = personal_idn; }
    public void setPhone(String phone){this.phone = phone;}
    public void setRisk(Risk_Assessment risk){this.risk = risk;}
    public void setClient_id(long id){this.client_id = id;}
    public void setRent_a_car(Set<Rent_A_Car> rent){this.rent_a_car = rent;}

    public String getClient_name(){return this.client_name;}
    public String getPhone(){return this.phone;}
    public long getPersonal_idn() { return personal_idn; }
    public long getClient_id() { return client_id; }
    public Risk_Assessment getRisk(){return this.risk;}
    public Set<Rent_A_Car> getRent_a_car(){return rent_a_car;}
}
