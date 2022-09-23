<?php
	require_once("customer_function.php");
	$id = $_GET['id'];
	deleteCustomer($id);
?>
</br>
Deleted!!

<button><a href="show_all.php">BACK!!</a></button>