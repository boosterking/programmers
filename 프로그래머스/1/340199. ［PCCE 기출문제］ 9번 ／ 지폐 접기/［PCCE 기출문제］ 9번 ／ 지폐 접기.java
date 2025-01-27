class Solution {
    public int solution(int[] wallet, int[] bill) {
        int folds = 0;
        int billWidth = Math.max(bill[0], bill[1]);
        int billHeight = Math.min(bill[0], bill[1]);
        int walletWidth = Math.max(wallet[0], wallet[1]);
        int walletHeight = Math.min(wallet[0], wallet[1]);
        
        while(billWidth > walletWidth || billHeight > walletHeight) {
            if(billWidth > billHeight) {
                billWidth = billWidth / 2;
            }
            else {
                billHeight = billHeight / 2;
            }
            folds++;
            
            if(billWidth <= walletHeight && billHeight <= walletWidth) {
                int temp = billWidth;
                billWidth = billHeight;
                billHeight = temp;
            }
        }
        return folds;
    }
}