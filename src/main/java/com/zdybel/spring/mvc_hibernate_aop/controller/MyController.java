package com.zdybel.spring.mvc_hibernate_aop.controller;

import com.zdybel.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.zdybel.spring.mvc_hibernate_aop.entity.Employee;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Controller
public class MyController {

//    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeDAO.getAllEmployees();

//        logger.info("Liczba pracowników: " + allEmployees.size());
//        for (Employee emp : allEmployees) {
//            logger.info("Pracownik: " + emp.getName() + " " + emp.getSurname());
//        }

        model.addAttribute("allEmps", allEmployees);
        return "new";  // Upewnij się, że masz odpowiedni widok (all-employees.jsp lub all-employees.html)
    }
}
