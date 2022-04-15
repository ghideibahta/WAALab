import React from "react";
import { useState } from "react";
import NewPost from "../../components/NewPost/NewPost";
import PostDetails from "../../components/PostDetails/PostDetails";
import Posts from "../../components/Posts/Posts";
import { Selected } from "../../store/Selected";


const DashBoard = () => {

    const [selectedState, setSelectedState] = useState(0);
    const [fetchFlag, setFetchFlag] = useState(true);


    const setSelected = (id) => {
        setSelectedState(id);

    }

    const changeFetchFlag = (id) => {
        setFetchFlag(!fetchFlag);
    }

    return (
        <div>
            <Selected.Provider value={setSelected}>
                <div> <Posts
                    fetchFlag={fetchFlag} />
                </div>
                <div>
                    <PostDetails
                        id={selectedState}
                        changeFetchFlag={changeFetchFlag} />
                </div>
                <div> <NewPost
                    changeFetchFlag={changeFetchFlag} />
                </div>
            </Selected.Provider>
        </div>


    );
}
export default DashBoard;
