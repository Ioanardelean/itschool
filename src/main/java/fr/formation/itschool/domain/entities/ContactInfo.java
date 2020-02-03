package fr.formation.itschool.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Represents contact information, postal address, mobile phone number and email
 * address.
 */
@Entity
public class ContactInfo extends AbstractEntity {

    private static final long serialVersionUID = -7275903852486380147L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @NotNull
    private Address address;

    @Column(length = 12)
    private String phone;

    @Column(length = 12)
    private String mobile;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    /*
     * Explicit protected constructor for ensuring security and consistency.
     */
    protected ContactInfo() {
	// Default no-arg empty constructor
    }

    /**
     * Returns a string representation of this {@code contactInfo}.
     * <p>
     * Returns a view of all the properties.
     *
     * @return a string representation of this {@code contactInfo}
     * @see Address#toString()
     */
    @Override
    public String toString() {
	return "{id=" + getId() + ", address=" + address + ", phone=" + phone
		+ ", mobile=" + mobile + ", email=" + email + "}";
    }
}
