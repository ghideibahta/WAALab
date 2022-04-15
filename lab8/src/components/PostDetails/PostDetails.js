import axios from "axios";
import { useEffect, useState } from "react";
import Comment from "../Comment/Comment";
//import './ProductDetails.css';

const PostDetails = (props) => {

    const[postDetail, setPostDetail] = useState({});//empty for the detail we want to render

    useEffect( () => {
      axios.get('http://localhost:8080/api/v1/posts/' + props.id + '/comments')
           .then(response => {
             setPostDetail(response.data);
           })
           .catch(e => console.log(e.message))
    }, [props.id])


    const deleteButtonClicked = (id) => {
      axios.delete('http://localhost:8080/api/v1/posts/' + id)
           .then(response => {
           props.changeFetchFlag();
             
           })
           .catch(e=> { console.error(e);
    })
  }

   
       

    let postDetailsDisplay = null;
    if(props.id !==0) {

     postDetailsDisplay = (
       <div className="ProductDetail">
           <div>Post Details </div>
           <h1>{postDetail.title}</h1>
           <div>Comment
                {postDetail.comments != null ? postDetail.comments
                .map(comment => {return <Comment  comment ={comment.name} key={comment.id}/>}): null} 
           </div>
           <button onClick ={ () =>{deleteButtonClicked(props.id)}}> Delete </button>
       </div>
    );
    }

    return postDetailsDisplay;
}
 
export default PostDetails;