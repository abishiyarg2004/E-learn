import React, { useState } from 'react';
import { Paper, Typography, Link, IconButton } from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';
import Login from './Login';
import Signup from './Signup';
import './loginsign.css';
import { useNavigate } from 'react-router-dom';

const LoginSign = () => {
 
  const [user, setUser] = useState(null);


  const [isLogin, setIsLogin] = useState(true);
  const navigate=useNavigate();
  const toggleForm = () => {
    setIsLogin(!isLogin);
  };

  const handleClose = () => {
    
    window.location.reload();

  };

  return (
    <div className='bodyinlog'>
      <h2 style={{ color: 'white', marginTop: "60px" }}>Login/SignUp to enjoy the features</h2>
      <Paper elevation={8} className='Paperinlog' style={{ padding: '30px', width: '500px', height: '400px', marginLeft: '710px', marginTop: '80px', position: 'relative' }}>
        <IconButton 
          onClick={handleClose} 
          style={{ position: 'absolute', top: 10, right: 10 }}
        >
          <CloseIcon />
        </IconButton>
        {isLogin ? <Login /> : <Signup />}
        <br />
        {isLogin ? (
          <Typography variant="body2" style={{ cursor: 'pointer' }} onClick={toggleForm}>
            New here? <Link>Sign Up</Link>
          </Typography>
        ) : (
          <Typography variant="body2" style={{ cursor: 'pointer' }} onClick={toggleForm}>
            Already a user? <Link>Login here</Link>
          </Typography>
        )}
      </Paper>
    </div>
  );
};

export default LoginSign;
