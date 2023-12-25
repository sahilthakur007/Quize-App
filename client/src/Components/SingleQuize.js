import React, { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { deleteQuize, stQuize, stoQuize } from "../Actions/commmonActions";
// import { useNavigate } from "react-router-dom";

export default () => {
    // const navigate = useNavigate()
    const { state } = useLocation();
    console.log(state)
    // var currentQuize = state
    const [currentQuize, setCurrentQuize] = useState(state)
    const navigate = useNavigate();
    var startQuize = async () => {
        try {
            var res = await stQuize(currentQuize.qid);
            console.log(res);
            setCurrentQuize({ ...currentQuize, "isstarted": true })
        }
        catch (e) {
            console.log(e)
        }
    }
    var stopQuize = async () => {
        try {
            var res = await stoQuize(currentQuize.qid);
            console.log(res);
            setCurrentQuize({ ...currentQuize, "isstarted": false })
        }
        catch (e) {
            console.log(e);
        }

    }
    var deleteQ = async () => {
        try {
            console.log(currentQuize.qid)
            var res = await deleteQuize(currentQuize.qid)
            console.log(res)
            navigate("/teacher-quize")

        }
        catch (e) {
            console.log(e);
        }
    }

    return (<>
        <div className="container card shadow mt-4 pb-3" style={{ width: "100%", backgroundColor: "white" }}>
            <div style={{
                display: "flex",
            }}>
                <h3 className="mt-3 fst-italic">{currentQuize.name}</h3>
                <div className="ms-auto mt-4">
                    <h5 className="mx-3">Total Question:{currentQuize.totalQuestions}</h5>
                    <h5 className="mx-3">Time:{currentQuize.time}</h5>
                    <h5 className="mx-3">Marks(per question):{currentQuize.markspq}</h5>
                </div>


            </div>
            <div style={{ display: "flex", justifyContent: "center" }}>
                <button onClick={() => navigate(`/add-question/${currentQuize.qid}`)} className="btn btn-dark mx-3">
                    Add Questions
                </button>

                <button onClick={() => navigate(`/manage-questions/${currentQuize.qid}`)} className="btn btn-dark mx-3">
                    Manage Question
                </button>
                <button onClick={() => navigate(`/add-student/${currentQuize.qid}`)} className="btn btn-dark mx-3">
                    Manage Students
                </button>
                {currentQuize.isstarted ? <button onClick={stopQuize} className="btn btn-dark mx-3">
                    Stop
                </button> : <button onClick={startQuize} className="btn btn-dark mx-3">
                    Start
                </button>}
                <button onClick={() => navigate(`/quize-performance/${currentQuize.qid}`)} className="btn btn-dark mx-3">
                    View Performance
                </button>
                <button onClick={deleteQ} className="btn btn-dark mx-3">
                    Delete Quize
                </button>
            </div>
        </div>
    </>)
}