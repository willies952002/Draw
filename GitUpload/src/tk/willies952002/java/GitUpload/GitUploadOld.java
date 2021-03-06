package tk.willies952002.java.GitUpload;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GitUploadOld extends JFrame implements Runnable {

	private static final long serialVersionUID = -3899450734400301334L;
	private static String gitUser;
	@SuppressWarnings("unused")
	private static String gitPass;
	private static boolean instantiated = false;

	JTextField gitPathField = new JTextField();

	JTextField gitUserField = new JTextField();

	JTextField gitPassField = new JTextField();
		
	JTextField gitCommitMsg = new JTextField();

	public GitUploadOld() {
		GitUploadOld.instantiated = true;
	}

	public GitUploadOld(InputStream in) {
		this(new Scanner(in).nextLine(), new Scanner(in).nextLine());
	}

	public GitUploadOld(String user, String oauth) {
		GitUploadOld.instantiated = false;
		GitUploadOld.gitUser = user;
		GitUploadOld.gitPass = oauth;
	}

	@Override
	public void run() {
		buildUI();
		this.setVisible(true);
	}

	public void buildUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Container contentPane = this.getContentPane();

		JButton commitBtn = new JButton("Commit And Push");
		commitBtn.setAction(new GitAction());

		contentPane.setLayout(new BorderLayout());
		contentPane.add(new JLabel("Path To Remote (HTTPS Only): "));
		contentPane.add(gitPathField, BorderLayout.NORTH);
		contentPane.add(gitCommitMsg, BorderLayout.CENTER);
		if ( this.isInstantiated() ) {
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout());
			panel.add(new JLabel("Username: "));
				gitUserField.setColumns(20);
				gitPassField.setColumns(35);
				panel.add(gitUserField);
				panel.add(new JLabel("Password: "));
				panel.add(gitPassField);
			contentPane.add(panel, BorderLayout.WEST); 
		}
		contentPane.add(commitBtn, BorderLayout.SOUTH);

	}

	public boolean isInstantiated() {
		return instantiated;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new GitUploadOld());
	}

	public class GitAction extends AbstractAction {

		private static final long serialVersionUID = -6187850825911399342L;
		public GitAction() {
			putValue(NAME, "Commit And Push");
		}
		public void actionPerformed(ActionEvent event) {
			try {
				//Runtime.getRuntime().exec("git", new String[] {"commit", "-a", "-m\"" + gitCommitMsg.getText() + "\"" } );
				System.out.println("git commit -a -m\"" + gitCommitMsg.getText() + "\"");
				Thread.sleep(100);
				//Runtime.getRuntime().exec("git", new String[] {"push", "https://" + (isInstantiated() ? gitUserField.getText() : gitUser) + "@" + gitPathField.getText(), "master" });
				System.out.println( "git push https://" + (isInstantiated() ? gitUserField.getText() : gitUser) + "@" + gitPathField.getText() + " master" );
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	

}