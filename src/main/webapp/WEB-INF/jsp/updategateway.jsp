<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>AdKrive - Update Gateway : ${pmnt.name}</title>
    <!-- site favicon -->
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
                    <div class="sidebar-submenu  ">
                        <ul>

                            <li class="sidebar-menu-item ">
                                <a href="/domain/pending" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Pending Domain</span>
                                                                    </a>
                            </li>
                            <li class="sidebar-menu-item ">
                                <a href="/domain/approved" class="nav-link">
                                    <i class="menu-icon las la-dot-circle"></i>
                                    <span class="menu-title">Approved Domain</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li class="sidebar-menu-item sidebar-dropdown">
                    <a href="javascript:void(0)" class="side-menu--open">
                        <i class="menu-icon las la-credit-card"></i>
                        <span class="menu-title">Payment Gateways</span>

                    </a>
                    <div class="sidebar-submenu sidebar-submenu__open ">
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
                    src="data:image/png;base64,${pfImage}"
                    alt="image"></span>

            <span class="navbar-user__info">
              <span class="navbar-user__name">admin</span>
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
        <h6 class="page-title">Update Gateway : ${pmnt.name}</h6>
    </div>
    <div class="col-lg-6 col-sm-6 text-sm-right mt-sm-0 mt-3 right-part">
            <a href="/admin/gateway/automatic" class="btn btn-sm btn--primary box--shadow1 text--small"><i class="la la-fw fa-backward"></i>Go Back</a>
    </div>
