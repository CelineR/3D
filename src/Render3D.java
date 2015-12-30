import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public class Render3D implements GLEventListener{
	
	
		
	  ArrayList<Cube> CubeList = new ArrayList<Cube>();
	  
	  Cube C = new Cube(0.0f,0.0f,0.0f,0.0f,-2f,0.0f,0.1f,"Texture1.jpg");
	  
	  Cube C2 = new Cube(0.0f,0.4f,0.0f, 2f, 0f, 0f,0.1f,"Texture2.jpg");
	  
	  Cube C3 = new Cube(0.0f,0.8f,0.0f, 0.0f, 0.0f,-2f,0.1f,"Texture3.jpg");
	  
	  
	  
	  
	// Changement dans le monde et le Dessin
	  
	public void update(){
	
		 C.update();
		 C2.update();
		 C3.update();

	}
	
	public void render(GLAutoDrawable dr){
		
		
		
	
		//tx= angle de rotation sur l'axe 
		CubeList.add(C);
		CubeList.add(C2);
		CubeList.add(C3);
		for(Cube MonCube: CubeList){
			MonCube.render(dr);		
		}
		

	    		
	}

	@Override
	//dessin update + render
	public void display(GLAutoDrawable dr) {
		// TODO Auto-generated method stub
		GL2 gl = dr.getGL().getGL2();	
		gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
		update();
		render(dr);

	}

	@Override
	public void dispose(GLAutoDrawable gl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable dr) {
		// TODO Auto-generated method stub
		GL2 gl = dr.getGL().getGL2();
		
		gl.glShadeModel(gl.GL_SMOOTH);
		
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClearDepthf(1.0f);
		
		gl.glEnable(gl.GL_DEPTH_TEST);
		gl.glDepthFunc(gl.GL_LEQUAL);
		gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);
				
		gl.glEnable(gl.GL_DEPTH_TEST);
		gl.glEnable(gl.GL_TEXTURE_2D);
		
		gl.glMatrixMode(gl.GL_MODELVIEW);
		gl.glLoadIdentity(); // monde nouveau, enleve toute les transformation faite avant
		
		C.init(dr);
		C2.init(dr);
		C3.init(dr);
	
		
	
	}

	//glpushMatrix() -> glPlopMatrix() tout ce qui sera dedans s'applique seulement à l'objet concerné pex une rotation locale
	//open Gl quand on appelle rotate déplace une matrice de rotation sans se soucier du reste
	
	@Override
	public void reshape(GLAutoDrawable dr, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
	
		//gluperspective
	}
	

}
