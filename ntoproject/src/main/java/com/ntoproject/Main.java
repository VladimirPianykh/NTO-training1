package com.ntoproject;

import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.futurefactory.Data.EditableGroup;
import com.futurefactory.Navigator;
import com.futurefactory.PathIcon;
import com.futurefactory.ProgramStarter;
import com.futurefactory.Registrator;
import com.futurefactory.Root;
import com.futurefactory.User.Feature;
import com.futurefactory.User.Permission;
import com.futurefactory.User.Role;
import com.ntoproject.editables.ExhibitionItem;


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
		Navigator.init();
		ProgramStarter.welcomeMessage="Добро пожаловать в Культурный центр ЗИЛ. Нажмите alt+H для запуска навигатора.";
		ProgramStarter.authRequired=false;
		if(ProgramStarter.isFirstLaunch()){
			EditableGroup<ExhibitionItem>exhibitionItems=new EditableGroup<ExhibitionItem>(
				new PathIcon("ui/left.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				new PathIcon("ui/right.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				ExhibitionItem.class
			);
		}
		ProgramStarter.runProgram();
	}
}