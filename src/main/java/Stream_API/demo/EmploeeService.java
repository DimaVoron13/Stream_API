package Stream_API.demo;

import java.util.Set;
import java.util.Collection;

public interface EmploeeService {

    Emploee maxSalary(Integer salary);

    Emploee minSalary(Integer salary);

    Set findEmploees(Integer depId);

    Set eploeesInDepartment(Integer departament);

    Set allEmploees();
}
