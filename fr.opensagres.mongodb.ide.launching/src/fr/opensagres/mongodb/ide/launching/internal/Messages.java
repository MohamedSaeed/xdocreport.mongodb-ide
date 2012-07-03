package fr.opensagres.mongodb.ide.launching.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "fr.opensagres.mongodb.ide.launching.ui.internal.Messages";//$NON-NLS-1$

	// ****************** ServerLaunchConfigurationTab ******************

	public static String ServerLaunchConfigurationTab_name;

	static {
		// load message values from bundle file
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
