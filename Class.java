@Service
public class CheckClientDataService extends AbstractService {

 ⁣ ⁣ ⁣ ⁣private final SupConfig supConfig;

 ⁣ ⁣ ⁣ ⁣public CheckClientDataService(SupConfig supConfig) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣this.supConfig = supConfig;
 ⁣ ⁣ ⁣ ⁣}
  
 ⁣ ⁣ ⁣ ⁣public void checkCapacityPerson(Person person) throws CheckClientDataException{
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣var clientCapacityCheck = getIncapacityCheck();
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣var doCheck = clientCapacityCheck == null || clientCapacityCheck;
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣List<IncapacitateReason> capacityStatusType = person.getProfile().getCapability();
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.info("Включена проверка на дееспособность клиента: {}", clientCapacityCheck);
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣if (doCheck && !capacityStatusType.isEmpty()) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣checkAgeCapacity(capacityStatusType);
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣checkMentalCapacity(capacityStatusType);
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣checkInCapacity(capacityStatusType);
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣}
 ⁣ ⁣ ⁣ ⁣}
  
 ⁣ ⁣ ⁣ ⁣public void isBlind(Person person) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣var clientInvalidVision = getInvalidVisionCheck();
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣var doCheck = clientInvalidVision == null || clientInvalidVision;
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.info("Включена проверка на ивалидность по зрению: {}", clientInvalidVision);
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣if (doCheck && person.getProfile().getInvalidVision()) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.warn("Клиент инвалид по зрению");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣throw new CheckClientDataException(HINT_FOR, "Клиент инвалид по зрению");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣}
 ⁣ ⁣ ⁣ ⁣}

public void checkAvailableCard(List <Agreement> agreement) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣Predicate<Agreement> predicate1 = agr -> agr.getState().equalsIgnoreCase(OPEN.getStateName());
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣Predicate<Agreement> predicate2 = agr -> agr.getState().equalsIgnoreCase(ARRESTED.getStateName());
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣boolean checkAvailableOMS = agreement.stream()
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣.filter(agr -> (agr.getState().equalsIgnoreCase(OPEN.getStateName())
                        || agr.getState().equalsIgnoreCase(ARRESTED.getStateName()))
                        && toLocalDateTime(agr.getEndDate()).isAfter(LocalDateTime.now())))           
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣.anyMatch(agr -> contains(agr.getCurrency().getCode()));
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣if (!checkAvailableOMS) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.warn("Нет доступных счетов для пополнения");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣throw new CheckClientDataException(ERROR_NOT_AVAIBLE_CARD, "Нет доступных счетов для пополнения");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣}
 ⁣ ⁣ ⁣ ⁣}

 ⁣ ⁣ ⁣ ⁣private void checkAgeCapacity (List<IncapacitateReason> type) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣if (type.contains(AGE_UNDERAGE)) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.warn("Клиент несовершеннолетний от 14 до 18 лет");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣throw new CheckClientDataException(ERROR1, "Несовершеннолетний от 14 до 18 лет");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣}
 ⁣ ⁣ ⁣ ⁣}

 ⁣ ⁣ ⁣ ⁣private void checkMentalCapacity (List<IncapacitateReason> type) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣if (type.contains(MARGIINALLY_ACTIVE)) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.warn("Клиент недеепособен в силу того то");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣throw new CheckClientDataException(ERROR2, "Клиент недеепособен в силу того то");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣}
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣if(type.contains(LIMBICALLY_ACTIVE)) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.warn("Клиент ограниченно дееспособный вследствие сего то");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣throw new CheckClientDataException(ERROR2, "Клиент ограниченно дееспособный вследствие сего то");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣}
 ⁣ ⁣ ⁣ ⁣}

 ⁣ ⁣ ⁣ ⁣private void checkInCapacity (List<Incapacity> type) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣if (type.contains(AGE_YOUNG)) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.warn("Клиент несовершеннолетний до 14 лет");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣throw new CheckClientDataException(ERROR3, "Несовершеннолетний до 14 лет");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣}
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣if (type.contains(CAPACITY_FALSE)) {
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣log.warn("Клиент недеепособен");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣throw new CheckClientDataException(ERROR3, "Клиент недеепособен");
 ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣ ⁣}
 ⁣ ⁣ ⁣ ⁣}
}
