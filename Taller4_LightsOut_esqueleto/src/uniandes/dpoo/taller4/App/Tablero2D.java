package uniandes.dpoo.taller4.App;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;


public class Tablero2D extends JPanel implements MouseListener {

   private int tamaño_tablero_sin_gap = (105)*5;
   private Color color = new Color(255, 241, 118);
   private int cantidad_celdas ;
   private int tamaño_celda;
   private int gap;
   private Rectangle[][] rectangles;
   private Tablero tablero;
   private Interfaz interfaz;

   public Tablero2D(int cantidad_celdas, int dificultad, Interfaz interfaz) {
      setConf(cantidad_celdas,dificultad);
      this.interfaz=interfaz;
      addMouseListener(this);
   }

   public void setConf(int cantidad_celdas,int dificultad ){
      this.cantidad_celdas = cantidad_celdas;
      this.tamaño_celda = this.tamaño_tablero_sin_gap/cantidad_celdas;
      this.rectangles = new Rectangle[cantidad_celdas][cantidad_celdas];
      this.tablero = new Tablero(cantidad_celdas);
      tablero.desordenar(dificultad);
      this.gap = 12/(cantidad_celdas-1);
      repaint();
   }

   public Tablero getTablero(){
      return tablero;
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      try {
         Image image = ImageIO.read(new File("Taller4_LightsOut_esqueleto/data/luz.png"));
         int disminucionTamañoImagen = (int)tamaño_celda*40/100;
         int mitadDisminucion = (int) disminucionTamañoImagen/2;
         int margen=5;
         for (int i=0; i<cantidad_celdas; i++){
            for (int j=0; j<cantidad_celdas; j++){
               rectangles[i][j]= new Rectangle(margen+(gap*j)+(j*tamaño_celda), margen+(gap*i)+(i*tamaño_celda),tamaño_celda, tamaño_celda);
               if (tablero.darTablero()[i][j]) g2.setColor(color);
               else g2.setColor(new Color(50,50,50));
               g2.fill(rectangles[i][j]);
               g2.drawImage(image, margen+mitadDisminucion+(gap*j)+(j*tamaño_celda), margen+mitadDisminucion+(gap*i)+(i*tamaño_celda),tamaño_celda-disminucionTamañoImagen, tamaño_celda-disminucionTamañoImagen, null);
            }

         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void mouseClicked(MouseEvent e) {
      int x = e.getX();
      int y = e.getY();
      for (int i=0; i<cantidad_celdas; i++){
      for (int j=0; j<cantidad_celdas; j++) {
         if (rectangles[i][j].contains(x, y) && (!tablero.tableroIluminado())) {
            tablero.jugar(i,j);
            interfaz.getInfo().setCantidad(tablero.darJugadas());
            repaint();
            if (tablero.tableroIluminado()){
               JOptionPane.showMessageDialog(this, new JLabel("Has completado el tablero!, tu puntuacion es: "+ tablero.calcularPuntaje() +" puntos."), "Ganaste", JOptionPane.INFORMATION_MESSAGE);
               Top10 top10 = interfaz.getTop();
               if (top10.esTop10(tablero.calcularPuntaje())){

                  top10.agregarRegistro(interfaz.getNombre(),tablero.calcularPuntaje());
                  try { 
                     top10.salvarRecords(new File("Taller4_LightsOut_esqueleto/data/top10.csv"));
                  } catch (FileNotFoundException e1) {

                     e1.printStackTrace();
                  } catch (UnsupportedEncodingException e1) {

                     e1.printStackTrace();
                  }
               }
            }
         }

      }
   }
   }
   public void mouseEntered(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}

   public void mousePressed(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
}