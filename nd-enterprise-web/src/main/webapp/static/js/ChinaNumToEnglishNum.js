function chineseNumber(dValue) {
    var maxDec = 2;
    dValue = dValue.toString().replace(/,/g, "");
    dValue = dValue.replace(/^0+/, "");
    if (dValue == "") {
        return "零";
    }
    else if (isNaN(dValue)) {
        return "错误：金额不是合法的数值！";
    }
    var minus = "";
    var CN_SYMBOL = "";
    if (dValue.length > 1) {
        if (dValue.indexOf('-') == 0) {
            dValue = dValue.replace("-", "");
            minus = "负";
        }
        if (dValue.indexOf('+') == 0) {
            dValue = dValue.replace("+", "");
        }
    }
    var vInt = "";
    var vDec = "";
    var resAIW;
    var parts;
    var digits, radices, bigRadices, decimals;
    var zeroCount;
    var i, p, d;
    var quotient, modulus;
    var NoneDecLen = (typeof(maxDec) == "undefined" || maxDec == null || Number(maxDec) < 0 || Number(maxDec) > 5);
    parts = dValue.split('.');
    if (parts.length > 1) {
        vInt = parts[0];
        vDec = parts[1];
        if (NoneDecLen) {
            maxDec = vDec.length > 5 ? 5 : vDec.length;
        }
        var rDec = Number("0." + vDec);
        rDec *= Math.pow(10, maxDec);
        rDec = Math.round(Math.abs(rDec));
        rDec /= Math.pow(10, maxDec);
        var aIntDec = rDec.toString().split('.');
        if (Number(aIntDec[0]) == 1) {
            vInt = (Number(vInt) + 1).toString();
        }
        if (aIntDec.length > 1) {
            vDec = aIntDec[1];
        } else {
            vDec = "";
        }
    } else {
        vInt = dValue;
        vDec = "";
        if (NoneDecLen) {
            maxDec = 0;
        }
    }
    if (vInt.length > 44) {
        return "错误：数值过大！整数位长【" + vInt.length.toString() + "】超过了上限！";
    }
    digits = new Array("零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖");
    radices = new Array("", "拾", "佰", "仟");
    bigRadices = new Array("", "万", "亿", "兆", "京", "垓", "杼", "穰", "沟", "涧", "正");
    decimals = new Array("角", "分", "厘", "毫", "丝");
    resAIW = "";
    if (Number(vInt) > 0) {
        zeroCount = 0;
        for (i = 0; i < vInt.length; i++) {
            p = vInt.length - i - 1;
            d = vInt.substr(i, 1);
            quotient = p / 4;
            modulus = p % 4;
            if (d == "0") {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    resAIW += digits[0];
                }
                zeroCount = 0;
                resAIW += digits[Number(d)] + radices[modulus];
            }
            if (modulus == 0 && zeroCount < 4) {
                resAIW += bigRadices[quotient];
            }
        }
        resAIW;
    }
    for (i = 0; i < vDec.length; i++) {
        d = vDec.substr(i, 1);
        if (d != "0") {
            resAIW += digits[Number(d)] + decimals[i];
        }
    }
    if (resAIW == "") {
        resAIW = "零";
    }
    if (vDec == "") {
        resAIW;
    }
    resAIW = CN_SYMBOL + minus + resAIW;
    return resAIW;
}

function toUpperMoney(n) {
    var fraction = ['角', '分']
    var digit = [
        '零', '壹', '贰', '叁', '肆',
        '伍', '陆', '柒', '捌', '玖'
    ];
    var unit = [
        ['元', '万', '亿'],
        ['', '拾', '佰', '仟']
    ];
    var head = n < 0 ? '欠' : ''
    n = Math.abs(n)
    var s = ''
    for (var i = 0; i < fraction.length; i++) {
        s += (digit[Math.floor(Math.floor(n * 1000 * 10 * Math.pow(10, i)) % (10 * 1000) / 1000)] + fraction[i]).replace(/零./, '')
    }
    s = s || '整'
    n = Math.floor(n)
    for (var i = 0; i < unit[0].length && n > 0; i++) {
        var p = ''
        for (var j = 0; j < unit[1].length && n > 0; j++) {
            p = digit[n % 10] + unit[1][j] + p
            n = Math.floor(n / 10)
        }
        s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s
    }
    return head + s.replace(/(零.)*零元/, '元')
        .replace(/(零.)+/g, '零')
        .replace(/^整$/, '零元整')
}