 $(function(){ //jQuery 시작
     var target = $('#main_top_img');
     var visual = target.find('.swiper-slide');
     var visualLen = visual.length; /*이미지 개수*/
     
     var cnt = 0; // 현재 이미지 번호 (첫번째 사진) 
     var setTime; //시간 기억
     var dir = 'next'; //다음 이미지가 나오도록
     
     
     
     //블릿 버튼 변수 정의
     var button = target.find('#main_slide_box ul li');
     button.eq(0).addClass('on');
           
     button.click(function(){
         var tg = $(this);
         var i = tg.index();
         
         button.removeClass('on');
         tg.addClass('on');
         
         move(i); /*move(n)이여도 무방*/
         
         return false;
     });
     
     function move(i){ 
     /*지역변수,이안에서만 사용,위에 내용과 별개 그래서 같은 i써도 무방 위에 move(i)가 넘겨주고 끝난거임 결국 위에 i와 같은 i가 아님*/
        if(cnt == i) return;
         
         //현재 이미지
         var cnt_img = visual.eq(cnt);
         
         //새로 보여질 이미지
         var next_img = visual.eq(i);
         
         if(dir == 'prev'){
                cnt_img.css({left:0}).stop().animate({left:'100%'});
                next_img.css({left:'-100%'}).stop().animate({left:0})
            }else{
                cnt_img.css({left:0}).stop().animate({left:'-100%'});
                next_img.css({left:'100%'}).stop().animate({left:0})
                
            }
         
         cnt = i;
         
     }
     
        target.find('.top_next').click(function(){
            dir = 'next';
            var n = cnt + 1;
            if( n == visualLen){
                n = 0;
            }
            button.eq(n).trigger('click');
       });
     
      target.find('.top_prev').click(function(){
            dir = 'prev';
            var n = cnt - 1;
            if( n < 0 ){
                n = visualLen - 1;
            }
            button.eq(n).trigger('click');
       });
     
     
     timer(); //시간제어 함수
     
     function timer(){
         setTime = setInterval(function(){
            var n = cnt + 1;
            if( n == visualLen){
                n = 0;
            }
            button.eq(n).trigger('click');
          },5000);
             
    }
         target.mouseover(function(){
             clearInterval(setTime); /*멈춤*/
         }).mouseout(function(){
            timer();  /*다시 재동*/
         });
     
     
     
     
    
     
         
     
       }); //jQuery 종료