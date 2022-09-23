<?php
    require_once("catagory_function.php");
    $id = $_GET['id'];
    deletecatagory($id);
    

?>

ลบข้อมูลเรียบร้อยแล้ว
<br/>
<a href="catagory_show_all.php">กลับ</a>