package Amaris.prueba.Controller;

import Amaris.prueba.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public String getEmployeesBroken() {
        JSONObject jsonObject = new JSONObject();
        try {
            return employeeService.getEmployees();
        } catch (JsonProcessingException e) {
            jsonObject.put("error", "Hubo un error procesando la solicitud");
            return jsonObject.toString();
        }
    }
    @GetMapping("id")
    public String getEmployeesBrokenById(@RequestParam("id") String id)  {
        JSONObject jsonObject = new JSONObject();
        try {
            return employeeService.getEmployeesById(id);
        } catch (JsonProcessingException e) {
            jsonObject.put("error", "Hubo un error procesando la solicitud");
            return jsonObject.toString();
        }
    }
    @GetMapping("/fixed")
    public String getEmployeesFixed() throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject();
        return employeeService.getEmployeesFixed();
    }
    @GetMapping("/fixed/id")
    public String getEmployeesFixedById(@RequestParam("id") String id) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject();
        return employeeService.getEmployeesFixedById(id);
    }
}
