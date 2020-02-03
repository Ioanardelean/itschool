/**
 * This package contains JPA-mapped business entities.
 * <p>
 * Entities are mapped by field-access strategy, provide default no-arg
 * protected constructor, an identifier of type {@link Long} and an optimistic
 * lock value of type {@link java.time.LocalDateTime}. Entities with immutable
 * fields provide a constructor in order to set related attributes at
 * construction time.
 * <p>
 * Last but not least, entities override {@link Object#equals(Object)},
 * {@link Object#hashCode()} and {@link Object#toString()}.
 * 
 * @see fr.formation.itschool.domain.entities.AbstractEntity
 */
package fr.formation.itschool.domain.entities;