import { useRef } from "react";
import axios from "axios"; 
import './NewPost.css';
import { useNavigate } from "react-router-dom";

const NewPost = (props) => {

       const navigate = useNavigate();
       const newPostForm = useRef();
       //const postTitle = useRef();

       const addButtonClicked = (e) => {
           e.preventDefault();
       //console.log(postTitle.current.value)
       const form = newPostForm.current;
       const post = 
         {
            //id:form['id'].value , 
            title:form['title'].value , 
            content:form['content'].value,
            author:form['author'].value
          }


        axios.post('http://localhost:8080/api/v1/posts', post)
            .then(response => {
                console.log("saved")
                navigate('/posts');
            })
           .catch()
    }

    return (
        <div className="NewPost">
            <form ref = {newPostForm} onSubmit={addButtonClicked}>

                <h1> Add Post</h1>

                <label>Title</label>
                <input  type="text" label={'title'} name={'title'} />

                <label>Content</label>
                <input type="text" label={'id'} name={'content'} />

                <label>Author</label>
                <input type="text" label={'author'} name={'author'} />

            <button > Add Post</button>
            </form>
        </div>
    );

}

export default NewPost;


// onClick={addButtonClicked}