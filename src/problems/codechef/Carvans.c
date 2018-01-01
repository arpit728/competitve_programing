//problem link:-https://www.codechef.com/problems/CARVANS

#include <stdio.h>

int main() {
    int t,n,a[10001],i,cnt;
    scanf("%d",&t);
    while(t--){
        cnt=1;
        scanf("%d",&n);
        scanf("%d",a);
        for (i =1; i<n; i++) {
            scanf("%d",(a+i));
            if(a[i]>a[i-1])a[i]=a[i-1];
            else cnt++;
        }
        printf("%d\n",cnt);
    }
    return 0;
}


