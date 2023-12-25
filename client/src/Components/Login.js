import React, { useContext, useState } from "react";
import { login } from "../Actions/commmonActions";
import { loginapi } from "../API/studentAPI";
import { useNavigate } from "react-router-dom";
import { loginUser, signInUser } from "../Redux/actions/authAction";
import { useDispatch } from "react-redux";
export default () => {
    const dispatch = useDispatch();

    const navigate = useNavigate()
    const [user, setuser] = useState({
        username: "",
        password: ""
    })
    var updateUserDetail = (e) => {
        var updatedUserInfo = { ...user };
        updatedUserInfo[e.target.name] = e.target.value;
        setuser(updatedUserInfo);
    }
    var loginU = (e) => {
        e.preventDefault();
        try {
            // var res;
            var res = dispatch(loginUser(user, navigate));
            console.log(res);

            var token = res.data["token"];

            // console.log(res)

        }
        catch (e) {
            console.log(e)
        }
    }
    return (
        <>
            <div class="container  card p-3 form-box shadow" style={{
                width: "50%"
            }} >
                <h1 class="text-center fst-italic mb-5 form-heading">Login</h1>
                <form ac >

                    <div class=" input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">

                            <i class="fa-solid fa-envelope"></i>
                        </span>

                        <input type="email" onChange={updateUserDetail} name="username" placeholder="Enter your  email" class="form-control" />

                    </div>

                    <div class=" input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">

                            <i class="fa-solid fa-key"></i>
                        </span>

                        <input type="password" onChange={updateUserDetail} name="password" placeholder="Enter your password" class="form-control" />

                    </div>






                    <div class="text-center">
                        <button onClick={loginU} class="btn text-white my-btn"
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