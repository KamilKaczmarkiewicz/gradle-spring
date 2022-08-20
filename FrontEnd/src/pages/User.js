import axios from 'axios'

const getUser = () => {
    axios.get(`http://localhost:8080/users/1`)
      .then(res => {
        console.log(res.data);
      })
}

const User = () => {
    return (
        <div>
            <h1>User</h1>
            <button onClick={getUser}>click me</button>
        </div>
    )
  };
  
  export default User;