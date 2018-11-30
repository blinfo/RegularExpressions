RPG = {
    roll: function (input) {
        const REGEXP = /(\d+)[dDtT](\d+)(?:([-+])(\d+))?/;
        if (input === null || !REGEXP.test(input)) {
            return null;
        }
        const NUMBER_OF_DICE = 1;
        const DIE_MAX = 2;
        const OPERATOR = 3;
        const MODIFIER = 4;
        var matcher = input.match(REGEXP);
        var result = 0;
        for (var i = 0; i < matcher[NUMBER_OF_DICE]; i++) {
            result += getResult();
        }
        return result + getModifier();

        function getResult() {
            var roll = Math.floor(Math.random() * parseInt(matcher[DIE_MAX])) + 1;
            return roll;
        }

        function getModifier() {
            var modifier = isEmpty(matcher[MODIFIER]) ? 0 : parseInt(matcher[MODIFIER]);
            return isEmpty(matcher[OPERATOR]) ? 0 : matcher[MODIFIER] === '-' ? 0 - modifier : modifier;
        }

        function isEmpty(data) {
            return data === null || data === undefined || data === '';
        }
    }
};