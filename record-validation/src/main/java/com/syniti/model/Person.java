package com.syniti.model;

import java.util.Objects;

public class Person {
	
    private String id;
	private String name;
    private String address;
    private String zip;

    public Person(){}

    public Person(String name,String address,String id,String zip){
        this.id = id;
        this.address = address;
        this.name = name;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return name.equals(person.name) && address.equals(person.address) && zip.equals(person.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, zip);
    }

//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", zip=" + zip + "]";
//	}
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
    
}
