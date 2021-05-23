package com.wccijam5.javapersistenceapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Resource
    private EmployeeRepository employeeRepo;

    @Resource
    private AddressRepository addressRepo;

    @Resource
    private ProjectRepository projectRepo;


    @GetMapping("/employees")
    public String displayEmployees(Model model){
        model.addAttribute("employeesModel", employeeRepo.findAll());
        return "employeesView";
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String street,
                              @RequestParam String city,
                              @RequestParam String state,
                              @RequestParam String county
                              ){
        Address addressToAdd = new Address(street, city, state, county);
        addressRepo.save(addressToAdd);
        employeeRepo.save(new Employee(firstName, lastName, addressToAdd));
        return "redirect:/employees/";
    }

    @GetMapping("/projects")
    public String displayProjects(Model model){
        model.addAttribute("projectsModel", projectsRepo.findAll());
        return "projectsView";
    }


}
