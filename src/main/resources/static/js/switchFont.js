console.log('Hello');

const simplifiedFonts = [
    "LiuJianMaoCao",
    "LongCang",
    "MaShanZheng",
    "NotoSansSC",
    "NotoSerifSC",
    "KuaiLe",
    "QingKeHuangYou",
    "XiaoWei",
    "ZhiMangXing"
];

const traditionalFonts = [
    "NotoSansTC",
    "NotoSerifTC"
];

const simplified = $('.simplified').get(0);
const traditional = $('.traditional').get(0);

simplified.addEventListener('click', function(){
    setFont(this, simplifiedFonts);
})

traditional.addEventListener('click', function(){
    setFont(this, traditionalFonts);
})

function setFont(node, fontArray){
    const fontIndex = fontArray.findIndex(font => font === node.id);
    //console.log(fontIndex);
    if(fontIndex == -1){
        return '';
    } else if (fontIndex+1 == fontArray.length) {
        node.id = fontArray[0];
    } else {
        node.id = fontArray[fontIndex+1];
    }
}
