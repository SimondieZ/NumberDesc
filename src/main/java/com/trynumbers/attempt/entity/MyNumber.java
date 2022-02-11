package com.trynumbers.attempt.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.IntArrayType;

@Entity
@Table(name = "numbers")
@TypeDefs({
	@TypeDef(name = "int-array", typeClass = IntArrayType.class)
})
public class MyNumber {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private long name;
	
	@Column(name = "roma_notation")
	private String romaNotation;
	
	@Column(name = "binary_notation")
	private String binaryNotation;
	
	@Column(name = "description")
	private String description;
	
	@Type(type = "int-array")
	@Column(name = "divisors", columnDefinition = "integer[]")
	private int[] divisors;
	

	protected MyNumber() {
		super();
	}
	
	private MyNumber(MyNumberBuilder myNumberBuilder) {
		super();
		this.id = myNumberBuilder.id;
		this.name = myNumberBuilder.name;
		this.romaNotation = myNumberBuilder.romaNotation;
		this.binaryNotation = myNumberBuilder.binaryNotation;
		this.description = myNumberBuilder.description;
		this.divisors = myNumberBuilder.divisors;
	}

	public static class MyNumberBuilder {
		private long id;
		private long name;
		private String romaNotation;
		private String binaryNotation;
		private String description;
		private int[] divisors;

		public MyNumberBuilder() {
		}

		public MyNumberBuilder id(long id) {
			this.id = id;
			return this;
		}

		public MyNumberBuilder name(long name) {
			this.name = name;
			return this;
		}

		public MyNumberBuilder romaNotation(String romaNotation) {
			this.romaNotation = romaNotation;
			return this;
		}

		public MyNumberBuilder binaryNotation(String binaryNotation) {
			this.binaryNotation = binaryNotation;
			return this;
		}

		public MyNumberBuilder description(String description) {
			this.description = description;
			return this;
		}

		public MyNumberBuilder divisors(int[] divisors) {
			this.divisors = divisors;
			return this;
		}

		public MyNumber build() {
			MyNumber number = new MyNumber(this);
			return number;
		}

	}
	
	public long getName() {
		return name;
	}

	public void setName(long name) {
		this.name = name;
	}

	public String getRomaNotation() {
		return romaNotation;
	}

	public void setRomaNotation(String romaNotation) {
		this.romaNotation = romaNotation;
	}

	public String getBinaryNotation() {
		return binaryNotation;
	}

	public void setBinaryNotation(String binaryNotation) {
		this.binaryNotation = binaryNotation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int[] getDivisors() {
		return divisors;
	}


	public void setDivisors(int[] divisors) {
		this.divisors = divisors;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((binaryNotation == null) ? 0 : binaryNotation.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + Arrays.hashCode(divisors);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (name ^ (name >>> 32));
		result = prime * result + ((romaNotation == null) ? 0 : romaNotation.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyNumber other = (MyNumber) obj;
		if (binaryNotation == null) {
			if (other.binaryNotation != null)
				return false;
		} else if (!binaryNotation.equals(other.binaryNotation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (!Arrays.equals(divisors, other.divisors))
			return false;
		if (id != other.id)
			return false;
		if (name != other.name)
			return false;
		if (romaNotation == null) {
			if (other.romaNotation != null)
				return false;
		} else if (!romaNotation.equals(other.romaNotation))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MyNumber [id=" + id + ", name=" + name + ", romaNotation=" + romaNotation + ", binaryNotation="
				+ binaryNotation + ", description=" + description + ", divisors=" + Arrays.toString(divisors) + "]";
	}


}
