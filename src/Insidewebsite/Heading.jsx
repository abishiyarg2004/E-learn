import React from 'react';
import './Heading.css';
import PersonIcon from '@mui/icons-material/Person';
import LocalLibraryIcon from '@mui/icons-material/LocalLibrary';
import { useNavigate } from 'react-router-dom';

const Heading = () => {

  const navigate = useNavigate();
const handlelogout=()=>{
 navigate('/');
}

  return (
    <div className="header">
      <div className="header-title">
        <LocalLibraryIcon style={{ fontSize: 30, marginRight: '10px' }} />
        E-Learning Portal
      </div>
      <div className="user-info">
        <span className="username">ABISHIYA R.G.</span>
        <div className="user-profile">
          <PersonIcon style={{ fontSize: 30 }} />
        </div>
        <button className="logout-button" onClick={handlelogout} >Logout</button>
      </div>
    </div>
  );
};

export default Heading;
