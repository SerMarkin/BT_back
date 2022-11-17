package com.bartrip.main.configurations;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletResponse resp = (HttpServletResponse) response;

    if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
      resp.setStatus(HttpServletResponse.SC_ACCEPTED);
      return;
    }

    // pass the request along the filter chain
    chain.doFilter(request, resp);
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub

  }
}