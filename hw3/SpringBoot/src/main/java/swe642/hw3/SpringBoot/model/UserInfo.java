package swe642.hw3.SpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The Class UserInfo.
 * The user model that will be used to persist the data into the MySQL database.
 * 
 */
@Entity
public class UserInfo {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The street address. */
	private String address;

	/** The city. */
	private String city;

	/** The state. */
	private String state;

	/** The zip. */
	private Integer zip;

	/** The tel number. */
	private String telephone;

	/** The email. */
	private String email;

	/** The date survey. */
	private String dos;

	// All above fields are required fields.

	/** The check like campus. */
	private String liked;

	/** The radio university. */
	private String interest;

	/** The likelihood. */
	private String recommendation;

	/** The comments. */
	private String comments;

	/**
	 * Instantiates a new user info.
	 */
	public UserInfo() {

	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", telephone=" + telephone + ", email="
				+ email + ", dos=" + dos + ", liked=" + liked + ", interest=" + interest + ", recommendation="
				+ recommendation + ", comments=" + comments + "]";
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip.
	 *
	 * @return the zip
	 */
	public Integer getZip() {
		return zip;
	}

	/**
	 * Sets the zip.
	 *
	 * @param zip the new zip
	 */
	public void setZip(Integer zip) {
		this.zip = zip;
	}

	/**
	 * Gets the telephone.
	 *
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Sets the telephone.
	 *
	 * @param telephone the new telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the dos.
	 *
	 * @return the dos
	 */
	public String getDos() {
		return dos;
	}

	/**
	 * Sets the dos.
	 *
	 * @param dos the new dos
	 */
	public void setDos(String dos) {
		this.dos = dos;
	}

	/**
	 * Gets the liked.
	 *
	 * @return the liked
	 */
	public String getLiked() {
		return liked;
	}

	/**
	 * Sets the liked.
	 *
	 * @param liked the new liked
	 */
	public void setLiked(String liked) {
		this.liked = liked;
	}

	/**
	 * Gets the interest.
	 *
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}

	/**
	 * Sets the interest.
	 *
	 * @param interest the new interest
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}

	/**
	 * Gets the recommendation.
	 *
	 * @return the recommendation
	 */
	public String getRecommendation() {
		return recommendation;
	}

	/**
	 * Sets the recommendation.
	 *
	 * @param recommendation the new recommendation
	 */
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
}
