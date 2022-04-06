import React, { useState, useEffect } from 'react';
import logo from './logo.svg';
import axios from 'axios';



function Employee() {
  const [useEmployees, setUseEmployees] = useState<any[]>([]);

  const Employees = () => {
    const fetchEmployees = async () => {
      const res = await axios.get('http://localhost:8080/api/v1/employee/');
      setUseEmployees(res.data);
    }

    fetchEmployees()
  }

  const deleteEmployee = (employee: any) => {
    const deleteEmployeeAsync = async () => {
      const res = await axios.delete(`http://localhost:8080/api/v1/employee/${employee.id}`);
      setUseEmployees(res.data);
    }
    
    deleteEmployeeAsync()
  }

  useEffect(() => {
    Employees();
  }, [useEmployees])

  return (
    <div>
      <p>Map project</p>
      <div>
        {useEmployees.map((employee, indx) => (
          <div className="goal" key={indx}>
            <h1>{employee.name}</h1>
            <p>Hours worked: {employee.hours}</p>
            <p>Brief description: {employee.project}</p>
            <button onClick={() => {
              deleteEmployee(employee)
            }}>Delete employee</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Employee;