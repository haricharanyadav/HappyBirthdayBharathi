function myFunction(){
    if($('#next #h').html().includes("Eighth")){
        $('#next, #img').hide();
        $('#video').show();
    }
    else{
    $('#details, #entry').hide();
    sendAnswer();
    window.scrollTo(0,0);
    $('input[type="radio"]').prop( "checked", false );
    $('#send1').prop('disabled', true);
    }

}
function closePopUp(){
    $('#ac-wrapper').hide();
}
function sendAnswer() {
    var str = $('#next #h').html();
    $.ajax({
        type : 'POST',
          url : 'http://localhost:8080/sendAnswer',
          dataType : 'json',
          contentType: 'application/json; charset=utf-8',

          data : JSON.stringify({"questionNumber": str.substring(0,str.indexOf(" ")),"ans": $(".message_pri:checked").val(), "question": $('#next #q1').html()}),
          success: function(data){
           console.log(data);
           $('#next').show();
           $('#next #h').html(data.questionNumber+" Question");
           $('#q1').html(data.question);
           $('#v1').attr("value", data.option1);
           $('#o1').html(data.option1);
           $('#v2').attr("value", data.option2);
           $('#o2').html(data.option2);
           $('#v3').attr("value", data.option3);
           $('#o3').html(data.option3);
           $('#img').attr("src", data.image);
        }
    });
    window.scrollTo(0,0);
}
