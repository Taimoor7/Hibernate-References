import javax.persistence.*;

@Entity
@Table(name = "teacher_detail")
public class TeacherDetail {

    public TeacherDetail(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "email")
    private String email;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    @OneToOne(mappedBy = "detail_id",cascade = CascadeType.ALL)
    private Teacher teacher;




    public TeacherDetail(String designation, String email) {
        this.designation = designation;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
