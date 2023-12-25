const initialSate = {
    userInfo: null
}
const authReducer = (state = initialSate, action) => {
    switch (action.type) {
        case "LOGIN":
            localStorage.setItem("profile", JSON.stringify({ ...action?.payload }))
            return { ...state, userInfo: action?.payload }
        case "SIGNIN":
            localStorage.setItem("profile", JSON.stringify({ ...action?.payload }))
            return { ...state, userInfo: action?.payload }

        case "LOGOUT":
            localStorage.clear();
            return { ...state, userInfo: null };

        default:
            return state;
    }
}
export default authReducer