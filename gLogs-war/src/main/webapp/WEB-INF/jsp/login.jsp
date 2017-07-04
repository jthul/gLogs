<html>
<head>
	<title>Error - Page not found</title>
<link rel="stylesheet" type="text/css"
	href="resources/lib/materialize/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
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
			<div class="row center">
					
			</div>
			<div class="row center">
				<a href="serverStatus"
					class="btn-large waves-effect waves-light pink accent-3">Go home ! </a> <a
					href="https://github.com/jthulliez/gLogs/issues"
					class="btn-large waves-effect waves-light pink accent-3"><i
					class="material-icons">playlist_add</i></a>
			</div>
			<br> <br>

		</div>
	</div>
    <div th:fragment="content">
        <form name="f" th:action="@{/login.do}" method="post">               
            <fieldset>
                <legend>Please Login</legend>
                <div th:if="${param.error}" class="alert alert-error">    
                    Invalid username and password.
                </div>
                <div th:if="${param.logout}" class="alert alert-success"> 
                    You have been logged out.
                </div>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>    
                <div class="form-actions">
                    <button type="submit" class="btn">Log in</button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </fieldset>
        </form>
    </div>
	
	<footer class="page-footer grey darken-3">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">gLogs</h5>
					<p class="grey-text text-lighten-4">
						gLogs helps you to keep an eye on all your logs.
					</p>
				</div>	
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">
				gLogs is a free application. We are currently not responsible of what you do with it.
			</div>
		</div>
	</footer>
</body>
</html>