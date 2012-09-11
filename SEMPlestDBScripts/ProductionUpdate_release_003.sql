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

---
--- CREATE TABLE: dbo.UserType
---
CREATE TABLE dbo.UserType
(
	UserTypePK int NOT NULL IDENTITY,
	UserType varchar(50) NOT NULL,
	PRIMARY KEY CLUSTERED (UserTypePK)
)
GO
---
--- CREATE COLUMN: UserTypeFK
---
ALTER TABLE dbo.Users ADD UserTypeFK int
GO
---
--- CREATE FOREIGN KEY CONSTRAINT: REL_UserType_Users_2
---
ALTER TABLE dbo.Users ADD 
	CONSTRAINT REL_UserType_Users_2 FOREIGN KEY (UserTypeFK)
		REFERENCES dbo.UserType(UserTypePK)
GO

---
--- CREATE COLUMN: IsKeywordServiceOnly
---
ALTER TABLE dbo.Promotion ADD IsKeywordServiceOnly bit NOT NULL DEFAULT 1
GO

insert into UserType(UserType) Values ('KeywordOnly')
insert into UserType(UserType) Values ('KeywordBid')