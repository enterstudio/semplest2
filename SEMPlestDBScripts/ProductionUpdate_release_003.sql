update configuration set ReminderEmailUrlPrefix ='https://www.semplest.com/profile/verify?token='
GO
  
ALTER TABLE Configuration ADD SemplestKeywordslucenedir varchar(100)
go

ALTER TABLE Configuration ADD SemplestKeywordsbdbdir varchar(100)
go

ALTER TABLE Configuration ADD SemplestKeywordsdffile varchar(100)
go

ALTER TABLE Configuration ADD numTopics varchar(100)
go


update Configuration set SemplestKeywordslucenedir = 'data/dmoz/lucene/'
go

update Configuration set SemplestKeywordsbdbdir = 'data/dmoz/bdb/'
go

update Configuration set SemplestKeywordsdffile = 'data/word.dict'
go

update Configuration set numTopics = 120
go