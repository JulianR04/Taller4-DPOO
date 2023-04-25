package uniandes.dpoo.taller4.App;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Opciones extends JPanel {
    private Interfaz interfaz;
    public Opciones(Color colorPrincipal, Color colorFont, Interfaz interfaz){
        this.interfaz= interfaz;
        GridLayout gridLayout = new GridLayout(0, 1);
        gridLayout.setVgap(20);
        setLayout(gridLayout);


        JButton boton1 = new JButton("NUEVO");
        JButton boton2 = new JButton("REINICIAR");
        JButton boton3 = new JButton("TOP-10");
        JButton boton4 = new JButton("CAMBIAR JUGADOR");

        boton1.addActionListener(e -> {
            this.interfaz.crearNuevoTablero();
            this.interfaz.getInfo().setCantidad(0);
        });
        boton2.addActionListener(e -> {
            this.interfaz.reiniciarTablero();
            this.interfaz.getInfo().setCantidad(0);
        });
        boton3.addActionListener(e -> {
            new Top(interfaz.getTop().darRegistros());
        });
        boton4.addActionListener(e -> {
            this.interfaz.setNombre();
        });
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);

        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());
        add(Box.createVerticalGlue());

        boton1.setBackground(colorPrincipal);
        boton1.setForeground(colorFont);
        boton2.setBackground(colorPrincipal);
        boton2.setForeground(colorFont);
        boton3.setBackground(colorPrincipal);
        boton3.setForeground(colorFont);
        boton4.setBackground(colorPrincipal);
        boton4.setForeground(colorFont);
    }
}


