#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	if(argc != 2)
	{
		exit(EXIT_FAILURE);
	}
	else
	{
		int year = atoi(argv[1]);
		if(year % 400 == 0)
		{
			printf("%i is a leap year", year);
		}
		else
		{
			printf("%i is not a leap year", year);
		}
	}
}
