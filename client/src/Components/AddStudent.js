import React, { useEffect, useState } from "react";
import { addAllStudents, getAllStudents, removeAllStudents } from "../Actions/commmonActions";
import { useParams } from "react-router-dom";
import { removeAllStudentsapi } from "../API/studentAPI";

// const students = [
//     {
//         "sid": 1,
//         "name": "Sahil Pravin Thakur",
//         "email": "sahil.thakur@walchandsangli.ac.in",

//     },
//     {
//         "sid": 2,
//         "name": "Divya Milind Kekade",
//         "email": "divya.kekade@walchandsangli.ac.in",

//     },

//     {
//         "sid": 3,
//         "name": "Divu Milind Kekade",
//         "email": "divu.kekade@walchandsangli.ac.in",

//     }
// ]

export default () => {

    var { quizeid } = useParams();
    const [students, setStudents] = useState([]);
    const [alreadyAddedStudentIds, setAlreadyAddedStudents] = useState([])
    const [addedStudent, setAddedStudent] = useState([]);
    const [removeStudents, setRemoveStudent] = useState([]);
    // console.log(quizeid)
    useEffect(() => {
        var loadStudent = async () => {
            var res = await getAllStudents(quizeid)
            setStudents(res.data.students)
            setAlreadyAddedStudents(res.data.addedStudents)
            // console.log(student)
            // console.log(res.data);
        }
        loadStudent();
    }, [])
    var addStudent = (e) => {

        if (removeStudents.includes(parseInt(e.target.value))) {
            var newList = removeStudents.filter((sid) => sid != parseInt(e.target.value))
            setRemoveStudent(newList)
        }
        else {
            var newList = [...addedStudent]

            newList.push(parseInt(e.target.value))
            setAddedStudent(newList)
        }



        // console.log(e.target.value)
    }
    // console.log(addedStudent)
    // console.log(alreadyAddedStudentIds)
    // console.log(removeStudents)
    var removeStudent = (e) => {
        console.log(e.target.value)
        if (alreadyAddedStudentIds.includes(parseInt(e.target.value))) {
            console.log("Hello")
            var newList = [...removeStudents]
            newList.push(parseInt(e.target.value))
            setRemoveStudent(newList)

        }
        else {
            // console.log("Bye")

            var newList = addedStudent.filter((sid) => sid != parseInt(e.target.value))
            setAddedStudent(newList)
        }

    }
    // console.log(alreadyAddedStudentIds)
    var saveUser = async () => {
        console.log(addedStudent)
        console.log(removeStudents)
        try {
            if (addedStudent.length > 0) {
                var res = await addAllStudents({ studentsList: addedStudent }, quizeid);
                console.log(res);


            }
            if (removeStudents.length > 0) {
                var res =
                    await removeAllStudents({ studentsList: removeStudents }, quizeid);
                console.log(res);

            }

        }
        catch (e) {
            console.log(e);
        }
    }
    return (
        <>
            <div className="container card shadow mt-3 p-3" style={{ width: "60%" }}>
                <h1 class="text-center fst-italic mb-5 form-heading">Add Student</h1>


                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Sr.No </th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {students && (students.map((student, index) => (
                            <tr>
                                <th scope="row">{index + 1}.</th>
                                <td>{student.name}</td>
                                <td>{student.email} </td>
                                <td>
                                    {addedStudent && ((addedStudent.includes(student.student.sid) || ((alreadyAddedStudentIds.includes(student.student.sid)) && !(removeStudents.includes(student.student.sid)))) ? <button onClick={removeStudent} className="btn btn-dark" value={student.student.sid} style={{ width: "90%" }} >Remove</button> : <button onClick={addStudent} style={{ width: "90%" }} className="btn btn-dark" value={student.student.sid}>Add</button>)}
                                </td>
                                {/* <button className="btn btn-dark">Add</button> */}
                            </tr>
                        )))}
                    </tbody>
                </table>
                <div className="d-flex" style={{ justifyContent: "center" }}>
                    <button onClick={saveUser} className="btn btn-dark" >
                        Save
                    </button>
                </div>

            </div>
        </>
    )
}