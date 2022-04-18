import { Navigate, Routes, Route } from "react-router-dom";
import NewPost from '../components/NewPost/NewPost';
import Posts from '../containers/Posts/Posts';
import PostDetails from '../components/PostDetails/PostDetails';


const PageRoutes = () => {
  return (
    <Routes>
       <Route path="/" element={<Navigate replace to="/posts" />} />
       <Route path="posts" element={<Posts />} >
           <Route path=":id" element={<PostDetails />} />
       </Route>
       <Route path="create-post" element={<NewPost />} />
    </Routes>
    );

}

 export default PageRoutes;