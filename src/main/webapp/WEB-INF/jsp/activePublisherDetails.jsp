
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<!-- meta tags and other links -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AdKrive - Publisher details</title>
<!-- site favicon -->
<base
	href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
<link rel="shortcut icon" type="image/png"
	href="images/logoIcon/favicon.png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap">
<!-- bootstrap 4  -->
<link rel="stylesheet" href="css/vendor/bootstrap.min.css">
<!-- bootstrap toggle css -->
<link rel="stylesheet" href="css/vendor/bootstrap-toggle.min.css">
<!-- fontawesome 5  -->
<link rel="stylesheet" href="css/all.min.css">
<!-- line-awesome webfont -->
<link rel="stylesheet" href="css/line-awesome.min.css">


<!-- custom select box css -->
<link rel="stylesheet" href="css/vendor/nice-select.css">
<!-- code preview css -->
<link rel="stylesheet" href="css/vendor/prism.css">
<!-- select 2 css -->
<link rel="stylesheet" href="css/vendor/select2.min.css">
<!-- jvectormap css -->
<link rel="stylesheet" href="css/vendor/jquery-jvectormap-2.0.5.css">
<!-- datepicker css -->
<link rel="stylesheet" href="css/vendor/datepicker.min.css">
<!-- timepicky for time picker css -->
<link rel="stylesheet" href="css/vendor/jquery-timepicky.css">
<!-- bootstrap-clockpicker css -->
<link rel="stylesheet" href="css/vendor/bootstrap-clockpicker.min.css">
<!-- bootstrap-pincode css -->
<link rel="stylesheet" href="css/vendor/bootstrap-pincode-input.css">
<!-- dashdoard main css -->
<link rel="stylesheet" href="css/app.css">
<link rel="stylesheet" href="css/snackbar.css">
   <script src="js/sticky.js"></script>


<style>
.fix .toggle-on, .fix .toggle-off {
	line-height: 2.0
}
</style>
<script type="text/javascript">
	function update1() {
		if (document.getElementById('chk').checked) {

			document.getElementsByName('status')[1].value = new Number(1);
			
		}

		else if (document.getElementById('chk1').checked) {

		
			document.getElementById('chk_1').disabled = true;
			
		}

		else if (document.getElementById("chk2").checked) {

			document.getElementById('chk_2').disabled = true;
		}

		else if (document.getElementById("chk3").checked) {

			document.getElementById('chk_3').disabled = true;
		} else if (document.getElementById("chk4").checked) {

			document.getElementById('chk_4').disabled = true;
		}
	}
</script>


