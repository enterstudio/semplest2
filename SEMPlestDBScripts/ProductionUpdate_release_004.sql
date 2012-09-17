/*
update the status of existing campaigns
*/

--Live
insert into PromotionAdengineStatus(PromotionFK,AdvertisingEngineFK,PromotionStatusFK)
select p.PromotionPK, paes.AdvertisingEngineFK, 2 from Promotion p 
inner join PromotionAdEngineSelected paes on paes.PromotionFK = p.PromotionPK
left join AdvertisingEnginePromotion aep on aep.PromotionFK = p.PromotionPK
where p.IsLaunched = 1 and p.IsDeleted = 0 and p.IsPaused = 0 and 
p.PromotionPK not in (
--all promotions with status
select paes.PromotionFK from PromotionAdengineStatus paes
inner join PromotionStatus ps on ps.PromotionStatusPK = paes.PromotionStatusFK
group by paes.PromotionFK )
--order by p.PromotionPK

--pending
insert into PromotionAdengineStatus(PromotionFK,AdvertisingEngineFK,PromotionStatusFK)
select p.PromotionPK, paes.AdvertisingEngineFK, 1 from Promotion p 
inner join PromotionAdEngineSelected paes on paes.PromotionFK = p.PromotionPK
left join AdvertisingEnginePromotion aep on aep.PromotionFK = p.PromotionPK
where p.IsLaunched = 0 and  
p.PromotionPK not in (
--all promotions with status
select paes.PromotionFK from PromotionAdengineStatus paes
inner join PromotionStatus ps on ps.PromotionStatusPK = paes.PromotionStatusFK
group by paes.PromotionFK )
--order by p.PromotionPK

--paused
insert into PromotionAdengineStatus(PromotionFK,AdvertisingEngineFK,PromotionStatusFK)
select p.PromotionPK, paes.AdvertisingEngineFK, 3 from Promotion p 
inner join PromotionAdEngineSelected paes on paes.PromotionFK = p.PromotionPK
left join AdvertisingEnginePromotion aep on aep.PromotionFK = p.PromotionPK
where p.IsPaused = 1 and  
p.PromotionPK not in (
--all promotions with status
select paes.PromotionFK from PromotionAdengineStatus paes
inner join PromotionStatus ps on ps.PromotionStatusPK = paes.PromotionStatusFK
group by paes.PromotionFK )
--order by p.PromotionPK