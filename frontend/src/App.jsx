import { useState } from 'react'
import './App.css'
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import SingUP from "./Views/Auth/SignUp/SingUP.jsx";
import LogIn from "./Views/Auth/LogIn/LogIn.jsx";
import Header from "./Components/Header/Header.jsx";

function App() {
  const [count, setCount] = useState(0)

    return (
        <Router>
            <Routes>
                <Route path="/signUp" element={<SingUP/>}/>
                <Route path="/login" element={<LogIn/>}/>
                <Route path="/" element={<Header/>}/>
            </Routes>
        </Router>
    );
}

export default App
