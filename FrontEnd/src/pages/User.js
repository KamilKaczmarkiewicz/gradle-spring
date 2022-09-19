import axios from 'axios'
import React, { useState, useEffect } from 'react'
import SimpleField from '../components/Utils/SimpleField';


const User = () => {

  const [formData, setFormData] = useState({
    id: '',
    userName: '', 
    name: '',
    lastName: '', 
    characterDtos: '',
})

useEffect(
    () => {
      getUser()
    }, // eslint-disable-next-line
    []
)

const getUser = () => {
    axios.get(`http://localhost:8080/users/me`, 
    {withCredentials: true}
    )
      .then(res => {
        console.log(res.data);
        setFormData({ ...formData, 
          id: res.data.id,
          userName: res.data.userName,
          name: res.data.name,
          lastName: res.data.lastName,
          characterDtos: res.data.characterDtos.length })
      })
}

    return (
        <div className="container">
            <h1>User</h1>
            <SimpleField mykey="ID" myvalue={formData.id}/>
            <SimpleField mykey="userName" myvalue={formData.userName}/>
            <SimpleField mykey="1st name" myvalue={formData.name}/>
            <SimpleField mykey="last name" myvalue={formData.lastName}/>
            <SimpleField mykey="number of characters" myvalue={formData.characterDtos}/>
        </div>
    )
  };
  
  export default User;