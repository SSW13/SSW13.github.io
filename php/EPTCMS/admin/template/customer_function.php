<?php
	function createConnection(){
			$servername ="localhost";
			$username = "root";
			$password = "";
			$dbname = "test_crud";
			
			
			$conn = new mysqli($servername, $username, $password, $dbname);
			// Check connection
			if ($conn->connect_error) {
			  die("Connection failed: " . $conn->connect_error);
			}
			return $conn;
	};
	
	function insertNewCustomer($name, $surname, $phone, $email){

			$conn = createConnection();
			

			$sql = "INSERT INTO customer (id, name, surname,phone, email)
			VALUES (0, '$name', '$surname', '$phone', '$email')";

			if ($conn->query($sql) === TRUE) {
			  echo "New record created successfully";
				setcookie("name", "", time() + (10), "/");
				setcookie("surname", "", time() + (10), "/");	
				setcookie("phone", "", time() + (10), "/");
				setcookie("email", "", time() + (10), "/");
			} else {
			  echo "Error: " . $sql . "<br>" . $conn->error;
			}

			$conn->close();
	};

	function getAllCustomer(){
			$conn = createConnection();
			
			$sql = "SELECT * FROM customer ORDER BY id";
			$result = $conn->query($sql);
			
			$customers = array();
			
			
			if ($result->num_rows > 0) {
			  // output data of each row
				while($row = $result->fetch_assoc()) 
				{	  $customers_row = array("id"=>$row["id"],
					  "name"=>$row["name"],
					  "surname"=>$row["surname"],
					  "phone"=>$row["phone"],
					  "email"=>$row["email"],
					  "insert_time"=>$row["insert_time"]);				  
					  array_push($customers, $customers_row);
				}
			} else {
			  echo "0 results";
			}
			$conn->close();
			return $customers;
	};
	
	function deleteCustomer($id){
			$conn = createConnection();
			
			$sql = "DELETE FROM customer WHERE id = $id";

			if ($conn->query($sql) === TRUE) {
			  echo "Record deleted successfully";
			} else {
			  echo "Error deleting record: " . $conn->error;
			}

			$conn->close();
	};
	
	function getCustomerById($id){
			$conn = createConnection();
			
			$sql = "SELECT * FROM customer WHERE id=$id";
			$result = $conn->query($sql);
			
			$customers = array();
			
			
			if ($result->num_rows > 0) {
			  // output data of each row
				while($row = $result->fetch_assoc()) 
				{	  $customers_row = array("id"=>$row["id"],
					  "name"=>$row["name"],
					  "surname"=>$row["surname"],
					  "phone"=>$row["phone"],
					  "email"=>$row["email"],
					  "insert_time"=>$row["insert_time"]);				  
					  array_push($customers, $customers_row);
				}
			} else {
			  echo "0 results";
			}
			$conn->close();
			return $customers;
	};
	
	function updateCustomer($id, $name, $surname, $phone, $email){

			$conn = createConnection();
			

			$sql = "UPDATE  customer set name = '$name',
			surname = '$surname',
			phone = '$phone',
			email = '$email'
			WHERE id = $id";

			if ($conn->query($sql) === TRUE) {
			  echo "upadted successfully";
				setcookie("name", "", time() + (10), "/");
				setcookie("surname", "", time() + (10), "/");	
				setcookie("phone", "", time() + (10), "/");
				setcookie("email", "", time() + (10), "/");
			} else {
			  echo "Error: " . $sql . "<br>" . $conn->error;
			}

			$conn->close();
	};
	
	function searchCustomerByName($name_search){
			$conn = createConnection();
			
			$sql = "SELECT * FROM customer WHERE `name` LIKE '%$name_search%'";
			$result = $conn->query($sql);
			
			$customers = array();
			
			
			if ($result->num_rows > 0) {
			  // output data of each row
				while($row = $result->fetch_assoc()) 
				{	  $customers_row = array("id"=>$row["id"],
					  "name"=>$row["name"],
					  "surname"=>$row["surname"],
					  "phone"=>$row["phone"],
					  "email"=>$row["email"],
					  "insert_time"=>$row["insert_time"]);				  
					  array_push($customers, $customers_row);
				}
			} else {
			  echo "0 results";
			}
			$conn->close();
			return $customers;
	};
?>

