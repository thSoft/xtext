/*
* generated by Xtext
*/
package org.eclipse.xtext.resource.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.resource.services.EObjectAtOffsetTestLanguageGrammarAccess;

public class EObjectAtOffsetTestLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private EObjectAtOffsetTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.xtext.resource.parser.antlr.internal.InternalEObjectAtOffsetTestLanguageParser createParser(XtextTokenStream stream) {
		return new org.eclipse.xtext.resource.parser.antlr.internal.InternalEObjectAtOffsetTestLanguageParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}
	
	public EObjectAtOffsetTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(EObjectAtOffsetTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
