import React, { useState } from "react";
import Post from "../../components/Post/Post";
import Posts from "../../components/Posts/Posts";


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
