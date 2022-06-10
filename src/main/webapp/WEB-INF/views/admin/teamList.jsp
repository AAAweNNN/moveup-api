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

    <!-- bootstrap-progressbar -->
    <link href="/static/admin/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="/static/admin/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="/static/admin/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="/static/admin/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="/static/admin/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="/static/admin/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="/static/admin/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="/static/admin/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    <link href="/static/admin/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="/static/admin/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="/static/admin/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/static/admin/build/css/custom.min.css" rel="stylesheet">

    <style>
        .validatorError {
            color: red;
        }

        .dark {
            display: none;
        }

        .alert-info {
            display: none;
        }
    </style>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <!-- sidebar menu -->
        <jsp:include page="sidebar.jsp" flush="true"/>
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
                        <h3>レポート管理</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>レポート
                                    <small>検索結果</small>
                                </h2>
                                <div class="clearfix"></div>
                            </div>

                            <div class="x_content">
                                <div class="col-md-2 col-sm-1 col-xs-12"><p>検索条件：</p></div>
                                <div class="col-md-9 col-sm-9 col-xs-12"></div>
                                <div class=" col-sm-1 col-sm-1 col-xs-12">
                                    <a class="btn btn-round btn-success"
                                       href="${pageContext.request.contextPath}/admin/team/regist/"
                                       style="width: 100px;" onclick="gotoRegist()"><span
                                            class="glyphicon glyphicon-plus"
                                            aria-hidden="true"></span>新規</a>
                                </div>
                                </p>

                                <form id="userForm" class="form-horizontal form-label-left input_mask" method="post">
                                    <div class="col-md-11">
                                        <label class="control-label col-md-1 col-sm-1 col-xs-12">カテゴリ</label>
                                        <div class="col-md-3 col-sm-3 col-xs-12 form-group has-feedback">
                                            <span class="fa fa-bars form-control-feedback left"
                                                  aria-hidden="true"></span>
                                            <select class="form-control has-feedback-left" id="type"
                                                    style="-webkit-appearance: none; padding-left: 45px;">
                                                <option value="9">全部</option>
                                                <option value="1">EVENT</option>
                                                <option value="2">MOVEUP</option>
                                                <option value="3">TEAM</option>
                                            </select>
                                        </div>
                                        <label class="control-label col-md-1 col-sm-1 col-xs-12">日付</label>
                                        <div class="col-md-3 col-sm-3 col-xs-12 form-group">
                                            <span class="fa fa-calendar form-control-feedback left"
                                                  aria-hidden="true"></span>
                                            <input type="date" class="form-control has-feedback-left"
                                                   style="padding-right: 0;" id="date">
                                        </div>
                                        <label class="control-label col-md-1 col-sm-1 col-xs-12">TOP表示</label>
                                        <div class="col-md-3 col-sm-1 col-xs-12 form-group has-feedback">
                                            <span class="fa fa-fire form-control-feedback left"
                                                  aria-hidden="true"></span>
                                            <input type="text" class="form-control has-feedback-left" id="sortScore"
                                                   data-rule-digits="true" data-rule-maxlength="4">
                                        </div>
                                        <label class="control-label col-md-1 col-sm-1 col-xs-12">掲載開始&gt=</label>
                                        <div class="col-md-3 col-sm-3 col-xs-12 form-group">
                                            <span class="fa fa-calendar form-control-feedback left"
                                                  aria-hidden="true"></span>
                                            <input type="date" class="form-control has-feedback-left"
                                                   style="padding-right: 0;" id="publishStart">
                                        </div>
                                        <label class="control-label col-md-1 col-sm-1 col-xs-12">掲載終了&lt=</label>
                                        <div class="col-md-3 col-sm-3 col-xs-12 form-group">
                                            <span class="fa fa-calendar form-control-feedback left"
                                                  aria-hidden="true"></span>
                                            <input path="publishEnd" type="date" class="form-control has-feedback-left"
                                                   style="padding-right: 0;" id="publishEnd">
                                            <span style="color: red" id="checkPublishEnd"></span>
                                        </div>
                                    </div>

                                    <div class="col-md-1 text-right" style="padding-right: 15px">
                                        <button type="submit" class="btn btn-round btn-info "
                                                style="width: 100px;"><span
                                                class="glyphicon glyphicon-search" aria-hidden="true"></span>検索
                                        </button>
                                    </div>
                                </form>

                                <div class="table-responsive">
                                    <table id="teamListTable" class="table table-striped jambo_table bulk_action">
                                        <thead>
                                        <tr class="headings">
                                            <th class="column-title" style="width: 5%;">カテゴリ</th>
                                            <th class="column-title" style="width: 20%;">タイトル</th>
                                            <th class="column-title" style="width: 5%;">日付</th>
                                            <th class="column-title" style="width: 25%;">詳細</th>
                                            <th class="column-title" style="width: 5%;">TOP表示</th>
                                            <th class="column-title" style="width: 5%;">掲載開始</th>
                                            <th class="column-title" style="width: 5%;">掲載終了</th>
                                            <th class="column-title" style="width: 5%;"></th>
                                            <th class="column-title" style="width: 5%;"></th>
                                            <th class="column-title" style="width: 5%;"></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                    <div class="col-md-9 col-sm-9 col-xs-12"></div>
                                </div>
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
<div class="modal fade delete-team-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel2">Delete</h4>
            </div>
            <div class="modal-body">
                <h4>この情報を削除しますか？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
                <button type="button" class="btn btn-primary" onclick="confirmDeleteClick()">削除</button>
            </div>

        </div>
    </div>
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
<!-- DateJS -->
<script src="/static/admin/vendors/DateJS/build/date.js"></script>
<!-- JQVMap -->
<script src="/static/admin/vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="/static/admin/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="/static/admin/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="/static/admin/vendors/moment/min/moment.min.js"></script>
<script src="/static/admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- iCheck -->
<script src="/static/admin/vendors/iCheck/icheck.min.js"></script>
<!-- Datatables -->
<script src="/static/admin/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/admin/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="/static/admin/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="/static/admin/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="/static/admin/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="/static/admin/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="/static/admin/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="/static/admin/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="/static/admin/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="/static/admin/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="/static/admin/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="/static/admin/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="/static/admin/vendors/jszip/dist/jszip.min.js"></script>
<script src="/static/admin/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="/static/admin/vendors/pdfmake/build/vfs_fonts.js"></script>
<!-- PNotify -->
<script src="/static/admin/vendors/pnotify/dist/pnotify.js"></script>
<script src="/static/admin/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="/static/admin/vendors/pnotify/dist/pnotify.nonblock.js"></script>

