//problem link:-https://www.codechef.com/problems/ERROR
#include <stdio.h>

int main() {
    
    char s[100001];
    int t,f1,f2;
    long i,j,l;
    
    scanf("%d",&t);
    
    while(t--){
        f1=f2=0;
        scanf("%s",s);
        l=strlen(s);
        
        for (i = 1,j=0; i<l-1 ; i++) {
            
            if((s[i-1]=='1') && (s[i]=='0')   && (s[i+1]=='1')){
                f1=1;
                break;
            }
            if((s[i-1]=='0') && (s[i]=='1')   && (s[i+1]=='0')){
                f2=1;
                break;
            } 
        }

        if(f1|f2)printf("Good\n");
        else printf("Bad\n");
    }
	return 0;
}


