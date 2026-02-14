$(function(){ //jQuery 시작
       $('ul.tab li').eq(0).addClass('on'); 
       /*첫번째 탭버튼에 활성화*/
          $('#s5_3_all > div').hide(); /*탭결과를 다 지우기*/ 
          $('#s5_3_all > div').eq(0).show();
           
          $('ul.tab li').click(function(){
              $('ul.tab li').removeClass('on'); /*탭버튼 초기화*/
              $(this).addClass('on');
              
              $('#s5_3_all > div').hide();
              $('#s5_3_all > div').eq($(this).index()).show(); 
              
              return false;
              
              
          });
          
           
      }); //jQuery 종료