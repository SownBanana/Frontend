document.addEventListener("DOMContentLoaded", function () {
    var click = document.getElementsByClassName('m');
    for (var i = 0; i < click.length; i++) {
        console.log(click[i]);
        click[i].onclick = function () {
            console.log(click[i]);
            for (var j = 0; j < click.length; j++) {
                click[j].classList.remove('m1');
                var id = click[j].getAttribute("data-item");
                var mitem = document.getElementById(id);
                mitem.classList.remove('hienItem');
            }
            this.classList.add('m1');
            var id = this.getAttribute("data-item");
            console.log(id);
            var mitem = document.getElementById(id);
            console.log(mitem);
            mitem.classList.add('hienItem');
        }
    }
}, false)
