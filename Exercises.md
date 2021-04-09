# Exercises
The exercises are found in the "exercise" package. Each class needs more or less completion to work. 
The requisite for each exercise is found in the java-doc-comment for the class.
The first exercises simply need you to provide the regular expression. The last few also need some java coding.

To check if you have succeeded, run the corresponding "Check"-class in the test package.

It's suggested that you do the exercises in the order below:

## UsernameValidator
Create a group of characters, specify minimum and maximum number of characters.

## BankGiroValidator & PlusGiroValidator
Create a pattern of digits and hyphen where the first group of digits may vary in length.

## VatNumberValidator
Create a pattern of letters and digits with an optional space for the Swedish Vat Number. The pattern should match the two letters "SE" followed by twelve digits. The last two digits should be "01".

## UUIDValidator
Create a pattern that matches java's UUID format. Hexadecimals in five groups with varying lengths, separated by hyphens.

## HtmlLinkParser (some java coding as well)
Extract the url and link text from an HTML link and populate the class HtmlLink. The HtmlLink's toString method should produce  
`"The Link Text : http://some.url.se/"` 
from `<a href="http://some.url.se/">The Link Text</a>`

## VersionNumberValidator (some java coding as well)
Create a capturing pattern for version number (e. g. `3.10, 2.15.3, 1.0`) and populate the Version class with correct values.

## PasswordValidator
Create a pattern for a specified (hypothetical) password format.

## PhoneNumberValidator (some java coding as well)
Create a pattern for phone numbers with two through three groups separated by one space; optional country code, region code and individual number.
 
If country code is included, it must begin with a plus sign, and the following region code must not start with a zero. If no country code is included the region code must begin with a zero.

## NameValidator (some java coding as well)
Validate that a full name is entered according to specification:  
Family name(s), Given name(s) and optional initials where each one is followed by a dot. It should be possible to tie names and initials together with hyphen or leave a space between each. 

Also, try to capture the different parts of the name and populate the Name object.
