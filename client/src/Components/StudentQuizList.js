import React, { useEffect, useState } from "react";
import { getQuizeForStudent } from "../Actions/commmonActions";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";

export default () => {
    const [quizes, setQuize] = useState([])
    const navigate = useNavigate()
    const { userInfo } = useSelector((state) => state.authReducer);

    console.log(quizes)

    useEffect(() => {
        var loadQuize = async () => {
            try {
                var res = await getQuizeForStudent(userInfo
                    .user.student.sid, userInfo.user.uid);
                console.log(res);
                setQuize(res.data)
            }
            catch (e) {

            }
        }

        loadQuize();
    }, [userInfo])
    return (<>

        <div className="container card shadow mt-3 p-3" style={{ width: "60%" }}>
            <h1 class="text-center fst-italic mb-5 form-heading">Your Quize</h1>


            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Sr.No </th>
                        <th scope="col">Quize</th>
                        <th scope="col">Time(min)</th>
                        <th scope="col">Marks(per-question)</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {quizes && (quizes.map((quize, index) => (
                        <tr>
                            <th scope="row">{index + 1}.</th>
                            <td>{quize.name}</td>
                            <td>{quize.time} </td>
                            <td>{quize.markspq}</td>
                            <td><button onClick={() => navigate("/attempt-quize", { state: quize })} className="btn btn-dark">Atempt</button></td>
                        </tr>
                    )))}
                </tbody>
            </table>


        </div>

    </>)
}