<!-- aan highlight() naam en slogan meegeven  -->

<a ng-if="grid==true" target="blank" href="{{ x.url }}">
	<div class="thumbnail">
		<div class="thumbnailHolder top-radius">
			<img class="top-radius" ng-src="{{ x.image }}">
		</div>
		<figcaption class="card-footer bottom-radius">
			<div class="card-action block">
				<div class="card-action-text card-action-icon">
					<div class="text-button">
						Visit Site <span class="glyphicon glyphicon-chevron-right">
							<!-- -->
						</span>
					</div>
				</div>
			</div>
		</figcaption>

	</div>
</a>