package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Department> list;

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: Department findById =====");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: Department findAll =====");
        list = departmentDao.findAll();
        list.forEach(System.out::println);


        System.out.println("\n=== TEST 3: Department insert =====");
        Department newDep = new Department(null, "Food");
        departmentDao.insert(newDep);
        System.out.println( "Inserted! new id = " + newDep.getId());

        System.out.println("\n=== TEST 4: seller update =====");
        dep = departmentDao.findById(6);
        dep.setName("Jewels");
        departmentDao.update(dep);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: seller delete =====");
        System.out.print("Enter id for delete test: ");
        departmentDao.deleteById(sc.nextInt());
        System.out.println("Delete completed");

        sc.close();
        DB.closeConnection();


    }
}
