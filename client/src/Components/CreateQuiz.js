import React, { useState } from "react";
import { createQuiz } from "../Actions/commmonActions";
import { useSelector } from "react-redux";

export default () => {
    const { userInfo } = useSelector((state) => state.authReducer);

    const [quize, setquize] = useState({
        name: "",
        markspq: "",
        time: "",
        isstarted: "false"
    })

    var manageQuize = (e) => {
        setquize({ ...quize, [e.target.name]: e.target.value })
    }
    var storeQuize = async (e) => {
        e.preventDefault();
        console.log(quize)
        // var user = JSON.parse(localStorage.getItem("user"))
        try {

            var res = await createQuiz(quize, userInfo.user.teacher.tid)
            console.log(res);
        }
        catch (e) {
            console.log(e);
        }
    }
    return (<>
        <div class="container  card p-3 form-box" style={{
            width: "50%"
        }} >
            <h1 class="text-center fst-italic mb-5 form-heading">Create Quiz</h1>
            <form ac >

                <div class=" input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">

                        <i class="fa-solid fa-magnifying-glass"></i>
                    </span>

                    <input onChange={manageQuize} type="text" name="name" placeholder="Enter name of quize" class="form-control" />

                </div>



                <div class=" input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">

                        <i class="fa-solid fa-check"></i>
                    </span>

                    <input onChange={manageQuize} type="number" name="markspq" placeholder="Enter marks of each question" class="form-control" />

                </div>

                <div class=" input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">

                        <i class="fa-solid fa-clock"></i>
                    </span>

                    <input onChange={manageQuize} type="number" name="time" placeholder="Enter duration of quize in min" class="form-control" />

                </div>






                <div class="text-center">
                    <button onClick={storeQuize} class="btn text-white my-btn"
                        style={{
                            marginRight: "1vw",
                            backgroundColor: "black"
                        }}
                    >Submit</button>
                    <button type="reset" class="btn btn-secondary text-white my-btn">Reset</button>

                </div>
            </form>


        </div>
    </>)
}