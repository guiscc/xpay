package com.xpay.admin.bank.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xpay.admin.common.exception.ErrorCodeException;
import com.xpay.admin.common.exception.HtmlException;
import com.xpay.admin.common.exception.XpayAdminException;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;


/**
 * @author Tandong
 * 
 */
public class ExceptionHandlerResolver extends ExceptionHandlerExceptionResolver {

    @Autowired
    private ExceptionResolver propertiesMessageResolver;

    private static String SYS_ERROR_CODE = "551";

    private String defaultErrorView;

    private Map<String, String> exceptionMappings;

    public Map<String, String> getExceptionMappings() {
        return exceptionMappings;
    }

    public void setExceptionMappings(Map<String, String> exceptionMappings) {
        this.exceptionMappings = exceptionMappings;
    }

    public String getDefaultErrorView() {
        return defaultErrorView;
    }

    public void setDefaultErrorView(String defaultErrorView) {
        this.defaultErrorView = defaultErrorView;
    }

    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {

        // 记录异常日志
        if (exception instanceof XpayAdminException || exception instanceof ErrorCodeException || exception instanceof HtmlException) {
            logger.error(propertiesMessageResolver.getMessage(((XpayAdminException) exception).getErrorCode(), Locale.CHINA, null));
            logger.error(SYS_ERROR_CODE, exception);
        } else {
            logger.error(SYS_ERROR_CODE, exception);
        }
        
        if (handlerMethod == null) {
            return null;
        }

        Method method = handlerMethod.getMethod();

        if (method == null) {
            return null;
        }

        ModelAndView returnValue = super.doResolveHandlerMethodException(request, response, handlerMethod, exception);

        ResponseBody responseBodyAnn = AnnotationUtils.findAnnotation(method, ResponseBody.class);
        if (responseBodyAnn != null) {
            try {
                ResponseStatus responseStatusAnn = AnnotationUtils.findAnnotation(method, ResponseStatus.class);
                if (responseStatusAnn != null) {
                    HttpStatus responseStatus = responseStatusAnn.value();
                    String reason = responseStatusAnn.reason();
                    if (!StringUtils.hasText(reason)) {
                        response.setStatus(responseStatus.value());
                    } else {
                        try {
                            response.sendError(responseStatus.value(), reason);
                        } catch (IOException e) {
                        }
                    }
                }

                return handleResponseBody(returnValue, request, response, exception);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (null == returnValue) {
            returnValue = new ModelAndView();
        }
        if (returnValue.getViewName() == null) {
            if (exception instanceof XpayAdminException) {
                XpayAdminException appException = (XpayAdminException) exception;
                returnValue.addObject("errorCode", appException.getErrorCode());
                returnValue.addObject("errorMsg", propertiesMessageResolver.getMessage(appException.getErrorCode(), Locale.CHINA, null));
            } else if (exception instanceof ErrorCodeException) {
                ErrorCodeException errorCodeException = (ErrorCodeException) exception;
                returnValue.addObject("errorCode", errorCodeException.getErrorCode());
                returnValue.addObject("errorMsg", propertiesMessageResolver.getMessage(SYS_ERROR_CODE, Locale.CHINA, null));
            } else if (exception instanceof SystemException) {
                returnValue.addObject("errorCode", SYS_ERROR_CODE);
                returnValue.addObject("errorMsg", propertiesMessageResolver.getMessage(SYS_ERROR_CODE, Locale.CHINA, null));
            } else if (exception instanceof HtmlException) {
                HtmlException htmlException = (HtmlException) exception;
                returnValue.addObject("errorCode", htmlException.getErrorCode());
                returnValue.addObject("errorMsg", htmlException.getMessage());
            } else {
                returnValue.addObject("errorCode", SYS_ERROR_CODE);
                returnValue.addObject("errorMsg", "未知的系统错�?");
            }

            if (null == exceptionMappings) {
                returnValue.setViewName(defaultErrorView);
            } else {
                String viewName = exceptionMappings.get(exception.getClass().getName());
                returnValue.setViewName((null == viewName || "".equals(viewName)) ? defaultErrorView : viewName);
            }
        }

        return returnValue;

    }

    @SuppressWarnings({ "unchecked", "rawtypes", "resource" })
    private ModelAndView handleResponseBody(ModelAndView returnValue, HttpServletRequest request, HttpServletResponse response, Exception exception) throws ServletException, IOException {
        if (null == returnValue) {
            returnValue = new ModelAndView();
        }
        Map value = returnValue.getModelMap();
        if (null == value) {
            value = new HashMap();
        }
        if (exception instanceof XpayAdminException) {
            XpayAdminException appException = (XpayAdminException) exception;
            value.put("errorCode", appException.getErrorCode());
            value.put("errorMsg", propertiesMessageResolver.getMessage(appException.getErrorCode(), Locale.CHINA, null));
        } else if (exception instanceof SystemException) {
            value.put("errorCode", SYS_ERROR_CODE);
            value.put("errorMsg", propertiesMessageResolver.getMessage(SYS_ERROR_CODE, Locale.CHINA, null));
        } else if (exception instanceof HtmlException) {
            HtmlException htmlException = (HtmlException) exception;
            value.put("errorCode", htmlException.getErrorCode());
            value.put("errorMsg", htmlException.getMessage());
        } else {
            value.put("errorCode", SYS_ERROR_CODE);
            value.put("errorMsg", "未知的系统错�?");
            // value.put("errorStack", exception.getStackTrace());
        }
        value.put("success", false);
        HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
        List<MediaType> acceptedMediaTypes = inputMessage.getHeaders().getAccept();
        if (acceptedMediaTypes.isEmpty()) {
            acceptedMediaTypes = Collections.singletonList(MediaType.ALL);
        }
        MediaType.sortByQualityValue(acceptedMediaTypes);
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        Class<?> returnValueType = value.getClass();
        List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
        if (messageConverters != null) {
            for (MediaType acceptedMediaType : acceptedMediaTypes) {
                for (HttpMessageConverter messageConverter : messageConverters) {
                    if (messageConverter.canWrite(returnValueType, acceptedMediaType)) {
                        messageConverter.write(value, acceptedMediaType, outputMessage);
                        return new ModelAndView();
                    }
                }
            }
        }
        if (logger.isWarnEnabled()) {
            logger.warn("Could not find HttpMessageConverter that supports return type [" + returnValueType + "] and " + acceptedMediaTypes);
        }
        return null;
    }

}
