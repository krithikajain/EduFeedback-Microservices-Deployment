package swe642.hw3.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe642.hw3.SpringBoot.model.StudentSurvey;
import swe642.hw3.SpringBoot.repository.StudentSurveyRepository;

/**
 * The Class UserService. The service class in the MVC architecture. The
 * controller calls the service to perform the back-end operations.
 * 
 */
@Service
public class StudentService {

	 @Autowired
	    private StudentSurveyRepository repository;

	
//	@Autowired
//	private UserInfoRepository userRepository;
//	
	
	/*
	 * @Autowired private StudentSurveyRepository studentRepository;
	 * 
	 * 
	 * @Transactional public void saveStudentAndSurvey(StudentSurvey student) { try
	 * {System.out.println("StudentService: save student info method " + student);
	 * student = studentRepository.save(student); } catch(Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	 public StudentSurvey saveStudentSurvey(StudentSurvey studentSurvey) {
	        return repository.save(studentSurvey);
	    }

	    public List<StudentSurvey> getAllStudentSurveys() {
	        return repository.findAll();
	    }

	    public Optional<StudentSurvey> getStudentSurveyById(Integer id) {
	        return repository.findById(id);
	    }

	    public void deleteStudentSurveyById(Integer id) {
	        repository.deleteById(id);
	    }

	    public void deleteAllStudentSurveys() {
	        repository.deleteAll();
	    }

	    public StudentSurvey updateStudentSurvey(Integer id, StudentSurvey studentSurvey) {
	        return repository.findById(id)
	                .map(existingSurvey -> {
	                    if (studentSurvey.getFirstName() != null) existingSurvey.setFirstName(studentSurvey.getFirstName());
	                    if (studentSurvey.getLastName() != null) existingSurvey.setLastName(studentSurvey.getLastName());
	                    if (studentSurvey.getStreetAddress() != null) existingSurvey.setStreetAddress(studentSurvey.getStreetAddress());
	                    if (studentSurvey.getCity() != null) existingSurvey.setCity(studentSurvey.getCity());
	                    if (studentSurvey.getState() != null) existingSurvey.setState(studentSurvey.getState());
	                    if (studentSurvey.getZip() != null) existingSurvey.setZip(studentSurvey.getZip());
	                    if (studentSurvey.getTelephoneNumber() != null) existingSurvey.setTelephoneNumber(studentSurvey.getTelephoneNumber());
	                    if (studentSurvey.getEmail() != null) existingSurvey.setEmail(studentSurvey.getEmail());
	                    if (studentSurvey.getDateOfSurvey() != null) existingSurvey.setDateOfSurvey(studentSurvey.getDateOfSurvey());
	                    if (studentSurvey.getLikedMost() != null) existingSurvey.setLikedMost(studentSurvey.getLikedMost());
	                    if (studentSurvey.getInterestedIn() != null) existingSurvey.setInterestedIn(studentSurvey.getInterestedIn());
	                    if (studentSurvey.getLikelihoodRecommendation() != null) existingSurvey.setLikelihoodRecommendation(studentSurvey.getLikelihoodRecommendation());
	                    return repository.save(existingSurvey);
	                }).orElseThrow(() -> new RuntimeException("Survey not found!"));
	    }
	
	

		/*
		 * public String listUser() {
		 * System.out.println("UserService: List user method"); List<UserInfo> userList
		 * = new ArrayList<>(); try { Iterable<UserInfo> allUsers =
		 * userRepository.findAll(); Iterator<UserInfo> itr = allUsers.iterator(); while
		 * (itr.hasNext()) { userList.add(itr.next()); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } return
		 * userListToJson(userList);
		 * 
		 * }
		 * 
		 * static String userListToJson(List<UserInfo> userList) {
		 * 
		 * System.out.println("User Service: user list to json."); Gson gson = new
		 * GsonBuilder().setPrettyPrinting().create(); String json =
		 * gson.toJson(userList); System.out.println(json); return json; }
		 */
}
