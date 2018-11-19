<a name="top"> </a>
# Regular Expressions 

  * <a href="#single-digit">Single digit</a>
  * <a href="#single-non-digit">Single non digit</a>
  * <a href="#zero-or-more-digits">Zero or more digits</a>
  * <a href="#zero-or-one-digit">Zero or one digit</a>
  * <a href="#one-or-more-digits">One or more digits</a>
  * <a href="#three-digits">Three digits</a>
  * <a href="#three-or-more-digits">Three or more digits</a>
  * <a href="#three-to-five-digits">Three to five digits</a>
  * <a href="#negative-or-positive-number">Negative or positive number</a>
  * <a href="#zero-or-negative-or-positive-number">Zero or negative or positive number</a>
  * <a href="#zero-or-negative-or-positive-float">Zero or negative or positive float</a>
  * <a href="#negative-or-positive-float-or-int">Negative or positive float or int</a>
  * <a href="#one-english-letter-et-al">One English letter et al</a>
  * <a href="#one-swedish-letter">One Swedish letter</a>
  * <a href="#some-specific-letters">Some specific letters</a>
  * <a href="#single-white-space">Single white space</a>
  * <a href="#single-non-white-space">Single non white space</a>
  * <a href="#swedish-social-security-number---initial-attempt">Swedish social security number - Initial attempt</a>
  * <a href="#swedish-social-security-number---improved-attempt">Swedish social security number - Improved attempt</a>
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

With alternative writing:

  _Matches:_

  * true	"1"
  * true	"7"

  _Non Matches:_

  * false	"a"
  * false	"P"
  * false	"@"


<a href="#top">^</a>

---

<a name="single-non-digit"> </a>
### Single non digit

**Expression**: `\\D`

**Alternative**: `[^0-9]`

Matches exactly one character which can not be a digit.

  _Matches:_

  * true	"a"
  * true	"P"
  * true	"@"

  _Non Matches:_

  * false	"1"
  * false	"7"

With alternative writing:

  _Matches:_

  * true	"a"
  * true	"P"
  * true	"@"

  _Non Matches:_

  * false	"1"
  * false	"7"


<a href="#top">^</a>

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


<a href="#top">^</a>

---

<a name="zero-or-one-digit"> </a>
### Zero or one digit

**Expression**: `\\d{0,1}`

Matches zero or one digit.

  _Matches:_

  * true	""
  * true	"7"
  * true	"4"

  _Non Matches:_

  * false	"a"
  * false	"11"
  * false	"957"



<a href="#top">^</a>

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


<a href="#top">^</a>

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


<a href="#top">^</a>

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


<a href="#top">^</a>

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


<a href="#top">^</a>

---

<a name="negative-or-positive-number"> </a>
### Negative or positive number

**Expression**: `[+\\-]{0,1}\\d+`

**Alternative**: `[-+]{0,1}[0-9]{1,}`

Matches negative or positive number of one or more digits. To use minus sign in a group  
it you can put it as the first sign in the group or escape it.

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


<a href="#top">^</a>

---

<a name="zero-or-negative-or-positive-number"> </a>
### Zero or negative or positive number

**Expression**: `0{1}|[-+]{0,1}[1-9]{1}\\d{0,}`

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



<a href="#top">^</a>

---

<a name="zero-or-negative-or-positive-float"> </a>
### Zero or negative or positive float

**Expression**: `0{1}|[-+]{0,1}\\d{1,}\\.\\d{1,9}`

Matches number zero or a negative or positive float (non zero).

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



<a href="#top">^</a>

---

<a name="negative-or-positive-float-or-int"> </a>
### Negative or positive float or int

**Expression**: `[-+]{0,1}\\d{1,}(\\.\\d{1,9}){0,1}`

Matches negative or positive float or int. (This expression accepts -0 and +0)

  _Matches:_

  * true	"0.1"
  * true	"-19.0"
  * true	"4.0154"
  * true	"-0.534"
  * true	"+0.24"
  * true	"11"
  * true	"0"
  * true	"+0"

  _Non Matches:_

  * false	"-"
  * false	"a4"
  * false	".5"
  * false	"1+1"
  * false	"-11,2"
  * false	"1+"
  * false	"1.2.43"



<a href="#top">^</a>

---

<a name="one-english-letter-et-al"> </a>
### One English letter et al

**Expression**: `\\w`

**Alternative**: `[a-zA-Z_0-9]`

Matches one English letter, one digit or underscore. This character class is not very  
reliable so the alternative writing is to be preferred.

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


<a href="#top">^</a>

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



<a href="#top">^</a>

---

<a name="some-specific-letters"> </a>
### Some specific letters

**Expression**: `[0-9a-fQXZ£€$]`

Matches digit, lower case letters a through f, upper case letters Q, X or Z and money  
symbols £, € and $.

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



<a href="#top">^</a>

---

<a name="single-white-space"> </a>
### Single white space

**Expression**: `\\s`

Matches whitespace characters, like new line, carriage return, tab and space.

  _Matches:_

  * true	"
"
  * true	""
  * true	"	"
  * true	" "

  _Non Matches:_

  * false	""
  * false	"x"



<a href="#top">^</a>

---

<a name="single-non-white-space"> </a>
### Single non white space

**Expression**: `\\S`

Matches non whitespace characters, like letter, digit or other symbol.

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



<a href="#top">^</a>

---

<a name="swedish-social-security-number---initial-attempt"> </a>
### Swedish social security number - Initial attempt

**Expression**: `(\\d{2}){0,1}\\d{6}-{0,1}\\d{4}`

Simple matching of the Swedish social security number. six or eight digits, an optional  
hyphen and four digits. This expressions only checks for the right number or digits,  
not wether they are correct.

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



<a href="#top">^</a>

---

<a name="swedish-social-security-number---improved-attempt"> </a>
### Swedish social security number - Improved attempt

**Expression**: `(19\\d{2}|20[01]\\d|\\d{2})(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])-{0,1}\\d{4}`

A somewhat better matching of the Swedish social security number. six or eight digits, an optional  
hyphen and four digits.

  _Matches:_

  * true	"19721011-6534"
  * true	"7811309574"
  * true	"120226-0987"
  * true	"19991231-9999"

  _Non Matches:_

  * false	"1234567-9781"
  * false	"1920-12-11-5789"
  * false	"647189-987"
  * false	"87456321"
  * false	"20040832-1541"



<a href="#top">^</a>

---

<a name="swedish-car-number"> </a>
### Swedish car number

**Expression**: `[A-HJ-PR-UW-Z]{3}\\s{0,1}(0\\d[1-9]|[1-9]\\d[A-HJ-PR-UW-Z0-9])`

Matches the Swedish licence plate number. Three upper case letters A-H, J-P, R-U or W-Z  
followed by 001 - 999 or 00 - 99 plus upper case letter A-H, J-P, R-U or W-Z.

  _Matches:_

  * true	"ABC123"
  * true	"PKJ 001"
  * true	"DEF 456"
  * true	"HJK 94A"

  _Non Matches:_

  * false	"abc123"
  * false	"CDE 000"
  * false	"IIV 453"
  * false	"DEF 4567"
  * false	"QHI 987"



<a href="#top">^</a>

