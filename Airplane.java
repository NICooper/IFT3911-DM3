public class Airplane extends Vehicle {
    public Airplane(String vehicleId, String model, Company company) {
        super(vehicleId, model, company);
        sections.add(new PlaneSection(1, PlaneSectionType.E));
    }

    public void addSection(PlaneSectionType sectionType, int sectionUnitCount, Repartition repartition) throws DuplicateSectionException, TooManySectionUnitsException {
        if (sectionUnitCount < 1) {
            return;
        }
        if (sections.stream().anyMatch(s -> sectionType == s.sectionType)) {
            throw new DuplicateSectionException();
        }
        if (sections.stream().map(s -> s.sectionUnitCount).reduce(0, Integer::sum) + sectionUnitCount > 100) {
            throw new TooManySectionUnitsException();
        }
        sections.add(new PlaneSection(sectionUnitCount, sectionType, repartition));
    }

    public void deleteSection(PlaneSectionType sectionType) throws TooFewSectionsException {
        if (sections.size() < 2) {
            throw new TooFewSectionsException();
        }
        sections = sections.stream().filter(s -> s.sectionType.equals(sectionType)).toList();
    }

    public void updateSectionUnitCount(SectionType sectionType, int sectionUnitCount) {
        if (sections.stream().map(s -> s.sectionUnitCount).reduce(0, Integer::sum) + sectionUnitCount > 100) {
            return;
        }

        super.updateSectionUnitCount(sectionType, sectionUnitCount);
    }

    public void updateRepartition(SectionType sectionType, Repartition repartition) {
        var section = sections.stream().filter(s -> s.sectionType == sectionType).findFirst();
        section.ifPresent(s -> ((PlaneSection)s).setRepartition(repartition));
    }

    @Override
    public Airplane copy() {
        return new Airplane(getVehicleId(), getModel(), getCompany());
    }
}