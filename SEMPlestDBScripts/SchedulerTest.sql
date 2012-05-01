insert into Frequency(Frequency) values ('Now')
insert into Frequency(Frequency) values ('Daily')
insert into Frequency(Frequency) values ('Weekly')
insert into Frequency(Frequency) values ('Monthly')

Insert into AdvertisingEngine(AdvertisingEngine) VALUES ('MSN')
Insert into AdvertisingEngine(AdvertisingEngine) VALUES ('Google')

insert into BidType(BidType) values ('Broad')
insert into BidType(BidType) values ('Exact')
insert into BidType(BidType) values ('Phrase')

select s.SchedulePK, MIN(s.StartTime) MinStartTime from Schedule s
inner join ScheduleTaskAssociation st on s.SchedulePK=st.ScheduleFK
inner join Task t on t.TaskPK = st.TaskFK
where s.IsEnabled = 1 and s.IsComplete = 0
group by s.SchedulePK

select * from Frequency
--insert into Schedule(ScheduleName,StartTime,EndDate,FrequencyFK,IsEnabled,IsInactive,PromotionFK,CustomerFK,ProductGroupFK,UsersFK) values (null,CURRENT_TIMESTAMP,1,1,CURRENT_TIMESTAMP)
select * from Schedule
--update Schedule set FrequencyFK = 2 --Daily 
--insert into Task(ServiceName,MethodName,Parameters) values ('semplest.services.client.api.SemplestMailServiceClient','SendEmail','{"subject":"Test","msgTxt":"Hello there","from":"mberg@semplest.com","recipient":"mitch@semplest.com"}')
--insert into Task(ServiceName,MethodName,Parameters) values ('semplest.services.client.api.SemplestMailServiceClient','SendEmail','{"subject":"Test2","msgTxt":"Hello there again","from":"mberg@semplest.com","recipient":"mitch@semplest.com"}')
select * from Task
update Task set ServiceName = 'semplest.services.client.api.SemplestMailServiceClient'
--insert into ScheduleTaskAssociation(ScheduleFK,TaskFK,TaskExecutionOrder) values (2,1,0)
--insert into ScheduleTaskAssociation(ScheduleFK,TaskFK,TaskExecutionOrder) values (1,2,1)
select * from ScheduleTaskAssociation
--insert into ScheduleJob(ScheduleFK,ExecutionStartTime,IsComplete,IsSuccessful) values (2,CURRENT_TIMESTAMP,0,0)
select * from ScheduleJob
--delete from ScheduleLog
--delete from ScheduleJob where ScheduleJobPK=2
--update ScheduleJob set IsComplete=0,IsSuccessful=0

select t.ServiceName,t.MethodName,t.Parameters,s.SchedulePK,st.TaskExecutionOrder from Schedule s 
inner join ScheduleTaskAssociation st on s.SchedulePK = st.ScheduleFK
inner join Task t on t.TaskPK = st.TaskFK
where s.SchedulePK =2 and s.IsEnabled = 1
order by st.TaskExecutionOrder

SELECT dbo.GetNextScheduleTime(CURRENT_TIMESTAMP, 'Weekly');

select * from Customer
select * from AdvertisingEngineAccount
--add Google account 123 customerID 2
insert into AdvertisingEngineAccount(AdvertisingEngineAccountPK,AdvertisingEngineFK,CustomerFK)
select '123',ae.AdvertisingEnginePK,2 from AdvertisingEngine ae where ae.AdvertisingEngine = 'Google'
select * from ProductGroup --product group pk = 3
insert into Promotion(ProductGroupFK,LandingPageURL,CycleBudgetAmount,StartDate, IsPaused,CreatedDate)
values (3,'',50.00,CURRENT_TIMESTAMP,0,CURRENT_TIMESTAMP)
select * from Promotion
declare @ID int
execute dbo.SetBidObject 3,2,100,'My Keyword',1000000,'Pending','Exact',null,1,1,1,0,'Google',@ID
select @ID
s

select * from Keyword
select * from KeywordBid
select * from PromotionKeywordAssociation
select * from BidType

select a.AdvertisingEngineAccountPK from AdvertisingEngineAccount a
inner join AdvertisingEngine e on e.AdvertisingEnginePK = a.AdvertisingEngineFK
where a.CustomerFK = 2 and e.AdvertisingEngine = 'Google'

select * from Customer
select a.AdvertisingEngineAccountPK, c.Name from AdvertisingEngineAccount a
inner join Customer c on c.CustomerPK = a.CustomerFK 
left join AdvertisingEngine e on e.AdvertisingEnginePK = a.AdvertisingEngineFK  
 where a.CustomerFK = 12 and e.AdvertisingEngine = 'Google'
 
 select * from Customer c
 left join AdvertisingEngineAccount a on c.CustomerPK = a.CustomerFK
left join AdvertisingEngine ae on ae.AdvertisingEnginePK = a.AdvertisingEngineFK
  where c.CustomerPK = 12 and (ae.AdvertisingEngine is null or ae.AdvertisingEngine = 'Google')
  
  insert into AdvertisingEnginePromotion(AdvertisingEngineCampaignPK,PromotionFK,AdvertisingEngineAccountFK,IsSearchNetwork,IsDisplayNetwork,AdvertisingEngineBudget)
  VALUES ()
  
  select p.PromotionPK,p.ProductGroupFK,p.p from Promotion p where p.PromotionPK =1 
  declare @res datetime2
  select @res = dbo.GetNextScheduleTime(CURRENT_TIMESTAMP, 'Daily');
  select @res

