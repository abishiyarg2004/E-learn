import React from "react";
import maindetail from "./Assets/maindetail.jpg";
import headerImage from "./Assets/headerImage.jpg";

const Maindetails = () => {
  const styles = {
    headerImage: {
      background: `url(${headerImage}) no-repeat center center`,
      backgroundSize: 'cover',
      height: '100vh',
      position: 'relative',
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      marginBottom: '-70px',
      marginTop: '-20px',
      marginRight: '-20px',
    },
    profileContainer: {
      backgroundColor: '#fff',
      borderRadius: '50%',
      padding: '50px 70px',
      boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
      textAlign: 'center',
      width: '300px',
    },
    profileImage: {
      borderRadius: '50%',
      width: '120px',
      height: '120px',
      marginBottom: '20px',
      boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
    },
    userInfo: {
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      textAlign: 'center',
    },
    name: {
      margin: '10px 0',
      fontSize: '24px',
      color: '#333',
    },
    email: {
      margin: '5px 0',
      fontSize: '16px',
      color: '#666',
    },
    description: {
      marginTop: '10px',
      fontSize: '19px',
      color: '#889',
    },
  };

  return (
    <div style={styles.headerImage}>
      <div style={styles.profileContainer}>
        <h2 style={{ fontSize: '20px', color: '#333', marginBottom: '20px' }}>
          Welcome back Abishiya, continue your learning!!!
        </h2>
        <img src={maindetail} alt="Profile" style={styles.profileImage} />
        <div className="user-info" style={styles.userInfo}>
          <h1 style={styles.name}>ABISHIYA R.G.</h1>
          <p style={styles.email}>abi@gmail.com</p>
          <p style={styles.description}>Unlock your potential with us!</p>
        </div>
      </div>
    </div>
  );
}

export default Maindetails;
