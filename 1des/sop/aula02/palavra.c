#include<stdio.h>
int main(){
	int variavel = 314;
	printf("Dado = %i \n",variavel);
	printf("Endereço inteiro = %i \n",&variavel);
	
	char caracter = 'R';
	printf("Caracter = %c \n",caracter);
	printf("ASSCII = %i \n",caracter);
	printf("Endereço hexadecimal = %x \n",&caracter);
}
