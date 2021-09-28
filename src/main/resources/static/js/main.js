console.log('Hello');

const colors = ["lightblue", "darkblue", "blue", "orange", "yellow", "blue"];

const cards = $('.card.small');

cards.each(function(){
    $(this).addClass(randomFromArray(colors))
});

$('.delete').click(function(){
    deleteRequest(this);
})


function deleteRequest(node) {
    $.ajax({
        url: node.dataset.href,
        type: 'DELETE',
        success: function (result) {
            console.log('success');
            document.getElementById('list').click();
        }
    });
}

function randomFromArray(array){
    return array[Math.random() * array.length | 0];
}

