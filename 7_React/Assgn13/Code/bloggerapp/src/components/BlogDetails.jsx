export const BlogDetails = () => {
  const blogDetails = [
    {name:'React Learning',author:'Stephen Biz',content:'Welcome to learning React!'},
    {name:'Installation',author:'Schewzdenier',content:'You can install React from npm'},
    {name:'Mongo Essentials',price:450},
  ]
  return(
    <>
      {
        blogDetails.map((blog,id)=>(
          <div key={id}>
            <h3>{blog.name}</h3>
            <h4>{blog.author}</h4>
            <p>{blog.content}</p>
          </div>
        ))
      }
    </>
  )
}