package fr.opensagres.mongodb.ide.launching.internal;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.RefreshUtil;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

public class MongoDBLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		if (monitor.isCanceled()) {
			return;
		}
		// resolve location
		IPath location = new Path("D:\\MongoDB\\mongodb-win32-i386-2.0.2\\bin\\mongo");// ExternalToolsCoreUtil.getLocation(configuration);

		if (monitor.isCanceled()) {
			return;
		}

		// resolve arguments
		String[] arguments = {};//ExternalToolsCoreUtil.getArguments(configuration);

		if (monitor.isCanceled()) {
			return;
		}

		int cmdLineLength = 1;
		if (arguments != null) {
			cmdLineLength += arguments.length;
		}
		String[] cmdLine = new String[cmdLineLength];
		cmdLine[0] = location.toOSString();
		if (arguments != null) {
			System.arraycopy(arguments, 0, cmdLine, 1, arguments.length);
		}
		
		File workingDir = null;
		
		if (monitor.isCanceled()) {
			return;
		}

		String[] envp = DebugPlugin.getDefault().getLaunchManager()
				.getEnvironment(configuration);

		if (monitor.isCanceled()) {
			return;
		}
		Process p = DebugPlugin.exec(cmdLine, workingDir, envp);

		// refresh resources
		RefreshUtil.refreshResources(configuration, monitor);
	}

}
