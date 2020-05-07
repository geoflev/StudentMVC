/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.dao;

import java.util.List;
import org.afdemp.studentmvc.entities.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mac
 */
@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements IStudentDao {

    @Override
    public List<Student> findAllStudents() {
        Criteria criteria = createEntityCriteria();
        return (List<Student>) criteria.list();
    }

    public void saveStudent(Student student) {
        persist(student);
    }

    public Student findStudentById(Integer id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Student) criteria.uniqueResult();
    }

    public void updateStudent(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Student findById(int id) {
        return getByKey(id);
    }

    public void deleteStudentById(Integer id) {
        Query query = getSession().createSQLQuery("delete from students where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

}
