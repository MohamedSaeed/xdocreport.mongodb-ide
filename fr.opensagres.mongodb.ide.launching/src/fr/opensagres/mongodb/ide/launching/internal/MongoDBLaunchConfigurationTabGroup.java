package fr.opensagres.mongodb.ide.launching.internal;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.sourcelookup.SourceLookupTab;

public class MongoDBLaunchConfigurationTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[4];
		tabs[0] = new ServerLaunchConfigurationTab();
		tabs[0].setLaunchConfigurationDialog(dialog);
//		tabs[1] = new JavaArgumentsTab();
//		tabs[1].setLaunchConfigurationDialog(dialog);
//		tabs[2] = new JavaClasspathTab();
//		tabs[2].setLaunchConfigurationDialog(dialog);
		tabs[1] = new SourceLookupTab();
		tabs[1].setLaunchConfigurationDialog(dialog);
		tabs[2] = new EnvironmentTab();
		tabs[2].setLaunchConfigurationDialog(dialog);
		tabs[3] = new CommonTab();
		tabs[3].setLaunchConfigurationDialog(dialog);
		setTabs(tabs);
	}

}
