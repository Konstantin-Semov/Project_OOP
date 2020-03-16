import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER_TYPE")
public class User_Type {
    @Id
    @Column(name = "USER_TYPE_ID")
    @GeneratedValue(generator = "UTS")
    @SequenceGenerator(name="UTS", sequenceName="User_Type_Seq", allocationSize=1)
    private long user_type_id;
    @Column(name = "USER_TYPE")
    private String user_type;

    @OneToMany(mappedBy = "user_type", fetch = FetchType.LAZY)
    private static Set<User> user;

    public User_Type(){}
    public User_Type(String type){this.user_type = type;}

    public void setUser_type_id(long id){this.user_type_id = id;}
    public void setUser_type(String name){this.user_type = name;}
    public void setUser(Set<User> user){this.user = user;}

    public long getUser_type_id(){return this.user_type_id;}
    public String getUser_type(){return this.user_type;}
    public Set<User> getUser(){return this.user;}


}
