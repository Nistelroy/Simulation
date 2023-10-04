package ru.yandex.practicum.process;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class  Sort
{
    // Функция для поиска `k` элементов, ближайших к `target`, в отсортированном целочисленном массиве `nums`
    public static List<Integer> findKClosestElements(int[] nums, int k, int target)
    {
        int left = 0;
        int right = nums.length - 1;

        while (right - left >= k)
        {
            if (Math.abs(nums[left] - target) > Math.abs(nums[right] - target)) {
                left++;
            }
            else {
                right--;
            }
        }

        return Arrays.stream(nums, left, right + 1).boxed()
                .collect(Collectors.toList());
    }



}