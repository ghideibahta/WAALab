import React from "react";
import Header from "../containers/Headers/Header";
import "../containers/Headers/Header.css";
import PageRoutes from "./PageRoutes";


const DashBoard = () => {

    return (
            <React.Fragment>
                <div className="header">
                    <Header />
                </div>
                
                   <div className="Post"> 
                    <PageRoutes/>
                  
                    </div>
                    </React.Fragment>

    );
}
export default DashBoard;
