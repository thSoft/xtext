/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import java.io.InputStream;
import java.net.URI;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeGenerationContextImpl implements CodeGenerationContext {
  private MutableFileSystemSupport _fileSystemSupport;
  
  public MutableFileSystemSupport getFileSystemSupport() {
    return this._fileSystemSupport;
  }
  
  public void setFileSystemSupport(final MutableFileSystemSupport fileSystemSupport) {
    this._fileSystemSupport = fileSystemSupport;
  }
  
  private FileLocations _fileLocations;
  
  public FileLocations getFileLocations() {
    return this._fileLocations;
  }
  
  public void setFileLocations(final FileLocations fileLocations) {
    this._fileLocations = fileLocations;
  }
  
  public boolean delete(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.delete(path);
  }
  
  public boolean mkdir(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.mkdir(path);
  }
  
  public void setContents(final Path path, final CharSequence contents) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    _fileSystemSupport.setContents(path, contents);
  }
  
  public void setContentsAsStream(final Path path, final InputStream stream) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    _fileSystemSupport.setContentsAsStream(path, stream);
  }
  
  public boolean exists(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.exists(path);
  }
  
  public String getCharset(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.getCharset(path);
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.getChildren(path);
  }
  
  public CharSequence getContents(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.getContents(path);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.getContentsAsStream(path);
  }
  
  public long getLastModification(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.getLastModification(path);
  }
  
  public Path getProjectFolder(final Path path) {
    FileLocations _fileLocations = this.getFileLocations();
    return _fileLocations.getProjectFolder(path);
  }
  
  public Path getSourceFolder(final Path path) {
    FileLocations _fileLocations = this.getFileLocations();
    return _fileLocations.getSourceFolder(path);
  }
  
  public Path getTargetFolder(final Path sourceFolder) {
    FileLocations _fileLocations = this.getFileLocations();
    return _fileLocations.getTargetFolder(sourceFolder);
  }
  
  public boolean isFile(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.isFile(path);
  }
  
  public boolean isFolder(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.isFolder(path);
  }
  
  public URI toURI(final Path path) {
    MutableFileSystemSupport _fileSystemSupport = this.getFileSystemSupport();
    return _fileSystemSupport.toURI(path);
  }
}
