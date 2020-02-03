package fr.formation.itschool.domain.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * A base abstract entity that concrete entity implementation should extend.
 * <p>
 * Defines a default mapping for the identifier, such as:
 * <ul>
 * <li>name: {@code id}
 * <li>generation type={@link GenerationType#IDENTITY}
 * </ul>
 * Please not that the class implements {@link Serializable} as JPA framework
 * implementations may require entity to be serializable.
 */
@SuppressWarnings("serial") // IDE issue
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Creates a new {@code AbstractEntity} with {@code null} id and optimistic
     * lock.
     */
    protected AbstractEntity() {
	// Default no-arg empty constructor
    }

    /**
     * Returns the identifier for this {@code entity}.
     * <p>
     * May be used by subclasses in order to override {@code toString} with the
     * identifier property.
     *
     * @return the identifier or {@code null} for an unsaved entity
     */
    protected Long getId() {
	return id;
    }

    /*
     * Declared private for security purpose.
     */
    @SuppressWarnings("unused")
    private void setId(Long id) {
	this.id = id;
    }
}
