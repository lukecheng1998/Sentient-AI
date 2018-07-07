.data
outputString: .asciz "%d\n"//Output a number value here
inputString: .asciz "%s"//Input a string value
phrase: .word 0 //get the phrase

.text
.global main
.global loop
main:
	sub sp, sp, #4 //allocate memory in order to get ready 
	str lr, [sp, #0] //push register
	
	ldr r0, =inputString//Input a value into the string
	ldr r1, =phrase //get phrase from and load it into r1
	bl scanf//Call scanf
	
	ldr r2, =phrase//Use for counting

	mov r6, #0 //r6 is used as a counter and set to 0
loop:
	ldr r3, [r2] //load content of r2 to r3 as we are going to be making comparisons to the termination string
	cmp r3, #0//Compare to \0, if true, then break
	ble is_end//if it is 0 then break
	add r6, r6, #1//add one
	add r2, r2, #1//Move the pointer   
	b loop//go back and loop
	is_end:        

	ldr r0, =outputString
	mov r1, r6 //get the number from r1 to r6
	bl printf //print r1

	ldr lr, [sp, #0]//Termination
	add sp, sp, #4//Pop the register back up
	mov pc, lr//Termination
