package pro.sky.employeeswithmap.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employeeswithmap.data.Employee;
import pro.sky.employeeswithmap.exception.DuplicateEmployeeException;
import pro.sky.employeeswithmap.exception.EmployeeNotFoundException;
import pro.sky.employeeswithmap.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employeeMap = new HashMap<>();

    public EmployeeServiceImpl() {
        addEmployee("Василий", "Иванович", "Чапаев");
        addEmployee("Семён", "Михайлович", "Будённый");
        addEmployee("Климент", "Ефремович", "Ворошилов");
    }

    @Override
    public Employee addEmployee(String firstName, String secondName, String lastName) {
        String key = getKeyString(firstName, secondName, lastName);
        if (!employeeMap.containsKey(key)) {
            Employee employee = new Employee(firstName, secondName, lastName);
            employeeMap.put(key, employee);
            return employee;
        }
        throw new DuplicateEmployeeException("Такой сотрудник уже есть.");
    }

    private String getKeyString(String firstName, String secondName, String lastName) {
        return firstName + '/' + secondName + '/' + lastName;

    }

    @Override
    public Employee getEmployee(String firstName, String secondName, String lastName) {
        String key = getKeyString(firstName, secondName, lastName);
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee removeEmployee(String firstName, String secondName, String lastName) {
        String key = getKeyString(firstName, secondName, lastName);
        if (employeeMap.containsKey(key)) {
            return employeeMap.remove(key);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

}
