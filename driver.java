package lab8_AVLTree;




public class driver extends JFrame implements ActionListener{
	
		private AvlTree avlTree = new Avltree();
		private DisplayableBtree
				displayAvltree = new DisplayableBtree(AvlTree);
		
		private JLabael cmdresultlabel; 
		private JTextField cmdresultextfield;
		private JLabel cmdLabel;
		private JTextField cmdtextfield;
		
		public AvlTreeDemo()
		{
			setTitle("Avl Trees");
			
			//cmd text and cmd result label in nor region
			Jpanel resultPanel = new JPanel(new GridLayout(1,2));
			cmdresultlabel = new JLabel("command result");
			cmdresulttextfield = new JTextField();
			resultPanel.add(cmdResultLabel);
			resultPanel.add(cmdResultTextField);
			cmdresulttextfield.setEditable(false);
			add(resultPanel, BorderLayout.north);
			
			// leave center for binary tree view
			
			//cmd label and cmd text field i nsouth region 
			cmdLabel = new JLabel("Command: ");
			cmdTextField = new JTextField();
			JPanel cmdPanel = new JPanel(new GridLayout(1,2));
			cmdPanel.add(cmdLabel);
			cmdPanel.add(cmdtextfield);
			cmdtextfield.addActionListener(this);
			add(cmdPanel, BorderLayout.south);
			
			//setup the frame
			pack();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisable(true);
			
			
			
			
		}
		
		


}
