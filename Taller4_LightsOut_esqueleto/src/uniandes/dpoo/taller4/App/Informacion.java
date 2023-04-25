package uniandes.dpoo.taller4.App;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Informacion extends JPanel {
    private JTextField jugadasField= new JTextField();
    private JTextField nombreField = new JTextField();

    public Informacion(){
        GridLayout layout= new GridLayout(1, 4);
        layout.setHgap(10);
        layout.setVgap(10);
        setLayout(layout);
        add(CustomWidget.crearNuevoTexto("Jugadas:",Color.black));

        jugadasField.setText(Integer.toString(0));
        add(jugadasField);
        add(CustomWidget.crearNuevoTexto("Jugador:",Color.black));
        add(nombreField);
    }
    public void setCantidad(int cantidad){
        jugadasField.setText(Integer.toString(cantidad));
    }
    public String getNombreField(){
        return nombreField.getText();
    }
}