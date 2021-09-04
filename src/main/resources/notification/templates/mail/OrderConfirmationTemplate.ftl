<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Sending Email with Eatzos HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }
        
        button {
            border-radius: 12px;
            border: none;
            background-color: #9ED241;
            color: black;
            position: relative;
            left: 50%;
            top: 50%;
            padding: 6px;
            text-align: center;
            text-decoration: none;
        }
        
        .footer-link {
            font-size: 14px;
            color: #ccc;
        }
    </style>
</head>

<body style="margin: 0; padding: 0;">

    <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse; border: 1px solid black;">
        <tr>
            <td align="center" style="padding: 20px 0 30px 0;">
                <a href="https://seller-dev.eatzos.com/" target="_blank"><img src="https://seller-dev.eatzos.com/assets/mail/eatzos_logo.png" alt="Eatzos" height="25px" style="display: block;color:white" /></a>
                <span style="color:#9ed241;font: 700 16px/60px Foco Black, sans-serif; letter-spacing: normal;">Support
                    Local, Eat Great</span>
            </td>
        </tr>
        <tr>
            <td style="padding: 0px 30px 0px 30px;">
                <p><b>Hello ${name},</b></p>
                <p> Your order ${orderNumber} has been conformed.</p>
                <p><b>Cheers,</b><br><b>The Eatzos Team</b></p>
            </td>
        </tr>

        <tr>
            <td align="center">
                <div style="margin: 0 auto; width: 200px">
                    <a href="https://www.facebook.com/EATZOS/" target="_blank">
                        <img src="https://seller-dev.eatzos.com/assets/mail/fb.png" alt="Eatzos" height="40px" style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://twitter.com/eatzos" target="_blank"><img src="https://seller-dev.eatzos.com/assets/mail/twitter.png" alt="Eatzos" height="40px" style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://www.pinterest.com/eatzos/_saved/" target="_blank"><img src="https://seller-dev.eatzos.com/assets/mail/printset.png" alt="Eatzos" height="40px" style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://www.instagram.com/eatzos/" target="_blank"><img src="https://seller-dev.eatzos.com/assets/mail/insta.png" alt="Eatzos" height="40px" style="display: block;color:white;padding:5px;float: left;" /></a>
                </div>
            </td>
        </tr>
        <tr>
            <td align="center">
                <span>
                    <p class="footer-link">Send with &#x2661; from Eatzos</p>
                    <p class="footer-link"><a style="color:#ccc;" href="#">Unsubscribe</a></p>

                    <p class="footer-link">Eatzos</p>
                    <p class="footer-link">12140 Wallace Woods Lane</p>
                    <p class="footer-link">Alpharetta, Georgia 30004</p>
                    <p class="footer-link">United States</p>
                    <p class="footer-link">(404) 392-6970</p>
                </span>
            </td>
        </tr>

    </table>

</body>

</html>