package pl.sda.jpa;

import pl.sda.jpa.dao.DepartmentDaoImpl;
import pl.sda.jpa.dao.WorkerDaoImpl;
import pl.sda.jpa.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil instance = HibernateUtil.getInstance();
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
        departmentDao.add("Java" );
        departmentDao.add("C++" );
        departmentDao.add("NET" );
        departmentDao.add("Ruby" );

        WorkerDaoImpl workerDao = new WorkerDaoImpl();
        workerDao.add("Paweł", "Citko", 33, 1);
        workerDao.add("Rafał", "Kosmo", 23, 2);

       // departmentDao.delete(2);


        instance.close();
    }
}
