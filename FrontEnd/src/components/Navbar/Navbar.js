
import './Navbar.css';
import { Link } from 'react-router-dom';
import axios from 'axios'
import Cookies from 'js-cookie';

const logout = () => {
    axios.post(`http://localhost:8080/logout`, 
    {withCredentials: true, crossdomain: true}
    )
}
const test = () => {
    axios.get(`http://localhost:8080/users/my-name`, 
    {withCredentials: true}
    )
      .then(res => {
        console.log(res.data);
      })
}

const loginbtn = () => (
    <form method="post" action="http://localhost:8080/login">
    <p>
    <label for="username" class="sr-only">Username</label>
    <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus=""/>
    </p>
    <p>
    <label for="password" class="sr-only">Password</label>
    <input type="password" id="password" name="password" class="form-control" placeholder="Password" required=""/>
    </p>
    <button type="submit">LogIn</button>
    </form>
)
const logoutbtn = () => (
    <a href='http://localhost:8080/logout'><button onClick={logout}>LogOut</button></a>
)

const Navbar = () => {

    return (
        <nav className="nav">
            <Link to="/" className="site-title">
                Nice Game
            </Link>
            <ul>
                <li><button onClick={test}>TEST</button></li>
                <li>{loginbtn()}</li>
                <li>{logoutbtn()}</li>
                <li><Link to="/user">User</Link></li>  
                <li><Link to="/register">Register</Link></li>  
            </ul>
        </nav>
    )
}

export default Navbar