<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<!-- meta tags and other links -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>AdKrive - General Settings</title>
    <base
	href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
 <link rel="shortcut icon" type="image/png" href="images/logoIcon/favicon.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap">
    <!-- bootstrap 4  -->
    <link rel="stylesheet" href="css/vendor/bootstrap.min.css">
    <!-- bootstrap toggle css -->
    <link rel="stylesheet" href="css/vendor/bootstrap-toggle.min.css">
    <!-- fontawesome 5  -->
    <link rel="stylesheet" href="css/all.min.css">
    <!-- line-awesome webfont -->
    <link rel="stylesheet" href="css/line-awesome.min.css">

        <link rel="stylesheet" href="css/spectrum.css">

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
        .sp-replacer {
            padding: 0;
            border: 1px solid rgba(0, 0, 0, .125);
            border-radius: 5px 0 0 5px;
            border-right: none;
        }

        .sp-preview {
            width: 100px;
            height: 46px;
            border: 0;
        }

        .sp-preview-inner {
            width: 110px;
        }

        .sp-dd {
            display: none;
        }
    </style>
    </head>
<body>
    <!-- page-wrapper start -->
    <div class="page-wrapper default-version">
        <div class="sidebar capsule--rounded bg_img overlay--indigo overlay--opacity-8"
     data-background="images/sidebar/2.jpg">
    <button class="res-sidebar-close-btn"><i class="las la-times"></i></button>
    <div class="sidebar__inner">
        <div class="sidebar__logo">
            <a href="/dashboard" class="sidebar__main-logo"><img
                    src="images/logoIcon/logo.png" alt="image"></a>
            <a href="/dashboard" class="sidebar__logo-shape"><img
                    src="images/logoIcon/favicon.png" alt="image"></a>
            <button type="button" class="navbar__expand"></button>
        </div>

        <div class="sidebar__menu-wrapper" id="sidebar__menuWrapper">
            <ul class="sidebar__menu">
                <li class="sidebar-menu-item ">
                    <a href="/dashboard" class="nav-link ">
                        <i class="menu-icon las la-home"></i>
                        <span class="menu-title">Dashboard</span>
                    </a>
                </li>
                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon las la-ad"></i>
                        <span class="menu-title">Advertises </span>
                    </a>
                    <div class="sidebar-submenu  ">
                        <ul>

                            <li class="sidebar-menu-item ">
                                <a href="/advertise/all" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">All Advertises</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertise/price-plan" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Price Plan</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertise/type" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Add Type</span>
                                </a>
                            </li>

                            <li class="sidebar-menu-item ">
                                <a href="/advertise/cpc&amp;cpm" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">CPC & CPM</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertise/ip-log" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Ip Logs</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertise/blocked/ip-log" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Blocked Ip Log</span>
                                </a>
                            </li>

                        </ul>
                    </div>
                </li>

	<!-- NEWLY ADDED FEEDS OPTION START-->
							 <li class="sidebar-menu-item ">

                    <a href="/feeds/all" class="nav-link">

                       <i class="menu-icon fa fa-rss" style="font-size:16px;" aria-hidden="true"></i>
                        <span class="menu-title">Feeds</span>
                    </a>
                </li>
					<!--    FEEDS OPTION CLOSED -->
                <li class="sidebar-menu-item ">
                    <a href="/keywords" class="nav-link">
                        <i class="menu-icon lab la-kickstarter-k"></i>
                        <span class="menu-title">Manage Keywords</span>
                    </a>
                </li>


                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon lab la-autoprefixer"></i>
                        <span class="menu-title">Manage Advertiser</span>
                    </a>
                    <div class="sidebar-submenu  ">
                        <ul>

                            <li class="sidebar-menu-item ">
                                <a href="/advertiser/all" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">All Advertiser</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertiser/active/all" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">All Active Advertiser</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertiser/banned/all" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Banned Advertiser</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertiser/email-unverified" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Email Unverified</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertiser/sms-unverified" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">SMS Unverified</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/advertiser/send-email" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Send Email to all</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon lab la-chromecast"></i>
                        <span class="menu-title">Manage Publisher</span>
                    </a>
                    <div class="sidebar-submenu  ">
                        <ul>

                            <li class="sidebar-menu-item ">
                                <a href="/publisher/all" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">All Publisher</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/publisher/active/all" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">All Active Publisher</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/publisher/banned/all" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Banned Publishers</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/publisher/email-unverified" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Email Unverified</span>
                                                                        <span
                                        class="menu-badge pill bg--primary ml-auto">1</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/publisher/sms-unverified" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">SMS Unverified</span>
                                                                        <span
                                        class="menu-badge pill bg--primary ml-auto">3</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/publisher/send-email" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Send Email to all</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>


                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon las la-check-circle"></i>
                        <span class="menu-title">Manage Domain</span>
                                            </a>
                    <div class="sidebar-submenu ">
                        <ul>

                            <li class="sidebar-menu-item ">
                                <a href="/domain/pending" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Pending Domain</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item">
                                <a href="/domain/approved" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Approved Domain</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon las la-credit-card"></i>
                        <span class="menu-title">Payment Gateways</span>

                    </a>
                    <div class="sidebar-submenu  ">
                        <ul>

                            <li class="sidebar-menu-item  ">
                                <a href="/gateway/automatic" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Automatic Gateways</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item  ">
                                <a href="/gateway/manual" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Manual Gateways</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon las la-credit-card"></i>
                        <span class="menu-title">Deposits</span>
                                            </a>
                    <div class="sidebar-submenu  ">
                        <ul>

                            <li class="sidebar-menu-item  ">
                                <a href="/deposit/pending" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Pending Deposits</span>
                                                                    </a>
                            </li>

                            <li class="sidebar-menu-item  ">
                                <a href="/deposit/approved" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Approved Deposits</span>
                                </a>
                            </li>

                            <li class="sidebar-menu-item  ">
                                <a href="/deposit/successful" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Successful Deposits</span>
                                </a>
                            </li>


                            <li class="sidebar-menu-item  ">
                                <a href="/deposit/rejected" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Rejected Deposits</span>
                                </a>
                            </li>

                            <li class="sidebar-menu-item  ">
                                <a href="/deposit" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">All Deposits</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon la la-bank"></i>
                        <span class="menu-title">Withdrawals </span>
                                            </a>
                    <div class="sidebar-submenu  ">
                        <ul>

                            <li class="sidebar-menu-item ">
                                <a href="/withdraw/method" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Withdraw Methods</span>
                                </a>
                            </li>

                            <li class="sidebar-menu-item  ">
                                <a href="/withdraw/pending" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Pending Log</span>

                                                                    </a>
                            </li>

                            <li class="sidebar-menu-item  ">
                                <a href="/withdraw/approved" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Approved Log</span>
                                </a>
                            </li>

                            <li class="sidebar-menu-item  ">
                                <a href="/withdraw/rejected" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Rejected Log</span>
                                </a>
                            </li>

                            <li class="sidebar-menu-item  ">
                                <a href="/withdraw/log" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Withdrawals Log</span>
                                </a>
                            </li>


                        </ul>
                    </div>
                </li>

                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon la la-ticket"></i>
                        <span class="menu-title">Support Ticket </span>
                                                    <span class="menu-badge pill bg--primary ml-auto">
                                <i class="fa fa-exclamation"></i>
                            </span>
                                            </a>
                    <div class="sidebar-submenu  ">
                        <ul>

                            <li class="sidebar-menu-item  ">
                                <a href="/tickets" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">All Ticket</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item  ">
                                <a href="/tickets/pending" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Pending Ticket</span>
                                                                            <span
                                            class="menu-badge pill bg--primary ml-auto">2</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item  ">
                                <a href="/tickets/closed" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Closed Ticket</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item  ">
                                <a href="/tickets/answered" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Answered Ticket</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>


                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="">
                        <i class="menu-icon la la-list"></i>
                        <span class="menu-title">Report </span>
                    </a>
                    <div class="sidebar-submenu  ">
                        <ul>
                            <li class="sidebar-menu-item ">
                                <a href="/report/publishers/earning-logs" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Publishers Earning Log</span>
                                </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/report/transaction/advertisers" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Advertisers TRX Log</span>
                                </a>
                            </li>

                            <li class="sidebar-menu-item ">
                                <a href="/report/login/history" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Login History</span>
                                </a>
                            </li>

                        </ul>
                    </div>
                </li>




               <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="side-menu--open">
                    <i class="menu-icon fas fa-wrench"></i>
                        
                        <span class="menu-title">SETTINGS </span>
                    </a>
                   <div class="sidebar-submenu sidebar-submenu__open ">
                    <ul>
                    	<li class="sidebar-menu-item active">
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
                <span class="text--primary">AdsRock</span>
                <span class="text--success">V1.1 </span>
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
        <input type="search" name="navbar-search__field" id="navbar-search__field"
               placeholder="Search...">
        <button type="button" class="navbar-search__close"><i class="las la-times"></i></button>

        <div id="navbar_search_result_area">
            <ul class="navbar_search_result"></ul>
        </div>
    </form>

    <div class="navbar__left">
        <button class="res-sidebar-open-btn"><i class="las la-bars"></i></button>
        <button type="button" class="fullscreen-btn">
            <i class="fullscreen-open las la-compress" onclick="openFullscreen();"></i>
            <i class="fullscreen-close las la-compress-arrows-alt" onclick="closeFullscreen();"></i>
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
                <button type="button" class="" data-toggle="dropdown" data-display="static" aria-haspopup="true"
                        aria-expanded="false">


           <span class="navbar-user">
            <span class="navbar-user__thumb"><img

                    src="${adminImg}"
                    alt="image"></span>

            <span class="navbar-user__info">
              <span class="navbar-user__name">${adminUserName}</span>


          
            </span>
            <span class="icon"><i class="las la-chevron-circle-down"></i></span>
          </span>
                </button>
                <div class="dropdown-menu dropdown-menu--sm p-0 border-0 box--shadow1 dropdown-menu-right">
                                            <a href="/profile"
                           class="dropdown-menu__item d-flex align-items-center px-3 py-2">
                            <i class="dropdown-menu__icon las la-user-circle"></i>
                            <span class="dropdown-menu__caption">Profile</span>
                        </a>
                    
                                            <a href="/password"
                           class="dropdown-menu__item d-flex align-items-center px-3 py-2">
                            <i class="dropdown-menu__icon las la-key"></i>
                            <span class="dropdown-menu__caption">Password</span>
                        </a>
                    
                                            <a href="/logout"
                           class="dropdown-menu__item d-flex align-items-center px-3 py-2">
                            <i class="dropdown-menu__icon las la-sign-out-alt"></i>
                            <span class="dropdown-menu__caption">Logout</span>
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
        <h6 class="page-title">General Settings</h6>
        <c:if test="${count eq 1}"><div id="snackbar">${Msg}</div></c:if>
    </div>
    <div class="col-lg-6 col-sm-6 text-sm-right mt-sm-0 mt-3 right-part">
            </div>
