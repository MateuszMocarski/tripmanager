package pl.edu.agh.mwo;

import java.util.Set;

public class Trip {
	private String name;
	private String description;
        private Set<Photo> photos;
	
	public Trip(String name, String description) {
		this.name = name;
		this.description = description;
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
        
        public void addPhoto(Photo photo){
            photos.add(photo);
        }
        
        public Set<Photo> getPhotos(){
            return photos;
        }
}
