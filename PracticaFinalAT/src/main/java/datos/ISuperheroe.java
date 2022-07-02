package datos;

import java.util.List;

public interface ISuperheroe {
	
	String getNombre();
	
	List<Poder> getPoder();
	
	boolean isVivo();
	
	String getUniverso();
	
	void setNombre(String nombre);
	
	void addPoder(Poder poder);
	
	void matar();
	
	void resucitar();
	
	
	
	
	

}
