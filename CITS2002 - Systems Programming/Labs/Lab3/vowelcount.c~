#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int numberOfVowels(char string[])
{
    int count = 0;
    int length = strlen(string);
    for(int i = 0; i < length; i++)
    {
        if(tolower(string[i]) == 'a' || 'e' || 'u' || 'i' || 'o')
	{
	    count++;
	}
    }
    return count;
}

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
	fprintf(stderr, "Usage: %s argument \n", argv[0]);
	exit(EXIT_FAILURE);
    }
    else
    {
    	int vowels = numberOfVowels(argv[1]);
	printf("The number of vowels: %i", vowels);
    	exit(EXIT_SUCCESS);
    }
    return 0;
}
