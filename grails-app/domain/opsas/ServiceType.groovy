package opsas

import enums.Type
import enums.DurationKind


class ServiceType {
    Type type;
    String duration;
    DurationKind durationKind;
    BigDecimal price
    static belongsTo = [service: Services]


    static constraints = {
    }

    static mapping = {
        type enumType: 'string'
        durationKind enumType: 'string'


    }
}
