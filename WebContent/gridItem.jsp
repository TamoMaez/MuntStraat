<!-- aan highlight() naam en slogan meegeven  -->

<a ng-if="grid==true" target="blank" href="{{ x.url }}">
	<div class="thumbnail">
		<div class="thumbnailHolder">
			<img ng-src="{{ x.image }}">
		</div>
		<div class="caption">
			<h4 ng-bind-html="x.naam | highlight:query"></h4>
			<p ng-bind-html="x.slogan | highlight:query" style="height: 45px"></p>
		</div>
		
	</div>
</a>