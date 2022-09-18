
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
    axios.get(`http://localhost:8080/users/me`, 
    {withCredentials: true}
    )
      .then(res => {
        console.log(res.data);
      })
}

const loginbtn = () => (
    <form method="post" action="http://localhost:8080/login">
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
            </ul>
        </nav>
    )
}

export default Navbar