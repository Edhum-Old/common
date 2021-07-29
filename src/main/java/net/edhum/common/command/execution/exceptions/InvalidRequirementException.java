package net.edhum.common.command.execution.exceptions;

import net.edhum.common.command.requirement.Requirement;

public class InvalidRequirementException extends Exception {

    private final Requirement requirement;

    public InvalidRequirementException(Requirement requirement) {
        this.requirement = requirement;
    }

    public Requirement getRequirement() {
        return requirement;
    }
}
