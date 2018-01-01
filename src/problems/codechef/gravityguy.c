#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
int main(){
	long t,l;
	char str1[200000],str2[200000],*ptr;
	int pos,sync=0,sw=0;
	scanf("%ld",&t);
	while(t--){
		pos=-1;
		sync=0;
		sw=0;
		scanf("%s",str1);
		scanf("%s",str2);
		l=strlen(str1);
		if(str1[0]=='.')
			ptr=str1;
		else ptr=str2;
		while(pos<l){
			if(ptr[pos+1]=='.'){
				pos++;
				sync=0;
			}
			else{

				sync++;
				if(sync==2)break;
				if(ptr==str1){
					ptr=str2;
					sw++;
				}
				else {
					ptr=str1;
					sw++;
				}
			}
		}
		if(pos+1==l)printf("%s\n%d\n","Yes",sw-1);
		else printf("%s\n","No");
	}
	return 0;
}
