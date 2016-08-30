/**
 * 
 */
package com.cwitter;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Saurabh
 *
 */

@Controller
public class CwitterController {

		@RequestMapping(value="/index", method = RequestMethod.GET )
		public ModelAndView show()
		{
			ModelAndView modelct = new ModelAndView("login");
			return modelct;
		}

		
		// called when post with /login
		@RequestMapping(value="/login", method = RequestMethod.POST )//@RequestParam("userid")String userid,@RequestParam("password")String password
		public ModelAndView login()
		{
			ModelAndView modelct = new ModelAndView("login");
			return modelct;
		}
		
		
		@RequestMapping(value="/signup", method = RequestMethod.POST )
		public ModelAndView singup()
		{
			ModelAndView modelct = new ModelAndView("login");
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
		
		@RequestMapping(value="/timeline", method = RequestMethod.POST )
		public ModelAndView addCweet()
		{
			ModelAndView modelct = new ModelAndView("CweetSuccess");
			return modelct;
		}

		@RequestMapping(value="/logout", method = RequestMethod.POST )
		public ModelAndView login(HttpSession session, Model model)
		{
			ModelAndView models = new ModelAndView("login");
			return models;
		}


}

