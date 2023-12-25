import { resolvePath } from "react-router-dom";
import { loginapi } from "../../API/studentAPI";
// import { signin, signup } from "../../api/allApi";
export const loginUser = (userinfo, navigate) => async (dispatch) => {

    try {
        const res = await loginapi(userinfo);
        // 
        dispatch({
            type: "LOGIN",
            payload: res.data
        })
        if (res.data.user.student) {
            navigate("/student-quize")
        }
        else {
            navigate("/teacher-quize")
        }

        console.log(res)


        // return res;
    }
    catch (error) {
        console.log(error);
    }
}
export const relogin = (userinfo) => async (dispatch) => {

    try {

        dispatch({
            type: "LOGIN",
            payload: userinfo
        })
    }
    catch (error) {
        console.log(error);
    }
}
export const logoutUser = () => async (dispatch) => {

    dispatch({
        type: "LOGOUT"
    })
}