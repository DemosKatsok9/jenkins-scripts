#!/usr/bin/env groovy
def projectDefs = [
        version : "new-feature",
        language: 'java'
]

def lib = library("pipes@${projectDefs.version}").com.katsok9.demo
lib.StepsRunner.yalla(this,projectDefs)
lib.MavenArtifactoryUtil.buildArtifactory(this,projectDefs)

