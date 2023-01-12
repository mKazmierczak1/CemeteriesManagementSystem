package com.mkazm.cemeteriesmanagementsystem.generator;

public class BatchGenerator {
  private long burialIndex;
  private long cemeteryIndex;
  private long deceasedIndex;
  private long exhumationIndex;
  private long invoiceIndex;
  private long paymentIndex;
  private long plotIndex;
  private long reservationIndex;
  private long sectorIndex;
  private long tombstoneIndex;
  private long userIndex;

  private final int maxBurialBatchCount = 400;
  private final int maxCemeteryBatchCount = 1;
  private final int maxDeceasedBatchCount = 1000;
  private final int maxExhumationBatchCount = 100;
  private final int maxPlotBatchCount = 1200;
  private final int maxReservationBatchCount = 800;
  private final int maxSectorBatchCount = 100;
  private final int maxTombstoneBatchCount = 800;
  private final int maxUserBatchCount = 200;

  //    INVOICE_AMOUNT_MIN = 0.01
  //    INVOICE_AMOUNT_MAX = 1000.0
  //
  //    DECEASED_MISSING_DATE_PERCENT = 0.02
  //    DECEASED_MISSING_DATA_PERCENT = 0.01
  //    DECEASED_NO_BURIAL_PERCENT = 0.3
  //    NO_STREET_IN_ADDRESS_PERCENT = 0.1
  //    NO_NIP_IN_INVOICE_PERCENT = 0.25
  //
  //    RESERVATION_MAX_DATE = date(datetime.now().year + 10, 12, 31)

  private static final BatchGenerator INSTANCE = new BatchGenerator();

  private BatchGenerator() {}

  public static BatchGenerator getInstance() {
    return INSTANCE;
  }
}
