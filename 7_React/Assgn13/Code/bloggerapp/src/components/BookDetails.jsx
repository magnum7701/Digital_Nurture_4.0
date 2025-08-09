export const BookDetails = () => {
  const bookDetails = [
    {name:'Master React',price:670},
    {name:'Deep Dive into Angular 11',price:800},
    {name:'Mongo Essentials',price:450},
  ]
  return(
    <>
      {
        bookDetails.map((book,id)=>(
          <div key={id}>
            <h3>{book.name}</h3>
            <h4>{book.price}</h4>
          </div>
        ))
      }
    </>
  )
}