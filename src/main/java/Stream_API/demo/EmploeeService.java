package Stream_API.demo;

import java.util.Set;

public abstract class EmploeeService {

    abstract Emploee maxSalary(Integer salary);

    abstract Emploee minSalary(Integer salary);

    abstract Set findEmploees(Integer depId);

    abstract Set eploeesInDepartment(Integer departament);

    abstract Set allEmploees();
}
