<!-- Shorelines -->
<div class="tab-pane container-fluid active" id="shorelines">
	<div class="row-fluid">
		<div class="span4"><h3>Shorelines</h3></div>
		<div class="span8" id="shorelines-alert-container"></div>
	</div>
	<ul class="nav nav-tabs" id="action-shorelines-tablist">
		<li class="active"><a  data-toggle="tab" href="#shorelines-view-tab">View</a></li>
		<li><a data-toggle="tab" href="#shorelines-manage-tab">Upload</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="shorelines-view-tab">
			<p class="text-center">
				<button data-toggle="button" class="btn btn-success" id="shorelines-aoi-select-toggle">
					<i class="fa fa-map-marker icon-white"></i> Select Area Of Interest
				</button>
			</p>
			<div id="description-aoi" class="well hidden">
				<h3>Selecting An Area Of Interest</h3>
				<p>To select an area of interest (AOI),</p>
				<ul> 
					<li> Click "Select Area Of Interest" button to begin drawing.</li>
					<li> Click and drag your mouse to draw a box around your area of interest.</li>
					<li> When you're satisfied with the AOI, click "I'm Done" button.</li>
					<li> Note: If the area of interest is redrawn, the previously drawn AOI will not remain.</li>
				</ul>
				<p class="text-center">
					<button class="btn btn-success" id="shorelines-aoi-select-done">
						<i class="fa fa-check icon-white"></i> I'm Done
					</button>
				</p>
			</div>
			<div id="shorelines-feature-table-container" class="hidden">
				<div id="shorelines-feature-table-button-sort" class="hidden">
					Select Wildcard:
					<select id="ctrl-shorelines-sort-select"></select>
				</div>
				<table class="table table-bordered table-condensed tablesorter shoreline-table">
					<thead>
					<th class="shoreline-table-selected-head-column" data-column="0">Visibility</th>
					<th data-column="1">Date</th>
					<th data-column="2">Source</th>
					<th data-sorter="false">Color</th>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>

		</div>
		<div class="tab-pane" id="shorelines-manage-tab">
			<div id="shorelines-uploader" class="uploader"></div>
			<button class="btn btn-success" id="shorelines-triggerbutton"><i class="icon-arrow-up icon-white"></i>Upload .zip</button>
		</div>
	</div>
</div> <!-- /Shorelines -->
