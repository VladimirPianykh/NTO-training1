package com.ntoproject;

import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.futurefactory.core.Data.EditableGroup;
import com.futurefactory.core.Navigator;
import com.futurefactory.PathIcon;
import com.futurefactory.core.ProgramStarter;
import com.futurefactory.core.Registrator;
import com.futurefactory.core.Root;
import com.futurefactory.core.User;
import com.futurefactory.core.User.Feature;
import com.futurefactory.core.User.Permission;
import com.futurefactory.core.User.Role;
import com.futurefactory.defaults.features.DefaultFeature;
import com.ntoproject.editables.ExhibitionItem;
import com.ntoproject.editables.Mentor;
import com.ntoproject.editables.Studio;
import com.ntoproject.editables.space.CenterSpace;

public class Main{
	public enum AppRole implements Role{
		ENTERTAINMENT(
			()->new Permission[]{AppPermission.READ_CENTERSPACE,AppPermission.CREATE_CENTERSPACE},
			()->new Feature[]{DefaultFeature.MODEL_EDITING}
		),CULTURE(
			()->new Permission[]{AppPermission.READ_EXHIBITIONITEM,AppPermission.CREATE_EXHIBITIONITEM},
			()->new Feature[]{DefaultFeature.MODEL_EDITING}
		),EDUCATION(
			()->new Permission[]{AppPermission.READ_STUDIO,AppPermission.CREATE_STUDIO,AppPermission.READ_MENTOR,AppPermission.CREATE_MENTOR},
			()->new Feature[]{DefaultFeature.MODEL_EDITING}
		);
		private AppRole(Supplier<Permission[]>p,Supplier<Feature[]>f){SwingUtilities.invokeLater(()->Registrator.register(this,f.get(),p.get()));}
	}
	public enum AppPermission implements Permission{
		READ_CENTERSPACE,
		CREATE_CENTERSPACE,
		READ_STUDIO,
		CREATE_STUDIO,
		READ_EXHIBITIONITEM,
		CREATE_EXHIBITIONITEM,
		READ_MENTOR,
		CREATE_MENTOR;
		private AppPermission(){Registrator.register(this);}
	}
	public static void main(String[]args){
		Navigator.init();
		ProgramStarter.welcomeMessage="Добро пожаловать в Культурный центр ЗИЛ. Нажмите alt+H для запуска навигатора.";
		ProgramStarter.authRequired=false;
		if(ProgramStarter.isFirstLaunch()){
			User.register("Развлекательная деятельность","",AppRole.ENTERTAINMENT);
			User.register("Культурно-просв. деятельность","",AppRole.CULTURE);
			User.register("Образовательная деятельность","",AppRole.EDUCATION);
			EditableGroup<CenterSpace>spaces=new EditableGroup<CenterSpace>(
				new PathIcon("ui/left.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				new PathIcon("ui/right.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				CenterSpace.class
			);
			EditableGroup<Studio>studios=new EditableGroup<Studio>(
				new PathIcon("ui/left.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				new PathIcon("ui/right.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				Studio.class
			);
			EditableGroup<ExhibitionItem>exhibitionItems=new EditableGroup<ExhibitionItem>(
				new PathIcon("ui/left.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				new PathIcon("ui/right.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				ExhibitionItem.class
			);
			EditableGroup<Mentor>mentors=new EditableGroup<Mentor>(
				new PathIcon("ui/left.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				new PathIcon("ui/right.png",Root.SCREEN_SIZE.height/11,Root.SCREEN_SIZE.height/11),
				Mentor.class
			);
			ProgramStarter.runProgram();
			Registrator.register(spaces);
			Registrator.register(studios);
			Registrator.register(exhibitionItems);
			Registrator.register(mentors);
		}else ProgramStarter.runProgram();
	}
}