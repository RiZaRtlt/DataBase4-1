package com.example.database41.Core;

import java.util.List;

public interface Reposytory {
    List<Persons> getPersonsByCity(String city);
}
