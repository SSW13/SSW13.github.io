<?php
			require_once("customer_function.php");
		
?>
<html>
	<head>
		<title>MM's Bag[Custtomers]</title>
		<script>
			function confirm_delete(id)
			{
					var r = confirm("Are you sure to delete?");
					if(r == true){
						window.open("delete_customer.php?id="+id, "_self");
					}else{
						
					}
			}		
		</script>
	</head>
	
	<body>
		<h1>Customer All</h1>
		<form action="search_customer.php" method="POST">
			search : <input type ="text" name="text_to_search"/>
			<input type="submit" value="SEARCH" name="btn"/>
		</form>
		
		<?php
		
			if(isset($_POST['btn'])){
				
			require_once("customer_function.php");
			
				$customers = searchCustomerByName(trim($_POST['text_to_search']));
				if(count($customers)>0)
				{
				echo "<table border='1' style='border-collapse: collapse; text-align: center;'>";
					echo"<tr>";
						$keys = array_keys($customers[0]);
						for($i =0 ; $i<count($customers[0]) ; $i++)
						{
							$key = $keys[$i];
							echo"<th>$key</th>";
						}
						echo"<th>"."แก้ไข"."</th>";
						echo"<th>"."ลบ"."</th>";
					echo"</tr>";
						for($i =0 ; $i<count($customers) ; $i++){
							echo"<tr>";
							for($j =0 ; $j<count($keys) ; $j++){
								$key = $keys[$j];
								if($i % 2 == 0){
									echo"<td style='background-color:#ccc;'>".$customers[$i][$key]."</td>";
								}else{
									echo"<td>".$customers[$i][$key]."</td>";
								}
							}
							echo"<td>"."<a href='insert_form.php?action=edit&id=".$customers[$i]['id']."'>แก้ไข"."</td>";
							echo"<td>"."<button onclick='confirm_delete(".$customers[$i]['id'].")'>ลบ</button>"."</td>";
							echo"</tr>";
						}
				echo "</table>";
				}
			}else{
					echo "please Search";
			}
		?>
		<button type="submit"><a href="index.php">BACK!!</a></button>
	</body>
	

</html>