/**
 * 
 */
package com.cwitter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Saurabh
 *
 */

@Controller
@SessionAttributes("userid")
public class CwitterController {

	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/cwitter";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "matrix24";

	   Connection conn = null;
	   Statement stmt = null;
	   
	   
	
		@RequestMapping(value="/index", method = RequestMethod.GET )
		public ModelAndView show()
		{
			ModelAndView modelct = new ModelAndView("login");
			return modelct;
		}

		
		// called when post with /login
		@RequestMapping(value="/login", method = RequestMethod.POST )//@RequestParam("userid")String userid,@RequestParam("password")String password
		public ModelAndView login(@RequestParam("userid")String useridd,@RequestParam("password")String passwordd,HttpSession sessionObj) throws Exception
		{
			
			      // Register JDBC driver and connect
			      Class.forName("com.mysql.jdbc.Driver");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      stmt = conn.createStatement();

			      String sql;
			      sql = "SELECT name,userid,email,password FROM user where userid='"+useridd+"'";
			      ResultSet rs = stmt.executeQuery(sql);
			      String uid=null;
			      String pas=null;
			      String eml=null;
			      String name=null;
			      if(rs.isBeforeFirst())
			      {
			    	  while(rs.next())
			    	  {
			    		  name=rs.getString(1);
			    		  uid=rs.getString(2);
			    		  eml=rs.getString(3);
			    		  pas=rs.getString(4);
			    	  }
			      }
			      
			      sessionObj.setAttribute("userid", uid);  
				ModelAndView modelct = new ModelAndView("timeline");
					return modelct;

		}
		
		
		@RequestMapping(value="/signup", method = RequestMethod.POST )
		public ModelAndView signup(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("userid")String useridd,@RequestParam("password")String passwordd) throws SQLException,Exception
		{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();

		      String sql;
		      sql = "insert into ";
		      ResultSet rs = stmt.executeQuery(sql);

			ModelAndView modelct = new ModelAndView("login");
			return modelct;
		}

		@RequestMapping(value="/timeline", method = RequestMethod.POST )
		public ModelAndView addCweet(@RequestParam("text")String cweet,HttpServletRequest req)
		{
			HttpSession session=req.getSession();
			String userid=(String)session.getAttribute("userid");
			
			Date date= new Date();
	        String timedate=(new Timestamp(date.getTime())).toString();
	        
	        
			// Write database code in CweetSuccess jsp page
			// CweetSuccess Adds cweet text in database and shows 
			// Cweet added Successfully and creates form with goto timeline button
			// Action in that form is same action as that of after login page
			// to go to timline so new cweet will be shown
			// db fields userID, cweet_text, current timestamp

			ModelAndView modelct = new ModelAndView("timeline");
			return modelct;
		}

		
		@RequestMapping(value="/logingo", method = RequestMethod.GET )
		public ModelAndView loGo()
		{
			ModelAndView modelct = new ModelAndView("login");
			return modelct;
		}
		
		@RequestMapping(value="/signupgo", method = RequestMethod.GET )
		public ModelAndView siGo()
		{
			ModelAndView modelct = new ModelAndView("signup");
			return modelct;
		}
		
		@RequestMapping(value="/timeline", method = RequestMethod.GET )
		public ModelAndView addCweet()
		{
			ModelAndView modelct = new ModelAndView("timeline");
			return modelct;
		}

		@RequestMapping(value="/logout", method = RequestMethod.POST )
		public ModelAndView login(HttpSession session, Model model)
		{
			ModelAndView models = new ModelAndView("login");
			return models;
		}


}

