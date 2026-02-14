$(function(){ //jQuery 시작
       $('ul.tab li').eq(0).addClass('on'); 
       /*첫번째 탭버튼에 활성화*/
          $('#s1_2_all > div').hide(); /*탭결과를 다 지우기*/ 
          $('#s1_2_all > div').eq(0).show();
      
          
           var target=$('.join_member');
          $('ul.tab li').click(function(){
              var i=$(this).index();
              $('ul.tab li').removeClass('on'); /*탭버튼 초기화*/
              $(this).addClass('on');
              
              $('#s1_2_all > div').hide();
              $('#s1_2_all > div').eq(i).show();
              if(i==0){
                  target=$('.join_member');
              }else{
                  target=$('.unjoin_member');
              }
               joinM();
              return false;
              
        });
        joinM();
        function joinM(){
         target.find('.list_radio ul li .ph0').prop('checked',true);
         target.find('.list_radio ul li').eq(0).addClass('on');
         /*target.find('.result_doc > select').hide();
         target.find('.result_doc > select').eq(0).show();*/
         target.find('.result_doc > select').show();
        };
            
            
       $('.join_member').find('.list_radio ul li').click(function(){
           
            chF(target);
            
        });
       $('.unjoin_member').find('.list_radio ul li').click(function(){
         
            chF(target);
            
        });
        
        function chF(targeti){
           /* targeti.find('.result_doc > select').hide();*/
           targeti.find('.list_radio ul li').removeClass('on');    
           $(this).addClass('on');
             
/*           if(targeti.find('.ph0').is(':checked')){
            targeti.find('.result_doc > select.list0').show();
            }
            else if(targeti.find('.ph1').is(':checked')){
            targeti.find('.result_doc > select.list1').show();
            }
            else if(targeti.find('.ph2').is(':checked')){
            targeti.find('.result_doc > select.list2').show();
            }
            else if(targeti.find('.ph3').is(':checked')){
            targeti.find('.result_doc > select.list3').show();
            }
            else if(targeti.find('.ph4').is(':checked')){
            targeti.find('.result_doc > select.list4').show();
            }
            else if(targeti.find('.ph5').is(':checked')){
            targeti.find('.result_doc > select.list5').show();
            }  */
/*            const dept = targeti.find('input[type=radio]:checked').val();
		    changeDoctors(dept);*/
		
		    //targeti.find('.result_doc > select').show();
        
        }
 
    
    
          
           
      }); //jQuery 종료