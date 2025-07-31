import { useState } from 'react'
import './App.css'
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import SingUP from "./Views/Auth/SingUP.jsx";

function App() {
  const [count, setCount] = useState(0)

  return (
      <Router>
        <Routes>
          <Route path="/signUp" element={<SingUP/>} />
        </Routes>
      </Router>
  )
}

export default App
