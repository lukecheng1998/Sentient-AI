#!/bin/sh

echo "[lab6] test 1"
echo "[lab6] compiling..."
echo "[lab6] running..."
gcc larger.s -o test1
for i in 0 1 2 3 4 5 6 7 8 9 
do
  filein="larger_in$i"
  fileout="larger_out$i"
  ./test1 < ./testcases/$filein > ./testcases/test1out.student
  diff ./testcases/test1out.student ./testcases/$fileout
done

echo "\n[lab6] test 2"
echo "[lab6] compiling..."
echo "[lab6] running..."
gcc length.s -o test2
for i in 0 1 2 3 4 5 6 7 8 9 
do
  filein="length_in$i"
  fileout="length_out$i"
  ./test2 < ./testcases/$filein > ./testcases/test2out.student
  diff ./testcases/test2out.student ./testcases/$fileout
done

echo "\n[lab6] test 3"
echo "[lab6] compiling..."
echo "[lab6] running..."
gcc sumarray.s -o test3
for i in 0 1 2 3 4 5 6 7 8 9 
do
  filein="sumarray_in$i"
  fileout="sumarray_out$i"
  ./test3 < ./testcases/$filein > ./testcases/test3out.student
  diff ./testcases/test3out.student ./testcases/$fileout
done

echo "\n[lab6] End of test. If diff outputs nothing, then all test case passed!"
