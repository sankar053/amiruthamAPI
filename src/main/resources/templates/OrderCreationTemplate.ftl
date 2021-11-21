<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Sending Email with Amirutham HTML Template Example</title>

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
            width: 60px;
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
                <a href="http://localhost:4200/" target="_blank"><img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/logo.png" alt="Amirutham" height="25px" style="display: block;color:white" /></a>
                <span style="color:#9ed241;font: 700 16px/60px Foco Black, sans-serif; letter-spacing: normal;">Support
                    Local</span>
            </td>
        </tr>
        <tr>
            <td style="padding: 0px 30px 0px 30px;">
                <p><b>Hello ${name},</b></p>
                <p>
                    You have a new order from Amirutham!

                    <br><br>
                    <p><a style=color:#9ED241;text-decoration:none; href="${url}">${url}</a></p>
                    <br>Order ID: #${orderNumber}
                    <br>Item: ${itemName}
                    <br>Qty: ${quantity}
                    <br>Delivery Option: ${deliveryMode}
                    <br><br>Log into Amirutham to manage your orders and fulfillment:
                    <br><br><button><a style=color:#285F44;text-decoration:none; href="http://localhost:4200/#" target=_blank><b>Login</b></a></button>
                    <p>

                        <p><b>Cheers,</b><br><b>The Amirutham Team</b></p>
            </td>
        </tr>

        <tr>
            <td align="center">
                <div style="margin: 0 auto; width: 200px">
                    <a href="https://www.facebook.com/Amirutham/" target="_blank">
                        <img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/fb.png" alt="Amirutham" height="40px" style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://twitter.com/Amirutham" target="_blank"><img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/twitter.png" alt="Amirutham" height="40px" style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://www.pinterest.com/Amirutham/_saved/" target="_blank"><img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/printset.png" alt="Amirutham" height="40px" style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://www.instagram.com/Amirutham/" target="_blank"><img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/insta.png" alt="Amirutham" height="40px" style="display: block;color:white;padding:5px;float: left;" /></a>
                </div>
            </td>
        </tr>
        <tr>
            <td align="center" style="padding: 20px 0 30px 0;">
                <span>
                    <p class="footer-link">Send with &#x2661; from Amirutham</p>
                    <p class="footer-link"><a style="color:#ccc;" href="#">Unsubscribe</a></p>

                    <p class="footer-link">Amirutham Cold Press Oil Shop</p>
                    <p class="footer-link">101, 44/1, Mogappair Rd, Shantiniketan Colony,</p>
                    <p class="footer-link">Thirumangalam, Padi, Chennai,</p>
                    <p class="footer-link">Tamil Nadu 600058</p>
                    <p class="footer-link">(+91) 9791255264</p>
                </span>
            </td>
        </tr>

    </table>

</body>

</html>