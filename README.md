<p>
<i>This file is auto generated. Any changes made to it will disappear with next build.</i>
</p>
<p>
<a href="https://github.com/blinfo/RegularExpressions/wiki"><b>Wiki page</b></a>
</p>
<a name="toc"> </a>
# Regular Expressions 

  * <a href="#single-digit">Single digit</a>
  * <a href="#single-non-digit">Single non digit</a>
  * <a href="#single-dot">Single dot</a>
  * <a href="#single-hyphen">Single hyphen</a>
  * <a href="#zero-or-more-digits">Zero or more digits</a>
  * <a href="#zero-or-one-digit">Zero or one digit</a>
  * <a href="#one-or-more-digits">One or more digits</a>
  * <a href="#three-digits">Three digits</a>
  * <a href="#three-or-more-digits">Three or more digits</a>
  * <a href="#three-to-five-digits">Three to five digits</a>
  * <a href="#hexadecimal">Hexadecimal</a>
  * <a href="#negative-or-positive-integer">Negative or positive integer</a>
  * <a href="#zero-or-negative-or-positive-integer">Zero or negative or positive integer</a>
  * <a href="#zero-or-negative-or-positive-float">Zero or negative or positive float</a>
  * <a href="#negative-or-positive-float-or-integer">Negative or positive float or integer</a>
  * <a href="#one-english-letter-et-al">One English letter et al</a>
  * <a href="#one-swedish-letter">One Swedish letter</a>
  * <a href="#some-specific-letters">Some specific letters</a>
  * <a href="#consonants">Consonants</a>
  * <a href="#dot---any-character-but-new-line">Dot - Any character but new line</a>
  * <a href="#single-white-space">Single white space</a>
  * <a href="#single-non-white-space">Single non white space</a>
  * <a href="#new-line">New line</a>
  * <a href="#single-white-space-or-digit">Single white space or digit</a>
  * <a href="#role-playing-die">Role playing die</a>
  * <a href="#role-playing-die-with-grouping">Role playing die with grouping</a>
  * <a href="#date---a-fairly-good-match">Date - a fairly good match</a>
  * <a href="#iso-date">ISO-Date</a>
  * <a href="#swedish-social-security-number---initial-attempt">Swedish social security number - Initial attempt</a>
  * <a href="#swedish-social-security-number---improved">Swedish social security number - Improved</a>
  * <a href="#email-address---a-pretty-simple-example">Email address - A pretty simple example</a>
  * <a href="#swedish-car-number">Swedish car number</a>


---

<a name="single-digit"> </a>
### Single digit

**Expression**: `\\d`

**Alternative**: `[0-9]`

Matches exactly one digit.

  _Matches:_

  * true	"1"
  * true	"7"

  _Non Matches:_

  * false	"a"
  * false	"P"
  * false	"@"
  * false	"11"

With alternative writing:

  _Matches:_

  * true	"1"
  * true	"7"

  _Non Matches:_

  * false	"a"
  * false	"P"
  * false	"@"
  * false	"11"


<a href="#toc">^</a>

---

<a name="single-non-digit"> </a>
### Single non digit

**Expression**: `\\D`

**Alternative**: `[^0-9]`

Matches exactly one character which can not be a digit. The circumflex as the first character in the brackets means "NOT"

  _Matches:_

  * true	"a"
  * true	"P"
  * true	"@"
  * true	"."

  _Non Matches:_

  * false	"1"
  * false	"7"
  * false	"pt"

With alternative writing:

  _Matches:_

  * true	"a"
  * true	"P"
  * true	"@"
  * true	"."

  _Non Matches:_

  * false	"1"
  * false	"7"
  * false	"pt"


<a href="#toc">^</a>

---

<a name="single-dot"> </a>
### Single dot

**Expression**: `\\.`

Matches exactly one dot (.). The dot is a meta character and must be escaped.

  _Matches:_

  * true	"."

  _Non Matches:_

  * false	"1"
  * false	","
  * false	".."



<a href="#toc">^</a>

---

<a name="single-hyphen"> </a>
### Single hyphen

**Expression**: `\\-`

**Alternative**: `[-]`

