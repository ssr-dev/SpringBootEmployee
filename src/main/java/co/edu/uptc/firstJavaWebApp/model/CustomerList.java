package co.edu.uptc.firstJavaWebApp.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {
    private List<Customer> customerList;

    public CustomerList(){
        this.customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public Customer findCustomerById(int id) {
        for (Customer emp : customerList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null; 
    }

    public boolean modifyCustomer(Customer changeCustomer) {
        Customer existingCustomer = findCustomerById(changeCustomer.getId());
        if (existingCustomer != null) {
            existingCustomer.setName(changeCustomer.getName());
            existingCustomer.setEmail(changeCustomer.getEmail());
            existingCustomer.setAddress(changeCustomer.getAddress());
            return true;
        }
        return false;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public boolean deleteCustomer(int id) {
        Customer customer = findCustomerById(id);
        if (customer != null) {
            customerList.remove(customer);
            return true;
        }
        return false;
    }
    public boolean isIdAvailable(int id) {
        for (Customer emp : customerList) {
            if (emp.getId() == id) {
            return false;
            }
        }
        return true;
    }
    
}
