<html>
<head>
<title>gLogs - Connexion</title>
<link rel="stylesheet" type="text/css"
	href="resources/lib/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="resources/lib/materialize/js/materialize.min.js"></script>

</head>
<body>
	<nav class="grey darken-3" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="#" class="brand-logo">gLogs</a>
		</div>
	</nav>
	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br>
			<h5 class="header col s12 light">Login </h5>
			<form name="f" action="/login.do" method="post">
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Placeholder" id="username" name="username"
							type="text" class="validate"> <label for="username">Username</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Password" id="password" name="password"
							type="password"> <label for="password">Password</label>
					</div>
				</div>

				<button class="btn waves-effect waves-light pink darken-1" type="submit"
					name="action">
					Submit <i class="material-icons right">send</i>
				</button>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
		<br> <br>

	</div>

</body>
</html>