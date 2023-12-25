import React, { useEffect, useState } from "react";
import { getHistoryStudent } from "../Actions/commmonActions";
import { format } from "date-fns";
import { useSelector } from "react-redux";

export default () => {
    const { userInfo } = useSelector((state) => state.authReducer);
    const [histories, setHistories] = useState();
    useEffect(() => {
        var loadHistory = async () => {
            try {
                var user = JSON.parse(localStorage.getItem("user"))
                var res = await getHistoryStudent(userInfo.user.uid)
                console.log(res)
                setHistories(res.data)
            }
            catch (e) {
                console.log(e)
            }
        }
        loadHistory()
    }, [])
    return (<>
        <div className="container card shadow mt-3 p-3" style={{ width: "60%" }}>
            <h1 class="text-center fst-italic mb-5 form-heading">Your Performances</h1>


            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Sr.No </th>
                        <th scope="col">Quize</th>
                        <th scope="col">Date</th>
                        <th scope="col">Marks</th>
                    </tr>
                </thead>
                <tbody>
                    {histories && (histories.map((history, index) => (
                        <tr>
                            <th scope="row">{index + 1}.</th>
                            <td>{history.quize.name}</td>
                            <td>{format(history.date, "dd-MM-yyyy")} </td>
                            <td>{history.marks}</td>
                        </tr>
                    )))}
                </tbody>
            </table>


        </div>
    </>)
}