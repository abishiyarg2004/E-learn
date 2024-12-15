import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useNavigate } from 'react-router-dom';
import styled, { keyframes } from 'styled-components';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
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

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await axios.get(`http://localhost:300/users?username=${username}&password=${password}`);
      console.log('Response:', response);

      // Check for correct username and password combination
      if (response.data.length > 0) {
        const user = response.data.find(user => user.username === username && user.password === password);
        if (user) {
          toast.success('Login successful');
          navigate('/Home');
        } else {
          toast.error('Invalid username or password');
        }
      } else {
        toast.error('Invalid username or password');
      }
    } catch (error) {
      console.error('There was an error logging in!', error);
      toast.error('Network Error: Unable to login');
    }
  };

  return (
    <div style={{ width: '80%', marginLeft: '40px' }}>
      <ToastContainer position="top-center" autoClose={2000} hideProgressBar />
      <Typography variant="h6" style={{ marginBottom: '20px', color: '#3f51b5' }}>Login</Typography>
      <TextField
        label="Username"
        variant="outlined"
        fullWidth
        style={{ marginBottom: '15px' }}
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <TextField
        label="Password"
        variant="outlined"
        type="password"
        fullWidth
        style={{ marginBottom: '15px' }}
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <StyledButton variant="contained" color="primary" onClick={handleLogin}>
        Login
      </StyledButton>
    </div>
  );
};

export default Login;
