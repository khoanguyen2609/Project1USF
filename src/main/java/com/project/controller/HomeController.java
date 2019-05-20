package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.ERS;

public class HomeController {

	public static String PetJSON(HttpServletRequest request, HttpServletResponse response) {
		List<ERS> po = (List<ERS>) request.getSession().getAttribute("Listt");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(po));

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}