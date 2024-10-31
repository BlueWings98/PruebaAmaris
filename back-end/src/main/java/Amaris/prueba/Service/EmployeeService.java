package Amaris.prueba.Service;

import Amaris.prueba.Data.ApiClient;
import Amaris.prueba.Model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    private final ApiClient apiClient;

    @Autowired
    public EmployeeService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String getEmployees() throws JsonProcessingException {
        String response = apiClient.getEmployees();
        Employee[] employees = Employee.fromJson(response);
        return Employee.toJsonArray(employees);
    }
    public String getEmployeesById(String id) throws JsonProcessingException {
        String response = apiClient.getEmployeesById(id);
        Employee[] employees = Employee.fromJson(response);
        return Employee.toJsonArray(employees);
    }
    public String getEmployeesFixed() throws JsonProcessingException {
        String response = apiClient.getMockedEmployees();
        Employee[] employees = Employee.fromJson(response);
        return Employee.toJsonArray(employees);

    }
    public String getEmployeesFixedById(String id) throws JsonProcessingException {
        String response = apiClient.getMockedEmployeesById(id);
        Employee[] employees = Employee.fromJson(response);
        return Employee.toJsonArray(employees);
    }

}
