package com.nandha.wiki.wikiminer.entities;

import java.time.LocalDate;

/**
 *
 *
 * @author Nandhakumar Subramanian
 * 
 * @version 0.0.2
 *
 * @since 9 Apr 2022
 **/

public class People {

	private String name;
	private String description;
	private String gender;
	private String occupation;
	private String countryOfCitizenship;
	private LocalDate birthDate;
	private String fatherName;
	private String motherName;
	private int age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the countryOfCitizenship
	 */
	public String getCountryOfCitizenship() {
		return countryOfCitizenship;
	}

	/**
	 * @param countryOfCitizenship the countryOfCitizenship to set
	 */
	public void setCountryOfCitizenship(String countryOfCitizenship) {
		this.countryOfCitizenship = countryOfCitizenship;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", description=" + description + ", gender=" + gender + ", occupation="
				+ occupation + ", countryOfCitizenship=" + countryOfCitizenship + ", birthDate=" + birthDate
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + ", age=" + age + "]";
	}

}
