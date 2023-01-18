<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD - login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/x-icon" href="groupe_travail.png"/>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-info fixed-top">
		<a class="navbar-brand" href="/crud">CRUD</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>

	<div class="text-center mx-3 mt-5">
		<h1>Login</h1>
		<form action="login" method="post">
			
				<div class="form-group w-50 mx-auto">
					<label for="email_address">Email</label> <input type="text"
						id="email" class="form-control" name="email" required autofocus>
				</div>
				<div class="form-group w-50 mx-auto">
					<label for="password">Password</label> <input type="password"
						id="password" class="form-control" name="password" required>
				</div>

			<br>
			<button type="submit" class="btn btn-secondary">Connexion</button>
			<br> <a class="nnav-item active text-dark" href="adduser">Create
				profil</a>

		</form>
	</div>
</body>
</html>