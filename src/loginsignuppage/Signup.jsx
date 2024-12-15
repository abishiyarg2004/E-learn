import React, { useState } from 'react';
import { IconButton, Input, InputLabel, InputAdornment, FormControl, TextField, Button, Typography } from '@mui/material';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import { useNavigate } from 'react-router-dom';
import styled, { keyframes } from 'styled-components';
import { ToastContainer, toast } from 'react-toastify'; // Import ToastContainer
import 'react-toastify/dist/ReactToastify.css';
import './signup.css';
import axios from 'axios';

const magic = keyframes`
  0% {
    transform: scale(1);
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
  }
  50% {
    transform: scale(1.1);
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
  }
  100% {
    transform: scale(1);
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
  }
`;

const StyledButton = styled(Button)`
  margin-top: 20px !important;
  width: 100%;
  animation: ${magic} 1s infinite;
`;

const Signup = () => {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPass] = useState('');
  const navigate = useNavigate();
  const [error, setError] = useState(false);
  const [showPassword, setShowPassword] = useState(false);

  const handleClickShowPassword = () => setShowPassword(!showPassword);
  const handleMouseDownPassword = (event) => event.preventDefault();

  const handleSignup = () => {
    const hasUppercase = /[A-Z]/.test(password);
    const hasLowercase = /[a-z]/.test(password);
    const hasNumber = /\d/.test(password);
    const hasSpecialChar = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/.test(password);

    const isStrong = hasUppercase && hasLowercase && hasNumber && hasSpecialChar;

    if (!isStrong) {
      setError(true);
    } else {
      try{
        const response= axios.post('http://localhost:300/users',{
          username,email,password
        })
      }
      catch (error) {
        console.error('There was an error registering the user!', error);
      }
      
      navigate('/Home');
      toast.success('Sign up Successful'); // Use toast to show success message
      
    

    }
  };

  return (
    <div className="signup-container">
    
      <Typography variant="h6" style={{  color: '#3f51b5' }}>Sign Up</Typography>
      <TextField
        label="Username"
        variant="outlined"
        fullWidth
        className="input-field"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <br></br>
      <TextField
        label="Email"
        variant="outlined"
        fullWidth
        className="input-field"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br></br>
      <FormControl variant="outlined" fullWidth className="input-field">
        <InputLabel>Password</InputLabel>
        <Input
          type={showPassword ? 'text' : 'password'}
          value={password}
          onChange={(e) => setPass(e.target.value)}
          endAdornment={
            <InputAdornment position="end">
              <IconButton
                aria-label="toggle password visibility"
                onClick={handleClickShowPassword}
                onMouseDown={handleMouseDownPassword}
              >
                {showPassword ? <VisibilityOff /> : <Visibility />}
              </IconButton>
            </InputAdornment>
          }
        />
      </FormControl>
      {error && <Typography color="error" className="signup-error">*use strong password</Typography>}
      <StyledButton variant="contained" color="primary" onClick={handleSignup}>
        Sign Up
      </StyledButton>
    </div>
  );
};

export default Signup;
