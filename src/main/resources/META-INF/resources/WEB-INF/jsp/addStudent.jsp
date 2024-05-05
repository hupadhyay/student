<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Add New Student</title>
    </head>

    <body>
        <div class="container">
            <form:form method="post" modelAttribute="student">
                <form:input type="hidden" path="id" />
                <table>
                    <caption>Student Form</caption>
                    <tr>
                        <fieldset class="mb-3">
                            <td>
                                <form:label path="userName" required="required">User Name</form:label>
                            </td>
                            <td>
                                <form:input path="userName"></form:input>
                            </td>
                            <td>
                                <form:errors path="userName"></form:errors>
                            </td>
                        </fieldset>
                    </tr>
                    <tr>
                        <fieldset class="mb-3"></fieldset>
                            <td>
                                <form:label path="fullName" required="required">Full Name</form:label>
                            </td>
                            <td>
                                <form:input path="fullName"></form:input>
                            </td>
                            <td>
                                <form:errors path="fullName"></form:errors>
                            </td>
                        </fieldset>
                    </tr>
                    <tr>
                        <fieldset class="mb-3"></fieldset>
                            <td>
                                <form:label path="email">E-mail</form:label>
                            </td>
                            <td>
                                <form:input path="email"></form:input>
                            </td>
                            <td>
                                <form:errors path="email"></form:errors>
                            </td>
                        </fieldset>
                    </tr>
                    <tr>
                        <fieldset class="mb-3"></fieldset>
                            <td>
                                <form:label path="doj" required="required">Date of Joining</form:label>
                            </td>
                            <td>
                                <form:input path="doj"></form:input>
                            </td>
                            <td>
                                <form:errors path="doj"></form:errors>
                            </td>
                        </fieldset>
                    </tr>
                    <tr>
                        <fieldset class="mb-3">
                            <td>
                                <form:label path="isGraduated">Graduated</form:label>
                            </td>
                            <td>
                                <form:checkbox path="isGraduated"></form:checkbox>
                            </td>
                        </fieldset>
                    </tr>
                    <tr>
                        <td>
                            <form:button class="btn btn-success">Submit</form:button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

    </html>