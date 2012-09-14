package semplest.dmoz.tree.frame;

import javax.swing.*;

import semplest.dmoz.tools.DmozTreeBuilder;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.filter.CharDigitLeafNodeMerger;
import semplest.dmoz.tree.filter.DmozTreeFliter;
import semplest.dmoz.tree.filter.FilterMessage;
import semplest.dmoz.tree.filter.LowUrlNodeMerger;
import semplest.dmoz.tree.filter.RegionalNodeMerger;
import semplest.dmoz.tree.process.AllNodesUrlNumProcesser;
import semplest.dmoz.tree.process.NodeCountProcessor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeViewer implements  ActionListener, MouseListener{
	
	
	//================================================================ constants
    private static final int    NODE_SIZE  = 18;
    private static final int    NODE_STYLE = Font.PLAIN;
    private static final String NODE_STYLENAME = "Font.PLAIN";
    private static final String NODE_FONTNAME  = "Monospaced";
    
    private static final int CATEGORY_WIDTH = 400;
    private static final int CATEGORY_ROWS = 35;
    private static final int CATEGORY_Y = 20;


	// Definition of global values and items that are part of the GUI.
	int redScoreAmount = 0;
	int blueScoreAmount = 0;

	JPanel titlePanel, bodyPanel, buttonPanel, statsPanel;
	JLabel categoryLabel, categoryNodeLabel, statLabel;
	Set<JLabel> childLabelSet;


	JButton upButton, topButton, filterButton;
	
	// added subhojit
	JFrame containingFrame;
	DmozTreeNode dmozTree;
	
	FilterMessage filterMsg; 

	public TreeViewer(DmozTreeNode dmozTree, FilterMessage filterMsg) {
		this.filterMsg = filterMsg;
		this.dmozTree = dmozTree;
	}

	public JPanel createContentPane () throws Exception{

		// We create a bottom JPanel to place everything on.
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);

		// Creation of a Panel to contain the title labels
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setLocation(50, 100);
		titlePanel.setSize(1162, 30);
		totalGUI.add(titlePanel);

		//redLabel = new JLabel("Red Team");
		categoryLabel = new JLabel("Category:");
		//redLabel.setFont(new Font(NODE_FONTNAME, NODE_STYLE, NODE_SIZE));
		categoryLabel.setLocation(0, 0);
		categoryLabel.setSize(CATEGORY_WIDTH*5, 30);
		categoryLabel.setHorizontalAlignment(JLabel.LEFT);
		categoryLabel.setForeground(Color.red);
		titlePanel.add(categoryLabel);

		//categoryNodeLabel = new JLabel("Blue Team");
		categoryNodeLabel = new JLabel(getCapitalized(dmozTree.getName()));
		categoryNodeLabel.setLocation(62, 0);
		categoryNodeLabel.setSize(CATEGORY_WIDTH*5, 30);
		categoryNodeLabel.setHorizontalAlignment(JLabel.LEFT);
		categoryNodeLabel.setForeground(Color.blue);
		titlePanel.add(categoryNodeLabel);

		
		// Creation of a Panel to contain the stats labels
		statsPanel = new JPanel();
		statsPanel.setLayout(null);
		statsPanel.setLocation(50, 120);
		statsPanel.setSize(CATEGORY_WIDTH*20, 30);
		totalGUI.add(statsPanel);
		
		
		AllNodesUrlNumProcesser allNodesUrl = new AllNodesUrlNumProcesser();
		NodeCountProcessor allNodeCounter = new NodeCountProcessor();
		
		
//		Map<String, DmozTreeNode> topCategoryMap = dmozTree.getChildrenNodes();
//		for(String cat : topCategoryMap.keySet()){
//			System.out.println(cat+": "+ allNodesUrl.getCount(topCategoryMap.get(cat)));
//		}
		
		
		StringBuffer statBuff = new StringBuffer();
		statBuff.append(" Node URLs:   "+dmozTree.getCategoryData().getUrlData().keySet().size());
		statBuff.append(",      Total Tree URLs:   "+ dmozTree.getTreeURLCount());//allNodesUrl.getCount(dmozTree));
		statBuff.append(",      Total Tree Nodes:   "+ dmozTree.getTreeNodeCount());//allNodeCounter.getCount(dmozTree));
		statLabel = new JLabel(statBuff.toString());
		statLabel.setLocation(70, 0);
		statLabel.setSize(CATEGORY_WIDTH*20, 30);
		statLabel.setHorizontalAlignment(JLabel.LEFT);
		statLabel.setForeground(Color.blue);
		statsPanel.add(statLabel);
		
		
		// Creation of a Panel to contain the score labels.
		bodyPanel = new JPanel();
		bodyPanel.setLayout(null);
		bodyPanel.setLocation(75, 140);
		bodyPanel.setSize(1000, 3000);
		//bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		totalGUI.add(bodyPanel);

		//subCatLabel = new ArrayList<JLabel>();
		//outLinks = new ArrayList<JButton>();
		//childButtonSet = new HashSet<JButton>();
		childLabelSet = new HashSet<JLabel>();
		Map<String,DmozTreeNode> children = dmozTree.getChildrenNodes();
		
		JLabel subCatTitleL = new JLabel("Sub-categories:");
		subCatTitleL.setLocation(0, 0);
		subCatTitleL.setSize(100, 30);
		subCatTitleL.setHorizontalAlignment(JLabel.LEFT);
		subCatTitleL.setForeground(Color.red);
		bodyPanel.add(subCatTitleL);
		
		int i=0;
		for(String s0 : children.keySet()){
			JLabel subCatL = new JLabel(getCapitalized(s0).replaceAll(".*/ ", ""));
//			JLabel subCatL = new JLabel(getCapitalized(s0).replaceAll(".*/ ", "")+
//					"    (Node URLs:   "+0+",      Sub-Tree URLs:   "+1+",      Sub-Tree Nodes:   "+2+")");
			int columnNo = i/CATEGORY_ROWS;
			int rowNo = i%CATEGORY_ROWS+2;
			subCatL.setLocation(25+columnNo*CATEGORY_WIDTH, rowNo*CATEGORY_Y);
			subCatL.setSize(CATEGORY_WIDTH/2, 30);
			subCatL.setHorizontalAlignment(JLabel.LEFT);
			if(children.get(s0).getTreeNodeCount()>0){
				subCatL.setForeground(Color.magenta);
				subCatL.addMouseListener(this);
			} else {
				subCatL.setForeground(Color.darkGray);
			}
			subCatL.setName(s0);
			bodyPanel.add(subCatL);
			childLabelSet.add(subCatL);
			i++;
		}
		
		i=0;
		for(String s0 : children.keySet()){
			//JLabel subCatL = new JLabel("(Nodes: "+allNodeCounter.getCount(children.get(s0))+", URLs: "+allNodesUrl.getCount(children.get(s0))+")");
			JLabel subCatL = new JLabel("(Nodes: "+children.get(s0).getTreeNodeCount()+", URLs: "+children.get(s0).getTreeURLCount()+")");
//			JLabel subCatL = new JLabel(getCapitalized(s0).replaceAll(".*/ ", "")+
//					"    (Node URLs:   "+0+",      Sub-Tree URLs:   "+1+",      Sub-Tree Nodes:   "+2+")");
			int columnNo = i/CATEGORY_ROWS;
			int rowNo = i%CATEGORY_ROWS+2;
			subCatL.setLocation(25+columnNo*CATEGORY_WIDTH+CATEGORY_WIDTH/2, rowNo*CATEGORY_Y);
			subCatL.setSize(CATEGORY_WIDTH/2, 30);
			subCatL.setHorizontalAlignment(JLabel.LEFT);
			if(children.get(s0).getTreeNodeCount()>0){
				subCatL.setForeground(Color.blue);
			} else {
				subCatL.setForeground(Color.darkGray);
			}
			subCatL.setName(s0);
			bodyPanel.add(subCatL);
			i++;
		}
		
//		redScore = new JLabel(""+redScoreAmount);
//		redScore.setLocation(0, 0);
//		redScore.setSize(120, 30);
//		redScore.setHorizontalAlignment(0);
//		bodyPanel.add(redScore);
//
//		blueScore = new JLabel(""+blueScoreAmount);
//		blueScore.setLocation(130, 0);
//		blueScore.setSize(120, 30);
//		blueScore.setHorizontalAlignment(0);
//		bodyPanel.add(blueScore);

		// Creation of a Panel to contain all the JButtons.
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(500, 10);
		buttonPanel.setSize(390, 70);
		totalGUI.add(buttonPanel);

		// We create a button and manipulate it using the syntax we have
		// used before. Now each button has an ActionListener which posts 
		// its action out when the button is pressed.
		upButton = new JButton("Move Up");
		upButton.setLocation(0, 0);
		upButton.setSize(120, 30);
		upButton.addActionListener(this);
		buttonPanel.add(upButton);

		topButton = new JButton("Go To Top");
		topButton.setLocation(130, 0);
		topButton.setSize(120, 30);
		topButton.addActionListener(this);
		buttonPanel.add(topButton);

		filterButton = new JButton(getCapitalized(filterMsg.name()));
		filterButton.setLocation(260, 0);
		filterButton.setSize(120, 30);
		filterButton.addActionListener(this);
		buttonPanel.add(filterButton);

		totalGUI.setOpaque(true);
		return totalGUI;
	}
	
	
	private String getCapitalized(String s0){
		StringBuffer buff = new StringBuffer();
		String [] catArr = s0.split("/");
		for(String cat : catArr){
			for(String s : cat.split("_")){
				char [] s1 = s.toCharArray(); 
				if(s1[0]<='z' && s1[0]>='a'){
					s1[0]=(char) (s1[0]+ ('A'-'a'));
				}
				buff.append(new String(s1)+" ");
			}
			if(!cat.equals(catArr[catArr.length-1])){
				buff.append("/ ");
			}
		}
		return buff.toString();
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel mouseClicked = (JLabel) e.getSource();
		Map<String, DmozTreeNode> topCategoryMap = dmozTree.getChildrenNodes();
		if(childLabelSet.contains(mouseClicked)){
			//System.out.println("Clicked "+mouseClicked.getName());
			createAndShowGUI(topCategoryMap.get(mouseClicked.getName()),filterMsg);
			containingFrame.dispose();
		}
	}
	
	
	// This is the new ActionPerformed Method.
	// It catches any events with an ActionListener attached.
	// Using an if statement, we can determine which button was pressed
	// and change the appropriate values in our GUI.
	public void actionPerformed(ActionEvent e) {
		
		Map<String, DmozTreeNode> topCategoryMap = dmozTree.getChildrenNodes();
		JButton buttonClicked = (JButton) e.getSource();
		if(buttonClicked==upButton && dmozTree.getParentNode()!=null){
			createAndShowGUI(dmozTree.getParentNode(),filterMsg);
			containingFrame.dispose();
		}
		if(buttonClicked==topButton && dmozTree.getParentNode()!=null){
			DmozTreeNode t = dmozTree;
			while(t.getParentNode()!=null){
				t=t.getParentNode();
			}
			createAndShowGUI(t,filterMsg);
			containingFrame.dispose();
		}
		if(buttonClicked==filterButton){
			DmozTreeNode t = dmozTree;

			if(filterMsg.equals(FilterMessage.apply_filter)){
				DmozTreeFliter filter1 = new CharDigitLeafNodeMerger();
				DmozTreeFliter filter2 = new LowUrlNodeMerger(20);
				DmozTreeFliter filter3 = new RegionalNodeMerger();

				filter1.applyFilter(t);
				filter2.applyFilter(t);
				filter3.applyFilter(t);
				filterMsg = FilterMessage.remove_filter;
			} else {
				AllNodesUrlNumProcesser urlProcessor = new AllNodesUrlNumProcesser();
				NodeCountProcessor nodeProcessor = new NodeCountProcessor();
				DmozTreeNode root =t;
				while(root.getParentNode()!=null){
					root=root.getParentNode();
				}
				try {
					urlProcessor.getCount(root);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					nodeProcessor.getCount(root);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				filterMsg = FilterMessage.apply_filter;

			}
			createAndShowGUI(t,filterMsg);
			containingFrame.dispose();
		}
		
//		if(e.getSource() == redButton)
//		{
//			redScoreAmount = redScoreAmount + 1;
//			redScore.setText(""+redScoreAmount);
//		}
//		else if(e.getSource() == blueButton)
//		{
//			blueScoreAmount = blueScoreAmount + 1;
//			blueScore.setText(""+blueScoreAmount);
//		}
//		else if(e.getSource() == resetButton)
//		{
//			redScoreAmount = 0;
//			blueScoreAmount = 0;
//			redScore.setText(""+redScoreAmount);
//			blueScore.setText(""+blueScoreAmount);
//		}
	}

	private static void createAndShowGUI(DmozTreeNode dmozTree, FilterMessage filterMsg) {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Dmoz Category Viewer!");

		//Create and set up the content pane.
		TreeViewer demo = new TreeViewer(dmozTree,filterMsg);
		try {
			frame.setContentPane(demo.createContentPane());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//subhojit
		demo.containingFrame = frame;		
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400,800);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		

			
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DmozTreeNode dmozTree = null; 
				try{
					DmozTreeBuilder treeBuilder = new DmozTreeBuilder();
					treeBuilder.buildDmozTree();
					dmozTree = treeBuilder.getTree();
					AllNodesUrlNumProcesser urlProcessor = new AllNodesUrlNumProcesser();
					NodeCountProcessor nodeProcessor = new NodeCountProcessor();
					urlProcessor.getCount(dmozTree);
					nodeProcessor.getCount(dmozTree);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				createAndShowGUI(dmozTree,FilterMessage.apply_filter);
			}
		});
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel mouseClicked = (JLabel) e.getSource();
		Map<String, DmozTreeNode> topCategoryMap = dmozTree.getChildrenNodes();
		if(childLabelSet.contains(mouseClicked)){
			mouseClicked.setForeground(Color.cyan);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel mouseClicked = (JLabel) e.getSource();
		Map<String, DmozTreeNode> topCategoryMap = dmozTree.getChildrenNodes();
		if(childLabelSet.contains(mouseClicked)){
			mouseClicked.setForeground(Color.magenta);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
