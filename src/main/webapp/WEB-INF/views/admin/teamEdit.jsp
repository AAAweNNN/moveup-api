<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/favicon.ico" type="image/ico"/>

    <title>JapanMoveUpWestAdmin</title>

    <!-- Bootstrap -->
    <link href="/static/admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/static/admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/static/admin/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/static/admin/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- bootstrap-wysiwyg -->
    <link href="/static/admin//vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="/static/admin//vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="/static/admin//vendors/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="/static/admin//vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- bootstrap-progressbar -->
    <link href="/static/admin/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="/static/admin/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="/static/admin/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <link href="/static/admin/vendors/bootstrap-datetimepicker-master/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"
          rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/static/admin/build/css/custom.min.css" rel="stylesheet">
    <!-- bootstrap-fileinput -->
    <link href="/static/admin/vendors/bootstrap-fileinput/css/fileinput.css" rel="stylesheet">

    <style>
        .validatorError {
            color: red;
        }
    </style>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <!-- sidebar menu -->
        <jsp:include page="sidebar.jsp"/>
        <!-- /sidebar menu -->

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                <span style="color: silver">Admin管理者&nbsp;&nbsp;</span>岡山 太郎
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="javascript:;">Help</a></li>
                                <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                            </ul>
                        </li>


                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Team管理</h3>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Team基本情報

                                </h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>

                                <form:form id="userForm" modelAttribute="teamForm" enctype="multipart/form-data"
                                           action="${pageContext.request.contextPath}/admin/team/update/"
                                           class="form-horizontal form-label-left">

                                <div class="item form-group">
                                    <div>
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">カテゴリ <span
                                                class="required">*</span>
                                        </label>
                                        <div class="col-md-1 col-sm-6 col-xs-12">
                                            <form:select path="type" required="required" data-validate-minmax="10,100"
                                                         class="form-control col-md-7 col-xs-12">
                                                <c:if test="${teamForm.type ==1}">
                                                    <form:option value="1">EVENT</form:option>
                                                    <form:option value="2">MOVEUP</form:option>
                                                    <form:option value="3">TEAM</form:option>
                                                </c:if>
                                                <c:if test="${teamForm.type ==2}">
                                                    <form:option value="1">EVENT</form:option>
                                                    <form:option value="2">MOVEUP</form:option>
                                                    <form:option value="3">TEAM</form:option>
                                                </c:if>
                                                <c:if test="${teamForm.type ==3}">
                                                    <form:option value="1">EVENT</form:option>
                                                    <form:option value="2">MOVEUP</form:option>
                                                    <form:option value="3">TEAM</form:option>
                                                </c:if>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div>
                                        <label class="control-label col-md-1 col-sm-3 col-xs-12" for="date">日付 <span
                                                class="required">*</span>
                                        </label>
                                        <div class="col-md-2 col-sm-6 col-xs-12">
                                            <form:input path="date" type="text" id="datetimepicker" name="date"
                                                        class="form-control col-md-7 col-xs-12 "
                                                        data-date-format="yyyy-mm-dd hh:ii"/>
                                        </div>
                                    </div>
                                    <div>
                                        <label class="control-label col-md-1 col-sm-3 col-xs-12">TOP表示<span
                                                class="required">*</span></label>
                                        <div class="col-md-1 col-sm-6 col-xs-12">
                                            <form:input path="sortScore" id="sortScore"
                                                        class="form-control col-md-7 col-xs-12"
                                                        name="sortScore" required="required" type="text"
                                                        value="${teamForm.sortScore}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="title">タイトル <span
                                            class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="title" id="title" class="form-control col-md-7 col-xs-12"
                                                    name="title" required="required" type="text"
                                                    value="${teamForm.title}"/>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">詳細抜粋 <span
                                            class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="excerpt" type="text" id="excerpt" name="excerpt"
                                                    required="required"
                                                    class="form-control col-md-7 col-xs-12"
                                                    value="${teamForm.excerpt}"/>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <div class="col-md-3 col-sm-6 col-xs-12"></div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <label class=" col-md-5 col-sm-3 col-xs-12"
                                                   style="text-align: left;padding:0 5px;" for="">TOP画像<span
                                                    class="required"></span>
                                            </label>
                                            <label class=" col-md-7 col-sm-3 col-xs-12" style="text-align: right">解像度:
                                                500 X 500</label>
                                        </div>
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <form:input path="picFile1" id="picFile1"
                                                        class="form-control col-md-7 col-xs-12" name="picFile1"
                                                        required="" type="file" multiple="multiple"/>
                                                <%--<c:forEach items="${teamForm.picUrl1}" var="url1">--%>
                                                <%--<div><img src="${url1}" class='file-preview-image kv-preview-data  col-md-2 col-sm-1 col-xs-12'--%>
                                                <%--style='width:20%;height:20%;max-width:100%;max-height:100%;margin-bottom: 20px;' alt='' title=''></div>--%>
                                                <%--</c:forEach>--%>
                                        </div>
                                    </div>
                                </div>
                                <div class="item form-group" style="margin-top: 30px;">
                                    <div class="col-md-3 col-sm-6 col-xs-12"></div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <label class=" col-md-5 col-sm-3 col-xs-12"
                                                   style="text-align: left;padding:0 5px;" for="">FOOT画像<span
                                                    class="required"></span>
                                            </label>
                                            <label class=" col-md-7 col-sm-3 col-xs-12" style="text-align: right">解像度:
                                                500 X 500</label>
                                        </div>
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <form:input path="picFile2" id="picFile2"
                                                        class="form-control col-md-7 col-xs-12" name="picFile2"
                                                        required="" type="file" multiple="multiple"/>
                                                <%--<c:forEach items="${teamForm.picUrl2}" var="url1">--%>
                                                <%--<div><img src="${url1}" class='file-preview-image kv-preview-data  col-md-2 col-sm-1 col-xs-12'--%>
                                                <%--style='width:20%;height:20%;max-width:100%;max-height:100%;margin-bottom: 20px;' alt='' title=''></div>--%>
                                                <%--</c:forEach>--%>
                                        </div>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="">詳細 <span
                                            class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="detail" id="detail" required="" name="detail" type="hidden"
                                                    class="form-control col-md-7 col-xs-12" cssStyle="height: 200px;"
                                                    value="${teamForm.detail}"></form:input>
                                        <div class="x_content">
                                            <div id="alerts"></div>
                                            <div class="btn-toolbar editor" data-role="editor-toolbar"
                                                 data-target="#editor">
                                                <div class="btn-group">
                                                    <a class="btn dropdown-toggle" data-toggle="dropdown"
                                                       title="Font"><i class="fa fa-font"></i><b class="caret"></b></a>
                                                    <ul class="dropdown-menu">
                                                    </ul>
                                                </div>

                                                <div class="btn-group">
                                                    <a class="btn dropdown-toggle" data-toggle="dropdown"
                                                       title="Font Size"><i class="fa fa-text-height"></i>&nbsp;<b
                                                            class="caret"></b></a>
                                                    <ul class="dropdown-menu">
                                                        <li>
                                                            <a data-edit="fontSize 5">
                                                                <p style="font-size:17px">Huge</p>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a data-edit="fontSize 3">
                                                                <p style="font-size:14px">Normal</p>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a data-edit="fontSize 1">
                                                                <p style="font-size:11px">Small</p>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>

                                                <div class="btn-group">
                                                    <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"
                                                       id="btn-bold"><i class="fa fa-bold"></i></a>
                                                    <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i
                                                            class="fa fa-italic"></i></a>
                                                    <a class="btn" data-edit="strikethrough" title="Strikethrough"><i
                                                            class="fa fa-strikethrough"></i></a>
                                                    <a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i
                                                            class="fa fa-underline"></i></a>
                                                </div>

                                                <div class="btn-group">
                                                    <a class="btn" data-edit="insertunorderedlist"
                                                       title="Bullet list"><i class="fa fa-list-ul"></i></a>
                                                    <a class="btn" data-edit="insertorderedlist" title="Number list"><i
                                                            class="fa fa-list-ol"></i></a>
                                                    <a class="btn" data-edit="outdent"
                                                       title="Reduce indent (Shift+Tab)"><i
                                                            class="fa fa-dedent"></i></a>
                                                    <a class="btn" data-edit="indent" title="Indent (Tab)"><i
                                                            class="fa fa-indent"></i></a>
                                                </div>

                                                <div class="btn-group">
                                                    <a class="btn" data-edit="justifyleft"
                                                       title="Align Left (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></a>
                                                    <a class="btn" data-edit="justifycenter"
                                                       title="Center (Ctrl/Cmd+E)"><i
                                                            class="fa fa-align-center"></i></a>
                                                    <a class="btn" data-edit="justifyright"
                                                       title="Align Right (Ctrl/Cmd+R)"><i
                                                            class="fa fa-align-right"></i></a>
                                                    <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i
                                                            class="fa fa-align-justify"></i></a>
                                                </div>

                                                <div class="btn-group">
                                                    <a class="btn dropdown-toggle" data-toggle="dropdown"
                                                       title="Hyperlink"><i class="fa fa-link"></i></a>
                                                    <div class="dropdown-menu input-append">
                                                        <input class="span2" placeholder="URL" type="text"
                                                               data-edit="createLink"/>
                                                        <button class="btn" type="button">Add</button>
                                                    </div>
                                                    <a class="btn" data-edit="tel" title="Telephone"><i
                                                            class="fa fa-phone"></i></a>
                                                    <a class="btn" data-edit="unlink" title="Remove Hyperlink"><i
                                                            class="fa fa-cut"></i></a>
                                                </div>

                                                    <%--<div class="btn-group">--%>
                                                    <%--<a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="fa fa-picture-o"></i></a>--%>
                                                    <%--<input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />--%>
                                                    <%--</div>--%>

                                                <div class="btn-group">
                                                    <a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i
                                                            class="fa fa-undo"></i></a>
                                                    <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i
                                                            class="fa fa-repeat"></i></a>
                                                </div>
                                            </div>


                                            <div id="editor" class="editor-wrapper placeholderText"
                                                 contenteditable="true"></div>

                                                <%--<form:textarea path="detail" id="detail" required="" name="editor-one" contenteditable="true"--%>
                                                <%--class="form-control col-md-7 col-xs-12 editor-wrapper placeholderText" cssStyle="height: 200px;"></form:textarea>--%>
                                        </div>
                                    </div>
                                </div>
                                <div class="item form-group">
                                    <div>
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="publishStart">掲載開始日 </label>
                                        <div class="col-md-2 col-sm-6 col-xs-12">
                                            <form:input path="publishStart" type="text" id="publishStart"
                                                        name="publishStart"
                                                        data-date-format="yyyy-mm-dd hh:ii"
                                                        class="form-control col-md-7 col-xs-12"/>
                                        </div>
                                    </div>
                                    <div>
                                        <label class="control-label col-md-1 col-sm-3 col-xs-12"
                                               for="publishEnd">掲載終了日 </label>
                                        <div class="col-md-2 col-sm-6 col-xs-12">
                                            <form:input path="publishEnd" type="text" id="publishEnd" name="publishEnd"
                                                        data-date-format="yyyy-mm-dd hh:ii"
                                                        class="form-control col-md-7 col-xs-12"/>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="form-group">
                                <div class="col-md-6 col-md-offset-3">
                                    <a class="btn btn-primary" href="/admin/team/list/" style="width: 100px;">キャンセル</a>
                                    <form:input type="hidden" path="id" value="${teamForm.id}"/>
                                    <form:input type="hidden" path="picUrl1" value="${teamForm.picUrl1}"/>
                                    <form:input type="hidden" path="picUrl2" value="${teamForm.picUrl2}"/>
                                    <button id="send" type="submit" class="btn btn-success" style="width: 100px;">登録
                                    </button>
                                </div>
                            </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /page content -->

    <!-- footer content -->
    <footer>
        <div class="pull-right">
            Japan Move Up West Admin
        </div>
        <div class="clearfix"></div>
    </footer>
    <!-- /footer content -->
