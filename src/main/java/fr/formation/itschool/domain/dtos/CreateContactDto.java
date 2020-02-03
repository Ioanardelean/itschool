package fr.formation.itschool.domain.dtos;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Administrateur
 */
public class CreateContactDto {

    @NotNull
    @Valid
    private AddressCreateDto createAddressDto;

    @Size(max = 12, message = "{E_MAX_LENGTH_EXCEED}")
    private String phone;

    @Size(max = 12, message = "{E_MAX_LENGTH_EXCEED}")
    private String mobile;

    @NotNull
    @Size(max = 255, message = "{E_MAX_LENGTH_EXCEED}")
    @Email
    private String email;

    public CreateContactDto() {
	//
    }

    @Override
    public String toString() {
	return "CreateContactDto [address=" + createAddressDto + ", phone="
		+ phone + ", mobile=" + mobile + ", email=" + email + "]";
    }
}
