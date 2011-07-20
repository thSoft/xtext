package org.eclipse.xtext.purexbase.generator;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PureXbaseGenerator implements IGenerator {
  
  @Inject
  private XbaseCompiler compiler;
  
  @Inject
  private TypeReferences typeReferences;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    String _name = this.name(resource);
    String _operator_plus = StringExtensions.operator_plus(_name, ".java");
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    StringConcatenation _generateMain = this.generateMain(((Model) _head));
    fsa.generateFile(_operator_plus, _generateMain);
  }
  
  public String name(final Resource res) {
    {
      URI _uRI = res.getURI();
      String _lastSegment = _uRI.lastSegment();
      final String s = _lastSegment;
      int _length = s.length();
      int _length_1 = ".xbase".length();
      int _operator_minus = IntegerExtensions.operator_minus(((Integer)_length), ((Integer)_length_1));
      String _substring = s.substring(0, _operator_minus);
      return _substring;
    }
  }
  
  public StringConcatenation generateMain(final Model m) {
    StringConcatenation _xblockexpression = null;
    {
      ImportManager _importManager = new ImportManager(true);
      final ImportManager impMnr = _importManager;
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(impMnr);
      final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
      XBlockExpression _block = m.getBlock();
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName("void", m);
      this.compiler.compile(_block, appendable, _typeForName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\u00B4impMnr.imports.map(e | \'import \' + e + \';\\n\').join()\u00AA");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@SuppressWarnings(\"all\")");
      _builder.newLine();
      _builder.append("public class \u00B4m.eResource.name\u00AA {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\u00B4appendable\u00AA");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}