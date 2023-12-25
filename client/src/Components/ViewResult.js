import React from "react";
import { useSelector } from "react-redux";
import { useLocation } from "react-router-dom";
export default () => {
    const { state } = useLocation();
    var data = state;
    console.log(data)
    const { userInfo } = useSelector((state) => state.authReducer);

    return (

        <>
            <div className="container card shadow mt-5 p-3" style={{ width: "40%" }}>
                <h1 class="text-center fst-italic mb-5 form-heading">Your Result</h1>
                <h4 className="fst-italic"><b>Student Name:</b> {userInfo?.user.name}</h4>
                <h4 className="fst-italic"><b>Quize Name:</b> {data?.quize.name}</h4>
                <h4 className="fst-italic"><b>Marks:</b> {data?.finalscore}</h4>

            </div>
        </>
    )
}