package org.afdemp.studentmvc.controllers;

import java.util.List;
import javax.validation.Valid;
import org.afdemp.studentmvc.entities.Student;
import org.afdemp.studentmvc.services.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    IStudent studentService;
    
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listAllStudents(ModelMap view) {
        List<Student> students  = studentService.findAllStudents();
        view.addAttribute("students", students);
        return("studentlist");
    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newStudent(ModelMap view) {
        Student student = new Student();
        view.addAttribute("student", student);
        view.addAttribute("edit", false);
        return "newstudent";
    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveStudent(@Valid Student student, BindingResult result,
            ModelMap view) {
        
        if (result.hasErrors()) {
            return "newstudent";
        }
        studentService.saveStudent(student);

        view.addAttribute("success", "Student " + student.getFirstName() + " registered successfully");
        return "success";
    }
    
  @RequestMapping(value = {"/edit-{id}-student"}, method = RequestMethod.GET)
    public String editEmployee(@PathVariable Integer id, ModelMap model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("edit", true);
        return "newstudent";
    }
    
    @RequestMapping(value = {"/edit-{id}-student"}, method = RequestMethod.POST)
    public String updateEmployee(@Valid Student student, BindingResult result,
            ModelMap model, @PathVariable Integer id) {

        if (result.hasErrors()) {
            return "newstudent";
        }
        studentService.updateStudent(student);

        model.addAttribute("success", "Student " + student.getFirstName() + " updated successfully");
        return "success";
    }
    
    @RequestMapping(value = {"/delete-{id}-student"}, method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/list";
    }
    
    
}
