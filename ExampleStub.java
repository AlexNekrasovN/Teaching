public static List<IMAgreement> buildPaymentAccounts() {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣List<Agreement> agreements = new LinkedList<>();

 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣// заполнить объект IMAgreement данными для заглушки
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣agreements.add(buildImAgreement("0", "Б", "A98", 1000.0, AccountState.ARRESTED.getStateName(), 1500.0, DateUtil.toGregorianCalendar(2030, Month.OCTOBER, 10)));
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣agreements.add(buildImAgreement("1", "С", "A99", 100.0, AccountState.CLOSED.getStateName(), 1500.0, DateUtil.toGregorianCalendar(2030, Month.OCTOBER, 10)));
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣agreements.add(buildImAgreement("2", "П", "A76", 10.0, AccountState.CLOSED.getStateName(), 1500.0, DateUtil.toGregorianCalendar(2030, Month.OCTOBER, 10)));
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣agreements.add(buildImAgreement("3", "П", "A33", 10.0, AccountState.OPEN.getStateName(), 1500.0, DateUtil.toGregorianCalendar(2030, Month.OCTOBER, 10)));

 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣return agreements;
 ⁣ ⁣ ⁣ ⁣}

 ⁣ ⁣ ⁣ ⁣public static List<IMAgreement> buildPaymentAccountWithWrongCode() {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣List<IMAgreement> agreements = new LinkedList<>();
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣agreements.add(buildImAgreement("0", "П", "A44", 10.0, AccountState.OPEN.getStateName(), 1500.0, DateUtil.toGregorianCalendar(2030, Month.OCTOBER, 10)));

 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣return agreements;
 ⁣ ⁣ ⁣ ⁣}

 ⁣ ⁣ ⁣ ⁣public static List<IMAgreement> buildPaymentAccountWithCloseStatus() {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣List<IMAgreement> agreements = new LinkedList<>();
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣agreements.add(buildImAgreement("0", "П", "A33", 10.0, AccountState.CLOSED.getStateName(), 1500.0, DateUtil.toGregorianCalendar(2030, Month.OCTOBER, 10)));

 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣return agreements;
 ⁣ ⁣ ⁣ ⁣}

 ⁣ ⁣ ⁣ ⁣public static List<IMAgreement> buildPaymentAccountWithExpiredDate() {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣List<IMAgreement> agreements = new LinkedList<>();
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣agreements.add(buildImAgreement("0", "П", "A33", 10.0, AccountState.ARRESTED.getStateName(), 1500.0, DateUtil.toGregorianCalendar(2020, Month.OCTOBER, 10)));

 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣return agreements;
 ⁣ ⁣ ⁣ ⁣}
