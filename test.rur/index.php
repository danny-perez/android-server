<?php
$arr = array(2,3,4,1,2,-2,-1,3,4,5,6,-1,-2,1)
//if($arr==null||count($arr)==0){echo "empty array"; die('stop');}
    
    $maxSumStartIndex = 0;
    $maxSumLastIndex = 0;
    $maxSum = arr[0];
    
    $lastSumStartIndex = 0;
    $lastSum = arr[0];
    
    for ($i=1; $i<count(arr); $i++) {

        $lastSum += $arr[i];
        if ($lastSum < $arr[i]) {
            $lastSum = $arr[i];
            $lastSumStartIndex = i;
        }
        
        if ($maxSum < $lastSum) {
            $maxSumStartIndex = $lastSumStartIndex;
            $maxSumLastIndex = $i;
            $maxSum = $lastSum;
        }
    }
    
    echo 'max=',$maxSum;
    ?>
