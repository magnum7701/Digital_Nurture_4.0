import { FlightDetails } from "../components/FlightDetails"

export const UserPage = ({props}) => {
  return(
    <>
      <h1>Welcome Back</h1>
      <button onClick={()=>props(false)}>Logout</button>
      <FlightDetails/>
    </>
  )
}