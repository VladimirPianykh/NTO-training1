package com.ntoproject;

import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import com.bpa4j.core.Data.EditableGroup;
import com.bpa4j.core.Navigator;
import com.bpa4j.PathIcon;
import com.bpa4j.core.ProgramStarter;
import com.bpa4j.core.Registrator;
import com.bpa4j.core.Root;
import com.bpa4j.core.User;
import com.bpa4j.core.User.Feature;
import com.bpa4j.core.User.Permission;
import com.bpa4j.core.User.Role;
import com.bpa4j.defaults.features.DefaultFeature;
import com.ntoproject.editables.ExhibitionItem;
import com.ntoproject.editables.Mentor;
import com.ntoproject.editables.CenterSpace;
import com.ntoproject.editables.space.Studio;

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