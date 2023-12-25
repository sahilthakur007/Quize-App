import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getQuizeHistory } from "../Actions/commmonActions";
import { format } from "date-fns";
export default () => {
    const { quizeid } = useParams();
    const [students, setStudents] = useState([])
    useEffect(() => {
        var loadQuize = async () => {
            try {
                var res = await getQuizeHistory(quizeid);
                console.log(res)
                setStudents(res.data)
            }
            catch (e) {
                console.log(e)
            }
        }

        loadQuize();

    }, [])
    return (
        <>
            <div className="container card shadow mt-3 p-3" style={{ width: "60%" }}>
                <h1 class="text-center fst-italic mb-5 form-heading">Quize Performace</h1>


                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Sr.No </th>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Date</th>
                            <th scope="col">Marks</th>
                        </tr>
                    </thead>
                    <tbody>
                        {students && (students.map((student, index) => (
                            <tr>
                                <th scope="row">{index + 1}.</th>
                                <td>{student.student.name}</td>
                                <td>{student.student.email}</td>
                                <td>{format(student.date, "dd-MM-yyyy")} </td>
                                <td>{student.marks}</td>
                            </tr>
                        )))}
                    </tbody>
                </table>


            </div>

        </>
    )
}