package pl.sda.jpa.dao;

import pl.sda.jpa.model.Department;
import pl.sda.jpa.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DepartmentDaoImpl {
    private final EntityManager entityManager = HibernateUtil.getInstance().getEntityManager();

    public void add(String departmentName) {
        Department department = new Department(departmentName);
        HibernateUtil.getInstance().save(department);
    }

    public List<Department> list() {
        return entityManager.createQuery("Select d from Department d").getResultList();
    }

    public void delete(int id) {
        Department department = entityManager.find(Department.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(department);
        entityManager.getTransaction().commit();
    }


}