Matches exactly one hyphen or minus (-). The minus sign is a meta character and must be escaped unless it occurs first or last in a square bracket group: "[-+a-z]" which matches plus, minus or lower case letters a through z, or "[0-5-]" which matches a minus or number zero through five.

  _Matches:_

  * true	"-"

  _Non Matches:_

  * false	"?"
  * false	"_"
  * false	"--"

With alternative writing:

  _Matches:_

  * true	"-"

  _Non Matches:_

  * false	"?"
  * false	"_"
  * false	"--"


<a href="#toc">^</a>

---

<a name="zero-or-more-digits"> </a>
### Zero or more digits

**Expression**: `\\d*`

**Alternative**: `[0-9]{0,}`

Matches zero or more digits.

  _Matches:_

  * true	""
  * true	"7"
  * true	"1798451451"

  _Non Matches:_

  * false	"a"
  * false	"P"
  * false	"@"

With alternative writing:

  _Matches:_

  * true	""
  * true	"7"
  * true	"1798451451"

  _Non Matches:_

  * false	"a"
  * false	"P"
  * false	"@"


<a href="#toc">^</a>

---

<a name="zero-or-one-digit"> </a>
### Zero or one digit

**Expression**: `\\d?`

**Alternative**: `\\d{0,1}`

Matches zero or one digit.

  _Matches:_

  * true	""
  * true	"7"
  * true	"4"

  _Non Matches:_

  * false	"a"
  * false	"11"
  * false	"957"

With alternative writing:

  _Matches:_

  * true	""
  * true	"7"
  * true	"4"

  _Non Matches:_

  * false	"a"
  * false	"11"
  * false	"957"


<a href="#toc">^</a>

---

<a name="one-or-more-digits"> </a>
### One or more digits

**Expression**: `\\d+`

**Alternative**: `[0-9]{1,}`

Matches one or more digits.

  _Matches:_

  * true	"0"
  * true	"14"
  * true	"18155111"

  _Non Matches:_

  * false	"a"
  * false	"P"
  * false	"@"

With alternative writing:

  _Matches:_

  * true	"0"
  * true	"14"
  * true	"18155111"

  _Non Matches:_

  * false	"a"
  * false	"P"
  * false	"@"


<a href="#toc">^</a>

---

<a name="three-digits"> </a>
### Three digits

**Expression**: `\\d{3}`

**Alternative**: `[0-9]{3}`

Matches exactly three digits.

  _Matches:_

  * true	"123"
  * true	"789"
  * true	"048"

  _Non Matches:_

  * false	"1"
  * false	"22"
  * false	"1234"
  * false	"a"
  * false	""

With alternative writing:

  _Matches:_

  * true	"123"
  * true	"789"
  * true	"048"

  _Non Matches:_

  * false	"1"
  * false	"22"
  * false	"1234"
  * false	"a"
  * false	""


<a href="#toc">^</a>

---

<a name="three-or-more-digits"> </a>
### Three or more digits

**Expression**: `\\d{3,}`

**Alternative**: `[0-9]{3,}`

Matches three or more digits.

  _Matches:_

  * true	"123"
  * true	"4567"
  * true	"1215854521"

  _Non Matches:_

  * false	"a"
  * false	"1"
  * false	"83"
  * false	"a42"

With alternative writing:

  _Matches:_

  * true	"123"
  * true	"4567"
  * true	"1215854521"

  _Non Matches:_

  * false	"a"
  * false	"1"
  * false	"83"
  * false	"a42"


<a href="#toc">^</a>

---

<a name="three-to-five-digits"> </a>
### Three to five digits

**Expression**: `\\d{3,5}`

**Alternative**: `[0-9]{3,5}`

Matches three through five digits.

  _Matches:_

  * true	"123"
  * true	"4567"
  * true	"89012"

  _Non Matches:_

  * false	"12"
  * false	"345678"
  * false	"text"

With alternative writing:

  _Matches:_

  * true	"123"
  * true	"4567"
  * true	"89012"

  _Non Matches:_

  * false	"12"
  * false	"345678"
  * false	"text"


<a href="#toc">^</a>

