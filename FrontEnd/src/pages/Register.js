import React, { useState } from 'react'
import axios from 'axios'

const registerUser = () => {
    const body = 
    {
        "userName": "usernamekams",
        "firstName": "namekams",
        "lastName": "lastnamekams",
        "password": "pass123",
        "mail": "kams@wp.pl"
    }
    axios.post(`http://localhost:8080/users/register`, 
    body,
    {withCredentials: true}
    )
      .then(res => {
        console.log(res.data);
      })
}

const Register = () => {


    const [formData, setFormData] = useState({
        user_name: '',
        first_name: '',
        last_name: '',
        email: '',
        password: ''
    })

    const { user_name, first_name, last_name, email, password } = formData

    const onChange = (e) =>
        setFormData({ ...formData, [e.target.name]: e.target.value })

    const onSubmit = (e) => {
        e.preventDefault();
        console.log("rejestracja");
    }

    return (
        <div>
            <h1>Register</h1>
            <button onClick={registerUser}>Rejestracja TEST</button>
            <form onSubmit={(e) => onSubmit(e)}>
                    <div className="form-group">
                        <input
                            className="form-control"
                            type="text"
                            placeholder="Wpisz nazwę użytkownika"
                            name="user_name"
                            value={user_name}
                            onChange={(e) => onChange(e)}
                            required
                        />
                    </div>
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
                    <button className="common-button" type="submit">
                        Zarejestruj się
                    </button>
                </form>
        </div>
    )
  };
  
  export default Register;