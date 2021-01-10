package com.cls.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cls.dao.TelDAO;
import com.cls.dao.TelDAOImplementation;
import com.cls.model.Tel;

@WebServlet("/TelephoneController")
public class TelController extends HttpServlet {
	
	private TelDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_TELEPHONE = "/listTelephone.jsp";
	public static final String INSERT_OR_EDIT = "/tel.jsp";
       
    public TelController() {
    	dao = new TelDAOImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = lIST_TELEPHONE;
			int telId = Integer.parseInt( request.getParameter("telId") );
			dao.deleteTel(telId);
			request.setAttribute("tels", dao.getAllTels() );
		}
		else if( action.equalsIgnoreCase( "edit" ) ) {
			forward = INSERT_OR_EDIT;
			int telId = Integer.parseInt( request.getParameter("telId") );
			Tel tel = dao.getTelById(telId);
			request.setAttribute("tel", tel);
		}
		else if( action.equalsIgnoreCase( "insert" ) ) {
			forward = INSERT_OR_EDIT;
		}
		else {
			forward = lIST_TELEPHONE;
			request.setAttribute("tels", dao.getAllTels() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Tel tel = new Tel();
		tel.setFirstName( request.getParameter( "firstName" ) );
		tel.setLastName( request.getParameter( "lastName" ) );
		tel.setAddress( request.getParameter( "address" ) );
		tel.setNum(Integer.parseInt( request.getParameter( "num" ) ) );
		//tel.setNum(10);
		String telId = request.getParameter("telId");
		
		if( telId == null || telId.isEmpty() ) 
			dao.addTel(tel);
		else {
			tel.setTelId( Integer.parseInt(telId) );
			dao.updateTel(tel);
		}
		
		RequestDispatcher view = request.getRequestDispatcher( lIST_TELEPHONE );
		request.setAttribute("tels", dao.getAllTels());
		view.forward(request, response);
	}
}