---

<a name="hexadecimal"> </a>
### Hexadecimal

**Expression**: `[\\da-fA-F]`

**Alternative**: `[0-9a-fA-F]`

Matches one hexadecimal.

  _Matches:_

  * true	"1"
  * true	"8"
  * true	"A"
  * true	"f"

  _Non Matches:_

  * false	""
  * false	"11"
  * false	"G"
  * false	"h"

With alternative writing:

  _Matches:_

  * true	"1"
  * true	"8"
  * true	"A"
  * true	"f"

  _Non Matches:_

  * false	""
  * false	"11"
  * false	"G"
  * false	"h"


<a href="#toc">^</a>

---

<a name="negative-or-positive-integer"> </a>
### Negative or positive integer

**Expression**: `[+\\-]?\\d+`

**Alternative**: `[-+]?[0-9]{1,}`

Matches negative or positive integer of one or more digits. To use a minus (hyphen) in a group you can put it as the first character in the group, the first character after a negating circumflex, the last character before the closing bracket or escape it.

  _Matches:_

  * true	"0"
  * true	"-19"
  * true	"4"
  * true	"-534"
  * true	"+24"
  * true	"-0"

  _Non Matches:_

  * false	"-"
  * false	"1+1"
  * false	"-11.2"
  * false	""

With alternative writing:

  _Matches:_

  * true	"0"
  * true	"-19"
  * true	"4"
  * true	"-534"
  * true	"+24"
  * true	"-0"

  _Non Matches:_

  * false	"-"
  * false	"1+1"
  * false	"-11.2"
  * false	""


<a href="#toc">^</a>

---

<a name="zero-or-negative-or-positive-integer"> </a>
### Zero or negative or positive integer

**Expression**: `0|[-+]?[1-9]\\d{0,}`

Matches number zero or a negative or positive non zero of one or more digits.

  _Matches:_

  * true	"0"
  * true	"-19"
  * true	"4"
  * true	"-534"
  * true	"+24"

  _Non Matches:_

  * false	"-"
  * false	"-0"
  * false	"1+1"
  * false	"-11.2"
  * false	""



<a href="#toc">^</a>

---

<a name="zero-or-negative-or-positive-float"> </a>
### Zero or negative or positive float

**Expression**: `0|[-+]?\\d+\\.\\d+`

Matches number zero or a negative or positive float (non zero) with required zero before floating point.

  _Matches:_

  * true	"0.1"
  * true	"-19.0"
  * true	"4.0154"
  * true	"-0.534"
  * true	"+0.24"

  _Non Matches:_

  * false	"-"
  * false	"4"
  * false	"-0"
  * false	"1+1"
  * false	"-11,2"
  * false	""
  * false	"1.2.43"



<a href="#toc">^</a>

---

<a name="negative-or-positive-float-or-integer"> </a>
### Negative or positive float or integer

**Expression**: `[-+]?\\d*\\.?\\d+`

Matches negative or positive float or integer with optional zero before floating point.

  _Matches:_

  * true	"0.1"
  * true	".5"
  * true	"-19.0"
  * true	"3.13159"
  * true	"-0.534"
  * true	"+0.24"
  * true	"-.4334546"
  * true	"11"
  * true	"0"

  _Non Matches:_

  * false	"-"
  * false	"a4"
  * false	"1+1"
  * false	"-11,2"
  * false	"1+"
  * false	"1.2.43"



<a href="#toc">^</a>

---

<a name="one-english-letter-et-al"> </a>
### One English letter et al

**Expression**: `\\w`

**Alternative**: `[a-zA-Z_0-9]`

Matches one English letter, one digit or underscore. This character class is highly unreliable so the alternative writing is to be preferred.

  _Matches:_

  * true	"a"
  * true	"Z"
  * true	"y"
  * true	"_"
  * true	"8"

  _Non Matches:_

  * false	"å"
  * false	"$"
  * false	"tr"
  * false	"ä"

With alternative writing:

  _Matches:_

  * true	"a"
  * true	"Z"
  * true	"y"
  * true	"_"
  * true	"8"

  _Non Matches:_

  * false	"å"
  * false	"$"
  * false	"tr"
  * false	"ä"


