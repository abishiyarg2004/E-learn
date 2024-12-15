import React from 'react';
import { Container, Grid, Box, Typography, TextField, Button } from '@mui/material';
import { Facebook, Twitter, LinkedIn, Instagram, YouTube, WhatsApp } from '@mui/icons-material';
import './Footer.css';

const Footer = () => {
  return (
    <Box className="footer">
      <Container>
        <Grid container spacing={4}>
          <Grid item xs={12} md={3}>
            <Typography variant="h6">Programs</Typography>
            <Typography>Corporate</Typography>
            <Typography>One to One</Typography>
            <Typography>Consulting</Typography>
          </Grid>
          <Grid item xs={12} md={3}>
            <Typography variant="h6">Service</Typography>
            <Typography>Training</Typography>
            <Typography>Coaching</Typography>
            <Typography>Consulting</Typography>
          </Grid>
          <Grid item xs={12} md={3}>
            <Typography variant="h6">Contact</Typography>
            <Typography>Home</Typography>
            <Typography>About</Typography>
            <Typography>Contact</Typography>
          </Grid>
          <Grid item xs={12} md={3}>
            
            
            <Box className="social-icons">
              <WhatsApp />
              <YouTube />
              <Instagram />
              <Facebook />
              <LinkedIn />
              <Twitter />
            </Box>
            <Typography>Mobile: +917892474250</Typography>
            <Typography>Email: abi@gmail.com</Typography>
          </Grid>
        </Grid>
        <Box className="footer-bottom">
          <Typography>© 2024 elearn.com</Typography>
        </Box>
      </Container>
    </Box>
  );
};

export default Footer;