</div>
                    <div class="row mb-none-30">
        <div class="col-lg-12 col-md-12 mb-30">
            <div class="card">
                <div class="card-body">

                    <form:form action="" method="POST" enctype="multipart/form-data" modelAttribute="generalSetting">
                        <input type="hidden" name="_token" value="qwPIH86FsA0csfC9VDB7zj1hQEdLyEcVf1zr4dpI">                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group ">
                                    <label class="form-control-label font-weight-bold"> Site Title </label>
                                    <input class="form-control form-control-lg" type="text" name="sitename"
                                           value="${genSetting.sitename}">
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-group ">
                                    <label class="form-control-label font-weight-bold">Currency</label>
                                    <input class="form-control  form-control-lg" type="text" name="cur_text"
                                           value="${genSetting.cur_text}">
                                </div>
                            </div>

                            <div class="col">
                                <div class="form-group ">
                                    <label class="form-control-label font-weight-bold">Currency Symbol </label>
                                    <input class="form-control  form-control-lg" type="text" name="cur_sym"
                                           value="${genSetting.cur_sym}">
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-group ">
                                    <label class="form-control-label font-weight-bold">Fraud Time Interval (minute) </label>
                                    <input class="form-control  form-control-lg" type="text" name="intervals"
                                           value="${genSetting.intervals}">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group ">
                                    <label class="form-control-label font-weight-bold"> Address </label>
                                    <input class="form-control form-control-lg" type="text" name="address"
                                           value="${genSetting.address}">
                                </div>
                            </div>

                            <div class="col">
                                <div class="form-group ">
                                    <label class="form-control-label font-weight-bold">Office Email</label>
                                    <input class="form-control  form-control-lg" type="text" name="email"
                                           value="${genSetting.email}">
                                </div>
                            </div>

                            <div class="col">
                                <div class="form-group ">
                                    <label class="form-control-label font-weight-bold">Phone </label>
                                    <input class="form-control  form-control-lg" type="text" name="phone"
                                           value="${genSetting.phone}">
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-group ">
                                    <label class="form-control-label font-weight-bold">Location API Key </label>
                                    <input class="form-control  form-control-lg" type="text" name="apikey"
                                           value="${genSetting.apikey}">
                                </div>
                            </div>
                        </div>

                        <div class="row ">
                            <div class="form-group col-md-3">
                                <label class="form-control-label font-weight-bold"> Site Base Color</label>
                                <div class="input-group">
                                <span class="input-group-addon ">
                                    <input type='text' class="form-control  form-control-lg colorPicker" 
                                           value="${genSetting.base_color}"/>
                                </span>
                                    <input type="text" class="form-control form-control-lg colorCode" name="base_color"
                                           value="${genSetting.base_color}"/>
                                </div>
                            </div>

                            <div class="form-group col-md-3">
                                <label class="form-control-label font-weight-bold"> Site Secondary Color</label>
                                <div class="input-group">
                                <span class="input-group-addon">
                                    <input type='text' class="form-control form-control-lg colorPicker"
                                           value="${genSetting.secondary_color}"/>
                                </span>
                                    <input type="text" class="form-control form-control-lg colorCode" name="secondary_color"
                                           value="${genSetting.secondary_color}"/>
                                </div>
                            </div>


                            <div class="form-group col-md-3">
                                <label class="form-control-label font-weight-bold">User Registration</label>
                                <input type="checkbox" data-width="100%" data-size="large" data-onstyle="-success" data-offstyle="-danger" data-toggle="toggle"
                                 data-on="Enable" data-off="Disabled" name="registration1" 
                                 <c:if test="${genSetting.registration eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_registration1" id="chk_0" />
                                 
                            </div>
                            <div class="form-group col-lg-3 col-sm-6 col-md-4">
                                <label class="form-control-label font-weight-bold">Domain Approval</label>
                                <input type="checkbox" data-width="100%" data-size="large" data-onstyle="-success"
                                 data-offstyle="-danger" data-toggle="toggle" data-on="Enable" data-off="Disable" name="domain_approval1" 
                                 
                                  <c:if test="${genSetting.domain_approval eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_domain_approval1" id="chk_1" />
                                 
                            </div>

                        </div>

                        <div class="row ">
                            <div class="form-group col-lg-3 col-sm-6 col-md-4">
                                <label class="form-control-label font-weight-bold"> Email Verification</label>
                                <input type="checkbox" data-width="100%" data-size="large" data-onstyle="-success"
                                
                                 data-offstyle="-danger" data-toggle="toggle" data-on="Enable" data-off="Disable" name="ev1" 
                                 
                                 
                                  <c:if test="${genSetting.ev eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_ev1" id="chk_2" />
                            </div>
                            <div class="form-group col-lg-3 col-sm-6 col-md-4">
                                <label class="form-control-label font-weight-bold">Email Notification</label>
                                <input type="checkbox" data-width="100%" data-size="large" data-onstyle="-success"
                                 data-offstyle="-danger" data-toggle="toggle" data-on="Enable" data-off="Disable" name="en1"
                                 <c:if test="${genSetting.en eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_en1" id="chk_3" />
                                  
                            </div>
                            <div class="form-group col-lg-3 col-sm-6 col-md-4">
                                <label class="form-control-label font-weight-bold"> SMS Verification</label>
                                <input type="checkbox" data-width="100%" data-size="large" data-onstyle="-success"
                                 data-offstyle="-danger" data-toggle="toggle" data-on="Enable" data-off="Disable" name="sv1"
                                 <c:if test="${genSetting.sv eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_sv1" id="chk_4" />
                                  
                            </div>
                            <div class="form-group col-lg-3 col-sm-6 col-md-4">
                                <label class="form-control-label font-weight-bold">SMS Notification</label>
                                <input type="checkbox" data-width="100%" data-size="large" data-onstyle="-success" 
                                data-offstyle="-danger" data-toggle="toggle" data-on="Enable" data-off="Disable" name="sn1" 
                                <c:if test="${genSetting.sn eq 1}">checked="checked"</c:if> />
											<input type="hidden" value="0" name="_sn1" id="chk_5" />
                            </div>

                        </div>

                        <div class="row">
                            <div class="col">
                                <div class="form-group">
                                    <label class="form-control-label font-weight-bold">Geo Target Location Api Key (<span class="text--danger">Visit ipstack.com to get your api key</span> )</label>
                                    <input class="form-control  form-control-lg" type="text" name="location_api"
                                           value="${genSetting.location_api}">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn--primary btn-block btn-lg">Update</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
            </div><!-- bodywrapper__inner end -->
        </div><!-- body-wrapper end -->
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