<a href="#toc">^</a>

---

<a name="one-swedish-letter"> </a>
### One Swedish letter

**Expression**: `[a-zA-ZåäöÅÄÖ]`

Matches one Swedish letter.

  _Matches:_

  * true	"Ä"
  * true	"z"
  * true	"W"
  * true	"ö"

  _Non Matches:_

  * false	"é"
  * false	"à"
  * false	"ł"
  * false	"ß"



<a href="#toc">^</a>

---

<a name="some-specific-letters"> </a>
### Some specific letters

**Expression**: `[0-9a-fQXZ£€$]`

Matches digit, lower case letters a through f, upper case letters Q, X or Z and money symbols £, € and $.

  _Matches:_

  * true	"a"
  * true	"9"
  * true	"Z"
  * true	"$"
  * true	"€"

  _Non Matches:_

  * false	"A"
  * false	"x"
  * false	"y"
  * false	"¥"



<a href="#toc">^</a>

---

<a name="consonants"> </a>
### Consonants

**Expression**: `[a-zA-Z&&[^aeiouyAEIOUY]]`

**Alternative**: `[b-df-hj-np-tv-xzB-DF-HJ-NP-TV-XZ]`

Matches all consonants but no wovels

  _Matches:_

  * true	"b"
  * true	"Q"
  * true	"Z"
  * true	"v"
  * true	"L"

  _Non Matches:_

  * false	"A"
  * false	"e"
  * false	"y"
  * false	"O"

With alternative writing:

  _Matches:_

  * true	"b"
  * true	"Q"
  * true	"Z"
  * true	"v"
  * true	"L"

  _Non Matches:_

  * false	"A"
  * false	"e"
  * false	"y"
  * false	"O"


<a href="#toc">^</a>

---

<a name="dot---any-character-but-new-line"> </a>
### Dot - Any character but new line

**Expression**: `.`

Matches any character that is not a new line. The non matching characters in the example below are \\r\\n, \\r, \\n

  _Matches:_

  * true	"b"
  * true	"Q"
  * true	"?"
  * true	"!"
  * true	"@"
  * true	"¡"
  * true	"1"
  * true	"8"

  _Non Matches:_

  * false	"
"
  * false	""
  * false	"
"



<a href="#toc">^</a>

---

<a name="single-white-space"> </a>
### Single white space

**Expression**: `\\s`

Matches whitespace characters, like new line, carriage return, tab and space. The matching characters in the example below are \\r\\n, \\r, \\n, space and \\f

  _Matches:_

  * true	"
"
  * true	""
  * true	"	"
  * true	" "
  * true	""

  _Non Matches:_

  * false	""
  * false	"x"



<a href="#toc">^</a>

---

<a name="single-non-white-space"> </a>
### Single non white space

**Expression**: `\\S`

**Alternative**: `[^\\s]`

Matches non whitespace characters, like letter, digit or other symbol. The non matching characters in the example below are \\r, \\n, \\t, space and \\f

  _Matches:_

  * true	"a"
  * true	"x"
  * true	"Ö"
  * true	"+"
  * true	"0"
  * true	"&"
  * true	"¥"

  _Non Matches:_

  * false	"
"
  * false	""
  * false	"	"
  * false	" "
  * false	""

With alternative writing:

  _Matches:_

  * true	"a"
  * true	"x"
  * true	"Ö"
  * true	"+"
  * true	"0"
  * true	"&"
  * true	"¥"

  _Non Matches:_

  * false	"
"
  * false	""
  * false	"	"
  * false	" "
  * false	""


<a href="#toc">^</a>

---

<a name="new-line"> </a>
### New line

**Expression**: `\\R`

**Alternative**: `\\r?\\n`

Matches new line both in windows and unix-like os (mac). Windows uses CRLF (\\r\\n) while other uses only LF (\\n). The strings that matches below are \\n and \\r\\n, the non-matching strings are \\n\\r and \\t.

  _Matches:_

  * true	"
"
  * true	"
"

  _Non Matches:_

  * false	"
"
  * false	"	"

