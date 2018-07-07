.data
numA: .word 0 //Store the number A here
numB: .word 0 //Store number B here
input: .string "%d" //Input a number in here
output: .asciz "%d\n" //Output a number here

.text
.global main


main:
	sub sp, sp, #4 //Push down stack by 4
	str lr, [sp, #0]//Load the first registry
	
	ldr r0, =input //Send a value r0
	ldr r1, =numA //load numA into r1
	bl scanf //Call scanf

	ldr r0, =input //send in a second value into r2
	ldr r1, =numB //load numB into r3
	bl scanf //Call scanf

	ldr r1, =numA//Load numA into r1
	ldr r2, [r1] //load the address of r2 into r1
	ldr r1, =numB //Load numB into r3
	ldr r3, [r1] //load the address of r3 into r1
	cmp r2, r3//compare r2 with r3

	bgt less_than//if values are less than, then execute the statement
	
	//Otherwise execute this if values are greater than
	ldr r0, =output//Load output into r0
	ldr r1, =numB//Load numB into r1
	ldr r1, [r1]//Load address of r1 into r1
	bl printf
	b skip//Skip the next statement if this is executed

	less_than://execute the less than statement
	ldr r0, =output//Load output into r0
	ldr r1, =numA//Load numA into r1
	ldr r1, [r1]//Load address of r1 into r1
	bl printf//Call for printf
	
	skip: //end skip
	
	ldr lr,[sp, #0]
	add sp, sp, #4//pop the stack up by 4
	mov pc, lr//Terminate?
	
