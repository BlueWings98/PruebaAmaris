"use client";
import { useState } from 'react';
import axios from 'axios';
import { Container, Navbar, Form, Button, Table, Image } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function Home() {
  const [employeeId, setEmployeeId] = useState('');
  const [employees, setEmployees] = useState([]);

  // Función para calcular el salario anual
  const calculateAnnualSalary = (salary) => salary * 12;

  // Función para manejar la búsqueda de empleados
  const handleSearch = async () => {
    try {
      const endpoint = employeeId
        ? `http://localhost:8080/employee/id?id=${employeeId}`
        : 'http://localhost:8080/employee';

      const response = await axios.get(endpoint);
      const data = Array.isArray(response.data) ? response.data : [response.data];
      
      // Agregar el salario anual calculado a cada empleado
      const employeesWithAnnualSalary = data.map(emp => ({
        ...emp,
        annualSalary: calculateAnnualSalary(emp.salary)
      }));

      setEmployees(employeesWithAnnualSalary);
    } catch (error) {
      console.error('Error fetching employees:', error);
    }
  };

  return (
    <Container fluid style={{ backgroundColor: '#f4f6f9', padding: '20px' }}>
    {/* Menú de navegación */}
    <Navbar bg="dark" variant="dark" className="mb-4 p-3">
      <Navbar.Brand href="/">
        <Image
          src="/brand-image.jpg"
          alt="Brand Logo"
          width="50"
          height="50"
          className="d-inline-block align-top me-3"
        />
        <span style={{ color: '#fff', fontSize: '1.5em' }}>Aplicacion Busqueda de Empleado</span>
      </Navbar.Brand>
    </Navbar>

    {/* Formulario de búsqueda */}
    <Form className="d-flex mb-4">
      <Form.Control
        type="text"
        placeholder="Digita en ID de empleado"
        value={employeeId}
        onChange={(e) => setEmployeeId(e.target.value)}
        className="me-2"
      />
      <Button variant="primary" onClick={handleSearch} className="ms-2">
        Buscar
      </Button>
    </Form>

    {/* Tabla de resultados */}
    <Table striped bordered hover className="table-bordered" style={{ border: '2px solid black' }}>
      <thead style={{ backgroundColor: '#343a40', color: 'white' }}>
        <tr>
          <th>ID</th>
          <th>Image</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Contact Number</th>
          <th>Age</th>
          <th>DOB</th>
          <th>Salary</th>
          <th>Annual Salary</th>
          <th>Address</th>
        </tr>
      </thead>
      <tbody>
        {employees.map((employee) => (
          <tr key={employee.id} style={{ border: '1px solid black' }}>
            <td>{employee.id}</td>
            <td>
              <Image src={employee.imageUrl} alt="Employee Image" width="50" height="50" rounded />
            </td>
            <td>{employee.firstName}</td>
            <td>{employee.lastName}</td>
            <td>{employee.email}</td>
            <td>{employee.contactNumber}</td>
            <td>{employee.age}</td>
            <td>{employee.dob}</td>
            <td>{employee.salary}</td>
            <td>{employee.annualSalary.toFixed(2)}</td>
            <td>{employee.address}</td>
          </tr>
        ))}
      </tbody>
    </Table>
  </Container>
  );
}
