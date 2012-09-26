/*
update the status of existing campaigns
*/
---
--- CREATE COLUMN: KeywordTopPercent
---
ALTER TABLE dbo.Configuration ADD KeywordTopPercent float DEFAULT 0.65
GO

update Configuration set KeywordTopPercent = 0.65

insert into Job values ('CLEANER', GETDATE())

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