</div>
                    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <form:form action="https://adjuction.in/admin/gateway/automatic/update/${pmnt.id}" method="POST" modelAttribute="pmnt"
                      enctype="multipart/form-data">
                      <input type="hidden" name="alias" value="${pmnt.name}">
                    <input type="hidden" name="description" value="">
                    <div class="card-body">
                        <div class="payment-method-item">
                            <div class="payment-method-header d-flex flex-wrap">
                                <div class="thumb">
                                    <div class="avatar-preview">
                                        <div class="profilePicPreview" style="background-image: url('https://adjuction.in/placeholder-image/800x800')"></div>
                                    </div>
                                    <div class="avatar-edit">
                                        <input type="file" name="image" class="profilePicUpload" id="image" accept=".png, .jpg, .jpeg"/>
                                        <label for="image" class="bg--primary"><i class="la la-pencil"></i></label>
                                    </div>
                                </div>

                                <div class="content">
                                    <div class="d-flex justify-content-between">
                                        <h3 class="title">Paypal</h3>
                                        <div class="input-group d-flex flex-wrap justify-content-end has_append width-375">
                                            <select class="newCurrencyVal ">
                                                <option value="">Select currency</option>
                                                                                                    <option value="AUD" data-symbol="AUD">AUD </option>
                                                                                                    <option value="BRL" data-symbol="BRL">BRL </option>
                                                                                                    <option value="CAD" data-symbol="CAD">CAD </option>
                                                                                                    <option value="CZK" data-symbol="CZK">CZK </option>
                                                                                                    <option value="DKK" data-symbol="DKK">DKK </option>
                                                                                                    <option value="EUR" data-symbol="EUR">EUR </option>
                                                                                                    <option value="HKD" data-symbol="HKD">HKD </option>
                                                                                                    <option value="HUF" data-symbol="HUF">HUF </option>
                                                                                                    <option value="INR" data-symbol="INR">INR </option>
                                                                                                    <option value="ILS" data-symbol="ILS">ILS </option>
                                                                                                    <option value="JPY" data-symbol="JPY">JPY </option>
                                                                                                    <option value="MYR" data-symbol="MYR">MYR </option>
                                                                                                    <option value="MXN" data-symbol="MXN">MXN </option>
                                                                                                    <option value="TWD" data-symbol="TWD">TWD </option>
                                                                                                    <option value="NZD" data-symbol="NZD">NZD </option>
                                                                                                    <option value="NOK" data-symbol="NOK">NOK </option>
                                                                                                    <option value="PHP" data-symbol="PHP">PHP </option>
                                                                                                    <option value="PLN" data-symbol="PLN">PLN </option>
                                                                                                    <option value="GBP" data-symbol="GBP">GBP </option>
                                                                                                    <option value="RUB" data-symbol="RUB">RUB </option>
                                                                                                    <option value="SGD" data-symbol="SGD">SGD </option>
                                                                                                    <option value="SEK" data-symbol="SEK">SEK </option>
                                                                                                    <option value="CHF" data-symbol="CHF">CHF </option>
                                                                                                    <option value="THB" data-symbol="THB">THB </option>
                                                                                                    <option value="USD" data-symbol="$">USD </option>
                                                
                                            </select>


                                            <div class="input-group-append">
                                                <button type="button" class="btn btn--primary newCurrencyBtn" data-crypto="0" data-name="Paypal">Add new                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <p></p>
                                </div>
                            </div>

                                                        <div class="payment-method-body mt-2">
                                <h4 class="mb-3">Global Setting for Paypal</h4>
                                <div class="row">
                                                                            <div class="form-group col-lg-6">
                                            <label>PayPal Email <span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" name="global[paypal_email]" value="paypal@user.com" required/>
                                        </div>
                                                                    </div>
                            </div>
                        </div>
                        <!-- payment-method-item start -->

                                                                        
                    <!-- payment-method-item end -->


                        <!-- **new payment-method-item start -->
                        <div class="payment-method-item child--item newMethodCurrency d-none">
                            <input disabled type="hidden" name="currency[1][symbol]"
                                   class="currencySymbol">
                            <div class="payment-method-header d-flex flex-wrap">
                                <div class="thumb">
                                    <div class="avatar-preview">
                                        <div class="profilePicPreview"
                                             style="background-image: url('https://adjuction.in/placeholder-image/800x800')">

                                        </div>
                                    </div>
                                    <div class="avatar-edit">
                                        <input disabled type="file" accept=".png, .jpg, .jpeg" class="profilePicUpload" id="image1" name="currency[1][image]"/>
                                        <label for="image1" class="bg-primary"><i class="la la-pencil"></i></label>
                                    </div>
                                </div>
                                <div class="content">
                                    <div class="d-flex justify-content-between">
                                        <div class="form-group">
                                            <h4 class="mb-3" id="payment_currency_name">Name</h4>
                                            <input disabled type="text" class="form-control" placeholder="Name for Gateway" name="currency[1][name]" required/>
                                        </div>
                                        <div class="remove-btn">
                                            <button type="button" class="btn btn-danger newCurrencyRemove">
                                                <i class="la la-trash-o mr-2"></i>Remove                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="payment-method-body">
                                <div class="row">
                                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
                                        <div class="card border--primary mt-2">
                                            <h5 class="card-header bg--primary">Range</h5>
                                            <div class="card-body">
                                                <div class="input-group mb-3">
                                                    <label class="w-100">Minimum Amount <span class="text-danger">*</span></label>
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">INR</div>
                                                    </div>
                                                    <input disabled type="text" class="form-control" name="currency[1][min_amount]" placeholder="0" required/>
                                                </div>

                                                <div class="input-group">
                                                    <label class="w-100">Maximum Amount <span class="text-danger">*</span></label>
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">INR</div>
                                                    </div>

                                                    <input disabled type="text" class="form-control" placeholder="0" name="currency[1][max_amount]" required/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
                                        <div class="card border--primary mt-2">
                                            <h5 class="card-header bg--primary">Charge</h5>
                                            <div class="card-body">
                                                <div class="input-group mb-3">
                                                    <label class="w-100">Fixed Charge <span class="text-danger">*</span></label>
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">INR</div>
                                                    </div>
                                                    <input disabled type="text" class="form-control" placeholder="0" name="currency[1][fixed_charge]" required/>
                                                </div>
                                                <div class="input-group">
                                                    <label class="w-100">Percent Charge <span class="text-danger">*</span></label>
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">%</div>
                                                    </div>
                                                    <input disabled type="text" class="form-control" placeholder="0" name="currency[1][percent_charge]" required>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
                                        <div class="card border--primary mt-2">
                                            <h5 class="card-header bg--primary">Currency</h5>
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="input-group mb-3">
                                                            <label class="w-100">Currency</label>
                                                            <input disabled type="text" class="form-control currencyText border-radius-5" name="currency[1][currency]" readonly/>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-6">
                                                        <div class="input-group mb-3">
                                                            <label class="w-100">Symbol</label>
                                                            <input type="text" name="currency[1][symbol]" class="form-control border-radius-5 symbl" ata-crypto="0" disabled/>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="input-group">
                                                    <label class="w-100">Rate <span class="text-danger">*</span></label>
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <b>1 </b>&nbsp; INR&nbsp; =
                                                        </div>
                                                    </div>
                                                    <input disabled type="text" class="form-control" placeholder="0" name="currency[1][rate]" required/>
                                                    <div class="input-group-append">
                                                        <div class="input-group-text"><span class="currency_symbol"></span></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    
                                </div>
                            </div>
                        </div>
                        <!-- **new payment-method-item end -->
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn--primary btn-block py-2">
                            Update Setting                        </button>
                    </div>
                </form:form>
            </div>
        </div>


    </div>



    
    <div id="deleteModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Gateway Currency Remove Confirmation</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="https://adjuction.in/admin/gateway/automatic/remove/101" method="POST">
                    <input type="hidden" name="_token" value="5oasvCaNnqLMzcFxwaydaC5MPdU9axxbM2HjogYo">                    <input type="hidden" name="id">
                    <div class="modal-body">
                        <p>Are you sure to delete <span class="font-weight-bold name"></span> gateway currency?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn--danger">Delete</button>
                        <button type="button" class="btn btn--dark" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

            </div><!-- bodywrapper__inner end -->
        </div><!-- body-wrapper end -->
    </div>





