package vn.edu.uit.giangtnm.lab03_5.model;

/**
 * Created by giangtnm on 2/3/18.
 */

public class Student {

    private int id = -1;
    private String name = "";
    private String className = "";

    public Student() {
    }

    public Student(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public Student(int id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
