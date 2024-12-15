import React, { useState } from "react";
import Heading from "./Heading";
import { Tab, Tabs, Box } from "@mui/material";
import { useNavigate } from "react-router-dom";
import './Sidebar.css';
import './Home.css';
import Dashboard from "./Dashboard";
import Courses from "./Courses";
import Maindetails from "./Maindetails";
import Quiz from "./Quiz";
import Mentoring from "./Mentoring";
import Certification from "./Certification";
const Home = () => {
  const [val, setVal] = useState(0);
  const navigate = useNavigate();

  return (
    <div className="myhome">
      <Heading />
      <div className="main-layout">
        <div className="sidebar">
          <h2 className="sidebar-title">Menu</h2>
          <Box sx={{ display: 'flex', flexDirection: 'column' }}>
            <Tabs
              orientation="vertical"
              textColor="inherit"
              value={val}
              onChange={(e, value) => setVal(value)}
              indicatorColor="secondary"
            >
              <Tab
                label="Home"
                sx={{ fontSize: "20px" }}
                onClick={() => { navigate("/Home") }}
              />
              <Tab
                label="Dashboard"
                sx={{ fontSize: "20px" }}
               
              />
              <Tab
                label="Courses"
                sx={{ fontSize: "20px" }}
               
              />
              <Tab
                label="Quiz"
                sx={{ fontSize: "20px" }}
                
              />
              <Tab
                label="Mentoring"
                sx={{ fontSize: "20px" }}
                
              />
              <Tab
                label="Certification"
                sx={{ fontSize: "20px" }}
               
              />
            </Tabs>
          </Box>
        </div>
        <div className="content">
          {/* This is where the content will be displayed */}

          {
            val===1 ? <Dashboard/> :
            val===2? <Courses/> :
            val ===3 ? <Quiz/> :
            val ===4 ? <Mentoring /> :
            val ===5 ? <Certification /> :
            <Maindetails/>
          
          }
        </div>
      </div>
    </div>
  );
};

export default Home;
