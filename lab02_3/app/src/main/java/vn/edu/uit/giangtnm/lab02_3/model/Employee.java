package vn.edu.uit.giangtnm.lab02_3.model;

/**
 * Created by giangtnm on 2/3/18.
 */

public abstract class Employee {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double tinhLuong();

    @Override
    public String toString() {
        //TODO Auto_generated method stub
        return this.id + " - " + this.name;
    }
}
