// Courses.js
import React, { useState } from 'react';
import { Routes, Route, useNavigate } from 'react-router-dom';
import CourseCard from './MyCourses/CourseCard';
import CoursePage from './MyCourses/CoursePage';
import './Courses.css';
import algorithm from './Assets/algorithm.jpg';
import datastructures from './Assets/datastructures.jpeg';
import ai from './Assets/ai.jpg';
import machinelearning from './Assets/machinelearning.jpg';
import react from './Assets/react.jpeg';

const Courses = () => {
  const navigate = useNavigate();
  const [enrolledCourses, setEnrolledCourses] = useState([]);

  const courses = [
    {
      id: "1",
      title: "Algorithm",
      assessment: "1",
      image: algorithm,
    },
    {
      id: "2",
      title: "Artificial Intelligence",
      assessment: "1",
      image: ai,
    },
    {
      id: "3",
      title: "Machine Learning",
      assessment: "1",
      image: machinelearning,
    },
    {
      id: "4",
      title: "React",
      assessment: "1",
      image: react,
    },
    {
      id: "5",
      title: "Data Structures",
      assessment: "1",
      image: datastructures,
    },
    {
      id: "6",
      title: "Cyber Security",
      assessment: "1",
      image: datastructures,
    },
    {
      id: "7",
      title: "Data Science",
      assessment: "1",
      image: datastructures,
    },
    {
      id: "8",
      title: "Cloud Computing",
      assessment: "1",
      image: datastructures,
    },
    {
      id: "9",
      title: "Information Technology",
      assessment: "1",
      image: datastructures,
    },
    {
      id: "10",
      title: "Quantum Computing",
      assessment: "1",
      image: datastructures,
    },
    {
      id: "11",
      title: "IOT",
      assessment: "1",
      image: datastructures,
    },
  ];

  const handleEnroll = (courseId) => {
    const course = courses.find(c => c.id === courseId);
    if (course && !enrolledCourses.includes(course)) {
      setEnrolledCourses([...enrolledCourses, course]);
    }
  };

  return (
    <div className="courses">
      {courses.map((course) => (
        <CourseCard
          key={course.id}
          course={course}
          onClick={() => navigate(`/courses/${course.id}`)}
          onEnroll={() => handleEnroll(course.id)}
        />
      ))}
      <Routes>
        <Route path=":courseId" element={<CoursePage courses={courses} />} />
      </Routes>
    </div>
  );
};

export default Courses;
