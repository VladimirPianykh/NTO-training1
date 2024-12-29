package com.ntoproject;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import com.futurefactory.HButton;
import com.futurefactory.User.Feature;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoadFromExcel implements Feature{
	public static final LoadFromExcel instance=new LoadFromExcel();
	private LoadFromExcel(){}
	public void fillTab(JPanel content,JPanel tab,Font font){
		File f=new File(System.getProperty("user.home")+"/Downloads");
		HButton c=new HButton(){
			public void paint(java.awt.Graphics g){
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, getWidth(), getHeight());
				FontMetrics fm=g.getFontMetrics();
				g.setColor(Color.WHITE);
				g.drawString(getText(),(getWidth()-fm.stringWidth(getText()))/2,(getHeight()+fm.getAscent()+fm.getLeading()-fm.getDescent())/2);
			};
		};
		c.addActionListener(e->{
			//TOOD: import from Excel
		});
		c.setText("Загрузить из "+f.getAbsolutePath());
	}
	public void paint(java.awt.Graphics2D g2,BufferedImage image,int h){
		
	}
}
