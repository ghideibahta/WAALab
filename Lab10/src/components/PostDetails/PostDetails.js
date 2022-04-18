import axios from "axios";
import { useEffect, useState, Fragment} from "react";
import { useNavigate, useParams } from "react-router-dom";
import Comment from "../Comment/Comment";
import './PostDetails.css';

const PostDetails = () => {
    const navigate = useNavigate();
    const params = useParams();
    const[postDetail, setPostDetail] = useState({});//empty for the detail we want to render

    useEffect( 
      () => {
      if(params.id){
      axios.get('http://localhost:8080/api/v1/posts/' + params.id + '/comments')
           .then(response => {
             setPostDetail(response.data);
             //console.log((response.data));
           })
           .catch(e => console.log(e.message))
          }
    }
    , [params.id])


    const deleteButtonClicked = (id) => {
      axios.delete('http://localhost:8080/api/v1/posts/' + id)
           .then(response => {
            //
             
           })
           .catch(e=> { console.error(e);
    })
  }

   
       
  const space = <Fragment>&nbsp;&nbsp;</Fragment>;
    let postDetailsDisplay = null;
    if(params.id) {

     postDetailsDisplay = (
       <div className="PostDetail">
           <div>Post Details </div>
           <h1>{params.id}</h1>
           <h2>{params.title}</h2>
           <br />
            <div style={{textAlign: "left"}} >
             {space}Comment  <br />
                {postDetail.comments != null ? postDetail.comments
                .map(comment => {return <Comment  comment ={comment.comment} key={comment.id}/>}): null}       
           </div>
           <br />
           <button onClick ={ () =>{deleteButtonClicked(params.id)}}> Delete </button>
       </div>
    );
    }

    return postDetailsDisplay;
}
 
export default PostDetails;