import React, { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import { getAllQuizeByTeacher } from "../Actions/commmonActions";
import { useSelector } from "react-redux";
export default () => {
    const navigate = useNavigate();
    const [Quizes, setQuize] = useState([])
    const { userInfo } = useSelector((state) => state.authReducer);

    useEffect(() => {
        var loadQuiz = async () => {
            try {
                var user = JSON.parse(localStorage.getItem("user"))
                var res = await getAllQuizeByTeacher(userInfo.user.teacher.tid);
                // console.log(res);
                setQuize(res.data)
            }
            catch (e) {
                console.log(e);
            }
        }

        loadQuiz();
    }, [userInfo])
    var Quize = [
        {
            'qid': 1,
            'name': "Computer Networks and cryptography",
            'time': "10:00",
            'totalQuestions': 10,
            'marks': 20

        },

        {
            'qid': 2,
            'name': "High Performance Computing",
            'time': "10:00",
            'totalQuestions': 10,
            'marks': 20

        }
        ,
        {
            'qid': 1,
            'name': "Computer Networks and cryptography",
            'time': "10:00",
            'totalQuestions': 10,
            'marks': 20
        }
    ]
    return (
        <>
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
                        {Quizes && (Quizes.map((quize, index) => (
                            <tr>
                                <th scope="row">{index + 1}.</th>
                                <td>{quize.name}</td>
                                <td>{quize.time} </td>
                                <td>{quize.markspq}</td>
                                <td><button onClick={() => navigate("/single-quize", { state: quize })} className="btn btn-dark">Quize Setting</button></td>
                            </tr>
                        )))}
                    </tbody>
                </table>


            </div>
        </>
    )
}