</head>
<body>
	<!-- page-wrapper start -->
	<div class="page-wrapper default-version">
		<div
			class="sidebar capsule--rounded bg_img overlay--indigo overlay--opacity-8"
			data-background="images/sidebar/2.jpg">
			<button class="res-sidebar-close-btn">
				<i class="las la-times"></i>
			</button>
			<div class="sidebar__inner">
				<div class="sidebar__logo">
					<a href="/dashboard" class="sidebar__main-logo"><img
						src="images/logoIcon/logo.png" alt="image"></a> <a
						href="/dashboard" class="sidebar__logo-shape"><img
						src="images/logoIcon/favicon.png" alt="image"></a>
					<button type="button" class="navbar__expand"></button>
				</div>

				<div class="sidebar__menu-wrapper" id="sidebar__menuWrapper">
					<ul class="sidebar__menu">
						<li class="sidebar-menu-item "><a href="/dashboard"
							class="nav-link "> <i class="menu-icon las la-home"></i> <span
								class="menu-title">Dashboard</span>
						</a></li>
						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon las la-ad"></i> <span class="menu-title">Advertises
							</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item "><a
										href="/advertise/all"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">All Advertises</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertise/price-plan"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Price Plan</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertise/type"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Add Type</span>
									</a></li>

									<li class="sidebar-menu-item "><a
										href="/advertise/cpc&amp;cpm"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">CPC & CPM</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertise/ip-log"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Ip Logs</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertise/blocked/ip-log"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Blocked Ip Log</span>
									</a></li>

								</ul>
							</div></li>
								
									<!-- NEWLY ADDED FEEDS OPTION START-->
							 <li class="sidebar-menu-item ">

                    <a href="/feeds/all" class="nav-link">

                       <i class="menu-icon fa fa-rss" style="font-size:16px;" aria-hidden="true"></i>
                        <span class="menu-title">Feeds</span>
                    </a>
                </li>
					<!--    FEEDS OPTION CLOSED -->

							
						<li class="sidebar-menu-item "><a
							href="/keywords" class="nav-link">
								<i class="menu-icon lab la-kickstarter-k"></i> <span
								class="menu-title">Manage Keywords</span>
						</a></li>


						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon lab la-autoprefixer"></i> <span
								class="menu-title">Manage Advertiser</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item "><a
										href="/advertiser/all"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">All Advertiser</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/active/all"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">All Active Advertiser</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/banned/all"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Banned Advertiser</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/email-unverified"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Email Unverified</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/sms-unverified"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">SMS Unverified</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/send-email"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Send Email to all</span>
									</a></li>
								</ul>
							</div></li>
						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class="side-menu--open"> <i
								class="menu-icon lab la-chromecast"></i> <span
								class="menu-title">Manage Publisher</span>
						</a>
							<div class="sidebar-submenu sidebar-submenu__open ">
								<ul>

									<li class="sidebar-menu-item "><a href="/publisher/all"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">All Publisher</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/publisher/active/all" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">All Active Publisher</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/publisher/banned/all" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Banned Publishers</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/publisher/email-unverified" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Email Unverified</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/publisher/sms-unverified" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">SMS Unverified</span> <span
											class="menu-badge pill bg--primary ml-auto">1</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/publisher/send-email" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Send Email to all</span>
									</a></li>
								</ul>
							</div></li>


						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon las la-check-circle"></i> <span
								class="menu-title">Manage Domain</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item "><a
										href="/domain/pending"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Pending Domain</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/domain/approved"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Approved Domain</span>
									</a></li>
								</ul>
							</div></li>

						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon las la-credit-card"></i> <span
								class="menu-title">Payment Gateways</span>

						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item  "><a
										href="/gateway/automatic"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Automatic Gateways</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/gateway/manual"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Manual Gateways</span>
									</a></li>
								</ul>
							</div></li>

						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon las la-credit-card"></i> <span
								class="menu-title">Deposits</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item  "><a
										href="/deposit/pending"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Pending Deposits</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/deposit/approved"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Approved Deposits</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/deposit/successful"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Successful Deposits</span>
									</a></li>


									<li class="sidebar-menu-item  "><a
										href="/deposit/rejected"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Rejected Deposits</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/deposit" class="nav-link">
											<i class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">All Deposits</span>
									</a></li>
								</ul>
							</div></li>

						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon la la-bank"></i> <span class="menu-title">Withdrawals
							</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item "><a
										href="/withdraw/method"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Withdraw Methods</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/withdraw/pending"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Pending Log</span>

									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/withdraw/approved"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Approved Log</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/withdraw/rejected"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Rejected Log</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/withdraw/log"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Withdrawals Log</span>
									</a></li>


								</ul>
							</div></li>

						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon la la-ticket"></i> <span class="menu-title">Support
									Ticket </span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item  "><a
										href="/tickets" class="nav-link">
											<i class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">All Ticket</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/tickets/pending"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Pending Ticket</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/tickets/closed"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Closed Ticket</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/tickets/answered"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Answered Ticket</span>
									</a></li>
								</ul>
							</div></li>


						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon la la-list"></i> <span class="menu-title">Report
							</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>
									<li class="sidebar-menu-item "><a
										href="/report/publishers/earning-logs"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Publishers Earning Log</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/report/transaction/advertisers"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Advertisers TRX Log</span>
									</a></li>

									<li class="sidebar-menu-item "><a
										href="/report/login/history"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Login History</span>
									</a></li>

								</ul>
							</div></li>



							<li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                    <i class="menu-icon fas fa-wrench"></i>
                        
                        <span class="menu-title">SETTINGS </span>
                    </a>
                    <div class="sidebar-submenu  ">
                    <ul>
                    	<li class="sidebar-menu-item ">
                    <a href="/general-setting" class="nav-link">
                        <i class="menu-icon las la-life-ring"></i>
                        <span class="menu-title">General Setting</span>
                    </a>
                </li>

                <li class="sidebar-menu-item ">
                    <a href="/setting/logo-icon" class="nav-link">
                        <i class="menu-icon las la-images"></i>
                        <span class="menu-title">Logo Icon Setting</span>
                    </a>
                </li>

                <li class="sidebar-menu-item ">
                    <a href="/extensions" class="nav-link">
                        <i class="menu-icon las la-cogs"></i>
                        <span class="menu-title">Extensions</span>
                    </a>
                </li>

                <li class="sidebar-menu-item  ">
                    <a href="/language" class="nav-link"
                       data-default-url="/language">
                        <i class="menu-icon las la-language"></i>
                        <span class="menu-title">Language </span>
                    </a>
                </li>

                <li class="sidebar-menu-item ">
                    <a href="/seo" class="nav-link">
                        <i class="menu-icon las la-globe"></i>
                        <span class="menu-title">SEO Manager</span>
                    </a>
                </li>
                    
                    </ul>
                    </div>
                    </li>

						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon la la-envelope-o"></i> <span class="menu-title">Email
									Manager</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item  "><a
										href="/email-template/global"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Global Template</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/email-template/index"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Email Templates</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/email-template/setting"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Email Configure</span>
									</a></li>
								</ul>
							</div></li>

						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon la la-mobile"></i> <span class="menu-title">SMS
									Manager</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>
									<li class="sidebar-menu-item  "><a
										href="/sms-template/global"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">API Setting</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/sms-template/index"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">SMS Templates</span>
									</a></li>
								</ul>
							</div></li>


						
					</ul>
					<div class="text-center mb-3 text-uppercase">
						<span class="text--primary">AdsRock</span> <span
							class="text--success">V1.1 </span>
					</div>
				</div>

			</div>

		</div>
		<!-- sidebar end -->
		<!-- navbar-wrapper start -->
		<nav class="navbar-wrapper">
			<form class="navbar-search" onsubmit="return false;">
				<button type="submit" class="navbar-search__btn">
					<i class="las la-search"></i>
				</button>
				<input type="search" name="navbar-search__field"
					id="navbar-search__field" placeholder="Search...">
				<button type="button" class="navbar-search__close">
					<i class="las la-times"></i>
				</button>

				<div id="navbar_search_result_area">
					<ul class="navbar_search_result"></ul>
				</div>
			</form>

			<div class="navbar__left">
				<button class="res-sidebar-open-btn">
					<i class="las la-bars"></i>
				</button>
				<button type="button" class="fullscreen-btn">
					<i class="fullscreen-open las la-compress"
						onclick="openFullscreen();"></i> <i
						class="fullscreen-close las la-compress-arrows-alt"
						onclick="closeFullscreen();"></i>
				</button>
			</div>

			<div class="navbar__right">
				<ul class="navbar__action-list">
					<li>
						<button type="button" class="navbar-search__btn-open">
							<i class="las la-search"></i>
						</button>
					</li>


					<li class="dropdown">
						<button type="button" class="" data-toggle="dropdown"
							data-display="static" aria-haspopup="true" aria-expanded="false">


							<span class="navbar-user"> <span
								class="navbar-user__thumb"><img

									src="${adminImg}"
									alt="image"></span> <span class="navbar-user__info"> <span
									class="navbar-user__name">${adminUserName}</span>

									
							</span> <span class="icon"><i class="las la-chevron-circle-down"></i></span>
							</span>
						</button>
						<div
							class="dropdown-menu dropdown-menu--sm p-0 border-0 box--shadow1 dropdown-menu-right">
							<a href="/profile"
								class="dropdown-menu__item d-flex align-items-center px-3 py-2">
								<i class="dropdown-menu__icon las la-user-circle"></i> <span
								class="dropdown-menu__caption">Profile</span>
							</a> <a href="/password"
								class="dropdown-menu__item d-flex align-items-center px-3 py-2">
								<i class="dropdown-menu__icon las la-key"></i> <span
								class="dropdown-menu__caption">Password</span>
							</a> <a href="/logout"
								class="dropdown-menu__item d-flex align-items-center px-3 py-2">
								<i class="dropdown-menu__icon las la-sign-out-alt"></i> <span
								class="dropdown-menu__caption">Logout</span>
							</a>
						</div>
					</li>
				</ul>
			</div>
		</nav>
		<!-- navbar-wrapper end -->

		<div class="body-wrapper">
			<div class="bodywrapper__inner">
				<div class="row align-items-center mb-30 justify-content-between">
					<div class="col-lg-6 col-sm-6">
						<h6 class="page-title">Publisher details</h6>
						  <c:if test="${count eq 1}"><div id="snackbar">${Msg}</div></c:if>
        <c:if test="${count eq 2}"><div id="snackbar">${Msg}</div></c:if>
					</div>
					<div
						class="col-lg-6 col-sm-6 text-sm-right mt-sm-0 mt-3 right-part">
					</div>
				</div>
				<div class="row mb-none-30">
					<div class="col-xl-3 col-lg-5 col-md-5 mb-30">
						<div class="card b-radius--10 overflow-hidden box--shadow1">
							<div class="card-body p-0">
								<div class="p-3 bg--white">
									<div class="">
										<img src="images/default.png" alt="profile-image"
											class="b-radius--10 w-100">
									</div>
									<div class="mt-15">
										<h4 class="">${publish.name}</h4>
										<span class="text--small">Joined At <strong><fmt:formatDate type="both" value="${publish.created_at}" /></strong></span>
									</div>
								</div>
							</div>
						</div>

						<div class="card b-radius--10 overflow-hidden mt-30 box--shadow1">
							<div class="card-body">
								<h5 class="mb-20 text-muted">Publisher information</h5>
								<ul class="list-group">

									<li
										class="list-group-item d-flex justify-content-between align-items-center">
										Username <span class="font-weight-bold">${publish.name}</span>
									</li>


									<li
										class="list-group-item d-flex justify-content-between align-items-center">
										Status 
										
										 <c:if test="${publish.status eq 1}"><span class="text--small badge font-weight-normal badge--success">Active</span></c:if>
                             			 <c:if test="${publish.status eq 0}"><span class="text--small badge font-weight-normal badge--warning">Deactive</span></c:if>
                             			 <c:if test="${publish.status eq 2}"><span class="text--small badge font-weight-normal badge--warning ">Banned</span></c:if>

											</li>

									<li
										class="list-group-item d-flex justify-content-between align-items-center">
										Balance <span class="font-weight-bold">${publish.balance} INR</span>
									</li>
								</ul>
							</div>
						</div>
						<div class="card b-radius--10 overflow-hidden mt-30 box--shadow1">
							<div class="card-body">
								<h5 class="mb-20 text-muted">Publisher action</h5>
								<a data-toggle="modal" href="#addSubModal"
									class="btn btn--success btn--shadow btn-block btn-lg">
									Add/Subtract Balance </a> <a
									href="/publisher/login/history/${publish.id}"
									class="btn btn--primary btn--shadow btn-block btn-lg">
									Login Logs </a> <a
									href="/user/email/${publish.id}/publisher"
									class="btn btn--danger btn--shadow btn-block btn-lg"> Send
									Email </a>
							</div>
						</div>
					</div>

					<div class="col-xl-9 col-lg-7 col-md-7 mb-30">

						<div class="row mb-none-30">
							<div class="col-xl-3 col-lg-6 col-sm-6 mb-30">
								<div
									class="dashboard-w1 bg--1 b-radius--10 box-shadow has--link">
									<a href="/publisher/withdrawals/${publish.id}"
										class="item--link"></a>
									<div class="icon">
										<i class="fa fa-credit-card"></i>
									</div>
									<div class="details">
										<div class="numbers">
											<span class="amount">₹ 0 INR</span>

										</div>
										<div class="desciption">
											<span>Total Withdraw</span>
										</div>
									</div>
								</div>
							</div>
							<!-- dashboard-w1 end -->


							<div class="col-xl-3 col-lg-6 col-sm-6 mb-30">
								<div
									class="dashboard-w1 bg--3 b-radius--10 box-shadow has--link">
									<a
										href="/report/publishers/earning-logs?search=${publish.name}"
										class="item--link"></a>
									<div class="icon">
										<i class="fa fa-wallet"></i>
									</div>
									<div class="details">
										<div class="numbers">
											<span class="amount">₹ 0 INR</span>

										</div>
										<div class="desciption">
											<span>Total Earnings</span>
										</div>
									</div>
								</div>
							</div>
							<!-- dashboard-w1 end -->

							<div class="col-xl-3 col-lg-6 col-sm-6 mb-30">
								<div
									class="dashboard-w1 bg--12 b-radius--10 box-shadow has--link">
									<a href="javascript:void(0)" class="item--link"></a>
									<div class="icon">
										<i class="fa fa-hand-point-up"></i>
									</div>
									<div class="details">
										<div class="numbers">
											<span class="amount">0</span>
										</div>
										<div class="desciption">
											<span>Total Click</span>
										</div>
									</div>
								</div>
							</div>
							<!-- dashboard-w1 end -->

							<div class="col-xl-3 col-lg-6 col-sm-6 mb-30">
								<div
									class="dashboard-w1 bg--5 b-radius--10 box-shadow has--link">
									<a href="javascript:void(0)" class="item--link"></a>
									<div class="icon">
										<i class="fa fa-globe"></i>
									</div>
									<div class="details">
										<div class="numbers">
											<span class="amount">0</span>
										</div>
										<div class="desciption">
											<span>Total Impression</span>
										</div>
									</div>
								</div>
							</div>
							<!-- dashboard-w1 end -->
						</div>


						<div class="card mt-40">
							<div class="card-body">
								<h5 class="card-title mb-15 border-bottom pb-2">${publish.username}
									Information</h5>

								<form:form action="/publisher/update/${id}"
									modelAttribute="publish" method="POST"
									onsubmit="return update1();" enctype="multipart/form-data">
									<input type="hidden" name="_token"
										value="xO4X6JbORO7bZlMiw12mcQgqDK5VFwAWBKrsIkEj">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group ">
												<label class="form-control-label font-weight-bold">Name<span
													class="text-danger">*</span></label>
												<form:input class="form-control" type="text" name="name"
													path="name" value="${publish.name}"></form:input>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="form-group ">
												<label class="form-control-label font-weight-bold">Email
													<span class="text-danger">*</span>
												</label>
												<form:input class="form-control" type="email" path="email"
													name="email" value="${publish.email}"></form:input>
											</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label class="form-control-label  font-weight-bold">Mobile
													Number <span class="text-danger">*</span>
												</label>
												<form:input class="form-control" type="text" path="phone"
													name="phone" value="${publish.phone}"></form:input>
											</div>
										</div>
									</div>


									<div class="row mt-2">

										<div class="col-xl-6 col-md-6">
											<div class="form-group">
												<label class="form-control-label font-weight-bold">City
												</label>
												<form:input class="form-control" type="text" name="city"
													path="city" value="${publish.city}"></form:input>
											</div>
										</div>

										<div class="col-xl-6 col-md-6">
											<div class="form-group ">
												<label class="form-control-label font-weight-bold">Country
												</label> 
													
													<select name="country" class="form-control">
													<option><c:if test="${publish.country eq 'selected'}"></c:if> ${publish.country}
													
													  
													
