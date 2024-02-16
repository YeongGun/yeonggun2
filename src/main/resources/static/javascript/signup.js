
$(funtion(){
    $(".step1").css("color","#222");

});

function agreeBt(){

}
function submit(){

}
#main{
    width:400%
    padding:30px 0 100px 0;
    position:relative;
}

$("#allAgree").on("change",function(){
    var is Chk = $(this).is(":checked");
    if(isChk){
        $("input[name=accept]").prop('checked',true);
        $("#join_btn").addClass("on");
    }else{
       $("input[name=accept]").prop('checked',false);
       $("#join_btn").removeClass("on");
    }
})

// 가입 양식
$(".write_list input").on("keyup",function(){
    var isValue=true;
    $(".write_list input").each(function(i,v){
    if( $(v).val()=='' ){
    isValue=false;
    return;
    }
});

if( isValue ){
    $("#submit_btn").addClass("on");
    }else{
        $("#submit_btn").removeClass("on");
    }