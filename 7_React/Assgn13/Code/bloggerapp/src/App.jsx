import './App.css';
import { useState } from 'react';
import { CourseDetails } from './components/CourseDetails';
import { BlogDetails } from './components/BlogDetails';
import { BookDetails } from './components/BookDetails';

function App() {
  const [active, setActive] = useState("book");
  return (
    <div className="App">
      <h1>Blogger App</h1>

      <div style={{ marginBottom: "1rem" }}>
        <button onClick={() => setActive("book")}>Show Book</button>
        <button onClick={() => setActive("blog")}>Show Blog</button>
        <button onClick={() => setActive("course")}>Show Course</button>
      </div>


      {/* Using if-else */}
      {(() => {
        if (active === "book") return <BookDetails />;
        else if (active === "blog") return <BlogDetails />;
        else return <CourseDetails />;
      })()}

      {/* Using ternary operator */}
      {/* {active === "book" ? <BookDetails /> : active === "blog" ? <BlogDetails /> : <CourseDetails />} */}


      {/* Using logical AND */}
      {/* {active === "book" && <BookDetails />}
      {active === "blog" && <BlogDetails />}
      {active === "course" && <CourseDetails />} */}

      {/* Using switch-case */}
      {/* {(() => {
        switch (active) {
          case "book":
            return <BookDetails />;
          case "blog":
            return <BlogDetails />;
          case "course":
            return <CourseDetails />;
          default:
            return null;
        }
      })()} */}
    </div>
  );
}

export default App;