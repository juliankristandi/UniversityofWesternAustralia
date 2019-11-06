#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

// This program has errors. Check again
bool valid(char number[])
{
	bool result = false;
	int length = strlen(number);
	int counter = 0;
	int s1 = 0;
	int s2 = 0;
	for(int i = length - 1; i >= 0; i--)
	{
		counter++;
		int digit = number[i] - '0';
		if((counter%2)!=0)
		{
			s1 = s1 + digit;	
		}
		else
		{
			digit = digit * 2;
			s2 = s2 + digit;
		}
	}
	
	if((s1 + s2)%10 == 0)
	{
		result = true;
	}
	return result;
}

int main (int argc, char *argv[])
{
	bool iscc = valid(argv[1]);
	if (iscc)
	{
		printf("It is a valid credit card.");
	}
	else
	{
		printf("Scammed.");
	}
}
