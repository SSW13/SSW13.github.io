<?php
	require_once('../mk_function.php');
	$order_id = $_GET['order_id'];
	change_order_status($order_id,"paid");

?>