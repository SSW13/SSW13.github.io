<?php
			require_once("customer_function.php");
		
?>
<html>
	<head>
		<title>MM's Bag[Custtomers]</title>
		<script src="jquery.min.js"></script>
		<script>
		$(document).ready(function(){
			loadTable();
		});
		function loadTable()
		{
				$("#table").load("show_all_inner.php", function(responseTxt, statusTxt, xhr){
					
				});
		};
		function confirm_delete(id)
		{
					var r = confirm("Are you sure to delete?");
					if(r == true){
						//window.open("delete_customer.php?id="+id, "_self");
						$("#table").load("delete_customer.php?id="+id, function(responseTxt, statusTxt, xhr){
							if(statusTxt == "success")
								loadTable();
							if(statusTxt == "error")
								alert("Error: " + xhr.status + ": " + xhr.statusText);
					});
					}else{
						
					}
		}		
		</script>
	</head>
	
	<body>
		<h1>Customer All</h1>
		<div id="data">
		
		</div>
		<div id="table">
		
		</div>
		<button type="submit"><a href="index.php">BACK!!</a></button>
	</body>
	

</html>