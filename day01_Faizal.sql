-- #2 No. 1
select  
    c.category_id,
	c.category_name, 
	count(1) as total_product 
from categories c
join products p on c.category_id = p.category_id  
group by 1
order by 2

-- #2 No. 2
select  
    s.supplier_id,
	s.company_name, 
	count(1) as total_product 
from suppliers s
join products p on s.supplier_id = p.supplier_id  
group by 1, 2
order by 3 desc

-- #2 No. 3
select  
    s.supplier_id,
	s.company_name, 
	count(1) as total_product,
	to_char(avg(p.unit_price), '99.99') as avg_unit_price
from suppliers s
join products p on s.supplier_id = p.supplier_id  
group by 1, 2
order by 3 desc

-- #2 No. 4
select
	p.product_id,
	product_name,
	s.supplier_id,
	s.company_name,
	unit_price,
	units_in_stock,
	units_on_order,
	reorder_level
from products p
join suppliers s on p.supplier_id = s.supplier_id
where p.units_in_stock <= p.reorder_level
order by 2 asc;

-- #2 No. 5
select
	c.customer_id,
	company_name,
	count(1) as total_order
from customers c
join orders o on c.customer_id = o.customer_id
group by 1
order by 2

-- #2 No. 6
select
	order_id,
	customer_id,
	order_date,
	required_date,
	shipped_date,
	shipped_date - order_date as delivery_time
from orders
where shipped_date - order_date > 10

-- #2 No. 7
select  
    p.product_id,
	p.product_name,
	sum(d.quantity) as total_qty 
from products p
join order_details d on p.product_id = d.product_id
join orders o on o.order_id = d.order_id
where o.shipped_date is not null
group by 1
order by 3 desc

-- #2 No. 8
select  
    c.category_id,
	c.category_name,
	sum(d.quantity) as total_qty_ordered 
from categories c
join products p on c.category_id = p.category_id
join order_details d on p.product_id = d.product_id
join orders o on o.order_id = d.order_id
where o.shipped_date is not null
group by 1
order by 3 desc

-- #2 No. 9
with soldot as (
    select
        c.category_id, 
        c.category_name,
        sum(d.quantity) as total_qty_ordered
    from products p
    join categories c on p.category_id = c.category_id
    join order_details d on p.product_id = d.product_id
	join orders o on o.order_id = d.order_id
	where o.shipped_date is not null
    group by 1
    order by 3 desc
)
select * from soldot
where total_qty_ordered = (select min(total_qty_ordered) from soldot) or
      total_qty_ordered = (select max(total_qty_ordered) from soldot)

-- #2 No. 10
select
	s.shipper_id,
	s.company_name,
	p.product_id,
	p.product_name,
	sum(d.quantity) AS total_qty_ordered
from shippers s
join orders o on s.shipper_id = o.ship_via
join order_details d on o.order_id = d.order_id
join products p on d.product_id = p.product_id
group by s.shipper_id, s.company_name, p.product_id, p.product_name
order by s.company_name, p.product_name

-- #2 No. 11
with tpc AS (
	select 
		s.shipper_id,
		s.company_name,
		p.product_id,
		p.product_name,
		sum(d.quantity) AS total_qty_ordered
	from shippers s
	join orders o on s.shipper_id = o.ship_via
	join order_details d on o.order_id = d.order_id
	join products p on d.product_id = p.product_id
	group by p.product_name, s.shipper_id, s.company_name, p.product_id),
	ranked as (
  		select *, rank() over (partition by company_name order by total_qty_ordered desc) as rank_max,
         		  rank() over (partition by company_name order by total_qty_ordered asc) as rank_min
  		from tpc
	)
	select
		shipper_id,
		company_name,
		product_id,
		product_name,
		total_qty_ordered
	from ranked
	where rank_max = 1 or rank_min = 1
	order by shipper_id, total_qty_ordered

-- #2 No. 12
set search_path to hr;
alter role postgres set search_path to hr;

with recursive hrk as (
    select
    	e.employee_id,
    	e.first_name||' '||last_name as full_name,
    	e.manager_id,
    	d.department_name,
    1 as level
    from employees e join departments d on e.department_id=d.department_id 
    where manager_id is null
    	union all
    select
    	e.employee_id,
    	e.first_name||' '||last_name as full_name,
    	e.manager_id,
    	d.department_name,
    	h.level + 1
    from employees e
    join departments d on p.department_id = d.department_id
    join hrk h on p.manager_id=h.employee_id
)
select * from hrk
order by employee_id