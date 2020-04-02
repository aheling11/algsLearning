package ToOffer;

class countDigitOne {

    public int countDigitOne(int n) {
        int ans = 0;
        for(int i = 0; i <= n; i++){
            if(isContainOne(i) == true){
                ans++;
            }
        }
        return ans;
    }

    public boolean isContainOne(int n){
        while(n > 0){
            if(n % 10 == 1){
                return true;
            }
            n/=10;
        }
        return false;
    }
}