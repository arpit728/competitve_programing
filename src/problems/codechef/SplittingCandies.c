//problem link:- https://www.codechef.com/problems/SPCANDY

#include <stdio.h>

int main() {
    long long t,n,k,tc,sc;
    scanf("%lld",&t);
    while(t--){
        scanf("%lld %lld",&n,&k);
        if(k==0){
            tc=n;
            sc=0;
        }
        else{
            tc=n%k;
            sc=n/k;
        }
        printf("%lld %lld\n",sc,tc);
    }
    
	return 0;
}


