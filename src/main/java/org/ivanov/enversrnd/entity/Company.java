package org.ivanov.enversrnd.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;


@Getter
@Setter
@Audited
@Table(name = "COMPANIES")
@Entity
public class Company {
    @Id
    @SequenceGenerator(name = "companySeqGen", sequenceName = "COMPANY_ID_SEQUENCE", allocationSize = 10)
    @GeneratedValue(generator = "companySeqGen")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Customer> customers;
}
