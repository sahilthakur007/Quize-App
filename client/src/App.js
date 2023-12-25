import Nav from './Components/Nav';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import { Route, Routes } from "react-router-dom"
import Register from './Components/Register';
import Login from './Components/Login';
import TeacherQuizeList from './Components/TeacherQuizeList';
import CreateQuiz from './Components/CreateQuiz';
import SingleQuize from './Components/SingleQuize';
import AddQuestion from './Components/AddQuestion';
import AddStudent from './Components/AddStudent';
import ManageQuestions from './Components/ManageQuestions';
import StudentQuizList from './Components/StudentQuizList';
import AttemptQuize from './Components/AttemptQuize';
import QuizePerformance from './Components/QuizePerformance';
import StudentHistory from './Components/StudentHistory';
import { useEffect } from 'react';
import { checkTokenValidityapi } from './API/studentAPI';
import { useDispatch } from 'react-redux';
import { relogin } from './Redux/actions/authAction';
import ViewResult from './Components/ViewResult';
function App() {
  const dispatch = useDispatch()
  useEffect(() => {
    var loadUser = async () => {
      const userdata = JSON.parse(localStorage.getItem('profile'))
      if (userdata) {
        console.log(userdata)
        console.log("app.js")
        try {
          var res = await checkTokenValidityapi(userdata.token, userdata.user.email)
          console.log(res)
          if (res.data) {
            dispatch(relogin(userdata))
          }

        }
        catch (e) {
          localStorage.clear();

        }

      }
    }
    loadUser()

  }, [])
  return (
    <>

      <Nav />
      <Routes>
        <Route path='/register' element={<Register />} />
        <Route path='/login' element={<Login />} />
        <Route path='/' element={<Login />} />
        <Route path='/teacher-quize' element={<TeacherQuizeList />} />
        <Route path='/student-quize' element={<StudentQuizList />} />
        <Route path="/add-quize" element={<CreateQuiz />} />
        <Route path="/single-quize" element={<SingleQuize />} />
        <Route path="/add-question/:quizeid" element={<AddQuestion />} />
        <Route path="/add-student/:quizeid" element={<AddStudent />} />
        <Route path="/manage-questions/:quizeid" element={<ManageQuestions />} />
        <Route path="/update-question/:updatequizeid/:questionid" element={<AddQuestion />} />
        <Route path="/attempt-quize" element={<AttemptQuize />} />
        <Route path="/quize-performance/:quizeid" element={<QuizePerformance />} />
        <Route path="/student-history" element={<StudentHistory />} />
        <Route path='/view-result' element={<ViewResult />} />

      </Routes>
    </>
  );
}

export default App;
