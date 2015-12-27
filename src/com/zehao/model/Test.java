package com.zehao.model;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */

public class Test implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String content;

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** full constructor */
	public Test(String content) {
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", content=" + content + "]";
	}

}