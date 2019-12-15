package com.ngs.REST_Jersey_POST_XML_Repository;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "persons" path)
 */
@Path("persons")
public class MyResource {

	PersonRepository repo=new PersonRepository();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Person> getPersons() {
		return repo.getPersons();
	}
	
	@GET
	@Path("person/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Person getPerson(@PathParam("id") int id) {
		return repo.getPerson(id);
	}
	
	@POST
	@Path("person")
	public Person createPerson(Person p1) {
		System.out.println(p1);
		repo.create(p1);
		return p1;
	}
}
