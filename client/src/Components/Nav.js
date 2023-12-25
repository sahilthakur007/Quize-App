import React, { useEffect, useState } from "react";
// import 'bootstrap/dist/css/bootstrap.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useDispatch, useSelector } from "react-redux";
import { logoutUser } from "../Redux/actions/authAction";
import { useNavigate } from "react-router-dom";
export default () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const { userInfo } = useSelector((state) => state.authReducer);

    var logout = () => {
        dispatch(logoutUser())
        navigate("/login")
    }
    return (
        <>
            <Navbar bg="dark" data-bs-theme="dark" className="px-3">
                {/* <Container> */}
                <Navbar.Brand href="#home">QuizeApp</Navbar.Brand>
                <Nav className="ms-auto">
                    {!userInfo && <Nav.Link onClick={() => navigate("/register")} >Register</Nav.Link>}
                    {!userInfo && <Nav.Link onClick={() => navigate("/login")}>Login</Nav.Link>}
                    {userInfo && userInfo.user.student && <Nav.Link onClick={() => navigate("/student-quize")} >My Quize</Nav.Link>}

                    {userInfo && userInfo.user.student && <Nav.Link onClick={() => navigate("/student-history")} >View History</Nav.Link>}
                    {userInfo && userInfo.user.teacher && <Nav.Link onClick={() => navigate("/add-quize")}  >Add Quize</Nav.Link>}
                    {userInfo && userInfo.user.teacher && < Nav.Link onClick={() => navigate("/teacher-quize")} >View Quize</Nav.Link>}
                    {userInfo && <Nav.Link href="/login" onClick={logout}>Logout</Nav.Link>}


                </Nav>
                {/* </Container> */}
            </Navbar>
        </>
    )
}