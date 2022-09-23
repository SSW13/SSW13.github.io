<?php

	require_once("customer_function.php");
			
	$customers = getAllCustomer();
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

?>