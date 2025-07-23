package com.example.crudTest;

import com.example.crudTest.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CrudTestApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;
	@Test

	void contextLoads() {
	}

	@Test
	void createStudent() throws Exception {
		Student student = new Student(null, "John" , "Doe" , true);
		MvcResult result = mockMvc.perform(post("/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(student))
		).andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		String Json = result.getResponse().getContentAsString();
		Student created = objectMapper.readValue(Json, Student.class);
		assertEquals(student.getName(), created.getName());

	}

}
