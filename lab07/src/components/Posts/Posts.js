import React from 'react';
import './Posts.css';

const Posts = (props) => {

    return ( 
        <div className="Posts">
            <h1> Update Title</h1>
            <label>Title: </label>
            <input type="text" /> 
            <button onClick={props.changeButtonClicked}>Change Name</button>
        </div>
    );

   

}

export default Posts;