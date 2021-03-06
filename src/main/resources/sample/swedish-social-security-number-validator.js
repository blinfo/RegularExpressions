SSN = {
    validate: function (input) {
        const REGEXP = /((?:19|20)?(\d{2}))(0[1-9]|1[0-2])(0[1-9]|[1-2]\d|3[0-1])[- ]?(\d{4})/;
        if (input === null || !REGEXP.test(input)) {
            return false;
        }
        const FULL_YEAR = 1;
        const YEAR = 2;
        const MONTH = 3;
        const DAY = 4;
        const NUMBER = 5;
        var matcher = input.match(REGEXP);
        var fullYear = parseInt(matcher[FULL_YEAR]);
        var year = parseInt(matcher[YEAR]);
        var month = matcher[MONTH];
        var day = matcher[DAY];
        var number = matcher[NUMBER];
        return isValidDate() && isValidLuhnNumber();

        function isValidDate() {
            dayOfMonth = parseInt(day);
            if (fullYear < 100) {
                fullYear += (fullYear < new Date().getFullYear() - 2000) ? 2000 : 1900;
            }
            switch (parseInt(month)) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return dayOfMonth < 32;
                case 4:
                case 6:
                case 9:
                case 11:
                    return dayOfMonth < 31;
                case 2:
                    var modulo100 = fullYear % 100;
                    return ((modulo100 === 0 && fullYear % 400 === 0) || (modulo100 !== 0 && fullYear % 4 === 0)) ?
                            dayOfMonth < 30 : dayOfMonth < 29;
                default:
                    return false;
            }
        }

        function isValidLuhnNumber() {
            var luhnNumber = "" + year + month + day + number;
            var multiplier = 1;
            var sum = 0;
            var term;
            for (var i = luhnNumber.length - 1; i >= 0; i--) {
                term = parseInt(luhnNumber.charAt(i)) * multiplier;
                if (term > 9) {
                    term -= 9;
                }
                sum += term;
                multiplier = 3 - multiplier;
            }
            return sum % 10 === 0;
        }
    }
};
