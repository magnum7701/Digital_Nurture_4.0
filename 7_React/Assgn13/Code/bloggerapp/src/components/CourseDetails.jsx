export const CourseDetails = () => {
  const courseDetails = [
    {name:'Angular',date:'4/5/2021'},
    {name:'React',date:'6/3/2021'},
  ]
  return(
    <>
      {
        courseDetails.map((course,id)=>(
          <div key={id}>
            <h3>{course.name}</h3>
            <h4>{course.date}</h4>
          </div>
        ))
      }
    </>
  )
}