package co.edu.uptc.firstJavaWebApp.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
        private List<Employee> employeeList;

        public EmployeeList(){
            this.employeeList = new ArrayList<>();
        }
        public void addEmployee(Employee employee){
            employeeList.add(employee);
        }
        
        public Employee findEmployeeById(int id) {
            for (Employee emp : employeeList) {
                if (emp.getId() == id) {
                    return emp;
                }
            }
            return null; 
        }

        public boolean modifyEmployee(Employee changeEmployee) {
            Employee existingEmployee = findEmployeeById(changeEmployee.getId());
            if (existingEmployee != null) {
                existingEmployee.setName(changeEmployee.getName());
                existingEmployee.setEmail(changeEmployee.getEmail());
                existingEmployee.setPhone(changeEmployee.getPhone());
                return true;
            }
            return false;
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public boolean deleteEmployee(int id) {
            Employee employee = findEmployeeById(id);
            if (employee != null) {
                employeeList.remove(employee);
                return true;
            }
            return false;
        }
    public boolean isIdAvailable(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return false;
            }
        }
        return true;
    }
        
        public void setEmployeeList(List<Employee> employeeList) {
            this.employeeList = employeeList;
        }
}