<!-- jQuery library -->
<script src="https://adjuction.in/assets/admin/js/vendor/jquery-3.5.1.min.js"></script>
<!-- bootstrap js -->
<script src="https://adjuction.in/assets/admin/js/vendor/bootstrap.bundle.min.js"></script>
<!-- bootstrap-toggle js -->
<script src="https://adjuction.in/assets/admin/js/vendor/bootstrap-toggle.min.js"></script>

<!-- slimscroll js for custom scrollbar -->
<script src="https://adjuction.in/assets/admin/js/vendor/jquery.slimscroll.min.js"></script>
<!-- custom select box js -->
<script src="https://adjuction.in/assets/admin/js/vendor/jquery.nice-select.min.js"></script>


<link rel="stylesheet" href="https://adjuction.in/assets/admin/css/iziToast.min.css">
<script src="https://adjuction.in/assets/admin/js/iziToast.min.js"></script>

<script>
"use strict";
    function notify(status,message) {
        iziToast[status]({
            message: message,
            position: "topRight"
        });
    }
</script>

<script src="https://adjuction.in/assets/admin/js/nicEdit.js"></script>

<!-- code preview js -->
<script src="https://adjuction.in/assets/admin/js/vendor/prism.js"></script>
<!-- seldct 2 js -->
<script src="https://adjuction.in/assets/admin/js/vendor/select2.min.js"></script>
<!-- main js -->
<script src="https://adjuction.in/assets/admin/js/app.js"></script>


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
        $(function () {
            "use strict";

            $('.newCurrencyBtn').on('click', function () {
            var form = $('.newMethodCurrency');

            var getCurrencySelected = $('.newCurrencyVal').find(':selected').val();
            var currency = $(this).data('crypto') == 1 ? 'USD' : `${getCurrencySelected}`;

            if (!getCurrencySelected) return;
            form.find('input').removeAttr('disabled');
            var symbol = $('.newCurrencyVal').find(':selected').data('symbol');
            form.find('.currencyText').val(getCurrencySelected);
            form.find('.currency_symbol').text(currency);
            $('#payment_currency_name').text(`${$(this).data('name')} - ${getCurrencySelected}`);
            form.removeClass('d-none');
            $('html, body').animate({scrollTop: $('html, body').height()}, 'slow');

            $('.newCurrencyRemove').on('click', function () {
                form.find('input').val('');
                // form.addClass('d-none');
                form.remove();
            });

        });

        $('.deleteBtn').on('click', function () {
            var modal = $('#deleteModal');
            modal.find('input[name=id]').val($(this).data('id'));
            modal.find('.name').text($(this).data('name'));
            modal.modal('show');
        });

        $('.symbl').on('input', function () {
            var curText = $(this).data('crypto') == 1 ? 'USD' : $(this).val();
            $(this).parents('.payment-method-body').find('.currency_symbol').text(curText);
        });

        $('.copyInput').on('click', function (e) {
            var copybtn = $(this);
            var input = copybtn.parent().parent().siblings('input');
            if (input && input.select) {
                input.select();
                try {
                    document.execCommand('SelectAll')
                    document.execCommand('Copy', false, null);
                    input.blur();
                    copybtn.addClass('copied');
                    setTimeout(function () {
                        copybtn.removeClass('copied');
                    }, 1000);
                } catch (err) {
                    alert('Please press Ctrl/Cmd + C to copy');
                }
            }
        });

        });

    </script>


</body>
</html>
