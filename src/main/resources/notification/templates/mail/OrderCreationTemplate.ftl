<!DOCTYPE html
          PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Sending Email with Amirutham HTML Template Example</title>

    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8" />
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0" />

    <link href='http://fonts.googleapis.com/css?family=Roboto'
          rel='stylesheet'
          type='text/css'>

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

    <table align="center"
           border="0"
           cellpadding="0"
           cellspacing="0"
           width="600"
           style="border-collapse: collapse; border: 1px solid black;">
        <tr>
            <td align="center"
                style="padding: 20px 0 30px 0;">
                <a href="http://localhost/8000"
                   target="_blank"><img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/logo.png"
                         alt="Amirutham"
                         height="25px"
                         style="display: block;color:white" /></a>
                <span style="color:#9ed241;font: 700 16px/60px Foco Black, sans-serif; letter-spacing: normal;">Support
                    Local, Eat Great</span>
            </td>
        </tr>
        <tr>
            <td style="padding: 0px 30px 0px 30px;">
                <#list buyerOrder
                       as
                       order>
                    <span style="float:right;text-align:right;"> Order ID: ${order.orderNumber} </span><br>
                </#list>
                <p><b>Hello ${name},</b></p>
                <p>
                    Thank you for your order. We'll send a confirmation when your order ships. Your estimated delivery
                    date is indicated below. If you would you like view the status of your order or make any changes to
                    it, Please vision Order section.<br><br>

                <p><b>Order Summary</b></p>
                <#list buyerOrder
                       as
                       order>
                    <span style="float:left;">
                        Order ID: ${order.orderNumber}<br>
                        Placed on: ${order.orderPlacedOn}<br>
                        Tracking: ${order.trackingNumber}<br>
                    </span>
                    <span style="float:right;">
                        <button><a style=color:#285F44;text-decoration:none;
                               href="${loginurl}"
                               target=_blank><b>&nbsp;Manage Order&nbsp;</b></a>
                    </span>
                    <br>
                    <#list order.productList
                           as
                           product>
                        <table align="center"
                               border="0"
                               cellpadding="0"
                               cellspacing="0"
                               width="600"
                               style="border-collapse: collapse; border-top: 1px solid black; background: #F4F0EB;">
                            <tr>
                                <td align="left"
                                    style="padding: 20px 10px 30px 15px;">
                                    <b>Item Name:</b> <br>
                                    ${product.productNm}<br>
                                   
                                </td>
                                 <td align="left"
                                    style="padding: 20px 0 30px 0;">
                                    <b>Order Quantity:</b> <br>
                                   ${product.orderQuantity} X<br>
                                </td>
                                 <td align="left"
                                    style="padding: 20px 0 30px 0;">
                                    <b>Order Price:</b> <br>
                                   Rs.${product.price}<br>
                                </td>
                              
                            </tr>
                        </table>
                    </#list>
                    <br><br>
                    <span style="float:right;text-align:right;"><b>Item Sub-total:<b> Rs.${order.orderAmount}</span><br>
                    <span style="float:right;text-align:right;"><b>Shipping & Handling:<b> Rs.0</span><br>
                    <span style="float:right;text-align:right;"><b>Order Total:<b> Rs.${order.orderAmount}</b></span><br>
                </#list>
                <br>
                <table align="center"
                               border="0"
                               cellpadding="0"
                               cellspacing="0"
                               width="600"
                               style="border-collapse: collapse; border-top: 1px solid black; background: #F4F0EB;">
                           
              <tbody><tr>
                
                <td align="left"
                                    style="padding: 20px 10px 30px 15px;">
                  <h4 style="font-weight:500;font-size:16px;color:#555;margin:0 0 5px">Shipping address</h4>
                  <p style="color:#777;line-height:150%;font-size:16px;margin:0"><span >${name}</span><br>
                  <span>${line1} ${line2}</span>
                  <br>
                  <span >${city}, ${state}+' '+${zipcode}</span>
                  <br>India</p>
                </td>
                
                
                <td style=align="left"
                                    style="padding: 20px 10px 30px 15px;">
                  <h4 style="font-weight:500;font-size:16px;color:#555;margin:0 0 5px">Billing address</h4>
                  <p style="color:#777;line-height:150%;font-size:16px;margin:0"><span >${name}</span><br>
                  <span>${line1} ${line2}</span>
                  <br>
                  <span >${city}, ${state} - ${zipcode}</span>
                  <br>India</p>
                  </td>
                
              </tr>
            </tbody></table>
                
                
                <br>Thank you for supporting independent producers!
                <br><br> If you have any questions, please send us an email at ${amiruthamInfo} or visit our <a
                   href="http:/localhost/8000"
                   target="_blank">Amirutham support page</a>, or check out our <a href="http://localhost:8000/faqs"
                   target="_blank">FAQ page</a>.
                <p>
                <p><b>Cheers,</b><br><b>The Amirutham Team</b></p>
            </td>
        </tr>


        <tr>
            <td align="center">
                <div style="margin: 0 auto; width: 200px">
                    <a href="https://www.facebook.com/Amirutham/"
                       target="_blank">
                        <img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/fb.png"
                             alt="Amirutham"
                             height="40px"
                             style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://twitter.com/Amirutham"
                       target="_blank"><img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/twitter.png"
                             alt="Amirutham"
                             height="40px"
                             style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://www.pinterest.com/Amirutham/_saved/"
                       target="_blank"><img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/printset.png"
                             alt="Amirutham"
                             height="40px"
                             style="display: block;color:white;padding:5px;float: left;" /></a>
                    <a href="https://www.instagram.com/Amirutham/"
                       target="_blank"><img src="https://raw.githubusercontent.com/sankar053/amiruthumimg/main/insta.png"
                             alt="Amirutham"
                             height="40px"
                             style="display: block;color:white;padding:5px;float: left;" /></a>
                </div>
            </td>
        </tr>
        <tr>
            <td align="center"
                style="padding: 20px 0 30px 0;">
                <span>
                    <p class="footer-link">Send with &#x2661; from Amirutham</p>
                    <p class="footer-link"><a style="color:#ccc;"
                           href="#">Unsubscribe</a></p>

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