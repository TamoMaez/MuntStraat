<a class="media-left" href="{{ x.url }}"> <img
	ng-src="{{ x.image }}" data-holder-rendered="true"
	style="width: 80px; height: 64px;">
</a>
<div class="media-body">
	<a href="{{ x.url }}">
		<h4 ng-bind-html="x.naam | highlight:query" class="media-heading"></h4>
	</a>
	<p ng-bind-html="x.slogan | highlight:query" style="height: 45px"></p>
</div>