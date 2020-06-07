function myFunction(){
    if($('#next #h').html().includes("Eighth")){
        window.scrollTo(0,0);
        if($(".message_pri:checked").val() == "Flying"){
            $('#text').html("You will most probably crash into a plane and die.");
            
        }
        else if($(".message_pri:checked").val() == "Invisibility"){
            $('#text').html("Spying on people is wrong.. you will be jailed");
        }
        else{
            $('#text').html("You trip and fall but due to your speed you will die");
        }
        $('#text2').html("Happy Birthday re!!, it aint much of a present.. its just a video. I hope you Like it.. Bye!!");
        $('#text3').html("If you want to try again with different answers. Just refresh the page.");
        $('#myModal').show();
        $('#next, #img').hide();
        $('#video').show();
    }
    else{
        $('#text1').html("Note: Sorry for inconvinence...Dont close the pop-up till background image changes(apx:10secs)");
        if($('#next #h').html().includes("First")){
            if($(".message_pri:checked").val() == "Yes"){
                $('#text').html("Yes!, Bharathi is an Big Idiot!!!!!!!.");
            }
            else{
                $('#text').html("No!, Bharathi is an Big Idiot!!!!!!!!");
            }
        }
        else if($('#next #h').html().includes("Second")){
            $('#text').html("Oooofffffoooooo!! BHARATHI LIKES "+ $(".message_pri:checked").val());
        }
        else if($('#next #h').html().includes("Third")){
            $('#text').html("Awwwhhhhh I'll tell "+ $(".message_pri:checked").val()+", that you hate her");
        }
        else if($('#next #h').html().includes("Fourth")){
            $('#text').html("I'll tell your parents that you want "+ $(".message_pri:checked").val());
        }
        else if($('#next #h').html().includes("Fifth")){
            if($(".message_pri:checked").val() == "My Brain"){
                $('#text').html("Yes!, you definitly need to change your Brain");
            }
            else if($(".message_pri:checked").val() == "My Attitude"){
                $('#text').html("I think your attritude is fine, i guess...");
            }
            else{
                $('#text').html("Abbooo, Your Life is fine Idiot. I hopeyou get what you want");
            }
        }
        else if($('#next #h').html().includes("Sixth")){
            if($(".message_pri:checked").val() == "A kiss from someone SPECIAL!"){
                $('#text').html("Ooooffffooo.... Bharathi Come on...full too!!");
            }
            else if($(".message_pri:checked").val() == "To Kill someone"){
                $('#text').html("You will go to jail re IDIOT!!!!");
            }
            else{
                $('#text').html("Hahahah, Congratulations on your Wedding.....");
            }
        }
        else if($('#next #h').html().includes("Seventh")){
            if($(".message_pri:checked").val() == "Niharika"){
                $('#text').html("I think it is perfect combination!!!!!");
            }
            else if($(".message_pri:checked").val() == "Lasya"){
                $('#text').html("I dont know who is she but All the best!!!!");
            }
            else{
                $('#text').html("WERID!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }
        
        $('#myModal').show();
        
    $('#details, #entry').hide();
    sendAnswer();
    window.scrollTo(0,0);
    $('input[type="radio"]').prop( "checked", false );
    $('#send1').prop('disabled', true);
    }

}
function popIt(){
    $('#myModal').hide();
}
function closePopUp(){
    $('#ac-wrapper').hide();
}
function sendAnswer() {
    var str = $('#next #h').html();
    $.ajax({
        type : 'POST',
          url : '/sendAnswer',
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
