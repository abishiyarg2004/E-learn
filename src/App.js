import logo from './logo.svg';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Routing from './Routingfolder/Routing.jsx';
function App() {
  return (
    <BrowserRouter>
    <div className="App">
      <Routing></Routing>
    </div>
    </BrowserRouter>
  );
}

export default App;
