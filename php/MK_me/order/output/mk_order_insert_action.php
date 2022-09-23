<?php
    require_once("mk_order_function.php");
    session_start();

    
    
$table_no      =   trim($_POST['table_no']);
$status      =   trim($_POST['status']);
$date_time      =   trim($_POST['date_time']);
    
    $submit      =  $_POST['submit'];
    
    
$_SESSION["table_no"]      =  $table_no        ;
$_SESSION["status"]      =  $status        ;
$_SESSION["date_time"]      =  $date_time        ;
    
    if(!isset($submit))
    {
        header("location:mk_order_insert_form.php");
    }


    
if($table_no == "")
            {
                header("location:mk_order_insert_form.php?return=1");
                exit;
            }
if($status == "")
            {
                header("location:mk_order_insert_form.php?return=2");
                exit;
            }
if($date_time == "")
            {
                header("location:mk_order_insert_form.php?return=3");
                exit;
            }

    
   // if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    //    header("location:insert_form.php?return=5");
    //    exit; 
    //}
    
   $isSuccess = insertNewmk_order(               
        $table_no, $status, $date_time 
                                        );
   
   
   // remove all session variables
    session_unset(); 
    
    // destroy the session 
    session_destroy(); 
 
?>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
    <body>
        <h1><?php echo $isSuccess ? "insert สำเร็จ"  : "ล้มเหลว"; ?></h1>
        <br/>
        <a href="index.php">กลับหน้าหลัก</a>
        <br/>
        <a href="mk_order_insert_form.php">กลับหน้าinsert new customer</a> 
    </body>
</html>
