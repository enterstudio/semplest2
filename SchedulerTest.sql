insert into Frequency(Frequency) values ('Now')
insert into Frequency(Frequency) values ('Daily')
insert into Frequency(Frequency) values ('Weekly')
insert into Frequency(Frequency) values ('Monthly')

select s.SchedulePK, MIN(s.StartTime) MinStartTime from Schedule s
inner join ScheduleTaskAssociation st on s.SchedulePK=st.ScheduleFK
inner join Task t on t.TaskPK = st.TaskFK
where s.IsEnabled = 1 and s.IsComplete = 0
group by s.SchedulePK

select * from Frequency
--insert into Schedule(StartTime,IsEnabled,FrequencyFK,CreatedDate) values (CURRENT_TIMESTAMP,1,1,CURRENT_TIMESTAMP)
select * from Schedule
--insert into Task(ServiceName,MethodName,Parameters) values ('semplest.services.client.api.SemplestMailServiceClient','SendEmail','{"subject":"Test","msgTxt":"Hello there","from":"mberg@semplest.com","recipient":"mitch@semplest.com"}')
--insert into Task(ServiceName,MethodName,Parameters) values ('semplest.services.client.api.SemplestMailServiceClient','SendEmail','{"subject":"Test2","msgTxt":"Hello there again","from":"mberg@semplest.com","recipient":"mitch@semplest.com"}')
select * from Task
update Task set ServiceName = 'semplest.services.client.api.SemplestMailServiceClient'
--insert into ScheduleTaskAssociation(ScheduleFK,TaskFK,TaskExecutionOrder) values (2,1,0)
--insert into ScheduleTaskAssociation(ScheduleFK,TaskFK,TaskExecutionOrder) values (2,2,1)
select * from ScheduleTaskAssociation
select t.ServiceName,t.MethodName,t.Parameters,s.SchedulePK,st.TaskExecutionOrder from Schedule s 
inner join ScheduleTaskAssociation st on s.SchedulePK = st.ScheduleFK
inner join Task t on t.TaskPK = st.TaskFK
where s.SchedulePK =2 and s.IsEnabled = 1
order by st.TaskExecutionOrder
