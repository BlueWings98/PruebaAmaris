package Amaris.prueba;

import Amaris.prueba.Data.ApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ApiClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ApiClient apiClient;

    private final String mockEmployeeJson = "[{\"id\":\"1\", \"name\":\"Mock Employee\"}]";
    private final String mockEmployeeByIdJson = "{\"id\":\"1\", \"name\":\"Mock Employee\"}";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeesSuccess() {
        // Configuración (Arrange)
        when(restTemplate.getForObject("https://hub.dummyapis.com/employee", String.class))
                .thenReturn(mockEmployeeJson);

        // Acción (Act)
        String result = apiClient.getEmployees();

        // Verificación (Assert)
        assertEquals(mockEmployeeJson, result);
        verify(restTemplate, times(1)).getForObject("https://hub.dummyapis.com/employee", String.class);
    }

    @Test
    void testGetEmployeesException() {
        // Configuración (Arrange)
        when(restTemplate.getForObject("https://hub.dummyapis.com/employee", String.class))
                .thenThrow(new RuntimeException("Simulated Exception"));

        // Acción (Act)
        String result = apiClient.getEmployees();

        // Verificación (Assert)
        assertEquals(apiClient.getMockedEmployees(), result);
    }

    @Test
    void testGetEmployeesByIdSuccess() {
        // Configuración (Arrange)
        when(restTemplate.getForObject("https://hub.dummyapis.com/employee/1", String.class))
                .thenReturn(mockEmployeeByIdJson);

        // Acción (Act)
        String result = apiClient.getEmployeesById("1");

        // Verificación (Assert)
        assertEquals(mockEmployeeByIdJson, result);
        verify(restTemplate, times(1)).getForObject("https://hub.dummyapis.com/employee/1", String.class);
    }

    @Test
    void testGetEmployeesByIdException() {
        // Configuración (Arrange)
        when(restTemplate.getForObject("https://hub.dummyapis.com/employee/1001", String.class))
                .thenThrow(new RuntimeException("Simulated Exception"));

        // Acción (Act)
        String result = apiClient.getEmployeesById("1001");

        // Verificación (Assert)
        assertEquals(apiClient.getMockedEmployeesById("1001"), result);
    }
}
