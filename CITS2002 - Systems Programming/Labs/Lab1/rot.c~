#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// Compile this program with:
//      cc -std=c99 -Wall -Werror -pedantic -o rot rot.c

//  The rotate function returns the character ROT positions further along the
//  alphabetic character sequence from c, or c if c is not lower-case

char rotate(char c, int ROT)
{
        // Check if c is lower-case or not
        if (islower(c))
        {
                // The ciphered character is ROT positions beyond c,
                // allowing for wrap-around
                return ('a' + (c - 'a' + ROT) % 26);
        }
        else
        {
                // If it is uppercase, converts it to lower, rotates, 
		// then capitalizes it
		c = tolower(c);
		return toupper(('a' + (c - 'a' + ROT) % 26));
        }
}

//  Execution of the whole program begins at the main function

int main(int argc, char *argv[])
{
        // Exit with an error if the number of arguments (including
        // the name of the executable) is not precisely 4
        if(argc != 4)
        {
                fprintf(stderr, "%s: program expected 3 arguments, but instead received %d\n", argv[0], argc-1);
                exit(EXIT_FAILURE);
        }
        else
        {
                int ROT = atoi(argv[3]);

		// Calculate the length of the first argument
                int length = strlen(argv[1]);

                // Loop for every character in the text
                for(int i = 0; i < length; i++)
                {
                        // Determine and print the ciphered character
                        printf("%c", rotate(argv[1][i], ROT));
                }

                // Print one final new-line character
                printf("\n");

		length = strlen(argv[2]);
		
		for(int i = 0; i < length; i++)
		{
			printf("%c", rotate(argv[2][i], ROT));
		}

		printf("\n");

                // Exit indicating success
                exit(EXIT_SUCCESS);
        }
        return 0;
}
