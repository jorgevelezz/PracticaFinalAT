package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Superheroe implements ISuperheroe{
	
	private Integer id;
	
	private String nombre;
	
	private String universo;
	
	private Integer poder;
	
	private boolean vivo;
	
	
	@Override
	public String getNombre() {return this.nombre;}

	@Override
	public Integer getPoder() {return this.poder;}

	@Override
	public boolean isVivo() {return this.vivo;}
 
	@Override
	public String getUniverso() {return this.universo;}

	@Override
	public void setNombre(String nombre) {this.nombre = nombre;}

	@Override
	public void setPoder(Integer poder) {this.poder = poder;}

	@Override
	public void matar() {this.vivo=false;}

	@Override
	public void resucitar() {this.vivo=true;}
	


		

}
