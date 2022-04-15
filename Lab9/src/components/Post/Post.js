import { Selected } from "../../store/Selected";
import React, { useContext } from "react";
import './Post.css'
const Post = (props) => {
  
    const setSelected = useContext(Selected);
    return (
          
        <div className="Content" onClick={() => { setSelected(props.id)}}>
              <div className="Field">
               <div><p>Id:{props.id}</p></div>
                <div><p>Title:{props.title}  </p></div>
                <div><p>Author:{props.author} </p></div>
            </div>
         </div>
         
    );
    
}

export default Post;