import axios from 'axios'

const getUser = () => {
    axios.get(`http://localhost:8080/users`, 
    {withCredentials: true}
    )
      .then(res => {
        console.log(res.data);
      })
}

const Home = () => {
    return (
        <div>
            <h1>Home</h1>
            <button onClick={getUser}>click me</button>
        </div>
    )
  };
  
  export default Home;