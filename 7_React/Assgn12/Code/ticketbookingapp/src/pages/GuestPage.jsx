export const GuestPage = ({props}) => {
  return(
    <>
      <h1>Please Sign Up</h1>
      <button onClick={()=>props(true)}>Login</button>
    </>
  )
}