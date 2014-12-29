<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.Business"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="row">
	<div class="col-xs-10">
		<div class="cutout">
			<h4 class="cutout-content uppercase">My Filter</h4>
			<ul class="nav nav-pills nav-stacked">
				<li><a class="" data-toggle="collapse" href="#collapseType"
					aria-expanded="false" aria-controls="collapseType">Type of
						business</a>
					<ul class="collapse in" id="collapseType" aria-expanded="true">
						
					</ul></li>
				<li><a href="https://oneplus.net/be_nl/customer/address">Address
						Book</a></li>
				<li><a href="https://oneplus.net/be_nl/sales/order/history">My
						Orders</a></li>
				<li><a href="https://oneplus.net/be_nl/awrma/customer_rma/list">RMA</a></li>
				<li class="last"><a
					href="https://oneplus.net/be_nl/warehouse/sales_order/pendingpayment">My
						Pending Payments</a></li>
				<li class="last"><a href="https://oneplustech.zendesk.com">Ticket
						Overview</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="margin-medium"></div>