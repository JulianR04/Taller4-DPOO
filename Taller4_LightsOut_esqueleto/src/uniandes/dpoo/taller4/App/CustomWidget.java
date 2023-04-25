package uniandes.dpoo.taller4.App;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
public class CustomWidget {
    private static Font Principal = new Font("Arial", Font.PLAIN , 12);
    private static Font Negrilla = new Font("Arial", Font.BOLD , 12);


    public static JLabel crearNuevoTexto(String texto, Color color){
        JLabel nuevoTexto = new JLabel(texto);
        nuevoTexto.setForeground(color);
        nuevoTexto.setFont(Negrilla);
        return nuevoTexto;
    }

    public static JRadioButton nuevoBotonRadio(String texto, Color background, Color colorTexto){
        JRadioButton Boton = new JRadioButton(texto);
        Boton.setForeground(colorTexto);
        Boton.setBackground(background);
        Boton.setFont(Principal);
        return Boton;
    }
}
