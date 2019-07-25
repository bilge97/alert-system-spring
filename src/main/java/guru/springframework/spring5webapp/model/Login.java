package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="username")
    private String username;

    @NotNull
    @Column(name="password")
    private String password;

    //@OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    //@JoinColumn(name = "login_id")
    //private Set<Alert> alertSet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //public Set<Alert> getAlertSet() {
    //    return alertSet;
    //}

    //public void setAlertSet(Set<Alert> alertSet) {
    //    this.alertSet = alertSet;
    //}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Login login = (Login) obj;
        return Objects.equals(id, login.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Login"+"{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
