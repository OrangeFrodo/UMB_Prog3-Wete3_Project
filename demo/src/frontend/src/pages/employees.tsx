import React, { useState, useEffect } from 'react';
import logo from './logo.svg';
import './App.css';

import axios from 'axios';



function Employee() {
  const [employees, setEmployees] = useState<any[]>([]);

  const Employees = () => {
    const fetchEmployees = async () => {
      const res = await axios.get('http://localhost:8080/api/v1/employee/');
      setEmployees(res.data);
    }

    fetchEmployees()
  }

  // Get method call
  Employees();

  return (
    <div className="App">
      {employees.map(employee => (
        <div>
          <h1>{employee.name}</h1>
        </div>
      ))}
    </div>
  );
}

export default Employee;