package fr.formation.itschool.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Represents a partner with its name and contact information.
 */
@Entity
public class Partner extends AbstractEntity {

    private static final long serialVersionUID = 523178222700962654L;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String contactName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private ContactInfo contactInfo;

    /*
     * Explicit protected constructor for ensuring security and consistency.
     */
    protected Partner() {
	// Default no-arg empty constructor
    }

    /**
     * Returns a string representation of this {@code partner}.
     * <p>
     * Returns a view of all the properties.
     *
     * @return a string representation of this {@code partner}
     * @see ContactInfo#toString()
     */
    @Override
    public String toString() {
	return "{id=" + getId() + ", name=" + name + ", contactName="
		+ contactName + ", contactInfo=" + contactInfo + "}";
    }
}