</div>
</div>
<div id="teamLoading" style="display: none" class="loading">
    <div class="loading-text">Processing...</div>
</div>

<!-- jQuery -->
<script src="/static/admin/vendors/jquery/dist/jquery.min.js"></script>
<!-- jquery validator -->
<script src="/static/admin/vendors/jquery-validation-1.17.0/dist/jquery.validate.min.js"></script>
<script src="/static/admin/vendors/jquery-validation-1.17.0/dist/localization/messages_ja.min.js"></script>
<!-- Bootstrap -->
<script src="/static/admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/static/admin/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/static/admin/vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="/static/admin/vendors/Chart.js/dist/Chart.min.js"></script>
<!-- gauge.js -->
<script src="/static/admin/vendors/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="/static/admin/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="/static/admin/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="/static/admin/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="/static/admin/vendors/Flot/jquery.flot.js"></script>
<script src="/static/admin/vendors/Flot/jquery.flot.pie.js"></script>
<script src="/static/admin/vendors/Flot/jquery.flot.time.js"></script>
<script src="/static/admin/vendors/Flot/jquery.flot.stack.js"></script>
<script src="/static/admin/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="/static/admin/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="/static/admin/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="/static/admin/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- bootstrap-wysiwyg -->
<script src="/static/admin/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
<script src="/static/admin/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
<script src="/static/admin/vendors/google-code-prettify/src/prettify.js"></script>
<script src="/static/admin/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
<script src="/static/admin/vendors/switchery/dist/switchery.min.js"></script>
<script src="/static/admin/vendors/parsleyjs/dist/parsley.min.js"></script>
<script src="/static/admin/vendors/starrr/dist/starrr.js"></script>
<script src="/static/admin/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
<!-- DateJS -->
<script src="/static/admin/vendors/DateJS/build/date.js"></script>
<!-- JQVMap -->
<script src="/static/admin/vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="/static/admin/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="/static/admin/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="/static/admin/vendors/moment/min/moment.min.js"></script>
<script src="/static/admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="/static/admin/vendors/core/jquery.ui.core.js"></script>
<script src="/static/admin/vendors/bootstrap-datetimepicker-master/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="/static/admin/vendors/bootstrap-datetimepicker-master/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="/static/admin/build/js/custom.min.js"></script>
<!-- bootstrap-fileinput -->
<script src="/static/admin/vendors/bootstrap-fileinput/js/fileinput.js"></script>
<script src="/static/admin/vendors/bootstrap-fileinput/js/locales/ja.js"></script>

