import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Driver implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(null+"Hellow World");
		SwingUtilities.invokeLater(new Driver());
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		MainWindow main=new MainWindow();
		main.setVisible(true);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
