package com.cit360.week09;
import java.util.*;

public class RunEmployee {
    public static void main(String[] args) {
        ConnectDB t = ConnectDB.getInstance();
        List<EmployeeEntity> emp = t.getEmployees();
        for (EmployeeEntity i : emp) {
            System.out.println(i); //You can call the individual columns
        }
        System.out.println(t.getCustomer(1));
    }
}
