//problem link:-https://www.codechef.com/problems/CONFLIP

#include <stdio.h>

int main() {
    
    long long i,q,n,g,ans,t;
    
    scanf("%lld",&t);
    
    
    while(t--){
        
        scanf("%lld",&g);
        while(g--){
            scanf("%lld %lld %lld",&i,&n,&q);
            if((n&1)==0)ans=n/2;
            else{
                if(i==q){
                    ans=n/2;
                }else ans=(n/2)+1;
            }
            printf("%lld\n",ans);
        }
    }
    
    
	return 0;
}


