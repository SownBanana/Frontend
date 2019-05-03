document.addEventListener("DOMContentLoaded", function () {
    var click = document.getElementsByClassName('m');
    for (var i = 0; i < click.length; i++) {
        click[i].onclick = function () {
            for (var j = 0; j < click.length; j++) {
                click[j].classList.remove('m1');
                var id = click[j].getAttribute("data-item");
                var mitem = document.getElementById(id);
                mitem.classList.remove('hienItem');
            }
            this.classList.add('m1');
            var id = this.getAttribute("data-item");
            var mitem = document.getElementById(id);
            mitem.classList.add('hienItem');
        }
    }

    // slide
    var nut = document.getElementsByClassName('nut');
    var slide = document.querySelector('.main_slide ul');
    var nuttrai = document.querySelector('.nuttrai');
    var nutphai = document.querySelector('.nutphai');
    for (var i = 0; i < nut.length; i++){
        nut[i].onclick = function () {
            for(var j = 0; j < nut.length; j++){
                nut[j].classList.remove('activenut');
                }
            
            this.classList.add('activenut');
    //tim vi tri
            var nowbut =  document.querySelector('.activenut'); 
            for (var pos = 0; nowbut = nowbut.previousElementSibling; pos++);
            for(var i = 1; i < nut.length + 1; i++){
                slide.classList.remove('so'+i);
            }
            slide.classList.add('so'+(pos+1));
        }
    }
    console.log(nut);
    nutphai.onclick = function () {;
        //tim vi tri
        var nowbut =  document.querySelector('.activenut'); 
        for (var pos = 0; nowbut = nowbut.previousElementSibling; pos++);
        console.log(pos);
        if(pos >= nut.length - 1){
            pos = -1;
        }
        console.log(pos);
        for(var i = 1; i < nut.length + 1; i++){
            slide.classList.remove('so'+i);
            console.log(nut[i-1]);
            nut[i-1].classList.remove('activenut');
        }
        slide.classList.add('so'+(pos+2));
        nut[pos+1].classList.add('activenut');
    }
    nuttrai.onclick = function () {
        //tim vi tri
        var nowbut =  document.querySelector('.activenut'); 
        for (var pos = 0; nowbut = nowbut.previousElementSibling; pos++);
        console.log(pos);
        if(pos < 1){
            pos = nut.length - 1;
        }
        for(var i = 1; i < nut.length + 1; i++){
            slide.classList.remove('so'+i);
            console.log(nut[i-1]);
            nut[i-1].classList.remove('activenut');
        }
        slide.classList.add('so'+(pos));
        nut[pos-1].classList.add('activenut');
    }



        baohanh
    var table = document.getElementById('tablebh');
    var trabh = document.getElementById('trabh');
    trabh.onclick = function(){
    table.classList.toggle('hienbang');
    }
}, false)
