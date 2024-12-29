package com.ntoproject;

import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.futurefactory.Registrator;
import com.futurefactory.User.Feature;
import com.futurefactory.User.Permission;
import com.futurefactory.User.Role;


public class Main{
	public enum AppRole implements Role{
		ENTERTAINMENT(
			()->new Permission[]{},
			()->new Feature[]{}
		),CULTURE(
			()->new Permission[]{},
			()->new Feature[]{}
		),EDUCATION(
			()->new Permission[]{},
			()->new Feature[]{}
		);
		private AppRole(Supplier<Permission[]>p,Supplier<Feature[]>f){SwingUtilities.invokeLater(()->Registrator.register(this,f.get(),p.get()));}
	}
	public enum AppPermission implements Permission{
		;
		private AppPermission(){Registrator.register(this);}
	}
	public static void main(String[]args){
		System.out.println("Hello world!");
	}
}