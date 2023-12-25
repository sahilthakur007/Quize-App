import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { deleteQuestion, getQuestionForQuize } from "../Actions/commmonActions";

export default () => {
    const navigate = useNavigate();
    const { quizeid } = useParams()
    const [questions, setQuestion] = useState([])

    useEffect(() => {
        var loadQuestions = async () => {
            var res = await getQuestionForQuize(quizeid);
            console.log(res);
            setQuestion(res.data)
        }
        loadQuestions();
    }, [])


    var deleteQ = async (e) => {

        try {
            console.log(e.target.value)
            var res = await deleteQuestion(e.target.value);
            console.log(res);
            var newQuestions = questions.filter((question) => (question.quid != e.target.value))
            setQuestion(newQuestions)
        }
        catch (e) {
            console.log(e);
        }
    }
    var updateQ = (question) => {
        console.log(question)
    }
    return (<>
        <div className="container card shadow mt-3 p-3" style={{ width: "80%" }}>
            <h1 class="text-center fst-italic mb-5 form-heading">Manage Questions</h1>


            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Sr.No </th>
                        <th scope="col">Question</th>
                        <th scope="col">Option1</th>
                        <th scope="col">Option2</th>
                        <th scope="col">Option3</th>
                        <th scope="col">Option3</th>
                        <th scope="col">CorrectOption</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {questions && (questions.map((question, index) => (
                        <tr>
                            <th scope="row">{index + 1}.</th>
                            <td>{question.question}</td>
                            <td>{question.option1} </td>
                            <td>{question.option2}</td>
                            <td>{question.option3}</td>
                            <td>{question.option4}</td>
                            <td>{question.correctOption}</td>
                            <td>
                                <div className="d-flex">
                                    <button value={question.quid} onClick={deleteQ} className="btn btn-dark" style={{ marginRight: "4px" }}>

                                        Delete
                                    </button>
                                    <button value={question.quid} onClick={() => navigate(`/update-question/${quizeid}/${question.quid}`, { state: question })
                                    } className="btn btn-dark">
                                        Update
                                    </button>
                                </div>
                            </td>
                        </tr>
                    )))}
                </tbody>
            </table>

        </div>
    </>)
}