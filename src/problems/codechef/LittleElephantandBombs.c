//Problem link:-https://www.codechef.com/problems/LEBOMBS

#include <stdio.h>

char a[1005];
int main() {
    int cnt,i,t,n;
    
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        scanf("%s",a+1);
        a[0]='0';a[n+1]='0';
        //printf("%s",a);
        cnt=0;
        for(i=1;i<=n;i++)
            if((a[i-1]=='0')&&(a[i]=='0')&&(a[i+1]=='0'))
                cnt++;
                
        printf("%d\n",cnt);
    }
	return 0;
}


