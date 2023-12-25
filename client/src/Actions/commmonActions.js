import { addAllStudentsapi, addQuestionapi, createQuizeapi, deleteQuestionapi, deleteQuizeapi, getAllQuizeByTeacherapi, getAllStudentsapi, getHistoryStudentapi, getQuestionForQuizeapi, getQuizeForStudentapi, getQuizeHistoryapi, loginapi, registerapi, removeAllStudentsapi, startQuizeapi, stopQuizeapi, submitQuizeapi, updateQuestionapi } from "../API/studentAPI"

export const login = async (body) => {

    var res = await loginapi(body);
    return res;
}

export const register = async (body) => {

    var res = await registerapi(body)
    return res;
}

export const getAllQuizeByTeacher = async (tid) => {

    // var res = l 
    var res = await getAllQuizeByTeacherapi(tid)
    return res;
}

export const createQuiz = async (quize, tid) => {
    var res = await createQuizeapi(quize, tid)
    return res;
}

export const addQuestion = async (question, quizeid) => {
    var res = await addQuestionapi(question, quizeid)
    return res;
}

export const getAllStudents = async (quizeid) => {
    var res = await getAllStudentsapi(quizeid);
    return res;
}
export const addAllStudents = async (students, quizeid) => {
    var res = await addAllStudentsapi(students, quizeid);
    return res;
}
export const removeAllStudents = async (students, quizeid) => {
    var res = await removeAllStudentsapi(students, quizeid);
    return res;
}
export const stQuize = async (quizeid) => {
    var res = await startQuizeapi(quizeid)
    return res;
}

export const stoQuize = async (quizeid) => {
    var res = await stopQuizeapi(quizeid)
    return res;
}

export const deleteQuize = async (quizeid) => {
    var res = await deleteQuizeapi(quizeid);
    return res;
}

export const getQuestionForQuize = async (quizeid) => {
    var res = await getQuestionForQuizeapi(quizeid);
    return res;
}

export const deleteQuestion = async (questionid) => {
    var res = await deleteQuestionapi(questionid)
    return res;
}
export const updateQuizeQuestion = async (question, questionid) => {
    var res = await updateQuestionapi(question, questionid);
    return res;
}
export const getQuizeForStudent = async (studentid, userid) => {
    var res = await getQuizeForStudentapi(studentid, userid);
    return res;
}

// export const getQuestionForQuize = async (quizeid) => {
//     var res = await getQuestionForQuizeapi(quizeid);
//     return res;
// }

export const submitQuize = async (details, quizeid, sid) => {
    var res = await submitQuizeapi(details, quizeid, sid)
    return res;
}
export const getQuizeHistory = async (quizeid) => {
    var res = await getQuizeHistoryapi(quizeid);
    return res;
}

export const getHistoryStudent = async (studentid) => {
    var res = await getHistoryStudentapi(studentid);
    return res;
}

