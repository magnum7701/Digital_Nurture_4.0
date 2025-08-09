import './App.css';

function App() {
  const element = 'Office Space';
  const attr = <img src='/image.jpg' width='25%' height='25%' alt='Office Room'/>
  const officeNames = [
    {
      name:'DBS',
      rent:50000,
      address:'Chennai'
    },
    {
      name:'ABS',
      rent:70000,
      address:'Kolkata'
    },
  ]
  return (
    <>
      <h1>{element}, at Affordable Range</h1>
      {officeNames.map((office)=>(
        // {attr}
        <div>
          {attr}
          <h1>Name : {office.name}</h1>
          <h3 style={{color:office.rent < 60000 ? 'red' : 'green'}}>Rent : {office.rent}</h3>
          <h3>Address : {office.address}</h3>
        </div>
      ))}
      {/* {attr} */}
    </>
  );
}

export default App;