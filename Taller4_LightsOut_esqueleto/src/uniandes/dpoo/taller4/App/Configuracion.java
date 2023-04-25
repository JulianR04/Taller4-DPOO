package uniandes.dpoo.taller4.App;


import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Configuracion extends JPanel {
    private Interfaz interfaz;
    public Configuracion(Color color, Interfaz interfaz){
        this.interfaz=interfaz;
        setLayout(new FlowLayout());
        setBackground(color);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(CustomWidget.crearNuevoTexto("Tamaño:",Color.white));

        JComboBox<String> opcionesTamaño = new JComboBox<String>();
        opcionesTamaño.addItem("3x3");
        opcionesTamaño.addItem("5x5");
        opcionesTamaño.addItem("7x7");
        opcionesTamaño.setSelectedItem("5x5");

        add(opcionesTamaño);

        add(CustomWidget.crearNuevoTexto("Dificultad:",Color.white));
        ButtonGroup group = new ButtonGroup();
        JRadioButton radioButton1 = CustomWidget.nuevoBotonRadio("Fácil",color,Color.white);
        JRadioButton radioButton2 = CustomWidget.nuevoBotonRadio("Medio",color,Color.white);
        JRadioButton radioButton3 = CustomWidget.nuevoBotonRadio("Difícil",color,Color.white);

        opcionesTamaño.addActionListener(e -> {
            String tamaño = (String) opcionesTamaño.getSelectedItem();
            if (tamaño.equals("3x3"))interfaz.setTamaño(3);
            else if (tamaño.equals("5x5"))interfaz.setTamaño(5);
            else interfaz.setTamaño(7);
        });

        radioButton1.addActionListener(e -> {
            this.interfaz.setDificultad(3);
        });
        radioButton2.addActionListener(e -> {
            this.interfaz.setDificultad(5);
        });
        radioButton3.addActionListener(e -> {
            this.interfaz.setDificultad(7);
        });

        radioButton1.setSelected(true);
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        add(radioButton1);
        add(radioButton2);
        add(radioButton3);
    }
}





