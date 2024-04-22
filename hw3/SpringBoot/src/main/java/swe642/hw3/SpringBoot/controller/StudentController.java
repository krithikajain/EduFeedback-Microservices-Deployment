package swe642.hw3.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swe642.hw3.SpringBoot.model.StudentSurvey;
import swe642.hw3.SpringBoot.service.StudentService;

/**
 * The Class StudentController.
 *
 */
@RestController
@RequestMapping(produces = "application/json")
public class StudentController {


	 @Autowired
	    private StudentService service;

	 @PostMapping("/Create")
	    public ResponseEntity<StudentSurvey> createStudentSurvey(@RequestBody StudentSurvey studentSurvey) {
	        return new ResponseEntity<>(service.saveStudentSurvey(studentSurvey), HttpStatus.CREATED);
	    }

	 @GetMapping("/List")
	    public List<StudentSurvey> getAllStudentSurveys() {
	        return service.getAllStudentSurveys();
	    }

	
	 @GetMapping("/FindById/{id}")
	    public ResponseEntity<StudentSurvey> getStudentSurveyById(@PathVariable Integer id) {
	        return service.getStudentSurveyById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	 @DeleteMapping("/DeleteAll")
	    public ResponseEntity<Void> deleteAllStudentSurveys() {
	        service.deleteAllStudentSurveys();
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @DeleteMapping("/DeletebyId/{id}")
	    public ResponseEntity<Void> deleteStudentSurveyById(@PathVariable Integer id) {
	        service.deleteStudentSurveyById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @PutMapping("/UpdateById/{id}")
	    public ResponseEntity<StudentSurvey> updateStudentSurvey(@PathVariable Integer id, @RequestBody StudentSurvey studentSurvey) {
	        try {
	            return new ResponseEntity<>(service.updateStudentSurvey(id, studentSurvey), HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


		/*@CrossOrigin
	@RequestMapping(value = { "/", "/survey" }, method = RequestMethod.GET)
	public String userForm() {
		System.out.println("User Form");
		return "survey";
	}

	
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = { "/registerUser" }, method = RequestMethod.POST,
	 * consumes = "application/json") public ResponseEntity saveForm(@RequestBody
	 * UserInfo userInfo) {
	 * 
	 * try {
	 * System.out.println("student controller, saveForm method, userInfo object: " +
	 * userInfo); // calling the save user info method of user service.
	 * userService.saveUserInfo(userInfo); } catch (Exception e) {
	 * System.out.println(e.getMessage()); return new
	 * ResponseEntity<>(HttpStatus.BAD_REQUEST); } return new
	 * ResponseEntity<>(HttpStatus.ACCEPTED); }
	 * 
	 * 
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value = { "/listUser" }, method = RequestMethod.GET, produces
	 * = "application/json") public ResponseEntity<String> listUser() {
	 * 
	 * try {
	 * 
	 * System.out.println("Student Controller, List all users"); return
	 * ResponseEntity.accepted().body(userService.listUser());
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * ResponseEntity.internalServerError().build(); }
	 */

}
