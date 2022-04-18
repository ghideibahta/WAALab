
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Dashboard from './pages/Dashboard';
function App() {
  return (
    <BrowserRouter>
    <div className="App">
       <h1>Welcome To WAA</h1>
       <Dashboard/>
    </div>
    </BrowserRouter>
  );
}

export default App;
