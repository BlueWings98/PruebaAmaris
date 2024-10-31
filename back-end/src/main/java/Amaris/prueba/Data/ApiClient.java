package Amaris.prueba.Data;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.NoSuchElementException;

@Service
public class ApiClient {
    private final RestTemplate restTemplate;
    private final String Endpoint = "https://hub.dummyapis.com/employee";

    @Autowired
    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getEmployees() {
        try {
            return restTemplate.getForObject(Endpoint, String.class);
        } catch (Exception e) {
            System.out.println("Se generó una excepción. Se devolverá un JSON mockeado");
            return getMockedEmployees();
        }
    }

    public String getEmployeesById(String id) {
        try {
            return restTemplate.getForObject(Endpoint + "/" + id, String.class);
        } catch (Exception e) {
            System.out.println("Se generó una excepción. Se devolverá un JSON mockeado");
            return getMockedEmployeesById(id);
        }
    }

    public String getMockedEmployees() {
        // Devuelve todos los empleados mockeados
        return mockedEmployees.toString();
    }

    public String getMockedEmployeesById(String id) {
        // Devuelve un empleado específico de los datos mockeados
        for (int i = 0; i < mockedEmployees.length(); i++) {
            JSONObject employee = mockedEmployees.getJSONObject(i);
            if (employee.getInt("id") == Integer.parseInt(id)) {
                return new JSONArray("[" + employee + "]").toString();
            }
        }
        throw new NoSuchElementException("Employee not found");
    }

    private final JSONArray mockedEmployees = new JSONArray(
            " [ {\n" +
            "    \"id\": 1001,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=TF&height=120&width=120\",\n" +
            "    \"firstName\": \"Teresa\",\n" +
            "    \"lastName\": \"Frami\",\n" +
            "    \"email\": \"Teresa.Frami@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4066695871\",\n" +
            "    \"age\": 72,\n" +
            "    \"dob\": \"30/12/1952\",\n" +
            "    \"salary\": 1.0,\n" +
            "    \"address\": \"Address1\"\n" +
            "  },\n" +
            "  {\n" +
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
            "  },\n" +
            "  {\n" +
            "    \"id\": 1003,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=DB&height=120&width=120\",\n" +
            "    \"firstName\": \"Dwight\",\n" +
            "    \"lastName\": \"Beatty\",\n" +
            "    \"email\": \"Dwight.Beatty@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4681194697\",\n" +
            "    \"age\": 25,\n" +
            "    \"dob\": \"16/05/1999\",\n" +
            "    \"salary\": 3.0,\n" +
            "    \"address\": \"Address3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 1004,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=JR&height=120&width=120\",\n" +
            "    \"firstName\": \"Jaden\",\n" +
            "    \"lastName\": \"Reinger\",\n" +
            "    \"email\": \"Jaden.Reinger@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4243699379\",\n" +
            "    \"age\": 59,\n" +
            "    \"dob\": \"10/03/1965\",\n" +
            "    \"salary\": 4.0,\n" +
            "    \"address\": \"Address4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 1005,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=JS&height=120&width=120\",\n" +
            "    \"firstName\": \"Jaclyn\",\n" +
            "    \"lastName\": \"Schamberger\",\n" +
            "    \"email\": \"Jaclyn.Schamberger@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4420096226\",\n" +
            "    \"age\": 47,\n" +
            "    \"dob\": \"04/11/1977\",\n" +
            "    \"salary\": 5.0,\n" +
            "    \"address\": \"Address5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 1006,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=EH&height=120&width=120\",\n" +
            "    \"firstName\": \"Eve\",\n" +
            "    \"lastName\": \"Heathcote\",\n" +
            "    \"email\": \"Eve.Heathcote@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4676391312\",\n" +
            "    \"age\": 70,\n" +
            "    \"dob\": \"22/10/1954\",\n" +
            "    \"salary\": 6.0,\n" +
            "    \"address\": \"Address6\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 1007,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=AL&height=120&width=120\",\n" +
            "    \"firstName\": \"Adella\",\n" +
            "    \"lastName\": \"Lesch\",\n" +
            "    \"email\": \"Adella.Lesch@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4702293891\",\n" +
            "    \"age\": 52,\n" +
            "    \"dob\": \"21/11/1972\",\n" +
            "    \"salary\": 7.0,\n" +
            "    \"address\": \"Address7\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 1008,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=JK&height=120&width=120\",\n" +
            "    \"firstName\": \"Jeanie\",\n" +
            "    \"lastName\": \"Keebler\",\n" +
            "    \"email\": \"Jeanie.Keebler@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4390991333\",\n" +
            "    \"age\": 89,\n" +
            "    \"dob\": \"21/12/1935\",\n" +
            "    \"salary\": 8.0,\n" +
            "    \"address\": \"Address8\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 1009,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=EL&height=120&width=120\",\n" +
            "    \"firstName\": \"Eladio\",\n" +
            "    \"lastName\": \"Lesch\",\n" +
            "    \"email\": \"Eladio.Lesch@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4237199247\",\n" +
            "    \"age\": 31,\n" +
            "    \"dob\": \"14/12/1993\",\n" +
            "    \"salary\": 9.0,\n" +
            "    \"address\": \"Address9\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 1010,\n" +
            "    \"imageUrl\": \"https://hub.dummyapis.com/Image?text=SB&height=120&width=120\",\n" +
            "    \"firstName\": \"Suzanne\",\n" +
            "    \"lastName\": \"Balistreri\",\n" +
            "    \"email\": \"Suzanne.Balistreri@dummyapis.com\",\n" +
            "    \"contactNumber\": \"4849797067\",\n" +
            "    \"age\": 69,\n" +
            "    \"dob\": \"30/03/1955\",\n" +
            "    \"salary\": 10.0,\n" +
            "    \"address\": \"Address10\"\n" +
            "  }\n" +
            "]");


}