<script>
    var $userForm = $("#userForm");
    $userForm.validate({
        submitHandler: function (form) {
            $("#detail").val($('#editor').html());
            $('#teamLoading').show();
            $(form).submit();
        },
        errorClass: "validatorError",
        rules: {
            date: {
                required: true
            },
            sortScore: {
                digits: true,
                required: true,
                maxlength: 4
            },
            title: {
                required: true,
                maxlength: 60
            },
            excerpt: {
                required: true,
                maxlength: 255
            },
            detail: {
                required: true,
                maxlength: 2048
            }
        }
    });
    $('#editor').html($("#detail").val());
    $('#datetimepicker').datetimepicker({
        autoclose: 1,
    });
    $('#publishStart').datetimepicker({
        autoclose: 1,
    });
    $('#publishEnd').datetimepicker({
        autoclose: 1,
    });

    $('#picFile1').fileinput({
        'language': 'ja',
        'showClose': true,
        'showCaption': false,
        'showRemove': false,
        'dropZoneTitle': '',
        'showUpload': false,
        'previewFileType': 'any',
        'autoReplace': true,
        "minImageWidth": 500,
        "maxImageWidth": 500,
        "minImageHeight": 500,
        "maxImageHeight": 500
        <c:if test="${teamForm.picUrl1 != null && teamForm.picUrl1 != ''}">
        ,
        'uploadUrl': null,
        'initialPreview': [
            <c:forEach items="${teamForm.picUrl1}" var="url1">
            "<img src='${url1}' class='file-preview-image kv-preview-data' stype='width:auto;height:auto;max-width:100%;max-height:100%;' alt='Desert' title='Desert'>",
            </c:forEach>
        ]
        </c:if>
    });

    $('#picFile2').fileinput({
        'language': 'ja',
        'showClose': true,
        'showCaption': false,
        'showRemove': false,
        'dropZoneTitle': '',
        'showUpload': false,
        'previewFileType': 'any',
        'autoReplace': true,
        "minImageWidth": 500,
        "maxImageWidth": 500,
        "minImageHeight": 500,
        "maxImageHeight": 500
        <c:if test="${teamForm.picUrl2 != null && teamForm.picUrl2 != ''}">
        ,
        'uploadUrl': null,
        'initialPreview': [
            <c:forEach items="${teamForm.picUrl2}" var="url2">
            "<img src='${url2}' class='file-preview-image kv-preview-data' stype='width:auto;height:auto;max-width:100%;max-height:100%;' alt='Desert' title='Desert'>",
            </c:forEach>
        ]
        </c:if>
    });

    document.getElementById('picFile1').value = null;
    document.getElementById('picFile2').value = null;

    function remove1() {
        document.getElementById('picUrl1').value = null;
    }

    function remove2() {
        document.getElementById('picUrl2').value = null;
    }

</script>

<script>
    function initToolbarBootstrapBindings() {
        var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
                'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                'Times New Roman', 'Verdana', 'San Francisco'],
            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
        $.each(fonts, function (idx, fontName) {
            fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
        });
    };
    initToolbarBootstrapBindings();
</script>

</body>
</html>