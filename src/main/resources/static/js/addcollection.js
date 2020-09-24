var saveCollection = Vue.resource('/collections/add');


Vue.component('collection-form', {
    props: ['collections'],
    data: function () {
        return{
            name: '',
            description: '',
            image: '',
            userEmail: ''
        }
    },

    template:
        '<div>' +
        '<label>Название коллекции: </label><input type="text" placeholder="Enter collection name" v-model="name" /><br>' +
        '<label>Описание: </label><input type="text" placeholder="Enter description" v-model="description"/><br>' +
        '<label>Изображение: </label><input type="text" placeholder="Enter image url" v-model="image" /><br>' +
        '<label>Email пользованителя: </label><input type="text" placeholder="Enter email" v-model="email" /><br>' +
        '<input type="button" value="Save collection" @click="addcollection" />' +
        '</div>',

    methods: {
        addcollection: function () {
            var collection ={
                name: this.name,
                description: this.description,
                image: this.image,
                userEmail: this.email
            };
            saveCollection.save({}, collection).then(result => result.json().then(data => {
                this.collections.push(data)
            }));
            this.email = '';
            this.name = '';
            this.description = '';
            this.image = '';
        }
    }
});


var app = new Vue({
    el: '#app3',
    template: '<collection-form :collections="collections" />',
    data: {
        collections: []
    }
});