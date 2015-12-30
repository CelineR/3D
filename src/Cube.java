import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Cube{
	
	private float x, y, z;
	private float tx, ty, tz;
	private float l;
	public float vistX=0;
	public float vistY=0;
	public float vistZ=0;
	private String texture;
	private int iTexture;


	

	public Cube(float x, float y, float z, float tx, float ty, float tz, float l, String texture) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		this.l= l;
		this.texture = texture;
	}
//render s'occupe juste de dessiner quoi qu'il se passe
//update lui va mettre a jour le monde

	public void update(){
		
		vistX+=tx;
		vistY+=ty;
		vistZ+=tz;
		
	   
	
	
	}
	
	public void init(GLAutoDrawable dr){
		GL2 gl = dr.getGL().getGL2();

		
		try{
			 File file = new File(texture);
			 Texture t = TextureIO.newTexture(file, false);
			 iTexture = t.getTextureObject(gl);
			 
		}catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
		
	
	
		
	}
	
	
	public void render(GLAutoDrawable dr){
		
		
		GL2 gl = dr.getGL().getGL2();
		GLU glu = GLU.createGLU(gl);
	
		
		gl.glBindTexture(gl.GL_TEXTURE_2D, iTexture);
	
		//Un rotate sur chaque axe 
	gl.glPushMatrix();
	
		
		gl.glRotatef(vistX, 1f, 0f, 0f);
		gl.glRotatef(vistY, 0f, 1f, 0f);
		gl.glRotatef(vistZ, 0f, 0f, 1f);		
		
		gl.glBegin(gl.GL_QUADS);
		
		//x = ligne des x
		//y = positionnement du y par rapport a x
		//Z = profondeur
		
		
		   //front
        
       
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l); // -0.1 -0.1 -0.1
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z-l);	//  0.1 -0.1 -0.1
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z-l);	//  0.1  0.1 -0.1
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z-l); // -0.1  0.1 -0.1
        
        //back
   
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z+l);
        
        //left
     
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x-l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z-l);
        
        //right
        
        
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x+l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y+l,z-l);
        
        //bottom
        
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y-l,z-l);
        
        //top
       
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y+l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y+l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y+l,z-l);
	     

		
		gl.glEnd(); 
		
	gl.glPopMatrix();
	
	}


	
}
