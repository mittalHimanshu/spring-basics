import React, { Component } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import Navbar from "./components/Navbar";
import ProjectBoard from "./components/ProjectBoard";
import AddProjectTask from './components/ProjectTask/AddProjectTask'
import { BrowserRouter as Router, Route } from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <Router>
        <div className="App">
          <Navbar />
          <Route exact path='/' component={ProjectBoard} />
          <Route exact path='/addProjectTask' component={AddProjectTask} />
        </div>
      </Router>
    );
  }
}

export default App;
