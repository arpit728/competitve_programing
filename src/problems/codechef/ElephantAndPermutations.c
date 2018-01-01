//problem linnk:-https://www.codechef.com/problems/LEPERMUT

#include <stdio.h>

int main() {
    int t,a[101],n,i,li,gi,j;
    scanf("%d",&t);
    while(t--){
        li=gi=0;
        scanf("%d",&n);
        scanf("%d",a);
        for(i=1;i<n;i++){
            scanf("%d",(a+i));
            if(a[i-1]>a[i])li++;
            for(j=0;j<i;j++)
                if(a[j]>a[i])gi++;
        }
        if(li==gi)printf("YES\n");
        else printf("NO\n");
    }
	return 0;
}


