package swe642.hw3.SpringBoot.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller; // Add import statement
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

/**
 * The Class CustomErrorController.
 * 
 * @author Samuel
 */
@Controller // Add this annotation
public class CustomErrorController implements ErrorController {

	/**
	 * Error. Method to handle error cases.
	 *
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping("/error")
	@ResponseBody
	public String error(HttpServletRequest request) {
		return "<h1>Error occurred! Please try again.</h1>";
	}

	/**
	 * Gets the error path.
	 *
	 * @return the error path
	 */
	public String getErrorPath() {
		return "/error";
	}
}
// Mahanth Reddy Esanakula
// Rutvik
// Samuel
// Tirth
