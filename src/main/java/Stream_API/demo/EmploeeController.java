package Stream_API.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/departments")
public class EmploeeController {
    EmploeeService serv = new EmploeeServiceImpl();

    public void init() {
        Set<Emploee> emploee = new HashSet<>();
        EmploeeServiceImpl.emploeesAbOvo();
    }

    @GetMapping("/max-salary")
    public String maxSalary(@RequestParam("departmentId") Integer depId) {
        return "Наибольшая з/п в отделе #" + depId + " у сотрудника: " + serv.maxSalary(depId).toString();
    }

    @GetMapping("min-salary")
    public String minSalary(@RequestParam("departmentId") Integer depId) {
        return "Наименьшая з/п в отделе #" + depId + " у сотрудника: " + serv.minSalary(depId).toString();
    }

    @GetMapping("/all")
    public String findEmploees(@RequestParam(value = "departmentId", required = false) Integer depId) {
        return serv.findEmploees(depId).toString();
    }
}
