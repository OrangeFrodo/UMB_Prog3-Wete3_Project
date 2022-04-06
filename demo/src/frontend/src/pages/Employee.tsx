import React, { useState, useEffect } from 'react';
import logo from './logo.svg';
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
    <div>
      <p>Notes for project</p>
      <div>
        {employees.map(employee => (
          <div className="goal">
            <h1>{employee.name}</h1>
            <p>Hours worked: {employee.hours}</p>
            <p>Brief description: {employee.project}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Employee;