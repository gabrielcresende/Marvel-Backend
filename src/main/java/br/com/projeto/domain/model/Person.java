package br.com.projeto.domain.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	// The unique ID of the character resource.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// The name of the character.
	private String name;
	// A short bio or description of the character.
	private String description;
	// The date the resource was most recently modified.
	private LocalDateTime modified;
	// The canonical URL identifier for this resource.
	private String resourceURI;
	// The representative image for this character.
	@Lob
    private byte[] thumbnail;
	// A resource list containing comics which feature this character.
	@ManyToMany
	@JoinTable(
	        name = "Person_Comic",
	        joinColumns = { @JoinColumn(name = "person_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "comic_id") }
	)
	private Set<Comic> comics = new HashSet<>();
	// A resource list of stories in which this character appears.
	@ManyToMany
	@JoinTable(
	        name = "Person_Storie", 
	        joinColumns = { @JoinColumn(name = "person_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "storie_id") }
	)
	private Set<Storie> stories = new HashSet<>();
	// A resource list of events in which this character appears.
	@ManyToMany
	@JoinTable(
	        name = "Person_Event", 
	        joinColumns = { @JoinColumn(name = "person_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "event_id") }
	)
	private Set<Event> events = new HashSet<>();
	// A resource list of series in which this character appears.
	@ManyToMany
	@JoinTable(
	        name = "Person_Serie", 
	        joinColumns = { @JoinColumn(name = "person_id") },
	        inverseJoinColumns = { @JoinColumn(name = "serie_id") }
	)
	private Set<Serie> series = new HashSet<>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	public byte[] getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Set<Comic> getComics() {
		return comics;
	}
	public void setComics(Set<Comic> comics) {
		this.comics = comics;
	}
	public Set<Storie> getStories() {
		return stories;
	}
	public void setStories(Set<Storie> stories) {
		this.stories = stories;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	public Set<Serie> getSeries() {
		return series;
	}
	public void setSeries(Set<Serie> series) {
		this.series = series;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
