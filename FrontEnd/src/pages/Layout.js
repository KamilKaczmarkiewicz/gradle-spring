import { Outlet, Link } from "react-router-dom";
import Navbar from "../components/Navbar/Navbar";

const Layout = () => {
  return (
    <>
      <Navbar/>

      <Outlet />
      
      <footer>My nice footer :D</footer>
    </>
  )
};

export default Layout;