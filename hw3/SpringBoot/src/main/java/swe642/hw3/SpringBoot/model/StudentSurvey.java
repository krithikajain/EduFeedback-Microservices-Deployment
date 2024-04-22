package swe642.hw3.SpringBoot.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_survey")
public class StudentSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Integer surveyId;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "street_address", nullable = false, length = 100)
    private String streetAddress;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "zip", nullable = false, length = 10)
    private String zip;

    @Column(name = "telephone_number", nullable = false, length = 20)
    private String telephoneNumber;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "date_of_survey", nullable = false)
    private Date dateOfSurvey;

    @Column(name = "liked_most", nullable = false, length = 50)
    private String likedMost;

    @Column(name = "interested_in", nullable = false, length = 50)
    private String interestedIn;

    @Column(name = "likelihood_recommendation", nullable = false, length = 20)
    private String likelihoodRecommendation;

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfSurvey() {
		return dateOfSurvey;
	}

	public void setDateOfSurvey(Date dateOfSurvey) {
		this.dateOfSurvey = dateOfSurvey;
	}

	public String getLikedMost() {
		return likedMost;
	}

	public void setLikedMost(String likedMost) {
		this.likedMost = likedMost;
	}

	public String getInterestedIn() {
		return interestedIn;
	}

	public void setInterestedIn(String interestedIn) {
		this.interestedIn = interestedIn;
	}

	public String getLikelihoodRecommendation() {
		return likelihoodRecommendation;
	}

	public void setLikelihoodRecommendation(String likelihoodRecommendation) {
		this.likelihoodRecommendation = likelihoodRecommendation;
	}

   
}
