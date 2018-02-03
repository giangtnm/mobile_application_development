package vn.edu.uit.giangtnm.lab03_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import vn.edu.uit.giangtnm.lab03_5.helper.StudentDbHelper;
import vn.edu.uit.giangtnm.lab03_5.model.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View by id
        TextView tvStudents = (TextView) findViewById(R.id.tv_students);

        // Init database
        StudentDbHelper db = new StudentDbHelper(this);

        // Add students
        addStudents(db);

        // Update students
        updateStudents(db);

        // Show students
        showStudents(db, tvStudents);
    }

    private void addStudents(StudentDbHelper db) {
        db.insertStudent(new Student(1, "An", "MMTT2011"));
        db.insertStudent(new Student(2, "Bình", "MMTT2011"));
        db.insertStudent(new Student(3, "Châu", "MMTT2012"));
        db.insertStudent(new Student(4, "Dương", "MMTT2012"));
        db.insertStudent(new Student(5, "Hiển", "MMTT2013"));
        db.insertStudent(new Student(6, "Khánh", "MMTT2013"));
        db.insertStudent(new Student(7, "Linh", "MMTT2014"));
        db.insertStudent(new Student(8, "Minh", "MMTT2014"));
        db.insertStudent(new Student(9, "Nam", "MMTT2015"));
        db.insertStudent(new Student(10, "Phú", "MMTT2015"));
    }

    private void updateStudents(StudentDbHelper db) {
        db.updateStudent(new Student(3, "Ý", "ATTT2014"));
        db.updateStudent(new Student(5, "Phong", "ATTT2014"));
        db.updateStudent(new Student(7, "Hoàng", "ATTT2014"));
        db.updateStudent(new Student(9, "Nhi", "ATTT2014"));
    }

    private void showStudents(StudentDbHelper db, TextView tv) {
        List<Student> students = db.getAllStudents();
        String all = "Students: \n";

        for (Student student : students)
            all += student.getId() + " - " + student.getName()
                    + " - " + student.getClassName() + "\n";

        tv.setText(all);
    }
}
