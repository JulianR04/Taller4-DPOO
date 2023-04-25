package uniandes.dpoo.taller4.App;


import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Collection;
import uniandes.dpoo.taller4.modelo.RegistroTop10;


public class Top extends JDialog {
    private Collection<RegistroTop10> registros;

    public Top(Collection<RegistroTop10> registros){
        this.registros=registros;


        JList<JPanel> lista = new JList<JPanel>(crearBasePaneles());

		lista.setCellRenderer(new ListCellRenderer<JPanel>() {
		    public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel panel, int index, boolean isSelected, boolean cellHasFocus) {
		    	JLabel label = (JLabel) panel.getComponent(0);
                Color color = Color.BLACK;
                if (index!=0  && cellHasFocus) {
		    		 panel.setBackground(new Color(64, 64, 64));
                     
                     label.setForeground(Color.WHITE);
		    	}
                else if (index != 0){
                    if (index<4) color = new Color(41,160,41);
                    else if (index<6) color = new Color(46,46,162);
		    		panel.setBackground(Color.WHITE);
                    label.setForeground(color);
		    	}
		    	return panel;
		    }
            
		});



        JScrollPane scrollPane = new JScrollPane(lista);
        add(scrollPane);
        setTitle("Top 10");
        setSize(300, 370);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public DefaultListModel<JPanel> crearBasePaneles() {
        DefaultListModel<JPanel> base = new DefaultListModel<JPanel>();
        JPanel panelRegistro = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelRegistro.setBackground(new Color(43, 136, 224));
        panelRegistro.add(CustomWidget.crearNuevoTexto("#   Nombre", Color.WHITE));
        base.addElement(panelRegistro);
        int i=1;
        for (RegistroTop10 registro : registros){
            panelRegistro = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
            panelRegistro.add(CustomWidget.crearNuevoTexto(i+"   "+ registro.darNombre()+"   "+registro.darPuntos(), Color.BLACK));
            base.addElement(panelRegistro);
            i++;
        }

        return base;
    }
}