
/*import { useState } from 'react';
import Post from '../../containers/Postss/Postss';
import Posts from '../../components/Posts/Posts';


const Dashboard = (props) => {
    
    
    const[postssState, setPostssState] = useState(
        [
            {id:111, title:"Happiness", author:"John"},
            {id:112, title: "MIU", author:"Dean"},
            {id:113, title: "Enjoy Life", author:"Jasmine"},

        ]
    );

    const [postState, setPostState] = useState(
        {
            
            Title: "",
            //Author: ""
        }
    )

   const onClick = (event)=> {
        /*const copy = { ...postState };
        copy[event.target.title] = event.target.value;
        setPostState(copy.Title);*/

        /*this.setPostState(state => {
            const newTitle = state.title + "0";
            return { newTitle}
        })
    } 

    const changeButtonClicked = () => {
        const copy = { ...postState };
        //copy.id = i;
        //i++;
        //copy.id=111;
        postState.id =111;
        const copyPostssState= [...postssState]
        copyPostssState.push(copy.Title);
        setPostssState(copyPostssState);
    }

    return (
        <div>
        <Post posts={postssState} />
        <Posts
           // id={postssState.id}
            title={postssState.title}
            //author={postssState.author}
            onClick={(event) => { onClick(event) }}
            changeButtonClicked={changeButtonClicked}
            
        />
       </div>
    )   
    
}

export default Dashboard;*/



import React, { useState } from "react";
import Post from "../../Components/Post";
import Posts from "../../Containers/Posts";
import "./DashBoard.css";


const DashBoard = () => {
    const [title, setTitle] = useState("");
    const [posts, setPosts] = useState(
        [
            { id: 111, title: 'Happiness', author: 'John' },
            { id: 112, title: 'MIU', author: 'Dean' },
            { id: 113, title: 'EnjoyLife', author: 'Jasmine' }
        ]);
    const titleHandler = (title) => {
        posts[0].title = title;
        setPosts([...posts]);
    }

    return (
        <div>
            <Posts posts={posts} />
            <fieldset className="form">
                <input
                    type="text"
                    id="newTitle"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    placeholder="Enter new title">
                </input>
                <br /><br />
                <button onClick={() => titleHandler(title)}>Change Title</button>
            </fieldset>
        </div>

);
}
export default DashBoard;