<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#">Task List</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor01" aria-controls="navbarColor01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<!-- active  --> <a class="nav-link" href="/">Home <!-- <span class="sr-only">(current)</span> --></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/dashboard">My Dashboard</a></li>
<!-- 			<li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li> -->
		</ul>
		<ul class="navbar-nav ml-auto">
		<c:if test="${user.username eq null}">
		<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
		</c:if>
		<c:if test="${user.username ne null}">
		<li>${user.username }</li>
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
		</c:if>	
			
		</ul>
	</div>
</nav>

<!--I don't really need a search bar in the nav right now, but useful maybe later:
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>  -->

<!--  ALSO LATER look up how to implement partial file while also utilizing<span current> class= "active"</span>





<!--This is MDBootstrap's code, which might be cool later to re-tool for a nice-looking little header or something
 <html lang="en" class="full-height">
 <!--Main Navigation
<header>

	<nav class="navbar fixed-top navbar-expand-lg navbar-dark indigo">
		<a class="navbar-brand" href="#"><strong>Navbar</strong></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
			</ul>
		</div>
	</nav>

	<div class="view intro-2">
		<div class="full-bg-img">
			<div class="mask rgba-black-light flex-center">
				<div class="container text-center white-text">
					<div class="white-text text-center wow fadeInUp">
						<h2>This Navbar is fixed</h2>
						<h5>It will always stay visible on the top, even when you
							scroll down</h5>
						<br>
						<p>Full page intro with background image will be always
							displayed in full screen mode, regardless of device</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</header>
Main Navigation -->