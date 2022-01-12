<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>AdKrive - Feeds</title>
<base
	href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
<!-- Main link -->
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
<!-- end main link -->

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.14/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,300;0,400;0,500;0,600;0,700;1,800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/datatabcss.css">

<style type="text/css">
.eventType[type=checkbox] {
	height: 0;
	width: 0;
	padding: 0;
	visibility: hidden;
}

.toggle {
	cursor: pointer;
	text-indent: -9999px;
	width: 50px;
	height: 20px;
	background: grey;
	display: block;
	border-radius: 50px;
	position: relative;
}

.toggle:after {
	content: '';
	position: absolute;
	top: 5px;
	left: 5px;
	width: 20px;
	height: 10px;
	background: #fff;
	border-radius: 90px;
	transition: 0.3s;
}

input:checked+.toggle {
	background: #bada55;
}

input:checked+.toggle:after {
	left: calc(100% - 5px);
	transform: translateX(-100%);
}

.toggle:active:after {
	width: 110px;
}
</style>
<style type="text/css">
.form-switch {
	display: inline-block;
	cursor: pointer;
	-webkit-tap-highlight-color: transparent;
}

.form-switch i {
	position: relative;
	display: inline-block;
	margin-right: .5rem;
	width: 46px;
	height: 26px;
	background-color: #e6e6e6;
	border-radius: 23px;
	vertical-align: text-bottom;
	transition: all 0.3s linear;
}

.form-switch i::before {
	content: "";
	position: absolute;
	left: 0;
	width: 42px;
	height: 22px;
	background-color: #fff;
	border-radius: 11px;
	transform: translate3d(2px, 2px, 0) scale3d(1, 1, 1);
	transition: all 0.25s linear;
}

.form-switch i::after {
	content: "";
	position: absolute;
	left: 0;
	width: 22px;
	height: 22px;
	background-color: #fff;
	border-radius: 11px;
	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.24);
	transform: translate3d(2px, 2px, 0);
	transition: all 0.2s ease-in-out;
}

.form-switch:active i::after {
	width: 28px;
	transform: translate3d(2px, 2px, 0);
}

.form-switch:active input:checked+i::after {
	transform: translate3d(16px, 2px, 0);
}

.form-switch input {
	display: none;
}

.form-switch input:checked+i {
	background-color: #4BD763;
}

.form-switch input:checked+i::before {
	transform: translate3d(18px, 2px, 0) scale3d(0, 0, 0);
}

