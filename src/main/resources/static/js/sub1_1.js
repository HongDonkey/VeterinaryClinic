$(function(){ //jQuery 시작
       $('#s1_1_con_wrap ul.tab li').eq(0).addClass('on'); 
       /*첫번째 탭버튼에 활성화*/
          $('#s1_1_dr_box_wrap > div').hide(); /*탭결과를 다 지우기*/ 
          $('#s1_1_dr_box_wrap > div').eq(0).show();
           
          $('#s1_1_con_wrap ul.tab li').click(function(){
              $('#s1_1_con_wrap ul.tab li').removeClass('on'); /*탭버튼 초기화*/
              $(this).addClass('on');
              
              $('#s1_1_dr_box_wrap > div').hide();
              $('#s1_1_dr_box_wrap > div ').eq($(this).index()).show(); 
              
              return false;
              
              
              
               $('.view_btn > h3').click(function(){
              $('#glaylayer').show().css({display:'flex'});  /*block이 아닌 flex으로 해야됨*/
              
              $('#overlayer figure .big').attr({
                  src:$(this).find('a').attr('href'),
                  alt:$(this).find('a img').attr('alt') /*이미지의 속성 alt 가져오기*/
              });
              return false;
          });
           
             $('.md_btn_close').click(function(){
           
              $('#glaylayer').hide();
             });
              
              
          });
          
           
      }); //jQuery 종료