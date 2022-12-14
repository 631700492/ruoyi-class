package com.ruoyi.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 认证失败处理类 返回未授权
 * 
 * @author ruoyi
 */
@Component
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable
{
    private static final long serialVersionUID = -8970718410437077606L;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException
    {
        int code = HttpStatus.UNAUTHORIZED;


        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        //创建一个 json 对象，用来存放 http 日志信息
        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.put("uri", requestWrapper.getRequestURI());
        rootNode.put("clientIp", requestWrapper.getRemoteAddr());
        rootNode.set("requestHeaders", mapper.valueToTree(getRequestHeaders(requestWrapper)));
        String method = requestWrapper.getMethod();
        rootNode.put("method", method);
        if (method.equals("GET")) {
            rootNode.set("request", mapper.valueToTree(requestWrapper.getParameterMap()));
        } else {
            JsonNode newNode = mapper.readTree(requestWrapper.getContentAsByteArray());
            rootNode.set("request", newNode);
        }

        rootNode.put("status", responseWrapper.getStatus());
        JsonNode newNode = mapper.readTree(responseWrapper.getContentAsByteArray());
        rootNode.set("response", newNode);

        responseWrapper.copyBodyToResponse();

        rootNode.set("responseHeaders", mapper.valueToTree(getResponsetHeaders(responseWrapper)));
        log.info("请求信息 ===》");
        log.info(rootNode.toString());

        String msg = StringUtils.format("请求访问：{}，认证失败，无法访问系统资源1", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
    }

    private Map<String, Object> getRequestHeaders(HttpServletRequest request) {
        Map<String, Object> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        return headers;

    }

    private Map<String, Object> getResponsetHeaders(ContentCachingResponseWrapper response) {
        Map<String, Object> headers = new HashMap<>();
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            headers.put(headerName, response.getHeader(headerName));
        }
        return headers;
    }
}
