/*
 * Copyright 2020 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ebivariation.contigalias.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "assembly")
public class AssemblyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @ApiModelProperty(value = "Autogenerated Primary Key.")
    private long id;

    @ApiModelProperty(value = "The name of the assembly.")
    private String name;

    @ApiModelProperty(value = "The organism of the assembly.")
    private String organism;

    @ApiModelProperty(value = "Assembly's taxonomic ID.")
    private Long taxid;

    @ApiModelProperty(value = "Assembly's Genbank accession.")
    private String genbank;

    @ApiModelProperty(value = "Assembly's Refseq accession.")
    private String refseq;

    @ApiModelProperty(value = "Are assembly's Genbank and Refseq accessions identical")
    private boolean isGenbankRefseqIdentical;

    @ApiModelProperty(value = "List of all chromosomes of the assembly present in the database.")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "assembly", cascade = CascadeType.ALL)
    private List<ChromosomeEntity> chromosomes;

    public AssemblyEntity() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AssemblyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getOrganism() {
        return organism;
    }

    public AssemblyEntity setOrganism(String organism) {
        this.organism = organism;
        return this;
    }

    public Long getTaxid() {
        return taxid;
    }

    public AssemblyEntity setTaxid(Long taxid) {
        this.taxid = taxid;
        return this;
    }

    public String getGenbank() {
        return genbank;
    }

    public AssemblyEntity setGenbank(String genbank) {
        this.genbank = genbank;
        return this;
    }

    public String getRefseq() {
        return refseq;
    }

    public AssemblyEntity setRefseq(String refseq) {
        this.refseq = refseq;
        return this;
    }

    public boolean isGenbankRefseqIdentical() {
        return isGenbankRefseqIdentical;
    }

    public AssemblyEntity setGenbankRefseqIdentical(boolean genbankRefseqIdentical) {
        isGenbankRefseqIdentical = genbankRefseqIdentical;
        return this;
    }

    public List<ChromosomeEntity> getChromosomes() {
        return chromosomes;
    }

    public AssemblyEntity setChromosomes(List<ChromosomeEntity> chromosomes) {
        this.chromosomes = chromosomes;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name :\t")
               .append(this.name)
               .append("\n")
               .append("Organism :\t")
               .append(this.organism)
               .append("\n")
               .append("Tax ID :\t")
               .append(this.taxid)
               .append("\n")
               .append("Genbank :\t")
               .append(this.genbank)
               .append("\n")
               .append("Refseq :\t")
               .append(this.refseq)
               .append("\n")
               .append("Genbank & Refseq identical :\t")
               .append(isGenbankRefseqIdentical)
               .append("\n");
        if (this.chromosomes != null) {
            builder.append("Number of chromosomes :\t")
                   .append(this.chromosomes.size())
                   .append("\n");
        }
        return builder.toString();
    }
}
