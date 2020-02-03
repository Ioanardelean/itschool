package fr.formation.itschool.domain.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.formation.itschool.domain.entities.Person.Gender;
import fr.formation.itschool.domain.validation.IsAdult;
import fr.formation.itschool.domain.validation.UniqueSecNumber;

public class CreatePersonDto {

    @NotNull
    @Size(max = 15, message = "{E_MAX_LENGTH_EXCEEDED")
    @UniqueSecNumber
    private String socialSecNumber;

    @NotNull
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED")
    private String firstName;

    @NotNull
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED")
    private String lastName;

    @NotNull
    @IsAdult
    private LocalDate birthDate;

    @NotNull
    private Gender gender;

    protected CreatePersonDto() {
	//
    }

    @Override
    public String toString() {
	return "PersonController [socialSecNumber=" + socialSecNumber
		+ ", firstName=" + firstName + ", lastName=" + lastName
		+ ", birthDate=" + birthDate + ", gender=" + gender + "]";
    }
}
