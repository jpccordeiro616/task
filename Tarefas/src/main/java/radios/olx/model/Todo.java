package radios.olx.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Todo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String name;

    
    @Column
    private String description;


	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}


	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setDescription(Object description2) {
		// TODO Auto-generated method stub
		
	}


	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}

	

}
