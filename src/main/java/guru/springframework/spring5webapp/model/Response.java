package guru.springframework.spring5webapp.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="response")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="id")
    private Long id;
    @Column(name="responsecode")
    private Integer responsecode;
    @Column(name = "resp_id")
    private Long resp_id;

    public Long getResp_id() {
        return resp_id;
    }

    public void setResp_id(Long resp_id) {
        this.resp_id = resp_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(Integer responsecode) {
        this.responsecode = responsecode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Response response = (Response) obj;
        return Objects.equals(id, response.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Response"+
                "{" + "id=" + id +
                ", responsecode=" + responsecode +
                ", resp_id=" + resp_id +
                '}';
    }
}
