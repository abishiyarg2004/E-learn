// CourseCard.js
import React, { useState } from 'react';
import './CourseCard.css';

const CourseCard = ({ course, onClick, onEnroll }) => {
  const [isEnrolled, setIsEnrolled] = useState(false);

  const handleEnrollClick = (e) => {
    e.stopPropagation();
    onEnroll();
    setIsEnrolled(true);
  };

  return (
    <div className="course-card" onClick={onClick}>
      <img src={course.image} alt={course.title} className="course-image" />
      <div className="course-card-content">
        <h3>{course.title}</h3>
        <p>Assessment: {course.assessment}</p>
        <button onClick={handleEnrollClick}>
          {isEnrolled ? 'Enrolled' : 'Enroll Now'}
        </button>
      </div>
    </div>
  );
};

export default CourseCard;
