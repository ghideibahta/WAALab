import Post from "../../components/Post/Post";

const Postss = (props) => {

      const posts = props.posts.map(post => {
        return <Post
            id={post.id} 
            title={post.title} 
            author={post.author} 
            key={post.id}
            

        />
    });
    return posts;

}

export default Postss;