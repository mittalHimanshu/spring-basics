import React, { Component } from 'react';
import axios from 'axios'

class Login extends Component {

    state = {
        usernameOrEmail: null,
        password: null
    }

    handleInput = event => {
        this.setState({
            [event.target.name] : event.target.value
        })
    }

    onLogin = () => {
        if(localStorage.getItem('accessToken')) {
            var headers = {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('accessToken')}`
            }
            console.log(headers)
            axios.get('/api/user/me', {headers})
                .then(response => {
                    console.log(response)
                })
        }
        else{
            console.log("no access token")
        }
    }

    handleSubmit = event => {
        event.preventDefault();   
        axios.post(`/api/auth/signIn`, this.state)
        .then(response => {
            localStorage.setItem('accessToken', response.data.accessToken);
            this.onLogin()
        })
        .catch(error => {
            if(error.status === 401) {
                // description: 'Your Username or Password is incorrect. Please try again!'                  
            } else {
                // description: error.message || 'Sorry! Something went wrong. Please try again!'
            }
        })
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                Username : <input onChange={this.handleInput} name="usernameOrEmail" type='text'></input>
                Password : <input onChange={this.handleInput} name="password" type='password'></input>
                <input type='submit' value='Submit'></input>
            </form>
        );
    }
}

export default Login;