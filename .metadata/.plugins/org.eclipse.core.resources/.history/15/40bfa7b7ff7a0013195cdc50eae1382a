package tk.willies952002.java.GitUpload;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class GitUpload {

	private JFrame frmGitupload;
	private JTextField gitPathField;
	private JTextField gitUserField;
	private JTextField gitPassField;
	private JLabel lblMessage;
	private JTextArea gitCommitMsg;
	private JButton commitBtn;
	private JLabel lblForSecurityYour;
	private JLabel lblDoNotInclude;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GitUpload window = new GitUpload();
					window.frmGitupload.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GitUpload() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGitupload = new JFrame();
		frmGitupload.getContentPane().setForeground(Color.WHITE);
		frmGitupload.getContentPane().setBackground(Color.BLACK);
		frmGitupload.setVisible(true);
		frmGitupload.setTitle("GitUpload");
		String jarLoc = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		frmGitupload.setIconImage(Toolkit.getDefaultToolkit().getImage("jar:" + jarLoc + "!/favicon.png"));
		frmGitupload.setName("GitUpload");
		frmGitupload.setBounds(100, 100, 450, 300);
		frmGitupload.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGitupload.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("110px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,}));
		
		JLabel lblGitRepository = new JLabel("Git Repository: ");
		lblGitRepository.setForeground(Color.LIGHT_GRAY);
		frmGitupload.getContentPane().add(lblGitRepository, "2, 2, right, top");
		
		gitPathField = new JTextField();
		frmGitupload.getContentPane().add(gitPathField, "4, 2, left, default");
		gitPathField.setColumns(28);
		
		lblDoNotInclude = new JLabel("DO NOT INCLUDE \"https://\" OR A USERNAME IN THE GIT PATH");
		lblDoNotInclude.setForeground(Color.RED);
		frmGitupload.getContentPane().add(lblDoNotInclude, "2, 4, 3, 1, center, default");
		
		JLabel lblGitUsername = new JLabel("Git Username: ");
		lblGitUsername.setForeground(Color.LIGHT_GRAY);
		frmGitupload.getContentPane().add(lblGitUsername, "2, 6, right, top");
		
		gitUserField = new JTextField();
		frmGitupload.getContentPane().add(gitUserField, "4, 6, left, default");
		gitUserField.setColumns(28);
		
		JLabel lblGitPassword = new JLabel("Git Password: ");
		lblGitPassword.setForeground(Color.LIGHT_GRAY);
		frmGitupload.getContentPane().add(lblGitPassword, "2, 8, right, top");
		
		gitPassField = new JTextField();
		gitPassField.setBorder(new EmptyBorder(1, 0, 1, 1));
		gitPassField.setBackground(Color.BLACK);
		gitPassField.setForeground(Color.DARK_GRAY);
		frmGitupload.getContentPane().add(gitPassField, "4, 8, left, default");
		gitPassField.setColumns(28);
		
		lblForSecurityYour = new JLabel("For Security, Your Password Is Blacked Out");
		lblForSecurityYour.setForeground(Color.LIGHT_GRAY);
		frmGitupload.getContentPane().add(lblForSecurityYour, "4, 10");
		
		lblMessage = new JLabel("Message: ");
		lblMessage.setForeground(Color.LIGHT_GRAY);
		frmGitupload.getContentPane().add(lblMessage, "2, 12, right, default");
		
		gitCommitMsg = new JTextArea();
		gitCommitMsg.setColumns(28);
		gitCommitMsg.setBorder(UIManager.getBorder("TextField.border"));
		gitCommitMsg.setRows(10);
		frmGitupload.getContentPane().add(gitCommitMsg, "4, 12, left, fill");
		
		commitBtn = new JButton("Commit And Push");
		commitBtn.setAction(new GitAction());
		frmGitupload.getContentPane().add(commitBtn, "4, 14, left, default");
	}

	private class GitAction extends AbstractAction {
		private static final long serialVersionUID = 3948204191493162838L;
		public GitAction() {
			putValue(NAME, "Commit And Push");
			putValue(LONG_DESCRIPTION, "Commit the Changes To The Local Repository Located at '.' and Pushes Them to The Defined Repository");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Runtime.getRuntime().exec("git commit -a -m\"" + gitCommitMsg.getText() + "\"");
				Thread.sleep(100);
				Runtime.getRuntime().exec("git push https://" + gitUserField.getText() + "@" + gitPathField.getText() + " master");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
