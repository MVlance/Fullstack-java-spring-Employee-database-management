package java_resources.controller;

import java_resources.entity.Employee;
import java_resources.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    public EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(@ModelAttribute("employee") Employee employee, Model model) {

        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", employees);
        model.addAttribute("employee", new Employee());


        return "allEmployees";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "addEmployee";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, Model model) {

        model.addAttribute("employee", employee);

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);


        return "employeeInfo";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(employee.getId());

        return "redirect:/";
    }

}