# Java Lambda Expressions
�ĺ��� ���� ���� ������ �Լ� ǥ����

```
( parameters ) -> expression body
( parameters ) -> { expression body }
() -> { expression body }
() -> expression body
```

# BigInteger
������ �����ϸ� �Ҽ��� Ȯ���� �ƴ� ��쿡�� false�� return,

�Ҽ��� ���� Ȯ���� 1-(1/2)^certainty �̻��� ��� true�� return �Ѵ�.

```
BigInteger.valueof(n).isProbablePrime(int certainty);
```

# IntStream

## range, noneMatch
```
return n -> IntStream.range(2, (int) Math.sqrt(n+1)).noneMatch(i -> n%i == 0);
```

# StringBuilder
```
new StringBuilder(Integer.toString(n)).reverse().toString()
```

# ��Ŭ���� �ڵ� �ٸ���
ctrl + shift + f

