package datos;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Superheroe implements ISuperheroe{
	
	private String nombre;
	
	private boolean vivo;
	
	private String universo;
	
	private List<Poder> poder;
	
	@Override
	public String getNombre() {return this.nombre;}

	@Override
	public List<Poder> getPoder() {return this.poder;}

	@Override
	public boolean isVivo() {return this.vivo;}
 
	@Override
	public String getUniverso() {return this.universo;}
	


		

}