With alternative writing:

  _Matches:_

  * true	"
"
  * true	"
"

  _Non Matches:_

  * false	"
"
  * false	"	"


<a href="#toc">^</a>

---

<a name="single-white-space-or-digit"> </a>
### Single white space or digit

**Expression**: `[\\s\\d]`

Matches whitespace characters, like new line, carriage return, tab and space and a digit.

  _Matches:_

  * true	"
"
  * true	""
  * true	"	"
  * true	" "
  * true	"1"
  * true	"9"

  _Non Matches:_

  * false	""
  * false	"x"
  * false	"11"
  * false	"A"



<a href="#toc">^</a>

---

<a name="role-playing-die"> </a>
### Role playing die

**Expression**: `\\d+[dDtT]\\d+([-+]?\\d*)?`

Matches the typical role playing die pattern: 3D6+2, 1D3-1, 4D8 and the Swedish model 4T6. Does not care about the number of sides of the typical dice.

  _Matches:_

  * true	"2D6"
  * true	"4d8"
  * true	"1T20"
  * true	"5D4+5"
  * true	"1D100"
  * true	"9D2-9"

  _Non Matches:_

  * false	"D10"
  * false	"2C4"
  * false	"11"



<a href="#toc">^</a>

---

<a name="role-playing-die-with-grouping"> </a>
### Role playing die with grouping

**Expression**: `(\\d+)[dDtT](\\d+)([-+]?)(\\d*)`

Almost the same as <a href="#role-playing-die">the previous</a>, but with grouping for parsing like in the <a href="./src/main/java/se/blinfo/regexp/sample/ImprovedRolePlayingDieParser.java">ImprovedRolePlayingDieParser</a> or the javascript version, <a href="./src/main/resources/sample/role-playing-dice-parser.js">role-playing-dice-parser.js</a>.

  _Matches:_

  * true	"2D6"
  * true	"4d8"
  * true	"1T20"
  * true	"5D4+5"
  * true	"1D100"
  * true	"9D2-9"

  _Non Matches:_

  * false	"D10"
  * false	"2C4"
  * false	"11"



<a href="#toc">^</a>

---

<a name="date---a-fairly-good-match"> </a>
### Date - a fairly good match

**Expression**: `(19|20)\\d{2}[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])`

A fairly good matching of dates. It does not handel the number of days for each month and consequently not leap years. Thus an invalid date like "1997-02-31" will still match. To add another century, add a it to the start of the expression: "(18|19|20)\\d{2}", which would place the failed date "1874-11-15" within the range for the expression and make it match.

  _Matches:_

  * true	"1920-12-31"
  * true	"2037-11-19"
  * true	"2000-01-01"
  * true	"1968/08/19"
  * true	"1997 02 31"

  _Non Matches:_

  * false	"1874-11-15"
  * false	"1989-13-01"
  * false	"2084-11-00"



<a href="#toc">^</a>

---

<a name="iso-date"> </a>
### ISO-Date

**Expression**: `(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])`

The same <a href="#date---a-fairly-good-match">as above</a> but only for ISO-date (ISO 8601 - yyyy-mm-dd).

  _Matches:_

  * true	"1920-12-31"
  * true	"2037-11-19"
  * true	"2000-01-01"

  _Non Matches:_

  * false	"1874-11-15"
  * false	"1989-13-01"
  * false	"1968/08/19"
  * false	"2084-11-00"
  * false	"1997 02 31"



<a href="#toc">^</a>

---

<a name="swedish-social-security-number---initial-attempt"> </a>
### Swedish social security number - Initial attempt

**Expression**: `(\\d{2})?\\d{6}-?\\d{4}`

Simple matching of the Swedish social security number. six or eight digits, an optional hyphen and four digits. This expressions only checks for the right number or digits, not wether they are correct.

  _Matches:_

  * true	"254789-1234"
  * true	"987741008475"
  * true	"12345678-0987"
  * true	"8745632104"

  _Non Matches:_

  * false	"1234567-9781"
  * false	"1920-12-11-5789"
  * false	"647189-987"
  * false	"87456321"



<a href="#toc">^</a>

---

