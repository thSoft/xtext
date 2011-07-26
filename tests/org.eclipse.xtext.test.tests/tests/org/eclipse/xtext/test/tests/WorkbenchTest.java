/**
 * 
 */
package org.eclipse.xtext.test.tests;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * @author huebner
 * 
 */
public class WorkbenchTest extends TestCase {
	private static final String TESTPROJECT_NAME = "releng.test";
	private Shell shell;
	private IWorkspace workspace;
	private IProject project;
	private final static Logger LOG = Logger.getLogger(WorkbenchTest.class
			.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		shell = PlatformUI.getWorkbench().getWorkbenchWindows()[0].getShell();
		workspace = ResourcesPlugin.getWorkspace();
		project = createPluginProject(new NullProgressMonitor(), shell,
				TESTPROJECT_NAME);
	}

	public void testWSProjectCreated() {
		assertNotNull(project);
		assertTrue(project.exists());
	}

	public void testCreateFile() {
		IFile createFile = createFile("someFile", project, "someContent",
				new NullProgressMonitor());
		assertNotNull(createFile);
		assertTrue(createFile.exists());
	}

	public void testPDEProject() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		deleteProject(project);
	}

	private void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			if (project.isOpen()) {
				project.close(null);
			}
			project.delete(true, true, null);
		}
	}

	protected IProject createPluginProject(IProgressMonitor monitor,
			Shell shell, String projectName) {
		IProject project = null;
		SubMonitor subMonitor = SubMonitor.convert(monitor, 10);
		try {
			final IProjectDescription projDescription = workspace
					.newProjectDescription(projectName);
			subMonitor.subTask("Creating project" + projDescription.getName());
			project = workspace.getRoot().getProject(projectName);
			project.create(projDescription, subMonitor.newChild(1));
			project.open(subMonitor.newChild(1));
			project.setDescription(projDescription, subMonitor.newChild(1));
		} catch (CoreException e) {
			LOG.log(Level.SEVERE, "Can't create eclipse project", e);
		} finally {
			subMonitor.done();
		}
		return project;
	}

	protected void setBuilder(final IProjectDescription projectDescription,
			final String... builders) {
		List<ICommand> commands = new ArrayList<ICommand>();
		for (int i = 0; i < builders.length; i++) {
			ICommand command = projectDescription.newCommand();
			command.setBuilderName(builders[i]);
			commands.add(command);
		}
		projectDescription.setBuildSpec(commands.toArray(new ICommand[commands
				.size()]));
	}

	protected IFile createFile(final String name, final IContainer container,
			final String content, final IProgressMonitor progressMonitor) {
		final IFile file = container.getFile(new Path(name));
		SubMonitor subMonitor = SubMonitor.convert(progressMonitor, 1);
		try {
			final InputStream stream = new ByteArrayInputStream(
					content.getBytes(file.getCharset()));
			if (file.exists()) {
				file.setContents(stream, true, true, subMonitor.newChild(1));
			} else {
				file.create(stream, true, subMonitor.newChild(1));
			}
			stream.close();
		} catch (final Exception e) {
			LOG.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			subMonitor.done();
		}
		return file;
	}
}
