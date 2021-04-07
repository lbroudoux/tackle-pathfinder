package io.tackle.pathfinder.model.assessment;

import io.tackle.commons.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "assessment_category")
@SQLDelete(sql = "UPDATE assessment_category SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentCategory extends AbstractEntity {
    @Column(name="category_order")
    public int order;

    public String name;

    @ManyToOne
    @JoinColumn(name="questionnaire_id", referencedColumnName="id")
    public AssessmentQuestionnaire questionnaire;

    @OneToMany(mappedBy = "category")
    public List<AssessmentQuestion> questions;
}
