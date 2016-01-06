<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/1/6
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- basic styles -->

    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>


    <link rel="stylesheet" href="assets/css/ym_fontfamily.css"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>

    <!-- JS部分 -->

    <script src="assets/js/ace-extra.min.js"></script>

    <title></title>
</head>
<body>


<div class="page-content" style="padding:3px 15px">


    <div class="row">
        <div class="col-xs-12">
            <div class="table-header">
                BluePrint Price List
            </div>
            <div class="table-responsive">
                <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Production Costs</th>
                        <th>Facility Fee</th>
                        <th>Sell Price</th>
                        <th>Profit</th>
                        <th>Profit Rate</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:if test="${!empty bluepricelist}">
                        <c:forEach items="${bluepricelist}" var="bpl">

                            <td class="center">
                                <a href="#">${bpl.typename}</a>
                            </td>

                            <td>
                                    ${bpl.materialcost}
                            </td>
                            <td>${bpl.facilityfee}</td>
                            <td>${bpl.sellprice}</td>
                            <c:if test="${ bpl.income>=0}">
                                <td style="color: forestgreen">${bpl.income}</td>
                            </c:if>
                            <c:if test="${ bpl.income<0}">
                                <td style="color: red">${bpl.income}</td>
                            </c:if>
                            <td>${bpl.profit}</td>

                            </tr>
                        </c:forEach>
                    </c:if>

                    </tbody>
                </table>
            </div>

        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->

</div>
<!-- /.page-content -->


<script src="assets/js/jquery-2.0.3.min.js"></script>


<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>


<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>


<!-- page specific plugin scripts -->

<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>

<!-- ace scripts -->

<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<!-- ace scripts -->

<script type="text/javascript">
    jQuery(function ($) {
        var oTable1 = $('#sample-table-2').dataTable({
            "bFilter": false,
            "iDisplayLength": 5,
            "bLengthChange": false,
            "aoColumns": [
                {"bSortable": false},
                null, null, null, null, null,
                {"bSortable": false}]
        });
    })

</script>
</body>
</html>
