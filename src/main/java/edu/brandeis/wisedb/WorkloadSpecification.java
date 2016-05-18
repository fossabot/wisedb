// { begin copyright } 
// Copyright Ryan Marcus 2016
// 
// This file is part of WiSeDB.
// 
// WiSeDB is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// 
// WiSeDB is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// 
// You should have received a copy of the GNU General Public License
// along with WiSeDB.  If not, see <http://www.gnu.org/licenses/>.
// 
// { end copyright } 
 

package edu.brandeis.wisedb;

import java.util.Map;

import edu.brandeis.wisedb.aws.VMType;
import edu.brandeis.wisedb.cost.ModelSLA;
import edu.brandeis.wisedb.cost.QueryTimePredictor;

public class WorkloadSpecification {
	private final Map<Integer, Map<VMType, Integer>> latencyData;
	private final Map<Integer, Map<VMType, Integer>> ioData;
	private final VMType[] vmTypeData;
	private final ModelSLA sla;
	
	public WorkloadSpecification(
			Map<Integer, Map<VMType, Integer>> latencyData,
			Map<Integer, Map<VMType, Integer>> ioData, 
			VMType[] vmTypeData, 
			ModelSLA sla) {
		
		
		this.latencyData = latencyData;
		this.ioData = ioData;
		this.vmTypeData = vmTypeData;
		this.sla = sla;
	}
	
	public Map<Integer, Map<VMType, Integer>> getLatencyData() {
		return latencyData;
	}
	
	public Map<Integer, Map<VMType, Integer>> getIoData() {
		return ioData;
	}
	
	public VMType[] getVmTypeData() {
		return vmTypeData;
	}
	
	public ModelSLA getSLA() {
		return sla;
	}
	
	public QueryTimePredictor getQueryTimePredictor() {
		return new QueryTimePredictor(latencyData, ioData, vmTypeData);
	}
	
	
	
	
}