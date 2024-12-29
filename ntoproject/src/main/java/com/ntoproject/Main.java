package com.ntoproject;

import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.futurefactory.Data.EditableGroup;
import com.futurefactory.Navigator;
import com.futurefactory.PathIcon;
import com.futurefactory.ProgramStarter;
import com.futurefactory.Registrator;
import com.futurefactory.Root;
import com.futurefactory.User;
import com.futurefactory.User.Feature;
import com.futurefactory.User.Permission;
import com.futurefactory.User.Role;
import com.futurefactory.defaults.features.DefaultFeature;
import com.ntoproject.editables.ExhibitionItem;
import com.ntoproject.editables.space.CenterSpace;


public class Main{
	public enum AppRole implements Role{
		ENTERTAINMENT(
			()->new Permission[]{},
			()->new Feature[]{DefaultFeature.MODEL_EDITING}
		),CULTURE(
			()->new Permission[]{},
			()->new Feature[]{DefaultFeature.MODEL_EDITING}
		),EDUCATION(
			()->new Permission[]{},
			()->new Feature[]{DefaultFeature.MODEL_EDITING}
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
			User.register("Развлекательная деятельность","");
			User.register("Культурно-просв. деятельность","");
			User.register("Образовательная деятельность","");
			EditableGroup<CenterSpace>spaces=new EditableGroup<CenterSpace>(
				new PathIcon("ui/left.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				new PathIcon("ui/right.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				CenterSpace.class
			);
			EditableGroup<ExhibitionItem>exhibitionItems=new EditableGroup<ExhibitionItem>(
				new PathIcon("ui/left.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				new PathIcon("ui/right.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				ExhibitionItem.class
			);
			ProgramStarter.runProgram();
			Registrator.register(spaces);
			Registrator.register(exhibitionItems);
		}else ProgramStarter.runProgram();
	}
}