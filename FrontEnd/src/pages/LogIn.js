const LogIn = () => {
    return (
        <div>
            <form class="form-signin" method="post" action="http://localhost:8080/login">
                <h1 class="form-signin-heading">Please LogIn</h1>
                <p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus=""/>
                </p>
                <p>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required=""/>
                </p>
                <input name="_csrf" type="hidden" value="2d55fd3c-d70a-4a14-aa49-d0b02e5cd52d"/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
        </div>
    )
  };
  
  export default LogIn;