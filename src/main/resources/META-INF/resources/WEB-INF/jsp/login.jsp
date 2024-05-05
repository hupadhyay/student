<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Login to SMS</title>
</head>

<body>
    <div class="container">
        ${loginError}
        <form action="/login" , method="post">
            <table>
                <tr>
                    <td>
                        User Name:
                    </td>
                    <td>
                        <input type="text" name=userName />
                    </td>
                    <td>
                        Password:
                    </td>
                    <td>
                        <input type="password" name=password />
                    </td>
                    <td span="2">
                        <input type="submit" />
                    </td>
                </tr>
            </table>

        </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>