<option value="Åland Islands">Åland Islands</option>
<option value="Albania">Albania</option>
<option value="Algeria">Algeria</option>
<option value="American Samoa">American Samoa</option>
<option value="Andorra">Andorra</option>
<option value="Angola">Angola</option>
<option value="Anguilla">Anguilla</option>
<option value="Antarctica">Antarctica</option>
<option value="Antigua and Barbuda">Antigua and Barbuda</option>
<option value="Argentina">Argentina</option>
<option value="Armenia">Armenia</option>
<option value="Aruba">Aruba</option>
<option value="Australia">Australia</option>
<option value="Austria">Austria</option>
<option value="Azerbaijan">Azerbaijan</option>
<option value="Bahamas">Bahamas</option>
<option value="Bahrain">Bahrain</option>
<option value="Bangladesh">Bangladesh</option>
<option value="Barbados">Barbados</option>
<option value="Belarus">Belarus</option>
<option value="Belgium">Belgium</option>
<option value="Belize">Belize</option>
<option value="Benin">Benin</option>
<option value="Bermuda">Bermuda</option>
<option value="Bhutan">Bhutan</option>
<option value="Bolivia, Plurinational State of bolivia">Bolivia, Plurinational State of bolivia</option>
<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
<option value="Botswana">Botswana</option>
<option value="Bouvet Island">Bouvet Island</option>
<option value="Brazil">Brazil</option>
<option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
<option value="Brunei Darussalam">Brunei Darussalam</option>
<option value="Bulgaria">Bulgaria</option>
<option value="Burkina Faso">Burkina Faso</option>
<option value="Burundi">Burundi</option>
<option value="Cambodia">Cambodia</option>
<option value="Cameroon">Cameroon</option>
<option value="Canada">Canada</option>
<option value="Cape Verde">Cape Verde</option>
<option value="Cayman Islands">Cayman Islands</option>
<option value="Central African Republic">Central African Republic</option>
<option value="Chad">Chad</option>
<option value="Chile">Chile</option>
<option value="China">China</option>
<option value="Christmas Island">Christmas Island</option>
<option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>
<option value="Colombia">Colombia</option>
<option value="Comoros">Comoros</option>
<option value="Congo">Congo</option>
<option value="Congo, The Democratic Republic of the Congo">Congo, The Democratic Republic of the Congo</option>
<option value="Cook Islands">Cook Islands</option>
<option value="Costa Rica">Costa Rica</option>
<option value="Cote d'Ivoire">Cote d'Ivoire</option>
<option value="Croatia">Croatia</option>
<option value="Cuba">Cuba</option>
<option value="Cyprus">Cyprus</option>
<option value="Czech Republic">Czech Republic</option>
<option value="Denmark">Denmark</option>
<option value="Djibouti">Djibouti</option>
<option value="Dominica">Dominica</option>
<option value="Dominican Republic">Dominican Republic</option>
<option value="Ecuador">Ecuador</option>
<option value="Egypt">Egypt</option>
<option value="El Salvador">El Salvador</option>
<option value="Equatorial Guinea">Equatorial Guinea</option>
<option value="Eritrea">Eritrea</option>
<option value="Estonia">Estonia</option>
<option value="Ethiopia">Ethiopia</option>
<option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option>
<option value="Faroe Islands">Faroe Islands</option>
<option value="Fiji">Fiji</option>
<option value="Finland">Finland</option>
<option value="France">France</option>
<option value="French Guiana">French Guiana</option>
<option value="French Polynesia">French Polynesia</option>
<option value="French Southern Territories">French Southern Territories</option>
<option value="Gabon">Gabon</option>
<option value="Gambia">Gambia</option>
<option value="Georgia">Georgia</option>
<option value="Germany">Germany</option>
<option value="Ghana">Ghana</option>
<option value="Gibraltar">Gibraltar</option>
<option value="Greece">Greece</option>
<option value="Greenland">Greenland</option>
<option value="Grenada">Grenada</option>
<option value="Guadeloupe">Guadeloupe</option>
<option value="Guam">Guam</option>
<option value="Guatemala">Guatemala</option>
<option value="Guernsey">Guernsey</option>
<option value="Guinea">Guinea</option>
<option value="Guinea-Bissau">Guinea-Bissau</option>
<option value="Guyana">Guyana</option>
<option value="Haiti">Haiti</option>
<option value="Heard Island and Mcdonald Islands">Heard Island and Mcdonald Islands</option>
<option value="Holy See (Vatican City State)">Holy See (Vatican City State)</option>
<option value="Honduras">Honduras</option>
<option value="Hong Kong">Hong Kong</option>
<option value="Hungary">Hungary</option>
<option value="Iceland">Iceland</option>
<option value="India">India</option>
<option value="Indonesia">Indonesia</option>
<option value="Iran, Islamic Republic of Persian Gulf">Iran, Islamic Republic of Persian Gulf</option>
<option value="Iraq">Iraq</option>
<option value="Ireland">Ireland</option>
<option value="Isle of Man">Isle of Man</option>
<option value="Israel">Israel</option>
<option value="Italy">Italy</option>
<option value="Jamaica">Jamaica</option>
<option value="Japan">Japan</option>
<option value="Jersey">Jersey</option>
<option value="Jordan">Jordan</option>
<option value="Kazakhstan">Kazakhstan</option>
<option value="Kenya">Kenya</option>
<option value="Kiribati">Kiribati</option>
<option value="Korea, Democratic People's Republic of Korea">Korea, Democratic People's Republic of Korea</option>
<option value="Korea, Republic of South Korea">Korea, Republic of South Korea</option>
<option value="Kosovo">Kosovo</option>
<option value="Kuwait">Kuwait</option>
<option value="Kyrgyzstan">Kyrgyzstan</option>
<option value="Laos">Laos</option>
<option value="Latvia">Latvia</option>
<option value="Lebanon">Lebanon</option>
<option value="Lesotho">Lesotho</option>
<option value="Liberia">Liberia</option>
<option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option>
<option value="Liechtenstein">Liechtenstein</option>
<option value="Lithuania">Lithuania</option>
<option value="Luxembourg">Luxembourg</option>
<option value="Macao">Macao</option>
<option value="Macedonia">Macedonia</option>
<option value="Madagascar">Madagascar</option>
<option value="Malawi">Malawi</option>
<option value="Malaysia">Malaysia</option>
<option value="Maldives">Maldives</option>
<option value="Mali">Mali</option>
<option value="Malta">Malta</option>
<option value="Marshall Islands">Marshall Islands</option>
<option value="Martinique">Martinique</option>
<option value="Mauritania">Mauritania</option>
<option value="Mauritius">Mauritius</option>
<option value="Mayotte">Mayotte</option>
<option value="Mexico">Mexico</option>
<option value="Micronesia, Federated States of Micronesia">Micronesia, Federated States of Micronesia</option>
<option value="Moldova">Moldova</option>
<option value="Monaco">Monaco</option>
<option value="Mongolia">Mongolia</option>
<option value="Montenegro">Montenegro</option>
<option value="Montserrat">Montserrat</option>
<option value="Morocco">Morocco</option>
<option value="Mozambique">Mozambique</option>
<option value="Myanmar">Myanmar</option>
<option value="Namibia">Namibia</option>
<option value="Nauru">Nauru</option>
<option value="Nepal">Nepal</option>
<option value="Netherlands">Netherlands</option>
<option value="Netherlands Antilles">Netherlands Antilles</option>
<option value="New Caledonia">New Caledonia</option>
<option value="New Zealand">New Zealand</option>
<option value="Nicaragua">Nicaragua</option>
<option value="Niger">Niger</option>
<option value="Nigeria">Nigeria</option>
<option value="Niue">Niue</option>
<option value="Norfolk Island">Norfolk Island</option>
<option value="Northern Mariana Islands">Northern Mariana Islands</option>
<option value="Norway">Norway</option>
<option value="Oman">Oman</option>
<option value="Pakistan">Pakistan</option>
<option value="Palau">Palau</option>
<option value="Palestinian Territory, Occupied">Palestinian Territory, Occupied</option>
<option value="Panama">Panama</option>
<option value="Papua New Guinea">Papua New Guinea</option>
<option value="Paraguay">Paraguay</option>
<option value="Peru">Peru</option>
<option value="Philippines">Philippines</option>
<option value="Pitcairn">Pitcairn</option>
<option value="Poland">Poland</option>
<option value="Portugal">Portugal</option>
<option value="Puerto Rico">Puerto Rico</option>
<option value="Qatar">Qatar</option>
<option value="Romania">Romania</option>
<option value="Russia">Russia</option>
<option value="Rwanda">Rwanda</option>
<option value="Reunion">Reunion</option>
<option value="Saint Barthelemy">Saint Barthelemy</option>
<option value="Saint Helena, Ascension and Tristan Da Cunha">Saint Helena, Ascension and Tristan Da Cunha</option>
<option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option>
<option value="Saint Lucia">Saint Lucia</option>
<option value="Saint Martin">Saint Martin</option>
<option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</option>
<option value="Saint Vincent and the Grenadines">Saint Vincent and the Grenadines</option>
<option value="Samoa">Samoa</option>
<option value="San Marino">San Marino</option>
<option value="Sao Tome and Principe">Sao Tome and Principe</option>
<option value="Saudi Arabia">Saudi Arabia</option>
<option value="Senegal">Senegal</option>
<option value="Serbia">Serbia</option>
<option value="Seychelles">Seychelles</option>
<option value="Sierra Leone">Sierra Leone</option>
<option value="Singapore">Singapore</option>
<option value="Slovakia">Slovakia</option>
<option value="Slovenia">Slovenia</option>
<option value="Solomon Islands">Solomon Islands</option>
<option value="Somalia">Somalia</option>
<option value="South Africa">South Africa</option>
<option value="South Sudan">South Sudan</option>
<option value="South Georgia and the South Sandwich Islands">South Georgia and the South Sandwich Islands</option>
<option value="Spain">Spain</option>
<option value="Sri Lanka">Sri Lanka</option>
<option value="Sudan">Sudan</option>
<option value="Suriname">Suriname</option>
<option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
<option value="Swaziland">Swaziland</option>
<option value="Sweden">Sweden</option>
<option value="Switzerland">Switzerland</option>
<option value="Syrian Arab Republic">Syrian Arab Republic</option>
<option value="Taiwan">Taiwan</option>
<option value="Tajikistan">Tajikistan</option>
<option value="Tanzania, United Republic of Tanzania">Tanzania, United Republic of Tanzania</option>
<option value="Thailand">Thailand</option>
<option value="Timor-Leste">Timor-Leste</option>
<option value="Togo">Togo</option>
<option value="Tokelau">Tokelau</option>
<option value="Tonga">Tonga</option>
<option value="Trinidad and Tobago">Trinidad and Tobago</option>
<option value="Tunisia">Tunisia</option>
<option value="Turkey">Turkey</option>
<option value="Turkmenistan">Turkmenistan</option>
<option value="Turks and Caicos Islands">Turks and Caicos Islands</option>
<option value="Tuvalu">Tuvalu</option>
<option value="Uganda">Uganda</option>
<option value="Ukraine">Ukraine</option>
<option value="United Arab Emirates">United Arab Emirates</option>
<option value="United Kingdom">United Kingdom</option>
<option value="United States">United States</option>
<option value="Uruguay">Uruguay</option>
<option value="Uzbekistan">Uzbekistan</option>
<option value="Vanuatu">Vanuatu</option>
<option value="Venezuela, Bolivarian Republic of Venezuela">Venezuela, Bolivarian Republic of Venezuela</option>
<option value="Vietnam">Vietnam</option>
<option value="Virgin Islands, British">Virgin Islands, British</option>
<option value="Virgin Islands, U.S.">Virgin Islands, U.S.</option>
<option value="Wallis and Futuna">Wallis and Futuna</option>
<option value="Yemen">Yemen</option>
<option value="Zambia">Zambia</option>
<option value="Zimbabwe">Zimbabwe</option> </select>
                                </div>
                            </div>
                        </div>




									<div class="row">
										<div class="form-group col-xl-4 col-md-6  col-sm-3 col-12">
											<label class="form-control-label font-weight-bold">Status
											</label> <input type="checkbox" name="status1" data-width="100%"
												data-onstyle="-success" data-offstyle="-danger"
												data-toggle="toggle" data-on="Active" data-off="Banned"
												id="chk"
												<c:if test="${publish.status eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_status1" id="chk_0" />


										</div>

										<div class="form-group  col-xl-4 col-md-6  col-sm-3 col-12">
											<label class="form-control-label font-weight-bold">Email
												Verification </label> <input type="checkbox" name="ev1"
												data-width="100%" data-onstyle="-success"
												data-offstyle="-danger" data-toggle="toggle"
												data-on="Verified" data-off="Unverified" id="chk1"
												<c:if test="${publish.ev eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_ev1" id="chk_1" />

										</div>

										<div class="form-group  col-xl-4 col-md-6  col-sm-3 col-12">
											<label class="form-control-label font-weight-bold">SMS
												Verification </label> <input type="checkbox" name="sv1"
												data-width="100%" data-onstyle="-success"
												data-offstyle="-danger" data-toggle="toggle"
												data-on="Verified" data-off="Unverified" id="chk2"
												<c:if test="${publish.sv eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_sv1" id="chk_2" />

										</div>
										<div class="form-group  col-md-6  col-sm-3 col-12">
											<label class="form-control-label font-weight-bold">2FA
												Status </label> <input type="checkbox" name="ts1" data-width="100%"
												data-onstyle="-success" data-offstyle="-danger"
												data-toggle="toggle" data-on="Active" data-off="Deactive"
												id="chk3"
												<c:if test="${publish.ts eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_ts1" id="chk_3" />
										</div>

										<div class="form-group  col-md-6  col-sm-3 col-12">
											<label class="form-control-label font-weight-bold">2FA
												Verification </label> <input type="checkbox" name="tv1"
												data-width="100%" data-onstyle="-success"
												data-offstyle="-danger" data-toggle="toggle"
												data-on="Verified" data-off="Unverified" id="chk4"
												<c:if test="${publish.tv eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_tv1" id="chk_4" />
										</div>
									</div>


									<div class="row mt-4">
										<div class="col-md-12">
											<div class="form-group">
												<button type="submit"
													class="btn btn--primary btn-block btn-lg">Save
													Changes</button>
											</div>
										</div>

									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>




				<div id="addSubModal" class="modal fade" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Add / Subtract Balance</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<form:form
								action="/publisher/add-sub-balance/${publish.id}"
								method="POST" modelAttribute="publish">
								<input type="hidden" name="_token"
									value="xO4X6JbORO7bZlMiw12mcQgqDK5VFwAWBKrsIkEj">
								<div class="modal-body">
									<div class="form-row">
										<div class="form-group col-md-12 fix">
											<input type="checkbox" data-width="100%" data-height="44px"
												data-onstyle="-success" data-offstyle="-danger"
												data-toggle="toggle" data-on="Add Balance"
												data-off="Subtract Balance" name="act" checked>
										</div>


										<div class="form-group col-md-12">
											<label>Amount<span class="text-danger">*</span></label>
											<div class="input-group has_append">
												<input type="text" name="amount" class="form-control"
													placeholder="Please provide positive amount">
												<div class="input-group-append">
													<div class="input-group-text">₹</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn--dark"
										data-dismiss="modal">Close</button>
									<button type="submit" class="btn btn--success">Submit</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>

			</div>
			<!-- bodywrapper__inner end -->
		</div>
		<!-- body-wrapper end -->
	</div>





	<!-- jQuery library -->
	<script src="js/vendor/jquery-3.5.1.min.js"></script>
	<!-- bootstrap js -->
	<script src="js/vendor/bootstrap.bundle.min.js"></script>
	<!-- bootstrap-toggle js -->
	<script src="js/vendor/bootstrap-toggle.min.js"></script>

	<!-- slimscroll js for custom scrollbar -->
	<script src="js/vendor/jquery.slimscroll.min.js"></script>
	<!-- custom select box js -->
	<script src="js/vendor/jquery.nice-select.min.js"></script>



	<script src="js/iziToast.min.js"></script>

	<script>
		"use strict";
		function notify(status, message) {
			iziToast[status]({
				message : message,
				position : "topRight"
			});
		}
	</script>

	<script type="text/javascript">
		
	</script>

	<script type="text/javascript">
		function update() {
			if (document.getElementById('chk').checked) {
				
				document.getElementById('chk_0').disabled = true;
			}

			else if (document.getElementById('chk1').checked) {

			
				document.getElementById('chk_1').disabled = true;
				alert(document.getElementById('chk_1').value);
			}

			else if (document.getElementById("chk2").checked) {

				document.getElementById('chk_2').disabled = true;
			}

			else if (document.getElementById("chk3").checked) {

				document.getElementById('chk_3').disabled = true;
			} else if (document.getElementById("chk4").checked) {

				document.getElementById('chk_4').disabled = true;
			}
		}
	</script>



	<script src="js/nicEdit.js"></script>

	<!-- code preview js -->
	<script src="js/vendor/prism.js"></script>
	<!-- seldct 2 js -->
	<script src="js/vendor/select2.min.js"></script>
	<!-- main js -->
	<script src="js/app.js"></script>


	<script>
		(function($, document) {
			"use strict";
			bkLib.onDomLoaded(function() {
				$(".nicEdit").each(function(index) {
					$(this).attr("id", "nicEditor" + index);
					new nicEditor({
						fullPanel : false
					}).panelInstance('nicEditor' + index, {
						hasPanel : true
					});
				});
			});
			$(document).on('mouseover ', '.nicEdit-main,.nicEdit-panelContain',
					function() {
						$('.nicEdit-main').focus();
					});
		})(jQuery, document);
	</script>

	<script>
		"use strict";
		$(function() {
			$("select[name=country]").val();
		});
	</script>
<script> myFunction()</script>
</body>
</html>
