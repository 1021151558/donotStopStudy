package com.zjut.noStopStudy.security.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.zjut.noStopStudy.VO.AjaxResult;
import com.zjut.noStopStudy.enums.ApiResponseEnum;
import com.zjut.noStopStudy.security.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 自定义token拦截器
 *
 * @author qiaokun
 * @date 2018/08/11
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截器跨域请求设置

        if (request.getMethod().equals("OPTIONS")) {
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

       System.out.println(request.getRequestURI());
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("Authorization").substring(7);
        //token不存在
        System.out.println("token:" + token);
        if (null != token) {
            //验证token是否正确
            boolean result = JwtUtil.verify(token);
//            System.out.println("result:"+result);
            if (result) {
                return true;
            }
        }
        AjaxResult apiResponse = new AjaxResult(ApiResponseEnum.AUTH_ERROR.getErrCode(), ApiResponseEnum.AUTH_ERROR.getErrMsg());
        responseMessage(response, response.getWriter(), apiResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 返回信息给客户端
     *
     * @param response
     * @param out
     * @param ajaxResult
     */
    private void responseMessage(HttpServletResponse response, PrintWriter out, AjaxResult ajaxResult) {
        response.setContentType("application/json; charset=utf-8");
        out.print(JSONObject.toJSONString(ajaxResult));
        out.flush();
        out.close();
    }
}
