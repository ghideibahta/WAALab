 import { useState } from "react";
import axios from "axios";

  const NewPost = (props) => { 
  const [postState, setPostState] = useState(
    {
        //id: "",
        title: "",
        content: "",
        author: ""
    }
)

const onChange = (events) => {
    const updatedPost = { ...postState, [events.target.name]: events.target.value };
    setPostState(updatedPost);
}

const addButtonClicked = () => {
    axios.post('http://localhost:8080/api/v1/posts', postState)
        .then(response => {
            setPostState({ title: "",content: "", author: ""});
            props.changeFetchFlag();
        })
        .catch()

    
}

return (
    <div className="NewPost">
        <h1> Add Post</h1>

        <label>Title</label>
        <input type="text" label={'title'} name={'title'} onChange={onChange} value={postState.title} />

        <label>Content</label>
        <input type="text" label={'content'} name={'content'} onChange={onChange} value={postState.content} />

        <label>Author</label>
        <input type="text" label={'author'} name={'author'} onChange={onChange} value={postState.author} />

        <button onClick={addButtonClicked} > Add Post</button>
    </div>
);

}

export default NewPost