// import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  const [value, setValue] = useState(0);
  const [formvalue, setFormValue] = useState('');
  const handleButtonIncrement = () => {
    setValue(value+1)
    alert('Hello Member')
  }
  const handleButtonDecrement = () => {
    setValue(value-1)
  }
  const handleWelcome = (txt) => {
    alert(txt)
  }
  const handleClick = () => {
    alert('I was clicked')
  }
  const handleFormChange = (e) => {
    setFormValue(e.target.value)
  }
  const handleSubmit = (e) => {
    e.preventDefault()
    alert(`Converting to Euro amount is ${parseInt(formvalue)*0.0099}`)

  }
  return (
    <div className="App">
      <p>{value}</p>
      <button onClick={handleButtonIncrement}>Increment</button>
      <br/>
      <button onClick={handleButtonDecrement}>Decrement</button>
      <br/>
      <button onClick={() => handleWelcome('welcome')}>Say Welcome</button>
      <br/>
      <button onClick={handleClick}>Click Me</button>
      <h1 style={{color:'green'}}>Currency Convertor!!!</h1>
      <form>
        <label>Amount:</label>
        <input type='text' value={formvalue} onChange={handleFormChange}></input>
        <br/>
        <label>Currency:</label>
        <input type='textarea' required></input>
        <br/>
        <button onClick={(e)=>handleSubmit(e)}>Submit</button>
      </form>
    </div>
  );
}

export default App;