package vn.edu.uit.giangtnm.lab02_3.model;

/**
 * Created by giangtnm on 2/3/18.
 */

public class EmployeeFulltime extends Employee {

    @Override
    public double tinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " --> FullTime = " + tinhLuong();
    }
}
