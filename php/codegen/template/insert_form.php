<?php
			require_once("customer_function.php");
			$isEdit = false;
			
			if(isset($_GET['action']) and $_GET['action']=="edit"){
				$isEdit = true;
				$id = $_GET['id'];
				$customers = getCustomerById($id);
				if(count($customers)>0){
					$name 		= $customers[0]['name'];
					$surname	= $customers[0]['surname'];
					$phone		= $customers[0]['phone'];
					$email		= $customers[0]['email'];
					
					setcookie("name", $name, time() + (10), "/");
					setcookie("surname", $surname, time() + (10), "/");	
					setcookie("phone", $phone, time() + (10), "/");
					setcookie("email", $email, time() + (10), "/");
									
					$_COOKIE["name"]	=	 $name;
					$_COOKIE["surname"]	=    $surname;
					$_COOKIE["phone"]	=    $phone	;
					$_COOKIE["email"]	=    $email	;
				};
			}
		
?>
<html>
	<head>
		<title>MM's Bag[Custtomers]</title>
	</head>
	
	<body>
		<h1>insert new Customer</h1>
		
		<?php	
		
			if(isset($_GET['return']) and $_GET['return'] == 1){
				echo "<p>Please insert your name</p>";
			}else if(isset($_GET['return']) and $_GET['return'] == 2){
				echo "<p>Please insert your surname</p>";
			}else if(isset($_GET['return']) and $_GET['return'] == 3){
				echo "<p>Please insert your phone</p>";
			}else if(isset($_GET['return']) and $_GET['return'] == 4){
				echo "<p>Please insert your email</p>";
			}
			
			if($isEdit){
				echo "<form action='update_action.php' method='POST'>";
			}else{
				echo "<form action='insert_action.php' method='POST'>";
			}

		?>
		
		
			<ul style="list-style-type: none;">
			
					<?php
						if($isEdit){
							echo "<input type='hidden' name='id' value='$id;'/>";
						}
					?>
				
				<li>name :<input type="text" name="name" 		value="<?php echo @($_COOKIE["name"]);?>" /></li>
				<li>surname :<input type="text" name="surname"	value="<?php echo @($_COOKIE["surname"]);?>"/></li>
				<li>phone :<input type="text" name="phone"		value="<?php echo @($_COOKIE["phone"]);?>"/></li>
				<li>email :<input type="text" name="email"		value="<?php echo @($_COOKIE["email"]);?>"/></li></br>
				<li><input type="submit" name="submit" value="SAVE"></li></br>
				<li><button><a href="index.php">BACK!!</a></button></li>
			</ul>
		</form>
		
		
	</body>
</html>