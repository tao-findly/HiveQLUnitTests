create table sales_by_shop
as select shop, sum(amount) amount
from sales
group by shop