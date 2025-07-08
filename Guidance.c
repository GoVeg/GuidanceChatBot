#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h> // For atoi

// Checks if a word matches any word in a comma-separated group, handling optional characters
bool word_in_group_with_optional(const char *word_a, const char *group_b) {
    char group_copy[strlen(group_b) + 1];
    strcpy(group_copy, group_b);

    char *token_b = strtok(group_copy, ", ");
    while (token_b != NULL) {
        const char *ptr_a = word_a;
        const char *ptr_b = token_b;
        bool match = true;

        while (*ptr_a != '\0' && *ptr_b != '\0') {
            if (*ptr_b == '+') {
                ptr_b++;
                if (*ptr_a == *ptr_b) {
                    ptr_a++;
                }
                ptr_b++;
            } else if (*ptr_a == *ptr_b) {
                ptr_a++;
                ptr_b++;
            } else {
                match = false;
                break;
            }
        }

        if (match && *ptr_a == '\0' && *ptr_b == '\0') {
            return true;
        }

        token_b = strtok(NULL, ", ");
    }
    return false;
}

// Compares the sentence and the word group string with required group handling
bool compare_sentences_with_required(const char *sentence_a, const char *sentence_b) {
    char sentence_a_copy[strlen(sentence_a) + 1];
    strcpy(sentence_a_copy, sentence_a);

    char sentence_b_copy[strlen(sentence_b) + 1];
    strcpy(sentence_b_copy, sentence_b);

    char *word_a = strtok(sentence_a_copy, " ");
    char *word_group_b_token = strtok(sentence_b_copy, "("); // Tokenize sentence B by '('

    int required_matches = 0;
    int total_required_groups = 0;

    // First, extract the required group count from the end of sentence B
    char *last_token = NULL;
    char *temp_b_copy = sentence_b_copy; // Use a temporary copy for the first strtok call

    while (word_group_b_token != NULL) {
        last_token = word_group_b_token;
        word_group_b_token = strtok(NULL, "(");
    }

    if (last_token != NULL) {
        // Extract the number from the last token
        char *space_before_number = strrchr(last_token, ' ');
        if (space_before_number != NULL) {
            *space_before_number = '\0'; // Null-terminate before the number
            total_required_groups = atoi(space_before_number + 1); // Convert the number string to an integer
        } else {
            // Handle the case where the last token is just the number
             total_required_groups = atoi(last_token);
        }
    }


    // Reset sentence_b_copy for processing word groups
    strcpy(sentence_b_copy, sentence_b);
    word_group_b_token = strtok(sentence_b_copy, "(");

    while (word_a != NULL && word_group_b_token != NULL) {
        // Extracts the word group from within the parentheses
        char *closing_paren = strchr(word_group_b_token, ')');
        if (closing_paren != NULL) {
            *closing_paren = '\0';
            char *word_group = word_group_b_token + 1; // Moves past the opening parenthesis

            bool is_required = false;
            if (word_group[0] == ',') {
                is_required = true;
                word_group++; // Move past the comma for matching
            }

            if (word_in_group_with_optional(word_a, word_group)) {
                if (is_required) {
                    required_matches++;
                }
                word_a = strtok(NULL, " ");
                word_group_b_token = strtok(NULL, "(");
            } else {
                if (is_required) {
                    return false; // Required group didn't match
                }
                // If not required and no match, move to the next word group
                word_group_b_token = strtok(NULL, "(");
            }
        } else {
            return false; // Invalid format for sentence B
        }
    }

    // Check if all words in sentence A and word groups in sentence B have been processed
    // and if the minimum required matches have been met
    if (word_a == NULL && word_group_b_token == NULL && required_matches >= total_required_groups) {
        return true; // Sentences match
    } else {
        return false; // Sentences do not match or required matches not met
    }
}

int main() {
    char sentence_a[] = "This is a test sentence";
    char sentence_b[] = "(This,That) (,is,was) (a) (tes+t,sampl+e) (,sentence) 2"; // 2 required groups

    if (compare_sentences_with_required(sentence_a, sentence_b)) {
        printf("Sentences match!\n");
    } else {
        printf("Sentences do not match.\n");
    }

    char sentence_a_alt[] = "This is a test example";
    char sentence_b_alt[] = "(This,That) (,is,was) (a) (tes+t,sampl+e) (,sentence) 2";

    if (compare_sentences_with_required(sentence_a_alt, sentence_b_alt)) {
        printf("Alternate sentence matches!\n");
    } else {
        printf("Alternate sentence does not match.\n");
    }

    char sentence_a_nomatch[] = "This is a test example";
    char sentence_b_nomatch[] = "(This,That) (,is,was) (a) (tes+t,sampl+e) (,sentence) 3"; // 3 required groups, but only 2 possible

     if (compare_sentences_with_required(sentence_a_nomatch, sentence_b_nomatch)) {
        printf("No-match sentence matches!\n");
    } else {
        printf("No-match sentence does not match.\n");
    }


    return 0;
}
