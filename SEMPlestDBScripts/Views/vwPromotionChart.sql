USE [semplest]
GO

/****** Object:  View [dbo].[vwPromotionChart]    Script Date: 06/01/2012 10:15:39 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[vwPromotionChart]
AS
SELECT     k.Keyword, p.PromotionName, a.NumberImpressions, a.NumberClick, kb.AdvertisingEngineFK, kb.PromotionFK, a.TransactionDate, a.MicroBidAmount, 
                      a.AveragePosition, a.AverageCPC, a.AdvertisingEngineBidDataPK, u.UserPK, kb.IsActive
FROM         dbo.KeywordBid AS kb INNER JOIN
                      dbo.AdvertisingEngineReportData AS a ON kb.KeywordBidPK = a.KeywordBidFK INNER JOIN
                      dbo.Keyword AS k ON kb.KeywordFK = k.KeywordPK INNER JOIN
                      dbo.Promotion AS p ON kb.PromotionFK = p.PromotionPK INNER JOIN
                      dbo.ProductGroup AS pg ON p.ProductGroupFK = pg.ProductGroupPK INNER JOIN
                      dbo.Customer AS c ON pg.CustomerFK = c.CustomerPK INNER JOIN
                      dbo.Users AS u ON c.CustomerPK = u.CustomerFK

GO

EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[28] 2[13] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "kb"
            Begin Extent = 
               Top = 6
               Left = 316
               Bottom = 273
               Right = 514
            End
            DisplayFlags = 280
            TopColumn = 9
         End
         Begin Table = "a"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 280
               Right = 278
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "k"
            Begin Extent = 
               Top = 6
               Left = 552
               Bottom = 125
               Right = 712
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "p"
            Begin Extent = 
               Top = 6
               Left = 750
               Bottom = 125
               Right = 965
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "pg"
            Begin Extent = 
               Top = 6
               Left = 1003
               Bottom = 125
               Right = 1185
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "c"
            Begin Extent = 
               Top = 156
               Left = 720
               Bottom = 275
               Right = 937
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "u"
            Begin Extent = 
               Top = 156
               Left = 1036
               Bottom = 275
               Right = 1196
            End
            DisplayFlags = 280
            TopColumn = 0
         End' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'vwPromotionChart'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 15
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 2415
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'vwPromotionChart'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'vwPromotionChart'
GO

