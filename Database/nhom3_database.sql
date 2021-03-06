USE [database]
GO
/****** Object:  UserDefinedFunction [dbo].[fnSplit]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[fnSplit](
    @sInputList NVARCHAR(MAX) -- List of delimited items
  , @sDelimiter NVARCHAR(MAX) = ',' -- delimiter that separates items
) RETURNS @List TABLE (item NVARCHAR(MAX))

BEGIN
DECLARE @sItem VARCHAR(8000)
WHILE CHARINDEX(@sDelimiter,@sInputList,0) <> 0
 BEGIN
 SELECT
  @sItem=RTRIM(LTRIM(SUBSTRING(@sInputList,1,CHARINDEX(@sDelimiter,@sInputList,0)-1))),
  @sInputList=RTRIM(LTRIM(SUBSTRING(@sInputList,CHARINDEX(@sDelimiter,@sInputList,0)+LEN(@sDelimiter),LEN(@sInputList))))
 
 IF LEN(@sItem) > 0
  INSERT INTO @List SELECT @sItem
 END

IF LEN(@sInputList) > 0
 INSERT INTO @List SELECT @sInputList -- Put the last item in
RETURN
END

GO
/****** Object:  Table [dbo].[Account]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[accountId] [nvarchar](50) NOT NULL,
	[createdOn] [date] NULL,
	[createdBy] [date] NULL,
	[modifiedOn] [date] NULL,
	[modifiedBy] [nvarchar](200) NULL,
	[createdOnBehalfBy] [nvarchar](200) NULL,
	[modifiedOnBehalfBy] [nvarchar](200) NULL,
	[overriddenCreatedOn] [date] NULL,
	[importSequenceNumber] [int] NULL,
	[ownerIdType] [nvarchar](max) NULL,
	[ownerId] [nvarchar](50) NULL,
	[owningBusinessUnit] [nvarchar](200) NULL,
	[owningUser] [nvarchar](200) NULL,
	[owningTeam] [nvarchar](200) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[accountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Admin]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Admin](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](50) NULL,
	[Password] [varchar](32) NULL,
	[Name] [nvarchar](100) NULL,
	[IsDeleted] [bit] NULL CONSTRAINT [DF_Admin_IsDelete]  DEFAULT ((0)),
	[IsActive] [bit] NULL CONSTRAINT [DF_Admin_IsActive]  DEFAULT ((1)),
	[AdminRoleID] [int] NULL,
	[CompanyID] [int] NULL,
	[GroupAdminPositionID] [int] NULL,
	[IsManager] [bit] NULL CONSTRAINT [DF_Admin_IsManager]  DEFAULT ((0)),
	[Gender] [tinyint] NULL,
	[urlAvatar] [varchar](500) NULL,
	[INF_PlaceOfBirth] [nvarchar](30) NULL,
	[INF_DateOfBirth] [datetime] NULL,
	[INF_Country] [nvarchar](30) NULL,
	[INF_Nation] [nvarchar](30) NULL CONSTRAINT [DF__Admin__INF_Natio__1367E606]  DEFAULT (N'Việt Nam'),
	[INF_SourceNation] [nvarchar](30) NULL CONSTRAINT [DF__Admin__INF_Sourc__145C0A3F]  DEFAULT ('Kinh'),
	[INF_AddressReg] [nvarchar](100) NULL,
	[INF_Address] [nvarchar](100) NULL,
	[INF_BankName] [varchar](100) NULL,
	[INF_BankAccount] [varchar](100) NULL,
	[Admincode] [varchar](20) NULL,
	[CreatedDate] [datetime] NULL CONSTRAINT [DF_Admin_CreatedDate]  DEFAULT (getdate()),
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
	[phone] [varchar](20) NULL,
	[IdentityCard] [int] NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [IX_Admin] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [IX_Admin_1] UNIQUE NONCLUSTERED 
(
	[Admincode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_3p0bq3dufa8up1u1w57929vcx] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AdminLogs]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AdminLogs](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CreatedDate] [datetime2](7) NULL,
	[LogContent] [varchar](255) NULL,
	[AdminID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AdminModule]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AdminModule](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Controller] [varchar](150) NULL,
	[Icon] [varchar](50) NULL,
	[IsDeleted] [bit] NULL CONSTRAINT [DF_AdminModule_IsDeleted]  DEFAULT ((0)),
	[IsShow] [bit] NULL,
	[level] [int] NULL,
	[Name] [nvarchar](255) NULL,
	[OrderNumber] [int] NULL,
	[routeLink] [varchar](150) NULL,
	[ParentID] [int] NULL,
 CONSTRAINT [PK__AdminMod__3214EC27390EBE2F] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AdminRole]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AdminRole](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[isActive] [bit] NULL CONSTRAINT [DF_RoleAdmin_isActive]  DEFAULT ((1)),
	[isDeleted] [bit] NULL CONSTRAINT [DF_RoleAdmin_Isdeleted]  DEFAULT ((0)),
	[Level] [tinyint] NULL,
	[Code] [varchar](100) NULL,
	[ModuleIDs] [varchar](max) NULL,
	[ModuleUrls] [varchar](max) NULL,
 CONSTRAINT [PK__AdminRol__3214EC2766B32EC1] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Company]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Company](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Code] [varchar](20) NULL,
	[CreatedDate] [datetime] NULL CONSTRAINT [DF_Company_CreatedDate]  DEFAULT (getdate()),
	[IsDeleted] [bit] NULL CONSTRAINT [DF_Company_IsDelete]  DEFAULT ((0)),
	[IsActive] [bit] NULL CONSTRAINT [DF_Company_IsActive]  DEFAULT ((1)),
	[UrlAvatar] [varchar](500) NULL,
	[Address] [nvarchar](2000) NULL,
	[Mobile] [varchar](50) NULL,
	[Email] [varchar](100) NULL,
 CONSTRAINT [PK_Company] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ__Company__A25C5AA787B74210] UNIQUE NONCLUSTERED 
(
	[Code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CreditPlan]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CreditPlan](
	[creditPlanId] [nvarchar](50) NOT NULL,
	[createdOn] [date] NULL,
	[createdBy] [nvarchar](500) NULL,
	[modifiedOn] [date] NULL,
	[modifiedBy] [nvarchar](500) NULL,
	[createdOnBehalfBy] [nvarchar](500) NULL,
	[modifiedOnBehalfBy] [nvarchar](500) NULL,
	[overriddenCreatedOn] [date] NULL,
	[importSequenceNumber] [int] NULL,
	[ownerIdType] [nvarchar](50) NULL,
	[ownerId] [nvarchar](50) NULL,
	[owningBusinessUnit] [nvarchar](50) NULL,
	[owningUser] [nvarchar](50) NULL,
	[owningTeam] [nvarchar](50) NULL,
	[timeZoneRuleVersionNumber] [int] NULL,
	[UTCConversionTimeZoneCode] [int] NULL,
	[versionNumber] [int] NULL,
	[stateCode] [int] NULL,
	[stateCode_display] [nvarchar](500) NULL,
	[statusCode] [int] NULL,
	[statusCode_display] [nvarchar](500) NULL,
	[creditPlanAccountId] [nvarchar](50) NULL,
	[creditPlanCampaignId] [nvarchar](50) NULL,
	[creditPlanPaymentScheduleId] [nvarchar](50) NULL,
	[creditType] [int] NULL,
	[creditType_display] [nvarchar](500) NULL,
	[validToDate] [date] NULL,
 CONSTRAINT [PK_CreditPlan] PRIMARY KEY CLUSTERED 
(
	[creditPlanId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CreditPlanRecipient]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CreditPlanRecipient](
	[creditRecipientId] [nvarchar](50) NOT NULL,
	[createdOn] [date] NULL,
	[createdBy] [nvarchar](500) NULL,
	[modifiedOn] [date] NULL,
	[modifiedBy] [nvarchar](500) NULL,
	[createdOnBehalfBy] [nvarchar](500) NULL,
	[modifiedOnBehalfBy] [nvarchar](500) NULL,
	[overriddenCreatedOn] [date] NULL,
	[importSequenceNumber] [int] NULL,
	[ownerIdType] [nvarchar](50) NULL,
	[ownerId] [nvarchar](50) NULL,
	[owningBusinessUnit] [nvarchar](50) NULL,
	[owningUser] [nvarchar](50) NULL,
	[owningTeam] [nvarchar](50) NULL,
	[timeZoneRuleVersionNumber] [int] NULL,
	[UTCConversionTimeZoneCode] [int] NULL,
	[versionNumber] [int] NULL,
	[stateCode] [int] NULL,
	[stateCode_display] [nvarchar](500) NULL,
	[statusCode] [int] NULL,
	[statusCode_display] [nvarchar](500) NULL,
	[name] [nvarchar](500) NULL,
	[creditPlanRecipientCustomerIdType] [nvarchar](500) NULL,
	[creditPlanRecipientCustomerId] [nvarchar](50) NULL,
	[creditRecipientCreditPlanId] [nvarchar](50) NULL,
	[percentageOfPayment] [decimal](18, 2) NULL,
	[softCreditReason] [int] NULL,
	[softCreditReason_display] [nvarchar](500) NULL,
 CONSTRAINT [PK_CreditPlanRecipient] PRIMARY KEY CLUSTERED 
(
	[creditRecipientId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Ledger]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ledger](
	[ledgerId] [nvarchar](50) NOT NULL,
	[name] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[companyKey] [nvarchar](50) NULL,
	[accountingCurrencyKey] [nvarchar](50) NULL,
 CONSTRAINT [PK_Ledger] PRIMARY KEY CLUSTERED 
(
	[ledgerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MainAccount]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MainAccount](
	[mainAccountId] [nvarchar](50) NOT NULL,
	[name] [nvarchar](max) NULL,
	[number] [nvarchar](50) NULL,
	[mainAccountCategoryKey] [nvarchar](50) NULL,
	[currencyKey] [nvarchar](50) NULL,
 CONSTRAINT [PK_MainAccount] PRIMARY KEY CLUSTERED 
(
	[mainAccountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MainAccountCategory]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MainAccountCategory](
	[mainAccountCategoryId] [nvarchar](50) NOT NULL,
	[name] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[isClosed] [tinyint] NULL,
	[accountType] [int] NULL,
	[accountType_display] [nvarchar](500) NULL,
 CONSTRAINT [PK_MainAccountCategory] PRIMARY KEY CLUSTERED 
(
	[mainAccountCategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PaymentAsset]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentAsset](
	[paymentAssetId] [nvarchar](50) NOT NULL,
	[createdOn] [date] NULL,
	[createdBy] [nvarchar](500) NULL,
	[modifiedOn] [date] NULL,
	[modifiedBy] [nvarchar](500) NULL,
	[createdOnBehalfBy] [nvarchar](500) NULL,
	[modifiedOnBehalfBy] [nvarchar](500) NULL,
	[overriddenCreatedOn] [date] NULL,
	[importSequenceNumber] [int] NULL,
	[ownerIdType] [nvarchar](50) NULL,
	[ownerId] [nvarchar](50) NULL,
	[owningBusinessUnit] [nvarchar](50) NULL,
	[owningUser] [nvarchar](50) NULL,
	[owningTeam] [nvarchar](50) NULL,
	[timeZoneRuleVersionNumber] [int] NULL,
	[UTCConversionTimeZoneCode] [int] NULL,
	[versionNumber] [int] NULL,
	[stateCode] [int] NULL,
	[stateCode_display] [nvarchar](500) NULL,
	[statusCode] [int] NULL,
	[statusCode_display] [nvarchar](500) NULL,
	[name] [nvarchar](500) NULL,
	[amount] [decimal](18, 2) NULL,
	[transactionCurrencyId] [nvarchar](50) NULL,
	[exchangeRate] [decimal](18, 2) NULL,
	[amountBase] [decimal](18, 2) NULL,
	[assetType] [int] NULL,
	[assetType_display] [nvarchar](500) NULL,
	[bookDate] [date] NULL,
	[description] [nvarchar](max) NULL,
	[originalAssetAdjustedId] [nvarchar](50) NULL,
	[paymentAssetPlannedGivingId] [nvarchar](50) NULL,
	[paymentAssetPledgedAsset] [nvarchar](500) NULL,
	[paymentAssetCategory] [int] NULL,
	[paymentAssetCategory_display] [nvarchar](500) NULL,
	[paymentAssetSubcategory] [int] NULL,
	[paymentAssetSubcategory_display] [nvarchar](500) NULL,
	[pledgedOnPaymentScheduleId] [nvarchar](50) NULL,
	[quantity] [decimal](18, 2) NULL,
	[symbol] [nvarchar](100) NULL,
	[transferredOnTransactionId] [nvarchar](50) NULL,
 CONSTRAINT [PK_PaymentAsset] PRIMARY KEY CLUSTERED 
(
	[paymentAssetId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PaymentMethod]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentMethod](
	[paymentMethodId] [nvarchar](50) NOT NULL,
	[createdOn] [date] NULL,
	[createdBy] [nvarchar](500) NULL,
	[modifiedOn] [date] NULL,
	[modifiedBy] [nvarchar](500) NULL,
	[createdOnBehalfBy] [nvarchar](500) NULL,
	[modifiedOnBehalfBy] [nvarchar](500) NULL,
	[overriddenCreatedOn] [date] NULL,
	[importSequenceNumber] [int] NULL,
	[ownerIdType] [nvarchar](50) NULL,
	[ownerId] [nvarchar](50) NULL,
	[owningBusinessUnit] [nvarchar](50) NULL,
	[owningUser] [nvarchar](50) NULL,
	[owningTeam] [nvarchar](50) NULL,
	[timeZoneRuleVersionNumber] [int] NULL,
	[UTCConversionTimeZoneCode] [int] NULL,
	[versionNumber] [int] NULL,
	[stateCode] [int] NULL,
	[stateCode_display] [nvarchar](500) NULL,
	[statusCode] [int] NULL,
	[statusCode_display] [nvarchar](500) NULL,
	[name] [nvarchar](500) NULL,
	[comments] [nvarchar](max) NULL,
	[contactId] [nvarchar](50) NULL,
	[isDefault] [tinyint] NULL,
	[lastAuthenticationStatus] [int] NULL,
	[lastAuthenticationStatus_display] [nvarchar](500) NULL,
	[lastAuthenticationStatusDate] [date] NULL,
	[lastAuthenticationStatusDetail] [nvarchar](500) NULL,
	[lastAuthenticationStatusTechnicalDetail] [nvarchar](max) NULL,
	[paymentScheduleId] [nvarchar](50) NULL,
	[payorId] [nvarchar](50) NULL,
	[transactionId] [nvarchar](50) NULL,
	[type] [int] NULL,
	[type_display] [nvarchar](500) NULL,
 CONSTRAINT [PK_PaymentMethod] PRIMARY KEY CLUSTERED 
(
	[paymentMethodId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PaymentProcessor]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentProcessor](
	[paymentProcessorId] [nvarchar](50) NOT NULL,
	[createdOn] [date] NULL,
	[createdBy] [nvarchar](500) NULL,
	[modifiedOn] [date] NULL,
	[modifiedBy] [nvarchar](500) NULL,
	[createdOnBehalfBy] [nvarchar](500) NULL,
	[modifiedOnBehalfBy] [nvarchar](500) NULL,
	[overriddenCreatedOn] [date] NULL,
	[importSequenceNumber] [int] NULL,
	[ownerIdType] [nvarchar](50) NULL,
	[ownerId] [nvarchar](50) NULL,
	[owningBusinessUnit] [nvarchar](50) NULL,
	[owningUser] [nvarchar](50) NULL,
	[owningTeam] [nvarchar](50) NULL,
	[timeZoneRuleVersionNumber] [int] NULL,
	[UTCConversionTimeZoneCode] [int] NULL,
	[versionNumber] [int] NULL,
	[stateCode] [int] NULL,
	[stateCode_display] [nvarchar](500) NULL,
	[statusCode] [int] NULL,
	[statusCode_display] [nvarchar](500) NULL,
	[name] [nvarchar](500) NULL,
 CONSTRAINT [PK_PaymentProcessor] PRIMARY KEY CLUSTERED 
(
	[paymentProcessorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PaymentSchedule]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentSchedule](
	[paymentScheduleId] [nvarchar](50) NOT NULL,
	[createdOn] [date] NULL,
	[createdBy] [nvarchar](500) NULL,
	[modifiedOn] [date] NULL,
	[modifiedBy] [nvarchar](500) NULL,
	[createdOnBehalfBy] [nvarchar](500) NULL,
	[modifiedOnBehalfBy] [nvarchar](500) NULL,
	[overriddenCreatedOn] [date] NULL,
	[importSequenceNumber] [int] NULL,
	[ownerIdType] [nvarchar](50) NULL,
	[ownerId] [nvarchar](50) NULL,
	[owningBusinessUnit] [nvarchar](50) NULL,
	[owningUser] [nvarchar](50) NULL,
	[owningTeam] [nvarchar](50) NULL,
	[timeZoneRuleVersionNumber] [int] NULL,
	[UTCConversionTimeZoneCode] [int] NULL,
	[versionNumber] [int] NULL,
	[stateCode] [int] NULL,
	[stateCode_display] [nvarchar](500) NULL,
	[statusCode] [int] NULL,
	[statusCode_display] [nvarchar](500) NULL,
	[name] [nvarchar](500) NULL,
	[firstPaymentDate] [date] NULL,
	[frequency] [int] NULL,
	[frequency_display] [nvarchar](500) NULL,
	[frequencyInterval] [int] NULL,
	[lastPaymentDate] [date] NULL,
	[nextPaymentAmount] [decimal](18, 2) NULL,
	[transactionCurrencyId] [nvarchar](50) NULL,
	[exchangeRate] [decimal](18, 2) NULL,
	[nextPaymentAmountBase] [decimal](18, 2) NULL,
	[nextPaymentDate] [date] NULL,
	[numberOfPayments] [int] NULL,
	[omtSchedDefaultHardCreditToCustomer] [nvarchar](50) NULL,
	[paymentScheduleDonorCommitmentId] [nvarchar](50) NULL,
	[receiptOnAccountId] [nvarchar](50) NULL,
	[recurringAmount] [decimal](18, 2) NULL,
	[recurringamountBase] [decimal](18, 2) NULL,
	[totalAmount] [decimal](18, 2) NULL,
	[totalamountBase] [decimal](18, 2) NULL,
 CONSTRAINT [PK_PaymentSchedule] PRIMARY KEY CLUSTERED 
(
	[paymentScheduleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Transactions]    Script Date: 19/10/2019 1:25:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transactions](
	[transactionId] [nvarchar](50) NOT NULL,
	[createdOn] [date] NULL,
	[createdBy] [nvarchar](500) NULL,
	[modifiedOn] [date] NULL,
	[modifiedBy] [nvarchar](500) NULL,
	[createdOnBehalfBy] [nvarchar](500) NULL,
	[modifiedOnBehalfBy] [nvarchar](500) NULL,
	[overriddenCreatedOn] [date] NULL,
	[importSequenceNumber] [int] NULL,
	[ownerIdType] [nvarchar](50) NULL,
	[ownerId] [nvarchar](50) NULL,
	[owningBusinessUnit] [nvarchar](50) NULL,
	[owningUser] [nvarchar](50) NULL,
	[owningTeam] [nvarchar](50) NULL,
	[timeZoneRuleVersionNumber] [int] NULL,
	[UTCConversionTimeZoneCode] [int] NULL,
	[versionNumber] [int] NULL,
	[stateCode] [int] NULL,
	[stateCode_display] [nvarchar](500) NULL,
	[statusCode] [int] NULL,
	[statusCode_display] [nvarchar](500) NULL,
	[name] [nvarchar](200) NULL,
	[adjustmentComment] [nvarchar](2000) NULL,
	[adjustmentReason] [int] NULL,
	[adjustmentReason_display] [nvarchar](500) NULL,
	[adjustmentType] [int] NULL,
	[adjustmentType_display] [nvarchar](500) NULL,
	[amount] [decimal](18, 2) NULL,
	[transactionCurrencyId] [nvarchar](50) NULL,
	[exchangeRate] [decimal](18, 2) NULL,
	[amountBase] [decimal](18, 2) NULL,
	[anonymity] [int] NULL,
	[anonymity_display] [nvarchar](500) NULL,
	[bookDate] [date] NULL,
	[dataEntryReference] [nvarchar](500) NULL,
	[dataEntrySource] [int] NULL,
	[dataEntrySource_display] [nvarchar](500) NULL,
	[effectiveCampaignId] [nvarchar](50) NULL,
	[effectiveSourceCode] [nvarchar](500) NULL,
	[exchangeRateDate] [date] NULL,
	[isAdjusted] [tinyint] NULL,
	[originalTxnAdjustedId] [nvarchar](50) NULL,
	[originatingCampaignId] [nvarchar](50) NULL,
	[originatingSourceCode] [nvarchar](500) NULL,
	[postedDate] [date] NULL,
	[receivedDate] [date] NULL,
	[transactionPaymentMethodId] [nvarchar](50) NULL,
	[transactionPaymentScheduleId] [nvarchar](50) NULL,
	[transactionReceiptOnAccountId] [nvarchar](50) NULL,
	[currencyValueDate] [date] NULL,
	[description] [nvarchar](max) NULL,
	[disbursementChannelId] [nvarchar](50) NULL,
	[financeTypeId] [nvarchar](50) NULL,
	[flowTypeId] [nvarchar](50) NULL,
	[humanitarian] [tinyint] NULL,
	[providerActivityIdentifier] [nvarchar](100) NULL,
	[providerOrganizationId] [nvarchar](50) NULL,
	[recipientActivityIdentifier] [nvarchar](100) NULL,
	[recipientCountryDescription] [nvarchar](2000) NULL,
	[recipientCountryId] [nvarchar](50) NULL,
	[recipientOrganizationId] [nvarchar](50) NULL,
	[recipientRegionDescription] [nvarchar](2000) NULL,
	[recipientRegionId] [nvarchar](50) NULL,
	[tiedStatusId] [nvarchar](50) NULL,
 CONSTRAINT [PK__Transact__9B57CF72BCFFCA5A] PRIMARY KEY CLUSTERED 
(
	[transactionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
ALTER TABLE [dbo].[Account] ADD  CONSTRAINT [DF_Account_accountId]  DEFAULT (newid()) FOR [accountId]
GO
ALTER TABLE [dbo].[CreditPlan] ADD  CONSTRAINT [DF_CreditPlan_creditPlanId]  DEFAULT (newid()) FOR [creditPlanId]
GO
ALTER TABLE [dbo].[CreditPlanRecipient] ADD  CONSTRAINT [DF_CreditPlanRecipient_creditRecipientId]  DEFAULT (newid()) FOR [creditRecipientId]
GO
ALTER TABLE [dbo].[Ledger] ADD  CONSTRAINT [DF_Ledger_ledgerId]  DEFAULT (newid()) FOR [ledgerId]
GO
ALTER TABLE [dbo].[MainAccountCategory] ADD  CONSTRAINT [DF_MainAccountCategory_mainAccountCategoryId]  DEFAULT (newid()) FOR [mainAccountCategoryId]
GO
ALTER TABLE [dbo].[PaymentAsset] ADD  CONSTRAINT [DF_PaymentAsset_paymentAssetId]  DEFAULT (newid()) FOR [paymentAssetId]
GO
ALTER TABLE [dbo].[PaymentMethod] ADD  CONSTRAINT [DF_PaymentMethod_paymentMethodId]  DEFAULT (newid()) FOR [paymentMethodId]
GO
ALTER TABLE [dbo].[PaymentProcessor] ADD  CONSTRAINT [DF_PaymentProcessor_paymentProcessorId]  DEFAULT (newid()) FOR [paymentProcessorId]
GO
ALTER TABLE [dbo].[PaymentSchedule] ADD  CONSTRAINT [DF_PaymentSchedule_paymentScheduleId]  DEFAULT (newid()) FOR [paymentScheduleId]
GO
ALTER TABLE [dbo].[Transactions] ADD  CONSTRAINT [DF_Transactions_transactionId]  DEFAULT (newid()) FOR [transactionId]
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [FK_Admin_AdminRole] FOREIGN KEY([AdminRoleID])
REFERENCES [dbo].[AdminRole] ([ID])
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [FK_Admin_AdminRole]
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [FK_Admin_Company] FOREIGN KEY([CompanyID])
REFERENCES [dbo].[Company] ([ID])
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [FK_Admin_Company]
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [FK3jwfsqe1nohan2fuslnm6gmf2] FOREIGN KEY([CompanyID])
REFERENCES [dbo].[Company] ([ID])
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [FK3jwfsqe1nohan2fuslnm6gmf2]
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [FKfsxq8n53angembe18qe4ufjqg] FOREIGN KEY([AdminRoleID])
REFERENCES [dbo].[AdminRole] ([ID])
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [FKfsxq8n53angembe18qe4ufjqg]
GO
ALTER TABLE [dbo].[AdminLogs]  WITH CHECK ADD  CONSTRAINT [FK3b33q4e6972hmftvyrresvqbt] FOREIGN KEY([AdminID])
REFERENCES [dbo].[Admin] ([ID])
GO
ALTER TABLE [dbo].[AdminLogs] CHECK CONSTRAINT [FK3b33q4e6972hmftvyrresvqbt]
GO
ALTER TABLE [dbo].[AdminModule]  WITH CHECK ADD  CONSTRAINT [FKf6tow44s52e13428cdc4sijca] FOREIGN KEY([ParentID])
REFERENCES [dbo].[AdminModule] ([ID])
GO
ALTER TABLE [dbo].[AdminModule] CHECK CONSTRAINT [FKf6tow44s52e13428cdc4sijca]
GO
ALTER TABLE [dbo].[CreditPlan]  WITH CHECK ADD  CONSTRAINT [FK_CreditPlan_Account] FOREIGN KEY([creditPlanAccountId])
REFERENCES [dbo].[Account] ([accountId])
GO
ALTER TABLE [dbo].[CreditPlan] CHECK CONSTRAINT [FK_CreditPlan_Account]
GO
ALTER TABLE [dbo].[CreditPlan]  WITH CHECK ADD  CONSTRAINT [FK_CreditPlan_PaymentSchedule] FOREIGN KEY([creditPlanPaymentScheduleId])
REFERENCES [dbo].[PaymentSchedule] ([paymentScheduleId])
GO
ALTER TABLE [dbo].[CreditPlan] CHECK CONSTRAINT [FK_CreditPlan_PaymentSchedule]
GO
ALTER TABLE [dbo].[CreditPlanRecipient]  WITH CHECK ADD  CONSTRAINT [FK_CreditPlanRecipient_CreditPlan] FOREIGN KEY([creditRecipientCreditPlanId])
REFERENCES [dbo].[CreditPlan] ([creditPlanId])
GO
ALTER TABLE [dbo].[CreditPlanRecipient] CHECK CONSTRAINT [FK_CreditPlanRecipient_CreditPlan]
GO
ALTER TABLE [dbo].[PaymentAsset]  WITH CHECK ADD  CONSTRAINT [FK_PaymentAsset_Transactions] FOREIGN KEY([transferredOnTransactionId])
REFERENCES [dbo].[Transactions] ([transactionId])
GO
ALTER TABLE [dbo].[PaymentAsset] CHECK CONSTRAINT [FK_PaymentAsset_Transactions]
GO
ALTER TABLE [dbo].[PaymentMethod]  WITH CHECK ADD  CONSTRAINT [FK_PaymentMethod_Transactions] FOREIGN KEY([transactionId])
REFERENCES [dbo].[Transactions] ([transactionId])
GO
ALTER TABLE [dbo].[PaymentMethod] CHECK CONSTRAINT [FK_PaymentMethod_Transactions]
GO
ALTER TABLE [dbo].[Transactions]  WITH CHECK ADD  CONSTRAINT [FK_Transactions_Account] FOREIGN KEY([transactionReceiptOnAccountId])
REFERENCES [dbo].[Account] ([accountId])
GO
ALTER TABLE [dbo].[Transactions] CHECK CONSTRAINT [FK_Transactions_Account]
GO
ALTER TABLE [dbo].[Transactions]  WITH CHECK ADD  CONSTRAINT [FK_Transactions_PaymentSchedule] FOREIGN KEY([transactionPaymentScheduleId])
REFERENCES [dbo].[PaymentSchedule] ([paymentScheduleId])
GO
ALTER TABLE [dbo].[Transactions] CHECK CONSTRAINT [FK_Transactions_PaymentSchedule]
GO
