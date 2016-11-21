import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class pintaSpray extends Thread{

	MouseEvent e;
	VentanaPrincipal ventana;
	int x;
	int y;
	
	
	
	



	public pintaSpray(VentanaPrincipal ventana, MouseEvent e) {
		this.ventana = ventana;
		this.e= e;
	}


	public void cambiarCordenadas(int posX, int posY) {
		
		x = posX;
		y = posY;
	}




	@Override
	public void run() {
		while(VentanaPrincipal.sprayBotonPulsado) {
			Graphics graficos = ventana.canvas.getGraphics();
			graficos.setColor(ventana.selector1.getColor());
			double angulo=Math.random()*Math.PI*2;
			
			int posXSpray = (int) (Math.cos(angulo) * Math.random()*41);
			int posYSpray = (int) (Math.sin(angulo)* Math.random()*41);
			graficos.fillOval(x + posXSpray, y + posYSpray, 2, 2);
			ventana.lienzo.repaint();
			try {
				sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
