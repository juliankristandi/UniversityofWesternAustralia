#include <stdio.h>
#include <stdlib.h>

void ordinal(int number)
{
	int remainder = number % 10;
	if(remainder == 1)
	{
		printf("%ist ", number);
	}
	else if(remainder == 2)
	{
		printf("%ind ", number);
	}
	else if(remainder == 3)
	{
		printf("%ird ", number);
	}
	else
	{
		printf("%ith ", number);
	} 
}


int main(int argc, char *argv[])
{
	if(argc < 2)
	{
		exit(EXIT_FAILURE);
	}
	else
	{
		for(int i = 1; i < argc; ++i)
		{
			int n = atoi(argv[i]);
			ordinal(n);	
		}	
		exit(EXIT_SUCCESS);
	}
	return 0;
}


