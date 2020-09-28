var sendComment = Vue.resource('/app/sendComment');



function send() {
    const textComment = document.getElementById("text").value;
    const collectionName = document.getElementById("collname").value;

    const comment = {
        'collectionName': collectionName,
        'text': textComment
    };

    sendComment.save({}, comment).then(result => result.json().then(data => {
        this.collections.push(data)
    }));
}

var app = new Vue({
    el: '#app4',
    // template: '<collection-form :collections="collections" />',
    // data: {
    //     collections: []
    // }
});