<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .login-container h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .login-container form {
            display: flex;
            flex-direction: column;
        }
        .login-container form input[type="text"],
        .login-container form input[type="password"],
        .login-container form input[type="submit"] {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px;
        }
        .login-container form input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        .login-container form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h1>Login</h1>
    <form action="http://localhost:8080/boardservlet/login" method="post">
        <label for="id">ID</label>
        <input type="text" id="id" name="id">
        <label for="password">Password</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="로그인">
    </form>
</div>
</body>
</html>