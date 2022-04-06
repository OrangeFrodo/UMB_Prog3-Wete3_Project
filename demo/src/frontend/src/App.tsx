import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Header from './components/Header';
import Dashboard from './pages/Dashboard';
import Employee from './pages/Employee';

function App() {
  return (
    <>
      <Router>
        <div className='container'>
          <Header />
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path='/employee' element={<Employee />} />
          </Routes>
        </div>
      </Router>
    </>
  );
}

export default App;
