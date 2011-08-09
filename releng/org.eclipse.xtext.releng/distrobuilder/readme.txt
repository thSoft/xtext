What p2distro.sh do:
It installs all the IUs listed in the corresponding builder.properties into each of eclipse packages from targetplatforms folder.
It compress new eclipse IDEs 
It renames file names using DISTRO_SUFFIX and VERSION property, so i.e. eclipse-SDK-3.8-macosx-cocoa-x86_64.tar.gz became eclipse-SDK-3.8-Xtext-2.0.1-macosx-cocoa-x86_64.tar.gz


How to build a juno based distro.

In eclipse /org.eclipse.xtext.releng/distrobuilder:
Create ./juno folder first
create ./juno/builder.properties or copy existing i.e. indigo/builder.properties
edit ECLIPSE_REPOSITORY property if necessary i.e. http://download.eclipse.org/eclipse/updates/3.8/
push the changes with git

Prepare dependencies:
	-	If using hudson: Connect to kiel1 machine (sftp) path /home/hudson/build/distrobuilder
	-	If working local: use /org.eclipse.xtext.releng/distrobuilder
	Create ./juno/targetplatforms folder, copy juno packages to work with (i.e. eclipse-SDK-3.8-macosx-cocoa-x86_64.tar.gz)
	Now you can copy zipped p2.repositories that should be used during the build in ./juno/repositories, or you set REMOTE_REPOSITORIES property properly.

Start builder: 
	-	Local: run bash p2distro.sh -ECLIPSE_CODENAME=juno
	-	Hudson: start jon select juno as ECLIPSE_CODENAME

Script will create ./juno/output folder where new distro files are located