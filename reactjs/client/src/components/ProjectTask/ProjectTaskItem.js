import React, { Component } from "react";
import { Link } from "react-router-dom";
import { connect } from 'react-redux'
import { deleteProjectTask } from "../../actions/projectTaskActions";

class ProjectTaskItem extends Component {

  onDeleteClick = pt_id => {
    this.props.deleteProjectTask(pt_id)
  }

  render() {
    const { task } = this.props;
    return (
      <div className="card mb-1 bg-light">
        <div className="card-header text-primary">ID: {task.id}</div>
        <div className="card-body bg-light">
          <h5 className="card-title">{task.summary}</h5>
          <p className="card-text text-truncate ">
            {task.acceptanceCriteria}
          </p>
          <Link to={`updateProjectTask/${task.id}`} className="btn btn-primary">
            View / Update
          </Link>
          <button className="btn btn-danger ml-4" onClick={() => this.onDeleteClick(task.id)}>
            Delete
          </button>
        </div>
      </div>
    );
  }
}

export default connect(null, {deleteProjectTask}) (ProjectTaskItem)