.form-switch input:checked+i::after {
	transform: translate3d(22px, 2px, 0);
}
</style>
<style type="text/css">
.checkboxname {
	display: none;
}
</style>
</head>
<body>

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

									<li class="sidebar-menu-item "><a href="/advertise/all"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">All Advertises</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertise/price-plan" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Price Plan</span>
									</a></li>
									<li class="sidebar-menu-item "><a href="/advertise/type"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Add Type</span>
									</a></li>

									<li class="sidebar-menu-item "><a
										href="/advertise/cpc&amp;cpm" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">CPC & CPM</span>
									</a></li>
									<li class="sidebar-menu-item "><a href="/advertise/ip-log"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Ip Logs</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertise/blocked/ip-log" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Blocked Ip Log</span>
									</a></li>

								</ul>
							</div></li>
						<!-- NEWLY ADDED FEEDS OPTION START-->
						<li class="sidebar-menu-item active"><a href="/feeds/all"
							class="nav-link"> <i class="menu-icon fa fa-rss"
								style="font-size: 16px;" aria-hidden="true"></i> <span
								class="menu-title">Feeds</span>
						</a></li>
						<!--    FEEDS OPTION CLOSED -->
						<li class="sidebar-menu-item "><a href="/keywords"
							class="nav-link"> <i class="menu-icon lab la-kickstarter-k"></i>
								<span class="menu-title">Manage Keywords</span>
						</a></li>


						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon lab la-autoprefixer"></i> <span
								class="menu-title">Manage Advertiser</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item "><a href="/advertiser/all"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">All Advertiser</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/active/all" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">All Active Advertiser</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/banned/all" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Banned Advertiser</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/email-unverified" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Email Unverified</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/sms-unverified" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">SMS Unverified</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/advertiser/send-email" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Send Email to all</span>
									</a></li>
								</ul>
							</div></li>
						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon lab la-chromecast"></i> <span
								class="menu-title">Manage Publisher</span>
						</a>
							<div class="sidebar-submenu  ">
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
											class="menu-title">Email Unverified</span> <span
											class="menu-badge pill bg--primary ml-auto">1</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/publisher/sms-unverified" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">SMS Unverified</span> <span
											class="menu-badge pill bg--primary ml-auto">3</span>
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
							<div class="sidebar-submenu ">
								<ul>

									<li class="sidebar-menu-item "><a href="/domain/pending"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Pending Domain</span>
									</a></li>
									<li class="sidebar-menu-item"><a href="/domain/approved"
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
										href="/gateway/automatic" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Automatic Gateways</span>
									</a></li>
									<li class="sidebar-menu-item  "><a href="/gateway/manual"
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

									<li class="sidebar-menu-item  "><a href="/deposit/pending"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Pending Deposits</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/deposit/approved" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Approved Deposits</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/deposit/successful" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Successful Deposits</span>
									</a></li>


									<li class="sidebar-menu-item  "><a
										href="/deposit/rejected" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Rejected Deposits</span>
									</a></li>

									<li class="sidebar-menu-item  "><a href="/deposit"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">All Deposits</span>
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

									<li class="sidebar-menu-item "><a href="/withdraw/method"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Withdraw Methods</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/withdraw/pending" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Pending Log</span>

									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/withdraw/approved" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Approved Log</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/withdraw/rejected" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Rejected Log</span>
									</a></li>

									<li class="sidebar-menu-item  "><a href="/withdraw/log"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Withdrawals Log</span>
									</a></li>


								</ul>
							</div></li>

						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon la la-ticket"></i> <span class="menu-title">Support
									Ticket </span> <span class="menu-badge pill bg--primary ml-auto">
									<i class="fa fa-exclamation"></i>
							</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item  "><a href="/tickets"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">All Ticket</span>
									</a></li>
									<li class="sidebar-menu-item  "><a href="/tickets/pending"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Pending Ticket</span> <span
											class="menu-badge pill bg--primary ml-auto">2</span>
									</a></li>
									<li class="sidebar-menu-item  "><a href="/tickets/closed"
										class="nav-link"> <i class="menu-icon las la-dot-circle"></i>
											<span class="menu-title">Closed Ticket</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/tickets/answered" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Answered Ticket</span>
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
										href="/report/publishers/earning-logs" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Publishers Earning Log</span>
									</a></li>
									<li class="sidebar-menu-item "><a
										href="/report/transaction/advertisers" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Advertisers TRX Log</span>
									</a></li>

									<li class="sidebar-menu-item "><a
										href="/report/login/history" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Login History</span>
									</a></li>

								</ul>
							</div></li>



						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon fas fa-wrench"></i> <span class="menu-title">SETTINGS
							</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>
									<li class="sidebar-menu-item "><a href="/general-setting"
										class="nav-link"> <i class="menu-icon las la-life-ring"></i>
											<span class="menu-title">General Setting</span>
									</a></li>

									<li class="sidebar-menu-item "><a
										href="/setting/logo-icon" class="nav-link"> <i
											class="menu-icon las la-images"></i> <span class="menu-title">Logo
												Icon Setting</span>
									</a></li>

									<li class="sidebar-menu-item "><a href="/extensions"
										class="nav-link"> <i class="menu-icon las la-cogs"></i> <span
											class="menu-title">Extensions</span>
									</a></li>

									<li class="sidebar-menu-item  "><a href="/language"
										class="nav-link" data-default-url="/language"> <i
											class="menu-icon las la-language"></i> <span
											class="menu-title">Language </span>
									</a></li>

									<li class="sidebar-menu-item "><a href="/seo"
										class="nav-link"> <i class="menu-icon las la-globe"></i> <span
											class="menu-title">SEO Manager</span>
									</a></li>

								</ul>
							</div></li>

						<li class="sidebar-menu-item sidebar-dropdown"><a
							href="javascript:void(0)" class=""> <i
								class="menu-icon la la-envelope-o"></i> <span class="menu-title">Email
									Manager</span>
						</a>
							<div class="sidebar-submenu  ">
								<ul>

									<li class="sidebar-menu-item  "><a
										href="/email-template/global" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Global Template</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/email-template/index" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Email Templates</span>
									</a></li>

									<li class="sidebar-menu-item  "><a
										href="/email-template/setting" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">Email Configure</span>
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
										href="/sms-template/global" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">API Setting</span>
									</a></li>
									<li class="sidebar-menu-item  "><a
										href="/sms-template/index" class="nav-link"> <i
											class="menu-icon las la-dot-circle"></i> <span
											class="menu-title">SMS Templates</span>
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
								class="navbar-user__thumb"><img src="${adminImg}"
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
		<div class="body-wrapper">
			<div class="bodywrapper__inner">
				<div class="row align-items-center mb-30 justify-content-between">
					<div class="col-lg-6 col-sm-6">
						<h6 class="page-title">Feeds</h6>
						<div
							style="top: 0; right: 0; color: green; display: block; float: right;"
							id="msgshow"></div>

					</div>
				</div>
				<div class="container p-30">
					<div class="row">
						<div class="col-md-12 main-datatable">
							<div class="card_body">
								<div class="row d-flex">
									<div class="col-sm-4 createSegment">
										<a class="btn dim_button create_new" href="/add/new/feed">
											<span class="glyphicon glyphicon-plus"></span>Add Feed
										</a>

									</div>
									
									<label class="form-switch"> <input class="selectAll"
										type="checkbox" id="select" <c:if test="${status eq true}">checked="checked"</c:if> /> <i></i> Show All
									</label>
									<!-- 
									<div class="col-sm-4 createSegment">
										<a class="btn dim_button create_new"> <span
											class="glyphicon glyphicon-plus" onclick="myFunction()"></span>Mass Update
										</a>
									</div> -->

									<button class="btn btn-primary" onclick="myFunction()">
										<span id="textId" style="color: white;">Mass Update</span>
									</button>
									
									<div class="col-sm-8 add_flex">
										<div class="form-group searchInput">
											<label for="email">Search:</label> <input type="search"
												class="form-control" id="filterbox"
												placeholder=" Enter name Or ID">
										</div>
									</div>
								</div>





								<div class="overflow-x">

									<table style="width: 100%;" id="filtertable"
										class="table cust-datatable dataTable no-footer">
										<thead>
											<tr>
												<th><input type="checkbox" id="selectAllchkbox"
													class="checkboxname"
													style="margin: 0; padding: 0; width: 15px;"></th>
												<th>Network/Feed</th>
												<th>Status</th>
												<th>Query String</th>
												<th>ID</th>
												<th>Native ID</th>
												<th>Platform</th>
												<th>RevShare, %</th>
												<th>Max Daily Queries</th>
												<th>Latest Update</th>
											</tr>
										</thead>
										<tbody>

											<c:choose>
												<c:when test="${empty networkList}">
													<td class="text-muted text-center" colspan="100%">No
														Feeds Available.</td>
												</c:when>
												<c:otherwise>

													<c:forEach items="${networkList}" var="element">

														<c:set var="count" scope="session" value="${limit}" />
														<c:forEach items="${element.value}" var="dataItem">
															<tr>
																<td><input type="checkbox" class="checkboxname"
																	id="chk${dataItem.feedId}"
																	style="margin: 0; padding: 0; width: 15px;"></td>

																<td><c:set var="test" scope="session"
																		value="${dataItem.feedNetwork.newtworkName}" /> <c:if
																		test="${element.key eq test && count==1}">
																		<h5 style="margin: 0; padding: 0; margin-top: -10px;">${dataItem.feedNetwork.newtworkName}</h5>

																		<c:set var="count" scope="session" value="${limit+1}" />

																	</c:if> <a href="/feedEdit/${dataItem.feedId}">${dataItem.feedName}</a>
																</td>
																<td><c:if test="${dataItem.status}">
																		<input class="eventType" value="${dataItem.feedId}"
																			type="checkbox" id="switch${dataItem.feedId}"
																			checked="checked" />
																		<label for="switch${dataItem.feedId}" class="toggle"></label>

																	</c:if> <c:if test="${dataItem.status eq false}">
																		<input class="eventType" value="${dataItem.feedId}"
																			type="checkbox" id="switch${dataItem.feedId}" />
																		<label for="switch${dataItem.feedId}" class="toggle">Toggle</label>

																	</c:if></td>
																<td><a href="#"
																	data-href="/linkBuilder/${dataItem.feedId}"
																	data-toggle="modal" data-id="${dataItem.feedNetwork.newtworkName}.${dataItem.feedName}" aria-labelledby="showTitle" data-target="#myModal"
																	class="openPopup">XML & API</a></td>
																<td>${dataItem.feedId}</td>
																<td>${dataItem.native_id}</td>
																<td>${dataItem.platform}</td>
																<td><input type="number" name="revenueShare"
																	style="text-align: center; padding: 0; width: 70px; height: 29px;"
																	value="${dataItem.revenueShare}" /></td>
																<td><input type="number" name="dailyMaxQuery"
																	style="text-align: center; padding: 0; width: 70px; height: 29px;"
																	value="${dataItem.dailyMaxQuery}" /></td>
																<td data-label="Date"><fmt:formatDate type="both"
																		value="${dataItem.created_at}" pattern="dd-MMM-yyyy" /></td>

															</tr>
														</c:forEach>


													</c:forEach>
												</c:otherwise>

											</c:choose>



										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="showTitle"></h4>
					</div>
					<div class="modal-body">
						 <input type="text" name="bookId" id="bookId" value=""/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>



		<!-- jQuery library -->
		<script
			src="https://adjuction.in/assets/admin/js/vendor/jquery-3.5.1.min.js"></script>
		<!-- bootstrap js -->
		<script src="js/vendor/bootstrap.bundle.min.js"></script>
		<!-- bootstrap-toggle js -->
		<script src="js/vendor/bootstrap-toggle.min.js"></script>

		<!-- slimscroll js for custom scrollbar -->
		<script src="js/vendor/jquery.slimscroll.min.js"></script>
		<!-- custom select box js -->
		<script src="js/vendor/jquery.nice-select.min.js"></script>

		<script src="js/nicEdit.js"></script>

		<!-- code preview js -->
		<script src="js/vendor/prism.js"></script>
		<!-- seldct 2 js -->
		<script src="js/vendor/select2.min.js"></script>
		<!-- main js -->
		<script src="js/app.js"></script>

		<script
			src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>
		<script type="text/javascript"
			src="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.js"></script>
		<script src="js/datanewTab.js"></script>
		<script type="text/javascript">
			$('.selectAll')
					.click(
							function() {
								var checked = $(this).is(':checked');
								if (checked) {
									$
											.ajax({
												type : 'GET',
												url : '${req.getContextPath()}/select/',
												data : {
													"status" : checked
												},
												success : function(data) {

													window.location.href = '/feeds/all';
															

												}
											});

								}
								else
								{
									var checked = $(this).is(':checked');
									unselect(checked);
								}

							});
			
			function unselect(checked) {
				
				
				$.ajax({
					type : 'GET',
					url : '${req.getContextPath()}/unselect/',
					data : {
						"status" : checked
					},
					success : function(data) {

						window.location.href = '/feeds/all';
								

					}
				});
			}
		</script>

		<script type="text/javascript">
			$(function() {
				$(".eventType").change(function(e) {
					var checked = $(this).is(':checked');
					var feedid = $(this).val();

					if (checked) {
						$.ajax({

							type : 'GET',
							url : '${req.getContextPath()}/check/',

							data : {
								"id" : feedid,
								"status" : checked
							},
							success : function(data) {
								$("#msgshow").text(data);
								$('#msgshow').fadeIn('fast');
							}

						});

						setTimeout(function() {
							$('#msgshow').fadeOut('fast');

						}, 4000);
					} else {
						var checked = $(this).is(':checked');
						uncheck(feedid, checked);

					}

				});
			});

			function uncheck(feedid, status) {
				$.ajax({
					type : 'GET',
					url : '${req.getContextPath()}/uncheck',
					data : {
						"id" : feedid,
						"status" : status
					},
					cache : false,
					success : function(data) {
						$("#msgshow").text(data);
						$('#msgshow').fadeIn('fast');
					}
				});
				
				setTimeout(function() {
					$('#msgshow').fadeOut('fast');

				}, 4000);
			}
		</script>

		<script type="text/javascript">
		$(document).ready(function() {

			  $(".checkBoxClass").on("click", function() {
			    debugger
			    if ($(this).prop("checked")) {
			      var columns = $(this).closest("tr").find("td:not(:first-child)");
			      $(columns).each(function(index) {
			        console.log("Column " + (index + 1) + " has value " + $(this).text());
			      });
			    }

			  });

			});
		
		</script>
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
				$(document).on('mouseover ',
						'.nicEdit-main,.nicEdit-panelContain', function() {
							$('.nicEdit-main').focus();
						});
			})(jQuery, document);
		</script>

		<script>
