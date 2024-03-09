// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DATA=1, CODE=2, PRINT=3, INT=4, FLOAT=5, INT_LITERAL=6, FLOAT_LITERAL=7, 
		IDENT=8, PLUS=9, MULT=10, SUB=11, DIV=12, ASSIGNMENT=13, SEMICOLON=14, 
		OPEN_PARENTHESIS=15, CLOSE_PARENTHESIS=16, LINE_COMMENT=17, MULTILINE_COMMENT=18, 
		WHITESPACE=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DATA", "CODE", "PRINT", "INT", "FLOAT", "INT_LITERAL", "FLOAT_LITERAL", 
			"IDENT", "PLUS", "MULT", "SUB", "DIV", "ASSIGNMENT", "SEMICOLON", "OPEN_PARENTHESIS", 
			"CLOSE_PARENTHESIS", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DATA'", "'CODE'", "'print'", "'int'", "'float'", null, null, 
			null, "'+'", "'*'", "'-'", "'/'", "'='", "';'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DATA", "CODE", "PRINT", "INT", "FLOAT", "INT_LITERAL", "FLOAT_LITERAL", 
			"IDENT", "PLUS", "MULT", "SUB", "DIV", "ASSIGNMENT", "SEMICOLON", "OPEN_PARENTHESIS", 
			"CLOSE_PARENTHESIS", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0013\u008e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005"+
		"C\b\u0005\u000b\u0005\f\u0005D\u0001\u0006\u0004\u0006H\b\u0006\u000b"+
		"\u0006\f\u0006I\u0001\u0006\u0001\u0006\u0004\u0006N\b\u0006\u000b\u0006"+
		"\f\u0006O\u0001\u0007\u0001\u0007\u0005\u0007T\b\u0007\n\u0007\f\u0007"+
		"W\t\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010m\b\u0010\n\u0010\f\u0010p\t\u0010\u0001\u0010\u0003\u0010s\b\u0010"+
		"\u0001\u0010\u0003\u0010v\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011~\b\u0011\n\u0011\f\u0011"+
		"\u0081\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0004\u0012\u0089\b\u0012\u000b\u0012\f\u0012\u008a\u0001"+
		"\u0012\u0001\u0012\u0002n\u007f\u0000\u0013\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\u0001\u0000\u0005\u0001\u000009\u0002\u0000AZaz\u0004\u0000"+
		"09AZ__az\u0001\u0001\n\n\u0003\u0000\t\n\r\r  \u0095\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0001\'"+
		"\u0001\u0000\u0000\u0000\u0003,\u0001\u0000\u0000\u0000\u00051\u0001\u0000"+
		"\u0000\u0000\u00077\u0001\u0000\u0000\u0000\t;\u0001\u0000\u0000\u0000"+
		"\u000bB\u0001\u0000\u0000\u0000\rG\u0001\u0000\u0000\u0000\u000fQ\u0001"+
		"\u0000\u0000\u0000\u0011X\u0001\u0000\u0000\u0000\u0013Z\u0001\u0000\u0000"+
		"\u0000\u0015\\\u0001\u0000\u0000\u0000\u0017^\u0001\u0000\u0000\u0000"+
		"\u0019`\u0001\u0000\u0000\u0000\u001bb\u0001\u0000\u0000\u0000\u001dd"+
		"\u0001\u0000\u0000\u0000\u001ff\u0001\u0000\u0000\u0000!h\u0001\u0000"+
		"\u0000\u0000#y\u0001\u0000\u0000\u0000%\u0088\u0001\u0000\u0000\u0000"+
		"\'(\u0005D\u0000\u0000()\u0005A\u0000\u0000)*\u0005T\u0000\u0000*+\u0005"+
		"A\u0000\u0000+\u0002\u0001\u0000\u0000\u0000,-\u0005C\u0000\u0000-.\u0005"+
		"O\u0000\u0000./\u0005D\u0000\u0000/0\u0005E\u0000\u00000\u0004\u0001\u0000"+
		"\u0000\u000012\u0005p\u0000\u000023\u0005r\u0000\u000034\u0005i\u0000"+
		"\u000045\u0005n\u0000\u000056\u0005t\u0000\u00006\u0006\u0001\u0000\u0000"+
		"\u000078\u0005i\u0000\u000089\u0005n\u0000\u00009:\u0005t\u0000\u0000"+
		":\b\u0001\u0000\u0000\u0000;<\u0005f\u0000\u0000<=\u0005l\u0000\u0000"+
		"=>\u0005o\u0000\u0000>?\u0005a\u0000\u0000?@\u0005t\u0000\u0000@\n\u0001"+
		"\u0000\u0000\u0000AC\u0007\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000E\f\u0001\u0000\u0000\u0000FH\u0007\u0000\u0000\u0000GF\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0005.\u0000\u0000LN\u0007"+
		"\u0000\u0000\u0000ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u000e\u0001\u0000"+
		"\u0000\u0000QU\u0007\u0001\u0000\u0000RT\u0007\u0002\u0000\u0000SR\u0001"+
		"\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000V\u0010\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000XY\u0005+\u0000\u0000Y\u0012\u0001\u0000\u0000\u0000Z[\u0005"+
		"*\u0000\u0000[\u0014\u0001\u0000\u0000\u0000\\]\u0005-\u0000\u0000]\u0016"+
		"\u0001\u0000\u0000\u0000^_\u0005/\u0000\u0000_\u0018\u0001\u0000\u0000"+
		"\u0000`a\u0005=\u0000\u0000a\u001a\u0001\u0000\u0000\u0000bc\u0005;\u0000"+
		"\u0000c\u001c\u0001\u0000\u0000\u0000de\u0005(\u0000\u0000e\u001e\u0001"+
		"\u0000\u0000\u0000fg\u0005)\u0000\u0000g \u0001\u0000\u0000\u0000hi\u0005"+
		"/\u0000\u0000ij\u0005/\u0000\u0000jn\u0001\u0000\u0000\u0000km\t\u0000"+
		"\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000qs\u0005\r\u0000\u0000rq\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000\u0000tv\u0007\u0003\u0000"+
		"\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0006\u0010"+
		"\u0000\u0000x\"\u0001\u0000\u0000\u0000yz\u0005/\u0000\u0000z{\u0005*"+
		"\u0000\u0000{\u007f\u0001\u0000\u0000\u0000|~\t\u0000\u0000\u0000}|\u0001"+
		"\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000"+
		"\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0005*\u0000\u0000"+
		"\u0083\u0084\u0005/\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0006\u0011\u0000\u0000\u0086$\u0001\u0000\u0000\u0000\u0087\u0089"+
		"\u0007\u0004\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0006\u0012\u0000\u0000\u008d&\u0001\u0000\u0000\u0000\n\u0000DIOUnr"+
		"u\u007f\u008a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}