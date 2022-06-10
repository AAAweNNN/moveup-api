package jp.co.vermore.common.mvc;

/**
 * ActionInterceptor
 * Created by xieyoujun.
 * <p>
 * DateTime: 2018/03/07 0:41
 * Copyright: sLab, Corp
 */

import jp.co.vermore.common.Constant;
import jp.co.vermore.controller.HomeController;
import jp.co.vermore.entity.AdminRole;
import jp.co.vermore.entity.AdminUser;
import jp.co.vermore.form.admin.AdminUserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Pattern;

@SuppressWarnings("ConstantConditions")
@ComponentScan
public class ActionInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    private static final String LOGIN_PATH = "/admin/login/";


    long sysmili = 0;


    private String[] urlList = {"/admin/",
            "/admin/review/list/",
            "/admin/review/edit/.*/",
            "/admin/review/license/",
            "/admin/review/profile/",
            "/admin/review/car/",
            "/admin/review/inspection/",
            "/admin/review/insurance/",
            "/admin/review/comment/",
            "/admin/member/list/",
            "/admin/member/edit/.*/",
            "/admin/member/restrictions/",
            "/admin/member/comment/",
            "/admin/review/view/.*/",
            "/admin/review/view/.*/",
            "/admin/review/view/.*/",
            "/admin/review/view/.*/",
            "/admin/carinfo/edit/.*/",
            "/admin/member/report/.*/",
            "admin/coupon/history/.*/",
            "/admin/member/toll/.*/",
            "/admin/member/toll/detail/.*/",
            "/admin/share/list/",
            "/admin/share/history/.*/",  // history  14
            "/admin/member/useday/add/", // history  14
            "/admin/share/detail/.*/",
            "/admin/share/chat/.*/",
            "/admin/carinfo/calendar/.*/",
            "/admin/carinfo/injury/.*/",
            "/admin/review/view/.*/",
            "/admin/coupon/list/",
            "/admin/coupon/detail/.*/",
            "/admin/coupon/regist/",
            "/admin/coupon/save/",
            "/admin/coupon/delete/",
            "/admin/coupon/gencode/",
            "",
            "",
            "/admin/infeed/list/",
            "/admin/infeed/edit/.*/",
            "/admin/infeed/regist/",
            "/admin/infeed/save/",
            "/admin/infeed/delete/"};


    private int[] urlActionList = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 15, 16, 17, 18, 19, 20, 21, 21, 21, 21, 21, 22, 23, 24, 25, 25, 25, 25};


    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        sysmili = System.currentTimeMillis();

        String uid = getUid(request);
        ActionInterceptor.logger.info("START:[" + uid + "]" + request.getServletPath());

        // TODO：localのみ適用する
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Spring3CorsFilter filter = handlerMethod.getMethod().getAnnotation(Spring3CorsFilter.class);
//            if (filter != null ) {
            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Allow-Origin", "http://localhost:9000");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with, uid, sid");
            response.setHeader("Content-Type", "application/json");
//            }
        }


        // check admin user and role
        if (request.getServletPath().startsWith("/admin") && !request.getServletPath().equals(ActionInterceptor.LOGIN_PATH)) {
            HttpSession session = request.getSession();
            if (session.getAttribute(Constant.ADMIN_SESSION.USER) != null) {
                if (checkRole(request, (AdminUserForm) session.getAttribute(Constant.ADMIN_SESSION.USER))) {
                    request.setAttribute("adminUser", session.getAttribute(Constant.ADMIN_SESSION.USER));
                    return Boolean.TRUE;
                }
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return Boolean.FALSE;
            } else {
                response.sendRedirect(request.getContextPath() + ActionInterceptor.LOGIN_PATH);
                return Boolean.FALSE;
            }
        }


        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    // ③リクエスト処理の完了後に呼ばれる
    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        String uid = getUid(request);
        ActionInterceptor.logger.info("END:[" + uid + "]" + request.getServletPath() + " score:" + (System.currentTimeMillis() - sysmili));
    }


    private boolean checkRole(HttpServletRequest request, AdminUserForm adminUserForm) {
        String path = request.getServletPath();
//        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
//        AdminAuthService adminAuthService = (AdminAuthService)factory.getBean("adminAuthService");
        AdminUser adminUser = adminUserForm.getUser();
        List<AdminRole> roleList = adminUserForm.getRoleList();
        if (adminUser.getRole() == 1) {
            return true;
        }
        for (int i = 0; i < urlList.length; i++) {
            if (Pattern.matches(urlList[i], path)) {
                int urlAction = urlActionList[i];
//                List<AdminRole> roleList = adminAuthService.getAdminRoleByType(adminUser.getRole().byteValue());
                for (AdminRole role : roleList) {
                    if (role.getAction() == urlAction && role.getPrivilege() != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private String getUid(HttpServletRequest request) {
        String uid = request.getHeader(Constant.SESSION.UUID);
        if (uid == null || uid.isEmpty()) {
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals(Constant.SESSION.UUID)) uid = c.getValue();
                }
            }
        }

        return (uid == null) ? Constant.EMPTY_STRING : uid;
    }


}
