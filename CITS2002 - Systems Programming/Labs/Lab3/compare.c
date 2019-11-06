#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int my_strcmp(char string1[], char string2[])
{
    int length1 = strlen(string1);
    int length2 = strlen(string2);
	if(length1 < length2)
	{
		return -1;
	}
	else if (length1 > length2)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

int main(int argc, char *argv[])
{
	if (argc != 3)
	{
		exit(EXIT_FAILURE);
	}
	else
	{
		int result = my_strcmp(argv[1], argv[2]);
		
		if (result == -1)
		{
			printf("First word is less than second.");
		}
		else if (result == 1)
		{
			printf("First word is greater than second.");
		}
		else
		{
			printf("Both words are equal.");
		}
		
		exit(EXIT_SUCCESS);
	}
	return 0;
}
