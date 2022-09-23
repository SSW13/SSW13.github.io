<!doctype html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <title>jQuery UI Tabs - Default functionality</title>
   <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
   <link rel="stylesheet" href="jquery-ui/jquery-ui.css">
   <link rel="stylesheet" href="mk.css">
   <script src="jquery-2.1.3.min.js"></script>
   <script src="jquery-ui/jquery-ui.js"></script>
   <script>
   ///////////////////////POP UP/////////////////////////
   
   

   function showPopUp()
   {
	   $(".popupBackground").css("visibility","visible");
	   $(".popup").css("visibility","visible");
   }
   
   function closePopUp()
   {
	   $(".popupBackground").css("visibility","hidden");
	   $(".popup").css("visibility","hidden");
   }
   ///////////////////////END POP UP//////////////////////////
   ///////////////////////ORDER//////////////////////////
   function orderFood(food_id_x)
   {
	   $.post("create_order_detail.php",{ 
			food_id: food_id_x,
			order_id: order_now[0].id
			})
			.done(function(data){
			console.log(data);
			});
   }
   
   function getOrderDetailToShow_wait_confrim()
   {
	   $.post("get_all_order_detail_by_order_id.php",{ 
			status: "wait_confirm",
			order_id: order_now[0].id
			})
			.done(function(data){
			//console.log(data);
			showOrderDetailWaitConfirm(data);
			});
   }
   
   function getOrderDetailToShow_confrimed()
   {
	   $.post("get_all_order_detail_by_order_id.php",{ 
			status: "confirmed|served",
			order_id: order_now[0].id
			})
			.done(function(data){
			//console.log(data);
			showOrderDetailConfirmed(data);
			});
   }
   
   function confirmOrderDetail(OrderDetailId)
   {
	   $.post("confirm_order_detail.php",
		{
			order_detail_id: OrderDetailId
		})
		.done(function(data){
			console.log(data);
			getOrderDetailToShow_wait_confrim();
		});
   }
   
   function showOrderDetailWaitConfirm(data)
	{
	   OrderDetailWaitConfirm = JSON.parse(data);
	   /*
			"id"=>$id,
			"food_id"=>$food_id,
			"order_id"=>$order_id,
			"qty"=>$qty,
			"status"=>$status,
			"insert_time"=>$insert_time,
			"food_id_x"=>$food_id_x,
			"food_name"=>$food_name,
			"food_description"=>$food_description,
			"food_price"=>$food_price,
			"food_image"=>$food_image,
			"food_cat_id"=>$food_cat_id
		*/
		$("#wait_confirm_table").html("<tr>\
						<th>id</th>\
						<th>food_id</th>\
						<th>order_id</th>\
						<th>qty</th>\
						<th>status</th>\
						<th>insert_time</th>\
						<th>food_id_x</th>\
						<th>food_name</th>\
						<th>food_description</th>\
						<th>food_price</th>\
						<th>food_image</th>\
						<th>food_cat_id</th>\
						<th>ยืนยัน</th>\
					</tr>");
	   var template =
	   "	<tr>\
				<td>\
				{{[[--id--]]}}\
				</td>\
				<td>\
				{{[[--food_id--]]}}\
				</td>\
				<td>\
				{{[[--order_id--]]}}\
				</td>\
				<td>\
				{{[[--qty--]]}}\
				</td>\
				<td>\
				{{[[--status--]]}}\
				</td>\
				<td>\
				{{[[--insert_time--]]}}\
				</td>\
				<td>\
				{{[[--food_id_x--]]}}\
				</td>\
				<td>\
				{{[[--food_name--]]}}\
				</td>\
				<td>\
				{{[[--food_description--]]}}\
				</td>\
				<td>\
				{{[[--food_price--]]}}\
				</td>\
				<td>\
				{{[[--food_image--]]}}\
				</td>\
				<td>\
				{{[[--food_cat_id--]]}}\
				</td>\
				<td>\
				<button id='food_confirm_{{[[--id--]]}}' order_detail_id='{{[[--id--]]}}'>confirm</button>\
				</td>\
			</tr>";
			
		for(var i = 0; i < OrderDetailWaitConfirm.length ; i++)
		{
			var row_now = template;
			row_now = row_now.replace("{{[[--id--]]}}",OrderDetailWaitConfirm[i].id);
			row_now = row_now.replace("{{[[--id--]]}}",OrderDetailWaitConfirm[i].id);
			row_now = row_now.replace("{{[[--id--]]}}",OrderDetailWaitConfirm[i].id);
			row_now = row_now.replace("{{[[--food_id--]]}}",OrderDetailWaitConfirm[i].food_id);
			row_now = row_now.replace("{{[[--order_id--]]}}",OrderDetailWaitConfirm[i].order_id);
			row_now = row_now.replace("{{[[--qty--]]}}",OrderDetailWaitConfirm[i].qty);
			row_now = row_now.replace("{{[[--status--]]}}",OrderDetailWaitConfirm[i].status);
			row_now = row_now.replace("{{[[--insert_time--]]}}",OrderDetailWaitConfirm[i].insert_time);
			row_now = row_now.replace("{{[[--food_id_x--]]}}",OrderDetailWaitConfirm[i].food_id_x);
			row_now = row_now.replace("{{[[--food_name--]]}}",OrderDetailWaitConfirm[i].food_name);
			row_now = row_now.replace("{{[[--food_description--]]}}",OrderDetailWaitConfirm[i].food_description);
			row_now = row_now.replace("{{[[--food_price--]]}}",OrderDetailWaitConfirm[i].food_price);
			row_now = row_now.replace("{{[[--food_image--]]}}",OrderDetailWaitConfirm[i].food_image);
			row_now = row_now.replace("{{[[--food_cat_id--]]}}",OrderDetailWaitConfirm[i].food_cat_id);
			$("#wait_confirm_table").append(row_now);
			
			//add event to confrim button
			$("#food_confirm_"+OrderDetailWaitConfirm[i].id).click(
				function foodconfirmBtn()
				{					
					var OrderDetailId = $(this).attr('order_detail_id');
					confirmOrderDetail(OrderDetailId);
			});

		}
	   //$("#wait_confirm_table")
	   
	}
	
	function showOrderDetailConfirmed(data)
   {
	   OrderDetailConfirmed = JSON.parse(data);
		$("#confirmed_table").html("<tr>\
						<th>id</th>\
						<th>food_id</th>\
						<th>order_id</th>\
						<th>qty</th>\
						<th>status</th>\
						<th>insert_time</th>\
						<th>food_id_x</th>\
						<th>food_name</th>\
						<th>food_description</th>\
						<th>food_price</th>\
						<th>food_image</th>\
						<th>food_cat_id</th>\
					</tr>");
	   var template =
	   "	<tr>\
				<td>\
				{{[[--id--]]}}\
				</td>\
				<td>\
				{{[[--food_id--]]}}\
				</td>\
				<td>\
				{{[[--order_id--]]}}\
				</td>\
				<td>\
				{{[[--qty--]]}}\
				</td>\
				<td>\
				{{[[--status--]]}}\
				</td>\
				<td>\
				{{[[--insert_time--]]}}\
				</td>\
				<td>\
				{{[[--food_id_x--]]}}\
				</td>\
				<td>\
				{{[[--food_name--]]}}\
				</td>\
				<td>\
				{{[[--food_description--]]}}\
				</td>\
				<td>\
				{{[[--food_price--]]}}\
				</td>\
				<td>\
				{{[[--food_image--]]}}\
				</td>\
				<td>\
				{{[[--food_cat_id--]]}}\
				</td>\
			</tr>";
			
		for(var i = 0; i < OrderDetailConfirmed.length ; i++)
		{
			var row_now = template;
			row_now = row_now.replace("{{[[--id--]]}}",OrderDetailConfirmed[i].id);
			row_now = row_now.replace("{{[[--food_id--]]}}",OrderDetailConfirmed[i].food_id);
			row_now = row_now.replace("{{[[--order_id--]]}}",OrderDetailConfirmed[i].order_id);
			row_now = row_now.replace("{{[[--qty--]]}}",OrderDetailConfirmed[i].qty);
			row_now = row_now.replace("{{[[--status--]]}}",OrderDetailConfirmed[i].status);
			row_now = row_now.replace("{{[[--insert_time--]]}}",OrderDetailConfirmed[i].insert_time);
			row_now = row_now.replace("{{[[--food_id_x--]]}}",OrderDetailConfirmed[i].food_id_x);
			row_now = row_now.replace("{{[[--food_name--]]}}",OrderDetailConfirmed[i].food_name);
			row_now = row_now.replace("{{[[--food_description--]]}}",OrderDetailConfirmed[i].food_description);
			row_now = row_now.replace("{{[[--food_price--]]}}",OrderDetailConfirmed[i].food_price);
			row_now = row_now.replace("{{[[--food_image--]]}}",OrderDetailConfirmed[i].food_image);
			row_now = row_now.replace("{{[[--food_cat_id--]]}}",OrderDetailConfirmed[i].food_cat_id);
			$("#confirmed_table").append(row_now);
			
			//add event to confrim button
			$("#food_confirm_"+OrderDetailWaitConfirm[i].id).click(
				function foodconfirmBtn()
				{					
					var OrderDetailId = $(this).attr('order_detail_id');
					confirmOrderDetail(OrderDetailId);
			});
		}
	   //$("#wait_confirm_table")
	   
   }
   
   ///////////////////////END ORDER//////////////////////////
   ///////////////////////LOAD DATA///////////////////////
   var categories ;
   var all_food = [];
   var count ;
   var order_now;
   var OrderDetailWaitConfirm;
   var OrderDetailConfirmed;
   function addListernerToFoodTile(id)
   {
			var id_x = "#food_tile_id_"+id;
			
			$(id_x).css('cursor','pointer');
			
			$(id_x).mouseover(function(){
				$(this).css("background-color","#aaa");
			});
			$(id_x).mouseout(function(){
				$(this).css("background-color","#ddd");
			});
			$(id_x).mousedown(function(){
				$(this).css("background-color","#888");				
			});
			$(id_x).mouseup(function(){
				$(this).css("background-color","#aaa");				
			});
			$(id_x).click(function(){
				var food_id_x = $(this).attr('food_id');
				//console.log(food_id_x);	
				orderFood(food_id_x);			
			});
   }
   
   
   function loadCategory()
   {
      console.log("b");
      $.get("category/output/ajax_get_all_category.php", function(data, status){
        console.log("a");
        var categorys = JSON.parse(data);
        categories = categorys;
        for(var i = 0 ; i < categorys.length ; i ++)
        {
            var x = "<li><a href='#food_category_"+categorys[i].id+"'>"+categorys[i].name+"</a></li>";
            $("#category_tab").append(x);

            var y = "<div id='food_category_"+categorys[i].id+"'>\
			<div class='row' ></div>\
			</div>";
            $("#tabs").append(y);
        }
         
         

         ///

        loadFood();
      });
	};

   function loadFood()
   {
      count = 0;
      for(var i = 0 ; i < categories.length ; i ++){
		  $.ajax({url: "food/output/ajax_get_all_food.php?cat_id="+categories[i].id,
                 context: (i+1)}).done(function(data){
                     console.log(data);
                     var foods =  JSON.parse(data);
					 console.log(foods);
					 all_food.push(foods);
                     for(var j =0 ; j < foods.length ; j ++)
                     {
                        var template_food = "\
						<div id='food_tile_id_{{[[--ID--]]}}' class='food_tile col-md-4 ' food_id='{{[[--ID--]]}}'>\
						<img src='{{[[--IMAGE_PATH--]]}}'/>\
						<div class='headline'>{{[[--NAME--]]}}</div>\
						<div class='description'>{{[[--DESCRIPTION--]]}}</div>\
						<div class='price'>{{[[--PRICE--]]}}.-</div>\
						</div>";
						
						var food = template_food;
						food = food.replace("{{[[--ID--]]}}",foods[j].id);
						food = food.replace("{{[[--ID--]]}}",foods[j].id);
						food = food.replace("{{[[--IMAGE_PATH--]]}}",foods[j].image);
						food = food.replace("{{[[--NAME--]]}}",foods[j].name);
						food = food.replace("{{[[--DESCRIPTION--]]}}",foods[j].description);
						food = food.replace("{{[[--PRICE--]]}}",foods[j].price);
						
                        console.log(this-1);
                        console.log("categories[i].id" + categories[this-1].id);

                        $("#food_category_"+categories[this-1].id + ">div").append(food);
						addListernerToFoodTile(foods[j].id);
                     }
                     count ++;
                     $(function() {
                        $( "#tabs" ).tabs();
                     });                     
               });

		}
		

			setTimeout(
					function()
					{ 
					   $(function()
					   {
								$( "#tabs" ).tabs();
					   });
					}, 3000);
		   }
		   $( document ).ready(function() {
				loadCategory();
				
				showPopUp();
				
				
				
				
        
		$("#btn_open_table").click(function()
			{
				var table_no_x = $("#table_number").val();
				if(!isNaN(parseInt(table_no_x)))
				{
				}else{
					$("#popup_numberOnly").show();
					return;
				}
				
				console.log(table_no_x);
				
				/////// send http post to create new table ///////////
				$.post("create_order.php",{ table_no: table_no_x})
				.done(function(data){
					console.log(data);
					order_now = JSON.parse(data);
					var c = "id : "+order_now[0].id+
					" table_no : "+order_now[0].table_no+
					" status : "+order_now[0].status+
					" insert_time : "+order_now[0].insert_time;
					//console.log(c);
					//order_now").html(c);
					closePopUp();
					setInterval(
					function()
					{ 
					   $(function()
					   {
							getOrderDetailToShow_wait_confrim();
							getOrderDetailToShow_confrimed();
					   });
					}, 2000);
				});
			});
			
		
   
	});
	
  </script>