<a name="swedish-social-security-number---improved"> </a>
### Swedish social security number - Improved

**Expression**: `(?:19|20)?\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1-2]\\d|3[0-1])-?\\d{4}`

**Alternative**: `((?:19|20)?(\\d{2}))(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])[- ]?(\\d{4})`

A somewhat better matching of the Swedish social security number. six or eight digits, an optional hyphen and four digits. Note that the first four non-matching numbers matched the initial attempt. To make a validation of the last digit (control digit) you need to use more than a regexp. The alternative expression contains the grouping used in the <a href="./src/main/java/se/blinfo/regexp/sample/SwedishSocialSecurityNumberValidator.java">SwedishSocialSecurityNumberValidator</a> and the javascript <a href="./src/main/resources/sample/swedish-social-security-number-validator.js">swedish-social-security-number-validator.js</a>.

  _Matches:_

  * true	"19721011-6534"
  * true	"7811309574"
  * true	"120226-0987"
  * true	"19991231-9999"

  _Non Matches:_

  * false	"254789-1234"
  * false	"987741008475"
  * false	"12345678-0987"
  * false	"8745632104"
  * false	"1234567-9781"
  * false	"1920-12-11-5789"
  * false	"647189-987"
  * false	"87456321"
  * false	"20040832-1541"

With alternative writing:

  _Matches:_

  * true	"19721011-6534"
  * true	"7811309574"
  * true	"120226-0987"
  * true	"19991231-9999"

  _Non Matches:_

  * false	"254789-1234"
  * false	"987741008475"
  * false	"12345678-0987"
  * false	"8745632104"
  * false	"1234567-9781"
  * false	"1920-12-11-5789"
  * false	"647189-987"
  * false	"87456321"
  * false	"20040832-1541"


<a href="#toc">^</a>

---

<a name="email-address---a-pretty-simple-example"> </a>
### Email address - A pretty simple example

**Expression**: `[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}`

Matches email address pattern.

  _Matches:_

  * true	"h.l@fejk.com"
  * true	"H_L@FEKJ.COM"
  * true	"snisse%b@blinfo.se"
  * true	"Info@hex.nu"
  * true	"Kalle-Nilsson@KalleNilsson.com"
  * true	"a+b@math.org"
  * true	"a@b.c.de"

  _Non Matches:_

  * false	"abc@123"
  * false	"pelle/lisa@gmail.com"
  * false	"IIV 453@plates.nu"
  * false	"DEF@4567:se"
  * false	"info(AT)company.com"



<a href="#toc">^</a>

---

<a name="swedish-car-number"> </a>
### Swedish car number

**Expression**: `[A-HJ-PR-UW-Z]{3} ?(0\\d[A-HJ-PR-UW-Z1-9]|[1-9]\\d[A-HJ-PR-UW-Z0-9])`

**Alternative**: `[A-Z&&[^IQV]]{3} ?(0\\d[A-Z1-9&&[^IQV]]|[1-9]\\d[A-Z0-9&&[^IQV]])`

Matches the Swedish licence plate number. Three upper case letters A-H, J-P, R-U or W-Z followed by a single space and then 001 - 999 or 00 - 99 plus upper case letter A-H, J-P, R-U or W-Z. Some letter combinations are removed, like KKK, PKK and a few others, but this expression does not handle these numbers.

  _Matches:_

  * true	"ABC123"
  * true	"PKJ 001"
  * true	"DEF 456"
  * true	"HJK 94A"
  * true	"AAA 00W"

  _Non Matches:_

  * false	"abc123"
  * false	"CDE 000"
  * false	"IIV 453"
  * false	"DEF 4567"
  * false	"QHI 987"
  * false	"BCD 12I"

With alternative writing:

  _Matches:_

  * true	"ABC123"
  * true	"PKJ 001"
  * true	"DEF 456"
  * true	"HJK 94A"
  * true	"AAA 00W"

  _Non Matches:_

  * false	"abc123"
  * false	"CDE 000"
  * false	"IIV 453"
  * false	"DEF 4567"
  * false	"QHI 987"
  * false	"BCD 12I"


<a href="#toc">^</a>

