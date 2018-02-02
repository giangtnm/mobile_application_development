package vn.edu.uit.giangtnm.lab02_3.model;

/**
 * Created by giangtnm on 2/3/18.
 */

public class EmployeeParttime extends Employee {

    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " --> PartTime = " + tinhLuong();
    }
}
