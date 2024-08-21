<?php	
	if (empty($_POST['name2_8296_1511_24562']) && strlen($_POST['name2_8296_1511_24562']) == 0 || empty($_POST['email2_8296_1511_24562']) && strlen($_POST['email2_8296_1511_24562']) == 0 || empty($_POST['email2_8296_1511_24562']) && strlen($_POST['email2_8296_1511_24562']) == 0 || empty($_POST['email2_8296_1511_24562']) && strlen($_POST['email2_8296_1511_24562']) == 0 || empty($_POST['email2_8296_1511_24562']) && strlen($_POST['email2_8296_1511_24562']) == 0 || empty($_POST['email2_8296_1511_24562']) && strlen($_POST['email2_8296_1511_24562']) == 0 || empty($_POST['email2_8296_1511_24562']) && strlen($_POST['email2_8296_1511_24562']) == 0)
	{
		return false;
	}
	
	$name2_8296_1511_24562 = $_POST['name2_8296_1511_24562'];
	$email2_8296_1511_24562 = $_POST['email2_8296_1511_24562'];
	$email2_8296_1511_24562 = $_POST['email2_8296_1511_24562'];
	$email2_8296_1511_24562 = $_POST['email2_8296_1511_24562'];
	$email2_8296_1511_24562 = $_POST['email2_8296_1511_24562'];
	$email2_8296_1511_24562 = $_POST['email2_8296_1511_24562'];
	$email2_8296_1511_24562 = $_POST['email2_8296_1511_24562'];
	
	$to = 'receiver@yoursite.com'; // Email submissions are sent to this email

	// Create email	
	$email_subject = "Message from a Blocs website.";
	$email_body = "You have received a new message. \n\n".
				  "Name2_8296_1511_24562: $name2_8296_1511_24562 \nEmail2_8296_1511_24562: $email2_8296_1511_24562 \nEmail2_8296_1511_24562: $email2_8296_1511_24562 \nEmail2_8296_1511_24562: $email2_8296_1511_24562 \nEmail2_8296_1511_24562: $email2_8296_1511_24562 \nEmail2_8296_1511_24562: $email2_8296_1511_24562 \nEmail2_8296_1511_24562: $email2_8296_1511_24562 \n";
	$headers = "MIME-Version: 1.0\r\nContent-type: text/plain; charset=UTF-8\r\n";	
	$headers .= "From: contact@yoursite.com\n";
	$headers .= "Reply-To: $email2_8296_1511_24562";	
	
	mail($to,$email_subject,$email_body,$headers); // Post message
	return true;			
?>