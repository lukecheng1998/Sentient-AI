.data
/* Assemble the following statements into the data section. */ 
  
print_string: .asciz "Hello World\n"
/* Assembler directive to assemble the ASCII string constant */                                         /*   into consecutive byte addresses followed by a zero byte. */
 
.text
/* Assemble the following statements into the text section */

.global main  /* Make the symbol "main" visible to the linker */

main:
/* main: is a label for the start of this program. */
/* main: stands for the address of the first instruction of the program in memory. */
push {r4-r9, fp, lr}
/* Push registers r4 through r9 that printf will use, along with fp and lr */
ldr r0, =print_string    
/* Load r0 with the address symbolized by "print_string", the first byte */
/*  of the Hello World string in the data segment. Printf will use this. */

bl printf   
/* Branch with link to "printf". Saves pc into lr then branches to printf. */
pop {r4-r9, fp, pc}      
/* Restore registers r4 through r9, fp and pc allowing graceful return     */                            
/*   from printf.  Without the push and pop a segmentation fault occurs.   */
