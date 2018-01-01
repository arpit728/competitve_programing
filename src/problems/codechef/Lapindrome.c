//Problem link:-https://www.codechef.com/problems/LAPIN

#include <stdio.h>

int main() {
    int t,hash[126],flag,i,m,n;
    char a[1001];
    scanf("%d",&t);
    while(t--){
        flag=1;
        for (i = 0; i<126; i++)hash[i]=0;
        scanf("%s",a);
        n=strlen(a);
        
        for (i = 0; i<=(n/2)-1; i++)hash[a[i]]++;
        
        m=n/2;
        if(n&1)m++;
        
        for (i =m; i<n; i++)hash[a[i]]--;
        
        for (i = 0; i<=(n/2)-1; i++)
            
            if(hash[a[i]]!=0){
                flag=0;
                break;
            }
        
        if(flag)printf("YES\n");
        else printf("NO\n");
        
    }
	return 0;
}


