package generator;

import generator.AbstractWebsite;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ReleaseNotes extends AbstractWebsite {
  public String path() {
    return "releasenotes.html";
  }
  
  protected boolean isPrettyPrint() {
    return true;
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    CharSequence _headline = this.headline("Release Notes - Version 2.5.0 (December 2013)");
    _builder.append(_headline, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<div id=\"page\">");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<div class=\"container clearfix\">");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<h2>Xtext 2.5.0 Release Notes (December 11th, 2013)</h2>");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<hr>");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<div class=\"span1\">&nbsp;</div>");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("<div class=\"span9\">");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("Xtext 2.5.0 includes ");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<a href=\"https://bugs.eclipse.org/bugs/buglist.cgi?f1=OP&list_id=7722745&f0=OP&status_whiteboard_type=allwordssubstr&f4=CP&query_format=advanced&j1=OR&f3=CP&status_whiteboard=v2.5&bug_status=RESOLVED&bug_status=VERIFIED&bug_status=CLOSED\">more than 100 bug fixes and enhancements</a>.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("Some of the more important enhancements are :");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("<section id=\"annotations_2_5\" style=\"padding-top: 68px; margin-top: -68px;\">");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<h2>Better Maven Support</h2>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Xtext 2.5.0 comes with much improved support for integrating Xtext languages and the corresponding code generators in ");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("continuous integration builds. All the needed jars are available on Maven central now and we have added a dedicated Maven compiler plug-in that ");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("simulates the incremental build in a headless Java Maven build (no Tycho needed!). Please read the <a href=\"documentation.html#continuousIntegration\">new section in the documentation</a> for more ");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("details on the new Maven support.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<pre class=\"prettyprint xml linenums\">");
    _builder.newLine();
    _builder.append("&lt;plugin&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;groupId&gt;org.eclipse.xtext&lt;/groupId&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;artifactId&gt;xtext-maven-plugin&lt;/artifactId&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;version&gt;2.5.0&lt;/version&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;executions&gt;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("&lt;execution&gt;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("&lt;goals&gt;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("&lt;goal&gt;generate&lt;/goal&gt;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("&lt;/goals&gt;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("&lt;/execution&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;/executions&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;configuration&gt;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("&lt;languages&gt;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("&lt;language&gt;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("&lt;setup&gt;my.mavenized.HeroLanguageStandaloneSetup&lt;/setup&gt;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("&lt;outputConfigurations&gt;");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("&lt;outputConfiguration&gt;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("&lt;outputDirectory&gt;src/main/generated-sources/xtend/&lt;/outputDirectory&gt;");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("&lt;/outputConfiguration&gt;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("&lt;/outputConfigurations&gt;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("&lt;/language&gt;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("&lt;/languages&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;/configuration&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;dependencies&gt;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("&lt;dependency&gt;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("&lt;groupId&gt;my.mavenized.herolanguage&lt;/groupId&gt;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("&lt;artifactId&gt;my.mavenized.herolanguage&lt;/artifactId&gt;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("&lt;version&gt;1.0.0-SNAPSHOT&lt;/version&gt;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("&lt;/dependency&gt;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("&lt;/dependencies&gt;");
    _builder.newLine();
    _builder.append("&lt;/plugin&gt;\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</pre>");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("</section>");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("<section id=\"annotations_2_5\" style=\"padding-top: 68px; margin-top: -68px;\">");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("</section>");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("<section id=\"compilerchecks\" style=\"padding-top: 68px; margin-top: -68px;\">");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<h2>Enhancements for Xbase</h2>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("The Xbase language and compiler has been improved in many ways.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<h3>Full support for Annotations</h3>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Xbase now supports all annotation values and constant expressions in annotations.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<pre class=\"prettyprint lang-xtend linenums\">");
    _builder.newLine();
    _builder.append("class MyEntity {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@Columns(#[@Column(\'id\'), @Column(value = \'timestamp\', length = 2 * 3 * 7)])");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("CompositeKey key");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</pre>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<h3 id=\"ambiguous_methods\">Method overload validation</h3>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Ambiguous method invocations are checked and reported with a detailled message.");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("The compiler optionally detects valid but suspiciously overloaded methods");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("that could be implemented by accident. This is especially handy when property access and ");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("extension methods come into play.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Here\'s an example how it is used within Xtend.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<pre class=\"prettyprint lang-xtend linenums\">");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def isCheck() {..}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class B extends A {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("* Ambiguous feature call.");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("* The methods");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("* \tgetCheck() in B and");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("* \tisCheck() in A");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("* both match.");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("*/ ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.check");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def getCheck() {..}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</pre>");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("<em>Important note:</em>");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("You have to make sure to use the library in version 2.5 along with the introduced compiler checks.");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<h3 id=\"ambiguous_methods\">Discouraged variable names</h3>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Some variable names are used implicitely by Xtend, for example the variable name \'self\'.");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("The compiler optionally reports if these names were picked manually.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<h3 id=\"improved_auto_casts\">Auto casts</h3>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("Xbase supported auto-casts right from the beginning with its powerful switch expression.");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("In 2.5, the more familiar syntax with instance-of checks caught up and also applies automatic");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("casts in if expressions and while loops. ");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<pre class=\"prettyprint lang-xtend linenums\">");
    _builder.newLine();
    _builder.append("if (c instanceof String) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("c.substring(42)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</pre>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<h3 id=\"switch_enum\">Switch over enums</h3>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("One of the few places where Xbase\'s syntax could be improved compared to Java, was a switch expression");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("over enumeration values. Now it\'s no longer necessary to use a qualified name or static imports for the enum values but");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("the literals are available automatically for the case guards.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<pre class=\"prettyprint lang-xtend linenums\">");
    _builder.newLine();
    _builder.append("switch p {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("case CLASS: 1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("case RUNTIME: 2");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("case SOURCE: 3");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</pre> ");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<h3>Improved type inference with primitive values</h3>");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("The local type inference has been improved when primitive types are involved. Their wrapper");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("types will be used in fewer cases which prevents unexpected exceptions at runtime.");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("An optional compiler check can point to places where primitive defaults are used rather than");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("explicit values.");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("</section>");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<div class=\"span1\">&nbsp;</div>  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
}
