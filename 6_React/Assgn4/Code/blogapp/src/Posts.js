import React, { Component } from 'react';
import Post from './Post.js';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const postList = data.map((item) => new Post(item.id, item.title, item.body))
        this.setState({ posts: postList });
      })
      .catch((error) => {
        throw new Error('Failed to load posts');
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred: " + error.message);
  }

  render() {
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key = {post.id}>
            <p>{post.id}</p>
            <p>{post.title}</p>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
