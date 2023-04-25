package uniandes.dpoo.taller4.App;

import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import uniandes.dpoo.taller4.modelo.Top10;
import java.awt.*;
import java.io.File;


class Interfaz extends JFrame {

    private Container container;
    private int dificultad = 3;
    private int Celdas = 5;
    private Color azulPrincipal = new Color(43, 136, 224);
    private Tablero2D tableroDelJuego=new Tablero2D(Celdas,dificultad,this);
    private Opciones Opciones = new Opciones(azulPrincipal, Color.WHITE,this);
    private Informacion PanelInformacion = new Informacion();
    private Configuracion Configuracion=  new Configuracion(azulPrincipal, this);
    private String nombre = "UNK";
    private Top10 top10= new Top10();


    public Interfaz() {
        
        setTitle("LightsOut");
        setSize(700, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(new BorderLayout());

        
        crearNuevoTablero();
        container.add(Opciones,BorderLayout.EAST);
        container.add(Configuracion,BorderLayout.NORTH);
        container.add(PanelInformacion,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
        top10.cargarRecords(new File("Taller4_LightsOut_esqueleto/data/top10.csv"));
    }

    public void setDificultad(int dificultad){
        this.dificultad=dificultad;
    }

    public void setTamaño(int tamaño){
        this.Celdas=tamaño;
    }


    public void crearNuevoTablero(){
        container.remove(tableroDelJuego);
        tableroDelJuego=new Tablero2D(Celdas,dificultad,this);
        container.add(tableroDelJuego,BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public Informacion getInfo(){
        return this.PanelInformacion;
    }


    public void reiniciarTablero(){
        tableroDelJuego.getTablero().reiniciar();
        container.revalidate();
        container.repaint();
    }

    public void setNombre(){
        this.nombre = PanelInformacion.getNombreField();
    }

    public String getNombre(){
        return this.nombre;
    }


    public Top10 getTop(){
        return this.top10;
    }
    public static void main(String[] args) throws Exception {
        FlatLightLaf.install();
        new Interfaz();
        
    }
}