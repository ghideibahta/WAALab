import React from 'react';
import Post from '../Post/Post';
import './Posts.css';

const Posts = (props) => {

    const posts = props.posts.map(post => {
        return <Post
            id={post.id} 
            title={post.title} 
            author={post.author} 
            key={post.id}
            

        />
    });
    return posts;
}

export default Posts;