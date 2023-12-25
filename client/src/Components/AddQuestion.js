import React, { useEffect, useState } from "react";
import '../App.css';
import { addQuestion, updateQuizeQuestion } from "../Actions/commmonActions";
import { useLocation, useParams, useNavigate } from "react-router-dom";
export default () => {

    const [questionDetaiils, setQuestionDetails] = useState({
        question: "",
        option1: "",
        option2: "",
        option3: "",
        option4: "",
        correctOption: ""
    });
    const { state } = useLocation();
    var currentQuestion = state;
    var { updatequizeid } = useParams();
    const navigate = useNavigate();
    useEffect(() => {
        if (currentQuestion) {
            setQuestionDetails(currentQuestion)
        }
        console.log(state)
    }, [])
    var { quizeid } = useParams()

    // console.log(quizeid)

    var updateQuestion = (e) => {
        setQuestionDetails({ ...questionDetaiils, [e.target.name]: e.target.value })
    }
    var storeQuestion = async (e) => {
        e.preventDefault();
        try {
            if (currentQuestion) {
                var res = await updateQuizeQuestion(questionDetaiils, currentQuestion.quid)
                console.log(res)
                navigate(`/manage-questions/${updatequizeid}`)
            }
            else {
                var res = await addQuestion(questionDetaiils, quizeid)
                console.log(res)
            }
            // console.log(res)
        }
        catch (e) {
            console.log(e);
        }
    }
    return (
        <>

            <div className="container card p-4 shadow mt-5" style={{ width: "60%" }}>
                <h1 class="text-center fst-italic mb-5 form-heading">{currentQuestion ? "Update Question" : "Add Question"}</h1>
                <form>
                    <div class="form-group">
                        <input type="text" value={questionDetaiils.question} onChange={updateQuestion} name="question" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Question" />
                    </div>
                    <div className="row  option-box">
                        {/* <div className="col"> */}

                        <div class="form-group col-6 my-4">
                            <label for="exampleInputPassword1">Option1</label>

                            <input value={questionDetaiils.option1} onChange={updateQuestion} type="text" name="option1" class="form-control" id="exampleInputPassword1" placeholder="Enter op1" />
                        </div>
                        <div class="form-group col-6 my-4">
                            <label for="exampleInputPassword1">Option2</label>
                            <input value={questionDetaiils.option2} onChange={updateQuestion} type="text" name="option2" class="form-control" id="exampleInputPassword1" placeholder="Enter op2" />
                        </div>
                        {/* </div> */}
                        {/* <div> */}
                        <div class="form-group col-6 my-1" >
                            <label for="exampleInputPassword1">Option3</label>
                            <input value={questionDetaiils.option3} onChange={updateQuestion} type="text" name="option3" class="form-control" id="exampleInputPassword1" placeholder="Enter op3" />
                        </div>
                        <div class="form-group col-6 my-1">
                            <label for="exampleInputPassword1">Option4</label>
                            <input value={questionDetaiils.option4} onChange={updateQuestion} type="text" name="option4" class="form-control" id="exampleInputPassword1" placeholder="Enter op4" />
                        </div>
                    </div>
                    {/* </div> */}
                    <div class=" input-group my-2">
                        <select name="correctOption" value={questionDetaiils.correctOption} onChange={updateQuestion} class="custom-select form-control" id="inputGroupSelect01">
                            <option selected>Choose correct option number</option>
                            <option value="op1">1</option>
                            <option value="op2">2</option>
                            <option value="op3">3</option>
                            <option value="op4">4</option>

                        </select>

                    </div>
                    <div className="d-flex" style={{ justifyContent: "end" }}>
                        <button onClick={storeQuestion} class="btn btn-dark mt-2">
                            {currentQuestion ? "Update" : "Add"}

                        </button>
                    </div>
                </form>
            </div>

        </>
    )
}