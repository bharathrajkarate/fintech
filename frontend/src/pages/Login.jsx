import { useState } from "react";

export default function Login() {

    fetch("http://localhost:8089/BBBkjdsfkjijijoieur_eriisdjf88_i8eewr898", {
          method: "GET",
          credentials: "include",
      });

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

    const handleLogin = async () => {

      let flag=true;

      if(username == ""){
        alert("Please Enter The User Name");
        flag=false;
      }else if(password == ""){
        alert("Please Enter The Password");
        flag=false;
      }

      if(flag == true){
        try{
        const response = await fetch("http://localhost:8089/login", {
          method: "POST",
          credentials: "include",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            username: username,
            password: password
          })
        });

         if (response.ok) {
            location.href = "/dashboard";
          } else {
            alert("Username or password incorrect");
          }
          
        } catch (error) {
          alert(error);
        }
        

        //  fetch("http://localhost:8089/logout_page", {
        //   method: "GET",
        //   credentials: "include",
        // });
        
      }
    };

  return (
<div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth px-0">
          <div class="row w-100 mx-0">
            <div class="col-lg-4 mx-auto" style={{boxShadow: "20px 20px 200px 10px grey"}} >
              <div class="auth-form-light text-left py-5 px-4 px-sm-5">
                <div class="brand-logo" style={{textAlign:'center',marginBottom:'15px'}}>
                  <img style={{width:'80px',height:'80px'}} src="/src/assets/images/hft_logo_symbol.png" alt="logo" />
                </div>
                <h3 class="font-weight-light" style={{margin:'auto',width:'fit-content'}} >HandFinTech Login</h3>
                <form class="pt-3">
                  <div class="form-group">
                    <input type="text" class="form-control form-control-lg" id="user_name" value={username} onChange={(e) => setUsername(e.target.value.trim())} placeholder="Username" />
                  </div>
                  <div class="form-group">
                    <input type="password" class="form-control form-control-lg" id="user_password" value={password} onChange={(e) => setPassword(e.target.value.trim())}placeholder="Password" />
                  </div>
                  <div class="mt-3 d-grid gap-2">
                    <a class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" onClick={handleLogin} >Login</a>
                  </div>
                   <div class="mb-4">
                    <div class="form-check" style={{textAlign:'center'}}>
                      <a href="/terms_and_conditions" >Terms & Conditions</a>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}