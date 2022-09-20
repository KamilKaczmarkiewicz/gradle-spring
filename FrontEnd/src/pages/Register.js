import React, { useState } from 'react'
import axios from 'axios'

const getUser = () => {
    axios.get(`http://localhost:8080/users`, 
    {withCredentials: true}
    )
      .then(res => {
        console.log(res.data);
      })
}

const Register = () => {


    const [formData, setFormData] = useState({
        first_name: '',
        last_name: '',
        email: '',
        password: '',
        re_password: '',
    })

    const { first_name, last_name, email, password, re_password } = formData

    const onChange = (e) =>
        setFormData({ ...formData, [e.target.name]: e.target.value })

    const onSubmit = (e) => {
        e.preventDefault()

        if (password === re_password) {
            console.log("rejestracja")
        }
    }

    return (
        <div>
            <h1>Register</h1>
            <button onClick={getUser}>click me</button>
            <form onSubmit={(e) => onSubmit(e)}>
                    <div className="form-group">
                        <input
                            className="form-control"
                            type="text"
                            placeholder="Wpisz imię*"
                            name="first_name"
                            value={first_name}
                            onChange={(e) => onChange(e)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <input
                            className="form-control"
                            type="text"
                            placeholder="Wpisz nazwisko*"
                            name="last_name"
                            value={last_name}
                            onChange={(e) => onChange(e)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <input
                            className="form-control"
                            type="email"
                            placeholder="Wpisz adres email*"
                            name="email"
                            value={email}
                            onChange={(e) => onChange(e)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <input
                            className="form-control"
                            type="password"
                            placeholder="Wpisz hasło*"
                            name="password"
                            value={password}
                            onChange={(e) => onChange(e)}
                            minLength="6"
                            required
                        />
                    </div>
                    <div className="form-group">
                        <input
                            className="form-control"
                            type="password"
                            placeholder="Potwierdź hasło*"
                            name="re_password"
                            value={re_password}
                            onChange={(e) => onChange(e)}
                            minLength="6"
                            required
                        />
                    </div>
                    <button className="common-button" type="submit">
                        Zarejestruj się
                    </button>
                </form>
        </div>
    )
  };
  
  export default Register;