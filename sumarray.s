.data
inputNum: .asciz "%d" //Take an input here
outputNum: .asciz "%d\n" //Output here
phrase: .word 0 //use to input a phrase

.text
.global main

main:
	sub sp, sp, #4//Push down the stack
	str lr, [sp, #0]//Store the value
	mov r4, #0 //registry for summing contents of an array
	mov r6, #0 //Registry for checking iteration time
loop:
	ldr r0, =inputNum //Format input here
	ldr r1, =phrase //store the address in phrase
	bl scanf

	ldr r2, =phrase //load the phrase to r2
	ldr r3, [r2] //move the content of phrase to r3
	add r4, r4, r3 //Sum the contents
	add r6, r6, #1 //Add one to the contents
	
	cmp r6, #4 //Compare if the contents are equal to 5
	ble loop//Repeat the loop and keep going for four times
	
	//bne loop//End loop
	ldr r0, =outputNum//Call output Num
	mov r1, r4//Move registry from r4 to r1
	bl printf //Call the print method
	

	terminate:
	ldr lr, [sp, #0]//Pop the stack
	add sp, sp, #0
	mov pc, lr//Terminate
