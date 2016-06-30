package nl.esciencecenter.e3dchem.kripodb.fragments;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.NodeSettingsRO;
import org.knime.core.node.NodeSettingsWO;
import org.knime.core.node.defaultnodesettings.SettingsModelString;
import org.knime.core.node.workflow.FlowVariable;

import nl.esciencecenter.e3dchem.kripodb.PythonNodeConfig;

public class FragmentsByIdConfig extends PythonNodeConfig {
	private static final String DEFAULT_IDTYPE = "fragment";
	private static final String CFG_IDCOLNAME = "id_column";
	public static final Set<String> LIST_IDENTIFIERTYPES = Stream.of(DEFAULT_IDTYPE, "pdb").collect(Collectors.toSet());
	private static final String CFG_IDTYPE = "id_type";
	private static final String CFG_FRAGMENTSDB = "fragmentdb";
	private static final String DEFAULT_PREFIX = "";
	private static final String CFG_PREFIX = "prefix";

	private SettingsModelString m_idColumn = new SettingsModelString(CFG_IDCOLNAME, null);
	private SettingsModelString m_fragmentsDB = new SettingsModelString(CFG_FRAGMENTSDB, null);
	private SettingsModelString m_idType = new SettingsModelString(CFG_IDTYPE, DEFAULT_IDTYPE);
	private SettingsModelString m_prefix = new SettingsModelString(CFG_PREFIX, DEFAULT_PREFIX);

	@Override
	public void saveTo(final NodeSettingsWO settings) {
		m_idColumn.saveSettingsTo(settings);
		m_fragmentsDB.saveSettingsTo(settings);
		m_idType.saveSettingsTo(settings);
		m_prefix.saveSettingsTo(settings);
	}

	@Override
	public void loadFrom(final NodeSettingsRO settings) throws InvalidSettingsException {
		m_idColumn.loadSettingsFrom(settings);
		m_fragmentsDB.loadSettingsFrom(settings);
		m_idType.loadSettingsFrom(settings);
		m_prefix.loadSettingsFrom(settings);
	}

	@Override
	public Set<FlowVariable> toFlowVariables() {
		Set<FlowVariable> variables = super.toFlowVariables();
		variables.add(new FlowVariable(CFG_IDCOLNAME, m_idColumn.getStringValue()));
		variables.add(new FlowVariable(CFG_FRAGMENTSDB, m_fragmentsDB.getStringValue()));
		variables.add(new FlowVariable(CFG_IDTYPE, m_idType.getStringValue()));
		variables.add(new FlowVariable(CFG_PREFIX, m_prefix.getStringValue()));
		return variables;
	}

	public SettingsModelString getIdColumn() {
		return m_idColumn;
	}

	public SettingsModelString getFragmentsDB() {
		return m_fragmentsDB;
	}

	public SettingsModelString getIdType() {
		return m_idType;
	}

	public SettingsModelString getPrefix() {
		return m_prefix;
	}
}
