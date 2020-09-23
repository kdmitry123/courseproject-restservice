var saveUser = Vue.resource('/users/add');

Vue.component('user-form', {
    props: ['users'],
    data: function () {
        return{
            email: '',
            firstName: '',
            password: '',
            role: ['',],
            secondName: ''
        }
    },

    template:
            '<div>' +
        '<label>Имя: </label><input type="text" placeholder="Enter firstName" v-model="firstName" /><br>' +
        '<label>Фамилия: </label><input type="text" placeholder="Enter secondName" v-model="secondName"/><br>' +
        '<label>Email: </label><input type="text" placeholder="Enter email" v-model="email" /><br>' +
        '<label>Password: </label><input type="password" placeholder="Enter password" v-model="password" /><br>' +
        '<fieldset><legend>Выберите роли</legend>' +
        '<input type="checkbox" id="role1" value="USER" />USER<br>' +
        '<input type="checkbox" id="role2" value="ADMIN" />ADMIN<br>' +
        '</fieldset><br>' +
        '<input type="button" value="Save user" @click="adduser" />' +
        '</div>',
    methods: {
        adduser: function () {
            var roles = [];
            var chbox1 = document.getElementById('role1');
            var chbox2 = document.getElementById('role2');
            if (chbox1.checked){
                roles.push(chbox1.value)
            }
            if(chbox2.checked){
                roles.push(chbox2.value)
            }
            var user ={
                email: this.email,
                firstName: this.firstName,
                password: this.password,
                role: roles,
                secondName: this.secondName
            };
            saveUser.save({}, user).then(result => result.json().then(data => {
                this.users.push(data)
            }));
            this.email = '';
            this.firstName = '';
            this.password = '';
            this.role = '';
            this.secondName = '';
        }
    }
});

var app = new Vue({
    el: '#app2',
    template: '<user-form :users="users" />',
    data: {
        users: []
    }
});