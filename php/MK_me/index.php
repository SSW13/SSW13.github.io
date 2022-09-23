<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>jQuery UI Tabs - Default functionality</title>
	<link rel="stylesheet" href="jquery-ui.min.css">
	<link rel="stylesheet" href="jquery-ui.structure.min.css">
	<link rel="stylesheet" href="jquery-ui.theme.min.css">
	<script src="jquery-2.1.3.min.js"></script>
	<script src="jquery-ui.min.js"></script>
	<script>
	var catagories ;

	function loadCatagory(){
		$.get("catagory/output/ajax_get_all_catagory.php", function(data, status){
			var catagorys = JSON.parse(data);
			catagories = catagorys;
			for(var i = 0 ; i<catagorys.length ; i++){
				var x = "<li><a href='#"+catagorys[i].id+"'>"+catagorys[i].name+"</a></li>";
				$("#catagory_tab").append(x);
				
				var y = "<div id='food_catagory_"+catagorys[i].id+"'></div>";
				$("#tabs").append(y);
			}
			$( function() {
				$( "#tabs" ).tabs();		
			} );
			loadFood();
		});
	}
	
	function loadFood(){
		for(var i = 0 ; i < catagories.length ; i++)
		{
			$.get("catagory/output/ajax_get_all_food.php?cat_id="+catagories[i].id, function(data, status){
				var foods = JSON.parse(data);
				for(var j = 0 ; j<foods.length ; j++)
				{
					var y = "<div><img src='"+foods[j]+"'/></div>";
					$("#food_catagory_"+catagories[i].id).append(y);
				}
				$( function() {
					$( "#tabs" ).tabs();		
				} );
			});
		}
	}
	
	$( document ).ready(function() {
		loadCatagory();
		
	});
  </script>
</head>
<body>
 
<div id="tabs" >
	<ul id="catagory_tab">
	</ul>
	
</div>
 
 
</body>
</html>