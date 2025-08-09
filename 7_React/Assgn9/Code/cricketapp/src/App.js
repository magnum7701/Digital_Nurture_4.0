import './App.css';
import { IndianPlayers, players } from './Players';


function App() {
  return (
    <div className="App">
      <h1>List of Players</h1>
      <div>
        {players.map((player,idx)=>(
          <li key={idx}>Mr. {player.name} <span>{player.score}</span></li>
        ))}
      </div>
      <h1>List of Players having scores less than 70</h1>
      <div>
        {players.filter((player)=>{
          return player.score < 70
        }).map((player,idx)=>(
          <li key={idx}>Mr. {player.name} <span>{player.score}</span></li>
        ))}
      </div>
      <h1>Odd Players</h1>
      <div>
        {players.filter((player)=>{
          return player.score % 2 !== 0
        }).map((player,idx)=>(
          <li key={idx}>Mr. {player.name} <span>{player.score}</span></li>
        ))}
      </div>
      <h1>Even Players</h1>
      <div>
        {players.filter((player)=>{
          return player.score % 2 === 0
        }).map((player,idx)=>(
          <li key={idx}>Mr. {player.name} <span>{player.score}</span></li>
        ))}
      </div>
      <h1>List of Indian Players Merged</h1>
      <div>
        {IndianPlayers.map((player,idx)=>(
          <li key={idx}>Mr. {player}</li>
        ))}
      </div>
    </div>
  );
}

export default App;