$(function(){ //jQuery 시작
    $('#con_sub_navi .con_navi_sec').hide();
    
    $('#con_sub_navi > ul > li:eq(0) > a').click(function(){
        $('#con_sub_navi> ul > li:eq(1) .con_navi_sec').slideUp();
     $(this).toggleClass('on');

     $(this).find('+.con_navi_sec').slideToggle('fast');
    
        
     $(this).find('.arrow_btn').toggleClass('up');
    
    
    });
    
    $('#con_sub_navi > ul > li:eq(1) > a').click(function(){
        $('#con_sub_navi ul > li:eq(0) .con_navi_sec').slideUp();
     $(this).toggleClass('on');

     $(this).find('+.con_navi_sec').slideToggle('fast');
    
        
     $(this).find('.arrow_btn').toggleClass('up');
    
    
    });
    
    }); //jQuery 종료