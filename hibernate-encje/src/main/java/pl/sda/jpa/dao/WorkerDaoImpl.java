package pl.sda.jpa.dao;

import pl.sda.jpa.model.Department;
import pl.sda.jpa.model.Worker;
import pl.sda.jpa.util.HibernateUtil;

public class WorkerDaoImpl {

    public void add(String firstName, String lastName, int age, int departmentId) {
        Department department = HibernateUtil.getInstance().getEntityManager().find(Department.class, departmentId);
        HibernateUtil.getInstance().save(new Worker(firstName, lastName, age, department));
    }


}
