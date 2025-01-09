package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secroleww_impl extends GXDataArea
{
   public secroleww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secroleww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secroleww_impl.class ));
   }

   public secroleww_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavDynamicfiltersselector1 = new HTMLChoice();
      cmbavDynamicfiltersoperator1 = new HTMLChoice();
      cmbavDynamicfiltersselector2 = new HTMLChoice();
      cmbavDynamicfiltersoperator2 = new HTMLChoice();
      cmbavDynamicfiltersselector3 = new HTMLChoice();
      cmbavDynamicfiltersoperator3 = new HTMLChoice();
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
      nRC_GXsfl_103 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_103"))) ;
      nGXsfl_103_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_103_idx"))) ;
      sGXsfl_103_idx = httpContext.GetPar( "sGXsfl_103_idx") ;
      edtavUaassociatefunctionalities_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUaassociatefunctionalities_Internalname, "Title", edtavUaassociatefunctionalities_Title, !bGXsfl_103_Refreshing);
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
      cmbavDynamicfiltersselector1.fromJSonString( httpContext.GetNextPar( ));
      AV46DynamicFiltersSelector1 = httpContext.GetPar( "DynamicFiltersSelector1") ;
      cmbavDynamicfiltersoperator1.fromJSonString( httpContext.GetNextPar( ));
      AV47DynamicFiltersOperator1 = (short)(GXutil.lval( httpContext.GetPar( "DynamicFiltersOperator1"))) ;
      AV48SecRoleName1 = httpContext.GetPar( "SecRoleName1") ;
      cmbavDynamicfiltersselector2.fromJSonString( httpContext.GetNextPar( ));
      AV51DynamicFiltersSelector2 = httpContext.GetPar( "DynamicFiltersSelector2") ;
      cmbavDynamicfiltersoperator2.fromJSonString( httpContext.GetNextPar( ));
      AV52DynamicFiltersOperator2 = (short)(GXutil.lval( httpContext.GetPar( "DynamicFiltersOperator2"))) ;
      AV53SecRoleName2 = httpContext.GetPar( "SecRoleName2") ;
      cmbavDynamicfiltersselector3.fromJSonString( httpContext.GetNextPar( ));
      AV56DynamicFiltersSelector3 = httpContext.GetPar( "DynamicFiltersSelector3") ;
      cmbavDynamicfiltersoperator3.fromJSonString( httpContext.GetNextPar( ));
      AV57DynamicFiltersOperator3 = (short)(GXutil.lval( httpContext.GetPar( "DynamicFiltersOperator3"))) ;
      AV58SecRoleName3 = httpContext.GetPar( "SecRoleName3") ;
      AV64ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      AV100Pgmname = httpContext.GetPar( "Pgmname") ;
      AV50DynamicFiltersEnabled2 = GXutil.strtobool( httpContext.GetPar( "DynamicFiltersEnabled2")) ;
      AV55DynamicFiltersEnabled3 = GXutil.strtobool( httpContext.GetPar( "DynamicFiltersEnabled3")) ;
      AV71TFSecRoleName = httpContext.GetPar( "TFSecRoleName") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV92TFSecRoleName_Sels);
      AV75TFSecRoleDescription = httpContext.GetPar( "TFSecRoleDescription") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV94TFSecRoleDescription_Sels);
      AV44OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV45OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV41GridState);
      AV61DynamicFiltersIgnoreFirst = GXutil.strtobool( httpContext.GetPar( "DynamicFiltersIgnoreFirst")) ;
      AV60DynamicFiltersRemoving = GXutil.strtobool( httpContext.GetPar( "DynamicFiltersRemoving")) ;
      edtavUaassociatefunctionalities_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUaassociatefunctionalities_Internalname, "Title", edtavUaassociatefunctionalities_Title, !bGXsfl_103_Refreshing);
      AV40IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV37IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV35IsAuthorized_UAAssociateFunctionalities = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_UAAssociateFunctionalities")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
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
      pa1H2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1H2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.wwpbaseobjects.secroleww", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV40IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV37IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES", getSecureSignedToken( "", AV35IsAuthorized_UAAssociateFunctionalities));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSSELECTOR1", AV46DynamicFiltersSelector1);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSOPERATOR1", GXutil.ltrim( localUtil.ntoc( AV47DynamicFiltersOperator1, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECROLENAME1", AV48SecRoleName1);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSSELECTOR2", AV51DynamicFiltersSelector2);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSOPERATOR2", GXutil.ltrim( localUtil.ntoc( AV52DynamicFiltersOperator2, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECROLENAME2", AV53SecRoleName2);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSSELECTOR3", AV56DynamicFiltersSelector3);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSOPERATOR3", GXutil.ltrim( localUtil.ntoc( AV57DynamicFiltersOperator3, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECROLENAME3", AV58SecRoleName3);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_103", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_103, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV68ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV68ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV89GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV90GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV95GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV78DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV78DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV64ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV100Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDYNAMICFILTERSENABLED2", AV50DynamicFiltersEnabled2);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDYNAMICFILTERSENABLED3", AV55DynamicFiltersEnabled3);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECROLENAME", AV71TFSecRoleName);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSECROLENAME_SELS", AV92TFSecRoleName_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSECROLENAME_SELS", AV92TFSecRoleName_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECROLEDESCRIPTION", AV75TFSecRoleDescription);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSECROLEDESCRIPTION_SELS", AV94TFSecRoleDescription_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSECROLEDESCRIPTION_SELS", AV94TFSecRoleDescription_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV44OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV45OrderedDsc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV41GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV41GridState);
      }
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDYNAMICFILTERSIGNOREFIRST", AV61DynamicFiltersIgnoreFirst);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDYNAMICFILTERSREMOVING", AV60DynamicFiltersRemoving);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV40IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV40IsAuthorized_Delete));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV37IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV37IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES", AV35IsAuthorized_UAAssociateFunctionalities);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES", getSecureSignedToken( "", AV35IsAuthorized_UAAssociateFunctionalities));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECROLENAME_SELSJSON", AV91TFSecRoleName_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECROLEDESCRIPTION_SELSJSON", AV93TFSecRoleDescription_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Width", GXutil.rtrim( Innewwindow1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Height", GXutil.rtrim( Innewwindow1_Height));
      web.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "vUAASSOCIATEFUNCTIONALITIES_Title", GXutil.rtrim( edtavUaassociatefunctionalities_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         we1H2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1H2( ) ;
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
      return formatLink("web.wwpbaseobjects.secroleww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecRoleWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Role", "") ;
   }

   public void wb1H0( )
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
         web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellWidthAuto", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "TableCellsWidthAuto", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupGrouped", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 103, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgBtnexport_gximage, "")==0) ? "GX_Image_(none)_Class" : "GX_Image_"+imgBtnexport_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = "(none)" ;
         web.GxWebStd.gx_bitmap( httpContext, imgBtnexport_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", httpContext.getMessage( "WWP_ExportTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgBtnexport_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportreport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 103, 3, 0)+","+"null"+");", httpContext.getMessage( "WWP_ExportReportCaption", ""), bttBtnexportreport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportReportTooltip", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORTREPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-6 CellFloatRight CellWidthAuto", "left", "top", "", "", "div");
         wb_table1_22_1H2( true) ;
      }
      else
      {
         wb_table1_22_1H2( false) ;
      }
      return  ;
   }

   public void wb_table1_22_1H2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol103( ) ;
      }
      if ( wbEnd == 103 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_103 = (int)(nGXsfl_103_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV89GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV90GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV95GridAppliedFilters);
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
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblJsdynamicfilters_Internalname, lblJsdynamicfilters_Caption, "", "", lblJsdynamicfilters_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV78DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 103 )
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

   public void start1H2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Role", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1H0( ) ;
   }

   public void ws1H2( )
   {
      start1H2( ) ;
      evt1H2( ) ;
   }

   public void evt1H2( )
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
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e111H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e141H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'REMOVEDYNAMICFILTERS1'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'RemoveDynamicFilters1' */
                           e151H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'REMOVEDYNAMICFILTERS2'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'RemoveDynamicFilters2' */
                           e161H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'REMOVEDYNAMICFILTERS3'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'RemoveDynamicFilters3' */
                           e171H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e181H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e191H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORTREPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExportReport' */
                           e201H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADDDYNAMICFILTERS1'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'AddDynamicFilters1' */
                           e211H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VDYNAMICFILTERSSELECTOR1.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e221H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADDDYNAMICFILTERS2'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'AddDynamicFilters2' */
                           e231H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VDYNAMICFILTERSSELECTOR2.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e241H2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VDYNAMICFILTERSSELECTOR3.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e251H2 ();
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
                           nGXsfl_103_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_103_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_103_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1032( ) ;
                           AV14Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV14Delete);
                           AV13Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV13Update);
                           AV34UAAssociateFunctionalities = httpContext.cgiGet( edtavUaassociatefunctionalities_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavUaassociatefunctionalities_Internalname, "Bitmap", ((GXutil.strcmp("", AV34UAAssociateFunctionalities)==0) ? AV116Uaassociatefunctionalities_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV34UAAssociateFunctionalities))), !bGXsfl_103_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavUaassociatefunctionalities_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV34UAAssociateFunctionalities), true);
                           A65SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecRoleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A355SecRoleName = httpContext.cgiGet( edtSecRoleName_Internalname) ;
                           A354SecRoleDescription = httpContext.cgiGet( edtSecRoleDescription_Internalname) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e261H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e271H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e281H2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Dynamicfiltersselector1 Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR1"), AV46DynamicFiltersSelector1) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Dynamicfiltersoperator1 Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV47DynamicFiltersOperator1 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Secrolename1 Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECROLENAME1"), AV48SecRoleName1) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Dynamicfiltersselector2 Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR2"), AV51DynamicFiltersSelector2) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Dynamicfiltersoperator2 Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV52DynamicFiltersOperator2 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Secrolename2 Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECROLENAME2"), AV53SecRoleName2) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Dynamicfiltersselector3 Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR3"), AV56DynamicFiltersSelector3) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Dynamicfiltersoperator3 Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR3"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV57DynamicFiltersOperator3 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Secrolename3 Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECROLENAME3"), AV58SecRoleName3) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
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

   public void we1H2( )
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

   public void pa1H2( )
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
            GX_FocusControl = cmbavDynamicfiltersselector1.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
      subsflControlProps_1032( ) ;
      while ( nGXsfl_103_idx <= nRC_GXsfl_103 )
      {
         sendrow_1032( ) ;
         nGXsfl_103_idx = ((subGrid_Islastpage==1)&&(nGXsfl_103_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_103_idx+1) ;
         sGXsfl_103_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_103_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1032( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV46DynamicFiltersSelector1 ,
                                 short AV47DynamicFiltersOperator1 ,
                                 String AV48SecRoleName1 ,
                                 String AV51DynamicFiltersSelector2 ,
                                 short AV52DynamicFiltersOperator2 ,
                                 String AV53SecRoleName2 ,
                                 String AV56DynamicFiltersSelector3 ,
                                 short AV57DynamicFiltersOperator3 ,
                                 String AV58SecRoleName3 ,
                                 byte AV64ManageFiltersExecutionStep ,
                                 String AV100Pgmname ,
                                 boolean AV50DynamicFiltersEnabled2 ,
                                 boolean AV55DynamicFiltersEnabled3 ,
                                 String AV71TFSecRoleName ,
                                 GXSimpleCollection<String> AV92TFSecRoleName_Sels ,
                                 String AV75TFSecRoleDescription ,
                                 GXSimpleCollection<String> AV94TFSecRoleDescription_Sels ,
                                 short AV44OrderedBy ,
                                 boolean AV45OrderedDsc ,
                                 web.wwpbaseobjects.SdtWWPGridState AV41GridState ,
                                 boolean AV61DynamicFiltersIgnoreFirst ,
                                 boolean AV60DynamicFiltersRemoving ,
                                 boolean AV40IsAuthorized_Delete ,
                                 boolean AV37IsAuthorized_Update ,
                                 boolean AV35IsAuthorized_UAAssociateFunctionalities )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e271H2 ();
      GRID_nCurrentRecord = 0 ;
      rf1H2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A65SecRoleId), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECROLEID", GXutil.ltrim( localUtil.ntoc( A65SecRoleId, (byte)(4), (byte)(0), ".", "")));
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
      if ( cmbavDynamicfiltersselector1.getItemCount() > 0 )
      {
         AV46DynamicFiltersSelector1 = cmbavDynamicfiltersselector1.getValidValue(AV46DynamicFiltersSelector1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersSelector1", AV46DynamicFiltersSelector1);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV46DynamicFiltersSelector1) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersoperator1.getItemCount() > 0 )
      {
         AV47DynamicFiltersOperator1 = (short)(GXutil.lval( cmbavDynamicfiltersoperator1.getValidValue(GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47DynamicFiltersOperator1), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersselector2.getItemCount() > 0 )
      {
         AV51DynamicFiltersSelector2 = cmbavDynamicfiltersselector2.getValidValue(AV51DynamicFiltersSelector2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersSelector2", AV51DynamicFiltersSelector2);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV51DynamicFiltersSelector2) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersoperator2.getItemCount() > 0 )
      {
         AV52DynamicFiltersOperator2 = (short)(GXutil.lval( cmbavDynamicfiltersoperator2.getValidValue(GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52DynamicFiltersOperator2), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersselector3.getItemCount() > 0 )
      {
         AV56DynamicFiltersSelector3 = cmbavDynamicfiltersselector3.getValidValue(AV56DynamicFiltersSelector3) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56DynamicFiltersSelector3", AV56DynamicFiltersSelector3);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV56DynamicFiltersSelector3) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersoperator3.getItemCount() > 0 )
      {
         AV57DynamicFiltersOperator3 = (short)(GXutil.lval( cmbavDynamicfiltersoperator3.getValidValue(GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57DynamicFiltersOperator3), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1H2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV100Pgmname = "WWPBaseObjects.SecRoleWW" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_103_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_103_Refreshing);
   }

   public void rf1H2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(103) ;
      /* Execute user event: Refresh */
      e271H2 ();
      nGXsfl_103_idx = 1 ;
      sGXsfl_103_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_103_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1032( ) ;
      bGXsfl_103_Refreshing = true ;
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
         subsflControlProps_1032( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A355SecRoleName ,
                                              AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                              A354SecRoleDescription ,
                                              AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                              AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                              Short.valueOf(AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1) ,
                                              AV103Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                              Boolean.valueOf(AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2) ,
                                              AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                              Short.valueOf(AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2) ,
                                              AV107Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                              Boolean.valueOf(AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3) ,
                                              AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                              Short.valueOf(AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3) ,
                                              AV111Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                              Integer.valueOf(AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels.size()) ,
                                              AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                              Integer.valueOf(AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels.size()) ,
                                              AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription ,
                                              Short.valueOf(AV44OrderedBy) ,
                                              Boolean.valueOf(AV45OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV103Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV103Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
         lV103Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV103Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
         lV107Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV107Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
         lV107Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV107Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
         lV111Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV111Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
         lV111Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV111Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
         lV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = GXutil.concat( GXutil.rtrim( AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename), "%", "") ;
         lV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription), "%", "") ;
         /* Using cursor H001H2 */
         pr_default.execute(0, new Object[] {lV103Wwpbaseobjects_secrolewwds_3_secrolename1, lV103Wwpbaseobjects_secrolewwds_3_secrolename1, lV107Wwpbaseobjects_secrolewwds_7_secrolename2, lV107Wwpbaseobjects_secrolewwds_7_secrolename2, lV111Wwpbaseobjects_secrolewwds_11_secrolename3, lV111Wwpbaseobjects_secrolewwds_11_secrolename3, lV112Wwpbaseobjects_secrolewwds_12_tfsecrolename, lV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_103_idx = 1 ;
         sGXsfl_103_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_103_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1032( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A354SecRoleDescription = H001H2_A354SecRoleDescription[0] ;
            A355SecRoleName = H001H2_A355SecRoleName[0] ;
            A65SecRoleId = H001H2_A65SecRoleId[0] ;
            e281H2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(103) ;
         wb1H0( ) ;
      }
      bGXsfl_103_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1H2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV100Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV40IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV40IsAuthorized_Delete));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV37IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV37IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES", AV35IsAuthorized_UAAssociateFunctionalities);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES", getSecureSignedToken( "", AV35IsAuthorized_UAAssociateFunctionalities));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECROLEID"+"_"+sGXsfl_103_idx, getSecureSignedToken( sGXsfl_103_idx, localUtil.format( DecimalUtil.doubleToDec(A65SecRoleId), "ZZZ9")));
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
      AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV46DynamicFiltersSelector1 ;
      AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV47DynamicFiltersOperator1 ;
      AV103Wwpbaseobjects_secrolewwds_3_secrolename1 = AV48SecRoleName1 ;
      AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV50DynamicFiltersEnabled2 ;
      AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV51DynamicFiltersSelector2 ;
      AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV52DynamicFiltersOperator2 ;
      AV107Wwpbaseobjects_secrolewwds_7_secrolename2 = AV53SecRoleName2 ;
      AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV55DynamicFiltersEnabled3 ;
      AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV56DynamicFiltersSelector3 ;
      AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV57DynamicFiltersOperator3 ;
      AV111Wwpbaseobjects_secrolewwds_11_secrolename3 = AV58SecRoleName3 ;
      AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV71TFSecRoleName ;
      AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV92TFSecRoleName_Sels ;
      AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV75TFSecRoleDescription ;
      AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV94TFSecRoleDescription_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A355SecRoleName ,
                                           AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                           A354SecRoleDescription ,
                                           AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                           AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                           Short.valueOf(AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1) ,
                                           AV103Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                           Boolean.valueOf(AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2) ,
                                           AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                           Short.valueOf(AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2) ,
                                           AV107Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                           Boolean.valueOf(AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3) ,
                                           AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                           Short.valueOf(AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3) ,
                                           AV111Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                           Integer.valueOf(AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels.size()) ,
                                           AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                           Integer.valueOf(AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels.size()) ,
                                           AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription ,
                                           Short.valueOf(AV44OrderedBy) ,
                                           Boolean.valueOf(AV45OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV103Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV103Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV103Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV103Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV107Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV107Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV107Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV107Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV111Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV111Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV111Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV111Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = GXutil.concat( GXutil.rtrim( AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename), "%", "") ;
      lV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription), "%", "") ;
      /* Using cursor H001H3 */
      pr_default.execute(1, new Object[] {lV103Wwpbaseobjects_secrolewwds_3_secrolename1, lV103Wwpbaseobjects_secrolewwds_3_secrolename1, lV107Wwpbaseobjects_secrolewwds_7_secrolename2, lV107Wwpbaseobjects_secrolewwds_7_secrolename2, lV111Wwpbaseobjects_secrolewwds_11_secrolename3, lV111Wwpbaseobjects_secrolewwds_11_secrolename3, lV112Wwpbaseobjects_secrolewwds_12_tfsecrolename, lV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription});
      GRID_nRecordCount = H001H3_AGRID_nRecordCount[0] ;
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
      AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV46DynamicFiltersSelector1 ;
      AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV47DynamicFiltersOperator1 ;
      AV103Wwpbaseobjects_secrolewwds_3_secrolename1 = AV48SecRoleName1 ;
      AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV50DynamicFiltersEnabled2 ;
      AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV51DynamicFiltersSelector2 ;
      AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV52DynamicFiltersOperator2 ;
      AV107Wwpbaseobjects_secrolewwds_7_secrolename2 = AV53SecRoleName2 ;
      AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV55DynamicFiltersEnabled3 ;
      AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV56DynamicFiltersSelector3 ;
      AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV57DynamicFiltersOperator3 ;
      AV111Wwpbaseobjects_secrolewwds_11_secrolename3 = AV58SecRoleName3 ;
      AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV71TFSecRoleName ;
      AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV92TFSecRoleName_Sels ;
      AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV75TFSecRoleDescription ;
      AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV94TFSecRoleDescription_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV46DynamicFiltersSelector1 ;
      AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV47DynamicFiltersOperator1 ;
      AV103Wwpbaseobjects_secrolewwds_3_secrolename1 = AV48SecRoleName1 ;
      AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV50DynamicFiltersEnabled2 ;
      AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV51DynamicFiltersSelector2 ;
      AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV52DynamicFiltersOperator2 ;
      AV107Wwpbaseobjects_secrolewwds_7_secrolename2 = AV53SecRoleName2 ;
      AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV55DynamicFiltersEnabled3 ;
      AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV56DynamicFiltersSelector3 ;
      AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV57DynamicFiltersOperator3 ;
      AV111Wwpbaseobjects_secrolewwds_11_secrolename3 = AV58SecRoleName3 ;
      AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV71TFSecRoleName ;
      AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV92TFSecRoleName_Sels ;
      AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV75TFSecRoleDescription ;
      AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV94TFSecRoleDescription_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV46DynamicFiltersSelector1 ;
      AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV47DynamicFiltersOperator1 ;
      AV103Wwpbaseobjects_secrolewwds_3_secrolename1 = AV48SecRoleName1 ;
      AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV50DynamicFiltersEnabled2 ;
      AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV51DynamicFiltersSelector2 ;
      AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV52DynamicFiltersOperator2 ;
      AV107Wwpbaseobjects_secrolewwds_7_secrolename2 = AV53SecRoleName2 ;
      AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV55DynamicFiltersEnabled3 ;
      AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV56DynamicFiltersSelector3 ;
      AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV57DynamicFiltersOperator3 ;
      AV111Wwpbaseobjects_secrolewwds_11_secrolename3 = AV58SecRoleName3 ;
      AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV71TFSecRoleName ;
      AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV92TFSecRoleName_Sels ;
      AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV75TFSecRoleDescription ;
      AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV94TFSecRoleDescription_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV46DynamicFiltersSelector1 ;
      AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV47DynamicFiltersOperator1 ;
      AV103Wwpbaseobjects_secrolewwds_3_secrolename1 = AV48SecRoleName1 ;
      AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV50DynamicFiltersEnabled2 ;
      AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV51DynamicFiltersSelector2 ;
      AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV52DynamicFiltersOperator2 ;
      AV107Wwpbaseobjects_secrolewwds_7_secrolename2 = AV53SecRoleName2 ;
      AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV55DynamicFiltersEnabled3 ;
      AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV56DynamicFiltersSelector3 ;
      AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV57DynamicFiltersOperator3 ;
      AV111Wwpbaseobjects_secrolewwds_11_secrolename3 = AV58SecRoleName3 ;
      AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV71TFSecRoleName ;
      AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV92TFSecRoleName_Sels ;
      AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV75TFSecRoleDescription ;
      AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV94TFSecRoleDescription_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV46DynamicFiltersSelector1 ;
      AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV47DynamicFiltersOperator1 ;
      AV103Wwpbaseobjects_secrolewwds_3_secrolename1 = AV48SecRoleName1 ;
      AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV50DynamicFiltersEnabled2 ;
      AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV51DynamicFiltersSelector2 ;
      AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV52DynamicFiltersOperator2 ;
      AV107Wwpbaseobjects_secrolewwds_7_secrolename2 = AV53SecRoleName2 ;
      AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV55DynamicFiltersEnabled3 ;
      AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV56DynamicFiltersSelector3 ;
      AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV57DynamicFiltersOperator3 ;
      AV111Wwpbaseobjects_secrolewwds_11_secrolename3 = AV58SecRoleName3 ;
      AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV71TFSecRoleName ;
      AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV92TFSecRoleName_Sels ;
      AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV75TFSecRoleDescription ;
      AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV94TFSecRoleDescription_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV100Pgmname = "WWPBaseObjects.SecRoleWW" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_103_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_103_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1H0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e261H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV68ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV78DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_103 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_103"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV89GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV90GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV95GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_managefilters_Icontype = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( "DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( "DDO_MANAGEFILTERS_Cls") ;
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
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Innewwindow1_Width = httpContext.cgiGet( "INNEWWINDOW1_Width") ;
         Innewwindow1_Height = httpContext.cgiGet( "INNEWWINDOW1_Height") ;
         Innewwindow1_Target = httpContext.cgiGet( "INNEWWINDOW1_Target") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         cmbavDynamicfiltersselector1.setName( cmbavDynamicfiltersselector1.getInternalname() );
         cmbavDynamicfiltersselector1.setValue( httpContext.cgiGet( cmbavDynamicfiltersselector1.getInternalname()) );
         AV46DynamicFiltersSelector1 = httpContext.cgiGet( cmbavDynamicfiltersselector1.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersSelector1", AV46DynamicFiltersSelector1);
         cmbavDynamicfiltersoperator1.setName( cmbavDynamicfiltersoperator1.getInternalname() );
         cmbavDynamicfiltersoperator1.setValue( httpContext.cgiGet( cmbavDynamicfiltersoperator1.getInternalname()) );
         AV47DynamicFiltersOperator1 = (short)(GXutil.lval( httpContext.cgiGet( cmbavDynamicfiltersoperator1.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47DynamicFiltersOperator1), 4, 0));
         AV48SecRoleName1 = httpContext.cgiGet( edtavSecrolename1_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48SecRoleName1", AV48SecRoleName1);
         cmbavDynamicfiltersselector2.setName( cmbavDynamicfiltersselector2.getInternalname() );
         cmbavDynamicfiltersselector2.setValue( httpContext.cgiGet( cmbavDynamicfiltersselector2.getInternalname()) );
         AV51DynamicFiltersSelector2 = httpContext.cgiGet( cmbavDynamicfiltersselector2.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersSelector2", AV51DynamicFiltersSelector2);
         cmbavDynamicfiltersoperator2.setName( cmbavDynamicfiltersoperator2.getInternalname() );
         cmbavDynamicfiltersoperator2.setValue( httpContext.cgiGet( cmbavDynamicfiltersoperator2.getInternalname()) );
         AV52DynamicFiltersOperator2 = (short)(GXutil.lval( httpContext.cgiGet( cmbavDynamicfiltersoperator2.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52DynamicFiltersOperator2), 4, 0));
         AV53SecRoleName2 = httpContext.cgiGet( edtavSecrolename2_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53SecRoleName2", AV53SecRoleName2);
         cmbavDynamicfiltersselector3.setName( cmbavDynamicfiltersselector3.getInternalname() );
         cmbavDynamicfiltersselector3.setValue( httpContext.cgiGet( cmbavDynamicfiltersselector3.getInternalname()) );
         AV56DynamicFiltersSelector3 = httpContext.cgiGet( cmbavDynamicfiltersselector3.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56DynamicFiltersSelector3", AV56DynamicFiltersSelector3);
         cmbavDynamicfiltersoperator3.setName( cmbavDynamicfiltersoperator3.getInternalname() );
         cmbavDynamicfiltersoperator3.setValue( httpContext.cgiGet( cmbavDynamicfiltersoperator3.getInternalname()) );
         AV57DynamicFiltersOperator3 = (short)(GXutil.lval( httpContext.cgiGet( cmbavDynamicfiltersoperator3.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57DynamicFiltersOperator3), 4, 0));
         AV58SecRoleName3 = httpContext.cgiGet( edtavSecrolename3_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58SecRoleName3", AV58SecRoleName3);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR1"), AV46DynamicFiltersSelector1) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV47DynamicFiltersOperator1 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECROLENAME1"), AV48SecRoleName1) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR2"), AV51DynamicFiltersSelector2) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV52DynamicFiltersOperator2 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECROLENAME2"), AV53SecRoleName2) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR3"), AV56DynamicFiltersSelector3) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR3"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV57DynamicFiltersOperator3 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECROLENAME3"), AV58SecRoleName3) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e261H2 ();
      if (returnInSub) return;
   }

   public void e261H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV96CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      secroleww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV96CliCod = GXt_int1 ;
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      if ( GXutil.strcmp(AV8HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      lblJsdynamicfilters_Caption = "" ;
      httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
      AV46DynamicFiltersSelector1 = "SECROLENAME" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersSelector1", AV46DynamicFiltersSelector1);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS1' */
      S122 ();
      if (returnInSub) return;
      AV51DynamicFiltersSelector2 = "SECROLENAME" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersSelector2", AV51DynamicFiltersSelector2);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS2' */
      S132 ();
      if (returnInSub) return;
      AV56DynamicFiltersSelector3 = "SECROLENAME" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56DynamicFiltersSelector3", AV56DynamicFiltersSelector3);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS3' */
      S142 ();
      if (returnInSub) return;
      imgAdddynamicfilters1_Jsonclick = GXutil.format( "WWPDynFilterShow_AL('%1', 2, 0)", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters1_Internalname, "Jsonclick", imgAdddynamicfilters1_Jsonclick, true);
      imgRemovedynamicfilters1_Jsonclick = GXutil.format( "WWPDynFilterHideLast_AL('%1', 3, 0)", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters1_Internalname, "Jsonclick", imgRemovedynamicfilters1_Jsonclick, true);
      imgAdddynamicfilters2_Jsonclick = GXutil.format( "WWPDynFilterShow_AL('%1', 3, 0)", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters2_Internalname, "Jsonclick", imgAdddynamicfilters2_Jsonclick, true);
      imgRemovedynamicfilters2_Jsonclick = GXutil.format( "WWPDynFilterHideLast_AL('%1', 3, 0)", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters2_Internalname, "Jsonclick", imgRemovedynamicfilters2_Jsonclick, true);
      imgRemovedynamicfilters3_Jsonclick = GXutil.format( "WWPDynFilterHideLast_AL('%1', 3, 0)", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters3_Internalname, "Jsonclick", imgRemovedynamicfilters3_Jsonclick, true);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Role", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( AV44OrderedBy < 1 )
      {
         AV44OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S172 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV78DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV78DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      edtavUaassociatefunctionalities_Title = httpContext.getMessage( "Permissions", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUaassociatefunctionalities_Internalname, "Title", edtavUaassociatefunctionalities_Title, !bGXsfl_103_Refreshing);
   }

   public void e271H2( )
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
      secroleww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV96CliCod = GXt_int1 ;
      GXv_SdtWWPContext5[0] = AV87WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV87WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S182 ();
      if (returnInSub) return;
      if ( AV64ManageFiltersExecutionStep == 1 )
      {
         AV64ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64ManageFiltersExecutionStep", GXutil.str( AV64ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV64ManageFiltersExecutionStep == 2 )
      {
         AV64ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64ManageFiltersExecutionStep", GXutil.str( AV64ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S192 ();
      if (returnInSub) return;
      AV89GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV89GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV89GridCurrentPage), 10, 0));
      AV90GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV90GridPageCount), 10, 0));
      GXt_char6 = AV95GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV100Pgmname, GXv_char7) ;
      secroleww_impl.this.GXt_char6 = GXv_char7[0] ;
      AV95GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95GridAppliedFilters", AV95GridAppliedFilters);
      AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV46DynamicFiltersSelector1 ;
      AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV47DynamicFiltersOperator1 ;
      AV103Wwpbaseobjects_secrolewwds_3_secrolename1 = AV48SecRoleName1 ;
      AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV50DynamicFiltersEnabled2 ;
      AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV51DynamicFiltersSelector2 ;
      AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV52DynamicFiltersOperator2 ;
      AV107Wwpbaseobjects_secrolewwds_7_secrolename2 = AV53SecRoleName2 ;
      AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV55DynamicFiltersEnabled3 ;
      AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV56DynamicFiltersSelector3 ;
      AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV57DynamicFiltersOperator3 ;
      AV111Wwpbaseobjects_secrolewwds_11_secrolename3 = AV58SecRoleName3 ;
      AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV71TFSecRoleName ;
      AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV92TFSecRoleName_Sels ;
      AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV75TFSecRoleDescription ;
      AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV94TFSecRoleDescription_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV68ManageFiltersData", AV68ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41GridState", AV41GridState);
   }

   public void e121H2( )
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
         AV88PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV88PageToGo) ;
      }
   }

   public void e131H2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e141H2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV44OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44OrderedBy), 4, 0));
         AV45OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45OrderedDsc", AV45OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S172 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecRoleName") == 0 )
         {
            AV71TFSecRoleName = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFSecRoleName", AV71TFSecRoleName);
            AV91TFSecRoleName_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFSecRoleName_SelsJson", AV91TFSecRoleName_SelsJson);
            AV92TFSecRoleName_Sels.fromJSonString(AV91TFSecRoleName_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecRoleDescription") == 0 )
         {
            AV75TFSecRoleDescription = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFSecRoleDescription", AV75TFSecRoleDescription);
            AV93TFSecRoleDescription_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93TFSecRoleDescription_SelsJson", AV93TFSecRoleDescription_SelsJson);
            AV94TFSecRoleDescription_Sels.fromJSonString(AV93TFSecRoleDescription_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV92TFSecRoleName_Sels", AV92TFSecRoleName_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV94TFSecRoleDescription_Sels", AV94TFSecRoleDescription_Sels);
   }

   private void e281H2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV14Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV14Delete);
      if ( AV40IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.wwpbaseobjects.secrole", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A65SecRoleId,4,0))}, new String[] {"Mode","SecRoleId"})  ;
      }
      AV13Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV13Update);
      if ( AV37IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.wwpbaseobjects.secrole", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A65SecRoleId,4,0))}, new String[] {"Mode","SecRoleId"})  ;
      }
      edtavUaassociatefunctionalities_gximage = "Permission" ;
      AV34UAAssociateFunctionalities = context.getHttpContext().getImagePath( "262dee5c-db77-4c22-a7be-798351973470", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUaassociatefunctionalities_Internalname, AV34UAAssociateFunctionalities);
      AV116Uaassociatefunctionalities_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "262dee5c-db77-4c22-a7be-798351973470", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavUaassociatefunctionalities_Tooltiptext = "" ;
      if ( AV35IsAuthorized_UAAssociateFunctionalities )
      {
         edtavUaassociatefunctionalities_Link = formatLink("web.wwpbaseobjects.secrolefunroleassociationww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A65SecRoleId,4,0))}, new String[] {"SecRoleId"})  ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(103) ;
      }
      sendrow_1032( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_103_Refreshing )
      {
         httpContext.doAjaxLoad(103, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e211H2( )
   {
      /* 'AddDynamicFilters1' Routine */
      returnInSub = false ;
      AV50DynamicFiltersEnabled2 = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50DynamicFiltersEnabled2", AV50DynamicFiltersEnabled2);
      imgAdddynamicfilters1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters1_Visible), 5, 0), true);
      imgRemovedynamicfilters1_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters1_Visible), 5, 0), true);
      /*  Sending Event outputs  */
   }

   public void e151H2( )
   {
      /* 'RemoveDynamicFilters1' Routine */
      returnInSub = false ;
      AV60DynamicFiltersRemoving = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60DynamicFiltersRemoving", AV60DynamicFiltersRemoving);
      AV61DynamicFiltersIgnoreFirst = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61DynamicFiltersIgnoreFirst", AV61DynamicFiltersIgnoreFirst);
      /* Execute user subroutine: 'SAVEDYNFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETDYNFILTERS' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S222 ();
      if (returnInSub) return;
      AV60DynamicFiltersRemoving = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60DynamicFiltersRemoving", AV60DynamicFiltersRemoving);
      AV61DynamicFiltersIgnoreFirst = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61DynamicFiltersIgnoreFirst", AV61DynamicFiltersIgnoreFirst);
      gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41GridState", AV41GridState);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV51DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV56DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV46DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV68ManageFiltersData", AV68ManageFiltersData);
   }

   public void e221H2( )
   {
      /* Dynamicfiltersselector1_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS1' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e231H2( )
   {
      /* 'AddDynamicFilters2' Routine */
      returnInSub = false ;
      AV55DynamicFiltersEnabled3 = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55DynamicFiltersEnabled3", AV55DynamicFiltersEnabled3);
      imgAdddynamicfilters2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters2_Visible), 5, 0), true);
      imgRemovedynamicfilters2_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters2_Visible), 5, 0), true);
      /*  Sending Event outputs  */
   }

   public void e161H2( )
   {
      /* 'RemoveDynamicFilters2' Routine */
      returnInSub = false ;
      AV60DynamicFiltersRemoving = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60DynamicFiltersRemoving", AV60DynamicFiltersRemoving);
      AV50DynamicFiltersEnabled2 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50DynamicFiltersEnabled2", AV50DynamicFiltersEnabled2);
      /* Execute user subroutine: 'SAVEDYNFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETDYNFILTERS' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S222 ();
      if (returnInSub) return;
      AV60DynamicFiltersRemoving = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60DynamicFiltersRemoving", AV60DynamicFiltersRemoving);
      gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41GridState", AV41GridState);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV51DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV56DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV46DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV68ManageFiltersData", AV68ManageFiltersData);
   }

   public void e241H2( )
   {
      /* Dynamicfiltersselector2_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS2' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e171H2( )
   {
      /* 'RemoveDynamicFilters3' Routine */
      returnInSub = false ;
      AV60DynamicFiltersRemoving = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60DynamicFiltersRemoving", AV60DynamicFiltersRemoving);
      AV55DynamicFiltersEnabled3 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55DynamicFiltersEnabled3", AV55DynamicFiltersEnabled3);
      /* Execute user subroutine: 'SAVEDYNFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETDYNFILTERS' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S222 ();
      if (returnInSub) return;
      AV60DynamicFiltersRemoving = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60DynamicFiltersRemoving", AV60DynamicFiltersRemoving);
      gxgrgrid_refresh( subGrid_Rows, AV46DynamicFiltersSelector1, AV47DynamicFiltersOperator1, AV48SecRoleName1, AV51DynamicFiltersSelector2, AV52DynamicFiltersOperator2, AV53SecRoleName2, AV56DynamicFiltersSelector3, AV57DynamicFiltersOperator3, AV58SecRoleName3, AV64ManageFiltersExecutionStep, AV100Pgmname, AV50DynamicFiltersEnabled2, AV55DynamicFiltersEnabled3, AV71TFSecRoleName, AV92TFSecRoleName_Sels, AV75TFSecRoleDescription, AV94TFSecRoleDescription_Sels, AV44OrderedBy, AV45OrderedDsc, AV41GridState, AV61DynamicFiltersIgnoreFirst, AV60DynamicFiltersRemoving, AV40IsAuthorized_Delete, AV37IsAuthorized_Update, AV35IsAuthorized_UAAssociateFunctionalities) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41GridState", AV41GridState);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV51DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV56DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV46DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV68ManageFiltersData", AV68ManageFiltersData);
   }

   public void e251H2( )
   {
      /* Dynamicfiltersselector3_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS3' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e111H2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S232 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S192 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("WWPBaseObjects.SecRoleWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV100Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV64ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64ManageFiltersExecutionStep", GXutil.str( AV64ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("WWPBaseObjects.SecRoleWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV64ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64ManageFiltersExecutionStep", GXutil.str( AV64ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char6 = AV65ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "WWPBaseObjects.SecRoleWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         secroleww_impl.this.GXt_char6 = GXv_char7[0] ;
         AV65ManageFiltersXml = GXt_char6 ;
         if ( (GXutil.strcmp("", AV65ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S232 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV100Pgmname+"GridState", AV65ManageFiltersXml) ;
            AV41GridState.fromxml(AV65ManageFiltersXml, null, null);
            AV44OrderedBy = AV41GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44OrderedBy), 4, 0));
            AV45OrderedDsc = AV41GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45OrderedDsc", AV45OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S172 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S242 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
            S222 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41GridState", AV41GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV92TFSecRoleName_Sels", AV92TFSecRoleName_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV94TFSecRoleDescription_Sels", AV94TFSecRoleDescription_Sels);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV46DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV51DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV56DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV68ManageFiltersData", AV68ManageFiltersData);
   }

   public void e181H2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.wwpbaseobjects.secrole", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","SecRoleId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e191H2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      GXv_char7[0] = AV62ExcelFilename ;
      GXv_char8[0] = AV63ErrorMessage ;
      new web.wwpbaseobjects.secrolewwexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      secroleww_impl.this.AV62ExcelFilename = GXv_char7[0] ;
      secroleww_impl.this.AV63ErrorMessage = GXv_char8[0] ;
      if ( GXutil.strcmp(AV62ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV62ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV63ErrorMessage);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41GridState", AV41GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV92TFSecRoleName_Sels", AV92TFSecRoleName_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV94TFSecRoleDescription_Sels", AV94TFSecRoleDescription_Sels);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV46DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV51DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV56DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
   }

   public void e201H2( )
   {
      /* 'DoExportReport' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("web.wwpbaseobjects.asecrolewwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41GridState", AV41GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV92TFSecRoleName_Sels", AV92TFSecRoleName_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV94TFSecRoleDescription_Sels", AV94TFSecRoleDescription_Sels);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV46DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV51DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV56DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
   }

   public void S172( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV44OrderedBy, 4, 0))+":"+(AV45OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S182( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean9 = AV40IsAuthorized_Delete ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "RoleModes", GXv_boolean10) ;
      secroleww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV40IsAuthorized_Delete = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40IsAuthorized_Delete", AV40IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV40IsAuthorized_Delete));
      if ( ! ( AV40IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_103_Refreshing);
      }
      GXt_boolean9 = AV37IsAuthorized_Update ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "RoleModes", GXv_boolean10) ;
      secroleww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV37IsAuthorized_Update = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37IsAuthorized_Update", AV37IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV37IsAuthorized_Update));
      if ( ! ( AV37IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_103_Refreshing);
      }
      GXt_boolean9 = AV35IsAuthorized_UAAssociateFunctionalities ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "RoleAssignFunctionalities", GXv_boolean10) ;
      secroleww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV35IsAuthorized_UAAssociateFunctionalities = GXt_boolean9 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35IsAuthorized_UAAssociateFunctionalities", AV35IsAuthorized_UAAssociateFunctionalities);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES", getSecureSignedToken( "", AV35IsAuthorized_UAAssociateFunctionalities));
      if ( ! ( AV35IsAuthorized_UAAssociateFunctionalities ) )
      {
         edtavUaassociatefunctionalities_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUaassociatefunctionalities_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUaassociatefunctionalities_Visible), 5, 0), !bGXsfl_103_Refreshing);
      }
      GXt_boolean9 = AV36TempBoolean ;
      GXv_boolean10[0] = GXt_boolean9 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "RoleModes", GXv_boolean10) ;
      secroleww_impl.this.GXt_boolean9 = GXv_boolean10[0] ;
      AV36TempBoolean = GXt_boolean9 ;
      if ( ! ( AV36TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'ENABLEDYNAMICFILTERS1' Routine */
      returnInSub = false ;
      edtavSecrolename1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecrolename1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecrolename1_Visible), 5, 0), true);
      cmbavDynamicfiltersoperator1.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator1.getVisible(), 5, 0), true);
      if ( GXutil.strcmp(AV46DynamicFiltersSelector1, "SECROLENAME") == 0 )
      {
         edtavSecrolename1_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecrolename1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecrolename1_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator1.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator1.getVisible(), 5, 0), true);
      }
   }

   public void S132( )
   {
      /* 'ENABLEDYNAMICFILTERS2' Routine */
      returnInSub = false ;
      edtavSecrolename2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecrolename2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecrolename2_Visible), 5, 0), true);
      cmbavDynamicfiltersoperator2.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator2.getVisible(), 5, 0), true);
      if ( GXutil.strcmp(AV51DynamicFiltersSelector2, "SECROLENAME") == 0 )
      {
         edtavSecrolename2_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecrolename2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecrolename2_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator2.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator2.getVisible(), 5, 0), true);
      }
   }

   public void S142( )
   {
      /* 'ENABLEDYNAMICFILTERS3' Routine */
      returnInSub = false ;
      edtavSecrolename3_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecrolename3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecrolename3_Visible), 5, 0), true);
      cmbavDynamicfiltersoperator3.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator3.getVisible(), 5, 0), true);
      if ( GXutil.strcmp(AV56DynamicFiltersSelector3, "SECROLENAME") == 0 )
      {
         edtavSecrolename3_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecrolename3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecrolename3_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator3.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator3.getVisible(), 5, 0), true);
      }
   }

   public void S212( )
   {
      /* 'RESETDYNFILTERS' Routine */
      returnInSub = false ;
      AV50DynamicFiltersEnabled2 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50DynamicFiltersEnabled2", AV50DynamicFiltersEnabled2);
      AV51DynamicFiltersSelector2 = "SECROLENAME" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersSelector2", AV51DynamicFiltersSelector2);
      AV52DynamicFiltersOperator2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52DynamicFiltersOperator2), 4, 0));
      AV53SecRoleName2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53SecRoleName2", AV53SecRoleName2);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS2' */
      S132 ();
      if (returnInSub) return;
      AV55DynamicFiltersEnabled3 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55DynamicFiltersEnabled3", AV55DynamicFiltersEnabled3);
      AV56DynamicFiltersSelector3 = "SECROLENAME" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56DynamicFiltersSelector3", AV56DynamicFiltersSelector3);
      AV57DynamicFiltersOperator3 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57DynamicFiltersOperator3), 4, 0));
      AV58SecRoleName3 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58SecRoleName3", AV58SecRoleName3);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS3' */
      S142 ();
      if (returnInSub) return;
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = AV68ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "WWPBaseObjects.SecRoleWWFilters", "WWPDynFilterHideAll_AL('%1', 3, 0)", divTabledynamicfilters_Internalname, false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[0] ;
      AV68ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   }

   public void S232( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV71TFSecRoleName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71TFSecRoleName", AV71TFSecRoleName);
      AV92TFSecRoleName_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV75TFSecRoleDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75TFSecRoleDescription", AV75TFSecRoleDescription);
      AV94TFSecRoleDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      AV46DynamicFiltersSelector1 = "SECROLENAME" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersSelector1", AV46DynamicFiltersSelector1);
      AV47DynamicFiltersOperator1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47DynamicFiltersOperator1), 4, 0));
      AV48SecRoleName1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48SecRoleName1", AV48SecRoleName1);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS1' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETDYNFILTERS' */
      S212 ();
      if (returnInSub) return;
      AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().clear();
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S222 ();
      if (returnInSub) return;
   }

   public void S162( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV15Session.getValue(AV100Pgmname+"GridState"), "") == 0 )
      {
         AV41GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV100Pgmname+"GridState"), null, null);
      }
      else
      {
         AV41GridState.fromxml(AV15Session.getValue(AV100Pgmname+"GridState"), null, null);
      }
      AV44OrderedBy = AV41GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44OrderedBy), 4, 0));
      AV45OrderedDsc = AV41GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45OrderedDsc", AV45OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S242 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S222 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV41GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV41GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV41GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S242( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV117GXV1 = 1 ;
      while ( AV117GXV1 <= AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV42GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV117GXV1));
         if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME") == 0 )
         {
            AV71TFSecRoleName = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFSecRoleName", AV71TFSecRoleName);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME_SEL") == 0 )
         {
            AV91TFSecRoleName_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91TFSecRoleName_SelsJson", AV91TFSecRoleName_SelsJson);
            AV92TFSecRoleName_Sels.fromJSonString(AV91TFSecRoleName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV75TFSecRoleDescription = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFSecRoleDescription", AV75TFSecRoleDescription);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV93TFSecRoleDescription_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93TFSecRoleDescription_SelsJson", AV93TFSecRoleDescription_SelsJson);
            AV94TFSecRoleDescription_Sels.fromJSonString(AV93TFSecRoleDescription_SelsJson, null);
         }
         AV117GXV1 = (int)(AV117GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV92TFSecRoleName_Sels.size()==0), AV91TFSecRoleName_SelsJson, GXv_char8) ;
      secroleww_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char13 = "" ;
      GXv_char7[0] = GXt_char13 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV94TFSecRoleDescription_Sels.size()==0), AV93TFSecRoleDescription_SelsJson, GXv_char7) ;
      secroleww_impl.this.GXt_char13 = GXv_char7[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char6+"|"+GXt_char13 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char13 = "" ;
      GXv_char8[0] = GXt_char13 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV71TFSecRoleName)==0), AV71TFSecRoleName, GXv_char8) ;
      secroleww_impl.this.GXt_char13 = GXv_char8[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV75TFSecRoleDescription)==0), AV75TFSecRoleDescription, GXv_char7) ;
      secroleww_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = GXt_char13+"|"+GXt_char6 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
   }

   public void S222( )
   {
      /* 'LOADDYNFILTERSSTATE' Routine */
      returnInSub = false ;
      imgAdddynamicfilters1_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters1_Visible), 5, 0), true);
      imgRemovedynamicfilters1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters1_Visible), 5, 0), true);
      imgAdddynamicfilters2_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters2_Visible), 5, 0), true);
      imgRemovedynamicfilters2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters2_Visible), 5, 0), true);
      if ( AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 1 )
      {
         AV43GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+1));
         AV46DynamicFiltersSelector1 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersSelector1", AV46DynamicFiltersSelector1);
         if ( GXutil.strcmp(AV46DynamicFiltersSelector1, "SECROLENAME") == 0 )
         {
            AV47DynamicFiltersOperator1 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47DynamicFiltersOperator1), 4, 0));
            AV48SecRoleName1 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48SecRoleName1", AV48SecRoleName1);
         }
         /* Execute user subroutine: 'ENABLEDYNAMICFILTERS1' */
         S122 ();
         if (returnInSub) return;
         if ( AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 2 )
         {
            lblJsdynamicfilters_Caption = "<script type=\"text/javascript\">$(document).ready(function() {" ;
            httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
            lblJsdynamicfilters_Caption = lblJsdynamicfilters_Caption+GXutil.format( "WWPDynFilterShow_AL('%1', 2, 0);", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
            httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
            imgAdddynamicfilters1_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters1_Visible), 5, 0), true);
            imgRemovedynamicfilters1_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters1_Visible), 5, 0), true);
            AV50DynamicFiltersEnabled2 = true ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50DynamicFiltersEnabled2", AV50DynamicFiltersEnabled2);
            AV43GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+2));
            AV51DynamicFiltersSelector2 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersSelector2", AV51DynamicFiltersSelector2);
            if ( GXutil.strcmp(AV51DynamicFiltersSelector2, "SECROLENAME") == 0 )
            {
               AV52DynamicFiltersOperator2 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV52DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52DynamicFiltersOperator2), 4, 0));
               AV53SecRoleName2 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV53SecRoleName2", AV53SecRoleName2);
            }
            /* Execute user subroutine: 'ENABLEDYNAMICFILTERS2' */
            S132 ();
            if (returnInSub) return;
            if ( AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 3 )
            {
               lblJsdynamicfilters_Caption = lblJsdynamicfilters_Caption+GXutil.format( "WWPDynFilterShow_AL('%1', 3, 0);", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
               httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
               imgAdddynamicfilters2_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters2_Visible), 5, 0), true);
               imgRemovedynamicfilters2_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters2_Visible), 5, 0), true);
               AV55DynamicFiltersEnabled3 = true ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55DynamicFiltersEnabled3", AV55DynamicFiltersEnabled3);
               AV43GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+3));
               AV56DynamicFiltersSelector3 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV56DynamicFiltersSelector3", AV56DynamicFiltersSelector3);
               if ( GXutil.strcmp(AV56DynamicFiltersSelector3, "SECROLENAME") == 0 )
               {
                  AV57DynamicFiltersOperator3 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV57DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57DynamicFiltersOperator3), 4, 0));
                  AV58SecRoleName3 = AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV58SecRoleName3", AV58SecRoleName3);
               }
               /* Execute user subroutine: 'ENABLEDYNAMICFILTERS3' */
               S142 ();
               if (returnInSub) return;
            }
            lblJsdynamicfilters_Caption = lblJsdynamicfilters_Caption+"});</script>" ;
            httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
         }
      }
      if ( AV60DynamicFiltersRemoving )
      {
         lblJsdynamicfilters_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
      }
   }

   public void S192( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV41GridState.fromxml(AV15Session.getValue(AV100Pgmname+"GridState"), null, null);
      AV41GridState.setgxTv_SdtWWPGridState_Orderedby( AV44OrderedBy );
      AV41GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV45OrderedDsc );
      AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState14[0] = AV41GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState14, "TFSECROLENAME", httpContext.getMessage( "Name", ""), !(GXutil.strcmp("", AV71TFSecRoleName)==0), (short)(0), AV71TFSecRoleName, "", !(AV92TFSecRoleName_Sels.size()==0), AV92TFSecRoleName_Sels.toJSonString(false), "") ;
      AV41GridState = GXv_SdtWWPGridState14[0] ;
      GXv_SdtWWPGridState14[0] = AV41GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState14, "TFSECROLEDESCRIPTION", httpContext.getMessage( "Description", ""), !(GXutil.strcmp("", AV75TFSecRoleDescription)==0), (short)(0), AV75TFSecRoleDescription, "", !(AV94TFSecRoleDescription_Sels.size()==0), AV94TFSecRoleDescription_Sels.toJSonString(false), "") ;
      AV41GridState = GXv_SdtWWPGridState14[0] ;
      /* Execute user subroutine: 'SAVEDYNFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      AV41GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV41GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV100Pgmname+"GridState", AV41GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S202( )
   {
      /* 'SAVEDYNFILTERSSTATE' Routine */
      returnInSub = false ;
      AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().clear();
      if ( ! AV61DynamicFiltersIgnoreFirst )
      {
         AV43GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
         AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Selected( AV46DynamicFiltersSelector1 );
         if ( ( GXutil.strcmp(AV46DynamicFiltersSelector1, "SECROLENAME") == 0 ) && ! (GXutil.strcmp("", AV48SecRoleName1)==0) )
         {
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Name", "") );
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV48SecRoleName1 );
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV47DynamicFiltersOperator1 );
         }
         if ( AV60DynamicFiltersRemoving || ! (GXutil.strcmp("", AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value())==0) )
         {
            AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().add(AV43GridStateDynamicFilter, 0);
         }
      }
      if ( AV50DynamicFiltersEnabled2 )
      {
         AV43GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
         AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Selected( AV51DynamicFiltersSelector2 );
         if ( ( GXutil.strcmp(AV51DynamicFiltersSelector2, "SECROLENAME") == 0 ) && ! (GXutil.strcmp("", AV53SecRoleName2)==0) )
         {
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Name", "") );
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV53SecRoleName2 );
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV52DynamicFiltersOperator2 );
         }
         if ( AV60DynamicFiltersRemoving || ! (GXutil.strcmp("", AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value())==0) )
         {
            AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().add(AV43GridStateDynamicFilter, 0);
         }
      }
      if ( AV55DynamicFiltersEnabled3 )
      {
         AV43GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
         AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Selected( AV56DynamicFiltersSelector3 );
         if ( ( GXutil.strcmp(AV56DynamicFiltersSelector3, "SECROLENAME") == 0 ) && ! (GXutil.strcmp("", AV58SecRoleName3)==0) )
         {
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Name", "") );
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV58SecRoleName3 );
            AV43GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV57DynamicFiltersOperator3 );
         }
         if ( AV60DynamicFiltersRemoving || ! (GXutil.strcmp("", AV43GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value())==0) )
         {
            AV41GridState.getgxTv_SdtWWPGridState_Dynamicfilters().add(AV43GridStateDynamicFilter, 0);
         }
      }
   }

   public void S152( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV100Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "WWPBaseObjects.SecRole" );
      AV15Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void wb_table1_22_1H2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablerightheader_Internalname, tblTablerightheader_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellAlignTopPaddingTop2'>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV68ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_27_1H2( true) ;
      }
      else
      {
         wb_table2_27_1H2( false) ;
      }
      return  ;
   }

   public void wb_table2_27_1H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_22_1H2e( true) ;
      }
      else
      {
         wb_table1_22_1H2e( false) ;
      }
   }

   public void wb_table2_27_1H2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableDynamicFilters'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabledynamicfilters_Internalname, 1, 0, "px", 0, "px", "TableDynamicFiltersFlex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DynRowVisible", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabledynamicfiltersrow1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersprefix1_Internalname, httpContext.getMessage( "WWP_DynFilterPrefix", ""), "", "", lblDynamicfiltersprefix1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescriptionPrefix", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersselector1.getInternalname(), httpContext.getMessage( "Dynamic Filters Selector1", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersselector1, cmbavDynamicfiltersselector1.getInternalname(), GXutil.rtrim( AV46DynamicFiltersSelector1), 1, cmbavDynamicfiltersselector1.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVDYNAMICFILTERSSELECTOR1.CLICK."+"'", "svchar", "", 1, cmbavDynamicfiltersselector1.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV46DynamicFiltersSelector1) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersmiddle1_Internalname, httpContext.getMessage( "WWP_DynFilterMiddle", ""), "", "", lblDynamicfiltersmiddle1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table3_41_1H2( true) ;
      }
      else
      {
         wb_table3_41_1H2( false) ;
      }
      return  ;
   }

   public void wb_table3_41_1H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabledynamicfiltersrow2_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersprefix2_Internalname, httpContext.getMessage( "WWP_DynFilterPrefix", ""), "", "", lblDynamicfiltersprefix2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescriptionPrefix", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersselector2.getInternalname(), httpContext.getMessage( "Dynamic Filters Selector2", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersselector2, cmbavDynamicfiltersselector2.getInternalname(), GXutil.rtrim( AV51DynamicFiltersSelector2), 1, cmbavDynamicfiltersselector2.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVDYNAMICFILTERSSELECTOR2.CLICK."+"'", "svchar", "", 1, cmbavDynamicfiltersselector2.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV51DynamicFiltersSelector2) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersmiddle2_Internalname, httpContext.getMessage( "WWP_DynFilterMiddle", ""), "", "", lblDynamicfiltersmiddle2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_63_1H2( true) ;
      }
      else
      {
         wb_table4_63_1H2( false) ;
      }
      return  ;
   }

   public void wb_table4_63_1H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabledynamicfiltersrow3_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersprefix3_Internalname, httpContext.getMessage( "WWP_DynFilterPrefix", ""), "", "", lblDynamicfiltersprefix3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescriptionPrefix", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersselector3.getInternalname(), httpContext.getMessage( "Dynamic Filters Selector3", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersselector3, cmbavDynamicfiltersselector3.getInternalname(), GXutil.rtrim( AV56DynamicFiltersSelector3), 1, cmbavDynamicfiltersselector3.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVDYNAMICFILTERSSELECTOR3.CLICK."+"'", "svchar", "", 1, cmbavDynamicfiltersselector3.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,81);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV56DynamicFiltersSelector3) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersmiddle3_Internalname, httpContext.getMessage( "WWP_DynFilterMiddle", ""), "", "", lblDynamicfiltersmiddle3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         wb_table5_85_1H2( true) ;
      }
      else
      {
         wb_table5_85_1H2( false) ;
      }
      return  ;
   }

   public void wb_table5_85_1H2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_27_1H2e( true) ;
      }
      else
      {
         wb_table2_27_1H2e( false) ;
      }
   }

   public void wb_table5_85_1H2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergeddynamicfilters3_Internalname, tblTablemergeddynamicfilters3_Internalname, "", "Table", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersoperator3.getInternalname(), httpContext.getMessage( "Dynamic Filters Operator3", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersoperator3, cmbavDynamicfiltersoperator3.getInternalname(), GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)), 1, cmbavDynamicfiltersoperator3.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavDynamicfiltersoperator3.getVisible(), cmbavDynamicfiltersoperator3.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secrolename3_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecrolename3_Internalname, httpContext.getMessage( "Sec Role Name3", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecrolename3_Internalname, AV58SecRoleName3, GXutil.rtrim( localUtil.format( AV58SecRoleName3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecrolename3_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecrolename3_Visible, edtavSecrolename3_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_removefilter3_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgRemovedynamicfilters3_gximage, "")==0) ? "GX_Image_ActionRemoveDynamicFilter_Class" : "GX_Image_"+imgRemovedynamicfilters3_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "11a6ef14-1a5a-4077-91a2-f41ed9a3a662", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgRemovedynamicfilters3_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", httpContext.getMessage( "WWP_DynFilterRemoveTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgRemovedynamicfilters3_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'REMOVEDYNAMICFILTERS3\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_85_1H2e( true) ;
      }
      else
      {
         wb_table5_85_1H2e( false) ;
      }
   }

   public void wb_table4_63_1H2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergeddynamicfilters2_Internalname, tblTablemergeddynamicfilters2_Internalname, "", "Table", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersoperator2.getInternalname(), httpContext.getMessage( "Dynamic Filters Operator2", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersoperator2, cmbavDynamicfiltersoperator2.getInternalname(), GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)), 1, cmbavDynamicfiltersoperator2.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavDynamicfiltersoperator2.getVisible(), cmbavDynamicfiltersoperator2.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secrolename2_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecrolename2_Internalname, httpContext.getMessage( "Sec Role Name2", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecrolename2_Internalname, AV53SecRoleName2, GXutil.rtrim( localUtil.format( AV53SecRoleName2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,70);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecrolename2_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecrolename2_Visible, edtavSecrolename2_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_addfilter2_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgAdddynamicfilters2_gximage, "")==0) ? "GX_Image_ActionNewDynamicFilter_Class" : "GX_Image_"+imgAdddynamicfilters2_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "27283ea5-332f-423b-b880-64b762622df3", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgAdddynamicfilters2_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgAdddynamicfilters2_Visible, 1, "", httpContext.getMessage( "WWP_DynFilterAddTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgAdddynamicfilters2_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'ADDDYNAMICFILTERS2\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_removefilter2_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgRemovedynamicfilters2_gximage, "")==0) ? "GX_Image_ActionRemoveDynamicFilter_Class" : "GX_Image_"+imgRemovedynamicfilters2_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "11a6ef14-1a5a-4077-91a2-f41ed9a3a662", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgRemovedynamicfilters2_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgRemovedynamicfilters2_Visible, 1, "", httpContext.getMessage( "WWP_DynFilterRemoveTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgRemovedynamicfilters2_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'REMOVEDYNAMICFILTERS2\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_63_1H2e( true) ;
      }
      else
      {
         wb_table4_63_1H2e( false) ;
      }
   }

   public void wb_table3_41_1H2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergeddynamicfilters1_Internalname, tblTablemergeddynamicfilters1_Internalname, "", "Table", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersoperator1.getInternalname(), httpContext.getMessage( "Dynamic Filters Operator1", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersoperator1, cmbavDynamicfiltersoperator1.getInternalname(), GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)), 1, cmbavDynamicfiltersoperator1.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavDynamicfiltersoperator1.getVisible(), cmbavDynamicfiltersoperator1.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secrolename1_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecrolename1_Internalname, httpContext.getMessage( "Sec Role Name1", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'" + sGXsfl_103_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecrolename1_Internalname, AV48SecRoleName1, GXutil.rtrim( localUtil.format( AV48SecRoleName1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecrolename1_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecrolename1_Visible, edtavSecrolename1_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_addfilter1_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgAdddynamicfilters1_gximage, "")==0) ? "GX_Image_ActionNewDynamicFilter_Class" : "GX_Image_"+imgAdddynamicfilters1_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "27283ea5-332f-423b-b880-64b762622df3", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgAdddynamicfilters1_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgAdddynamicfilters1_Visible, 1, "", httpContext.getMessage( "WWP_DynFilterAddTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgAdddynamicfilters1_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'ADDDYNAMICFILTERS1\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_removefilter1_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgRemovedynamicfilters1_gximage, "")==0) ? "GX_Image_ActionRemoveDynamicFilter_Class" : "GX_Image_"+imgRemovedynamicfilters1_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "11a6ef14-1a5a-4077-91a2-f41ed9a3a662", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgRemovedynamicfilters1_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgRemovedynamicfilters1_Visible, 1, "", httpContext.getMessage( "WWP_DynFilterRemoveTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgRemovedynamicfilters1_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'REMOVEDYNAMICFILTERS1\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_41_1H2e( true) ;
      }
      else
      {
         wb_table3_41_1H2e( false) ;
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
      pa1H2( ) ;
      ws1H2( ) ;
      we1H2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020413231", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secroleww.js", "?2024122020413232", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1032( )
   {
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_103_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_103_idx ;
      edtavUaassociatefunctionalities_Internalname = "vUAASSOCIATEFUNCTIONALITIES_"+sGXsfl_103_idx ;
      edtSecRoleId_Internalname = "SECROLEID_"+sGXsfl_103_idx ;
      edtSecRoleName_Internalname = "SECROLENAME_"+sGXsfl_103_idx ;
      edtSecRoleDescription_Internalname = "SECROLEDESCRIPTION_"+sGXsfl_103_idx ;
   }

   public void subsflControlProps_fel_1032( )
   {
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_103_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_103_fel_idx ;
      edtavUaassociatefunctionalities_Internalname = "vUAASSOCIATEFUNCTIONALITIES_"+sGXsfl_103_fel_idx ;
      edtSecRoleId_Internalname = "SECROLEID_"+sGXsfl_103_fel_idx ;
      edtSecRoleName_Internalname = "SECROLENAME_"+sGXsfl_103_fel_idx ;
      edtSecRoleDescription_Internalname = "SECROLEDESCRIPTION_"+sGXsfl_103_fel_idx ;
   }

   public void sendrow_1032( )
   {
      subsflControlProps_1032( ) ;
      wb1H0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_103_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_103_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_103_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV14Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(103),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV13Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(103),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtavUaassociatefunctionalities_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "ActionBaseColorAttribute" + " " + ((GXutil.strcmp(edtavUaassociatefunctionalities_gximage, "")==0) ? "" : "GX_Image_"+edtavUaassociatefunctionalities_gximage+"_Class") ;
         StyleString = "" ;
         AV34UAAssociateFunctionalities_IsBlob = (boolean)(((GXutil.strcmp("", AV34UAAssociateFunctionalities)==0)&&(GXutil.strcmp("", AV116Uaassociatefunctionalities_GXI)==0))||!(GXutil.strcmp("", AV34UAAssociateFunctionalities)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV34UAAssociateFunctionalities)==0) ? AV116Uaassociatefunctionalities_GXI : httpContext.getResourceRelative(AV34UAAssociateFunctionalities)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavUaassociatefunctionalities_Internalname,sImgUrl,edtavUaassociatefunctionalities_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavUaassociatefunctionalities_Visible),Integer.valueOf(1),"",edtavUaassociatefunctionalities_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWActionColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV34UAAssociateFunctionalities_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecRoleId_Internalname,GXutil.ltrim( localUtil.ntoc( A65SecRoleId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A65SecRoleId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecRoleId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(103),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecRoleName_Internalname,A355SecRoleName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecRoleName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(103),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecRoleDescription_Internalname,A354SecRoleDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecRoleDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(120),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(103),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes1H2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_103_idx = ((subGrid_Islastpage==1)&&(nGXsfl_103_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_103_idx+1) ;
         sGXsfl_103_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_103_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1032( ) ;
      }
      /* End function sendrow_1032 */
   }

   public void startgridcontrol103( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"103\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ActionBaseColorAttribute"+" "+((GXutil.strcmp(edtavUaassociatefunctionalities_gximage, "")==0) ? "" : "GX_Image_"+edtavUaassociatefunctionalities_gximage+"_Class")+"\" "+" style=\""+((edtavUaassociatefunctionalities_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( edtavUaassociatefunctionalities_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Name", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Description", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV14Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV13Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV34UAAssociateFunctionalities));
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( edtavUaassociatefunctionalities_Title));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUaassociatefunctionalities_Link));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavUaassociatefunctionalities_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUaassociatefunctionalities_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A65SecRoleId, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A355SecRoleName);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A354SecRoleDescription);
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
      bttBtninsert_Internalname = "BTNINSERT" ;
      imgBtnexport_Internalname = "BTNEXPORT" ;
      bttBtnexportreport_Internalname = "BTNEXPORTREPORT" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      lblDynamicfiltersprefix1_Internalname = "DYNAMICFILTERSPREFIX1" ;
      cmbavDynamicfiltersselector1.setInternalname( "vDYNAMICFILTERSSELECTOR1" );
      lblDynamicfiltersmiddle1_Internalname = "DYNAMICFILTERSMIDDLE1" ;
      cmbavDynamicfiltersoperator1.setInternalname( "vDYNAMICFILTERSOPERATOR1" );
      edtavSecrolename1_Internalname = "vSECROLENAME1" ;
      cellFilter_secrolename1_cell_Internalname = "FILTER_SECROLENAME1_CELL" ;
      imgAdddynamicfilters1_Internalname = "ADDDYNAMICFILTERS1" ;
      cellDynamicfilters_addfilter1_cell_Internalname = "DYNAMICFILTERS_ADDFILTER1_CELL" ;
      imgRemovedynamicfilters1_Internalname = "REMOVEDYNAMICFILTERS1" ;
      cellDynamicfilters_removefilter1_cell_Internalname = "DYNAMICFILTERS_REMOVEFILTER1_CELL" ;
      tblTablemergeddynamicfilters1_Internalname = "TABLEMERGEDDYNAMICFILTERS1" ;
      divTabledynamicfiltersrow1_Internalname = "TABLEDYNAMICFILTERSROW1" ;
      lblDynamicfiltersprefix2_Internalname = "DYNAMICFILTERSPREFIX2" ;
      cmbavDynamicfiltersselector2.setInternalname( "vDYNAMICFILTERSSELECTOR2" );
      lblDynamicfiltersmiddle2_Internalname = "DYNAMICFILTERSMIDDLE2" ;
      cmbavDynamicfiltersoperator2.setInternalname( "vDYNAMICFILTERSOPERATOR2" );
      edtavSecrolename2_Internalname = "vSECROLENAME2" ;
      cellFilter_secrolename2_cell_Internalname = "FILTER_SECROLENAME2_CELL" ;
      imgAdddynamicfilters2_Internalname = "ADDDYNAMICFILTERS2" ;
      cellDynamicfilters_addfilter2_cell_Internalname = "DYNAMICFILTERS_ADDFILTER2_CELL" ;
      imgRemovedynamicfilters2_Internalname = "REMOVEDYNAMICFILTERS2" ;
      cellDynamicfilters_removefilter2_cell_Internalname = "DYNAMICFILTERS_REMOVEFILTER2_CELL" ;
      tblTablemergeddynamicfilters2_Internalname = "TABLEMERGEDDYNAMICFILTERS2" ;
      divTabledynamicfiltersrow2_Internalname = "TABLEDYNAMICFILTERSROW2" ;
      lblDynamicfiltersprefix3_Internalname = "DYNAMICFILTERSPREFIX3" ;
      cmbavDynamicfiltersselector3.setInternalname( "vDYNAMICFILTERSSELECTOR3" );
      lblDynamicfiltersmiddle3_Internalname = "DYNAMICFILTERSMIDDLE3" ;
      cmbavDynamicfiltersoperator3.setInternalname( "vDYNAMICFILTERSOPERATOR3" );
      edtavSecrolename3_Internalname = "vSECROLENAME3" ;
      cellFilter_secrolename3_cell_Internalname = "FILTER_SECROLENAME3_CELL" ;
      imgRemovedynamicfilters3_Internalname = "REMOVEDYNAMICFILTERS3" ;
      cellDynamicfilters_removefilter3_cell_Internalname = "DYNAMICFILTERS_REMOVEFILTER3_CELL" ;
      tblTablemergeddynamicfilters3_Internalname = "TABLEMERGEDDYNAMICFILTERS3" ;
      divTabledynamicfiltersrow3_Internalname = "TABLEDYNAMICFILTERSROW3" ;
      divTabledynamicfilters_Internalname = "TABLEDYNAMICFILTERS" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavUaassociatefunctionalities_Internalname = "vUAASSOCIATEFUNCTIONALITIES" ;
      edtSecRoleId_Internalname = "SECROLEID" ;
      edtSecRoleName_Internalname = "SECROLENAME" ;
      edtSecRoleDescription_Internalname = "SECROLEDESCRIPTION" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      lblJsdynamicfilters_Internalname = "JSDYNAMICFILTERS" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
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
      edtSecRoleDescription_Jsonclick = "" ;
      edtSecRoleName_Jsonclick = "" ;
      edtSecRoleId_Jsonclick = "" ;
      edtavUaassociatefunctionalities_gximage = "" ;
      edtavUaassociatefunctionalities_Link = "" ;
      edtavUaassociatefunctionalities_Tooltiptext = "" ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      imgRemovedynamicfilters1_Visible = 1 ;
      imgAdddynamicfilters1_Visible = 1 ;
      edtavSecrolename1_Jsonclick = "" ;
      edtavSecrolename1_Enabled = 1 ;
      cmbavDynamicfiltersoperator1.setJsonclick( "" );
      cmbavDynamicfiltersoperator1.setEnabled( 1 );
      imgRemovedynamicfilters2_Visible = 1 ;
      imgAdddynamicfilters2_Visible = 1 ;
      edtavSecrolename2_Jsonclick = "" ;
      edtavSecrolename2_Enabled = 1 ;
      cmbavDynamicfiltersoperator2.setJsonclick( "" );
      cmbavDynamicfiltersoperator2.setEnabled( 1 );
      edtavSecrolename3_Jsonclick = "" ;
      edtavSecrolename3_Enabled = 1 ;
      cmbavDynamicfiltersoperator3.setJsonclick( "" );
      cmbavDynamicfiltersoperator3.setEnabled( 1 );
      cmbavDynamicfiltersselector3.setJsonclick( "" );
      cmbavDynamicfiltersselector3.setEnabled( 1 );
      cmbavDynamicfiltersselector2.setJsonclick( "" );
      cmbavDynamicfiltersselector2.setEnabled( 1 );
      cmbavDynamicfiltersselector1.setJsonclick( "" );
      cmbavDynamicfiltersselector1.setEnabled( 1 );
      cmbavDynamicfiltersoperator3.setVisible( 1 );
      edtavSecrolename3_Visible = 1 ;
      cmbavDynamicfiltersoperator2.setVisible( 1 );
      edtavSecrolename2_Visible = 1 ;
      cmbavDynamicfiltersoperator1.setVisible( 1 );
      edtavSecrolename1_Visible = 1 ;
      edtavUaassociatefunctionalities_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      lblJsdynamicfilters_Caption = httpContext.getMessage( "JSDynamicFilters", "") ;
      bttBtninsert_Visible = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Innewwindow1_Target = "" ;
      Innewwindow1_Height = "50" ;
      Innewwindow1_Width = "50" ;
      Ddo_grid_Datalistproc = "WWPBaseObjects.SecRoleWWGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "T" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "T" ;
      Ddo_grid_Filtertype = "Character|Character" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2" ;
      Ddo_grid_Columnids = "4:SecRoleName|5:SecRoleDescription" ;
      Ddo_grid_Gridinternalname = "" ;
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
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( " Role", "") );
      edtavUaassociatefunctionalities_Title = "" ;
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavDynamicfiltersselector1.setName( "vDYNAMICFILTERSSELECTOR1" );
      cmbavDynamicfiltersselector1.setWebtags( "" );
      cmbavDynamicfiltersselector1.addItem("SECROLENAME", httpContext.getMessage( "Name", ""), (short)(0));
      if ( cmbavDynamicfiltersselector1.getItemCount() > 0 )
      {
         AV46DynamicFiltersSelector1 = cmbavDynamicfiltersselector1.getValidValue(AV46DynamicFiltersSelector1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersSelector1", AV46DynamicFiltersSelector1);
      }
      cmbavDynamicfiltersoperator1.setName( "vDYNAMICFILTERSOPERATOR1" );
      cmbavDynamicfiltersoperator1.setWebtags( "" );
      cmbavDynamicfiltersoperator1.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
      cmbavDynamicfiltersoperator1.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
      if ( cmbavDynamicfiltersoperator1.getItemCount() > 0 )
      {
         AV47DynamicFiltersOperator1 = (short)(GXutil.lval( cmbavDynamicfiltersoperator1.getValidValue(GXutil.trim( GXutil.str( AV47DynamicFiltersOperator1, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47DynamicFiltersOperator1), 4, 0));
      }
      cmbavDynamicfiltersselector2.setName( "vDYNAMICFILTERSSELECTOR2" );
      cmbavDynamicfiltersselector2.setWebtags( "" );
      cmbavDynamicfiltersselector2.addItem("SECROLENAME", httpContext.getMessage( "Name", ""), (short)(0));
      if ( cmbavDynamicfiltersselector2.getItemCount() > 0 )
      {
         AV51DynamicFiltersSelector2 = cmbavDynamicfiltersselector2.getValidValue(AV51DynamicFiltersSelector2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersSelector2", AV51DynamicFiltersSelector2);
      }
      cmbavDynamicfiltersoperator2.setName( "vDYNAMICFILTERSOPERATOR2" );
      cmbavDynamicfiltersoperator2.setWebtags( "" );
      cmbavDynamicfiltersoperator2.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
      cmbavDynamicfiltersoperator2.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
      if ( cmbavDynamicfiltersoperator2.getItemCount() > 0 )
      {
         AV52DynamicFiltersOperator2 = (short)(GXutil.lval( cmbavDynamicfiltersoperator2.getValidValue(GXutil.trim( GXutil.str( AV52DynamicFiltersOperator2, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52DynamicFiltersOperator2), 4, 0));
      }
      cmbavDynamicfiltersselector3.setName( "vDYNAMICFILTERSSELECTOR3" );
      cmbavDynamicfiltersselector3.setWebtags( "" );
      cmbavDynamicfiltersselector3.addItem("SECROLENAME", httpContext.getMessage( "Name", ""), (short)(0));
      if ( cmbavDynamicfiltersselector3.getItemCount() > 0 )
      {
         AV56DynamicFiltersSelector3 = cmbavDynamicfiltersselector3.getValidValue(AV56DynamicFiltersSelector3) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56DynamicFiltersSelector3", AV56DynamicFiltersSelector3);
      }
      cmbavDynamicfiltersoperator3.setName( "vDYNAMICFILTERSOPERATOR3" );
      cmbavDynamicfiltersoperator3.setWebtags( "" );
      cmbavDynamicfiltersoperator3.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
      cmbavDynamicfiltersoperator3.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
      if ( cmbavDynamicfiltersoperator3.getItemCount() > 0 )
      {
         AV57DynamicFiltersOperator3 = (short)(GXutil.lval( cmbavDynamicfiltersoperator3.getValidValue(GXutil.trim( GXutil.str( AV57DynamicFiltersOperator3, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57DynamicFiltersOperator3), 4, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV89GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV90GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV95GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'edtavUaassociatefunctionalities_Visible',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV68ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e121H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e131H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e141H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV91TFSecRoleName_SelsJson',fld:'vTFSECROLENAME_SELSJSON',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV93TFSecRoleDescription_SelsJson',fld:'vTFSECROLEDESCRIPTION_SELSJSON',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e281H2',iparms:[{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV14Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV13Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV34UAAssociateFunctionalities',fld:'vUAASSOCIATEFUNCTIONALITIES',pic:''},{av:'edtavUaassociatefunctionalities_Tooltiptext',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Tooltiptext'},{av:'edtavUaassociatefunctionalities_Link',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Link'}]}");
      setEventMetadata("'ADDDYNAMICFILTERS1'","{handler:'e211H2',iparms:[]");
      setEventMetadata("'ADDDYNAMICFILTERS1'",",oparms:[{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'}]}");
      setEventMetadata("'REMOVEDYNAMICFILTERS1'","{handler:'e151H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true}]");
      setEventMetadata("'REMOVEDYNAMICFILTERS1'",",oparms:[{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'edtavSecrolename2_Visible',ctrl:'vSECROLENAME2',prop:'Visible'},{av:'edtavSecrolename3_Visible',ctrl:'vSECROLENAME3',prop:'Visible'},{av:'edtavSecrolename1_Visible',ctrl:'vSECROLENAME1',prop:'Visible'},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV89GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV90GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV95GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'edtavUaassociatefunctionalities_Visible',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV68ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("VDYNAMICFILTERSSELECTOR1.CLICK","{handler:'e221H2',iparms:[{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''}]");
      setEventMetadata("VDYNAMICFILTERSSELECTOR1.CLICK",",oparms:[{av:'edtavSecrolename1_Visible',ctrl:'vSECROLENAME1',prop:'Visible'},{av:'cmbavDynamicfiltersoperator1'}]}");
      setEventMetadata("'ADDDYNAMICFILTERS2'","{handler:'e231H2',iparms:[]");
      setEventMetadata("'ADDDYNAMICFILTERS2'",",oparms:[{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'}]}");
      setEventMetadata("'REMOVEDYNAMICFILTERS2'","{handler:'e161H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true}]");
      setEventMetadata("'REMOVEDYNAMICFILTERS2'",",oparms:[{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'edtavSecrolename2_Visible',ctrl:'vSECROLENAME2',prop:'Visible'},{av:'edtavSecrolename3_Visible',ctrl:'vSECROLENAME3',prop:'Visible'},{av:'edtavSecrolename1_Visible',ctrl:'vSECROLENAME1',prop:'Visible'},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV89GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV90GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV95GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'edtavUaassociatefunctionalities_Visible',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV68ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("VDYNAMICFILTERSSELECTOR2.CLICK","{handler:'e241H2',iparms:[{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''}]");
      setEventMetadata("VDYNAMICFILTERSSELECTOR2.CLICK",",oparms:[{av:'edtavSecrolename2_Visible',ctrl:'vSECROLENAME2',prop:'Visible'},{av:'cmbavDynamicfiltersoperator2'}]}");
      setEventMetadata("'REMOVEDYNAMICFILTERS3'","{handler:'e171H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true}]");
      setEventMetadata("'REMOVEDYNAMICFILTERS3'",",oparms:[{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'edtavSecrolename2_Visible',ctrl:'vSECROLENAME2',prop:'Visible'},{av:'edtavSecrolename3_Visible',ctrl:'vSECROLENAME3',prop:'Visible'},{av:'edtavSecrolename1_Visible',ctrl:'vSECROLENAME1',prop:'Visible'},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV89GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV90GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV95GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'edtavUaassociatefunctionalities_Visible',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV68ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("VDYNAMICFILTERSSELECTOR3.CLICK","{handler:'e251H2',iparms:[{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''}]");
      setEventMetadata("VDYNAMICFILTERSSELECTOR3.CLICK",",oparms:[{av:'edtavSecrolename3_Visible',ctrl:'vSECROLENAME3',prop:'Visible'},{av:'cmbavDynamicfiltersoperator3'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e111H2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV91TFSecRoleName_SelsJson',fld:'vTFSECROLENAME_SELSJSON',pic:''},{av:'AV93TFSecRoleDescription_SelsJson',fld:'vTFSECROLEDESCRIPTION_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV91TFSecRoleName_SelsJson',fld:'vTFSECROLENAME_SELSJSON',pic:''},{av:'AV93TFSecRoleDescription_SelsJson',fld:'vTFSECROLEDESCRIPTION_SELSJSON',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'edtavSecrolename1_Visible',ctrl:'vSECROLENAME1',prop:'Visible'},{av:'edtavSecrolename2_Visible',ctrl:'vSECROLENAME2',prop:'Visible'},{av:'edtavSecrolename3_Visible',ctrl:'vSECROLENAME3',prop:'Visible'},{av:'AV89GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV90GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV95GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'edtavUaassociatefunctionalities_Visible',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV68ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e181H2',iparms:[{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e191H2',iparms:[{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV91TFSecRoleName_SelsJson',fld:'vTFSECROLENAME_SELSJSON',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV93TFSecRoleDescription_SelsJson',fld:'vTFSECROLEDESCRIPTION_SELSJSON',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''}]");
      setEventMetadata("'DOEXPORT'",",oparms:[{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV91TFSecRoleName_SelsJson',fld:'vTFSECROLENAME_SELSJSON',pic:''},{av:'AV93TFSecRoleDescription_SelsJson',fld:'vTFSECROLEDESCRIPTION_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'edtavSecrolename1_Visible',ctrl:'vSECROLENAME1',prop:'Visible'},{av:'edtavSecrolename2_Visible',ctrl:'vSECROLENAME2',prop:'Visible'},{av:'edtavSecrolename3_Visible',ctrl:'vSECROLENAME3',prop:'Visible'}]}");
      setEventMetadata("'DOEXPORTREPORT'","{handler:'e201H2',iparms:[{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV91TFSecRoleName_SelsJson',fld:'vTFSECROLENAME_SELSJSON',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV93TFSecRoleDescription_SelsJson',fld:'vTFSECROLEDESCRIPTION_SELSJSON',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''}]");
      setEventMetadata("'DOEXPORTREPORT'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV41GridState',fld:'vGRIDSTATE',pic:''},{av:'AV44OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV45OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'cmbavDynamicfiltersselector1'},{av:'AV46DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV47DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV48SecRoleName1',fld:'vSECROLENAME1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV51DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV52DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV53SecRoleName2',fld:'vSECROLENAME2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV56DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV57DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV58SecRoleName3',fld:'vSECROLENAME3',pic:''},{av:'AV64ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV55DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV71TFSecRoleName',fld:'vTFSECROLENAME',pic:''},{av:'AV92TFSecRoleName_Sels',fld:'vTFSECROLENAME_SELS',pic:''},{av:'AV75TFSecRoleDescription',fld:'vTFSECROLEDESCRIPTION',pic:''},{av:'AV94TFSecRoleDescription_Sels',fld:'vTFSECROLEDESCRIPTION_SELS',pic:''},{av:'AV61DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV60DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'edtavUaassociatefunctionalities_Title',ctrl:'vUAASSOCIATEFUNCTIONALITIES',prop:'Title'},{av:'AV40IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV35IsAuthorized_UAAssociateFunctionalities',fld:'vISAUTHORIZED_UAASSOCIATEFUNCTIONALITIES',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV91TFSecRoleName_SelsJson',fld:'vTFSECROLENAME_SELSJSON',pic:''},{av:'AV93TFSecRoleDescription_SelsJson',fld:'vTFSECROLEDESCRIPTION_SELSJSON',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'edtavSecrolename1_Visible',ctrl:'vSECROLENAME1',prop:'Visible'},{av:'edtavSecrolename2_Visible',ctrl:'vSECROLENAME2',prop:'Visible'},{av:'edtavSecrolename3_Visible',ctrl:'vSECROLENAME3',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'valid_Secroledescription',iparms:[]");
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
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV46DynamicFiltersSelector1 = "" ;
      AV48SecRoleName1 = "" ;
      AV51DynamicFiltersSelector2 = "" ;
      AV53SecRoleName2 = "" ;
      AV56DynamicFiltersSelector3 = "" ;
      AV58SecRoleName3 = "" ;
      AV100Pgmname = "" ;
      AV71TFSecRoleName = "" ;
      AV92TFSecRoleName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75TFSecRoleDescription = "" ;
      AV94TFSecRoleDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV68ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV95GridAppliedFilters = "" ;
      AV78DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV91TFSecRoleName_SelsJson = "" ;
      AV93TFSecRoleDescription_SelsJson = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtninsert_Jsonclick = "" ;
      imgBtnexport_gximage = "" ;
      sImgUrl = "" ;
      imgBtnexport_Jsonclick = "" ;
      bttBtnexportreport_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      lblJsdynamicfilters_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV14Delete = "" ;
      AV13Update = "" ;
      AV34UAAssociateFunctionalities = "" ;
      AV116Uaassociatefunctionalities_GXI = "" ;
      A355SecRoleName = "" ;
      A354SecRoleDescription = "" ;
      AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV103Wwpbaseobjects_secrolewwds_3_secrolename1 = "" ;
      lV107Wwpbaseobjects_secrolewwds_7_secrolename2 = "" ;
      lV111Wwpbaseobjects_secrolewwds_11_secrolename3 = "" ;
      lV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = "" ;
      lV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = "" ;
      AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = "" ;
      AV103Wwpbaseobjects_secrolewwds_3_secrolename1 = "" ;
      AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = "" ;
      AV107Wwpbaseobjects_secrolewwds_7_secrolename2 = "" ;
      AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = "" ;
      AV111Wwpbaseobjects_secrolewwds_11_secrolename3 = "" ;
      AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename = "" ;
      AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription = "" ;
      H001H2_A354SecRoleDescription = new String[] {""} ;
      H001H2_A355SecRoleName = new String[] {""} ;
      H001H2_A65SecRoleId = new short[1] ;
      H001H3_AGRID_nRecordCount = new long[1] ;
      AV8HTTPRequest = httpContext.getHttpRequest();
      imgAdddynamicfilters1_Jsonclick = "" ;
      imgRemovedynamicfilters1_Jsonclick = "" ;
      imgAdddynamicfilters2_Jsonclick = "" ;
      imgRemovedynamicfilters2_Jsonclick = "" ;
      imgRemovedynamicfilters3_Jsonclick = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int2 = new int[1] ;
      AV87WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV65ManageFiltersXml = "" ;
      AV62ExcelFilename = "" ;
      AV63ErrorMessage = "" ;
      GXv_boolean10 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12 = new GXBaseCollection[1] ;
      AV15Session = httpContext.getWebSession();
      AV42GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char13 = "" ;
      GXv_char8 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV43GridStateDynamicFilter = new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
      GXv_SdtWWPGridState14 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      lblDynamicfiltersprefix1_Jsonclick = "" ;
      lblDynamicfiltersmiddle1_Jsonclick = "" ;
      lblDynamicfiltersprefix2_Jsonclick = "" ;
      lblDynamicfiltersmiddle2_Jsonclick = "" ;
      lblDynamicfiltersprefix3_Jsonclick = "" ;
      lblDynamicfiltersmiddle3_Jsonclick = "" ;
      imgRemovedynamicfilters3_gximage = "" ;
      imgAdddynamicfilters2_gximage = "" ;
      imgRemovedynamicfilters2_gximage = "" ;
      imgAdddynamicfilters1_gximage = "" ;
      imgRemovedynamicfilters1_gximage = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secroleww__default(),
         new Object[] {
             new Object[] {
            H001H2_A354SecRoleDescription, H001H2_A355SecRoleName, H001H2_A65SecRoleId
            }
            , new Object[] {
            H001H3_AGRID_nRecordCount
            }
         }
      );
      AV100Pgmname = "WWPBaseObjects.SecRoleWW" ;
      /* GeneXus formulas. */
      AV100Pgmname = "WWPBaseObjects.SecRoleWW" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV64ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
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
   private short AV47DynamicFiltersOperator1 ;
   private short AV52DynamicFiltersOperator2 ;
   private short AV57DynamicFiltersOperator3 ;
   private short AV44OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A65SecRoleId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ;
   private short AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ;
   private short AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_103 ;
   private int nGXsfl_103_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int subGrid_Islastpage ;
   private int edtavDelete_Enabled ;
   private int edtavUpdate_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ;
   private int AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ;
   private int AV96CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV88PageToGo ;
   private int imgAdddynamicfilters1_Visible ;
   private int imgRemovedynamicfilters1_Visible ;
   private int imgAdddynamicfilters2_Visible ;
   private int imgRemovedynamicfilters2_Visible ;
   private int edtavDelete_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavUaassociatefunctionalities_Visible ;
   private int edtavSecrolename1_Visible ;
   private int edtavSecrolename2_Visible ;
   private int edtavSecrolename3_Visible ;
   private int AV117GXV1 ;
   private int edtavSecrolename3_Enabled ;
   private int edtavSecrolename2_Enabled ;
   private int edtavSecrolename1_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV89GridCurrentPage ;
   private long AV90GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String edtavUaassociatefunctionalities_Title ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_103_idx="0001" ;
   private String edtavUaassociatefunctionalities_Internalname ;
   private String AV100Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
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
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistproc ;
   private String Innewwindow1_Width ;
   private String Innewwindow1_Height ;
   private String Innewwindow1_Target ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtninsert_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String imgBtnexport_gximage ;
   private String sImgUrl ;
   private String imgBtnexport_Internalname ;
   private String imgBtnexport_Jsonclick ;
   private String bttBtnexportreport_Internalname ;
   private String bttBtnexportreport_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String lblJsdynamicfilters_Internalname ;
   private String lblJsdynamicfilters_Caption ;
   private String lblJsdynamicfilters_Jsonclick ;
   private String Ddo_grid_Internalname ;
   private String Innewwindow1_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV14Delete ;
   private String edtavDelete_Internalname ;
   private String AV13Update ;
   private String edtavUpdate_Internalname ;
   private String edtSecRoleId_Internalname ;
   private String edtSecRoleName_Internalname ;
   private String edtSecRoleDescription_Internalname ;
   private String scmdbuf ;
   private String edtavSecrolename1_Internalname ;
   private String edtavSecrolename2_Internalname ;
   private String edtavSecrolename3_Internalname ;
   private String imgAdddynamicfilters1_Jsonclick ;
   private String divTabledynamicfilters_Internalname ;
   private String imgAdddynamicfilters1_Internalname ;
   private String imgRemovedynamicfilters1_Jsonclick ;
   private String imgRemovedynamicfilters1_Internalname ;
   private String imgAdddynamicfilters2_Jsonclick ;
   private String imgAdddynamicfilters2_Internalname ;
   private String imgRemovedynamicfilters2_Jsonclick ;
   private String imgRemovedynamicfilters2_Internalname ;
   private String imgRemovedynamicfilters3_Jsonclick ;
   private String imgRemovedynamicfilters3_Internalname ;
   private String edtavDelete_Link ;
   private String edtavUpdate_Link ;
   private String edtavUaassociatefunctionalities_gximage ;
   private String edtavUaassociatefunctionalities_Tooltiptext ;
   private String edtavUaassociatefunctionalities_Link ;
   private String GXt_char13 ;
   private String GXv_char8[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String divTabledynamicfiltersrow1_Internalname ;
   private String lblDynamicfiltersprefix1_Internalname ;
   private String lblDynamicfiltersprefix1_Jsonclick ;
   private String lblDynamicfiltersmiddle1_Internalname ;
   private String lblDynamicfiltersmiddle1_Jsonclick ;
   private String divTabledynamicfiltersrow2_Internalname ;
   private String lblDynamicfiltersprefix2_Internalname ;
   private String lblDynamicfiltersprefix2_Jsonclick ;
   private String lblDynamicfiltersmiddle2_Internalname ;
   private String lblDynamicfiltersmiddle2_Jsonclick ;
   private String divTabledynamicfiltersrow3_Internalname ;
   private String lblDynamicfiltersprefix3_Internalname ;
   private String lblDynamicfiltersprefix3_Jsonclick ;
   private String lblDynamicfiltersmiddle3_Internalname ;
   private String lblDynamicfiltersmiddle3_Jsonclick ;
   private String tblTablemergeddynamicfilters3_Internalname ;
   private String cellFilter_secrolename3_cell_Internalname ;
   private String edtavSecrolename3_Jsonclick ;
   private String cellDynamicfilters_removefilter3_cell_Internalname ;
   private String imgRemovedynamicfilters3_gximage ;
   private String tblTablemergeddynamicfilters2_Internalname ;
   private String cellFilter_secrolename2_cell_Internalname ;
   private String edtavSecrolename2_Jsonclick ;
   private String cellDynamicfilters_addfilter2_cell_Internalname ;
   private String imgAdddynamicfilters2_gximage ;
   private String cellDynamicfilters_removefilter2_cell_Internalname ;
   private String imgRemovedynamicfilters2_gximage ;
   private String tblTablemergeddynamicfilters1_Internalname ;
   private String cellFilter_secrolename1_cell_Internalname ;
   private String edtavSecrolename1_Jsonclick ;
   private String cellDynamicfilters_addfilter1_cell_Internalname ;
   private String imgAdddynamicfilters1_gximage ;
   private String cellDynamicfilters_removefilter1_cell_Internalname ;
   private String imgRemovedynamicfilters1_gximage ;
   private String sGXsfl_103_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDelete_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtSecRoleId_Jsonclick ;
   private String edtSecRoleName_Jsonclick ;
   private String edtSecRoleDescription_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_103_Refreshing=false ;
   private boolean AV50DynamicFiltersEnabled2 ;
   private boolean AV55DynamicFiltersEnabled3 ;
   private boolean AV45OrderedDsc ;
   private boolean AV61DynamicFiltersIgnoreFirst ;
   private boolean AV60DynamicFiltersRemoving ;
   private boolean AV40IsAuthorized_Delete ;
   private boolean AV37IsAuthorized_Update ;
   private boolean AV35IsAuthorized_UAAssociateFunctionalities ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ;
   private boolean AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV36TempBoolean ;
   private boolean GXt_boolean9 ;
   private boolean GXv_boolean10[] ;
   private boolean AV34UAAssociateFunctionalities_IsBlob ;
   private String AV91TFSecRoleName_SelsJson ;
   private String AV93TFSecRoleDescription_SelsJson ;
   private String AV65ManageFiltersXml ;
   private String AV46DynamicFiltersSelector1 ;
   private String AV48SecRoleName1 ;
   private String AV51DynamicFiltersSelector2 ;
   private String AV53SecRoleName2 ;
   private String AV56DynamicFiltersSelector3 ;
   private String AV58SecRoleName3 ;
   private String AV71TFSecRoleName ;
   private String AV75TFSecRoleDescription ;
   private String AV95GridAppliedFilters ;
   private String AV116Uaassociatefunctionalities_GXI ;
   private String A355SecRoleName ;
   private String A354SecRoleDescription ;
   private String lV103Wwpbaseobjects_secrolewwds_3_secrolename1 ;
   private String lV107Wwpbaseobjects_secrolewwds_7_secrolename2 ;
   private String lV111Wwpbaseobjects_secrolewwds_11_secrolename3 ;
   private String lV112Wwpbaseobjects_secrolewwds_12_tfsecrolename ;
   private String lV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription ;
   private String AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ;
   private String AV103Wwpbaseobjects_secrolewwds_3_secrolename1 ;
   private String AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ;
   private String AV107Wwpbaseobjects_secrolewwds_7_secrolename2 ;
   private String AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ;
   private String AV111Wwpbaseobjects_secrolewwds_11_secrolename3 ;
   private String AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename ;
   private String AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription ;
   private String AV62ExcelFilename ;
   private String AV63ErrorMessage ;
   private String AV34UAAssociateFunctionalities ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ;
   private GXSimpleCollection<String> AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ;
   private HTMLChoice cmbavDynamicfiltersselector1 ;
   private HTMLChoice cmbavDynamicfiltersoperator1 ;
   private HTMLChoice cmbavDynamicfiltersselector2 ;
   private HTMLChoice cmbavDynamicfiltersoperator2 ;
   private HTMLChoice cmbavDynamicfiltersselector3 ;
   private HTMLChoice cmbavDynamicfiltersoperator3 ;
   private IDataStoreProvider pr_default ;
   private String[] H001H2_A354SecRoleDescription ;
   private String[] H001H2_A355SecRoleName ;
   private short[] H001H2_A65SecRoleId ;
   private long[] H001H3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV92TFSecRoleName_Sels ;
   private GXSimpleCollection<String> AV94TFSecRoleDescription_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV68ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item11 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item12[] ;
   private web.wwpbaseobjects.SdtWWPContext AV87WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV41GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState14[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV42GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPGridState_DynamicFilter AV43GridStateDynamicFilter ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV78DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class secroleww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A355SecRoleName ,
                                          GXSimpleCollection<String> AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                          String A354SecRoleDescription ,
                                          GXSimpleCollection<String> AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                          String AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                          short AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ,
                                          String AV103Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                          boolean AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ,
                                          String AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                          short AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ,
                                          String AV107Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                          boolean AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ,
                                          String AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                          short AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ,
                                          String AV111Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                          int AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ,
                                          String AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                          int AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ,
                                          String AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription ,
                                          short AV44OrderedBy ,
                                          boolean AV45OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[11];
      Object[] GXv_Object16 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " SecRoleDescription, SecRoleName, SecRoleId" ;
      sFromString = " FROM SecRole" ;
      sOrderString = "" ;
      if ( ( GXutil.strcmp(AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, "SECROLENAME") == 0 ) && ( AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 0 ) && ( ! (GXutil.strcmp("", AV103Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int15[0] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, "SECROLENAME") == 0 ) && ( AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 1 ) && ( ! (GXutil.strcmp("", AV103Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int15[1] = (byte)(1) ;
      }
      if ( AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, "SECROLENAME") == 0 ) && ( AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 0 ) && ( ! (GXutil.strcmp("", AV107Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int15[2] = (byte)(1) ;
      }
      if ( AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, "SECROLENAME") == 0 ) && ( AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 1 ) && ( ! (GXutil.strcmp("", AV107Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int15[3] = (byte)(1) ;
      }
      if ( AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, "SECROLENAME") == 0 ) && ( AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 0 ) && ( ! (GXutil.strcmp("", AV111Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int15[4] = (byte)(1) ;
      }
      if ( AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, "SECROLENAME") == 0 ) && ( AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 1 ) && ( ! (GXutil.strcmp("", AV111Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int15[5] = (byte)(1) ;
      }
      if ( ( AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int15[6] = (byte)(1) ;
      }
      if ( AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels, "SecRoleName IN (", ")")+")");
      }
      if ( ( AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleDescription) like LOWER(?))");
      }
      else
      {
         GXv_int15[7] = (byte)(1) ;
      }
      if ( AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels, "SecRoleDescription IN (", ")")+")");
      }
      if ( ( AV44OrderedBy == 1 ) && ! AV45OrderedDsc )
      {
         sOrderString += " ORDER BY SecRoleName, SecRoleId" ;
      }
      else if ( ( AV44OrderedBy == 1 ) && ( AV45OrderedDsc ) )
      {
         sOrderString += " ORDER BY SecRoleName DESC, SecRoleId" ;
      }
      else if ( ( AV44OrderedBy == 2 ) && ! AV45OrderedDsc )
      {
         sOrderString += " ORDER BY SecRoleDescription, SecRoleId" ;
      }
      else if ( ( AV44OrderedBy == 2 ) && ( AV45OrderedDsc ) )
      {
         sOrderString += " ORDER BY SecRoleDescription DESC, SecRoleId" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY SecRoleId" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
   }

   protected Object[] conditional_H001H3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A355SecRoleName ,
                                          GXSimpleCollection<String> AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                          String A354SecRoleDescription ,
                                          GXSimpleCollection<String> AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                          String AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                          short AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ,
                                          String AV103Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                          boolean AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ,
                                          String AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                          short AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ,
                                          String AV107Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                          boolean AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ,
                                          String AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                          short AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ,
                                          String AV111Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                          int AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ,
                                          String AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                          int AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ,
                                          String AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription ,
                                          short AV44OrderedBy ,
                                          boolean AV45OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[8];
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM SecRole" ;
      if ( ( GXutil.strcmp(AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, "SECROLENAME") == 0 ) && ( AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 0 ) && ( ! (GXutil.strcmp("", AV103Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int18[0] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV101Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, "SECROLENAME") == 0 ) && ( AV102Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 1 ) && ( ! (GXutil.strcmp("", AV103Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int18[1] = (byte)(1) ;
      }
      if ( AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, "SECROLENAME") == 0 ) && ( AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 0 ) && ( ! (GXutil.strcmp("", AV107Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int18[2] = (byte)(1) ;
      }
      if ( AV104Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV105Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, "SECROLENAME") == 0 ) && ( AV106Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 1 ) && ( ! (GXutil.strcmp("", AV107Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int18[3] = (byte)(1) ;
      }
      if ( AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, "SECROLENAME") == 0 ) && ( AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 0 ) && ( ! (GXutil.strcmp("", AV111Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int18[4] = (byte)(1) ;
      }
      if ( AV108Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV109Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, "SECROLENAME") == 0 ) && ( AV110Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 1 ) && ( ! (GXutil.strcmp("", AV111Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int18[5] = (byte)(1) ;
      }
      if ( ( AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV112Wwpbaseobjects_secrolewwds_12_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int18[6] = (byte)(1) ;
      }
      if ( AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV113Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels, "SecRoleName IN (", ")")+")");
      }
      if ( ( AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV114Wwpbaseobjects_secrolewwds_14_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleDescription) like LOWER(?))");
      }
      else
      {
         GXv_int18[7] = (byte)(1) ;
      }
      if ( AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels, "SecRoleDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV44OrderedBy == 1 ) && ! AV45OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV44OrderedBy == 1 ) && ( AV45OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV44OrderedBy == 2 ) && ! AV45OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV44OrderedBy == 2 ) && ( AV45OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
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
                  return conditional_H001H2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Boolean) dynConstraints[7]).booleanValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , ((Boolean) dynConstraints[11]).booleanValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() );
            case 1 :
                  return conditional_H001H3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Boolean) dynConstraints[7]).booleanValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , ((Boolean) dynConstraints[11]).booleanValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001H3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 40);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 120);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 120);
               }
               return;
      }
   }

}

