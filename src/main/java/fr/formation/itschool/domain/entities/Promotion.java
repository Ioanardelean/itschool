package fr.formation.itschool.domain.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/**
 * Represents a promotion with its name, start and end dates; teachers and
 * students.
 */
@Entity
public class Promotion extends AbstractEntity {

    private static final long serialVersionUID = -7795215991284760793L;

    @Column(length = 100, nullable = false)
    private String name;

    // @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Set<Stakeholder> teachers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Set<Stakeholder> students;

    /*
     * Explicit protected constructor for ensuring security and consistency.
     */
    protected Promotion() {
	// Default no-arg empty constructor
    }

    /**
     * Returns a string representation of this {@code promotion}.
     * <p>
     * Returns a view of all the properties but the teachers and students.
     *
     * @return a string representation of this {@code promotion}
     * @see {@link LocalDate#toString()} for the start and end dates string
     *      representation
     */
    @Override
    public String toString() {
	return "{id=" + getId() + ", name=" + name + ", startDate=" + startDate
		+ ", endDate=" + endDate + "}";
    }
}
