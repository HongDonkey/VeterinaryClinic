var $ = jQuery;

$(function(){ //jQuery 시작

     /*PC 네비게이션*/       
     $('#navi, #navi_bg').mouseenter(function(){
     $('#navi > ul > li > .navi_sec, #navi_bg').stop().slideDown('fast');
         
     }).mouseleave(function(){
     $('#navi > ul > li > .navi_sec, #navi_bg').stop().slideUp('fast');
           });
          
     
    /* 모바일 메뉴 복제 */
     var naviClon = $('#navi').contents().clone();
     
     naviClon.appendTo('#mb_menu_gnb');
    
    
    /* 모바일 메뉴 활성화 */
    $('#mb_menu_gnb > ul > li:eq(0) > a').addClass('selected');
    
      $('#mb_menu_gnb > ul > li > a').click(function(){
          
         
      $('#mb_menu_gnb > ul > li > a').removeClass('selected');
          
      $(this).addClass('selected');
          
      $('#mb_menu_gnb > ul > li > +.navi_sec').hide();
      $(this).find('+.navi_sec').show();
          
      return false;      
      });
    
    
    /* 모바일 메뉴 버튼 클릭시 메뉴 보임 */
      var time = 500;
     $('#mb_menu_icon').click(function(){
        $('#mb_menu').stop().animate({
            right : 0
        },time)         
    
     }); 
     /* 닫기 버튼 클릭시 모바일 메뉴 사라짐*/
     $('#close_icon').click(function(){
         $('#mb_menu').stop().animate({
             right : '-100%'
        },time)
     
         $('#mb_menu_gnb > ul > li > a').removeClass('selected');
         $('#mb_menu_gnb > ul > li:eq(0) > a').addClass('selected');
         
         $('#mb_menu_gnb > ul > li > +.navi_sec').hide();
         $('#mb_menu_gnb > ul > li:eq(0) > +.navi_sec').show();
        
         });
         
         /* 모바일 네비게이션 창 열고 pc로 이동하고 다시 모바일로 이동 시
         네비게이션 초기화 상태*/
         $(window).resize(function(){
         if($(this).outerWidth()>800){     
         $('#mb_menu_gnb > ul > li > a').removeClass('selected');
         $('#mb_menu_gnb > ul > li:eq(0) > a').addClass('selected');     
         $('#mb_menu_gnb > ul > li > +.navi_sec').hide();
         $('#mb_menu_gnb > ul > li:eq(0) > +.navi_sec').show();
             
         }
             
             
         });
    
         //팝업창 구현
         $('#popup').animate({
              top: '50px', /*숫자와 단위쓸때 ''사용해야함*/ /*style에 popup top값과 조절해서 입력*/
              opacity: 1
          },1000,'easeOutBounce'); /*1초 동안에*/
           
          $('.pop_close').click(function(){
              $('#popup').hide();
          }); 
     
    
       
        
      }); //jQuery 종료