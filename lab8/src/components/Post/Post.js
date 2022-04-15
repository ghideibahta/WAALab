
import React from "react";
import './Post.css'
const Post = (props) => {
  
    return (
          
        <div className="Content" onClick={props.setSelected}>
              <div className="Field">
               <div><p>Id:{props.id}</p></div>
                <div><p>Title:{props.title}  </p></div>
                <div><p>Author:{props.author} </p></div>
            </div>
         </div>
         
    );
    
}

export default Post;