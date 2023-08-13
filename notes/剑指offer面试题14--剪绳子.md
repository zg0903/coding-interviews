# 剑指offer面试题14--剪绳子

> ```
> 给你一根长度为n的绳子，把绳子剪成m段（m、n都是整数且m > 1, n > 1）,m段绳子的长度依然是整数，求m段绳子的长度乘积最大为多少？比如绳子长度为8，我们可以分成2段、3段、4段...8段，只有分成3段且长度分别是2、3、3时能得到最大乘积18
> ```

## 动态规划版本

要求大问题的最优解，可以将大问题分解成小问题，分解的小问题也有最优解，因此将小问题的最优解组合起来就能得到大问题的最优解。若将f(n)定义为将长度为n的绳子分成若干段后的各段长度的最大乘积（最优解），在剪第一刀时有n-1种剪法，可选择在`0 < i < n`处下刀；如在i处下刀，分成长度为i的左半绳子和长度为n - i的右半绳子，对于这两根绳子，定义最优解为f(i)和f(n-i)，于是`f(n) = max(f(i) * f(n-i))`，即求出各种相乘可能中的最大值就是f(n)的最优解。这两根绳子又可以继续分下去，就这样从上到下的分下去，但是问题的解决得从下到上来。因为f(2)、f(3)的很好求：

- f(2) = 1，因为只能分成两半
- f(3) = 2，因为分成两段`2*1` 大于分成三段的`1*1*1`
- 然后根据这两个最优解求出f(4)、f(5)...直到f(n)，每个f(i)的确定是**通过遍历所有可能的相乘情况，从中选出乘积最大者。**

```java
public static int maxProductAfterCutting(int length) {
    // 长度为1时不满足题意，返回0
    if (length < 2) {
        return 0;
    }
    // f(2)
    if (length == 2) {
        return 1;
    }
    // f(3)
    if (length == 3) {
        return 2;
    }
    // 加1是因为需要访问到products[length]
    int[] products = new int[length + 1];
    // 下面这三个存的不是f(1)、f(2)、f(3)，只是单纯的长度而已
    products[1] = 1;
    products[2] = 2;
    products[3] = 3;
    // 从products[4]到products[length]放的是f(4)~f(n)的值
    for (int i = 4; i <= length; i++) {
        int max = 0;

        // 对所有相乘情况进行遍历求出f(i)的最优解
        for (int j = 1; j <= i / 2; j++) {
            int product = products[j] * products[i - j];
            if (product > max) {
                max = product;
            }
        }
        // 得到f(i)的最优解
        products[i] = max;
    }
    // 返回f(n)
    return products[length];
}
```

对于长度为2或者3的绳子，可以直接返回答案。之后f(4)~f(n)的值存放在了products[4]~products[n]中，注意product[1]~products[3]中存放的不是f(1)~f(3)，它们单纯地表示长度而已，作为求出`f(i)，4 <= i <= n`的辅助。最后得到的f(n)存放在products[n]中，直接返回即可。第二层中的for循环为了得到f(i)，遍历了所有可能的乘积情况，将最大乘积赋予max。`j <= i / 2`是为了避免重复的相乘情况，比如i = 4时，只有`2*2`和`1*3 `两种，`3*1`和`1*3`是同一种相乘情况，所以j只到i / 2 = 2即可枚举所有相乘情况。

## 贪婪算法

我们应用贪婪算法解决问题时，每一步都可以做出一个贪婪的选择。基于这个选择，我们确定能得到问题的最优解。为什么能得到最优解，还需要数学证明来保证。

这道题我们按照下面的做法就能得到最优解：如果绳子长度n >= 5，就不断分出长度为3的绳子，如果最后只剩下长度为1的绳子，退一步，将得到长度为4的绳子，然后将这长度为4的绳子分成`2*2`(这样分是因为`2*2`大于原来的`3*1`)；因此n = 4时不能分出长度为3的绳子,而n = 2，n = 3的最优解可直接返回。

基于此写出代码。

```java
public static int maxProductAfterCutting2(int length) {
    // 长度为1时不满足题意，返回0
    if (length < 2) {
        return 0;
    }
    // f(2)
    if (length == 2) {
        return 1;
    }
    // f(3)
    if (length == 3) {
        return 2;
    }
    // 统计能分出多少段长度为3的绳子
    int timesOf3 = length / 3;
    // 如果最有只剩下长度为1的绳子，需要退一步，得到长度为4的绳子，重新分成2*2的
    if (length - timesOf3 * 3 == 1) {
        timesOf3--;
    }
    // 统计能分出多少段长度为2的绳子
    // 到这步length - timesOf3 * 3的值只可能是0,2,4，所以timesOf2只可能是0, 1, 2
    int timesOf2 = (length - timesOf3 * 3) / 2;
    return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);

}
```

---

by @sunhaiyu

2017.12.19
