$(function(){ //jQuery 시작
  var $img = $('#s6_1_con1')
  var  $addItemCount = 2;
  var  $added = 5;
  var len=$img.find('ul li').length;
    
   $img.find('ul li').hide();
   $('#s6_2_btn').hide();
    
    for(var i = 0; i<6;i++){
        $img.find('ul li').eq(i).show();
    }
    $('#s6_1_btn a').click(function(){
        
        $added += $addItemCount;
        //console.log($added)
         /*alert($added)*/
        if($added < len){
            $img.find('ul li').hide();
            for(var k = 0; k<=$added;k++){
            $img.find('ul li').eq(k).show();
            }
    }
        if($added == (len-1)){
           $('#s6_2_btn').show();
            $('#s6_1_btn').hide();
     }
        return false;
       });
    
     $('#s6_2_btn a').click(function(){
         $img.find('ul li').hide();
         for(var k = 0; k<6;k++){
            $img.find('ul li').eq(k).show();
        }
            $('#s6_1_btn').show();
            $('#s6_2_btn').hide();
         
         $added = 5; 
         /*다시 첫번쨰 화면 6개부터 시작*/
         
         return false; /*a태그 있을경우 꼭 기재
         안그러면 클릭할때마다 상단으로 이동*/
     });
    
    }); //jQuery 종료