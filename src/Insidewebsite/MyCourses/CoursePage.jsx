import React from 'react';
import { useParams } from 'react-router-dom';
import './CoursePage.css';

const CoursePage = ({ courses }) => {
  const { courseId } = useParams();
  const course = courses.find(c => c.id === courseId);

  if (!course) {
    return <div>Course not found.</div>;
  }

  return (
    <div className="course-page">
      <h2>{course.title}</h2>
      <p>Status: {course.status}</p>
      <p>Assessment: {course.assessment}</p>
      <img src={course.image} alt={course.title} className="course-image" />
    </div>
  );
};

export default CoursePage;
