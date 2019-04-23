import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {


  static   SessionFactory sessionFactory;
  static   Session session;
    static Scanner in ;
    public static void main(String[] args) {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class).addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentDetail.class)
                .addAnnotatedClass(Course.class).buildSessionFactory();

        in = new Scanner(System.in);
        System.out.println("Welcome to Hibernate CLI App");
        System.out.println("Please select one of following options");

        menu();
    }
    public static void menu(){
        int option;
        System.out.println(" 1 : Teacher \n 2: Student \n 3: Course \n 4: Assign Course to Teacher \n 5: Enroll Student Into Course");
        option = in.nextInt();
        switch (option){
            case 1:
                System.out.println("You are in Teachers's menu");
                System.out.println("Please select one of following options");
                System.out.println(" 1: Add Teacher \n 2: Update Teacher \n 3: Delete Teacher \n 4: Teacher Courses");
                option = in.nextInt();
                switch (option){
                    case 1:
                        saveTeacher();
                        break;
                    case 2:
                        updateTeacher();
                        break;
                    case 3:
                        deleteTeacher();
                        break;
                    case 4:
                        getTeacherCourses();
                        break;

                }
                break;
            case 2:
                System.out.println("You are in Student's menu");

                System.out.println("Please select one of following options");
                System.out.println(" 1: Add Student /n 2: Update Student /n 3: Delete Student /n 4: get student courses");
                option = in.nextInt();
                switch (option){
                    case 1:
                        saveStudent();

                        break;
                    case 2:
                        updateStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        getStudentCourses();
                        break;

                }
                break;
            case 3:
                System.out.println("You are in Courses's menu");

                System.out.println("Please select one of following options");
                System.out.println(" 1: Add Course \n 2: Update Course \n 3: Delete Course \n 4: Back");
                option = in.nextInt();
                switch (option){
                    case 1:
                        saveCourse();
                        break;
                    case 2:
                        updateCourse();
                        break;
                    case 3:
                        deleteCourse();
                        break;
                    case 4:

                        break;

                }

                break;

            case 4:
                System.out.println(
                        "Assigning Course to Teacher"
                        +"The Teacher and Course must be added before assigning "
                );

                int techerId;
                int courseId;

                session = sessionFactory.getCurrentSession();
                session.beginTransaction();

                System.out.println("Enter Teacher Id");
                techerId= in.nextInt();

                System.out.println("Enter Course Id");
                courseId=in.nextInt();

                Teacher teacher = session.get(Teacher.class,techerId);
                Course course = session.get(Course.class,courseId);

                teacher.addCourse(course);

                session.getTransaction().commit();
                menu();
                break;

            case 5:

                int studentId;
                int cId;

                session = sessionFactory.getCurrentSession();
                session.beginTransaction();

                System.out.println("Enter Student Id");
               studentId= in.nextInt();

                System.out.println("Enter Course Id");
                cId=in.nextInt();

                Student s  = session.get(Student.class,studentId);
                Course c = session.get(Course.class,cId);

                c.addStudent(s);
                session.getTransaction().commit();
                menu();
                break;

        }

    }

    public static void saveTeacher(){
        String firstName;
        String lastName;
        String designation;
        String email;

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Enter Teacher Details");
        System.out.println("First Name:");
        firstName= in.nextLine();
        firstName= in.nextLine();
        System.out.println("Last Name:");
        lastName=in.nextLine();
        System.out.println("Designation:");
        designation=in.nextLine();
        System.out.println("Email:");
        email=in.nextLine();

        Teacher teacher = new Teacher(firstName,lastName);
        TeacherDetail teacherDetail=new TeacherDetail(designation,email);
        teacher.setDetail_id(teacherDetail);
        System.out.println("Trying to add teacher");
        session.save(teacher);
        session.getTransaction().commit();
        System.out.println("Teacher added successfully");
        menu();
    }

    public static void updateTeacher(){

    }

    public static void deleteTeacher(){

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        int id;
        System.out.println("Enter Teacher id you want to delete");
        id=in.nextInt();
        Teacher teacher = session.get(Teacher.class,id);
        System.out.println("Trying to delete teacher");
        System.out.println("Deleting teacher will  also delete teacher's details");
        session.delete(teacher);
        session.getTransaction().commit();
    }

    public static void saveStudent(){

        String firstName;
        String lastName;
        String fatherName;
        String email;

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Enter Student Details");
        System.out.println("First Name:");
        firstName= in.nextLine();
        firstName= in.nextLine();
        System.out.println("Last Name:");
        lastName=in.nextLine();
        System.out.println("Father Name:");
        fatherName=in.nextLine();
        System.out.println("Email:");
        email=in.nextLine();

        Student student = new Student(firstName,lastName);
        StudentDetail studentDetail=new StudentDetail(fatherName,email);
        student.setDetail_id(studentDetail);
        System.out.println("Trying to add student");
        session.save(student);
        session.getTransaction().commit();
        System.out.println("student added successfully");
        menu();



    }

    public static void updateStudent(){

    }

    public static void deleteStudent(){

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        int id;
        System.out.println("Enter Teacher id you want to delete");
        id=in.nextInt();
        Student student = session.get(Student.class,id);
        System.out.println("Trying to delete student");
        System.out.println("Deleting student will  also delete student's details");
        session.delete(student);
        session.getTransaction().commit();

        menu();

    }

    public static void saveCourse(){

        String name;
        String code;

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Enter Course Details");
        System.out.println("Name:");
        name= in.nextLine();
        name= in.nextLine();
        System.out.println("Code:");
        code=in.nextLine();

        Course course = new Course(name,code);
        System.out.println("Trying to add course");
        session.save(course);
        session.getTransaction().commit();
        System.out.println("course added successfully");
        menu();

    }
    public static void updateCourse(){

        int id;
        String name;
        String code;

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Enter Course id you want to update");
        id=in.nextInt();

        Course course= session.get(Course.class,id);

        System.out.println("Enter updated Course Details");
        System.out.println("Name:");
        name= in.nextLine();
        name= in.nextLine();
        System.out.println("Code:");
        code=in.nextLine();


        course.setCode(code);
        course.setName(name);

        session.getTransaction().commit();
        System.out.println("Updated");
        menu();

    }

    public static void deleteCourse(){


        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        int id;
        System.out.println("Enter Course id you want to delete");
        id=in.nextInt();
        Course course = session.get(Course.class,id);
        System.out.println("Trying to delete course");
        session.delete(course);
        session.getTransaction().commit();
        menu();
    }


    public static void getTeacherCourses(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        int id;
        System.out.println("Displaying Teacher Curses");
        System.out.println("Please enter teacher Id");
        id=in.nextInt();
        System.out.println(id);
        Teacher teacher =session.get(Teacher.class,id);
        List<Course> courseList =teacher.getCourses();
        System.out.println(courseList);
        session.getTransaction().commit();
        menu();
    }

    public static void getStudentCourses(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        int id;
        System.out.println("Displaying Student Curses");
        System.out.println("Please enter student Id");
        id=in.nextInt();
        Student  student =session.get(Student.class,id);
        List<Course> courseList =student.getCourses();
        System.out.println(courseList);
        session.getTransaction().commit();
        menu();
    }


}