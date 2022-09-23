<?php

	require_once("customer_function.php");

	$name 		= trim($_POST['name']);
	$surname	= trim($_POST['surname']);
	$phone		= trim($_POST['phone']);
	$email		= trim($_POST['email']);
	$submit		= $_POST['submit'];
	
	
	
	if(!isset($submit)){
		header("location:insert_form.php");		
	}
	if(trim($name) == ""){
		header("location:insert_form.php?return=1");
		exit;		
	}
	if(trim($surname) == ""){
		header("location:insert_form.php?return=2");
		exit;	
	}
	if(trim($phone) == ""){
		header("location:insert_form.php?return=3");
		exit;	
	}
	if(trim($email) == ""){
		header("location:insert_form.php?return=4");
		exit;	
	}
	if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
	header("location:insert_form.php?return=4");
		exit;	
	}	
	setcookie("name", $name, time() + (10), "/");
	setcookie("surname", $surname, time() + (10), "/");	
	setcookie("phone", $phone, time() + (10), "/");
	setcookie("email", $email, time() + (10), "/");
	
	
	
	insertNewCustomer($name, $surname, $phone, $email);
	
	
?>
</br>
<button><a href="insert_form.php">BACK!!</a></button>