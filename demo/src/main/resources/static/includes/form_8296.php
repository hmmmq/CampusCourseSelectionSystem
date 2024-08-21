<?php	
	if (empty($_POST['name2_8296']) && strlen($_POST['name2_8296']) == 0 || empty($_POST['email2_8296']) && strlen($_POST['email2_8296']) == 0 || empty($_POST['email2_8296']) && strlen($_POST['email2_8296']) == 0 || empty($_POST['email2_8296']) && strlen($_POST['email2_8296']) == 0 || empty($_POST['email2_8296']) && strlen($_POST['email2_8296']) == 0 || empty($_POST['email2_8296']) && strlen($_POST['email2_8296']) == 0 || empty($_POST['email2_8296']) && strlen($_POST['email2_8296']) == 0)
	{
		return false;
	}
	
	$name2_8296 = $_POST['name2_8296'];
	$email2_8296 = $_POST['email2_8296'];
	$email2_8296 = $_POST['email2_8296'];
	$email2_8296 = $_POST['email2_8296'];
	$email2_8296 = $_POST['email2_8296'];
	$email2_8296 = $_POST['email2_8296'];
	$email2_8296 = $_POST['email2_8296'];
	
	$to = 'receiver@yoursite.com'; // Email submissions are sent to this email

	// Create email	
	$email_subject = "Message from a Blocs website.";
	$email_body = "You have received a new message. \n\n".
				  "Name2_8296: $name2_8296 \nEmail2_8296: $email2_8296 \nEmail2_8296: $email2_8296 \nEmail2_8296: $email2_8296 \nEmail2_8296: $email2_8296 \nEmail2_8296: $email2_8296 \nEmail2_8296: $email2_8296 \n";
	$headers = "MIME-Version: 1.0\r\nContent-type: text/plain; charset=UTF-8\r\n";	
	$headers .= "From: contact@yoursite.com\n";
	$headers .= "Reply-To: $email2_8296";	
	
	mail($to,$email_subject,$email_body,$headers); // Post message
	return true;			
?>