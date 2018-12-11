package graduation.choosecafe.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity{

    @Column(name = "name")
    @Size(max = 100)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    public User() {
    }

    public User(@Size(max = 100) String name, @Email @NotBlank @Size(max = 100) String email, @NotBlank @Size(min = 5, max = 100) String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(Integer id, @Size(max = 100) String name, @Email @NotBlank @Size(max = 100) String email, @NotBlank @Size(min = 5, max = 100) String password, Role... role) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(User user)
    {
        super(user.id);
        this.name = user.name;
        this.email = user.email;
        this.password = user.password;
        this.roles = user.roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", id=" + id +
                '}';
    }
}
