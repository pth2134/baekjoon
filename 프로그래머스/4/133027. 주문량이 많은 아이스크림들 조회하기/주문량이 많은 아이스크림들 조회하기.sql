SELECT h.FLAVOR
from first_half h 
left join (
    select min(shipment_id) as SHIPMENT_ID, FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
    from july
    group by flavor
) j
on h.shipment_id = j.shipment_id
order by (h.total_order + j.total_order) desc
limit 3
