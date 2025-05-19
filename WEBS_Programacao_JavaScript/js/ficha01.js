function multiply(num1, num2) {
    return num1 * num2;
}

function isShortsWeather(temperature) {
    if (temperature > 25) {
        return true;
    } else {
        return false;
    }
}

function lastElement(array) {
    if (array.length == 0) {
        return null;
    } else {
        return array[array.length - 1];
    }
}

function sumArray(array) {
    let sum = 0;
    for (let i = 0; i < array.length; i++) {
        sum += array[i];
    }
    return sum;
}

function returnDay (day) {
    switch (day) {
        case 1:
            return "Monday";
        case 2:
            return "Tuesday";
        case 3:
            return "Wednesday";
        case 4:
            return "Thursday";
        case 5:
            return "Friday";
        case 6:
            return "Saturday";
        case 7:
            return "Sunday";
        default:
            return null;
    }
}