</head>
<body>
	<div class="container-fluid" style="margin:0px;padding:0px;">
		<div class="popupBackground">
			<div class="popup">
				<h1>WELCOME!!</h1>
					<div class="form-group">
						<label for="table_number">โต๊ะ</label>
						</br>
						</br>
						<input type="text" class="form-control" id="table_number" placeholder="กรอกเลขที่โต๊ะ">
						<div id="popup_numberOnly" style="color:red; display: none;">Please insert table number</div>
						</br>
					</div>				
						<button id="btn_open_table" class="btn btn-primary">Submit</button>
			</div>
		</div>
		<div id="tabs">
		  <ul id="category_tab">
			<li><a href = "#order_list">รายการอาหารที่้สั่ง</a></li>
		  </ul>
		  <div id="order_list">
			รายการอาหารที่สั่ง</br>
			<div id="order_now">
			
			</div>
			
			<h1>Wait Confirm</h1>
			<div class="wait_confirm">
				<table class="table table-bordered table-striped">
				<tbody id="wait_confirm_table">
					<tr>
						<th>id</th>
						<th>food_id</th>
						<th>order_id</th>
						<th>qty</th>
						<th>status</th>
						<th>insert_time</th>
						<th>food_id_x</th>
						<th>food_name</th>
						<th>food_description</th>
						<th>food_price</th>
						<th>food_image</th>
						<th>food_cat_id</th>
						<th>ยืนยัน</th>
					</tr>
				</tbody>
				</table>
			</div>
			<hr>
			<h1>Confirmed</h1>
			<hr>
			<div class="confirmed">
				<table class="table table-bordered table-striped">
				<tbody id="confirmed_table">
					<tr>
						<th>id</th>
						<th>food_id</th>
						<th>order_id</th>
						<th>qty</th>
						<th>status</th>
						<th>insert_time</th>
						<th>food_id_x</th>
						<th>food_name</th>
						<th>food_description</th>
						<th>food_price</th>
						<th>food_image</th>
						<th>food_cat_id</th>
					</tr>
				</tbody>
				</table>
			</div>
			
		  </div>
		</div>
	</div>
 
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>