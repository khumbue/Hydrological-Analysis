package za.co.jobcreation.ejb.impl.validation;

public class ErrorMessages {

	public enum ReduceStock

	{
		STOCK_DTOS_EMPTY("The list of stock dtos cannot be empty."), STOCK_DTO_SKU_CODE_EMPTY("The sku code of the stock dto cannot be empty."), SERIAL_NUMBER_BEING_REDUCED_DOES_NOT_EXIST(
				"The serial number being reduced does not exist."), ORDER_ALREADY_PROCESSED("The order has already been processed."), NO_RESERVATION_EXIST(
				"No reservartion exist for this order."), RESERVATION_DO_NOT_MATCH_INCOMING_DTO("The number of items being reduced does not match the number of reserved Items.");

		private String value;

		private ReduceStock(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

	};

}
