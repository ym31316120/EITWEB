var DataSourceTree = function (options) {
    this._data = options.data;
    this._delay = options.delay;
}

DataSourceTree.prototype.data = function (options, callback) {
    var self = this;
    var $data = null;

    if (!("name" in options) && !("type" in options)) {
        $data = this._data;//the root tree
        callback({data: $data});
        return;
    }
    else if ("type" in options && options.type == "folder") {
        if ("additionalParameters" in options && "children" in options.additionalParameters)
            $data = options.additionalParameters.children;
        else $data = {}//no data
    }

    if ($data != null)//this setTimeout is only for mimicking some random delay
        setTimeout(function () {
            callback({data: $data});
        }, parseInt(Math.random() * 500) + 200);

    //we have used static data here
    //but you can retrieve your data dynamically from a server using ajax call
    //checkout examples/treeview.html and examples/treeview.js for more info
};

//--------------生成蓝图分组树形结构--------------------
var bluePrintGroups_data = {
    'Ships' : {name: 'Ships', type: 'folder', 'icon-class':'red'}   ,
    'ShipEquipment' : {name: 'Ship Equipment', type: 'folder', 'icon-class':'orange'},
    'Ammunition' : {name: 'Ammunition & Charges', type: 'folder', 'icon-class':'blue'},
    'Drones' : {name: 'Drones', type: 'folder', 'icon-class':'green'},
    'Modifications' : {name: 'Ship Modifications', type: 'folder'}
}
bluePrintGroups_data['Ships']['additionalParameters'] = {
    'children' : [
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(205)">Frigates</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(206)">Cruisers</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(207)">Battleships</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(208)">Industrial Ships</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(408)">Interceptors</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(414)">Shuttles</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(419)">Covert Ops</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(442)">Logistics</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(453)">Heavy Assault Cruisers</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(458)">Assault Frigates</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(496)">Mining Barges</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(582)">Destroyers</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(588)">Battlecruisers</a>', type: 'item'},
        {name: '<i class="icon-fighter-jet blue"></i><a onclick="bluePrintTreeClick(634)">Transport Ships</a>', type: 'item'},
    ]
}
bluePrintGroups_data['ShipEquipment']['additionalParameters'] = {
    'children' : [
        {name: '<i class="icon-film blue"></i> movie1.avi', type: 'item'},
        {name: '<i class="icon-film blue"></i> movie2.avi', type: 'item'},
        {name: '<i class="icon-film blue"></i> movie3.avi', type: 'item'},
        {name: '<i class="icon-film blue"></i> movie4.avi', type: 'item'},
        {name: '<i class="icon-film blue"></i> movie5.avi', type: 'item'}
    ]
}
bluePrintGroups_data['Ammunition']['additionalParameters'] = {
    'children' : {
        'wallpapers' : {name: 'Wallpapers', type: 'folder', 'icon-class':'pink'},
        'camera' : {name: 'Camera', type: 'folder', 'icon-class':'pink'}
    }
}
bluePrintGroups_data['Ammunition']['additionalParameters']['children']['wallpapers']['additionalParameters'] = {
    'children' : [
        {name: '<i class="icon-picture green"></i> wallpaper1.jpg', type: 'item'},
        {name: '<i class="icon-picture green"></i> wallpaper2.jpg', type: 'item'},
        {name: '<i class="icon-picture green"></i> wallpaper3.jpg', type: 'item'},
        {name: '<i class="icon-picture green"></i> wallpaper4.jpg', type: 'item'}
    ]
}
bluePrintGroups_data['Ammunition']['additionalParameters']['children']['camera']['additionalParameters'] = {
    'children' : [
        {name: '<i class="icon-picture green"></i><a href="#" onclick="alert(1)">photo1.jpg</a> ', type: 'item'},
        {name: '<i class="icon-picture green"></i> photo2.jpg', type: 'item'},
        {name: '<i class="icon-picture green"></i> photo3.jpg', type: 'item'},
        {name: '<i class="icon-picture green"></i> photo4.jpg', type: 'item'},
        {name: '<i class="icon-picture green"></i> photo5.jpg', type: 'item'},
        {name: '<i class="icon-picture green"></i> photo6.jpg', type: 'item'}
    ]
}


bluePrintGroups_data['Drones']['additionalParameters'] = {
    'children' : [
        {name: '<i class="icon-file-text red"></i> document1.pdf', type: 'item'},
        {name: '<i class="icon-file-text grey"></i> document2.doc', type: 'item'},
        {name: '<i class="icon-file-text grey"></i> document3.doc', type: 'item'},
        {name: '<i class="icon-file-text red"></i> document4.pdf', type: 'item'},
        {name: '<i class="icon-file-text grey"></i> document5.doc', type: 'item'}
    ]
}

bluePrintGroups_data['Modifications']['additionalParameters'] = {
    'children' : [
        {name: '<i class="icon-archive brown"></i> backup1.zip', type: 'item'},
        {name: '<i class="icon-archive brown"></i> backup2.zip', type: 'item'},
        {name: '<i class="icon-archive brown"></i> backup3.zip', type: 'item'},
        {name: '<i class="icon-archive brown"></i> backup4.zip', type: 'item'}
    ]
}
var treeDataEit = new DataSourceTree({data: bluePrintGroups_data});


function bluePrintTreeClick(index){
    alert(index);
}