<!-- Custom Theme Scripts -->
<script src="/static/admin/build/js/custom.min.js"></script>

<script>

    var $userForm = $("#userForm");
    $userForm.validate({
        submitHandler: function (form) {
            searchData();
        },
        errorClass: "validatorError",
        rules: {
            sortScore: {
                digits: true,
                required: true,
                maxlength: 4
            }
        }
    });

    var datatable = $('#teamListTable').DataTable({
        dom: 'lrtip',
        processing: true,
        serverSide: true,
        ajax: {
            url: '/admin/team/list/',
            type: 'POST',
            data: function (data) {
                data.type = $('#type').val();
                data.date = $('#date').val();
                data.sortScore = $('#sortScore').val();
                data.publishStart = $('#publishStart').val();
                data.publishEnd = $('#publishEnd').val();
                return JSON.stringify(data);
            },
            contentType: "application/json;charset=UTF-8",
            dataType: "json"
        },
        order: [[2, 'desc']],
        columns: [
            {
                data: null,
                render: function (data, type, full, meta) {
                    if (full.type == 1) {
                        return '<button type="button" class="btn btn-primary" style="width: 80px;">EVENT</button>';
                    }
                    if (full.type == 2) {
                        return '<button type="button" class="btn btn-danger" style="width: 80px;">MOVEUP</button>';
                    }
                    if (full.type == 3) {
                        return '<button type="button" class="btn btn-success" style="width: 80px;">TEAM</button>';
                    }
                    if (full.type == 0) {
                        return '<button type="button" class="btn btn-primary" style="width: 80px;">不明</button>';
                    }
                    return "";
                },
                name: "type"
            },
            {data: "title", name: "title"},
            {
                data: null,
                render: function (data, type, full, meta) {
                    return '<div>' + formatDate(full.date) + '</div>';
                },
                name: "date"
            },
            {data: "excerpt", name: "excerpt"},
            {data: "sortScore", name: "sort_score"},
            {
                data: null,
                render: function (data, type, full, meta) {
                    return '<div>' + formatDate(full.publishStart) + '</div>';
                },
                name: "publish_start"
            },
            {
                data: null,
                render: function (data, type, full, meta) {
                    return '<div>' + formatDate(full.publishEnd) + '</div>';
                },
                name: "publish_end"
            },
            {
                data: null,
                render: function (data, type, full, meta) {
                    if (full.type == 1 && full.entryType == 0) {
                        return '<a class="btn btn-primary" style="font-size: inherit;" href="javascript:void(0)" onclick=gotoRegistEntryMail("' + full.id + '","' + full.type + '")>応募</a>';
                    } else if (full.type == 1 && full.entryType == 1) {
                        return '<a class="btn btn-primary buttonDisabled" style="font-size: inherit; opacity: .65;" href="javascript:void(0)" onclick="(' + full.id + ',' + full.type + ')">応募</a>';
                    }
                    if (full.type == 2 && full.entryType == 0) {
                        return '<a class="btn btn-primary" style="font-size: inherit;" href="javascript:void(0)" onclick=gotoRegistEntryMail("' + full.id + '","' + full.type + '")>応募</a>';
                    } else if (full.type == 2 && full.entryType == 1) {
                        return '<a class="btn btn-primary buttonDisabled" style="font-size: inherit; opacity: .65;" href="javascript:void(0)" onclick="(' + full.id + ',' + full.type + ')">応募</a>';
                    }
                    if (full.type == 3) {

                    }
                    return "";
                },
                // name: "type"
            },
            {
                data: null,
                orderable: false,
                render: function (data, type, full, meta) {
                    return '<a class="btn btn-primary" style="font-size: inherit;" href="javascript:void(0)" onclick="gotoUpdate(' + full.id + ')">詳細</a>';
                }
            },
            {
                data: null,
                orderable: false,
                render: function (data, type, full, meta) {
                    return '<button class="btn btn-danger" style="font-size: inherit;" onclick="gotoDelete(' + full.id + ')">削除</button>';
                }
            }
        ],
        columnDefs: [
            {
                targets: [7, 8],
                searchable: false,
                orderable: false
            }
        ],
        language: {url: "/static/admin/build/json/japanese.json"}
    });

    var currDeleteTeamId = 0;

    function searchData() {
        datatable.ajax.reload();
    }

    function gotoDelete(id) {
        currDeleteTeamId = id;
        $('.delete-team-modal').modal("show");
    }

    function gotoUpdate(id) {
        $('#teamLoading').show();
        window.location.href = '${pageContext.request.contextPath}/admin/team/edit/' + id + '/';
    }

    function gotoRegistEntryMail(id, type) {
        $('#teamLoading').show();
        window.location.href = '${pageContext.request.contextPath}/admin/entrymail/regist/' + id + '/' + type + '/';
    }

    function gotoRegist() {
        $('#teamLoading').show();
        window.location.href = '${pageContext.request.contextPath}/admin/team/regist/';
    }

    function confirmDeleteClick() {
        $('.delete-team-modal').modal("hide");
        $('#teamLoading').show();
        var form = $("<form></form>");
        form.attr('action', '${pageContext.request.contextPath}/admin/team/delete/');
        form.attr('method', 'post');
        var input1 = $("<input type='hidden' name='id'/>");
        input1.attr('value', currDeleteTeamId);
        form.append(input1);
        form.appendTo("body");
        form.css('display', 'none');
        form.submit();
    }

    function formatDate(timestamp) {
        var rtn = "";
        if (timestamp == null) {
            return rtn;
        } else {
            var date = new Date(timestamp);
            var year = date.getFullYear();
            var month = "0" + (date.getMonth() + 1);
            var day = "0" + date.getDate();
            var hour = "0" + date.getHours();
            var minute = "0" + date.getMinutes();
            if (year == "1970" && month == "01" && day == "00") {
            } else {
                rtn = year + "-" + month.substring(month.length - 2, month.length) + "-" + day.substring(day.length - 2, day.length) + " " + hour.substring(hour.length - 2, hour.length) + ":" + minute.substring(minute.length - 2, minute.length);
            }
            return rtn;
        }
    }

    $("#publishEnd").change(function () {
        var startDate = $('#publishStart').val();
        var publishEnd = $('#publishEnd').val();
        var date = (new Date(Date.parse(publishEnd.replace("-", "/"))) > new Date(Date.parse(startDate.replace("-", "/")))) || (new Date(Date.parse(publishEnd.replace("-", "/"))).equals(new Date(Date.parse(startDate.replace("-", "/")))));
        debugger;
        if (startDate.length != 0 && publishEnd.length != 0) {
            if (date) {
                document.getElementById("checkPublishEnd").innerHTML = "";
            } else {
                document.getElementById("checkPublishEnd").innerHTML = "掲載開始日以上の値を入力してください。";
            }
        } else {
            document.getElementById("checkPublishEnd").innerHTML = "";
        }
    })
    $("#publishStart").change(function () {
        var startDate = $('#publishStart').val();
        var publishEnd = $('#publishEnd').val();
        var date = (new Date(Date.parse(publishEnd.replace("-", "/"))) > new Date(Date.parse(startDate.replace("-", "/")))) || (new Date(Date.parse(publishEnd.replace("-", "/"))).equals(new Date(Date.parse(startDate.replace("-", "/")))));
        debugger;
        if (publishEnd.length != 0) {
            if (date) {
                document.getElementById("checkPublishEnd").innerHTML = "";
            } else {
                document.getElementById("checkPublishEnd").innerHTML = "掲載開始日以上の値を入力してください。";
            }
        }
    })

    var errorCode = ${errorCode};

    if (errorCode == 1) {
        new PNotify({
            title: 'エラーが発生しました',
            text: 'データの更新に失敗しました。',
            type: 'error',
            styling: 'bootstrap3'
        });
    }
</script>

</body>
</html>
