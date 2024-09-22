package Stream_API.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/departments")
public class EmploeeController {
    EmploeeService serv = new EmploeeServiceImpl();

    @GetMapping(path = "/departments/max-salary")
    public String maxSalary(@RequestParam("departmentId") Integer depId) {
        return "Наибольшая з/п в отделе #" + depId + " у сотрудника: " + serv.maxSalary(depId).toString();
    }

    @GetMapping(path = "/departments/min-salary")
    public String minSalary(@RequestParam("departmentId") Integer depId) {
        return "Наименьшая з/п в отделе #" + depId + " у сотрудника: " + serv.minSalary(depId).toString();
    }

    @GetMapping(path = "/departments/all")
    public String findEmploees(@RequestParam(value = "departmentId", required = false) Integer depId) {
        return serv.findEmploees(depId).toString();
    }
}
