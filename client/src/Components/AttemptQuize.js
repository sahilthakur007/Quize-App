import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { getQuestionForQuize, submitQuize } from "../Actions/commmonActions";
import { useSelector } from "react-redux";


export default () => {

    const { state } = useLocation();
    const [counter, setCounter] = useState(0)
    const [question, setQuestion] = useState([])
    const [score, setScore] = useState(0)
    const [selectedOption, setSelectedOption] = useState("")
    const [quize, setQuize] = useState(state)

    const [minute, setMinute] = useState(0);
    const [second, setSecond] = useState(0)
    const { userInfo } = useSelector((state) => state.authReducer);
    const navigate = useNavigate();
    var timer;
    useEffect(() => {
        timer = setInterval(() => {
            setSecond(second + 1);
            if (second == 59) {
                setMinute(minute + 1);
                setSecond(0)
            }

            if (minute == quize.time) {
                submitQ()
            }
        }, 1000)

        return () => clearInterval(timer)
    })
    useEffect(() => {
        console.log(quize)
        // setQuize(state)
        var loadQuestions = async () => {
            try {
                var res = await getQuestionForQuize(quize.qid)
                console.log(res.data);
                setQuestion(res.data);
            }
            catch (e) {
                console.log(e);
            }
        }
        // if (counter < 1) {
        loadQuestions();

        // }
    }, [])

    var handleNext = (e) => {
        e.preventDefault()

        console.log(selectedOption)
        if (question[counter].correctOption == selectedOption) {
            setScore(score + quize.markspq)
        }
        // var newcount = counter + 1;
        setCounter(counter + 1);


    }
    var submitQ = async (e) => {
        e?.preventDefault();
        var finalscore = score
        if (question[counter].correctOption == selectedOption) {
            // setScore(score + quize.markspq)
            finalscore = finalscore + quize.markspq
        }
        try {
            var res = await submitQuize({ marks: finalscore }, quize.qid, userInfo.user.student.sid)
            console.log(res)

            navigate("/view-result", { state: { quize, finalscore } })

        }
        catch (e) {
            console.log(e)
        }
        console.log(score)
    }
    var handleCorrectOption = (e) => {
        setSelectedOption(e.target.value)
    }
    return (
        <>
            <div className="container card p-4 shadow mt-5" style={{ width: "60%" }}>
                <h1 class="text-center fst-italic mb-5 form-heading">{quize?.name}</h1>
                <div className="d-flex mb-3" style={{ justifyContent: "end" }}>
                    <div className="card shadow p-2 d-flex" style={{ width: "14%", textAlign: "center" }}>
                        <h2>{minute < 10 ? '0' + minute : minute}:{second < 10 ? "0" + second : second}</h2>
                    </div>
                </div>
                {question && (
                    <form>
                        <div class="form-group">
                            <input type="text" value={question[counter]?.question} disabled name="question" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Question" />
                        </div>
                        <div className="row  option-box">
                            {/* <div className="col"> */}

                            <div class="form-group col-6 my-4">
                                <label for="exampleInputPassword1">Option1</label>

                                <input value={question[counter]?.option1} disabled type="text" name="option1" class="form-control" id="exampleInputPassword1" placeholder="Enter op1" />
                            </div>
                            <div class="form-group col-6 my-4">
                                <label for="exampleInputPassword1">Option2</label>
                                <input value={question[counter]?.option2} disabled type="text" name="option2" class="form-control" id="exampleInputPassword1" placeholder="Enter op2" />
                            </div>
                            {/* </div> */}
                            {/* <div> */}
                            <div class="form-group col-6 my-1" >
                                <label for="exampleInputPassword1">Option3</label>
                                <input value={question[counter]?.option3} disabled type="text" name="option3" class="form-control" id="exampleInputPassword1" placeholder="Enter op3" />
                            </div>
                            <div class="form-group col-6 my-1">
                                <label for="exampleInputPassword1">Option4</label>
                                <input value={question[counter]?.option4} disabled type="text" name="option4" class="form-control" id="exampleInputPassword1" placeholder="Enter op4" />
                            </div>
                            <div class=" input-group my-2">
                                <select name="correctOption" onChange={handleCorrectOption} class="custom-select form-control" id="inputGroupSelect01">
                                    <option selected>Choose correct option number</option>
                                    <option value="op1">1</option>
                                    <option value="op2">2</option>
                                    <option value="op3">3</option>
                                    <option value="op4">4</option>

                                </select>

                            </div>
                        </div>
                        {/* </div> */}
                        <div className="d-flex" style={{ justifyContent: "end" }}>
                            {
                                counter < (question.length - 1) ? <button class="btn btn-dark mt-2" onClick={handleNext}>
                                    Save And Next
                                </button> :
                                    <button onClick={submitQ} class="btn btn-dark mt-2">
                                        Submit
                                    </button>
                            }
                        </div>
                    </form>
                )}
            </div>
        </>
    )
}