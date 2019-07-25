package guru.springframework.spring5webapp.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="alert")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="url")
    private String url;

    @NotEmpty
    @NotNull
    @Column(name="method")
    private String method;

    @NotNull
    @Min(2l)
    @Column(name="period")
    private Long period;

    @Column(name="login_id")
    private Long login_id;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "resp_id")
    private Set<Response> responseSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }

    public Set<Response> getResponse() {
        return responseSet;
    }

    public void setResponse(Set<Response> responseSet) {
        this.responseSet = responseSet;
    }

    public Alert() {
    }

    public Alert(@NotNull String name, @NotNull String url, @NotNull String method , @NotNull @Min(2l) Long period ) {
        this.name = name;
        this.url = url;
        this.method = method;
        this.period = period;


    }

    public Alert(@NotNull String name, @NotNull String url, @NotNull String method , @NotNull @Min(2l) Long period ,Long login_id) {
        this.name = name;
        this.url = url;
        this.method = method;
        this.period = period;
        this.login_id = login_id;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alert alert = (Alert) obj;
        return Objects.equals(id, alert.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Alert" +
                "{" + "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", period=" + period +
                ", response=" + responseSet +
                '}';
    }
}
