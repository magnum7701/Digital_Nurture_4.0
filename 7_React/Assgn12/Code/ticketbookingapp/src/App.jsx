import { useState } from 'react';
import './App.css';
import { GuestPage } from './pages/GuestPage';
import { UserPage } from './pages/UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false)
  if(!isLoggedIn){
    return (
      <div className="App">
        <GuestPage props={setIsLoggedIn}/>
      </div>
    );
  }
  return(
    <div className="App">
      <UserPage props={setIsLoggedIn}/>
    </div>
  )
  
}

export default App;