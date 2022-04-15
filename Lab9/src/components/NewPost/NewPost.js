import { useRef } from "react";
import axios from "axios"; 
import './NewPost.css';

const NewPost = (props) => {


       const newPostForm = useRef();
       const postTitle = useRef();

       const addButtonClicked = () => {
       console.log(postTitle.current.value)
       const form = newPostForm.current;
       const post = 
         {
            id:form['id'].value , 
            title:form['title'].value , 
            author:form['author'].value
          }


        axios.post('http://localhost:8080/api/v1/posts', post)
            .then(response => {
                props.changeFetchFlag();
            })
            
    }

    return (
        <div className="NewPost">
            <form ref = {newPostForm}>

                <h1> Add Post</h1>

                <label>Id</label>
                <input type="text" label={'id'} name={'id'} />

                <label>Title</label>
                <input ref={postTitle} type="text" label={'title'} name={'title'} />

                <label>Author</label>
                <input type="text" label={'author'} name={'author'} />
            </form>


            <button onClick={addButtonClicked} > Add Post</button>
        </div>
    );

}

export default NewPost