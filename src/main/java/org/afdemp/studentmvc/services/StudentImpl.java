/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.studentmvc.services;

import java.util.List;
import org.afdemp.studentmvc.dao.StudentDaoImpl;
import org.afdemp.studentmvc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mac
 */
@Service("studentService")
@Transactional
public class StudentImpl implements IStudent {

    @Autowired
    StudentDaoImpl dao;

    @Override
    public List<Student> findAllStudents() {
        List<Student> students = dao.findAllStudents();
        return students;
    }

    public void saveStudent(Student student) {
        dao.saveStudent(student);
    }

    public Student findStudentById(Integer id) {
        return dao.findStudentById(id);
    }

    public void updateStudent(Student student) {
        Student entity = dao.findById(student.getId());
        if (entity != null) {
            System.out.print("************************ NOT NULL *****************************");
            entity.setFirstName(student.getFirstName());
            entity.setLastName(student.getLastName());
            entity.setDateOfBirth(student.getDateOfBirth());
            entity.setTuitionFees(student.getTuitionFees());
        }
    }
    
    public Student findById(int id) {
		return dao.findById(id);
	}

    public void deleteStudentById(Integer id) {
        dao.deleteStudentById(id);
    }

}
