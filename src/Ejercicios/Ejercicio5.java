package Ejercicios;

	import java.awt.EventQueue;
	import java.awt.FlowLayout;
	import java.awt.Frame;
	import java.awt.TextArea;
	import java.awt.TextField;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.WindowEvent;
	import java.awt.event.WindowListener;
	import java.io.File;

	import javax.swing.JButton;

	public class Ejercicio5 extends Frame implements WindowListener
	{
		private static final long serialVersionUID = 1L;
		private TextField textField = new TextField(20);
		TextArea textArea = new TextArea(20,50);
		JButton btnNewButton = new JButton("Leer directorio");

		public static void main(String[] args)
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Ejercicio5 frame = new Ejercicio5();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public Ejercicio5()
		{
			setLayout(new FlowLayout());
			add(textField);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(leerDirectorio(textField.getText()));
				}
			});
			add(btnNewButton);
			add(textArea);
			addWindowListener(this);
			setSize(400,450);
			setVisible(true);
		}

		public String leerDirectorio(String pathname)
		{
			File filePathname = new File(pathname);
			File[] files = filePathname.listFiles();
			String res = "";
			if(files!=null)
			{
				for(File element:files)
				{
					if(res=="")
					{
						if(element.isDirectory())
						{
							res = "<DIR>"+element.getName();
						}
						else
						{
							res = element.getName();
						}
					}
					else
					{
						if(element.isDirectory())
						{
							res = res + "\n<DIR>" + element.getName();
						}
						else
						{
							res = res + "\n" + element.getName();
						}
					}
				}
			}
			return res;
		}

		@Override
		public void windowActivated(WindowEvent arg0) {}

		@Override
		public void windowClosed(WindowEvent arg0) {}

		@Override
		public void windowClosing(WindowEvent arg0)
		{
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {}

		@Override
		public void windowDeiconified(WindowEvent arg0) {}

		@Override
		public void windowIconified(WindowEvent arg0) {}

		@Override
		public void windowOpened(WindowEvent arg0) {}
	}

