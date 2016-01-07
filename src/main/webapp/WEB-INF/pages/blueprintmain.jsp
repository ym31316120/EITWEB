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


<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try {
            ace.settings.check('breadcrumbs', 'fixed')
        } catch (e) {
        }
    </script>

    <ul class="breadcrumb">
        <li>
            <i class="icon-home home-icon"></i>
            EvE
        </li>
        <li class="active">BluePrint</li>
    </ul>
</div>

<div class="page-content">


    <div class="row">
        <div class="col-xs-12">

            <div class="row">
                <div class="col-sm-3">
                    <div class="widget-box">
                        <div class="widget-header header-color-blue2">
                            <h4 class="lighter smaller">BluePrint Group</h4>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main padding-8">
                                <div id="tree1" class="tree"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-9">
                    <div class="row">
                        <div class="col-xs-12">
                            <iframe src="/bpList" id="blueListFrame" name="blueListFrame" style="padding: 0px; width: 100%; height: 340px;" frameborder="no" border="0"
                                    ></iframe>
                        </div>
                    </div>

                    <div class="space-2"></div>

                    <div class="row">
                        <div class="col-xs-12">
                            <iframe src="/bpdetailCart" id="blueDetailCartFrame" name="blueDetailCartFrame" style="padding: 0px; width: 100%; height: 200px;" frameborder="no" border="0"
                                    ></iframe>
                        </div>
                    </div>
                </div>
            </div>
            <!-- PAGE CONTENT ENDS -->
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

<script src="assets/js/eit/eit_tree_data.js"></script>
<script src="assets/js/fuelux/fuelux.tree.min.js"></script>

<!-- ace scripts -->

<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<!-- ace scripts -->

<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>
<script type="text/javascript">


    jQuery(function ($) {

        $('#tree1').ace_tree({
            dataSource: treeDataEit ,
            loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
            'open-icon' : 'icon-folder-open',
            'close-icon' : 'icon-folder-close',
            'selectable' : false,
            'selected-icon' : null,
            'unselected-icon' : null
        });


    });
</script>
</body>
</html>
