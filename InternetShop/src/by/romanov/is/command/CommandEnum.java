package by.romanov.is.command;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	REGISTRATION {
		{
			this.command = new RegistrationCommand();
		}
	},
	CATEGORY {
		{
			this.command = new CategoryCommand();
		}
	},
	HOME {
		{
			this.command = new HomePageCommand();
		}
	},
	EXIT {
		{
			this.command = new ExitButtonCommand();
		}
	},
	LANGUAGE {
		{
			this.command = new LanguageCommand();
		}
	},
	MORE {
		{
			this.command = new MoreGoodsCommand();
		}
	},
	ORDER {
		{
			this.command = new OrderCommand();
		}
	},
	PROFILE {
		{
			this.command = new ProfileCommand();
		}
	},
	DELETE_GOODS {
		{
			this.command = new DeleteGoodsCommand();
		}
	},
	LIST_USER {
		{
			this.command = new GetListUserCommand();
		}
	},
	PAY {
		{
			this.command = new PayOrderCommand();
		}
	},
	EDIT_GOODS_PAGE {
		{
			this.command = new EditGoodsPageCommand();
		}
	},
	EDIT_GOODS {
		{
			this.command = new EditGoodsCommand();
		}
	},
	USER_INFO {
		{
			this.command = new UserInfoCommand();
		}
	},
	BAN_ACTION {
		{
			this.command = new ActionBanCommand();
		}
	},
	ADD_GOODS_PAGE {
		{
			this.command = new AddGoodsPageCommand();
		}
	},
	ADD_GOODS {
		{
			this.command = new AddGoodsCommand();
		}
	},
	PAGE_CATALOG_ADMIN {
		{
			this.command = new PageCatalogAdminCommand();
		}
	},
	PAGE_CATALOG_USER {
		{
			this.command = new PageCatalogUserCommand();
		}
	},
	DELIVERED {
		{
			this.command = new DeliveredCommand();
		}
	};

	Command command;

	public Command getCurrentCommand() {
		return command;

	}
}
