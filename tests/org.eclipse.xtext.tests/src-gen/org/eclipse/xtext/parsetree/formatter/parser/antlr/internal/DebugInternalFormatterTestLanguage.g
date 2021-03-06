/*
* generated by Xtext
*/
grammar DebugInternalFormatterTestLanguage ;

// Rule Root
ruleRoot :
	'test' (
		ruleTestLinewrap |
		ruleTestIndentation |
		ruleTestLinewrapMinMax |
		ruleWrappingDataTypeTest
	)
;

// Rule Line
ruleLine :
	(
		ruleDecl |
		ruleAssign |
		ruleMeth |
		ruleFqnObj |
		ruleFqnRef |
		ruleEnumeration |
		ruleSuppressedHidden 'post' |
		ruleSpace |
		ruleDatatypes
	) ';'
;

// Rule Decl
ruleDecl :
	RULE_ID RULE_ID
;

// Rule Assign
ruleAssign :
	RULE_ID (
		'=' |
		'+='
	) '[' (
		RULE_INT (
			',' RULE_INT
		)*
	)? ']'
;

// Rule Meth
ruleMeth :
	'void' RULE_ID '(' (
		ruleParam (
			',' ruleParam
		)*
	)? ')'
;

// Rule Param
ruleParam :
	RULE_ID ':' RULE_ID
;

// Rule Space
ruleSpace :
	'space' RULE_ID
;

// Rule TestLinewrap
ruleTestLinewrap :
	'linewrap' ruleLine*
;

// Rule TestLinewrapMinMax
ruleTestLinewrapMinMax :
	'wrapminmax' ruleLine*
;

// Rule TestIndentation
ruleTestIndentation :
	'indentation' '{' (
		ruleLine |
		ruleTestIndentation
	)* '}' ';'?
;

// Rule FqnObj
ruleFqnObj :
	'fqn' ruleFQN
;

// Rule FQN
ruleFQN :
	RULE_ID (
		'.' RULE_ID
	)*
;

// Rule FqnRef
ruleFqnRef :
	'fqnref' ruleFQN
;

// Rule Enumeration
ruleEnumeration :
	'enum' ruleEnum1+ (
		',' ruleEnum1
	)*
;

// Rule SuppressedHidden
ruleSuppressedHidden :
	'`' (
		ruleSuppressedHiddenSub (
			'%' ruleSuppressedHiddenSub
		)*
	)? '`'
;

// Rule SuppressedHiddenSub
ruleSuppressedHiddenSub :
	ruleSuppressedHiddenSubSub |
	ruleSuppressedHiddenSubID
;

// Rule SuppressedHiddenSubSub
ruleSuppressedHiddenSubSub :
	'<' RULE_ID '>'
;

// Rule SuppressedHiddenSubID
ruleSuppressedHiddenSubID :
	RULE_ID
;

// Rule Datatype1
ruleDatatype1 :
	ruleFQN
;

// Rule Datatype2
ruleDatatype2 :
	ruleFQN
;

// Rule Datatype3
ruleDatatype3 :
	ruleFQN
;

// Rule Datatypes
ruleDatatypes :
	'datatypes' ruleDatatype1 'kw1' ruleDatatype2 ruleDatatype3 'kw3'
;

// Rule WrappingDataTypeTest
ruleWrappingDataTypeTest :
	'wrappingdt' ruleWrappingDataType 'kw1'
;

// Rule WrappingDataType
ruleWrappingDataType :
	RULE_ID+
;

// Rule Enum1
ruleEnum1 :
	'lit1' |
	'lit2' |
	'lit3'
;

RULE_ID :
	'^'? (
		'a' .. 'z' |
		'A' .. 'Z' |
		'_'
	) (
		'a' .. 'z' |
		'A' .. 'Z' |
		'_' |
		'0' .. '9'
	)*
;

RULE_INT :
	'0' .. '9'+
;

RULE_STRING :
	'"' (
		'\\' (
			'b' |
			't' |
			'n' |
			'f' |
			'r' |
			'u' |
			'"' |
			'\'' |
			'\\'
		) |
		~ (
			'\\' |
			'"'
		)
	)* '"' |
	'\'' (
		'\\' (
			'b' |
			't' |
			'n' |
			'f' |
			'r' |
			'u' |
			'"' |
			'\'' |
			'\\'
		) |
		~ (
			'\\' |
			'\''
		)
	)* '\''
;

RULE_ML_COMMENT :
	'/*' (
		options { greedy = false ; } : .
	)* '*/' {skip();}
;

RULE_SL_COMMENT :
	'//' ~ (
		'\n' |
		'\r'
	)* (
		'\r'? '\n'
	)? {skip();}
;

RULE_WS :
	(
		' ' |
		'\t' |
		'\r' |
		'\n'
	)+ {skip();}
;

RULE_ANY_OTHER :
	.
;