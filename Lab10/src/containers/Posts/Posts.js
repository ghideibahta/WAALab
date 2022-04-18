import React, { useEffect } from 'react';
import Post from '../../components/Post/Post';
import { useState } from 'react';
import axios from 'axios';
import './Posts.css';
import { Link } from "react-router-dom";
import PostDetails from '../../components/PostDetails/PostDetails';

const Posts = (props) => {

    const [posts, setPosts] = useState(
        [
            { id: 111, title: 'Happiness', author: 'John' },
            { id: 112, title: 'MIU', author: 'Dean' },
            { id: 113, title: 'EnjoyLife', author: 'Jasmine' }
        ])

        const fetchPosts = () => {
            axios.get('http://localhost:8080/api/v1/posts')
                .then(response => {
                    setPosts(response.data)
                })
                .catch(error => {
                    console.log(error.message)
                })
            
        }
    
        useEffect(() => {
          fetchPosts();
        },
        [props.fetchFlag])


    const postsList = posts.map(post => {
        return (
            <Link to={`${post.id}`} key={post.id}  >
            <Post 
            id={post.id} 
            title={post.title} 
            author={post.author}         
            
        />
        </Link>
        );
    });
    return(
        <div className='Posts'>
           {postsList}
           <PostDetails />
        </div> 
    );

}


export default Posts;