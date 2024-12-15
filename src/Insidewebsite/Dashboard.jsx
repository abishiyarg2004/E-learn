import React from 'react';
import { Line, Bar, Doughnut, Bubble } from 'react-chartjs-2';
import { Chart, CategoryScale, LinearScale, PointElement, LineElement, BarElement, ArcElement, Title, Tooltip, Legend } from 'chart.js';
import './Dashboard.css';

// Register the necessary components and scales
Chart.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  BarElement,
  ArcElement,
  Title,
  Tooltip,
  Legend
);

const Dashboard = () => {
  // Data for Performance Graph
  const performanceData = {
    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
    datasets: [
      {
        label: 'Performance',
        data: [65, 59, 80, 81, 56, 55, 40],
        fill: false,
        backgroundColor: '#1e88e5',
        borderColor: '#1e88e5',
        tension: 0.4,
      },
    ],
  };

  // Data for Time Spent
  const timeSpentData = {
    labels: ['Week 1', 'Week 2', 'Week 3', 'Week 4'],
    datasets: [
      {
        label: 'Time Spent (hours)',
        data: [2, 3, 5, 4],
        backgroundColor: 'rgba(255, 99, 132, 0.2)',
        borderColor: 'rgba(255, 99, 132, 1)',
        borderWidth: 1,
      },
    ],
  };

  // Data for Overall Performance
  const overallPerformanceData = {
    labels: ['Excellent', 'Good', 'Average', 'Below Average'],
    datasets: [
      {
        data: [40, 35, 15, 10],
        backgroundColor: ['#4caf50', '#ffeb3b', '#ff9800', '#f44336'],
      },
    ],
  };

  // Data for Courses Attended
  const coursesAttendedData = {
    labels: ['Machine Learning', 'Artificial Intelligence', 'Data Structures', 'Algorithms', 'Operating Systems'],
    datasets: [
      {
        label: 'Progress',
        data: [80, 70, 60, 90, 75],
        backgroundColor: '#42a5f5',
      },
    ],
  };

  // Data for Certifications
  const certificationsData = {
    datasets: [
      {
        label: 'Certifications',
        data: [
          { x: 1, y: 80, r: 15 },  // Machine Learning
          { x: 2, y: 70, r: 12 },  // Artificial Intelligence
          { x: 3, y: 60, r: 10 },  // Data Structures
          { x: 4, y: 90, r: 18 },  // Algorithms
          { x: 5, y: 75, r: 14 }   // Operating Systems
        ],
        backgroundColor: '#4caf50',
      },
    ],
  };

  return (
    <div className="dashboard">
      <h1>Student Dashboard</h1>
      <div className="dashboard-section large-chart">
        <div className="chart-container">
          <h2>Performance Graph</h2>
          <Line data={performanceData} />
        </div>
        <div className="chart-container">
          <h2>Time Spent</h2>
          <Bar data={timeSpentData} />
        </div>
      </div>
      <div className="dashboard-section small-chart-section">
        <div className="chart-container small-chart">
          <h2>Current Courses Progress</h2>
          <Bar data={coursesAttendedData} options={{ indexAxis: 'y' }} />
        </div>
        <div className="chart-container">
          <h2>Certifications</h2>
          <Bubble data={certificationsData} />
        </div>
        <div className="chart-container">
          <h2>Overall Performance</h2>
          <Doughnut data={overallPerformanceData} />
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
