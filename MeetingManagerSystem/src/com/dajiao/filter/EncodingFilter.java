package com.dajiao.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.dajiao.model.Person;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, 
		urlPatterns = { 
				"/EncodingFilter", 
				"/*"
		})
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		request.setCharacterEncoding("utf-8");
		
		HttpServletRequest res = (HttpServletRequest)request;
		Person person = (Person)res.getSession().getAttribute("person");
		if(person != null){
			request.setAttribute("showUserName", person.getaccount());	
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
