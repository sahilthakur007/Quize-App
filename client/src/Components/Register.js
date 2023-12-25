import React, { useState } from "react";
import { register } from "../Actions/commmonActions";
import { registerapi } from "../API/studentAPI";
import { useNavigate } from "react-router-dom";
export default () => {
    const navigate = useNavigate();
    const [user, setuser] = useState({
        name: "",
        email: "",
        password: "",
        phone: "",
        role: "ROLE_STUDENT"
    })
    var updateUserDetail = (e) => {
        const updatedUserInfo = { ...user };
        updatedUserInfo[e.target.name] = e.target.value;
        setuser(updatedUserInfo);
    }
    var storeUser = async (e) => {
        e.preventDefault();
        console.log(user);
        // await register(user, navigate);
        try {
            var res = await register(user);
            console.log(res)
            // if(res.status==20)
            navigate("/login")

        }
        catch (e) {
            console.log(e.response.data)
        }
    }
    return (

        <>
            <div class="container  card p-3 form-box shadow" style={{
                width: "50%"
            }} >
                <h1 class="text-center fst-italic mb-5 form-heading">Register Yourself</h1>
                <form ac >
                    <div class=" input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">

                            <i class="fa-solid fa-user"></i>
                        </span>

                        <input type="text" onChange={updateUserDetail} name="name" placeholder="Enter your  name" class="form-control" />

                    </div>

                    <div class=" input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">

                            <i class="fa-solid fa-envelope"></i>
                        </span>

                        <input type="email" onChange={updateUserDetail} name="email" placeholder="Enter your  email" class="form-control" />

                    </div>

                    <div class=" input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">

                            <i class="fa-solid fa-lock"></i>
                        </span>

                        <input type="password" onChange={updateUserDetail} name="password" placeholder="Enter your password" class="form-control" />

                    </div>

                    <div class=" input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">

                            <i class="fa-solid fa-phone"></i>
                        </span>

                        <input type="text" onChange={updateUserDetail} name="phone" placeholder="Enter your  phone number" class="form-control" />

                    </div>

                    <div class=" input-group mb-3">


                        <span class="input-group-text" id="basic-addon1">

                            <i class="fa-solid fa-id-card-clip"></i>
                        </span>
                        <select name="role" onChange={updateUserDetail} class="custom-select form-control" id="inputGroupSelect01">
                            <option selected>Choose your role</option>
                            <option value="ROLE_TEACHER">Teacher</option>
                            <option value="ROLE_STUDENT">Student</option>
                        </select>

                    </div>


                    <div class="text-center">
                        <button onClick={storeUser} class="btn text-white my-btn"
                            style={{
                                marginRight: "1vw",
                                backgroundColor: "black"
                            }}
                        >Submit</button>
                        <button type="reset" class="btn btn-secondary text-white my-btn">Reset</button>

                    </div>
                </form>


            </div>
        </>
    )
}