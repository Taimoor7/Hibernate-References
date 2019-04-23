import javax.persistence.*;

@Entity
@Table(name = "student_detail")
public class StudentDetail {


    public StudentDetail(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "email")
    private String email;

    public StudentDetail(String fatherName, String email) {
        this.fatherName = fatherName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", fatherName='" + fatherName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}