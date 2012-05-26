<!DOCTYPE html>
<html lang="en">
	<meta charset="utf-8"/>
	<title>Twitter Visualizer</title>
	<link rel='stylesheet' href='css/bootstrap.css' />
	<link rel="stylesheet" href="css/style1.css"/>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="js/spotter.js"></script>
    <script src="js/sha1-min.js"></script>
    <script type="text/javascript" src="js/script.js"></script>
    <script type='text/javascript' src='js/bootstrap-modal.js'></script>

<div class='content'>
	<table>
		<tr class='top-row'><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;
		<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;
		<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;
		<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;
		<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;
		<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;
		<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;
		<tr><td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;<td>&nbsp;
		<tr id='counter-row'>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
			<td><div class='counter'></div>
		<tr id='info-row'>
			<td>
				<h4 class='tag-header'>Tunisia</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='tag-header'>France</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='tag-header'>USA</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='tag-header'>India</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='tag-header'>China</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='tag-header'>Italy</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='tag-header'>Australia</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='tag-header'>Russia</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='tag-header'>Egypt</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
			<td><h4 class='last tag-header'>UK</h4>
				<div class='spacer'></div>
				<button class='btn primary' data-keyboard='true' data-backdrop='true' data-controls-modal='modal-from-dom'>
					Change
				</button>
	</table>

	<a href='#' id='about-button'>
		<img src='info.png' alt='icon' />
	</a>
</div><!-- content -->

<div id='modal-from-dom' class='modal hide fade'>
	<div class='modal-header'>
		<a href='#' class='close'>&times;</a>
		<h3 id='name_header'></h3>
	</div>
	<div class='modal-body'>
		<p>Change tag to:</p>
		<form>
			<input id='modal-input' type='text' />
		</form>
	</div>
	<div class='modal-footer'>
		<a href='#' class='btn primary'>Change</a>
		<a href='#' class='btn cancel'>Cancel</a>
	</div>
</div>

<div id='about-modal' class='modal hide fade'>
	<div class='modal-header'>
		<a href='#' class='close'>&times;</a>
		<h3>Data Mining</h3>
	</div>
	<div class='modal-body'>
		<p>It displays incoming tweets from 10 different search terms.</p>
	</div>
	<div class='modal-footer'>
		<a href='#' class='btn primary'>Close</a>
		<a href='#' class='btn secondary'>Reset Stacks</a>
	</div>
</div>

</html>
