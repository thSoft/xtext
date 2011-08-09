How to use:

You would like to build a juno based distro.
Create ./juno folder first
create ./juno/builder.properties or copy existing i.e. indigo/builder.properties
edit ECLIPSE_REPOSITORY property if necessary i.e. http://download.eclipse.org/eclipse/updates/3.8/
push the changes with git

Connect to kiel1 machine (sftp) path /home/hudson/build/distrobuilder

Create ./juno/targetplatforms folder, copy juno packages to work with (i.e. eclipse-SDK-3.8-macosx-cocoa-x86_64.tar.gz)
Now you can copy zipped p2.repositories that should be used during the build in ./juno/repositories, or you set REMOTE_REPOSITORIES properly.

run bash p2distro.sh -ECLIPSE_CODENAME=juno

Script will create ./juno/output folder where new distro files are located