$(document).ready(function(){
    $('.openPopup').on('click',function(event){
    	 var myFeedTitle = $(this).data('id');
    	    
    	$('#showTitle').html(myFeedTitle);
        var dataURL = $(this).attr('data-href');
        $('.modal-body').load(dataURL,function(){
            $('#myModal').modal({show:true});
        });
    }); 
});
</script>

	<script type="text/javascript">
	$(document).ready(function()
	{
		$('#selectAllchkbox').click(function()
		{
			$('.checkboxname').prop('checked',$(this).prop('checked'));
		});
	});
</script>

		<script>
function myFunction() {
  var x = document.getElementsByClassName("checkboxname");
  var change = document.getElementById("textId");
  change.innerHTML = 'EditSelected';
  for (var i = 0; i < x.length; i++) {
  if (x[i].style.display !== "block") {
    x[i].style.display = "block";
  } else {
    x[i].style.display = "none";
  }
  }
}
</script>
		<!-- <script>
function changeDefault()
{
	window.location.reload(); 
}
</script>
		<script>
	function updateAllSelect()
	{
		$('input:checkbox').on('change', function() {
		    var result = [];

		    $('input:checkbox:checked').each(function() {

		      var rowText = '';
		      $(this).parent().siblings().each(function() {
		        rowText += $(this).text() + ' ';
		      });
		      result.push(rowText.trim());
		    });

		    alert(JSON.stringify(result));
		  });
		});
	}
	
</script> -->
</body>
</html>