<link rel="stylesheet" href="css/iziToast.min.css">
<script src="js/iziToast.min.js"></script>

<script>
"use strict";
    function notify(status,message) {
        iziToast[status]({
            message: message,
            position: "topRight"
        });
    }
</script>
    <script src="js/spectrum.js"></script>

<script src="js/nicEdit.js"></script>

<!-- code preview js -->
<script src="js/vendor/prism.js"></script>
<!-- seldct 2 js -->
<script src="js/vendor/select2.min.js"></script>
<!-- main js -->
<script src="js/app.js"></script>


<script>
    (function($,document){
        "use strict";
        bkLib.onDomLoaded(function() {
            $( ".nicEdit" ).each(function( index ) {
                $(this).attr("id","nicEditor"+index);
                new nicEditor({fullPanel : false}).panelInstance('nicEditor'+index,{hasPanel : true});
            });
        });
        $( document ).on('mouseover ', '.nicEdit-main,.nicEdit-panelContain',function(){
            $('.nicEdit-main').focus();
        });
    })(jQuery, document);
</script>

    <script>
        'use strict';
        $('.colorPicker').spectrum({
            color: $(this).data('color'),
            change: function (color) {
                $(this).parent().siblings('.colorCode').val(color.toHexString().replace(/^#?/, ''));
            }
        });

        $('.colorCode').on('input', function () {
            var clr = $(this).val();
            $(this).parents('.input-group').find('.colorPicker').spectrum({
                color: clr,
            });
        });
    </script>

<script>myFunction()</script>
</body>
</html>
