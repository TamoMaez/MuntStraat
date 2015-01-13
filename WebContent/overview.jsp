<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.Business"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="head.jsp">
	<jsp:param name="title" value="Overview" />
</jsp:include>

<body ng-app="bsSearch" ng-controller="bsController">

	<jsp:include page="header.jsp">
		<jsp:param name="active" value="home" />
	</jsp:include>

	<div class="margin-medium hidden-xs"></div>
	<div class="container">
		<div class="row">
			<div class="col-xs-4 col-lg-3">
				<div class="row">
					<div class="col-xs-10">
						<div class="cutout">
							<h4 class="cutout-content uppercase">My Filter</h4>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="" data-toggle="collapse" href="#collapseType" ng-click="filterDb(); setFilter();">All <span
													data-ng-bind="totalBs" class="badge">23</span></a>
									<ul class="collapse in" id="collapseType"
										aria-expanded="false">
										
									<li ng-repeat="(key, value) in map">
									<a href="#" ng-click="filterDb('type='+key); setFilter(key);">{{ key }} <span
													class="badge">{{ value }}</span></a>
								
									</li></ul>
						
								<li><a href="#">Acties</a></li>
								<li><a href="#">My
										Orders</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="margin-medium"></div>
			</div>

			<div class="col-xs-8 col-lg-9">
				<main>
				<div  class="main-content">
				
				
					<div class="row">
						<div class="col-lg-6">
							<div class="page-title">
								<h1 class="uppercase default-color">My Search 
								<small> 
								<span ng-repeat="x in filters">
								<span ng-if="$first"> / </span>
								<span class="tag">{{ x }}</span>
								<span ng-if="!$last"> > </span>
							</span>
							</small>
							</h1>
							</div>
						</div>

						<div class="col-lg-6 grid-list-pull-down">
							<div class="btn-group pull-right" aria-label="Right Align">
        <button type="button" ng-click="grid = true" ng-init="grid=true" class="btn btn-default active" aria-label="Left Align"><span class="glyphicon glyphicon-th" aria-hidden="true"></span></button>
        <button type="button" ng-click="grid = false" class="btn btn-default" aria-label="Center Align"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span></button>
      </div>
						</div>
					</div>
					<div class="margin-medium"></div>
					<div style="position:relative" class="row">
					<div class="modal"><!-- Place at bottom of page --></div>
						<div class="col-lg-6">
							<h5>
								<span><span class="items-length default-color">{{ (list | filter:search).length }}
								</span>found </span>
								
							</h5>
						</div>
						<!-- /.col-lg-6 -->
						<div class="col-lg-6">
							<div class="input-group">
								<input type="text" class="form-control" ng-model="query"
									placeholder="Search by name..."> <span
									class="input-group-btn">
									<button disabled class="btn btn-default" type="button">Instant result</button>
								</span>
							</div>
							<!-- /input-group -->
						</div>
						<!-- /.col-lg-6 -->
					</div>
					<!-- /.row -->

					<div class="margin-small hidden-xs"></div>


					<div id="result">

						<div ng-if="grid">
						
						<div ng-repeat="x in filtered = (list | filter:search | orderBy:'naam')" ng-if="$index%4==0" class="animate-repeat row">
							<div
								ng-repeat="x in filtered = (list | filter:search | orderBy:'naam')"
								ng-if="($index >= $parent.$index) && ($index - $parent.$index < 4)" class="animate-repeat col-sm-6 col-md-3">
									
									<jsp:include page="gridItem.jsp">
										<jsp:param name="title" value="" />
									</jsp:include>
								
							</div>
						</div>
						</div>
						<div ng-if="!grid">
							<div
								ng-repeat="x in filtered = (list | filter:search | orderBy:'naam')"
								class="animate-repeat media">
								
									<jsp:include page="listItem.jsp">
										<jsp:param name="title" value="" />
									</jsp:include>
								
						</div>
						</div>
					</div>
				</div>
				</main>
			</div>
		</div>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>