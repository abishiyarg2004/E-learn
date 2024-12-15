import { Route, Routes } from "react-router-dom"
import Mainhome from "../loginsignuppage/Mainhome"
import Home from "../Insidewebsite/Home.jsx"
import Dashboard from "../Insidewebsite/Dashboard.jsx"
import Courses from "../Insidewebsite/Courses.jsx"
import Certification from "../Insidewebsite/Certification.jsx"
import Mentoring from "../Insidewebsite/Mentoring.jsx"
import { Quiz } from "@mui/icons-material"



const Routing=()=>{
    return(
        <div>
            <Routes>
               <Route path='/' element={<Mainhome/>}></Route>
              <Route path='/Home'  element={<Home/>}></Route>
             <Route path='/dashboard' element={<Dashboard/>}></Route>
             <Route path="/courses" element={<Courses/>}></Route>
             <Route path="/certification" element={<Certification/>}></Route>
             <Route path="mentoring" element={<Mentoring/>}></Route>
             <Route path="quiz" element={<Quiz/>}></Route>
            </Routes>

        </div>
    )
}
export default Routing;