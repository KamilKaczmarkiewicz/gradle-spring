
import './Navbar.css';
import { Link } from 'react-router-dom';
import axios from 'axios'
import Cookies from 'js-cookie';

const logout = () => {
    axios.post(`http://localhost:8080/logout`, 
    {withCredentials: true, crossdomain: true}
    )
}

const Navbar = () => {

    return (
        <nav className="nav">
            <Link to="/" className="site-title">
                Nice Game
            </Link>
            <ul>
                <li><Link to="/login">LogIn</Link></li>
                <li><Link to="/user">User</Link></li>  
                <li><Link to="/">LogOut</Link></li>  
                <button onClick={logout}>LogOut</button>
            </ul>
        </nav>
    )
}

export default Navbar