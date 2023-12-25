import axios from "axios"
const API = axios.create({ baseURL: "http://localhost:8080" })
API.interceptors.request.use((req) => {
    if (localStorage.getItem('profile')) {
        req.headers.Authorization = `Bearer ${JSON.parse(localStorage.getItem('profile')).token}`;
    }

    return req;
});

// http://localhost:8080/auth/login
// axios.create("http://localhost:8080/user/create").post(user)
export const registerapi = (user) => axios.post("http://localhost:8080/user/create", user)

export const loginapi = (user) => axios.post("http://localhost:8080/auth/login", user);
export const getAllQuizeByTeacherapi = (tid) => API.get(`/teacher/${tid}`)
export const createQuizeapi = (quize, tid) => API.post(`/quize/create/${tid}`, quize)
export const addQuestionapi = (question, quizeid) => API.post(`/question/create/${quizeid}`, question)

export const getAllStudentsapi = (quizeid) => API.get(`/student/quize/${quizeid}`)
export const addAllStudentsapi = (students, quizeid) => API.put(`student/add/quize/${quizeid}`, students)
export const removeAllStudentsapi = (students, quizeid) => API.put(`student/remove/quize/${quizeid}`, students)

export const startQuizeapi = (quizeid) => API.put(`/quize/start/${quizeid}`)
export const stopQuizeapi = (quizeid) => API.put(`/quize/start/${quizeid}`)

export const deleteQuizeapi = (quizeid) => API.delete(`/quize/delete/${quizeid}`)

export const getQuestionForQuizeapi = (quizeid) => API.get(`/question/quize/${quizeid}`)

export const updateQuestionapi = (question, questionid) => API.put(`/question/update/${questionid}`, question)
export const deleteQuestionapi = (questionid) => API.delete(`/question/delete/${questionid}`)
export const getQuizeForStudentapi = (studentid, userid) => API.get(`/student/${studentid}/${userid}`)
export const getQueztionForQuizeapi = (quizid) => API.get(`/question/quize/${quizid}`)
export const submitQuizeapi = (details, quizeid, sid) => API.post(`/history/submit/quize/${quizeid}/student/${sid}`, details)

export const getQuizeHistoryapi = (quizeid) => API.get(`/history/quize/${quizeid}`)

export const getHistoryStudentapi = (studentid) => API.get(`/history/student/${studentid}`)

export const checkTokenValidityapi = (token, username) => API.get(`/auth/check-token/${token}/${username}`)