package fr.formation.itschool.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Administrateur
 */
public class AddressCreateDto {

    @NotBlank(message = "Road must not be empty idiot!")
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED")
    @NotNull
    private String road;

    @NotBlank(message = "Pas bien!")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED")
    @NotNull
    private String zipCode;

    @NotNull
    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED")
    private String city;

    /**
     * 
     */
    public AddressCreateDto() {
	//
    }

    /**
     * @return
     */
    @Override
    public String toString() {
	return "CreateAddressDto [road=" + road + ", zipcode=" + zipCode
		+ ", city=" + city + "]";
    }
}
