package com.sqli.paja.hiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hiring.configuration.SpringDataConfiguration;
import com.hiring.entities.School;
import com.hiring.service.ISchoolService;
import com.hiring.service.SchoolService;

public class CandidateTest {

	public static void main(String[] args) {

		School etablissement = new School();

		etablissement.setName("Ferahat");

		// Il recupere le fichier de configuration et il va instancier tous les beans
		// renseignés
		// dedans pour qu'on puisse les manipuler avec notre variable
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfiguration.class);

		ISchoolService service = context.getBean(SchoolService.class);
		service.insertSchool(etablissement);
	}

}
