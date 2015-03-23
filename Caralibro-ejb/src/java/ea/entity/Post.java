/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.entity;

/**
 *
 * @author lavitz
 */
public class Post {
    private long id = 0;
    private String titulo = "";
    private String mensaje = "";
    
    // Contructor
    public Post(){}
    //  Contructor to initial the properties
    public Post(long id, String titulo, String mensaje) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
	
	public String getMensaje() {
		return mensaje;
	}

	public void getMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
