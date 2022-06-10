<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${pageContext.request.contextPath}/admin/" class="site_title"><span
                    style="color: #F72323">Japan</span><span>MoveUpWest</span></a>
        </div>
        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">

            <div class="profile_pic">
                <img src="/static/img/img.jpg" alt="..." class="img-circle profile_img">
            </div>

            <div class="profile_info">
                <span>ようこそう,</span>
                <h2>岡山 太郎</h2>
            </div>

        </div>
        <!-- /menu profile quick info -->
        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <ul class="nav side-menu">
                    <li><a href="${pageContext.request.contextPath}/admin/">Dashboard</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/user/list/">ユーザー管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/role/list/">顧客情報管理</a></li>
                    <li>
                        <a>カテゴリ管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${pageContext.request.contextPath}/admin/shop/list/">協力店</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/corporateinfo/list/">コーポレートインフォ</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/admin/place/list/">プレイス</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/recruit/list/">求人</a></li>
                        </ul>
                    </li>

                    <li>
                        <a>コンテンツ管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${pageContext.request.contextPath}/admin/top/">TOP</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/news/list/">ニュース</a></li>
                            <%-- 2022.4.25追加内容　by awen--%>
                            <li><a href="${pageContext.request.contextPath}/admin/team/list/">Slab2022</a></li>

                            <%--20210317楊追加--%>
                            <li><a href="${pageContext.request.contextPath}/admin/report/list/">レポート</a></li>

                            <li><a href="${pageContext.request.contextPath}/admin/event/list/">イベント</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/entrymail/list/">応募メール</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/entry/list/">応募結果</a></li>
                            <%--<li><a href="${pageContext.request.contextPath}/admin/rise/list/">RISE(保留)</a></li>--%>
                            <li><a href="${pageContext.request.contextPath}/admin/freepaper/list/">フリーペーパ</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/tv/list/">TV</a></li>
                            <li><a>スタジオ <span class="fa fa-chevron-down"></span>
                                <ul class="nav child_menu">
                                    <li><a href="${pageContext.request.contextPath}/admin/studioNews/list/">NEWS</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/admin/studioGallery/">GALLERY</a>
                                    </li>
                                </ul>
                            </a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/team2020/list/">TEAM2020</a></li>


                            <li><a href="${pageContext.request.contextPath}/admin/inquire/list/">お問い合わせ</a></li>
                            <%--<li><a href="${pageContext.request.contextPath}/admin/">(仮)STUDIO</a></li>--%>
                            <%--<li><a href="${pageContext.request.contextPath}/admin/">(仮)TEAM2020</a></li>--%>

                        </ul>
                    </li>
                    <li>
                        <a>GOODS管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="${pageContext.request.contextPath}/admin/goods/list/">GOODS管理</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/goods/purchase/list/">購入履歴</a></li>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/admin/notify/list/">通知管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/coin/list/">ポイント</a></li>
                    <%--<li><a href="${pageContext.request.contextPath}/admin/">(仮)データ分析</a></li>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/admin/quote/list/">(仮)請求情報</a></li>--%>
                    <li><a href="${pageContext.request.contextPath}/admin/settlement/list/">請求情報</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/document/list/">各種書類</a></li>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

    </div>
</div>



