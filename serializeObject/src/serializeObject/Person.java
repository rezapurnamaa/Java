package serializeObject;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{

	private String name;
	 
    private Date dateOfBirth;
 
    public Person() {
        this(null, null);
    }
 
    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
 
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person other = (Person) obj;
 
            return this.name.equals(other.name)
                    && this.dateOfBirth.equals(other.dateOfBirth);
 
        } else {
            return false;
        }
    }
 
    public int hashCode() {
        return this.name.hashCode() * 37 + this.dateOfBirth.hashCode();
    }
 
    public String toString() {
        return "Name: " + this.name + "\ndate Of Birth: " + this.dateOfBirth;
    }
}

