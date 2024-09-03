package org.restaurante.mstrazabilidad.infrastructure.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "traceabilities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TraceabilityEntity {

    @Id
    private String id;

    private String state;

    private Long orderId;

    private Long restaurantId;

    private Long employeeId;

    private Date changeStateOrder;

    private String duration;
}
