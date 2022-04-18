import { Selected } from "../../store/Selected";
import React, { useContext } from "react";
import './Post.css'
const Post = (props) => {
  
    
    return (
          
        <div className="Content" >
              <div className="Field">
               <div><p>{props.id}</p></div>
                <div><p>{props.title}  </p></div>
                <div><p>{props.author} </p></div>
            </div>
         </div>
         
    );
    
}

export default Post;