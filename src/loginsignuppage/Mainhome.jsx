import React, { useState } from 'react';
import { AppBar, Toolbar, Typography, Button, Container, Grid, Box, IconButton } from '@mui/material';
import { Home, Info, ContactMail, School } from '@mui/icons-material';
import backimage from './Assets/backimage.png';
import './loginsign.css';
import LoginSign from './LoginSign';
import Footer from './Footer'; // Import the Footer component
import LocalLibraryIcon from '@mui/icons-material/LocalLibrary';

const Mainhome = () => {
  const [isLogin, setIsLogin] = useState(false);

  return (
    <div className='mainimg'>
      {/* Navigation Bar */}
      <AppBar position="static" className="navbar">
        <Toolbar>
          <IconButton edge="start" color="inherit" aria-label="home">
           <LocalLibraryIcon/>
          </IconButton>
          <Typography variant="h4" className="nav-title" style={{ flexGrow: 1 }}>
            E-Learning Portal
          </Typography>
          <IconButton color="inherit" aria-label="courses">
            <School />
          </IconButton>
          <IconButton color="inherit" aria-label="about">
            <Info />
          </IconButton>
          <IconButton color="inherit" aria-label="contact">
            <ContactMail />
          </IconButton>
          <Button color="inherit" onClick={() => setIsLogin(true)} className="nav-button">Login/SignUp</Button>
        </Toolbar>
      </AppBar>
      
      {/* Main Content */}
      <Container className="main-content">
        <Grid container spacing={2} alignItems="center">
          <Grid item xs={12} md={6} className="slide-in-left">
            <h2 className="main-title"> Welcome  to the E-Learning Portal</h2>
            <br></br>
            <br></br>
            <p className="main-subtitle">
               Your gateway  to the best educational resources and courses. Explore, learn, and grow with us.
            </p>
            <br></br>
            <Box className="button-group">
              <Button variant="contained" className="start-button" onClick={() => setIsLogin(true)}>Get Started to enjoy the features</Button>
            </Box>
          </Grid>
          <Grid item xs={12} md={6} className="slide-in-right">
            <Box style={{ textAlign: 'center' }}>
              <img src={backimage} alt="Educational GIF" className="main-gif" />
            </Box>
          </Grid>
        </Grid>
      </Container>

      {/* Features Section */}
      <div className='features'>
        <Container className="features-section slide-in-bottom">
          <Grid container spacing={3}>
            <Grid item xs={12} md={3}>
              <Box className="feature-box">
                <Typography variant="h6">Lorem Ipsum</Typography>
                <Box className="feature-box-content">
                  <Typography variant="body1">Detailed content about Lorem Ipsum.</Typography>
                  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vel velit auctor, lacinia justo ac, cursus dolor.</p>
                </Box>
              </Box>
            </Grid>
            <Grid item xs={12} md={3}>
              <Box className="feature-box">
                <Typography variant="h6">Sed ut perspiciatis</Typography>
                <Box className="feature-box-content">
                  <Typography variant="body1">Detailed content about Sed ut perspiciatis.</Typography>
                  <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                </Box>
              </Box>
            </Grid>
            <Grid item xs={12} md={3}>
              <Box className="feature-box">
                <Typography variant="h6">Magni Dolores</Typography>
                <Box className="feature-box-content">
                  <Typography variant="body1">Detailed content about Magni Dolores.</Typography>
                  <p>Magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum.</p>
                </Box>
              </Box>
            </Grid>
            <Grid item xs={12} md={3}>
              <Box className="feature-box">
                <Typography variant="h6">Nemo Enim</Typography>
                <Box className="feature-box-content">
                  <Typography variant="body1">Detailed content about Nemo Enim.</Typography>
                  <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni.</p>
                </Box>
              </Box>
            </Grid>
          </Grid>
        </Container>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
      </div>

      {/* Conditional Rendering of Login/Signup */}
      {isLogin && <LoginSign />}
      
      {/* Footer */}
      <Footer />
    </div>
  );
};

export default Mainhome;
