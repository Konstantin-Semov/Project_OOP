import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RISK_ASSESSMENT")
public class Risk_Assessment {
    @Id
    @Column(name = "RISK_ID")
    @GeneratedValue(generator = "RAS")
    @SequenceGenerator(name="RAS", sequenceName="Risk_Seq", allocationSize=1)
    private long risk_id;

    @Column(name = "RISK_LEVEL")
    private String risk_level;

    @OneToMany(mappedBy = "risk", fetch = FetchType.LAZY)
    private Set<Clients> client;

    public Risk_Assessment(){}
    public Risk_Assessment(String risk){this.risk_level = risk;}

    public void setRisk_id(long risk_id) { this.risk_id = risk_id; }
    public void setRisk_level(String risk_level) { this.risk_level = risk_level; }
    public void setClient(Set<Clients> client){this.client = client;}

    public long getRisk_id() { return this.risk_id; }
    public String getRisk_level(){return this.risk_level;}
    public Set<Clients> getClient(){return this.client;}
}
