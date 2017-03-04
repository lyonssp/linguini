package grammar

//import grammar.POS.POS
import grammar.Phoneme.Phoneme
import grammar.Stress.Stress

//Phonemes
object Phoneme extends Enumeration {
  type Phoneme = Value
  val
  AA,
  AE,
  AH,
  AO,
  AW,
  AY,
  B,
  CH,
  D,
  DH,
  EH,
  ER,
  EY,
  F,
  G,
  HH,
  IH,
  IY,
  JH,
  K,
  L,
  M,
  N,
  NG,
  OW,
  OY,
  P,
  R,
  S,
  SH,
  T,
  TH,
  UH,
  UW,
  V,
  W,
  Y,
  Z,
  ZH = Value
}

//Phoneme stress type
object Stress extends Enumeration {
  type Stress = Value
  val
  None,
  Primary,
  Secondary = Value
}

object StressedPhoneme {
  private val regex = "([a-zA-z]{1,2,3})([0-2])".r
  def fromString(str: String): StressedPhoneme = str match {
    case regex(phonemeString, stressNumber) => StressedPhoneme(
      Phoneme.withName(phonemeString),
      Stress.values.toList(stressNumber.toInt)
    )
  }
}

case class StressedPhoneme(p: Phoneme.Phoneme, stress: Stress.Stress)
case class Pronunciation(word: String, sps: Seq[StressedPhoneme])

/*
.	punctuation mark, sentence closer	.;?* 
,	punctuation mark, comma	, 
:	punctuation mark, colon	: 
(	contextual separator, left paren	( 
)
 */
object POS extends Enumeration {
  type POS = Value
  val
  CC,
  CD,
  DT,
  EX,
  FW,
  IN,
  JJ,
  JJR,
  JJS,
  LS,
  MD,
  NN,
  NNS,
  NNP,
  NNPS,
  PDT,
  POS,
  PRP,
  PRPS,
  RB,
  RBR,
  RBS,
  RP,
  SYM,
  TO,
  UH,
  VB,
  VBZ,
  VBP,
  VBD,
  VBN,
  VBG,
  WDT,
  WP,
  WPS,
  WRB,
  PERIOD,
  COMMA,
  COLON,
  LPAREN,
  RPAREN = Value
}

case class TaggedSentence(taggedWords: Seq[(String, POS.POS)])