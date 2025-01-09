package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secfunctionalityww_impl extends GXDataArea
{
   public secfunctionalityww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secfunctionalityww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityww_impl.class ));
   }

   public secfunctionalityww_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavGridactions = new HTMLChoice();
      cmbSecFunctionalityType = new HTMLChoice();
      chkSecFunctionalityActive = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetNextPar( ) ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            gxnrgrid_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            gxgrgrid_refresh_invoke( ) ;
            return  ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_32 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_32"))) ;
      nGXsfl_32_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_32_idx"))) ;
      sGXsfl_32_idx = httpContext.GetPar( "sGXsfl_32_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV72ColumnsSelector);
      AV100Pgmname = httpContext.GetPar( "Pgmname") ;
      AV41TFSecFunctionalityKey = httpContext.GetPar( "TFSecFunctionalityKey") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV87TFSecFunctionalityKey_Sels);
      AV45TFSecFunctionalityDescription = httpContext.GetPar( "TFSecFunctionalityDescription") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV89TFSecFunctionalityDescription_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV81TFSecFunctionalityType_Sels);
      AV52TFSecParentFunctionalityDescription = httpContext.GetPar( "TFSecParentFunctionalityDescription") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV91TFSecParentFunctionalityDescription_Sels);
      AV29OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV30OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV18IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV19IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV72ColumnsSelector, AV100Pgmname, AV41TFSecFunctionalityKey, AV87TFSecFunctionalityKey_Sels, AV45TFSecFunctionalityDescription, AV89TFSecFunctionalityDescription_Sels, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV91TFSecParentFunctionalityDescription_Sels, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      pa1G2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1G2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV18IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV19IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_32", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_32, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV83GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV84GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV92GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vAGEXPORTDATA", AV94AGExportData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vAGEXPORTDATA", AV94AGExportData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV55DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV55DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV72ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV72ColumnsSelector);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV100Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYKEY", AV41TFSecFunctionalityKey);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSECFUNCTIONALITYKEY_SELS", AV87TFSecFunctionalityKey_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSECFUNCTIONALITYKEY_SELS", AV87TFSecFunctionalityKey_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYDESCRIPTION", AV45TFSecFunctionalityDescription);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSECFUNCTIONALITYDESCRIPTION_SELS", AV89TFSecFunctionalityDescription_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSECFUNCTIONALITYDESCRIPTION_SELS", AV89TFSecFunctionalityDescription_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSECFUNCTIONALITYTYPE_SELS", AV81TFSecFunctionalityType_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSECFUNCTIONALITYTYPE_SELS", AV81TFSecFunctionalityType_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECPARENTFUNCTIONALITYDESCRIPTION", AV52TFSecParentFunctionalityDescription);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS", AV91TFSecParentFunctionalityDescription_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS", AV91TFSecParentFunctionalityDescription_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV29OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV30OrderedDsc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV18IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV18IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV19IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV19IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYKEY_SELSJSON", AV86TFSecFunctionalityKey_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYDESCRIPTION_SELSJSON", AV88TFSecFunctionalityDescription_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECFUNCTIONALITYTYPE_SELSJSON", AV80TFSecFunctionalityType_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELSJSON", AV90TFSecParentFunctionalityDescription_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Icontype", GXutil.rtrim( Ddo_agexport_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Icon", GXutil.rtrim( Ddo_agexport_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Caption", GXutil.rtrim( Ddo_agexport_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Cls", GXutil.rtrim( Ddo_agexport_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Titlecontrolidtoreplace", GXutil.rtrim( Ddo_agexport_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace", GXutil.rtrim( Ddo_gridcolumnsselector_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Fixedcolumns", GXutil.rtrim( Grid_empowerer_Fixedcolumns));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Activeeventkey", GXutil.rtrim( Ddo_agexport_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Activeeventkey", GXutil.rtrim( Ddo_agexport_Activeeventkey));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we1G2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1G2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecFunctionalityWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Functionality", "") ;
   }

   public void wb1G0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Functionality", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupGrouped", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 32, 2, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ColumnsSelector" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnagexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 32, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_ExportData", ""), bttBtnagexport_Jsonclick, 0, httpContext.getMessage( "WWP_ExportData", ""), "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 32, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_EditColumnsCaption", ""), bttBtneditcolumns_Jsonclick, 0, httpContext.getMessage( "WWP_EditColumnsTooltip", ""), "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionalityWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol32( ) ;
      }
      if ( wbEnd == 32 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_32 = (int)(nGXsfl_32_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridpaginationbar.setProperty("Class", Gridpaginationbar_Class);
         ucGridpaginationbar.setProperty("ShowFirst", Gridpaginationbar_Showfirst);
         ucGridpaginationbar.setProperty("ShowPrevious", Gridpaginationbar_Showprevious);
         ucGridpaginationbar.setProperty("ShowNext", Gridpaginationbar_Shownext);
         ucGridpaginationbar.setProperty("ShowLast", Gridpaginationbar_Showlast);
         ucGridpaginationbar.setProperty("PagesToShow", Gridpaginationbar_Pagestoshow);
         ucGridpaginationbar.setProperty("PagingButtonsPosition", Gridpaginationbar_Pagingbuttonsposition);
         ucGridpaginationbar.setProperty("PagingCaptionPosition", Gridpaginationbar_Pagingcaptionposition);
         ucGridpaginationbar.setProperty("EmptyGridClass", Gridpaginationbar_Emptygridclass);
         ucGridpaginationbar.setProperty("RowsPerPageSelector", Gridpaginationbar_Rowsperpageselector);
         ucGridpaginationbar.setProperty("RowsPerPageOptions", Gridpaginationbar_Rowsperpageoptions);
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("RowsPerPageCaption", Gridpaginationbar_Rowsperpagecaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV83GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV84GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV92GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_agexport.setProperty("IconType", Ddo_agexport_Icontype);
         ucDdo_agexport.setProperty("Icon", Ddo_agexport_Icon);
         ucDdo_agexport.setProperty("Caption", Ddo_agexport_Caption);
         ucDdo_agexport.setProperty("Cls", Ddo_agexport_Cls);
         ucDdo_agexport.setProperty("DropDownOptionsData", AV94AGExportData);
         ucDdo_agexport.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_agexport_Internalname, "DDO_AGEXPORTContainer");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("Fixable", Ddo_grid_Fixable);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV55DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV55DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV72ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.setProperty("FixedColumns", Grid_empowerer_Fixedcolumns);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 32 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start1G2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( " Functionality", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1G0( ) ;
   }

   public void ws1G2( )
   {
      start1G2( ) ;
      evt1G2( ) ;
   }

   public void evt1G2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e111G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_AGEXPORT.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e141G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e151G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e161G2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_32_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_32_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_32_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_322( ) ;
                           cmbavGridactions.setName( cmbavGridactions.getInternalname() );
                           cmbavGridactions.setValue( httpContext.cgiGet( cmbavGridactions.getInternalname()) );
                           AV93GridActions = (short)(GXutil.lval( httpContext.cgiGet( cmbavGridactions.getInternalname()))) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV93GridActions), 4, 0));
                           AV24UAViewChildren = httpContext.cgiGet( edtavUaviewchildren_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavUaviewchildren_Internalname, "Bitmap", ((GXutil.strcmp("", AV24UAViewChildren)==0) ? AV108Uaviewchildren_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24UAViewChildren))), !bGXsfl_32_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavUaviewchildren_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24UAViewChildren), true);
                           A62SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A64SecFunctionalityKey = httpContext.cgiGet( edtSecFunctionalityKey_Internalname) ;
                           A350SecFunctionalityDescription = httpContext.cgiGet( edtSecFunctionalityDescription_Internalname) ;
                           cmbSecFunctionalityType.setName( cmbSecFunctionalityType.getInternalname() );
                           cmbSecFunctionalityType.setValue( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()) );
                           A351SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()))) ;
                           A63SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           n63SecParentFunctionalityId = false ;
                           A353SecParentFunctionalityDescript = httpContext.cgiGet( edtSecParentFunctionalityDescript_Internalname) ;
                           A349SecFunctionalityActive = GXutil.strtobool( httpContext.cgiGet( chkSecFunctionalityActive.getInternalname())) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e171G2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e181G2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e191G2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1G2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa1G2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_322( ) ;
      while ( nGXsfl_32_idx <= nRC_GXsfl_32 )
      {
         sendrow_322( ) ;
         nGXsfl_32_idx = ((subGrid_Islastpage==1)&&(nGXsfl_32_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_32_idx+1) ;
         sGXsfl_32_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_32_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_322( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV72ColumnsSelector ,
                                 String AV100Pgmname ,
                                 String AV41TFSecFunctionalityKey ,
                                 GXSimpleCollection<String> AV87TFSecFunctionalityKey_Sels ,
                                 String AV45TFSecFunctionalityDescription ,
                                 GXSimpleCollection<String> AV89TFSecFunctionalityDescription_Sels ,
                                 GXSimpleCollection<Byte> AV81TFSecFunctionalityType_Sels ,
                                 String AV52TFSecParentFunctionalityDescription ,
                                 GXSimpleCollection<String> AV91TFSecParentFunctionalityDescription_Sels ,
                                 short AV29OrderedBy ,
                                 boolean AV30OrderedDsc ,
                                 boolean AV18IsAuthorized_Update ,
                                 boolean AV19IsAuthorized_Delete )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e181G2 ();
      GRID_nCurrentRecord = 0 ;
      rf1G2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECFUNCTIONALITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( A62SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1G2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV100Pgmname = "WWPBaseObjects.SecFunctionalityWW" ;
      Gx_err = (short)(0) ;
   }

   public void rf1G2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(32) ;
      /* Execute user event: Refresh */
      e181G2 ();
      nGXsfl_32_idx = 1 ;
      sGXsfl_32_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_32_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_322( ) ;
      bGXsfl_32_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_322( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A64SecFunctionalityKey ,
                                              AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels ,
                                              A350SecFunctionalityDescription ,
                                              AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels ,
                                              Byte.valueOf(A351SecFunctionalityType) ,
                                              AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels ,
                                              A353SecParentFunctionalityDescript ,
                                              AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels ,
                                              Integer.valueOf(AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels.size()) ,
                                              AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ,
                                              Integer.valueOf(AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels.size()) ,
                                              AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ,
                                              Integer.valueOf(AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels.size()) ,
                                              Integer.valueOf(AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels.size()) ,
                                              AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ,
                                              Short.valueOf(AV29OrderedBy) ,
                                              Boolean.valueOf(AV30OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey), "%", "") ;
         lV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription), "%", "") ;
         lV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription), "%", "") ;
         /* Using cursor H001G2 */
         pr_default.execute(0, new Object[] {lV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey, lV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription, lV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_32_idx = 1 ;
         sGXsfl_32_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_32_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_322( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A349SecFunctionalityActive = H001G2_A349SecFunctionalityActive[0] ;
            A353SecParentFunctionalityDescript = H001G2_A353SecParentFunctionalityDescript[0] ;
            A63SecParentFunctionalityId = H001G2_A63SecParentFunctionalityId[0] ;
            n63SecParentFunctionalityId = H001G2_n63SecParentFunctionalityId[0] ;
            A351SecFunctionalityType = H001G2_A351SecFunctionalityType[0] ;
            A350SecFunctionalityDescription = H001G2_A350SecFunctionalityDescription[0] ;
            A64SecFunctionalityKey = H001G2_A64SecFunctionalityKey[0] ;
            A62SecFunctionalityId = H001G2_A62SecFunctionalityId[0] ;
            A353SecParentFunctionalityDescript = H001G2_A353SecParentFunctionalityDescript[0] ;
            e191G2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(32) ;
         wb1G0( ) ;
      }
      bGXsfl_32_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1G2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV100Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV18IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV18IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV19IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV19IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECFUNCTIONALITYID"+"_"+sGXsfl_32_idx, getSecureSignedToken( sGXsfl_32_idx, localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9")));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = AV87TFSecFunctionalityKey_Sels ;
      AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = AV89TFSecFunctionalityDescription_Sels ;
      AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = AV91TFSecParentFunctionalityDescription_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A64SecFunctionalityKey ,
                                           AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels ,
                                           A350SecFunctionalityDescription ,
                                           AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels ,
                                           Byte.valueOf(A351SecFunctionalityType) ,
                                           AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels ,
                                           A353SecParentFunctionalityDescript ,
                                           AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels ,
                                           Integer.valueOf(AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels.size()) ,
                                           AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ,
                                           Integer.valueOf(AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels.size()) ,
                                           AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels.size()) ,
                                           Integer.valueOf(AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels.size()) ,
                                           AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ,
                                           Short.valueOf(AV29OrderedBy) ,
                                           Boolean.valueOf(AV30OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey), "%", "") ;
      lV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription), "%", "") ;
      lV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor H001G3 */
      pr_default.execute(1, new Object[] {lV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey, lV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription, lV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription});
      GRID_nRecordCount = H001G3_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = AV87TFSecFunctionalityKey_Sels ;
      AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = AV89TFSecFunctionalityDescription_Sels ;
      AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = AV91TFSecParentFunctionalityDescription_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV72ColumnsSelector, AV100Pgmname, AV41TFSecFunctionalityKey, AV87TFSecFunctionalityKey_Sels, AV45TFSecFunctionalityDescription, AV89TFSecFunctionalityDescription_Sels, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV91TFSecParentFunctionalityDescription_Sels, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = AV87TFSecFunctionalityKey_Sels ;
      AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = AV89TFSecFunctionalityDescription_Sels ;
      AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = AV91TFSecParentFunctionalityDescription_Sels ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV72ColumnsSelector, AV100Pgmname, AV41TFSecFunctionalityKey, AV87TFSecFunctionalityKey_Sels, AV45TFSecFunctionalityDescription, AV89TFSecFunctionalityDescription_Sels, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV91TFSecParentFunctionalityDescription_Sels, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = AV87TFSecFunctionalityKey_Sels ;
      AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = AV89TFSecFunctionalityDescription_Sels ;
      AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = AV91TFSecParentFunctionalityDescription_Sels ;
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV72ColumnsSelector, AV100Pgmname, AV41TFSecFunctionalityKey, AV87TFSecFunctionalityKey_Sels, AV45TFSecFunctionalityDescription, AV89TFSecFunctionalityDescription_Sels, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV91TFSecParentFunctionalityDescription_Sels, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = AV87TFSecFunctionalityKey_Sels ;
      AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = AV89TFSecFunctionalityDescription_Sels ;
      AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = AV91TFSecParentFunctionalityDescription_Sels ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV72ColumnsSelector, AV100Pgmname, AV41TFSecFunctionalityKey, AV87TFSecFunctionalityKey_Sels, AV45TFSecFunctionalityDescription, AV89TFSecFunctionalityDescription_Sels, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV91TFSecParentFunctionalityDescription_Sels, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = AV87TFSecFunctionalityKey_Sels ;
      AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = AV89TFSecFunctionalityDescription_Sels ;
      AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = AV91TFSecParentFunctionalityDescription_Sels ;
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV72ColumnsSelector, AV100Pgmname, AV41TFSecFunctionalityKey, AV87TFSecFunctionalityKey_Sels, AV45TFSecFunctionalityDescription, AV89TFSecFunctionalityDescription_Sels, AV81TFSecFunctionalityType_Sels, AV52TFSecParentFunctionalityDescription, AV91TFSecParentFunctionalityDescription_Sels, AV29OrderedBy, AV30OrderedDsc, AV18IsAuthorized_Update, AV19IsAuthorized_Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV100Pgmname = "WWPBaseObjects.SecFunctionalityWW" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1G0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e171G2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vAGEXPORTDATA"), AV94AGExportData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV55DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV72ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_32 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_32"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV83GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV84GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV92GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Class = httpContext.cgiGet( "GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_agexport_Icontype = httpContext.cgiGet( "DDO_AGEXPORT_Icontype") ;
         Ddo_agexport_Icon = httpContext.cgiGet( "DDO_AGEXPORT_Icon") ;
         Ddo_agexport_Caption = httpContext.cgiGet( "DDO_AGEXPORT_Caption") ;
         Ddo_agexport_Cls = httpContext.cgiGet( "DDO_AGEXPORT_Cls") ;
         Ddo_agexport_Titlecontrolidtoreplace = httpContext.cgiGet( "DDO_AGEXPORT_Titlecontrolidtoreplace") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Fixable = httpContext.cgiGet( "DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
         Ddo_gridcolumnsselector_Titlecontrolidtoreplace = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hascolumnsselector")) ;
         Grid_empowerer_Fixedcolumns = httpContext.cgiGet( "GRID_EMPOWERER_Fixedcolumns") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_agexport_Activeeventkey = httpContext.cgiGet( "DDO_AGEXPORT_Activeeventkey") ;
         /* Read variables values. */
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e171G2 ();
      if (returnInSub) return;
   }

   public void e171G2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV96CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      secfunctionalityww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV96CliCod = GXt_int1 ;
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      Ddo_agexport_Titlecontrolidtoreplace = bttBtnagexport_Internalname ;
      ucDdo_agexport.sendProperty(context, "", false, Ddo_agexport_Internalname, "TitleControlIdToReplace", Ddo_agexport_Titlecontrolidtoreplace);
      AV94AGExportData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV95AGExportDataItem = (web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV95AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "WWP_ExportCaption", "") );
      AV95AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "Export" );
      AV95AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV94AGExportData.add(AV95AGExportDataItem, 0);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Functionality", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      if ( AV29OrderedBy < 1 )
      {
         AV29OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV55DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV55DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e181G2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV96CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      secfunctionalityww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV96CliCod = GXt_int1 ;
      GXv_SdtWWPContext5[0] = AV79WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV79WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV13Session.getValue("WWPBaseObjects.SecFunctionalityWWColumnsSelector"), "") != 0 )
      {
         AV60ColumnsSelectorXML = AV13Session.getValue("WWPBaseObjects.SecFunctionalityWWColumnsSelector") ;
         AV72ColumnsSelector.fromxml(AV60ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S162 ();
         if (returnInSub) return;
      }
      edtSecFunctionalityKey_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV72ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityKey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityKey_Visible), 5, 0), !bGXsfl_32_Refreshing);
      edtSecFunctionalityDescription_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV72ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityDescription_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityDescription_Visible), 5, 0), !bGXsfl_32_Refreshing);
      cmbSecFunctionalityType.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV72ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Visible", GXutil.ltrimstr( cmbSecFunctionalityType.getVisible(), 5, 0), !bGXsfl_32_Refreshing);
      edtSecParentFunctionalityDescript_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV72ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityDescript_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityDescript_Visible), 5, 0), !bGXsfl_32_Refreshing);
      AV83GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV83GridCurrentPage), 10, 0));
      AV84GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV84GridPageCount), 10, 0));
      GXt_char6 = AV92GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV100Pgmname, GXv_char7) ;
      secfunctionalityww_impl.this.GXt_char6 = GXv_char7[0] ;
      AV92GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92GridAppliedFilters", AV92GridAppliedFilters);
      AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = AV41TFSecFunctionalityKey ;
      AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = AV87TFSecFunctionalityKey_Sels ;
      AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = AV45TFSecFunctionalityDescription ;
      AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = AV89TFSecFunctionalityDescription_Sels ;
      AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = AV81TFSecFunctionalityType_Sels ;
      AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = AV52TFSecParentFunctionalityDescription ;
      AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = AV91TFSecParentFunctionalityDescription_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72ColumnsSelector", AV72ColumnsSelector);
   }

   public void e111G2( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         subgrid_nextpage( ) ;
      }
      else
      {
         AV82PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV82PageToGo) ;
      }
   }

   public void e121G2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e141G2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV29OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29OrderedBy), 4, 0));
         AV30OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30OrderedDsc", AV30OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecFunctionalityKey") == 0 )
         {
            AV41TFSecFunctionalityKey = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSecFunctionalityKey", AV41TFSecFunctionalityKey);
            AV86TFSecFunctionalityKey_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86TFSecFunctionalityKey_SelsJson", AV86TFSecFunctionalityKey_SelsJson);
            AV87TFSecFunctionalityKey_Sels.fromJSonString(AV86TFSecFunctionalityKey_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecFunctionalityDescription") == 0 )
         {
            AV45TFSecFunctionalityDescription = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFSecFunctionalityDescription", AV45TFSecFunctionalityDescription);
            AV88TFSecFunctionalityDescription_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFSecFunctionalityDescription_SelsJson", AV88TFSecFunctionalityDescription_SelsJson);
            AV89TFSecFunctionalityDescription_Sels.fromJSonString(AV88TFSecFunctionalityDescription_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecFunctionalityType") == 0 )
         {
            AV80TFSecFunctionalityType_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFSecFunctionalityType_SelsJson", AV80TFSecFunctionalityType_SelsJson);
            AV81TFSecFunctionalityType_Sels.fromJSonString(GXutil.strReplace( AV80TFSecFunctionalityType_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecParentFunctionalityDescription") == 0 )
         {
            AV52TFSecParentFunctionalityDescription = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFSecParentFunctionalityDescription", AV52TFSecParentFunctionalityDescription);
            AV90TFSecParentFunctionalityDescription_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFSecParentFunctionalityDescription_SelsJson", AV90TFSecParentFunctionalityDescription_SelsJson);
            AV91TFSecParentFunctionalityDescription_Sels.fromJSonString(AV90TFSecParentFunctionalityDescription_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV87TFSecFunctionalityKey_Sels", AV87TFSecFunctionalityKey_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFSecFunctionalityDescription_Sels", AV89TFSecFunctionalityDescription_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFSecFunctionalityType_Sels", AV81TFSecFunctionalityType_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV91TFSecParentFunctionalityDescription_Sels", AV91TFSecParentFunctionalityDescription_Sels);
   }

   private void e191G2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      cmbavGridactions.removeAllItems();
      cmbavGridactions.addItem("0", ";fa fa-bars", (short)(0));
      if ( AV18IsAuthorized_Update )
      {
         cmbavGridactions.addItem("1", GXutil.format( "%1;%2", httpContext.getMessage( "GXM_update", ""), "fa fa-pen", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( AV19IsAuthorized_Delete )
      {
         cmbavGridactions.addItem("2", GXutil.format( "%1;%2", httpContext.getMessage( "GX_BtnDelete", ""), "fa fa-times", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( cmbavGridactions.getItemCount() == 1 )
      {
         cmbavGridactions.setThemeClass( "Invisible" );
      }
      else
      {
         cmbavGridactions.setThemeClass( "ConvertToDDO" );
      }
      edtavUaviewchildren_gximage = "ActionDisplay" ;
      AV24UAViewChildren = context.getHttpContext().getImagePath( "f11923b6-6acd-4a79-bfc0-0cfc6f3bced5", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUaviewchildren_Internalname, AV24UAViewChildren);
      AV108Uaviewchildren_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "f11923b6-6acd-4a79-bfc0-0cfc6f3bced5", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavUaviewchildren_Tooltiptext = httpContext.getMessage( "View Actions, Tabs and Modes", "") ;
      GXt_boolean8 = AV15TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secfunctionalityhaschildren(remoteHandle, context).execute( A62SecFunctionalityId, GXv_boolean9) ;
      secfunctionalityww_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV15TempBoolean = GXt_boolean8 ;
      if ( AV15TempBoolean )
      {
         edtavUaviewchildren_Link = formatLink("web.wwpbaseobjects.secfunctionalityfilterparentww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A62SecFunctionalityId,10,0))}, new String[] {"SecParentFunctionalityId"})  ;
         edtavUaviewchildren_Class = "ActionBaseColorAttribute" ;
      }
      else
      {
         edtavUaviewchildren_Link = "" ;
         edtavUaviewchildren_Class = "Invisible" ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(32) ;
      }
      sendrow_322( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_32_Refreshing )
      {
         httpContext.doAjaxLoad(32, GridRow);
      }
      /*  Sending Event outputs  */
      cmbavGridactions.setValue( GXutil.trim( GXutil.str( AV93GridActions, 4, 0)) );
   }

   public void e151G2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV60ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV72ColumnsSelector.fromJSonString(AV60ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityWWColumnsSelector", ((GXutil.strcmp("", AV60ColumnsSelectorXML)==0) ? "" : AV72ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV72ColumnsSelector", AV72ColumnsSelector);
   }

   public void e161G2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","SecFunctionalityId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e131G2( )
   {
      /* Ddo_agexport_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_agexport_Activeeventkey, "Export") == 0 )
      {
         /* Execute user subroutine: 'DOEXPORT' */
         S192 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV91TFSecParentFunctionalityDescription_Sels", AV91TFSecParentFunctionalityDescription_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV81TFSecFunctionalityType_Sels", AV81TFSecFunctionalityType_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV89TFSecFunctionalityDescription_Sels", AV89TFSecFunctionalityDescription_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV87TFSecFunctionalityKey_Sels", AV87TFSecFunctionalityKey_Sels);
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV29OrderedBy, 4, 0))+":"+(AV30OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S162( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV72ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10[0] = AV72ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SecFunctionalityKey", "", "Key", true, "") ;
      AV72ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV72ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SecFunctionalityDescription", "", "Description", true, "") ;
      AV72ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV72ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SecFunctionalityType", "", "Type", true, "") ;
      AV72ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV72ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SecParentFunctionalityDescription", "", "Parent Functionality", true, "") ;
      AV72ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char6 = AV67UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityWWColumnsSelector", GXv_char7) ;
      secfunctionalityww_impl.this.GXt_char6 = GXv_char7[0] ;
      AV67UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV67UserCustomValue)==0) ) )
      {
         AV85ColumnsSelectorAux.fromxml(AV67UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV72ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV85ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV72ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
   }

   public void S142( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean8 = AV18IsAuthorized_Update ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFunctionality", GXv_boolean9) ;
      secfunctionalityww_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV18IsAuthorized_Update = GXt_boolean8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18IsAuthorized_Update", AV18IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV18IsAuthorized_Update));
      GXt_boolean8 = AV19IsAuthorized_Delete ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFunctionality", GXv_boolean9) ;
      secfunctionalityww_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV19IsAuthorized_Delete = GXt_boolean8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19IsAuthorized_Delete", AV19IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV19IsAuthorized_Delete));
      GXt_boolean8 = AV15TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFunctionality", GXv_boolean9) ;
      secfunctionalityww_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV15TempBoolean = GXt_boolean8 ;
      if ( ! ( AV15TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S172( )
   {
      /* 'DO UPDATE' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A62SecFunctionalityId,10,0))}, new String[] {"Mode","SecFunctionalityId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S182( )
   {
      /* 'DO DELETE' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A62SecFunctionalityId,10,0))}, new String[] {"Mode","SecFunctionalityId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV13Session.getValue(AV100Pgmname+"GridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV100Pgmname+"GridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV13Session.getValue(AV100Pgmname+"GridState"), null, null);
      }
      AV29OrderedBy = AV27GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29OrderedBy), 4, 0));
      AV30OrderedDsc = AV27GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30OrderedDsc", AV30OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV109GXV1 = 1 ;
      while ( AV109GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV109GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV41TFSecFunctionalityKey = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFSecFunctionalityKey", AV41TFSecFunctionalityKey);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV86TFSecFunctionalityKey_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86TFSecFunctionalityKey_SelsJson", AV86TFSecFunctionalityKey_SelsJson);
            AV87TFSecFunctionalityKey_Sels.fromJSonString(AV86TFSecFunctionalityKey_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV45TFSecFunctionalityDescription = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFSecFunctionalityDescription", AV45TFSecFunctionalityDescription);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV88TFSecFunctionalityDescription_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFSecFunctionalityDescription_SelsJson", AV88TFSecFunctionalityDescription_SelsJson);
            AV89TFSecFunctionalityDescription_Sels.fromJSonString(AV88TFSecFunctionalityDescription_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV80TFSecFunctionalityType_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFSecFunctionalityType_SelsJson", AV80TFSecFunctionalityType_SelsJson);
            AV81TFSecFunctionalityType_Sels.fromJSonString(AV80TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV52TFSecParentFunctionalityDescription = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFSecParentFunctionalityDescription", AV52TFSecParentFunctionalityDescription);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV90TFSecParentFunctionalityDescription_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFSecParentFunctionalityDescription_SelsJson", AV90TFSecParentFunctionalityDescription_SelsJson);
            AV91TFSecParentFunctionalityDescription_Sels.fromJSonString(AV90TFSecParentFunctionalityDescription_SelsJson, null);
         }
         AV109GXV1 = (int)(AV109GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV87TFSecFunctionalityKey_Sels.size()==0), AV86TFSecFunctionalityKey_SelsJson, GXv_char7) ;
      secfunctionalityww_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV89TFSecFunctionalityDescription_Sels.size()==0), AV88TFSecFunctionalityDescription_SelsJson, GXv_char13) ;
      secfunctionalityww_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV91TFSecParentFunctionalityDescription_Sels.size()==0), AV90TFSecParentFunctionalityDescription_SelsJson, GXv_char15) ;
      secfunctionalityww_impl.this.GXt_char14 = GXv_char15[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char6+"|"+GXt_char12+"|"+((AV81TFSecFunctionalityType_Sels.size()==0) ? "" : AV80TFSecFunctionalityType_SelsJson)+"|"+GXt_char14 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV41TFSecFunctionalityKey)==0), AV41TFSecFunctionalityKey, GXv_char15) ;
      secfunctionalityww_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV45TFSecFunctionalityDescription)==0), AV45TFSecFunctionalityDescription, GXv_char13) ;
      secfunctionalityww_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFSecParentFunctionalityDescription)==0), AV52TFSecParentFunctionalityDescription, GXv_char7) ;
      secfunctionalityww_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = GXt_char14+"|"+GXt_char12+"||"+GXt_char6 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV27GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV27GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV27GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV27GridState.fromxml(AV13Session.getValue(AV100Pgmname+"GridState"), null, null);
      AV27GridState.setgxTv_SdtWWPGridState_Orderedby( AV29OrderedBy );
      AV27GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV30OrderedDsc );
      AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFSECFUNCTIONALITYKEY", httpContext.getMessage( "Key", ""), !(GXutil.strcmp("", AV41TFSecFunctionalityKey)==0), (short)(0), AV41TFSecFunctionalityKey, "", !(AV87TFSecFunctionalityKey_Sels.size()==0), AV87TFSecFunctionalityKey_Sels.toJSonString(false), "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFSECFUNCTIONALITYDESCRIPTION", httpContext.getMessage( "Description", ""), !(GXutil.strcmp("", AV45TFSecFunctionalityDescription)==0), (short)(0), AV45TFSecFunctionalityDescription, "", !(AV89TFSecFunctionalityDescription_Sels.size()==0), AV89TFSecFunctionalityDescription_Sels.toJSonString(false), "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFSECFUNCTIONALITYTYPE_SEL", httpContext.getMessage( "Type", ""), !(AV81TFSecFunctionalityType_Sels.size()==0), (short)(0), AV81TFSecFunctionalityType_Sels.toJSonString(false), "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV27GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFSECPARENTFUNCTIONALITYDESCRIPTION", httpContext.getMessage( "Parent Functionality", ""), !(GXutil.strcmp("", AV52TFSecParentFunctionalityDescription)==0), (short)(0), AV52TFSecParentFunctionalityDescription, "", !(AV91TFSecParentFunctionalityDescription_Sels.size()==0), AV91TFSecParentFunctionalityDescription_Sels.toJSonString(false), "") ;
      AV27GridState = GXv_SdtWWPGridState16[0] ;
      AV27GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV27GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV100Pgmname+"GridState", AV27GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV8TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV100Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV7HTTPRequest.getScriptName()+"?"+AV7HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "WWPBaseObjects.SecFunctionality" );
      AV13Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S192( )
   {
      /* 'DOEXPORT' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      GXv_char15[0] = AV32ExcelFilename ;
      GXv_char13[0] = AV33ErrorMessage ;
      new web.wwpbaseobjects.secfunctionalitywwexport(remoteHandle, context).execute( GXv_char15, GXv_char13) ;
      secfunctionalityww_impl.this.AV32ExcelFilename = GXv_char15[0] ;
      secfunctionalityww_impl.this.AV33ErrorMessage = GXv_char13[0] ;
      if ( GXutil.strcmp(AV32ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV32ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV33ErrorMessage);
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa1G2( ) ;
      ws1G2( ) ;
      we1G2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202041525", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("wwpbaseobjects/secfunctionalityww.js", "?202412202041525", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_322( )
   {
      cmbavGridactions.setInternalname( "vGRIDACTIONS_"+sGXsfl_32_idx );
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN_"+sGXsfl_32_idx ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_32_idx ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY_"+sGXsfl_32_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_32_idx ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE_"+sGXsfl_32_idx );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID_"+sGXsfl_32_idx ;
      edtSecParentFunctionalityDescript_Internalname = "SECPARENTFUNCTIONALITYDESCRIPT_"+sGXsfl_32_idx ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE_"+sGXsfl_32_idx );
   }

   public void subsflControlProps_fel_322( )
   {
      cmbavGridactions.setInternalname( "vGRIDACTIONS_"+sGXsfl_32_fel_idx );
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN_"+sGXsfl_32_fel_idx ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_32_fel_idx ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY_"+sGXsfl_32_fel_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_32_fel_idx ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE_"+sGXsfl_32_fel_idx );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID_"+sGXsfl_32_fel_idx ;
      edtSecParentFunctionalityDescript_Internalname = "SECPARENTFUNCTIONALITYDESCRIPT_"+sGXsfl_32_fel_idx ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE_"+sGXsfl_32_fel_idx );
   }

   public void sendrow_322( )
   {
      subsflControlProps_322( ) ;
      wb1G0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_32_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_32_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_32_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavGridactions.getEnabled()!=0)&&(cmbavGridactions.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 33,'',false,'"+sGXsfl_32_idx+"',32)\"" : " ") ;
         if ( ( cmbavGridactions.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vGRIDACTIONS_" + sGXsfl_32_idx ;
            cmbavGridactions.setName( GXCCtl );
            cmbavGridactions.setWebtags( "" );
            if ( cmbavGridactions.getItemCount() > 0 )
            {
               AV93GridActions = (short)(GXutil.lval( cmbavGridactions.getValidValue(GXutil.trim( GXutil.str( AV93GridActions, 4, 0))))) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV93GridActions), 4, 0));
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavGridactions,cmbavGridactions.getInternalname(),GXutil.trim( GXutil.str( AV93GridActions, 4, 0)),Integer.valueOf(1),cmbavGridactions.getJsonclick(),Integer.valueOf(7),"'"+""+"'"+",false,"+"'"+"e201g2_client"+"'","int","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","",cmbavGridactions.getThemeClass(),"WWActionGroupColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavGridactions.getEnabled()!=0)&&(cmbavGridactions.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,33);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavGridactions.setValue( GXutil.trim( GXutil.str( AV93GridActions, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGridactions.getInternalname(), "Values", cmbavGridactions.ToJavascriptSource(), !bGXsfl_32_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = edtavUaviewchildren_Class + " " + ((GXutil.strcmp(edtavUaviewchildren_gximage, "")==0) ? "" : "GX_Image_"+edtavUaviewchildren_gximage+"_Class") ;
         StyleString = "" ;
         AV24UAViewChildren_IsBlob = (boolean)(((GXutil.strcmp("", AV24UAViewChildren)==0)&&(GXutil.strcmp("", AV108Uaviewchildren_GXI)==0))||!(GXutil.strcmp("", AV24UAViewChildren)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV24UAViewChildren)==0) ? AV108Uaviewchildren_GXI : httpContext.getResourceRelative(AV24UAViewChildren)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavUaviewchildren_Internalname,sImgUrl,edtavUaviewchildren_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"",edtavUaviewchildren_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWActionColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV24UAViewChildren_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A62SecFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(32),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecFunctionalityKey_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityKey_Internalname,A64SecFunctionalityKey,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityKey_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSecFunctionalityKey_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(32),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecFunctionalityDescription_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityDescription_Internalname,A350SecFunctionalityDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSecFunctionalityDescription_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(32),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbSecFunctionalityType.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbSecFunctionalityType.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_32_idx ;
            cmbSecFunctionalityType.setName( GXCCtl );
            cmbSecFunctionalityType.setWebtags( "" );
            cmbSecFunctionalityType.addItem("1", httpContext.getMessage( "Mode", ""), (short)(0));
            cmbSecFunctionalityType.addItem("2", httpContext.getMessage( "Action", ""), (short)(0));
            cmbSecFunctionalityType.addItem("3", httpContext.getMessage( "Tab", ""), (short)(0));
            cmbSecFunctionalityType.addItem("4", httpContext.getMessage( "Object", ""), (short)(0));
            cmbSecFunctionalityType.addItem("5", httpContext.getMessage( "Attribute", ""), (short)(0));
            if ( cmbSecFunctionalityType.getItemCount() > 0 )
            {
               A351SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSecFunctionalityType,cmbSecFunctionalityType.getInternalname(),GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0)),Integer.valueOf(1),cmbSecFunctionalityType.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbSecFunctionalityType.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), !bGXsfl_32_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A63SecParentFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecParentFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(32),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecParentFunctionalityDescript_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityDescript_Internalname,A353SecParentFunctionalityDescript,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecParentFunctionalityDescript_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtSecParentFunctionalityDescript_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(32),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "SECFUNCTIONALITYACTIVE_" + sGXsfl_32_idx ;
         chkSecFunctionalityActive.setName( GXCCtl );
         chkSecFunctionalityActive.setWebtags( "" );
         chkSecFunctionalityActive.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkSecFunctionalityActive.getInternalname(), "TitleCaption", chkSecFunctionalityActive.getCaption(), !bGXsfl_32_Refreshing);
         chkSecFunctionalityActive.setCheckedValue( "false" );
         A349SecFunctionalityActive = GXutil.strtobool( GXutil.booltostr( A349SecFunctionalityActive)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkSecFunctionalityActive.getInternalname(),GXutil.booltostr( A349SecFunctionalityActive),"","",Integer.valueOf(0),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn hidden-xs","",""});
         send_integrity_lvl_hashes1G2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_32_idx = ((subGrid_Islastpage==1)&&(nGXsfl_32_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_32_idx+1) ;
         sGXsfl_32_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_32_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_322( ) ;
      }
      /* End function sendrow_322 */
   }

   public void startgridcontrol32( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"32\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+cmbavGridactions.getThemeClass()+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavUaviewchildren_Class+" "+((GXutil.strcmp(edtavUaviewchildren_gximage, "")==0) ? "" : "GX_Image_"+edtavUaviewchildren_gximage+"_Class")+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecFunctionalityKey_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Key", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecFunctionalityDescription_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Description", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbSecFunctionalityType.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Type", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecParentFunctionalityDescript_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Parent Functionality", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV93GridActions, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( cmbavGridactions.getThemeClass()));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV24UAViewChildren));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavUaviewchildren_Class));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUaviewchildren_Link));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavUaviewchildren_Tooltiptext));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A62SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A64SecFunctionalityKey);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityKey_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A350SecFunctionalityDescription);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityDescription_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A351SecFunctionalityType, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbSecFunctionalityType.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A63SecParentFunctionalityId, (byte)(10), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A353SecParentFunctionalityDescript);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecParentFunctionalityDescript_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A349SecFunctionalityActive));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      bttBtninsert_Internalname = "BTNINSERT" ;
      bttBtnagexport_Internalname = "BTNAGEXPORT" ;
      bttBtneditcolumns_Internalname = "BTNEDITCOLUMNS" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      divTableheadercontent_Internalname = "TABLEHEADERCONTENT" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      cmbavGridactions.setInternalname( "vGRIDACTIONS" );
      edtavUaviewchildren_Internalname = "vUAVIEWCHILDREN" ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID" ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY" ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION" ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE" );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID" ;
      edtSecParentFunctionalityDescript_Internalname = "SECPARENTFUNCTIONALITYDESCRIPT" ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_agexport_Internalname = "DDO_AGEXPORT" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      chkSecFunctionalityActive.setCaption( "" );
      edtSecParentFunctionalityDescript_Jsonclick = "" ;
      edtSecParentFunctionalityId_Jsonclick = "" ;
      cmbSecFunctionalityType.setJsonclick( "" );
      edtSecFunctionalityDescription_Jsonclick = "" ;
      edtSecFunctionalityKey_Jsonclick = "" ;
      edtSecFunctionalityId_Jsonclick = "" ;
      edtavUaviewchildren_gximage = "" ;
      edtavUaviewchildren_Class = "ActionBaseColorAttribute" ;
      edtavUaviewchildren_Link = "" ;
      edtavUaviewchildren_Tooltiptext = httpContext.getMessage( "View Actions, Tabs and Modes", "") ;
      cmbavGridactions.setJsonclick( "" );
      cmbavGridactions.setVisible( -1 );
      cmbavGridactions.setEnabled( 1 );
      cmbavGridactions.setThemeClass( "ConvertToDDO" );
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtSecParentFunctionalityDescript_Visible = -1 ;
      cmbSecFunctionalityType.setVisible( -1 );
      edtSecFunctionalityDescription_Visible = -1 ;
      edtSecFunctionalityKey_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      bttBtninsert_Visible = 1 ;
      Grid_empowerer_Fixedcolumns = "L;;;;;;;;" ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = "" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector hidden-xs" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "WWP_EditColumnsCaption", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Ddo_grid_Datalistproc = "WWPBaseObjects.SecFunctionalityWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||1:Mode,2:Action,3:Tab,4:Object,5:Attribute|" ;
      Ddo_grid_Allowmultipleselection = "T" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic|FixedValues|Dynamic" ;
      Ddo_grid_Includedatalist = "T" ;
      Ddo_grid_Filtertype = "Character|Character||Character" ;
      Ddo_grid_Includefilter = "T|T||T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4" ;
      Ddo_grid_Columnids = "3:SecFunctionalityKey|4:SecFunctionalityDescription|5:SecFunctionalityType|7:SecParentFunctionalityDescription" ;
      Ddo_grid_Gridinternalname = "" ;
      Ddo_agexport_Titlecontrolidtoreplace = "" ;
      Ddo_agexport_Cls = "ColumnsSelector" ;
      Ddo_agexport_Icon = "fas fa-download" ;
      Ddo_agexport_Icontype = "FontIcon" ;
      Gridpaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridpaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridpaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridpaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridpaginationbar_Pagingcaptionposition = "Left" ;
      Gridpaginationbar_Pagingbuttonsposition = "Right" ;
      Gridpaginationbar_Pagestoshow = 5 ;
      Gridpaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Class = "PaginationBar" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( " Functionality", "") );
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "vGRIDACTIONS_" + sGXsfl_32_idx ;
      cmbavGridactions.setName( GXCCtl );
      cmbavGridactions.setWebtags( "" );
      if ( cmbavGridactions.getItemCount() > 0 )
      {
         AV93GridActions = (short)(GXutil.lval( cmbavGridactions.getValidValue(GXutil.trim( GXutil.str( AV93GridActions, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV93GridActions), 4, 0));
      }
      GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_32_idx ;
      cmbSecFunctionalityType.setName( GXCCtl );
      cmbSecFunctionalityType.setWebtags( "" );
      cmbSecFunctionalityType.addItem("1", httpContext.getMessage( "Mode", ""), (short)(0));
      cmbSecFunctionalityType.addItem("2", httpContext.getMessage( "Action", ""), (short)(0));
      cmbSecFunctionalityType.addItem("3", httpContext.getMessage( "Tab", ""), (short)(0));
      cmbSecFunctionalityType.addItem("4", httpContext.getMessage( "Object", ""), (short)(0));
      cmbSecFunctionalityType.addItem("5", httpContext.getMessage( "Attribute", ""), (short)(0));
      if ( cmbSecFunctionalityType.getItemCount() > 0 )
      {
         A351SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0))))) ;
      }
      GXCCtl = "SECFUNCTIONALITYACTIVE_" + sGXsfl_32_idx ;
      chkSecFunctionalityActive.setName( GXCCtl );
      chkSecFunctionalityActive.setWebtags( "" );
      chkSecFunctionalityActive.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSecFunctionalityActive.getInternalname(), "TitleCaption", chkSecFunctionalityActive.getCaption(), !bGXsfl_32_Refreshing);
      chkSecFunctionalityActive.setCheckedValue( "false" );
      A349SecFunctionalityActive = GXutil.strtobool( GXutil.booltostr( A349SecFunctionalityActive)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV87TFSecFunctionalityKey_Sels',fld:'vTFSECFUNCTIONALITYKEY_SELS',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV89TFSecFunctionalityDescription_Sels',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV91TFSecParentFunctionalityDescription_Sels',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtSecFunctionalityKey_Visible',ctrl:'SECFUNCTIONALITYKEY',prop:'Visible'},{av:'edtSecFunctionalityDescription_Visible',ctrl:'SECFUNCTIONALITYDESCRIPTION',prop:'Visible'},{av:'cmbSecFunctionalityType'},{av:'edtSecParentFunctionalityDescript_Visible',ctrl:'SECPARENTFUNCTIONALITYDESCRIPT',prop:'Visible'},{av:'AV83GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV84GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV92GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{ctrl:'BTNINSERT',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e111G2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV87TFSecFunctionalityKey_Sels',fld:'vTFSECFUNCTIONALITYKEY_SELS',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV89TFSecFunctionalityDescription_Sels',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV91TFSecParentFunctionalityDescription_Sels',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e121G2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV87TFSecFunctionalityKey_Sels',fld:'vTFSECFUNCTIONALITYKEY_SELS',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV89TFSecFunctionalityDescription_Sels',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV91TFSecParentFunctionalityDescription_Sels',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e141G2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV87TFSecFunctionalityKey_Sels',fld:'vTFSECFUNCTIONALITYKEY_SELS',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV89TFSecFunctionalityDescription_Sels',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV91TFSecParentFunctionalityDescription_Sels',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV86TFSecFunctionalityKey_SelsJson',fld:'vTFSECFUNCTIONALITYKEY_SELSJSON',pic:''},{av:'AV87TFSecFunctionalityKey_Sels',fld:'vTFSECFUNCTIONALITYKEY_SELS',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV88TFSecFunctionalityDescription_SelsJson',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELSJSON',pic:''},{av:'AV89TFSecFunctionalityDescription_Sels',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV90TFSecParentFunctionalityDescription_SelsJson',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELSJSON',pic:''},{av:'AV91TFSecParentFunctionalityDescription_Sels',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e191G2',iparms:[{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A62SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'cmbavGridactions'},{av:'AV93GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'},{av:'AV24UAViewChildren',fld:'vUAVIEWCHILDREN',pic:''},{av:'edtavUaviewchildren_Tooltiptext',ctrl:'vUAVIEWCHILDREN',prop:'Tooltiptext'},{av:'edtavUaviewchildren_Link',ctrl:'vUAVIEWCHILDREN',prop:'Link'},{av:'edtavUaviewchildren_Class',ctrl:'vUAVIEWCHILDREN',prop:'Class'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e151G2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV87TFSecFunctionalityKey_Sels',fld:'vTFSECFUNCTIONALITYKEY_SELS',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV89TFSecFunctionalityDescription_Sels',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV91TFSecParentFunctionalityDescription_Sels',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtSecFunctionalityKey_Visible',ctrl:'SECFUNCTIONALITYKEY',prop:'Visible'},{av:'edtSecFunctionalityDescription_Visible',ctrl:'SECFUNCTIONALITYDESCRIPTION',prop:'Visible'},{av:'cmbSecFunctionalityType'},{av:'edtSecParentFunctionalityDescript_Visible',ctrl:'SECPARENTFUNCTIONALITYDESCRIPT',prop:'Visible'},{av:'AV83GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV84GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV92GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{ctrl:'BTNINSERT',prop:'Visible'}]}");
      setEventMetadata("VGRIDACTIONS.CLICK","{handler:'e201G2',iparms:[{av:'cmbavGridactions'},{av:'AV93GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'},{av:'A62SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("VGRIDACTIONS.CLICK",",oparms:[{av:'cmbavGridactions'},{av:'AV93GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'}]}");
      setEventMetadata("'DOINSERT'","{handler:'e161G2',iparms:[{av:'A62SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("DDO_AGEXPORT.ONOPTIONCLICKED","{handler:'e131G2',iparms:[{av:'Ddo_agexport_Activeeventkey',ctrl:'DDO_AGEXPORT',prop:'ActiveEventKey'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV87TFSecFunctionalityKey_Sels',fld:'vTFSECFUNCTIONALITYKEY_SELS',pic:''},{av:'AV86TFSecFunctionalityKey_SelsJson',fld:'vTFSECFUNCTIONALITYKEY_SELSJSON',pic:''},{av:'AV89TFSecFunctionalityDescription_Sels',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV88TFSecFunctionalityDescription_SelsJson',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELSJSON',pic:''},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV91TFSecParentFunctionalityDescription_Sels',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV90TFSecParentFunctionalityDescription_SelsJson',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELSJSON',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("DDO_AGEXPORT.ONOPTIONCLICKED",",oparms:[{av:'AV29OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV30OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV90TFSecParentFunctionalityDescription_SelsJson',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELSJSON',pic:''},{av:'AV91TFSecParentFunctionalityDescription_Sels',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV52TFSecParentFunctionalityDescription',fld:'vTFSECPARENTFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV80TFSecFunctionalityType_SelsJson',fld:'vTFSECFUNCTIONALITYTYPE_SELSJSON',pic:''},{av:'AV81TFSecFunctionalityType_Sels',fld:'vTFSECFUNCTIONALITYTYPE_SELS',pic:''},{av:'AV88TFSecFunctionalityDescription_SelsJson',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELSJSON',pic:''},{av:'AV89TFSecFunctionalityDescription_Sels',fld:'vTFSECFUNCTIONALITYDESCRIPTION_SELS',pic:''},{av:'AV45TFSecFunctionalityDescription',fld:'vTFSECFUNCTIONALITYDESCRIPTION',pic:''},{av:'AV86TFSecFunctionalityKey_SelsJson',fld:'vTFSECFUNCTIONALITYKEY_SELSJSON',pic:''},{av:'AV87TFSecFunctionalityKey_Sels',fld:'vTFSECFUNCTIONALITYKEY_SELS',pic:''},{av:'AV41TFSecFunctionalityKey',fld:'vTFSECFUNCTIONALITYKEY',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV72ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV18IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV19IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID","{handler:'valid_Secparentfunctionalityid',iparms:[]");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Secfunctionalityactive',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_agexport_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV72ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV100Pgmname = "" ;
      AV41TFSecFunctionalityKey = "" ;
      AV87TFSecFunctionalityKey_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFSecFunctionalityDescription = "" ;
      AV89TFSecFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV52TFSecParentFunctionalityDescription = "" ;
      AV91TFSecParentFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV92GridAppliedFilters = "" ;
      AV94AGExportData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV55DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV86TFSecFunctionalityKey_SelsJson = "" ;
      AV88TFSecFunctionalityDescription_SelsJson = "" ;
      AV80TFSecFunctionalityType_SelsJson = "" ;
      AV90TFSecParentFunctionalityDescription_SelsJson = "" ;
      Ddo_agexport_Caption = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtninsert_Jsonclick = "" ;
      bttBtnagexport_Jsonclick = "" ;
      bttBtneditcolumns_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_agexport = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV24UAViewChildren = "" ;
      AV108Uaviewchildren_GXI = "" ;
      A64SecFunctionalityKey = "" ;
      A350SecFunctionalityDescription = "" ;
      A353SecParentFunctionalityDescript = "" ;
      AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = "" ;
      lV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = "" ;
      lV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = "" ;
      AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey = "" ;
      AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription = "" ;
      AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription = "" ;
      H001G2_A349SecFunctionalityActive = new boolean[] {false} ;
      H001G2_A353SecParentFunctionalityDescript = new String[] {""} ;
      H001G2_A63SecParentFunctionalityId = new long[1] ;
      H001G2_n63SecParentFunctionalityId = new boolean[] {false} ;
      H001G2_A351SecFunctionalityType = new byte[1] ;
      H001G2_A350SecFunctionalityDescription = new String[] {""} ;
      H001G2_A64SecFunctionalityKey = new String[] {""} ;
      H001G2_A62SecFunctionalityId = new long[1] ;
      H001G3_AGRID_nRecordCount = new long[1] ;
      AV95AGExportDataItem = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int2 = new int[1] ;
      AV79WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV13Session = httpContext.getWebSession();
      AV60ColumnsSelectorXML = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV67UserCustomValue = "" ;
      AV85ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char14 = "" ;
      GXt_char12 = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState16 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV8TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV7HTTPRequest = httpContext.getHttpRequest();
      AV32ExcelFilename = "" ;
      GXv_char15 = new String[1] ;
      AV33ErrorMessage = "" ;
      GXv_char13 = new String[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      GXCCtl = "" ;
      sImgUrl = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secfunctionalityww__default(),
         new Object[] {
             new Object[] {
            H001G2_A349SecFunctionalityActive, H001G2_A353SecParentFunctionalityDescript, H001G2_A63SecParentFunctionalityId, H001G2_n63SecParentFunctionalityId, H001G2_A351SecFunctionalityType, H001G2_A350SecFunctionalityDescription, H001G2_A64SecFunctionalityKey, H001G2_A62SecFunctionalityId
            }
            , new Object[] {
            H001G3_AGRID_nRecordCount
            }
         }
      );
      AV100Pgmname = "WWPBaseObjects.SecFunctionalityWW" ;
      /* GeneXus formulas. */
      AV100Pgmname = "WWPBaseObjects.SecFunctionalityWW" ;
      Gx_err = (short)(0) ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte A351SecFunctionalityType ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV29OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short AV93GridActions ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_32 ;
   private int nGXsfl_32_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size ;
   private int AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size ;
   private int AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels_size ;
   private int AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size ;
   private int AV96CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtSecFunctionalityKey_Visible ;
   private int edtSecFunctionalityDescription_Visible ;
   private int edtSecParentFunctionalityDescript_Visible ;
   private int AV82PageToGo ;
   private int AV109GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV83GridCurrentPage ;
   private long AV84GridPageCount ;
   private long A62SecFunctionalityId ;
   private long A63SecParentFunctionalityId ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_agexport_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_32_idx="0001" ;
   private String AV100Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Rowsperpageoptions ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Gridpaginationbar_Rowsperpagecaption ;
   private String Ddo_agexport_Icontype ;
   private String Ddo_agexport_Icon ;
   private String Ddo_agexport_Caption ;
   private String Ddo_agexport_Cls ;
   private String Ddo_agexport_Titlecontrolidtoreplace ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Fixable ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
   private String Ddo_gridcolumnsselector_Titlecontrolidtoreplace ;
   private String Grid_empowerer_Gridinternalname ;
   private String Grid_empowerer_Fixedcolumns ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtninsert_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String bttBtnagexport_Internalname ;
   private String bttBtnagexport_Jsonclick ;
   private String bttBtneditcolumns_Internalname ;
   private String bttBtneditcolumns_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_agexport_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUaviewchildren_Internalname ;
   private String edtSecFunctionalityId_Internalname ;
   private String edtSecFunctionalityKey_Internalname ;
   private String edtSecFunctionalityDescription_Internalname ;
   private String edtSecParentFunctionalityId_Internalname ;
   private String edtSecParentFunctionalityDescript_Internalname ;
   private String scmdbuf ;
   private String edtavUaviewchildren_gximage ;
   private String edtavUaviewchildren_Tooltiptext ;
   private String edtavUaviewchildren_Link ;
   private String edtavUaviewchildren_Class ;
   private String GXt_char14 ;
   private String GXt_char12 ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXv_char15[] ;
   private String GXv_char13[] ;
   private String sGXsfl_32_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String GXCCtl ;
   private String sImgUrl ;
   private String ROClassString ;
   private String edtSecFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityKey_Jsonclick ;
   private String edtSecFunctionalityDescription_Jsonclick ;
   private String edtSecParentFunctionalityId_Jsonclick ;
   private String edtSecParentFunctionalityDescript_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV30OrderedDsc ;
   private boolean AV18IsAuthorized_Update ;
   private boolean AV19IsAuthorized_Delete ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_32_Refreshing=false ;
   private boolean n63SecParentFunctionalityId ;
   private boolean A349SecFunctionalityActive ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV15TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private boolean AV24UAViewChildren_IsBlob ;
   private String AV86TFSecFunctionalityKey_SelsJson ;
   private String AV88TFSecFunctionalityDescription_SelsJson ;
   private String AV80TFSecFunctionalityType_SelsJson ;
   private String AV90TFSecParentFunctionalityDescription_SelsJson ;
   private String AV60ColumnsSelectorXML ;
   private String AV67UserCustomValue ;
   private String AV41TFSecFunctionalityKey ;
   private String AV45TFSecFunctionalityDescription ;
   private String AV52TFSecParentFunctionalityDescription ;
   private String AV92GridAppliedFilters ;
   private String AV108Uaviewchildren_GXI ;
   private String A64SecFunctionalityKey ;
   private String A350SecFunctionalityDescription ;
   private String A353SecParentFunctionalityDescript ;
   private String lV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ;
   private String lV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ;
   private String lV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ;
   private String AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ;
   private String AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ;
   private String AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ;
   private String AV32ExcelFilename ;
   private String AV33ErrorMessage ;
   private String AV24UAViewChildren ;
   private GXSimpleCollection<Byte> AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels ;
   private GXSimpleCollection<Byte> AV81TFSecFunctionalityType_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV7HTTPRequest ;
   private com.genexus.webpanels.WebSession AV13Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_agexport ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private GXSimpleCollection<String> AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels ;
   private GXSimpleCollection<String> AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels ;
   private GXSimpleCollection<String> AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels ;
   private HTMLChoice cmbavGridactions ;
   private HTMLChoice cmbSecFunctionalityType ;
   private ICheckbox chkSecFunctionalityActive ;
   private IDataStoreProvider pr_default ;
   private boolean[] H001G2_A349SecFunctionalityActive ;
   private String[] H001G2_A353SecParentFunctionalityDescript ;
   private long[] H001G2_A63SecParentFunctionalityId ;
   private boolean[] H001G2_n63SecParentFunctionalityId ;
   private byte[] H001G2_A351SecFunctionalityType ;
   private String[] H001G2_A350SecFunctionalityDescription ;
   private String[] H001G2_A64SecFunctionalityKey ;
   private long[] H001G2_A62SecFunctionalityId ;
   private long[] H001G3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV87TFSecFunctionalityKey_Sels ;
   private GXSimpleCollection<String> AV89TFSecFunctionalityDescription_Sels ;
   private GXSimpleCollection<String> AV91TFSecParentFunctionalityDescription_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV94AGExportData ;
   private web.wwpbaseobjects.SdtWWPContext AV79WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState16[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV95AGExportDataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV55DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV72ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV85ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
}

final  class secfunctionalityww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001G2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A64SecFunctionalityKey ,
                                          GXSimpleCollection<String> AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels ,
                                          String A350SecFunctionalityDescription ,
                                          GXSimpleCollection<String> AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels ,
                                          byte A351SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels ,
                                          String A353SecParentFunctionalityDescript ,
                                          GXSimpleCollection<String> AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels ,
                                          int AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size ,
                                          String AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ,
                                          int AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size ,
                                          String AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ,
                                          int AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels_size ,
                                          int AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size ,
                                          String AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ,
                                          short AV29OrderedBy ,
                                          boolean AV30OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[6];
      Object[] GXv_Object18 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.SecFunctionalityActive, T2.SecFunctionalityDescription AS SecParentFunctionalityDescript, T1.SecParentFunctionalityId AS SecParentFunctionalityId, T1.SecFunctionalityType," ;
      sSelectString += " T1.SecFunctionalityDescription, T1.SecFunctionalityKey, T1.SecFunctionalityId" ;
      sFromString = " FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      sOrderString = "" ;
      if ( ( AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityKey) like LOWER(?))");
      }
      else
      {
         GXv_int17[0] = (byte)(1) ;
      }
      if ( AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels, "T1.SecFunctionalityKey IN (", ")")+")");
      }
      if ( ( AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels, "T1.SecFunctionalityDescription IN (", ")")+")");
      }
      if ( AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels, "T1.SecFunctionalityType IN (", ")")+")");
      }
      if ( ( AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels, "T2.SecFunctionalityDescription IN (", ")")+")");
      }
      if ( ( AV29OrderedBy == 1 ) && ! AV30OrderedDsc )
      {
         sOrderString += " ORDER BY T1.SecFunctionalityKey" ;
      }
      else if ( ( AV29OrderedBy == 1 ) && ( AV30OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.SecFunctionalityKey DESC" ;
      }
      else if ( ( AV29OrderedBy == 2 ) && ! AV30OrderedDsc )
      {
         sOrderString += " ORDER BY T1.SecFunctionalityDescription, T1.SecFunctionalityId" ;
      }
      else if ( ( AV29OrderedBy == 2 ) && ( AV30OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.SecFunctionalityDescription DESC, T1.SecFunctionalityId" ;
      }
      else if ( ( AV29OrderedBy == 3 ) && ! AV30OrderedDsc )
      {
         sOrderString += " ORDER BY T1.SecFunctionalityType, T1.SecFunctionalityId" ;
      }
      else if ( ( AV29OrderedBy == 3 ) && ( AV30OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.SecFunctionalityType DESC, T1.SecFunctionalityId" ;
      }
      else if ( ( AV29OrderedBy == 4 ) && ! AV30OrderedDsc )
      {
         sOrderString += " ORDER BY T2.SecFunctionalityDescription, T1.SecFunctionalityId" ;
      }
      else if ( ( AV29OrderedBy == 4 ) && ( AV30OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.SecFunctionalityDescription DESC, T1.SecFunctionalityId" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.SecFunctionalityId" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_H001G3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A64SecFunctionalityKey ,
                                          GXSimpleCollection<String> AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels ,
                                          String A350SecFunctionalityDescription ,
                                          GXSimpleCollection<String> AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels ,
                                          byte A351SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels ,
                                          String A353SecParentFunctionalityDescript ,
                                          GXSimpleCollection<String> AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels ,
                                          int AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size ,
                                          String AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey ,
                                          int AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size ,
                                          String AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription ,
                                          int AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels_size ,
                                          int AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size ,
                                          String AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription ,
                                          short AV29OrderedBy ,
                                          boolean AV30OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[3];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      if ( ( AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Wwpbaseobjects_secfunctionalitywwds_1_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityKey) like LOWER(?))");
      }
      else
      {
         GXv_int20[0] = (byte)(1) ;
      }
      if ( AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey_sels, "T1.SecFunctionalityKey IN (", ")")+")");
      }
      if ( ( AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV103Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int20[1] = (byte)(1) ;
      }
      if ( AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription_sels, "T1.SecFunctionalityDescription IN (", ")")+")");
      }
      if ( AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitytype_sels, "T1.SecFunctionalityType IN (", ")")+")");
      }
      if ( ( AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Wwpbaseobjects_secfunctionalitywwds_6_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription_sels, "T2.SecFunctionalityDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV29OrderedBy == 1 ) && ! AV30OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 1 ) && ( AV30OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 2 ) && ! AV30OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 2 ) && ( AV30OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 3 ) && ! AV30OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 3 ) && ( AV30OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 4 ) && ! AV30OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV29OrderedBy == 4 ) && ( AV30OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_H001G2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
            case 1 :
                  return conditional_H001G3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Boolean) dynConstraints[16]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001G2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001G3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((long[]) buf[7])[0] = rslt.getLong(7);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 100);
               }
               return;
      }
   }

}

