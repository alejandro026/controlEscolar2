/**
 * 
 */
package com.utng.controlescolar2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alejandro
 *En esta clase se identifica wque pude guardar cualquier objeto no importa de cual sea
 */
public class Response<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8489104362012431997L;

	@Getter @Setter
	private String status;
	
	@Getter @Setter
	private String message;
	
	private transient List<T> list=null;
	
	@Getter @Setter
	private int count=0;
	
	@Getter @Setter
	private T data;
	
	public List<T> getList() {
		List<T> tmp=null;
		if (this.list !=null) {
			tmp = new ArrayList<T>(this.list);
		}
		return tmp;
	}
	
	public void setList(List<T> tmp) {
		if (tmp !=null) {
			this.list = new ArrayList<T>(tmp);
		}
	}
	
}
