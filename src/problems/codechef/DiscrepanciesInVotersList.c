//problem link:-https://www.codechef.com/problems/VOTERS

#include <stdio.h>
#include<stdlib.h>
#define max 1000001
#define inchar getchar_unlocked
inline int inIntPos() {
    	int n=0;
    	int ch=getchar_unlocked();
    	
    	while( ch >= '0' && ch <= '9' ) {
    		n = (n<<3)+(n<<1) + (ch-'0');
    		ch=getchar_unlocked();
    	}
    	return n;
    }
int hash[max]={0};
int main() {
    int n1,n2,n3,size,temp,i,j,cnt=0;
    
    n1=inIntPos();
    n2=inIntPos();
    n3=inIntPos();
    
    size=n1+n2+n3;
    
    j=0;
    for (i = 0; i <size; i++) {
        temp=inIntPos();
        hash[temp]++;
        if(temp>j)j=temp;
        if(hash[temp]==2)cnt++;
    }
    
    printf("%d\n",cnt);
    
    for (i = 0; i <=j; i++)
        if(hash[i]>=2)
         printf("%d\n",i);
         
	return 0;
}
