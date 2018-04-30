package com.agenda.demo.Repository;
import com.agenda.demo.Interfaces.IStudentRepository;
import com.agenda.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Student get(int id) {
        String sql = "select * from Students where studentId = " + id;

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();

        Student student = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5));

        return student;
    }

    @Override
    public List<Student> get() {

        List<Student> students = new ArrayList<>();
        String sql = "select * from Students";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while(rs.next())
        {
            students.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5)));
        }

        return students;
    }

    @Override
    public void create(Student st) {
        String sql = "insert into Students(firstName,lastName,enrollmentDate,cpr) " +
                "values('" + st.getFirstName() + "', '" +
                st.getLastName() + "', '" +
                st.getDateString() + "', " +
                st.getCpr() + ")";
        System.out.println(sql);
        int rowsAffected = jdbc.update(sql);
        System.out.println("Rows affected: " + rowsAffected);

    }
    @Override
    public void delete(Student st) {
        String sql = "Delete from Students where studentId =" +st.getStudentId();

        jdbc.update(sql);
    }

    @Override
    public void update(Student st)
    {
        // The one
        String sql = "Update Students set "  +
                "firstName='" + st.getFirstName() + "', " +
                "lastName='" + st.getLastName() + "', " +
                "enrollmentDate='" + st.getDateString() + "', " +
                "cpr=" + st.getCpr() + " WHERE studentId = " + st.getStudentId() + ";";
        System.out.println(sql);
        jdbc.update(sql);

    }


}
