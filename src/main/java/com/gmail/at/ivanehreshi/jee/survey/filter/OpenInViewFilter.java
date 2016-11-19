package com.gmail.at.ivanehreshi.jee.survey.filter;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.transaction.NotSupportedException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.IOException;

@WebFilter(urlPatterns = {"*"})
public class OpenInViewFilter implements Filter{
    @Resource
    private UserTransaction ut;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
            ut.begin();
            chain.doFilter(request, response);
        }catch(NotSupportedException | SystemException | IOException e){
            throw new ServletException("", e);
        } finally {
            try {
                if(ut.getStatus()!= Status.STATUS_MARKED_ROLLBACK){
                    ut.commit();
                }
            } catch (Exception e) {
                throw new ServletException("", e);
            }
        }
    }

    @Override
    public void destroy() {

    }

}
