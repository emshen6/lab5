package command;


interface Builder {
    void reset();

    void setHelpCommand();

    void setInfoCommand();

    void setShowCommand();

    void setAddCommand();

    void setUpdateIdCommand();

    void setRemoveByIdCommand();

    void setClearCommand();

    void setSaveCommand();

    void setExecuteScriptCommand();

    void setExitCommand();

    void setRemoveFirstCommand();

    void setRemoveHeadCommand();

    void setHistoryCommand();

    void setRemoveAllByStudentsCountCommand();

    void setCountByStudentsCountCommand();

    void setPrintAscendingCommand();

}
