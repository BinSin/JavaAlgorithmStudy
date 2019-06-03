# 요일 정보

```java
Calendar c = Calendar.getInstance();
c.set(year, month - 1, day);
return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
```

