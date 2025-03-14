package com.zdybel.spring.mvc_hibernate_aop.controller;

import com.zdybel.spring.mvc_hibernate_aop.entity.Employee;
import com.zdybel.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Controller
public class MyController {

//    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();

//        logger.info("Liczba pracowników: " + allEmployees.size());
//        for (Employee emp : allEmployees) {
//            logger.info("Pracownik: " + emp.getName() + " " + emp.getSurname());
//        }

        model.addAttribute("allEmps", allEmployees);
        return "all-employees";  // Upewnij się, że masz odpowiedni widok (all-employees.jsp lub all-employees.html)
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){

        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            System.out.println("Błąd: Pracownik o ID " + id + " nie istnieje!");
            return "error-page"; // Możesz przekierować do strony błędu
        }

        model.addAttribute("employee", employee);

        return"employee-info";
    }
}
