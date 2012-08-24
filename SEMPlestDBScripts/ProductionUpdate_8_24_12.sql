---
--- CREATE COLUMN: AllowAutobid
---
ALTER TABLE dbo.Customer ADD AllowAutobid bit NOT NULL DEFAULT 0
GO
---
--- CREATE COLUMN: IsAutobid
---
ALTER TABLE dbo.Promotion ADD IsAutobid bit NOT NULL DEFAULT 0
GO
---
--- CREATE COLUMN: MaxCPC
---
ALTER TABLE dbo.Promotion ADD AutoBidMaxCPC money
GO
