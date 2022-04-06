import React, { useState } from 'react'

function EmployeeForm() {
    const [employee, setEmployee] = useState("")
    const [hours, setHours] = useState("")
    const [project, setProject] = useState("")

    // On submit function
    const onSubmit = (e: any) => {
        e.preventDefault();

        fetch('http://localhost:8080/api/v1/employee/', {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                name: employee,
                hours: hours,
                project: project
            })
        })

        // Clean
        setEmployee("")
        setHours("")
        setProject("")
    }

    return (
        <section className='form'>
            <form onSubmit={onSubmit}>
                <div className="form-group">
                    <label htmlFor="text">Employee</label>
                    <input
                        type="text"
                        name='text'
                        id="text"
                        value={employee}
                        onChange={(e) => setEmployee(e.target.value)}
                    />
                    <label htmlFor="text">Hours worked</label>
                    <input
                        type="text"
                        name='hours'
                        id="hours"
                        value={hours}
                        onChange={(e) => setHours(e.target.value)}
                    />
                    <label htmlFor="text">Bried description</label>
                    <input
                        type="text"
                        name='project'
                        id="project"
                        value={project}
                        onChange={(e) => setProject(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <button
                        className="btn btn-block"
                        type='submit'>
                        Add employee
                    </button>
                </div>
            </form>
        </section>
    )
}

export default EmployeeForm