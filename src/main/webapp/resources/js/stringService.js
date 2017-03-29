/**
 * Created by alex on 26.03.17.
 */

myApp.factory("stringService", function () {
    return {
        processString: function (input) {
            if (!input) return;

            var output = input[0];


            for (var i = 1; i < input.length; i++) {
                if (input[i] == input[i].toUpperCase()) {
                    output += " ";
                }

                output+= input[i];
            }

            return output;

        }
    }
});