#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int my_strlen(char string[])
{
	return strlen(string);
}

int main(int argc, char *argv[])
{
	
	if (argc < 2)
	{
		fprintf(stderr, "Usage: %s argument\n", argv[0]);
		exit(EXIT_FAILURE);
	}
	else
	{
		int count = my_strlen(argv[1]);
		
		printf("There are %i letters in the string", count);

		exit(EXIT_SUCCESS);
	}
	return 0;
}
