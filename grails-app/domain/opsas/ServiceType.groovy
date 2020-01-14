package opsas

import enums.DurationKind
import enums.Type

class ServiceType {
    Type name;
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
