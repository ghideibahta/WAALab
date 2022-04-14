//import { response } from "express";

import React from "react";
import { useState } from "react";
import { titleHandler } from "react";

import Posts from "../../components/Posts/Posts";


const DashBoard = () => {
    const[postState, setPostState] = useState();
    const[posts, setPosts] = useState();
    const [title, setTitle] = useState("");
    const[selectedState, setSelectedState] = useState(0);
   
 
    /*const titleHandler = (title) => {
        posts[0].title = title;
        setPosts([...posts]);
    }*/

    const setSelected =(id)=> {
        setSelectedState(id);
        console.log(selectedState)
    }

    const onChange = (events) => {
        const updatedPost = { ...postState, [events.target.name]: events.target.value};
        setPostState(updatedPost)
    }
    

    return (
        <div>
            <fieldset className="form">
            <Posts />
                 
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
