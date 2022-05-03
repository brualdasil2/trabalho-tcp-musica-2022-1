#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    FILE* testFile, *gabFile;

    char testNumber[10] = "1";
    int erro = 0;
    while (!erro) {
        char testFilePath[100] = "./A Testar/T";
        char gabFilePath[100] = "./Gabarito/T";
        strcat(testFilePath, testNumber);
        strcat(testFilePath, ".midi");
        strcat(gabFilePath, testNumber);
        strcat(gabFilePath, ".midi");
        testFile = fopen(testFilePath, "rb");
        gabFile = fopen(gabFilePath, "rb");

        char tb, gb;
        int bytesRead = 0, equalBytes = 0;
        do {
            if (fread(&tb, sizeof(char), 1, testFile) != 1) {
                erro = 1;
            }
            if (fread(&gb, sizeof(char), 1, gabFile) != 1) {
                erro = 1;
            };
            if (!erro) {
                bytesRead++;;
                if (tb == gb) {
                    equalBytes++;
                }
            }
        } while (tb != EOF && gb != EOF);
        if (!erro) {
            printf("T%s: %.2f%%\n", testNumber, ((float)equalBytes/(float)bytesRead)*100);
            testNumber[0]++;
        }
    }
    return 0;
}