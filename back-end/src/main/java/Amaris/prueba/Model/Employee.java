package Amaris.prueba.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    /*
    Example JSON response:
            "    \"id\": 1002,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=GD&height=120&width=120\",\n" +
            "    \"firstName\": \"Gabriella\",\n" +
            "    \"lastName\": \"Dach\",\n" +
            "    \"email\": \"Gabriella.Dach@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4926895885\",\n" +
            "    \"age\": 76,\n" +
            "    \"dob\": \"26/12/1948\",\n" +
            "    \"salary\": 2.0,\n" +
            "    \"address\": \"Address2\"\n" +
     */
    private int id;
    private String imageUrl;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private int age;
    private String dob;
    private double salary;
    private String address;
    private double annualSalary;

    public static Employee[] fromJson(String response) throws JsonProcessingException {
        System.out.println("response: " + response);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parse JSON response to Employee array
            Employee[] employees = objectMapper.readValue(response, Employee[].class);

            // Calculate annual salary for each employee
            for (Employee employee : employees) {
                employee.setAnnualSalary(employee.calculateAnnualSalary(employee.getSalary()));
            }

            return employees;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new Employee[0]; // Return empty array in case of error
        }
    }
    public static String toJsonArray(Employee[] employees) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert the array of Employee objects to a JSON array string
            return objectMapper.writeValueAsString(employees);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "[]"; // Return an empty JSON array string in case of error
        }
    }
    private double calculateAnnualSalary(double monthlySalary) {
        return monthlySalary * 12;
    }
}
