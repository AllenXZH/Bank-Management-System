/**
 * 
 */
package com.springmvc.entities.POJO;

import java.util.ArrayList;

/**
 * @author Nanda
 *
 */
public class WeatherInfo {
	
	private String id;
	private String name;
	private String cod;
	private String base;
	private String description;
	Weather weather[];
	
	/**
	 * @return the weather
	 */
	public Weather[] getWeather() {
		return weather;
	}
	/**
	 * @param weather the weather to set
	 */
	public void setWeather(Weather[] weather) {
		this.weather = weather;
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
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
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	/**
	 * @return the base
	 */
	public String getBase() {
		return base;
	}
	/**
	 * @param base the base to set
	 */
	public void setBase(String base) {
		this.base = base;
	}
	
	
	
	
	
	public String toString() {
		return "[id=" + "=" + id + ", name=" + name + ", cod=" + cod + ", base=" + base + "]";
	}
	

}
