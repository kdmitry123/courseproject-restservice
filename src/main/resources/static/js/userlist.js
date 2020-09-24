var allUsers = Vue.resource('/users/getall');

Vue.component('user-row', {
    props: ['user'],
    template: '<div> <hr>' +
        '<h5><u>{{ user.firstName }}' + ' ' + '{{ user.secondName }}</u></h5><br>' +
        '<label>User email:</label>'+ ' ' + '{{ user.email }}<br>' +
        '<label>User roles:</label> '+ ' ' + '{{ user.role }}<br><hr></div>'
});

Vue.component('user-list', {
    props: ['users'],
    template: '<div>' +
            '<user-row v-for="user in users" :key="user.id" :user="user"/>' +
        '</div>',
    created: function () {
        allUsers.get().then(result => result.json().then(data =>
            data.forEach(user => this.users.push(user))
             )
        )
    }
});

var app = new Vue({
    el: '#app1',
    template: '<user-list :users="users" />',
    data: {
        users: []
    }
});