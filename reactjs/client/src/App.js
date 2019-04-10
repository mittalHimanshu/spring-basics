import React, {Component} from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import Navbar from "./components/Navbar";
import ProjectBoard from "./components/ProjectBoard";
import AddProjectTask from './components/ProjectTask/AddProjectTask'
import {BrowserRouter as Router, Route} from 'react-router-dom'
import {Provider} from 'react-redux'
import store from './store';
import UpdateProjectTask from './components/ProjectTask/UpdateProjectTask';

class App extends Component {
    render() {
        return (
            <Provider store={store}>
                <Router>
                    <div className="App">
                        <Navbar/>
                        <Route exact path='/' component={ProjectBoard}/>
                        <Route exact path='/updateProjectTask/:pt_id' component={UpdateProjectTask}/>
                        <Route exact path='/addProjectTask' component={AddProjectTask}/>
                    </div>
                </Router>
            </Provider>
        );
    }
}

export default App;
