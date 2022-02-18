function calcSubTotal(index){    //小計を計算
    let priceList = document.getElementsByName('priceList');
    let quantityList = document.getElementsByName('quantityList');
    let quantity = parseInt(quantityList.item(index).value);    //部数を取得
    let price    = parseInt(priceList.item(index).value);
    subTotal = quantity*price;

    let elementSubTotal = document.getElementsByClassName('subtotal');
    elementSubTotal.item(index).textContent = subTotal;
    calcSum();  //合計金額を計算し更新
}

function calcSum(){ //合計金額を計算
    let priceList = document.getElementsByName('priceList');
    let quantityList = document.getElementsByName('quantityList');
    let sumPrice=0;
    for(let i=0;i<quantityList.length;i++){
        let quantity = parseInt(quantityList.item(i).value);    //部数を取得
        let price    = parseInt(priceList.item(i).value);
        sumPrice+=(price*quantity);
    }

    let sumId = document.getElementById('sum'); //sumのidを取得
    sumId.textContent = sumPrice;   //合計金額を表示
}