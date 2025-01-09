package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secrolefunroleactionassociationww_impl extends GXDataArea
{
   public secrolefunroleactionassociationww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secrolefunroleactionassociationww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolefunroleactionassociationww_impl.class ));
   }

   public secrolefunroleactionassociationww_impl( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavSecfunctionalitytype = new HTMLChoice();
      cmbavDynamicfiltersselector1 = new HTMLChoice();
      cmbavDynamicfiltersoperator1 = new HTMLChoice();
      cmbavDynamicfiltersselector2 = new HTMLChoice();
      cmbavDynamicfiltersoperator2 = new HTMLChoice();
      cmbavDynamicfiltersselector3 = new HTMLChoice();
      cmbavDynamicfiltersoperator3 = new HTMLChoice();
      chkavIsassociated = UIFactory.getCheckbox(this);
      chkavIsassociatedold = UIFactory.getCheckbox(this);
      cmbSecFunctionalityType = new HTMLChoice();
      chkSecFunctionalityActive = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "SecRoleId") ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV9SecRoleId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9SecRoleId), "ZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV29SecParentFunctionalityId = GXutil.lval( httpContext.GetPar( "SecParentFunctionalityId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV29SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29SecParentFunctionalityId), 10, 0));
            }
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
      nRC_GXsfl_101 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_101"))) ;
      nGXsfl_101_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_101_idx"))) ;
      sGXsfl_101_idx = httpContext.GetPar( "sGXsfl_101_idx") ;
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
      cmbavSecfunctionalitytype.fromJSonString( httpContext.GetNextPar( ));
      AV27SecFunctionalityType = (byte)(GXutil.lval( httpContext.GetPar( "SecFunctionalityType"))) ;
      cmbavDynamicfiltersselector1.fromJSonString( httpContext.GetNextPar( ));
      AV37DynamicFiltersSelector1 = httpContext.GetPar( "DynamicFiltersSelector1") ;
      cmbavDynamicfiltersoperator1.fromJSonString( httpContext.GetNextPar( ));
      AV38DynamicFiltersOperator1 = (short)(GXutil.lval( httpContext.GetPar( "DynamicFiltersOperator1"))) ;
      AV39SecFunctionalityDescription1 = httpContext.GetPar( "SecFunctionalityDescription1") ;
      AV53SecParentFunctionalityDescription1 = httpContext.GetPar( "SecParentFunctionalityDescription1") ;
      cmbavDynamicfiltersselector2.fromJSonString( httpContext.GetNextPar( ));
      AV42DynamicFiltersSelector2 = httpContext.GetPar( "DynamicFiltersSelector2") ;
      cmbavDynamicfiltersoperator2.fromJSonString( httpContext.GetNextPar( ));
      AV43DynamicFiltersOperator2 = (short)(GXutil.lval( httpContext.GetPar( "DynamicFiltersOperator2"))) ;
      AV44SecFunctionalityDescription2 = httpContext.GetPar( "SecFunctionalityDescription2") ;
      AV54SecParentFunctionalityDescription2 = httpContext.GetPar( "SecParentFunctionalityDescription2") ;
      cmbavDynamicfiltersselector3.fromJSonString( httpContext.GetNextPar( ));
      AV47DynamicFiltersSelector3 = httpContext.GetPar( "DynamicFiltersSelector3") ;
      cmbavDynamicfiltersoperator3.fromJSonString( httpContext.GetNextPar( ));
      AV48DynamicFiltersOperator3 = (short)(GXutil.lval( httpContext.GetPar( "DynamicFiltersOperator3"))) ;
      AV49SecFunctionalityDescription3 = httpContext.GetPar( "SecFunctionalityDescription3") ;
      AV55SecParentFunctionalityDescription3 = httpContext.GetPar( "SecParentFunctionalityDescription3") ;
      AV29SecParentFunctionalityId = GXutil.lval( httpContext.GetPar( "SecParentFunctionalityId")) ;
      AV41DynamicFiltersEnabled2 = GXutil.strtobool( httpContext.GetPar( "DynamicFiltersEnabled2")) ;
      AV46DynamicFiltersEnabled3 = GXutil.strtobool( httpContext.GetPar( "DynamicFiltersEnabled3")) ;
      AV86Pgmname = httpContext.GetPar( "Pgmname") ;
      AV13SecFunctionalityIdRemovedXml = httpContext.GetPar( "SecFunctionalityIdRemovedXml") ;
      AV12SecFunctionalityIdAddedXml = httpContext.GetPar( "SecFunctionalityIdAddedXml") ;
      AV9SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
      A65SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
      AV21i = GXutil.lval( httpContext.GetPar( "i")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV11SecFunctionalityIdRemoved);
      AV15SecFunctionalityIdToFind = GXutil.lval( httpContext.GetPar( "SecFunctionalityIdToFind")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV10SecFunctionalityIdAdded);
      AV31SecRoleIdParm = (short)(GXutil.lval( httpContext.GetPar( "SecRoleIdParm"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
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
      pa2Y2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2Y2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.wwpbaseobjects.secrolefunroleactionassociationww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9SecRoleId,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV29SecParentFunctionalityId,10,0))}, new String[] {"SecRoleId","SecParentFunctionalityId"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV86Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEIDPARM", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31SecRoleIdParm), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9SecRoleId), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECFUNCTIONALITYTYPE", GXutil.ltrim( localUtil.ntoc( AV27SecFunctionalityType, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSSELECTOR1", AV37DynamicFiltersSelector1);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSOPERATOR1", GXutil.ltrim( localUtil.ntoc( AV38DynamicFiltersOperator1, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECFUNCTIONALITYDESCRIPTION1", AV39SecFunctionalityDescription1);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION1", AV53SecParentFunctionalityDescription1);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSSELECTOR2", AV42DynamicFiltersSelector2);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSOPERATOR2", GXutil.ltrim( localUtil.ntoc( AV43DynamicFiltersOperator2, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECFUNCTIONALITYDESCRIPTION2", AV44SecFunctionalityDescription2);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION2", AV54SecParentFunctionalityDescription2);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSSELECTOR3", AV47DynamicFiltersSelector3);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vDYNAMICFILTERSOPERATOR3", GXutil.ltrim( localUtil.ntoc( AV48DynamicFiltersOperator3, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECFUNCTIONALITYDESCRIPTION3", AV49SecFunctionalityDescription3);
      web.GxWebStd.gx_hidden_field( httpContext, "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION3", AV55SecParentFunctionalityDescription3);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_101", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_101, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV78GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV79GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV80GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV71DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV71DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDYNAMICFILTERSENABLED2", AV41DynamicFiltersEnabled2);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDYNAMICFILTERSENABLED3", AV46DynamicFiltersEnabled3);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV86Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV86Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYIDREMOVEDXML", AV13SecFunctionalityIdRemovedXml);
      web.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYIDADDEDXML", AV12SecFunctionalityIdAddedXml);
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV35OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV36OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vSECROLEID", GXutil.ltrim( localUtil.ntoc( AV9SecRoleId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9SecRoleId), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECROLEID", GXutil.ltrim( localUtil.ntoc( A65SecRoleId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vI", GXutil.ltrim( localUtil.ntoc( AV21i, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECFUNCTIONALITYIDREMOVED", AV11SecFunctionalityIdRemoved);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECFUNCTIONALITYIDREMOVED", AV11SecFunctionalityIdRemoved);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYIDTOFIND", GXutil.ltrim( localUtil.ntoc( AV15SecFunctionalityIdToFind, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECFUNCTIONALITYIDADDED", AV10SecFunctionalityIdAdded);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECFUNCTIONALITYIDADDED", AV10SecFunctionalityIdAdded);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vSECROLEIDPARM", GXutil.ltrim( localUtil.ntoc( AV31SecRoleIdParm, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEIDPARM", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31SecRoleIdParm), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECFUNCTIONALITYROLE", AV16SecFunctionalityRole);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECFUNCTIONALITYROLE", AV16SecFunctionalityRole);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV32GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV32GridState);
      }
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDYNAMICFILTERSIGNOREFIRST", AV52DynamicFiltersIgnoreFirst);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vDYNAMICFILTERSREMOVING", AV51DynamicFiltersRemoving);
      web.GxWebStd.gx_hidden_field( httpContext, "vSECPARENTFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( AV29SecParentFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
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
         we2Y2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2Y2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.wwpbaseobjects.secrolefunroleactionassociationww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9SecRoleId,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV29SecParentFunctionalityId,10,0))}, new String[] {"SecRoleId","SecParentFunctionalityId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecRoleFunRoleActionAssociationWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Associated to Role", "") ;
   }

   public void wb2Y0( )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "TableCellsWidthAuto", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs CellFloatRight", "left", "top", "", "", "div");
         wb_table1_15_2Y2( true) ;
      }
      else
      {
         wb_table1_15_2Y2( false) ;
      }
      return  ;
   }

   public void wb_table1_15_2Y2e( boolean wbgen )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol101( ) ;
      }
      if ( wbEnd == 101 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_101 = (int)(nGXsfl_101_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV78GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV79GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV80GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirm_Internalname, "gx.evt.setGridEvt("+GXutil.str( 101, 3, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnconfirm_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 101, 3, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblJsdynamicfilters_Internalname, lblJsdynamicfilters_Caption, "", "", lblJsdynamicfilters_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "", 0, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV71DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 101 )
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

   public void start2Y2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Associated to Role", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2Y0( ) ;
   }

   public void ws2Y2( )
   {
      start2Y2( ) ;
      evt2Y2( ) ;
   }

   public void evt2Y2( )
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
                           e112Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              /* Set Refresh If Secfunctionalitytype Changed */
                              if ( localUtil.ctol( httpContext.cgiGet( "GXH_vSECFUNCTIONALITYTYPE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV27SecFunctionalityType )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Dynamicfiltersselector1 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR1"), AV37DynamicFiltersSelector1) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Dynamicfiltersoperator1 Changed */
                              if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV38DynamicFiltersOperator1 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Secfunctionalitydescription1 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECFUNCTIONALITYDESCRIPTION1"), AV39SecFunctionalityDescription1) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Secparentfunctionalitydescription1 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION1"), AV53SecParentFunctionalityDescription1) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Dynamicfiltersselector2 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR2"), AV42DynamicFiltersSelector2) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Dynamicfiltersoperator2 Changed */
                              if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV43DynamicFiltersOperator2 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Secfunctionalitydescription2 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECFUNCTIONALITYDESCRIPTION2"), AV44SecFunctionalityDescription2) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Secparentfunctionalitydescription2 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION2"), AV54SecParentFunctionalityDescription2) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Dynamicfiltersselector3 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR3"), AV47DynamicFiltersSelector3) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Dynamicfiltersoperator3 Changed */
                              if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR3"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV48DynamicFiltersOperator3 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Secfunctionalitydescription3 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECFUNCTIONALITYDESCRIPTION3"), AV49SecFunctionalityDescription3) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              /* Set Refresh If Secparentfunctionalitydescription3 Changed */
                              if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION3"), AV55SecParentFunctionalityDescription3) != 0 )
                              {
                                 Rfr0gs = true ;
                              }
                              if ( ! Rfr0gs )
                              {
                                 /* Execute user event: Enter */
                                 e142Y2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'REMOVEDYNAMICFILTERS1'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'RemoveDynamicFilters1' */
                           e152Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'REMOVEDYNAMICFILTERS2'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'RemoveDynamicFilters2' */
                           e162Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'REMOVEDYNAMICFILTERS3'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'RemoveDynamicFilters3' */
                           e172Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADDDYNAMICFILTERS1'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'AddDynamicFilters1' */
                           e182Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VDYNAMICFILTERSSELECTOR1.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e192Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADDDYNAMICFILTERS2'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'AddDynamicFilters2' */
                           e202Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VDYNAMICFILTERSSELECTOR2.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e212Y2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VDYNAMICFILTERSSELECTOR3.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e222Y2 ();
                           /* No code required for Cancel button. It is implemented as the Reset button. */
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "VISASSOCIATED.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "VISASSOCIATED.CLICK") == 0 ) )
                        {
                           nGXsfl_101_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_101_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_101_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1012( ) ;
                           AV18IsAssociated = GXutil.strtobool( httpContext.cgiGet( chkavIsassociated.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
                           AV19IsAssociatedOld = GXutil.strtobool( httpContext.cgiGet( chkavIsassociatedold.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
                           web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_101_idx, getSecureSignedToken( sGXsfl_101_idx, AV19IsAssociatedOld));
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
                                 e232Y2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e242Y2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e252Y2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VISASSOCIATED.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e262Y2 ();
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

   public void we2Y2( )
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

   public void pa2Y2( )
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
            GX_FocusControl = cmbavSecfunctionalitytype.getInternalname() ;
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
      subsflControlProps_1012( ) ;
      while ( nGXsfl_101_idx <= nRC_GXsfl_101 )
      {
         sendrow_1012( ) ;
         nGXsfl_101_idx = ((subGrid_Islastpage==1)&&(nGXsfl_101_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_101_idx+1) ;
         sGXsfl_101_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_101_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1012( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV27SecFunctionalityType ,
                                 String AV37DynamicFiltersSelector1 ,
                                 short AV38DynamicFiltersOperator1 ,
                                 String AV39SecFunctionalityDescription1 ,
                                 String AV53SecParentFunctionalityDescription1 ,
                                 String AV42DynamicFiltersSelector2 ,
                                 short AV43DynamicFiltersOperator2 ,
                                 String AV44SecFunctionalityDescription2 ,
                                 String AV54SecParentFunctionalityDescription2 ,
                                 String AV47DynamicFiltersSelector3 ,
                                 short AV48DynamicFiltersOperator3 ,
                                 String AV49SecFunctionalityDescription3 ,
                                 String AV55SecParentFunctionalityDescription3 ,
                                 long AV29SecParentFunctionalityId ,
                                 boolean AV41DynamicFiltersEnabled2 ,
                                 boolean AV46DynamicFiltersEnabled3 ,
                                 String AV86Pgmname ,
                                 String AV13SecFunctionalityIdRemovedXml ,
                                 String AV12SecFunctionalityIdAddedXml ,
                                 short AV9SecRoleId ,
                                 short A65SecRoleId ,
                                 long AV21i ,
                                 GXSimpleCollection<Long> AV11SecFunctionalityIdRemoved ,
                                 long AV15SecFunctionalityIdToFind ,
                                 GXSimpleCollection<Long> AV10SecFunctionalityIdAdded ,
                                 short AV31SecRoleIdParm )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e242Y2 ();
      GRID_nCurrentRecord = 0 ;
      rf2Y2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECFUNCTIONALITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( A62SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD", getSecureSignedToken( "", AV19IsAssociatedOld));
      web.GxWebStd.gx_hidden_field( httpContext, "vISASSOCIATEDOLD", GXutil.booltostr( AV19IsAssociatedOld));
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
      if ( cmbavSecfunctionalitytype.getItemCount() > 0 )
      {
         AV27SecFunctionalityType = (byte)(GXutil.lval( cmbavSecfunctionalitytype.getValidValue(GXutil.trim( GXutil.str( AV27SecFunctionalityType, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27SecFunctionalityType), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSecfunctionalitytype.setValue( GXutil.trim( GXutil.str( AV27SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSecfunctionalitytype.getInternalname(), "Values", cmbavSecfunctionalitytype.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersselector1.getItemCount() > 0 )
      {
         AV37DynamicFiltersSelector1 = cmbavDynamicfiltersselector1.getValidValue(AV37DynamicFiltersSelector1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37DynamicFiltersSelector1", AV37DynamicFiltersSelector1);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV37DynamicFiltersSelector1) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersoperator1.getItemCount() > 0 )
      {
         AV38DynamicFiltersOperator1 = (short)(GXutil.lval( cmbavDynamicfiltersoperator1.getValidValue(GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38DynamicFiltersOperator1), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersselector2.getItemCount() > 0 )
      {
         AV42DynamicFiltersSelector2 = cmbavDynamicfiltersselector2.getValidValue(AV42DynamicFiltersSelector2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42DynamicFiltersSelector2", AV42DynamicFiltersSelector2);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV42DynamicFiltersSelector2) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersoperator2.getItemCount() > 0 )
      {
         AV43DynamicFiltersOperator2 = (short)(GXutil.lval( cmbavDynamicfiltersoperator2.getValidValue(GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DynamicFiltersOperator2), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersselector3.getItemCount() > 0 )
      {
         AV47DynamicFiltersSelector3 = cmbavDynamicfiltersselector3.getValidValue(AV47DynamicFiltersSelector3) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersSelector3", AV47DynamicFiltersSelector3);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV47DynamicFiltersSelector3) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      }
      if ( cmbavDynamicfiltersoperator3.getItemCount() > 0 )
      {
         AV48DynamicFiltersOperator3 = (short)(GXutil.lval( cmbavDynamicfiltersoperator3.getValidValue(GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48DynamicFiltersOperator3), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2Y2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV86Pgmname = "WWPBaseObjects.SecRoleFunRoleActionAssociationWW" ;
      Gx_err = (short)(0) ;
      chkavIsassociatedold.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsassociatedold.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsassociatedold.getEnabled(), 5, 0), !bGXsfl_101_Refreshing);
   }

   public void rf2Y2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(101) ;
      /* Execute user event: Refresh */
      e242Y2 ();
      nGXsfl_101_idx = 1 ;
      sGXsfl_101_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_101_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1012( ) ;
      bGXsfl_101_Refreshing = true ;
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
         subsflControlProps_1012( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Byte.valueOf(AV27SecFunctionalityType) ,
                                              AV37DynamicFiltersSelector1 ,
                                              Short.valueOf(AV38DynamicFiltersOperator1) ,
                                              AV39SecFunctionalityDescription1 ,
                                              AV53SecParentFunctionalityDescription1 ,
                                              Boolean.valueOf(AV41DynamicFiltersEnabled2) ,
                                              AV42DynamicFiltersSelector2 ,
                                              Short.valueOf(AV43DynamicFiltersOperator2) ,
                                              AV44SecFunctionalityDescription2 ,
                                              AV54SecParentFunctionalityDescription2 ,
                                              Boolean.valueOf(AV46DynamicFiltersEnabled3) ,
                                              AV47DynamicFiltersSelector3 ,
                                              Short.valueOf(AV48DynamicFiltersOperator3) ,
                                              AV49SecFunctionalityDescription3 ,
                                              AV55SecParentFunctionalityDescription3 ,
                                              Byte.valueOf(A351SecFunctionalityType) ,
                                              A350SecFunctionalityDescription ,
                                              A353SecParentFunctionalityDescript ,
                                              Short.valueOf(AV35OrderedBy) ,
                                              Boolean.valueOf(AV36OrderedDsc) ,
                                              Long.valueOf(A63SecParentFunctionalityId) ,
                                              Long.valueOf(AV29SecParentFunctionalityId) } ,
                                              new int[]{
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                              TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.LONG
                                              }
         });
         lV39SecFunctionalityDescription1 = GXutil.concat( GXutil.rtrim( AV39SecFunctionalityDescription1), "%", "") ;
         lV39SecFunctionalityDescription1 = GXutil.concat( GXutil.rtrim( AV39SecFunctionalityDescription1), "%", "") ;
         lV53SecParentFunctionalityDescription1 = GXutil.concat( GXutil.rtrim( AV53SecParentFunctionalityDescription1), "%", "") ;
         lV53SecParentFunctionalityDescription1 = GXutil.concat( GXutil.rtrim( AV53SecParentFunctionalityDescription1), "%", "") ;
         lV44SecFunctionalityDescription2 = GXutil.concat( GXutil.rtrim( AV44SecFunctionalityDescription2), "%", "") ;
         lV44SecFunctionalityDescription2 = GXutil.concat( GXutil.rtrim( AV44SecFunctionalityDescription2), "%", "") ;
         lV54SecParentFunctionalityDescription2 = GXutil.concat( GXutil.rtrim( AV54SecParentFunctionalityDescription2), "%", "") ;
         lV54SecParentFunctionalityDescription2 = GXutil.concat( GXutil.rtrim( AV54SecParentFunctionalityDescription2), "%", "") ;
         lV49SecFunctionalityDescription3 = GXutil.concat( GXutil.rtrim( AV49SecFunctionalityDescription3), "%", "") ;
         lV49SecFunctionalityDescription3 = GXutil.concat( GXutil.rtrim( AV49SecFunctionalityDescription3), "%", "") ;
         lV55SecParentFunctionalityDescription3 = GXutil.concat( GXutil.rtrim( AV55SecParentFunctionalityDescription3), "%", "") ;
         lV55SecParentFunctionalityDescription3 = GXutil.concat( GXutil.rtrim( AV55SecParentFunctionalityDescription3), "%", "") ;
         /* Using cursor H002Y2 */
         pr_default.execute(0, new Object[] {Long.valueOf(AV29SecParentFunctionalityId), Byte.valueOf(AV27SecFunctionalityType), lV39SecFunctionalityDescription1, lV39SecFunctionalityDescription1, lV53SecParentFunctionalityDescription1, lV53SecParentFunctionalityDescription1, lV44SecFunctionalityDescription2, lV44SecFunctionalityDescription2, lV54SecParentFunctionalityDescription2, lV54SecParentFunctionalityDescription2, lV49SecFunctionalityDescription3, lV49SecFunctionalityDescription3, lV55SecParentFunctionalityDescription3, lV55SecParentFunctionalityDescription3, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_101_idx = 1 ;
         sGXsfl_101_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_101_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1012( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A62SecFunctionalityId = H002Y2_A62SecFunctionalityId[0] ;
            A353SecParentFunctionalityDescript = H002Y2_A353SecParentFunctionalityDescript[0] ;
            A349SecFunctionalityActive = H002Y2_A349SecFunctionalityActive[0] ;
            A63SecParentFunctionalityId = H002Y2_A63SecParentFunctionalityId[0] ;
            n63SecParentFunctionalityId = H002Y2_n63SecParentFunctionalityId[0] ;
            A351SecFunctionalityType = H002Y2_A351SecFunctionalityType[0] ;
            A350SecFunctionalityDescription = H002Y2_A350SecFunctionalityDescription[0] ;
            A64SecFunctionalityKey = H002Y2_A64SecFunctionalityKey[0] ;
            A353SecParentFunctionalityDescript = H002Y2_A353SecParentFunctionalityDescript[0] ;
            e252Y2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(101) ;
         wb2Y0( ) ;
      }
      bGXsfl_101_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2Y2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV86Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV86Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vSECROLEIDPARM", GXutil.ltrim( localUtil.ntoc( AV31SecRoleIdParm, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEIDPARM", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31SecRoleIdParm), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_SECFUNCTIONALITYID"+"_"+sGXsfl_101_idx, getSecureSignedToken( sGXsfl_101_idx, localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_101_idx, getSecureSignedToken( sGXsfl_101_idx, AV19IsAssociatedOld));
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
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Byte.valueOf(AV27SecFunctionalityType) ,
                                           AV37DynamicFiltersSelector1 ,
                                           Short.valueOf(AV38DynamicFiltersOperator1) ,
                                           AV39SecFunctionalityDescription1 ,
                                           AV53SecParentFunctionalityDescription1 ,
                                           Boolean.valueOf(AV41DynamicFiltersEnabled2) ,
                                           AV42DynamicFiltersSelector2 ,
                                           Short.valueOf(AV43DynamicFiltersOperator2) ,
                                           AV44SecFunctionalityDescription2 ,
                                           AV54SecParentFunctionalityDescription2 ,
                                           Boolean.valueOf(AV46DynamicFiltersEnabled3) ,
                                           AV47DynamicFiltersSelector3 ,
                                           Short.valueOf(AV48DynamicFiltersOperator3) ,
                                           AV49SecFunctionalityDescription3 ,
                                           AV55SecParentFunctionalityDescription3 ,
                                           Byte.valueOf(A351SecFunctionalityType) ,
                                           A350SecFunctionalityDescription ,
                                           A353SecParentFunctionalityDescript ,
                                           Short.valueOf(AV35OrderedBy) ,
                                           Boolean.valueOf(AV36OrderedDsc) ,
                                           Long.valueOf(A63SecParentFunctionalityId) ,
                                           Long.valueOf(AV29SecParentFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.LONG
                                           }
      });
      lV39SecFunctionalityDescription1 = GXutil.concat( GXutil.rtrim( AV39SecFunctionalityDescription1), "%", "") ;
      lV39SecFunctionalityDescription1 = GXutil.concat( GXutil.rtrim( AV39SecFunctionalityDescription1), "%", "") ;
      lV53SecParentFunctionalityDescription1 = GXutil.concat( GXutil.rtrim( AV53SecParentFunctionalityDescription1), "%", "") ;
      lV53SecParentFunctionalityDescription1 = GXutil.concat( GXutil.rtrim( AV53SecParentFunctionalityDescription1), "%", "") ;
      lV44SecFunctionalityDescription2 = GXutil.concat( GXutil.rtrim( AV44SecFunctionalityDescription2), "%", "") ;
      lV44SecFunctionalityDescription2 = GXutil.concat( GXutil.rtrim( AV44SecFunctionalityDescription2), "%", "") ;
      lV54SecParentFunctionalityDescription2 = GXutil.concat( GXutil.rtrim( AV54SecParentFunctionalityDescription2), "%", "") ;
      lV54SecParentFunctionalityDescription2 = GXutil.concat( GXutil.rtrim( AV54SecParentFunctionalityDescription2), "%", "") ;
      lV49SecFunctionalityDescription3 = GXutil.concat( GXutil.rtrim( AV49SecFunctionalityDescription3), "%", "") ;
      lV49SecFunctionalityDescription3 = GXutil.concat( GXutil.rtrim( AV49SecFunctionalityDescription3), "%", "") ;
      lV55SecParentFunctionalityDescription3 = GXutil.concat( GXutil.rtrim( AV55SecParentFunctionalityDescription3), "%", "") ;
      lV55SecParentFunctionalityDescription3 = GXutil.concat( GXutil.rtrim( AV55SecParentFunctionalityDescription3), "%", "") ;
      /* Using cursor H002Y3 */
      pr_default.execute(1, new Object[] {Long.valueOf(AV29SecParentFunctionalityId), Byte.valueOf(AV27SecFunctionalityType), lV39SecFunctionalityDescription1, lV39SecFunctionalityDescription1, lV53SecParentFunctionalityDescription1, lV53SecParentFunctionalityDescription1, lV44SecFunctionalityDescription2, lV44SecFunctionalityDescription2, lV54SecParentFunctionalityDescription2, lV54SecParentFunctionalityDescription2, lV49SecFunctionalityDescription3, lV49SecFunctionalityDescription3, lV55SecParentFunctionalityDescription3, lV55SecParentFunctionalityDescription3});
      GRID_nRecordCount = H002Y3_AGRID_nRecordCount[0] ;
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
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV86Pgmname = "WWPBaseObjects.SecRoleFunRoleActionAssociationWW" ;
      Gx_err = (short)(0) ;
      chkavIsassociatedold.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsassociatedold.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsassociatedold.getEnabled(), 5, 0), !bGXsfl_101_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2Y0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e232Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV71DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_101 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_101"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV78GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV79GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV80GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         /* Read variables values. */
         cmbavSecfunctionalitytype.setName( cmbavSecfunctionalitytype.getInternalname() );
         cmbavSecfunctionalitytype.setValue( httpContext.cgiGet( cmbavSecfunctionalitytype.getInternalname()) );
         AV27SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbavSecfunctionalitytype.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27SecFunctionalityType), 2, 0));
         cmbavDynamicfiltersselector1.setName( cmbavDynamicfiltersselector1.getInternalname() );
         cmbavDynamicfiltersselector1.setValue( httpContext.cgiGet( cmbavDynamicfiltersselector1.getInternalname()) );
         AV37DynamicFiltersSelector1 = httpContext.cgiGet( cmbavDynamicfiltersselector1.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37DynamicFiltersSelector1", AV37DynamicFiltersSelector1);
         cmbavDynamicfiltersoperator1.setName( cmbavDynamicfiltersoperator1.getInternalname() );
         cmbavDynamicfiltersoperator1.setValue( httpContext.cgiGet( cmbavDynamicfiltersoperator1.getInternalname()) );
         AV38DynamicFiltersOperator1 = (short)(GXutil.lval( httpContext.cgiGet( cmbavDynamicfiltersoperator1.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38DynamicFiltersOperator1), 4, 0));
         AV39SecFunctionalityDescription1 = httpContext.cgiGet( edtavSecfunctionalitydescription1_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39SecFunctionalityDescription1", AV39SecFunctionalityDescription1);
         AV53SecParentFunctionalityDescription1 = httpContext.cgiGet( edtavSecparentfunctionalitydescription1_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53SecParentFunctionalityDescription1", AV53SecParentFunctionalityDescription1);
         cmbavDynamicfiltersselector2.setName( cmbavDynamicfiltersselector2.getInternalname() );
         cmbavDynamicfiltersselector2.setValue( httpContext.cgiGet( cmbavDynamicfiltersselector2.getInternalname()) );
         AV42DynamicFiltersSelector2 = httpContext.cgiGet( cmbavDynamicfiltersselector2.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42DynamicFiltersSelector2", AV42DynamicFiltersSelector2);
         cmbavDynamicfiltersoperator2.setName( cmbavDynamicfiltersoperator2.getInternalname() );
         cmbavDynamicfiltersoperator2.setValue( httpContext.cgiGet( cmbavDynamicfiltersoperator2.getInternalname()) );
         AV43DynamicFiltersOperator2 = (short)(GXutil.lval( httpContext.cgiGet( cmbavDynamicfiltersoperator2.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DynamicFiltersOperator2), 4, 0));
         AV44SecFunctionalityDescription2 = httpContext.cgiGet( edtavSecfunctionalitydescription2_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44SecFunctionalityDescription2", AV44SecFunctionalityDescription2);
         AV54SecParentFunctionalityDescription2 = httpContext.cgiGet( edtavSecparentfunctionalitydescription2_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV54SecParentFunctionalityDescription2", AV54SecParentFunctionalityDescription2);
         cmbavDynamicfiltersselector3.setName( cmbavDynamicfiltersselector3.getInternalname() );
         cmbavDynamicfiltersselector3.setValue( httpContext.cgiGet( cmbavDynamicfiltersselector3.getInternalname()) );
         AV47DynamicFiltersSelector3 = httpContext.cgiGet( cmbavDynamicfiltersselector3.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersSelector3", AV47DynamicFiltersSelector3);
         cmbavDynamicfiltersoperator3.setName( cmbavDynamicfiltersoperator3.getInternalname() );
         cmbavDynamicfiltersoperator3.setValue( httpContext.cgiGet( cmbavDynamicfiltersoperator3.getInternalname()) );
         AV48DynamicFiltersOperator3 = (short)(GXutil.lval( httpContext.cgiGet( cmbavDynamicfiltersoperator3.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48DynamicFiltersOperator3), 4, 0));
         AV49SecFunctionalityDescription3 = httpContext.cgiGet( edtavSecfunctionalitydescription3_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49SecFunctionalityDescription3", AV49SecFunctionalityDescription3);
         AV55SecParentFunctionalityDescription3 = httpContext.cgiGet( edtavSecparentfunctionalitydescription3_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55SecParentFunctionalityDescription3", AV55SecParentFunctionalityDescription3);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vSECFUNCTIONALITYTYPE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV27SecFunctionalityType )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR1"), AV37DynamicFiltersSelector1) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV38DynamicFiltersOperator1 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECFUNCTIONALITYDESCRIPTION1"), AV39SecFunctionalityDescription1) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION1"), AV53SecParentFunctionalityDescription1) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR2"), AV42DynamicFiltersSelector2) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV43DynamicFiltersOperator2 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECFUNCTIONALITYDESCRIPTION2"), AV44SecFunctionalityDescription2) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION2"), AV54SecParentFunctionalityDescription2) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vDYNAMICFILTERSSELECTOR3"), AV47DynamicFiltersSelector3) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vDYNAMICFILTERSOPERATOR3"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) != AV48DynamicFiltersOperator3 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECFUNCTIONALITYDESCRIPTION3"), AV49SecFunctionalityDescription3) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vSECPARENTFUNCTIONALITYDESCRIPTION3"), AV55SecParentFunctionalityDescription3) != 0 )
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
      e232Y2 ();
      if (returnInSub) return;
   }

   public void e232Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV81CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      secrolefunroleactionassociationww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV81CliCod = GXt_int1 ;
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      lblJsdynamicfilters_Caption = "" ;
      httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
      AV37DynamicFiltersSelector1 = "SECFUNCTIONALITYDESCRIPTION" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37DynamicFiltersSelector1", AV37DynamicFiltersSelector1);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS1' */
      S112 ();
      if (returnInSub) return;
      AV42DynamicFiltersSelector2 = "SECFUNCTIONALITYDESCRIPTION" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42DynamicFiltersSelector2", AV42DynamicFiltersSelector2);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS2' */
      S122 ();
      if (returnInSub) return;
      AV47DynamicFiltersSelector3 = "SECFUNCTIONALITYDESCRIPTION" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersSelector3", AV47DynamicFiltersSelector3);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS3' */
      S132 ();
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
      AV27SecFunctionalityType = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27SecFunctionalityType), 2, 0));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( "Associated to Role", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S142 ();
      if (returnInSub) return;
      if ( AV35OrderedBy < 1 )
      {
         AV35OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S152 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV71DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV71DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      /* Using cursor H002Y4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV9SecRoleId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A65SecRoleId = H002Y4_A65SecRoleId[0] ;
         A354SecRoleDescription = H002Y4_A354SecRoleDescription[0] ;
         Form.setCaption( GXutil.format( httpContext.getMessage( "Associate Functionalities to Role :: %1", ""), A354SecRoleDescription, "", "", "", "", "", "", "", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
   }

   public void e242Y2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV81CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      secrolefunroleactionassociationww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV81CliCod = GXt_int1 ;
      GXv_SdtWWPContext5[0] = AV74WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV74WWPContext = GXv_SdtWWPContext5[0] ;
      cmbavDynamicfiltersoperator1.removeAllItems();
      if ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECFUNCTIONALITYDESCRIPTION") == 0 )
      {
         cmbavDynamicfiltersoperator1.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
         cmbavDynamicfiltersoperator1.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
      }
      else if ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
      {
         cmbavDynamicfiltersoperator1.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
         cmbavDynamicfiltersoperator1.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
      }
      if ( AV41DynamicFiltersEnabled2 )
      {
         cmbavDynamicfiltersoperator2.removeAllItems();
         if ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            cmbavDynamicfiltersoperator2.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
            cmbavDynamicfiltersoperator2.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
         }
         else if ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            cmbavDynamicfiltersoperator2.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
            cmbavDynamicfiltersoperator2.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
         }
         if ( AV46DynamicFiltersEnabled3 )
         {
            cmbavDynamicfiltersoperator3.removeAllItems();
            if ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECFUNCTIONALITYDESCRIPTION") == 0 )
            {
               cmbavDynamicfiltersoperator3.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
               cmbavDynamicfiltersoperator3.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
            }
            else if ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
            {
               cmbavDynamicfiltersoperator3.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
               cmbavDynamicfiltersoperator3.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
            }
         }
      }
      /* Execute user subroutine: 'LOAD LISTS' */
      S162 ();
      if (returnInSub) return;
      AV78GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78GridCurrentPage), 10, 0));
      AV79GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79GridPageCount), 10, 0));
      GXt_char6 = AV80GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV86Pgmname, GXv_char7) ;
      secrolefunroleactionassociationww_impl.this.GXt_char6 = GXv_char7[0] ;
      AV80GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80GridAppliedFilters", AV80GridAppliedFilters);
      /*  Sending Event outputs  */
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e112Y2( )
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
         AV77PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV77PageToGo) ;
      }
   }

   public void e122Y2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e132Y2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV35OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35OrderedBy), 4, 0));
         AV36OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36OrderedDsc", AV36OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S152 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e252Y2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV31SecRoleIdParm = AV9SecRoleId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31SecRoleIdParm", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31SecRoleIdParm), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEIDPARM", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31SecRoleIdParm), "ZZZ9")));
      AV19IsAssociatedOld = false ;
      httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_101_idx, getSecureSignedToken( sGXsfl_101_idx, AV19IsAssociatedOld));
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           AV37DynamicFiltersSelector1 ,
                                           Short.valueOf(AV38DynamicFiltersOperator1) ,
                                           AV53SecParentFunctionalityDescription1 ,
                                           Boolean.valueOf(AV41DynamicFiltersEnabled2) ,
                                           AV42DynamicFiltersSelector2 ,
                                           Short.valueOf(AV43DynamicFiltersOperator2) ,
                                           AV54SecParentFunctionalityDescription2 ,
                                           Boolean.valueOf(AV46DynamicFiltersEnabled3) ,
                                           AV47DynamicFiltersSelector3 ,
                                           Short.valueOf(AV48DynamicFiltersOperator3) ,
                                           AV55SecParentFunctionalityDescription3 ,
                                           A353SecParentFunctionalityDescript ,
                                           Long.valueOf(A62SecFunctionalityId) ,
                                           Short.valueOf(AV31SecRoleIdParm) ,
                                           Short.valueOf(A65SecRoleId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor H002Y5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A62SecFunctionalityId), Short.valueOf(AV31SecRoleIdParm)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A65SecRoleId = H002Y5_A65SecRoleId[0] ;
         AV19IsAssociatedOld = true ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_101_idx, getSecureSignedToken( sGXsfl_101_idx, AV19IsAssociatedOld));
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
      AV15SecFunctionalityIdToFind = A62SecFunctionalityId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15SecFunctionalityIdToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecFunctionalityIdToFind), 10, 0));
      if ( AV19IsAssociatedOld )
      {
         /* Execute user subroutine: 'FIND IN REMOVED' */
         S172 ();
         if (returnInSub) return;
      }
      else
      {
         /* Execute user subroutine: 'FIND IN ADDED' */
         S182 ();
         if (returnInSub) return;
      }
      if ( AV21i > 0 )
      {
         AV18IsAssociated = (boolean)(!AV19IsAssociatedOld) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
      }
      else
      {
         AV18IsAssociated = AV19IsAssociatedOld ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(101) ;
      }
      sendrow_1012( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_101_Refreshing )
      {
         httpContext.doAjaxLoad(101, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e142Y2 ();
      if (returnInSub) return;
   }

   public void e142Y2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOAD LISTS' */
      S162 ();
      if (returnInSub) return;
      AV17Success = true ;
      AV21i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      AV88GXV1 = 1 ;
      while ( AV88GXV1 <= AV11SecFunctionalityIdRemoved.size() )
      {
         AV14SecFunctionalityId = ((Number) AV11SecFunctionalityIdRemoved.elementAt(-1+AV88GXV1)).longValue() ;
         AV16SecFunctionalityRole = (web.wwpbaseobjects.SdtSecFunctionalityRole)new web.wwpbaseobjects.SdtSecFunctionalityRole( remoteHandle, context);
         AV16SecFunctionalityRole.Load(AV14SecFunctionalityId, AV9SecRoleId);
         if ( AV16SecFunctionalityRole.Success() )
         {
            AV16SecFunctionalityRole.Delete();
         }
         if ( ! AV16SecFunctionalityRole.Success() )
         {
            AV17Success = false ;
            /* Execute user subroutine: 'SHOW ERROR MESSAGES' */
            S192 ();
            if (returnInSub) return;
         }
         AV21i = (long)(AV21i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
         AV88GXV1 = (int)(AV88GXV1+1) ;
      }
      AV21i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      AV89GXV2 = 1 ;
      while ( AV89GXV2 <= AV10SecFunctionalityIdAdded.size() )
      {
         AV14SecFunctionalityId = ((Number) AV10SecFunctionalityIdAdded.elementAt(-1+AV89GXV2)).longValue() ;
         AV16SecFunctionalityRole = (web.wwpbaseobjects.SdtSecFunctionalityRole)new web.wwpbaseobjects.SdtSecFunctionalityRole( remoteHandle, context);
         AV16SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Secroleid( AV9SecRoleId );
         AV16SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid( AV14SecFunctionalityId );
         AV16SecFunctionalityRole.Save();
         if ( ! AV16SecFunctionalityRole.Success() )
         {
            AV17Success = false ;
            /* Execute user subroutine: 'SHOW ERROR MESSAGES' */
            S192 ();
            if (returnInSub) return;
         }
         AV21i = (long)(AV21i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
         AV89GXV2 = (int)(AV89GXV2+1) ;
      }
      if ( AV17Success )
      {
         if ( AV10SecFunctionalityIdAdded.size() + AV11SecFunctionalityIdRemoved.size() > 0 )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secrolefunroleactionassociationww");
            AV12SecFunctionalityIdAddedXml = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12SecFunctionalityIdAddedXml", AV12SecFunctionalityIdAddedXml);
            AV13SecFunctionalityIdRemovedXml = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13SecFunctionalityIdRemovedXml", AV13SecFunctionalityIdRemovedXml);
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_DataSuccessfulyUpdated", ""));
         }
         else
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_NoChangesMade", ""));
         }
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV16SecFunctionalityRole", AV16SecFunctionalityRole);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e182Y2( )
   {
      /* 'AddDynamicFilters1' Routine */
      returnInSub = false ;
      AV41DynamicFiltersEnabled2 = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41DynamicFiltersEnabled2", AV41DynamicFiltersEnabled2);
      imgAdddynamicfilters1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters1_Visible), 5, 0), true);
      imgRemovedynamicfilters1_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters1_Visible), 5, 0), true);
      gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      /*  Sending Event outputs  */
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e152Y2( )
   {
      /* 'RemoveDynamicFilters1' Routine */
      returnInSub = false ;
      AV51DynamicFiltersRemoving = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersRemoving", AV51DynamicFiltersRemoving);
      AV52DynamicFiltersIgnoreFirst = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52DynamicFiltersIgnoreFirst", AV52DynamicFiltersIgnoreFirst);
      /* Execute user subroutine: 'SAVEDYNFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETDYNFILTERS' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S142 ();
      if (returnInSub) return;
      AV51DynamicFiltersRemoving = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersRemoving", AV51DynamicFiltersRemoving);
      AV52DynamicFiltersIgnoreFirst = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52DynamicFiltersIgnoreFirst", AV52DynamicFiltersIgnoreFirst);
      gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32GridState", AV32GridState);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV42DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV47DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV37DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e192Y2( )
   {
      /* Dynamicfiltersselector1_Click Routine */
      returnInSub = false ;
      AV38DynamicFiltersOperator1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38DynamicFiltersOperator1), 4, 0));
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS1' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
   }

   public void e202Y2( )
   {
      /* 'AddDynamicFilters2' Routine */
      returnInSub = false ;
      AV46DynamicFiltersEnabled3 = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersEnabled3", AV46DynamicFiltersEnabled3);
      imgAdddynamicfilters2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters2_Visible), 5, 0), true);
      imgRemovedynamicfilters2_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters2_Visible), 5, 0), true);
      gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      /*  Sending Event outputs  */
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e162Y2( )
   {
      /* 'RemoveDynamicFilters2' Routine */
      returnInSub = false ;
      AV51DynamicFiltersRemoving = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersRemoving", AV51DynamicFiltersRemoving);
      AV41DynamicFiltersEnabled2 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41DynamicFiltersEnabled2", AV41DynamicFiltersEnabled2);
      /* Execute user subroutine: 'SAVEDYNFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETDYNFILTERS' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S142 ();
      if (returnInSub) return;
      AV51DynamicFiltersRemoving = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersRemoving", AV51DynamicFiltersRemoving);
      gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32GridState", AV32GridState);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV42DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV47DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV37DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e212Y2( )
   {
      /* Dynamicfiltersselector2_Click Routine */
      returnInSub = false ;
      AV43DynamicFiltersOperator2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DynamicFiltersOperator2), 4, 0));
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS2' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
   }

   public void e172Y2( )
   {
      /* 'RemoveDynamicFilters3' Routine */
      returnInSub = false ;
      AV51DynamicFiltersRemoving = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersRemoving", AV51DynamicFiltersRemoving);
      AV46DynamicFiltersEnabled3 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersEnabled3", AV46DynamicFiltersEnabled3);
      /* Execute user subroutine: 'SAVEDYNFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETDYNFILTERS' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADDYNFILTERSSTATE' */
      S142 ();
      if (returnInSub) return;
      AV51DynamicFiltersRemoving = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51DynamicFiltersRemoving", AV51DynamicFiltersRemoving);
      gxgrgrid_refresh( subGrid_Rows, AV27SecFunctionalityType, AV37DynamicFiltersSelector1, AV38DynamicFiltersOperator1, AV39SecFunctionalityDescription1, AV53SecParentFunctionalityDescription1, AV42DynamicFiltersSelector2, AV43DynamicFiltersOperator2, AV44SecFunctionalityDescription2, AV54SecParentFunctionalityDescription2, AV47DynamicFiltersSelector3, AV48DynamicFiltersOperator3, AV49SecFunctionalityDescription3, AV55SecParentFunctionalityDescription3, AV29SecParentFunctionalityId, AV41DynamicFiltersEnabled2, AV46DynamicFiltersEnabled3, AV86Pgmname, AV13SecFunctionalityIdRemovedXml, AV12SecFunctionalityIdAddedXml, AV9SecRoleId, A65SecRoleId, AV21i, AV11SecFunctionalityIdRemoved, AV15SecFunctionalityIdToFind, AV10SecFunctionalityIdAdded, AV31SecRoleIdParm) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32GridState", AV32GridState);
      cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV42DynamicFiltersSelector2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV47DynamicFiltersSelector3) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
      cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV37DynamicFiltersSelector1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
      cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void e222Y2( )
   {
      /* Dynamicfiltersselector3_Click Routine */
      returnInSub = false ;
      AV48DynamicFiltersOperator3 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48DynamicFiltersOperator3), 4, 0));
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS3' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
   }

   public void e262Y2( )
   {
      /* Isassociated_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOAD LISTS' */
      S162 ();
      if (returnInSub) return;
      AV15SecFunctionalityIdToFind = A62SecFunctionalityId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15SecFunctionalityIdToFind", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecFunctionalityIdToFind), 10, 0));
      if ( AV18IsAssociated )
      {
         if ( AV19IsAssociatedOld )
         {
            /* Execute user subroutine: 'FIND IN REMOVED' */
            S172 ();
            if (returnInSub) return;
            AV11SecFunctionalityIdRemoved.removeItem((int)(AV21i));
         }
         else
         {
            AV10SecFunctionalityIdAdded.add((long)(AV15SecFunctionalityIdToFind), 0);
         }
      }
      else
      {
         if ( AV19IsAssociatedOld )
         {
            AV11SecFunctionalityIdRemoved.add((long)(AV15SecFunctionalityIdToFind), 0);
         }
         else
         {
            /* Execute user subroutine: 'FIND IN ADDED' */
            S182 ();
            if (returnInSub) return;
            AV10SecFunctionalityIdAdded.removeItem((int)(AV21i));
         }
      }
      /* Execute user subroutine: 'SAVE LISTS' */
      S222 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11SecFunctionalityIdRemoved", AV11SecFunctionalityIdRemoved);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV10SecFunctionalityIdAdded", AV10SecFunctionalityIdAdded);
   }

   public void S152( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV35OrderedBy, 4, 0))+":"+(AV36OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S112( )
   {
      /* 'ENABLEDYNAMICFILTERS1' Routine */
      returnInSub = false ;
      edtavSecfunctionalitydescription1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecfunctionalitydescription1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecfunctionalitydescription1_Visible), 5, 0), true);
      edtavSecparentfunctionalitydescription1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecparentfunctionalitydescription1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecparentfunctionalitydescription1_Visible), 5, 0), true);
      cmbavDynamicfiltersoperator1.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator1.getVisible(), 5, 0), true);
      if ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECFUNCTIONALITYDESCRIPTION") == 0 )
      {
         edtavSecfunctionalitydescription1_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecfunctionalitydescription1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecfunctionalitydescription1_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator1.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator1.getVisible(), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
      {
         edtavSecparentfunctionalitydescription1_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecparentfunctionalitydescription1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecparentfunctionalitydescription1_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator1.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator1.getVisible(), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'ENABLEDYNAMICFILTERS2' Routine */
      returnInSub = false ;
      edtavSecfunctionalitydescription2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecfunctionalitydescription2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecfunctionalitydescription2_Visible), 5, 0), true);
      edtavSecparentfunctionalitydescription2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecparentfunctionalitydescription2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecparentfunctionalitydescription2_Visible), 5, 0), true);
      cmbavDynamicfiltersoperator2.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator2.getVisible(), 5, 0), true);
      if ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECFUNCTIONALITYDESCRIPTION") == 0 )
      {
         edtavSecfunctionalitydescription2_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecfunctionalitydescription2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecfunctionalitydescription2_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator2.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator2.getVisible(), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
      {
         edtavSecparentfunctionalitydescription2_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecparentfunctionalitydescription2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecparentfunctionalitydescription2_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator2.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator2.getVisible(), 5, 0), true);
      }
   }

   public void S132( )
   {
      /* 'ENABLEDYNAMICFILTERS3' Routine */
      returnInSub = false ;
      edtavSecfunctionalitydescription3_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecfunctionalitydescription3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecfunctionalitydescription3_Visible), 5, 0), true);
      edtavSecparentfunctionalitydescription3_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecparentfunctionalitydescription3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecparentfunctionalitydescription3_Visible), 5, 0), true);
      cmbavDynamicfiltersoperator3.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator3.getVisible(), 5, 0), true);
      if ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECFUNCTIONALITYDESCRIPTION") == 0 )
      {
         edtavSecfunctionalitydescription3_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecfunctionalitydescription3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecfunctionalitydescription3_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator3.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator3.getVisible(), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
      {
         edtavSecparentfunctionalitydescription3_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecparentfunctionalitydescription3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecparentfunctionalitydescription3_Visible), 5, 0), true);
         cmbavDynamicfiltersoperator3.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDynamicfiltersoperator3.getVisible(), 5, 0), true);
      }
   }

   public void S212( )
   {
      /* 'RESETDYNFILTERS' Routine */
      returnInSub = false ;
      AV41DynamicFiltersEnabled2 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41DynamicFiltersEnabled2", AV41DynamicFiltersEnabled2);
      AV42DynamicFiltersSelector2 = "SECFUNCTIONALITYDESCRIPTION" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42DynamicFiltersSelector2", AV42DynamicFiltersSelector2);
      AV43DynamicFiltersOperator2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DynamicFiltersOperator2), 4, 0));
      AV44SecFunctionalityDescription2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44SecFunctionalityDescription2", AV44SecFunctionalityDescription2);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS2' */
      S122 ();
      if (returnInSub) return;
      AV46DynamicFiltersEnabled3 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersEnabled3", AV46DynamicFiltersEnabled3);
      AV47DynamicFiltersSelector3 = "SECFUNCTIONALITYDESCRIPTION" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersSelector3", AV47DynamicFiltersSelector3);
      AV48DynamicFiltersOperator3 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48DynamicFiltersOperator3), 4, 0));
      AV49SecFunctionalityDescription3 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49SecFunctionalityDescription3", AV49SecFunctionalityDescription3);
      /* Execute user subroutine: 'ENABLEDYNAMICFILTERS3' */
      S132 ();
      if (returnInSub) return;
   }

   public void S142( )
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
      if ( AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 1 )
      {
         AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+1));
         AV37DynamicFiltersSelector1 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37DynamicFiltersSelector1", AV37DynamicFiltersSelector1);
         if ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV38DynamicFiltersOperator1 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38DynamicFiltersOperator1), 4, 0));
            AV39SecFunctionalityDescription1 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39SecFunctionalityDescription1", AV39SecFunctionalityDescription1);
         }
         else if ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV38DynamicFiltersOperator1 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38DynamicFiltersOperator1), 4, 0));
            AV53SecParentFunctionalityDescription1 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53SecParentFunctionalityDescription1", AV53SecParentFunctionalityDescription1);
         }
         /* Execute user subroutine: 'ENABLEDYNAMICFILTERS1' */
         S112 ();
         if (returnInSub) return;
         if ( AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 2 )
         {
            lblJsdynamicfilters_Caption = "<script type=\"text/javascript\">$(document).ready(function() {" ;
            httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
            lblJsdynamicfilters_Caption = lblJsdynamicfilters_Caption+GXutil.format( "WWPDynFilterShow_AL('%1', 2, 0);", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
            httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
            imgAdddynamicfilters1_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters1_Visible), 5, 0), true);
            imgRemovedynamicfilters1_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters1_Visible), 5, 0), true);
            AV41DynamicFiltersEnabled2 = true ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41DynamicFiltersEnabled2", AV41DynamicFiltersEnabled2);
            AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+2));
            AV42DynamicFiltersSelector2 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42DynamicFiltersSelector2", AV42DynamicFiltersSelector2);
            if ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECFUNCTIONALITYDESCRIPTION") == 0 )
            {
               AV43DynamicFiltersOperator2 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV43DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DynamicFiltersOperator2), 4, 0));
               AV44SecFunctionalityDescription2 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV44SecFunctionalityDescription2", AV44SecFunctionalityDescription2);
            }
            else if ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
            {
               AV43DynamicFiltersOperator2 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV43DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DynamicFiltersOperator2), 4, 0));
               AV54SecParentFunctionalityDescription2 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV54SecParentFunctionalityDescription2", AV54SecParentFunctionalityDescription2);
            }
            /* Execute user subroutine: 'ENABLEDYNAMICFILTERS2' */
            S122 ();
            if (returnInSub) return;
            if ( AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 3 )
            {
               lblJsdynamicfilters_Caption = lblJsdynamicfilters_Caption+GXutil.format( "WWPDynFilterShow_AL('%1', 3, 0);", divTabledynamicfilters_Internalname, "", "", "", "", "", "", "", "") ;
               httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
               imgAdddynamicfilters2_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, imgAdddynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAdddynamicfilters2_Visible), 5, 0), true);
               imgRemovedynamicfilters2_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, imgRemovedynamicfilters2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgRemovedynamicfilters2_Visible), 5, 0), true);
               AV46DynamicFiltersEnabled3 = true ;
               httpContext.ajax_rsp_assign_attri("", false, "AV46DynamicFiltersEnabled3", AV46DynamicFiltersEnabled3);
               AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+3));
               AV47DynamicFiltersSelector3 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersSelector3", AV47DynamicFiltersSelector3);
               if ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECFUNCTIONALITYDESCRIPTION") == 0 )
               {
                  AV48DynamicFiltersOperator3 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV48DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48DynamicFiltersOperator3), 4, 0));
                  AV49SecFunctionalityDescription3 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV49SecFunctionalityDescription3", AV49SecFunctionalityDescription3);
               }
               else if ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
               {
                  AV48DynamicFiltersOperator3 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV48DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48DynamicFiltersOperator3), 4, 0));
                  AV55SecParentFunctionalityDescription3 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV55SecParentFunctionalityDescription3", AV55SecParentFunctionalityDescription3);
               }
               /* Execute user subroutine: 'ENABLEDYNAMICFILTERS3' */
               S132 ();
               if (returnInSub) return;
            }
            lblJsdynamicfilters_Caption = lblJsdynamicfilters_Caption+"});</script>" ;
            httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
         }
      }
      if ( AV51DynamicFiltersRemoving )
      {
         lblJsdynamicfilters_Caption = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblJsdynamicfilters_Internalname, "Caption", lblJsdynamicfilters_Caption, true);
      }
   }

   public void S202( )
   {
      /* 'SAVEDYNFILTERSSTATE' Routine */
      returnInSub = false ;
      AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().clear();
      if ( ! AV52DynamicFiltersIgnoreFirst )
      {
         AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
         AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Selected( AV37DynamicFiltersSelector1 );
         if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ! (GXutil.strcmp("", AV39SecFunctionalityDescription1)==0) )
         {
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Functionality Description", "") );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV39SecFunctionalityDescription1 );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV38DynamicFiltersOperator1 );
         }
         else if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ! (GXutil.strcmp("", AV53SecParentFunctionalityDescription1)==0) )
         {
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Parent Functionality", "") );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV53SecParentFunctionalityDescription1 );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV38DynamicFiltersOperator1 );
         }
         if ( AV51DynamicFiltersRemoving || ! (GXutil.strcmp("", AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value())==0) )
         {
            AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().add(AV34GridStateDynamicFilter, 0);
         }
      }
      if ( AV41DynamicFiltersEnabled2 )
      {
         AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
         AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Selected( AV42DynamicFiltersSelector2 );
         if ( ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ! (GXutil.strcmp("", AV44SecFunctionalityDescription2)==0) )
         {
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Functionality Description", "") );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV44SecFunctionalityDescription2 );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV43DynamicFiltersOperator2 );
         }
         else if ( ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ! (GXutil.strcmp("", AV54SecParentFunctionalityDescription2)==0) )
         {
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Parent Functionality", "") );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV54SecParentFunctionalityDescription2 );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV43DynamicFiltersOperator2 );
         }
         if ( AV51DynamicFiltersRemoving || ! (GXutil.strcmp("", AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value())==0) )
         {
            AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().add(AV34GridStateDynamicFilter, 0);
         }
      }
      if ( AV46DynamicFiltersEnabled3 )
      {
         AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
         AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Selected( AV47DynamicFiltersSelector3 );
         if ( ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ! (GXutil.strcmp("", AV49SecFunctionalityDescription3)==0) )
         {
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Functionality Description", "") );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV49SecFunctionalityDescription3 );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV48DynamicFiltersOperator3 );
         }
         else if ( ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ! (GXutil.strcmp("", AV55SecParentFunctionalityDescription3)==0) )
         {
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Dsc( httpContext.getMessage( "Parent Functionality", "") );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Value( AV55SecParentFunctionalityDescription3 );
            AV34GridStateDynamicFilter.setgxTv_SdtWWPGridState_DynamicFilter_Operator( AV48DynamicFiltersOperator3 );
         }
         if ( AV51DynamicFiltersRemoving || ! (GXutil.strcmp("", AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value())==0) )
         {
            AV32GridState.getgxTv_SdtWWPGridState_Dynamicfilters().add(AV34GridStateDynamicFilter, 0);
         }
      }
   }

   public void S182( )
   {
      /* 'FIND IN ADDED' Routine */
      returnInSub = false ;
      AV21i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      AV90GXV3 = 1 ;
      while ( AV90GXV3 <= AV10SecFunctionalityIdAdded.size() )
      {
         AV14SecFunctionalityId = ((Number) AV10SecFunctionalityIdAdded.elementAt(-1+AV90GXV3)).longValue() ;
         if ( AV14SecFunctionalityId == AV15SecFunctionalityIdToFind )
         {
            if (true) break;
         }
         AV21i = (long)(AV21i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
         AV90GXV3 = (int)(AV90GXV3+1) ;
      }
      if ( AV21i > AV10SecFunctionalityIdAdded.size() )
      {
         AV21i = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      }
   }

   public void S172( )
   {
      /* 'FIND IN REMOVED' Routine */
      returnInSub = false ;
      AV21i = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      AV91GXV4 = 1 ;
      while ( AV91GXV4 <= AV11SecFunctionalityIdRemoved.size() )
      {
         AV14SecFunctionalityId = ((Number) AV11SecFunctionalityIdRemoved.elementAt(-1+AV91GXV4)).longValue() ;
         if ( AV14SecFunctionalityId == AV15SecFunctionalityIdToFind )
         {
            if (true) break;
         }
         AV21i = (long)(AV21i+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
         AV91GXV4 = (int)(AV91GXV4+1) ;
      }
      if ( AV21i > AV11SecFunctionalityIdRemoved.size() )
      {
         AV21i = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21i), 10, 0));
      }
   }

   public void S162( )
   {
      /* 'LOAD LISTS' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV13SecFunctionalityIdRemovedXml)==0) )
      {
         AV11SecFunctionalityIdRemoved.fromxml(AV13SecFunctionalityIdRemovedXml, null, null);
      }
      if ( ! (GXutil.strcmp("", AV12SecFunctionalityIdAddedXml)==0) )
      {
         AV10SecFunctionalityIdAdded.fromxml(AV12SecFunctionalityIdAddedXml, null, null);
      }
   }

   public void S222( )
   {
      /* 'SAVE LISTS' Routine */
      returnInSub = false ;
      if ( AV11SecFunctionalityIdRemoved.size() > 0 )
      {
         AV13SecFunctionalityIdRemovedXml = AV11SecFunctionalityIdRemoved.toxml(false, true, "Collection", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13SecFunctionalityIdRemovedXml", AV13SecFunctionalityIdRemovedXml);
      }
      else
      {
         AV13SecFunctionalityIdRemovedXml = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13SecFunctionalityIdRemovedXml", AV13SecFunctionalityIdRemovedXml);
      }
      if ( AV10SecFunctionalityIdAdded.size() > 0 )
      {
         AV12SecFunctionalityIdAddedXml = AV10SecFunctionalityIdAdded.toxml(false, true, "Collection", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12SecFunctionalityIdAddedXml", AV12SecFunctionalityIdAddedXml);
      }
      else
      {
         AV12SecFunctionalityIdAddedXml = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12SecFunctionalityIdAddedXml", AV12SecFunctionalityIdAddedXml);
      }
   }

   public void S192( )
   {
      /* 'SHOW ERROR MESSAGES' Routine */
      returnInSub = false ;
      AV93GXV6 = 1 ;
      AV92GXV5 = AV16SecFunctionalityRole.GetMessages() ;
      while ( AV93GXV6 <= AV92GXV5.size() )
      {
         AV20Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV92GXV5.elementAt(-1+AV93GXV6));
         if ( AV20Message.getgxTv_SdtMessages_Message_Type() == 1 )
         {
            httpContext.GX_msglist.addItem(AV20Message.getgxTv_SdtMessages_Message_Description());
         }
         AV93GXV6 = (int)(AV93GXV6+1) ;
      }
   }

   public void wb_table1_15_2Y2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableDynamicFilters'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSecfunctionalitytype.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavSecfunctionalitytype.getInternalname(), httpContext.getMessage( "Type", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSecfunctionalitytype, cmbavSecfunctionalitytype.getInternalname(), GXutil.trim( GXutil.str( AV27SecFunctionalityType, 2, 0)), 1, cmbavSecfunctionalitytype.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavSecfunctionalitytype.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         cmbavSecfunctionalitytype.setValue( GXutil.trim( GXutil.str( AV27SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSecfunctionalitytype.getInternalname(), "Values", cmbavSecfunctionalitytype.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabledynamicfilters_Internalname, 1, 0, "px", 0, "px", "TableDynamicFiltersFlex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DynRowVisible", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabledynamicfiltersrow1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersprefix1_Internalname, httpContext.getMessage( "WWP_DynFilterPrefix", ""), "", "", lblDynamicfiltersprefix1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescriptionPrefix", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersselector1.getInternalname(), httpContext.getMessage( "Dynamic Filters Selector1", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersselector1, cmbavDynamicfiltersselector1.getInternalname(), GXutil.rtrim( AV37DynamicFiltersSelector1), 1, cmbavDynamicfiltersselector1.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVDYNAMICFILTERSSELECTOR1.CLICK."+"'", "svchar", "", 1, cmbavDynamicfiltersselector1.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         cmbavDynamicfiltersselector1.setValue( GXutil.rtrim( AV37DynamicFiltersSelector1) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector1.getInternalname(), "Values", cmbavDynamicfiltersselector1.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersmiddle1_Internalname, httpContext.getMessage( "WWP_DynFilterMiddle", ""), "", "", lblDynamicfiltersmiddle1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table2_33_2Y2( true) ;
      }
      else
      {
         wb_table2_33_2Y2( false) ;
      }
      return  ;
   }

   public void wb_table2_33_2Y2e( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersprefix2_Internalname, httpContext.getMessage( "WWP_DynFilterPrefix", ""), "", "", lblDynamicfiltersprefix2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescriptionPrefix", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersselector2.getInternalname(), httpContext.getMessage( "Dynamic Filters Selector2", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersselector2, cmbavDynamicfiltersselector2.getInternalname(), GXutil.rtrim( AV42DynamicFiltersSelector2), 1, cmbavDynamicfiltersselector2.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVDYNAMICFILTERSSELECTOR2.CLICK."+"'", "svchar", "", 1, cmbavDynamicfiltersselector2.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         cmbavDynamicfiltersselector2.setValue( GXutil.rtrim( AV42DynamicFiltersSelector2) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector2.getInternalname(), "Values", cmbavDynamicfiltersselector2.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersmiddle2_Internalname, httpContext.getMessage( "WWP_DynFilterMiddle", ""), "", "", lblDynamicfiltersmiddle2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         wb_table3_58_2Y2( true) ;
      }
      else
      {
         wb_table3_58_2Y2( false) ;
      }
      return  ;
   }

   public void wb_table3_58_2Y2e( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersprefix3_Internalname, httpContext.getMessage( "WWP_DynFilterPrefix", ""), "", "", lblDynamicfiltersprefix3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescriptionPrefix", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDynamicfiltersselector3.getInternalname(), httpContext.getMessage( "Dynamic Filters Selector3", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersselector3, cmbavDynamicfiltersselector3.getInternalname(), GXutil.rtrim( AV47DynamicFiltersSelector3), 1, cmbavDynamicfiltersselector3.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVDYNAMICFILTERSSELECTOR3.CLICK."+"'", "svchar", "", 1, cmbavDynamicfiltersselector3.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         cmbavDynamicfiltersselector3.setValue( GXutil.rtrim( AV47DynamicFiltersSelector3) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersselector3.getInternalname(), "Values", cmbavDynamicfiltersselector3.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblDynamicfiltersmiddle3_Internalname, httpContext.getMessage( "WWP_DynFilterMiddle", ""), "", "", lblDynamicfiltersmiddle3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataFilterDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_83_2Y2( true) ;
      }
      else
      {
         wb_table4_83_2Y2( false) ;
      }
      return  ;
   }

   public void wb_table4_83_2Y2e( boolean wbgen )
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
         wb_table1_15_2Y2e( true) ;
      }
      else
      {
         wb_table1_15_2Y2e( false) ;
      }
   }

   public void wb_table4_83_2Y2( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersoperator3, cmbavDynamicfiltersoperator3.getInternalname(), GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)), 1, cmbavDynamicfiltersoperator3.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavDynamicfiltersoperator3.getVisible(), cmbavDynamicfiltersoperator3.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         cmbavDynamicfiltersoperator3.setValue( GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator3.getInternalname(), "Values", cmbavDynamicfiltersoperator3.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secfunctionalitydescription3_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecfunctionalitydescription3_Internalname, httpContext.getMessage( "Sec Functionality Description3", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecfunctionalitydescription3_Internalname, AV49SecFunctionalityDescription3, GXutil.rtrim( localUtil.format( AV49SecFunctionalityDescription3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,90);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecfunctionalitydescription3_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecfunctionalitydescription3_Visible, edtavSecfunctionalitydescription3_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secparentfunctionalitydescription3_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecparentfunctionalitydescription3_Internalname, httpContext.getMessage( "Sec Parent Functionality Description3", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecparentfunctionalitydescription3_Internalname, AV55SecParentFunctionalityDescription3, GXutil.rtrim( localUtil.format( AV55SecParentFunctionalityDescription3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecparentfunctionalitydescription3_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecparentfunctionalitydescription3_Visible, edtavSecparentfunctionalitydescription3_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_removefilter3_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgRemovedynamicfilters3_gximage, "")==0) ? "GX_Image_ActionRemoveDynamicFilter_Class" : "GX_Image_"+imgRemovedynamicfilters3_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "11a6ef14-1a5a-4077-91a2-f41ed9a3a662", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgRemovedynamicfilters3_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", httpContext.getMessage( "WWP_DynFilterRemoveTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgRemovedynamicfilters3_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'REMOVEDYNAMICFILTERS3\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_83_2Y2e( true) ;
      }
      else
      {
         wb_table4_83_2Y2e( false) ;
      }
   }

   public void wb_table3_58_2Y2( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersoperator2, cmbavDynamicfiltersoperator2.getInternalname(), GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)), 1, cmbavDynamicfiltersoperator2.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavDynamicfiltersoperator2.getVisible(), cmbavDynamicfiltersoperator2.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         cmbavDynamicfiltersoperator2.setValue( GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator2.getInternalname(), "Values", cmbavDynamicfiltersoperator2.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secfunctionalitydescription2_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecfunctionalitydescription2_Internalname, httpContext.getMessage( "Sec Functionality Description2", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecfunctionalitydescription2_Internalname, AV44SecFunctionalityDescription2, GXutil.rtrim( localUtil.format( AV44SecFunctionalityDescription2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,65);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecfunctionalitydescription2_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecfunctionalitydescription2_Visible, edtavSecfunctionalitydescription2_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secparentfunctionalitydescription2_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecparentfunctionalitydescription2_Internalname, httpContext.getMessage( "Sec Parent Functionality Description2", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecparentfunctionalitydescription2_Internalname, AV54SecParentFunctionalityDescription2, GXutil.rtrim( localUtil.format( AV54SecParentFunctionalityDescription2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecparentfunctionalitydescription2_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecparentfunctionalitydescription2_Visible, edtavSecparentfunctionalitydescription2_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_addfilter2_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgAdddynamicfilters2_gximage, "")==0) ? "GX_Image_ActionNewDynamicFilter_Class" : "GX_Image_"+imgAdddynamicfilters2_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "27283ea5-332f-423b-b880-64b762622df3", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgAdddynamicfilters2_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgAdddynamicfilters2_Visible, 1, "", httpContext.getMessage( "WWP_DynFilterAddTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgAdddynamicfilters2_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'ADDDYNAMICFILTERS2\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_removefilter2_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgRemovedynamicfilters2_gximage, "")==0) ? "GX_Image_ActionRemoveDynamicFilter_Class" : "GX_Image_"+imgRemovedynamicfilters2_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "11a6ef14-1a5a-4077-91a2-f41ed9a3a662", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgRemovedynamicfilters2_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgRemovedynamicfilters2_Visible, 1, "", httpContext.getMessage( "WWP_DynFilterRemoveTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgRemovedynamicfilters2_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'REMOVEDYNAMICFILTERS2\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_58_2Y2e( true) ;
      }
      else
      {
         wb_table3_58_2Y2e( false) ;
      }
   }

   public void wb_table2_33_2Y2( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDynamicfiltersoperator1, cmbavDynamicfiltersoperator1.getInternalname(), GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)), 1, cmbavDynamicfiltersoperator1.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavDynamicfiltersoperator1.getVisible(), cmbavDynamicfiltersoperator1.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         cmbavDynamicfiltersoperator1.setValue( GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDynamicfiltersoperator1.getInternalname(), "Values", cmbavDynamicfiltersoperator1.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secfunctionalitydescription1_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecfunctionalitydescription1_Internalname, httpContext.getMessage( "Sec Functionality Description1", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecfunctionalitydescription1_Internalname, AV39SecFunctionalityDescription1, GXutil.rtrim( localUtil.format( AV39SecFunctionalityDescription1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecfunctionalitydescription1_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecfunctionalitydescription1_Visible, edtavSecfunctionalitydescription1_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellFilter_secparentfunctionalitydescription1_cell_Internalname+"\"  class=''>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSecparentfunctionalitydescription1_Internalname, httpContext.getMessage( "Sec Parent Functionality Description1", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'" + sGXsfl_101_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSecparentfunctionalitydescription1_Internalname, AV53SecParentFunctionalityDescription1, GXutil.rtrim( localUtil.format( AV53SecParentFunctionalityDescription1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecparentfunctionalitydescription1_Jsonclick, 0, "Attribute", "", "", "", "", edtavSecparentfunctionalitydescription1_Visible, edtavSecparentfunctionalitydescription1_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_addfilter1_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgAdddynamicfilters1_gximage, "")==0) ? "GX_Image_ActionNewDynamicFilter_Class" : "GX_Image_"+imgAdddynamicfilters1_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "27283ea5-332f-423b-b880-64b762622df3", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgAdddynamicfilters1_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgAdddynamicfilters1_Visible, 1, "", httpContext.getMessage( "WWP_DynFilterAddTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgAdddynamicfilters1_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'ADDDYNAMICFILTERS1\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellDynamicfilters_removefilter1_cell_Internalname+"\"  class=''>") ;
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgRemovedynamicfilters1_gximage, "")==0) ? "GX_Image_ActionRemoveDynamicFilter_Class" : "GX_Image_"+imgRemovedynamicfilters1_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "11a6ef14-1a5a-4077-91a2-f41ed9a3a662", "", context.getHttpContext().getTheme( )) ;
         web.GxWebStd.gx_bitmap( httpContext, imgRemovedynamicfilters1_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgRemovedynamicfilters1_Visible, 1, "", httpContext.getMessage( "WWP_DynFilterRemoveTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgRemovedynamicfilters1_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'REMOVEDYNAMICFILTERS1\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecRoleFunRoleActionAssociationWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_33_2Y2e( true) ;
      }
      else
      {
         wb_table2_33_2Y2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV9SecRoleId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9SecRoleId), "ZZZ9")));
      AV29SecParentFunctionalityId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29SecParentFunctionalityId), 10, 0));
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
      pa2Y2( ) ;
      ws2Y2( ) ;
      we2Y2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020411466", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secrolefunroleactionassociationww.js", "?2024122020411466", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1012( )
   {
      chkavIsassociated.setInternalname( "vISASSOCIATED_"+sGXsfl_101_idx );
      chkavIsassociatedold.setInternalname( "vISASSOCIATEDOLD_"+sGXsfl_101_idx );
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_101_idx ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY_"+sGXsfl_101_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_101_idx ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE_"+sGXsfl_101_idx );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID_"+sGXsfl_101_idx ;
      edtSecParentFunctionalityDescript_Internalname = "SECPARENTFUNCTIONALITYDESCRIPT_"+sGXsfl_101_idx ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE_"+sGXsfl_101_idx );
   }

   public void subsflControlProps_fel_1012( )
   {
      chkavIsassociated.setInternalname( "vISASSOCIATED_"+sGXsfl_101_fel_idx );
      chkavIsassociatedold.setInternalname( "vISASSOCIATEDOLD_"+sGXsfl_101_fel_idx );
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_101_fel_idx ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY_"+sGXsfl_101_fel_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_101_fel_idx ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE_"+sGXsfl_101_fel_idx );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID_"+sGXsfl_101_fel_idx ;
      edtSecParentFunctionalityDescript_Internalname = "SECPARENTFUNCTIONALITYDESCRIPT_"+sGXsfl_101_fel_idx ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE_"+sGXsfl_101_fel_idx );
   }

   public void sendrow_1012( )
   {
      subsflControlProps_1012( ) ;
      wb2Y0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_101_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_101_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_101_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavIsassociated.getEnabled()!=0)&&(chkavIsassociated.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 102,'',false,'"+sGXsfl_101_idx+"',101)\"" : " ") ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vISASSOCIATED_" + sGXsfl_101_idx ;
         chkavIsassociated.setName( GXCCtl );
         chkavIsassociated.setWebtags( "" );
         chkavIsassociated.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsassociated.getInternalname(), "TitleCaption", chkavIsassociated.getCaption(), !bGXsfl_101_Refreshing);
         chkavIsassociated.setCheckedValue( "false" );
         AV18IsAssociated = GXutil.strtobool( GXutil.booltostr( AV18IsAssociated)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavIsassociated.getInternalname(),GXutil.booltostr( AV18IsAssociated),"","",Integer.valueOf(-1),Integer.valueOf(1),"true","",StyleString,ClassString,"","",TempTags+((chkavIsassociated.getEnabled()!=0)&&(chkavIsassociated.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,102);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavIsassociatedold.getEnabled()!=0)&&(chkavIsassociatedold.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 103,'',false,'"+sGXsfl_101_idx+"',101)\"" : " ") ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         GXCCtl = "vISASSOCIATEDOLD_" + sGXsfl_101_idx ;
         chkavIsassociatedold.setName( GXCCtl );
         chkavIsassociatedold.setWebtags( "" );
         chkavIsassociatedold.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsassociatedold.getInternalname(), "TitleCaption", chkavIsassociatedold.getCaption(), !bGXsfl_101_Refreshing);
         chkavIsassociatedold.setCheckedValue( "false" );
         AV19IsAssociatedOld = GXutil.strtobool( GXutil.booltostr( AV19IsAssociatedOld)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_101_idx, getSecureSignedToken( sGXsfl_101_idx, AV19IsAssociatedOld));
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavIsassociatedold.getInternalname(),GXutil.booltostr( AV19IsAssociatedOld),"","",Integer.valueOf(0),Integer.valueOf(chkavIsassociatedold.getEnabled()),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(103, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavIsassociatedold.getEnabled()!=0)&&(chkavIsassociatedold.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,103);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A62SecFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(101),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityKey_Internalname,A64SecFunctionalityKey,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityKey_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(101),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityDescription_Internalname,A350SecFunctionalityDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(101),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbSecFunctionalityType.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_101_idx ;
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
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSecFunctionalityType,cmbSecFunctionalityType.getInternalname(),GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0)),Integer.valueOf(1),cmbSecFunctionalityType.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), !bGXsfl_101_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A63SecParentFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecParentFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(101),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecParentFunctionalityDescript_Internalname,A353SecParentFunctionalityDescript,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecParentFunctionalityDescript_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(101),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "SECFUNCTIONALITYACTIVE_" + sGXsfl_101_idx ;
         chkSecFunctionalityActive.setName( GXCCtl );
         chkSecFunctionalityActive.setWebtags( "" );
         chkSecFunctionalityActive.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkSecFunctionalityActive.getInternalname(), "TitleCaption", chkSecFunctionalityActive.getCaption(), !bGXsfl_101_Refreshing);
         chkSecFunctionalityActive.setCheckedValue( "false" );
         A349SecFunctionalityActive = GXutil.strtobool( GXutil.booltostr( A349SecFunctionalityActive)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkSecFunctionalityActive.getInternalname(),GXutil.booltostr( A349SecFunctionalityActive),"","",Integer.valueOf(0),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn hidden-xs","",""});
         send_integrity_lvl_hashes2Y2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_101_idx = ((subGrid_Islastpage==1)&&(nGXsfl_101_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_101_idx+1) ;
         sGXsfl_101_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_101_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1012( ) ;
      }
      /* End function sendrow_1012 */
   }

   public void startgridcontrol101( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"101\">") ;
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
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Key", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Description", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Type", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Parent Functionality Id  ", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Parent Functionality", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Is Active?", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV18IsAssociated));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV19IsAssociatedOld));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavIsassociatedold.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A62SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A64SecFunctionalityKey);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A350SecFunctionalityDescription);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A351SecFunctionalityType, (byte)(2), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A63SecParentFunctionalityId, (byte)(10), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A353SecParentFunctionalityDescript);
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
      cmbavSecfunctionalitytype.setInternalname( "vSECFUNCTIONALITYTYPE" );
      lblDynamicfiltersprefix1_Internalname = "DYNAMICFILTERSPREFIX1" ;
      cmbavDynamicfiltersselector1.setInternalname( "vDYNAMICFILTERSSELECTOR1" );
      lblDynamicfiltersmiddle1_Internalname = "DYNAMICFILTERSMIDDLE1" ;
      cmbavDynamicfiltersoperator1.setInternalname( "vDYNAMICFILTERSOPERATOR1" );
      edtavSecfunctionalitydescription1_Internalname = "vSECFUNCTIONALITYDESCRIPTION1" ;
      cellFilter_secfunctionalitydescription1_cell_Internalname = "FILTER_SECFUNCTIONALITYDESCRIPTION1_CELL" ;
      edtavSecparentfunctionalitydescription1_Internalname = "vSECPARENTFUNCTIONALITYDESCRIPTION1" ;
      cellFilter_secparentfunctionalitydescription1_cell_Internalname = "FILTER_SECPARENTFUNCTIONALITYDESCRIPTION1_CELL" ;
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
      edtavSecfunctionalitydescription2_Internalname = "vSECFUNCTIONALITYDESCRIPTION2" ;
      cellFilter_secfunctionalitydescription2_cell_Internalname = "FILTER_SECFUNCTIONALITYDESCRIPTION2_CELL" ;
      edtavSecparentfunctionalitydescription2_Internalname = "vSECPARENTFUNCTIONALITYDESCRIPTION2" ;
      cellFilter_secparentfunctionalitydescription2_cell_Internalname = "FILTER_SECPARENTFUNCTIONALITYDESCRIPTION2_CELL" ;
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
      edtavSecfunctionalitydescription3_Internalname = "vSECFUNCTIONALITYDESCRIPTION3" ;
      cellFilter_secfunctionalitydescription3_cell_Internalname = "FILTER_SECFUNCTIONALITYDESCRIPTION3_CELL" ;
      edtavSecparentfunctionalitydescription3_Internalname = "vSECPARENTFUNCTIONALITYDESCRIPTION3" ;
      cellFilter_secparentfunctionalitydescription3_cell_Internalname = "FILTER_SECPARENTFUNCTIONALITYDESCRIPTION3_CELL" ;
      imgRemovedynamicfilters3_Internalname = "REMOVEDYNAMICFILTERS3" ;
      cellDynamicfilters_removefilter3_cell_Internalname = "DYNAMICFILTERS_REMOVEFILTER3_CELL" ;
      tblTablemergeddynamicfilters3_Internalname = "TABLEMERGEDDYNAMICFILTERS3" ;
      divTabledynamicfiltersrow3_Internalname = "TABLEDYNAMICFILTERSROW3" ;
      divTabledynamicfilters_Internalname = "TABLEDYNAMICFILTERS" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      chkavIsassociated.setInternalname( "vISASSOCIATED" );
      chkavIsassociatedold.setInternalname( "vISASSOCIATEDOLD" );
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID" ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY" ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION" ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE" );
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID" ;
      edtSecParentFunctionalityDescript_Internalname = "SECPARENTFUNCTIONALITYDESCRIPT" ;
      chkSecFunctionalityActive.setInternalname( "SECFUNCTIONALITYACTIVE" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      bttBtnconfirm_Internalname = "BTNCONFIRM" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      lblJsdynamicfilters_Internalname = "JSDYNAMICFILTERS" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
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
      chkavIsassociatedold.setCaption( "" );
      chkavIsassociatedold.setVisible( 0 );
      chkavIsassociatedold.setEnabled( 1 );
      chkavIsassociated.setCaption( "" );
      chkavIsassociated.setVisible( -1 );
      chkavIsassociated.setEnabled( 1 );
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      imgRemovedynamicfilters1_Visible = 1 ;
      imgAdddynamicfilters1_Visible = 1 ;
      edtavSecparentfunctionalitydescription1_Jsonclick = "" ;
      edtavSecparentfunctionalitydescription1_Enabled = 1 ;
      edtavSecfunctionalitydescription1_Jsonclick = "" ;
      edtavSecfunctionalitydescription1_Enabled = 1 ;
      cmbavDynamicfiltersoperator1.setJsonclick( "" );
      cmbavDynamicfiltersoperator1.setEnabled( 1 );
      imgRemovedynamicfilters2_Visible = 1 ;
      imgAdddynamicfilters2_Visible = 1 ;
      edtavSecparentfunctionalitydescription2_Jsonclick = "" ;
      edtavSecparentfunctionalitydescription2_Enabled = 1 ;
      edtavSecfunctionalitydescription2_Jsonclick = "" ;
      edtavSecfunctionalitydescription2_Enabled = 1 ;
      cmbavDynamicfiltersoperator2.setJsonclick( "" );
      cmbavDynamicfiltersoperator2.setEnabled( 1 );
      edtavSecparentfunctionalitydescription3_Jsonclick = "" ;
      edtavSecparentfunctionalitydescription3_Enabled = 1 ;
      edtavSecfunctionalitydescription3_Jsonclick = "" ;
      edtavSecfunctionalitydescription3_Enabled = 1 ;
      cmbavDynamicfiltersoperator3.setJsonclick( "" );
      cmbavDynamicfiltersoperator3.setEnabled( 1 );
      cmbavDynamicfiltersselector3.setJsonclick( "" );
      cmbavDynamicfiltersselector3.setEnabled( 1 );
      cmbavDynamicfiltersselector2.setJsonclick( "" );
      cmbavDynamicfiltersselector2.setEnabled( 1 );
      cmbavDynamicfiltersselector1.setJsonclick( "" );
      cmbavDynamicfiltersselector1.setEnabled( 1 );
      cmbavSecfunctionalitytype.setJsonclick( "" );
      cmbavSecfunctionalitytype.setEnabled( 1 );
      cmbavDynamicfiltersoperator3.setVisible( 1 );
      edtavSecparentfunctionalitydescription3_Visible = 1 ;
      edtavSecfunctionalitydescription3_Visible = 1 ;
      cmbavDynamicfiltersoperator2.setVisible( 1 );
      edtavSecparentfunctionalitydescription2_Visible = 1 ;
      edtavSecfunctionalitydescription2_Visible = 1 ;
      cmbavDynamicfiltersoperator1.setVisible( 1 );
      edtavSecparentfunctionalitydescription1_Visible = 1 ;
      edtavSecfunctionalitydescription1_Visible = 1 ;
      subGrid_Sortable = (byte)(0) ;
      lblJsdynamicfilters_Caption = httpContext.getMessage( "JSDynamicFilters", "") ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4" ;
      Ddo_grid_Columnids = "3:SecFunctionalityKey|4:SecFunctionalityDescription|5:SecFunctionalityType|7:SecParentFunctionalityDescription" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Associated to Role", "") );
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavSecfunctionalitytype.setName( "vSECFUNCTIONALITYTYPE" );
      cmbavSecfunctionalitytype.setWebtags( "" );
      cmbavSecfunctionalitytype.addItem(GXutil.trim( GXutil.str( 0, 2, 0)), httpContext.getMessage( "WWP_AllInCombo", ""), (short)(0));
      cmbavSecfunctionalitytype.addItem("1", httpContext.getMessage( "Mode", ""), (short)(0));
      cmbavSecfunctionalitytype.addItem("2", httpContext.getMessage( "Action", ""), (short)(0));
      cmbavSecfunctionalitytype.addItem("3", httpContext.getMessage( "Tab", ""), (short)(0));
      cmbavSecfunctionalitytype.addItem("4", httpContext.getMessage( "Object", ""), (short)(0));
      cmbavSecfunctionalitytype.addItem("5", httpContext.getMessage( "Attribute", ""), (short)(0));
      if ( cmbavSecfunctionalitytype.getItemCount() > 0 )
      {
         AV27SecFunctionalityType = (byte)(GXutil.lval( cmbavSecfunctionalitytype.getValidValue(GXutil.trim( GXutil.str( AV27SecFunctionalityType, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27SecFunctionalityType), 2, 0));
      }
      cmbavDynamicfiltersselector1.setName( "vDYNAMICFILTERSSELECTOR1" );
      cmbavDynamicfiltersselector1.setWebtags( "" );
      cmbavDynamicfiltersselector1.addItem("SECFUNCTIONALITYDESCRIPTION", httpContext.getMessage( "Functionality Description", ""), (short)(0));
      cmbavDynamicfiltersselector1.addItem("SECPARENTFUNCTIONALITYDESCRIPTION", httpContext.getMessage( "Parent Functionality", ""), (short)(0));
      if ( cmbavDynamicfiltersselector1.getItemCount() > 0 )
      {
         AV37DynamicFiltersSelector1 = cmbavDynamicfiltersselector1.getValidValue(AV37DynamicFiltersSelector1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37DynamicFiltersSelector1", AV37DynamicFiltersSelector1);
      }
      cmbavDynamicfiltersoperator1.setName( "vDYNAMICFILTERSOPERATOR1" );
      cmbavDynamicfiltersoperator1.setWebtags( "" );
      cmbavDynamicfiltersoperator1.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
      cmbavDynamicfiltersoperator1.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
      if ( cmbavDynamicfiltersoperator1.getItemCount() > 0 )
      {
         AV38DynamicFiltersOperator1 = (short)(GXutil.lval( cmbavDynamicfiltersoperator1.getValidValue(GXutil.trim( GXutil.str( AV38DynamicFiltersOperator1, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38DynamicFiltersOperator1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38DynamicFiltersOperator1), 4, 0));
      }
      cmbavDynamicfiltersselector2.setName( "vDYNAMICFILTERSSELECTOR2" );
      cmbavDynamicfiltersselector2.setWebtags( "" );
      cmbavDynamicfiltersselector2.addItem("SECFUNCTIONALITYDESCRIPTION", httpContext.getMessage( "Functionality Description", ""), (short)(0));
      cmbavDynamicfiltersselector2.addItem("SECPARENTFUNCTIONALITYDESCRIPTION", httpContext.getMessage( "Parent Functionality", ""), (short)(0));
      if ( cmbavDynamicfiltersselector2.getItemCount() > 0 )
      {
         AV42DynamicFiltersSelector2 = cmbavDynamicfiltersselector2.getValidValue(AV42DynamicFiltersSelector2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42DynamicFiltersSelector2", AV42DynamicFiltersSelector2);
      }
      cmbavDynamicfiltersoperator2.setName( "vDYNAMICFILTERSOPERATOR2" );
      cmbavDynamicfiltersoperator2.setWebtags( "" );
      cmbavDynamicfiltersoperator2.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
      cmbavDynamicfiltersoperator2.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
      if ( cmbavDynamicfiltersoperator2.getItemCount() > 0 )
      {
         AV43DynamicFiltersOperator2 = (short)(GXutil.lval( cmbavDynamicfiltersoperator2.getValidValue(GXutil.trim( GXutil.str( AV43DynamicFiltersOperator2, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43DynamicFiltersOperator2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43DynamicFiltersOperator2), 4, 0));
      }
      cmbavDynamicfiltersselector3.setName( "vDYNAMICFILTERSSELECTOR3" );
      cmbavDynamicfiltersselector3.setWebtags( "" );
      cmbavDynamicfiltersselector3.addItem("SECFUNCTIONALITYDESCRIPTION", httpContext.getMessage( "Functionality Description", ""), (short)(0));
      cmbavDynamicfiltersselector3.addItem("SECPARENTFUNCTIONALITYDESCRIPTION", httpContext.getMessage( "Parent Functionality", ""), (short)(0));
      if ( cmbavDynamicfiltersselector3.getItemCount() > 0 )
      {
         AV47DynamicFiltersSelector3 = cmbavDynamicfiltersselector3.getValidValue(AV47DynamicFiltersSelector3) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47DynamicFiltersSelector3", AV47DynamicFiltersSelector3);
      }
      cmbavDynamicfiltersoperator3.setName( "vDYNAMICFILTERSOPERATOR3" );
      cmbavDynamicfiltersoperator3.setWebtags( "" );
      cmbavDynamicfiltersoperator3.addItem("0", httpContext.getMessage( "WWP_FilterLike", ""), (short)(0));
      cmbavDynamicfiltersoperator3.addItem("1", httpContext.getMessage( "WWP_FilterContains", ""), (short)(0));
      if ( cmbavDynamicfiltersoperator3.getItemCount() > 0 )
      {
         AV48DynamicFiltersOperator3 = (short)(GXutil.lval( cmbavDynamicfiltersoperator3.getValidValue(GXutil.trim( GXutil.str( AV48DynamicFiltersOperator3, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48DynamicFiltersOperator3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48DynamicFiltersOperator3), 4, 0));
      }
      GXCCtl = "vISASSOCIATED_" + sGXsfl_101_idx ;
      chkavIsassociated.setName( GXCCtl );
      chkavIsassociated.setWebtags( "" );
      chkavIsassociated.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsassociated.getInternalname(), "TitleCaption", chkavIsassociated.getCaption(), !bGXsfl_101_Refreshing);
      chkavIsassociated.setCheckedValue( "false" );
      AV18IsAssociated = GXutil.strtobool( GXutil.booltostr( AV18IsAssociated)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavIsassociated.getInternalname(), AV18IsAssociated);
      GXCCtl = "vISASSOCIATEDOLD_" + sGXsfl_101_idx ;
      chkavIsassociatedold.setName( GXCCtl );
      chkavIsassociatedold.setWebtags( "" );
      chkavIsassociatedold.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsassociatedold.getInternalname(), "TitleCaption", chkavIsassociatedold.getCaption(), !bGXsfl_101_Refreshing);
      chkavIsassociatedold.setCheckedValue( "false" );
      AV19IsAssociatedOld = GXutil.strtobool( GXutil.booltostr( AV19IsAssociatedOld)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavIsassociatedold.getInternalname(), AV19IsAssociatedOld);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISASSOCIATEDOLD"+"_"+sGXsfl_101_idx, getSecureSignedToken( sGXsfl_101_idx, AV19IsAssociatedOld));
      GXCCtl = "SECFUNCTIONALITYTYPE_" + sGXsfl_101_idx ;
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
      GXCCtl = "SECFUNCTIONALITYACTIVE_" + sGXsfl_101_idx ;
      chkSecFunctionalityActive.setName( GXCCtl );
      chkSecFunctionalityActive.setWebtags( "" );
      chkSecFunctionalityActive.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSecFunctionalityActive.getInternalname(), "TitleCaption", chkSecFunctionalityActive.getCaption(), !bGXsfl_101_Refreshing);
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV78GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV79GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV80GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e112Y2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e122Y2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e132Y2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'AV35OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV36OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV35OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV36OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e252Y2',iparms:[{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'A62SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true},{av:'AV19IsAssociatedOld',fld:'vISASSOCIATEDOLD',pic:'',hsh:true},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV18IsAssociated',fld:'vISASSOCIATED',pic:''},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("ENTER","{handler:'e142Y2',iparms:[{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV16SecFunctionalityRole',fld:'vSECFUNCTIONALITYROLE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV16SecFunctionalityRole',fld:'vSECFUNCTIONALITYROLE',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("'ADDDYNAMICFILTERS1'","{handler:'e182Y2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'ADDDYNAMICFILTERS1'",",oparms:[{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV78GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV79GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV80GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("'REMOVEDYNAMICFILTERS1'","{handler:'e152Y2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true},{av:'AV32GridState',fld:'vGRIDSTATE',pic:''},{av:'AV52DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV51DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''}]");
      setEventMetadata("'REMOVEDYNAMICFILTERS1'",",oparms:[{av:'AV51DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'AV52DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV32GridState',fld:'vGRIDSTATE',pic:''},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'edtavSecfunctionalitydescription2_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION2',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription2_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION2',prop:'Visible'},{av:'edtavSecfunctionalitydescription3_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION3',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription3_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION3',prop:'Visible'},{av:'edtavSecfunctionalitydescription1_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION1',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription1_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION1',prop:'Visible'},{av:'AV78GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV79GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV80GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("VDYNAMICFILTERSSELECTOR1.CLICK","{handler:'e192Y2',iparms:[{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''}]");
      setEventMetadata("VDYNAMICFILTERSSELECTOR1.CLICK",",oparms:[{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'edtavSecfunctionalitydescription1_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION1',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription1_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION1',prop:'Visible'}]}");
      setEventMetadata("'ADDDYNAMICFILTERS2'","{handler:'e202Y2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'ADDDYNAMICFILTERS2'",",oparms:[{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV78GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV79GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV80GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("'REMOVEDYNAMICFILTERS2'","{handler:'e162Y2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true},{av:'AV32GridState',fld:'vGRIDSTATE',pic:''},{av:'AV52DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV51DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''}]");
      setEventMetadata("'REMOVEDYNAMICFILTERS2'",",oparms:[{av:'AV51DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV32GridState',fld:'vGRIDSTATE',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'edtavSecfunctionalitydescription2_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION2',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription2_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION2',prop:'Visible'},{av:'edtavSecfunctionalitydescription3_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION3',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription3_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION3',prop:'Visible'},{av:'edtavSecfunctionalitydescription1_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION1',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription1_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION1',prop:'Visible'},{av:'AV78GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV79GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV80GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("VDYNAMICFILTERSSELECTOR2.CLICK","{handler:'e212Y2',iparms:[{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''}]");
      setEventMetadata("VDYNAMICFILTERSSELECTOR2.CLICK",",oparms:[{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'edtavSecfunctionalitydescription2_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION2',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription2_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION2',prop:'Visible'}]}");
      setEventMetadata("'REMOVEDYNAMICFILTERS3'","{handler:'e172Y2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'cmbavSecfunctionalitytype'},{av:'AV27SecFunctionalityType',fld:'vSECFUNCTIONALITYTYPE',pic:'Z9'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'AV29SecParentFunctionalityId',fld:'vSECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV86Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9',hsh:true},{av:'A65SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV31SecRoleIdParm',fld:'vSECROLEIDPARM',pic:'ZZZ9',hsh:true},{av:'AV32GridState',fld:'vGRIDSTATE',pic:''},{av:'AV52DynamicFiltersIgnoreFirst',fld:'vDYNAMICFILTERSIGNOREFIRST',pic:''},{av:'AV51DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''}]");
      setEventMetadata("'REMOVEDYNAMICFILTERS3'",",oparms:[{av:'AV51DynamicFiltersRemoving',fld:'vDYNAMICFILTERSREMOVING',pic:''},{av:'AV46DynamicFiltersEnabled3',fld:'vDYNAMICFILTERSENABLED3',pic:''},{av:'AV32GridState',fld:'vGRIDSTATE',pic:''},{av:'AV41DynamicFiltersEnabled2',fld:'vDYNAMICFILTERSENABLED2',pic:''},{av:'cmbavDynamicfiltersselector2'},{av:'AV42DynamicFiltersSelector2',fld:'vDYNAMICFILTERSSELECTOR2',pic:''},{av:'cmbavDynamicfiltersoperator2'},{av:'AV43DynamicFiltersOperator2',fld:'vDYNAMICFILTERSOPERATOR2',pic:'ZZZ9'},{av:'AV44SecFunctionalityDescription2',fld:'vSECFUNCTIONALITYDESCRIPTION2',pic:''},{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''},{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'AV49SecFunctionalityDescription3',fld:'vSECFUNCTIONALITYDESCRIPTION3',pic:''},{av:'imgAdddynamicfilters1_Visible',ctrl:'ADDDYNAMICFILTERS1',prop:'Visible'},{av:'imgRemovedynamicfilters1_Visible',ctrl:'REMOVEDYNAMICFILTERS1',prop:'Visible'},{av:'imgAdddynamicfilters2_Visible',ctrl:'ADDDYNAMICFILTERS2',prop:'Visible'},{av:'imgRemovedynamicfilters2_Visible',ctrl:'REMOVEDYNAMICFILTERS2',prop:'Visible'},{av:'cmbavDynamicfiltersselector1'},{av:'AV37DynamicFiltersSelector1',fld:'vDYNAMICFILTERSSELECTOR1',pic:''},{av:'cmbavDynamicfiltersoperator1'},{av:'AV38DynamicFiltersOperator1',fld:'vDYNAMICFILTERSOPERATOR1',pic:'ZZZ9'},{av:'AV39SecFunctionalityDescription1',fld:'vSECFUNCTIONALITYDESCRIPTION1',pic:''},{av:'AV53SecParentFunctionalityDescription1',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION1',pic:''},{av:'lblJsdynamicfilters_Caption',ctrl:'JSDYNAMICFILTERS',prop:'Caption'},{av:'AV54SecParentFunctionalityDescription2',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION2',pic:''},{av:'AV55SecParentFunctionalityDescription3',fld:'vSECPARENTFUNCTIONALITYDESCRIPTION3',pic:''},{av:'edtavSecfunctionalitydescription2_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION2',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription2_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION2',prop:'Visible'},{av:'edtavSecfunctionalitydescription3_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION3',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription3_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION3',prop:'Visible'},{av:'edtavSecfunctionalitydescription1_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION1',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription1_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION1',prop:'Visible'},{av:'AV78GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV79GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV80GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''}]}");
      setEventMetadata("VDYNAMICFILTERSSELECTOR3.CLICK","{handler:'e222Y2',iparms:[{av:'cmbavDynamicfiltersselector3'},{av:'AV47DynamicFiltersSelector3',fld:'vDYNAMICFILTERSSELECTOR3',pic:''}]");
      setEventMetadata("VDYNAMICFILTERSSELECTOR3.CLICK",",oparms:[{av:'cmbavDynamicfiltersoperator3'},{av:'AV48DynamicFiltersOperator3',fld:'vDYNAMICFILTERSOPERATOR3',pic:'ZZZ9'},{av:'edtavSecfunctionalitydescription3_Visible',ctrl:'vSECFUNCTIONALITYDESCRIPTION3',prop:'Visible'},{av:'edtavSecparentfunctionalitydescription3_Visible',ctrl:'vSECPARENTFUNCTIONALITYDESCRIPTION3',prop:'Visible'}]}");
      setEventMetadata("VISASSOCIATED.CLICK","{handler:'e262Y2',iparms:[{av:'A62SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'AV18IsAssociated',fld:'vISASSOCIATED',pic:''},{av:'AV19IsAssociatedOld',fld:'vISASSOCIATEDOLD',pic:'',hsh:true},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''},{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("VISASSOCIATED.CLICK",",oparms:[{av:'AV15SecFunctionalityIdToFind',fld:'vSECFUNCTIONALITYIDTOFIND',pic:'ZZZZZZZZZ9'},{av:'AV11SecFunctionalityIdRemoved',fld:'vSECFUNCTIONALITYIDREMOVED',pic:''},{av:'AV10SecFunctionalityIdAdded',fld:'vSECFUNCTIONALITYIDADDED',pic:''},{av:'AV21i',fld:'vI',pic:'ZZZZZZZZZ9'},{av:'AV13SecFunctionalityIdRemovedXml',fld:'vSECFUNCTIONALITYIDREMOVEDXML',pic:''},{av:'AV12SecFunctionalityIdAddedXml',fld:'vSECFUNCTIONALITYIDADDEDXML',pic:''}]}");
      setEventMetadata("VALIDV_SECFUNCTIONALITYTYPE","{handler:'validv_Secfunctionalitytype',iparms:[]");
      setEventMetadata("VALIDV_SECFUNCTIONALITYTYPE",",oparms:[]}");
      setEventMetadata("VALID_SECFUNCTIONALITYID","{handler:'valid_Secfunctionalityid',iparms:[]");
      setEventMetadata("VALID_SECFUNCTIONALITYID",",oparms:[]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV37DynamicFiltersSelector1 = "" ;
      AV39SecFunctionalityDescription1 = "" ;
      AV53SecParentFunctionalityDescription1 = "" ;
      AV42DynamicFiltersSelector2 = "" ;
      AV44SecFunctionalityDescription2 = "" ;
      AV54SecParentFunctionalityDescription2 = "" ;
      AV47DynamicFiltersSelector3 = "" ;
      AV49SecFunctionalityDescription3 = "" ;
      AV55SecParentFunctionalityDescription3 = "" ;
      AV86Pgmname = "" ;
      AV13SecFunctionalityIdRemovedXml = "" ;
      AV12SecFunctionalityIdAddedXml = "" ;
      AV11SecFunctionalityIdRemoved = new GXSimpleCollection<Long>(Long.class, "internal", "");
      AV10SecFunctionalityIdAdded = new GXSimpleCollection<Long>(Long.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV80GridAppliedFilters = "" ;
      AV71DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16SecFunctionalityRole = new web.wwpbaseobjects.SdtSecFunctionalityRole(remoteHandle);
      AV32GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      bttBtnconfirm_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      lblJsdynamicfilters_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A64SecFunctionalityKey = "" ;
      A350SecFunctionalityDescription = "" ;
      A353SecParentFunctionalityDescript = "" ;
      scmdbuf = "" ;
      lV39SecFunctionalityDescription1 = "" ;
      lV53SecParentFunctionalityDescription1 = "" ;
      lV44SecFunctionalityDescription2 = "" ;
      lV54SecParentFunctionalityDescription2 = "" ;
      lV49SecFunctionalityDescription3 = "" ;
      lV55SecParentFunctionalityDescription3 = "" ;
      H002Y2_A62SecFunctionalityId = new long[1] ;
      H002Y2_A353SecParentFunctionalityDescript = new String[] {""} ;
      H002Y2_A349SecFunctionalityActive = new boolean[] {false} ;
      H002Y2_A63SecParentFunctionalityId = new long[1] ;
      H002Y2_n63SecParentFunctionalityId = new boolean[] {false} ;
      H002Y2_A351SecFunctionalityType = new byte[1] ;
      H002Y2_A350SecFunctionalityDescription = new String[] {""} ;
      H002Y2_A64SecFunctionalityKey = new String[] {""} ;
      H002Y3_AGRID_nRecordCount = new long[1] ;
      imgAdddynamicfilters1_Jsonclick = "" ;
      imgRemovedynamicfilters1_Jsonclick = "" ;
      imgAdddynamicfilters2_Jsonclick = "" ;
      imgRemovedynamicfilters2_Jsonclick = "" ;
      imgRemovedynamicfilters3_Jsonclick = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      H002Y4_A65SecRoleId = new short[1] ;
      H002Y4_A354SecRoleDescription = new String[] {""} ;
      A354SecRoleDescription = "" ;
      GXv_int2 = new int[1] ;
      AV74WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      H002Y5_A62SecFunctionalityId = new long[1] ;
      H002Y5_A65SecRoleId = new short[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV34GridStateDynamicFilter = new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
      AV92GXV5 = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV20Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      lblDynamicfiltersprefix1_Jsonclick = "" ;
      lblDynamicfiltersmiddle1_Jsonclick = "" ;
      lblDynamicfiltersprefix2_Jsonclick = "" ;
      lblDynamicfiltersmiddle2_Jsonclick = "" ;
      lblDynamicfiltersprefix3_Jsonclick = "" ;
      lblDynamicfiltersmiddle3_Jsonclick = "" ;
      imgRemovedynamicfilters3_gximage = "" ;
      sImgUrl = "" ;
      imgAdddynamicfilters2_gximage = "" ;
      imgRemovedynamicfilters2_gximage = "" ;
      imgAdddynamicfilters1_gximage = "" ;
      imgRemovedynamicfilters1_gximage = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secrolefunroleactionassociationww__default(),
         new Object[] {
             new Object[] {
            H002Y2_A62SecFunctionalityId, H002Y2_A353SecParentFunctionalityDescript, H002Y2_A349SecFunctionalityActive, H002Y2_A63SecParentFunctionalityId, H002Y2_n63SecParentFunctionalityId, H002Y2_A351SecFunctionalityType, H002Y2_A350SecFunctionalityDescription, H002Y2_A64SecFunctionalityKey
            }
            , new Object[] {
            H002Y3_AGRID_nRecordCount
            }
            , new Object[] {
            H002Y4_A65SecRoleId, H002Y4_A354SecRoleDescription
            }
            , new Object[] {
            H002Y5_A62SecFunctionalityId, H002Y5_A65SecRoleId
            }
         }
      );
      AV86Pgmname = "WWPBaseObjects.SecRoleFunRoleActionAssociationWW" ;
      /* GeneXus formulas. */
      AV86Pgmname = "WWPBaseObjects.SecRoleFunRoleActionAssociationWW" ;
      Gx_err = (short)(0) ;
      chkavIsassociatedold.setEnabled( 0 );
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV27SecFunctionalityType ;
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
   private short wcpOAV9SecRoleId ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV9SecRoleId ;
   private short AV38DynamicFiltersOperator1 ;
   private short AV43DynamicFiltersOperator2 ;
   private short AV48DynamicFiltersOperator3 ;
   private short A65SecRoleId ;
   private short AV31SecRoleIdParm ;
   private short AV35OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_101 ;
   private int subGrid_Rows ;
   private int nGXsfl_101_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV81CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV77PageToGo ;
   private int AV88GXV1 ;
   private int AV89GXV2 ;
   private int imgAdddynamicfilters1_Visible ;
   private int imgRemovedynamicfilters1_Visible ;
   private int imgAdddynamicfilters2_Visible ;
   private int imgRemovedynamicfilters2_Visible ;
   private int edtavSecfunctionalitydescription1_Visible ;
   private int edtavSecparentfunctionalitydescription1_Visible ;
   private int edtavSecfunctionalitydescription2_Visible ;
   private int edtavSecparentfunctionalitydescription2_Visible ;
   private int edtavSecfunctionalitydescription3_Visible ;
   private int edtavSecparentfunctionalitydescription3_Visible ;
   private int AV90GXV3 ;
   private int AV91GXV4 ;
   private int AV93GXV6 ;
   private int edtavSecfunctionalitydescription3_Enabled ;
   private int edtavSecparentfunctionalitydescription3_Enabled ;
   private int edtavSecfunctionalitydescription2_Enabled ;
   private int edtavSecparentfunctionalitydescription2_Enabled ;
   private int edtavSecfunctionalitydescription1_Enabled ;
   private int edtavSecparentfunctionalitydescription1_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long wcpOAV29SecParentFunctionalityId ;
   private long GRID_nFirstRecordOnPage ;
   private long AV29SecParentFunctionalityId ;
   private long AV21i ;
   private long AV15SecFunctionalityIdToFind ;
   private long AV78GridCurrentPage ;
   private long AV79GridPageCount ;
   private long A62SecFunctionalityId ;
   private long A63SecParentFunctionalityId ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private long AV14SecFunctionalityId ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_101_idx="0001" ;
   private String AV86Pgmname ;
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
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableheader_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String TempTags ;
   private String bttBtnconfirm_Internalname ;
   private String bttBtnconfirm_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String lblJsdynamicfilters_Internalname ;
   private String lblJsdynamicfilters_Caption ;
   private String lblJsdynamicfilters_Jsonclick ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtSecFunctionalityId_Internalname ;
   private String edtSecFunctionalityKey_Internalname ;
   private String edtSecFunctionalityDescription_Internalname ;
   private String edtSecParentFunctionalityId_Internalname ;
   private String edtSecParentFunctionalityDescript_Internalname ;
   private String scmdbuf ;
   private String edtavSecfunctionalitydescription1_Internalname ;
   private String edtavSecparentfunctionalitydescription1_Internalname ;
   private String edtavSecfunctionalitydescription2_Internalname ;
   private String edtavSecparentfunctionalitydescription2_Internalname ;
   private String edtavSecfunctionalitydescription3_Internalname ;
   private String edtavSecparentfunctionalitydescription3_Internalname ;
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
   private String GXt_char6 ;
   private String GXv_char7[] ;
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
   private String cellFilter_secfunctionalitydescription3_cell_Internalname ;
   private String edtavSecfunctionalitydescription3_Jsonclick ;
   private String cellFilter_secparentfunctionalitydescription3_cell_Internalname ;
   private String edtavSecparentfunctionalitydescription3_Jsonclick ;
   private String cellDynamicfilters_removefilter3_cell_Internalname ;
   private String imgRemovedynamicfilters3_gximage ;
   private String sImgUrl ;
   private String tblTablemergeddynamicfilters2_Internalname ;
   private String cellFilter_secfunctionalitydescription2_cell_Internalname ;
   private String edtavSecfunctionalitydescription2_Jsonclick ;
   private String cellFilter_secparentfunctionalitydescription2_cell_Internalname ;
   private String edtavSecparentfunctionalitydescription2_Jsonclick ;
   private String cellDynamicfilters_addfilter2_cell_Internalname ;
   private String imgAdddynamicfilters2_gximage ;
   private String cellDynamicfilters_removefilter2_cell_Internalname ;
   private String imgRemovedynamicfilters2_gximage ;
   private String tblTablemergeddynamicfilters1_Internalname ;
   private String cellFilter_secfunctionalitydescription1_cell_Internalname ;
   private String edtavSecfunctionalitydescription1_Jsonclick ;
   private String cellFilter_secparentfunctionalitydescription1_cell_Internalname ;
   private String edtavSecparentfunctionalitydescription1_Jsonclick ;
   private String cellDynamicfilters_addfilter1_cell_Internalname ;
   private String imgAdddynamicfilters1_gximage ;
   private String cellDynamicfilters_removefilter1_cell_Internalname ;
   private String imgRemovedynamicfilters1_gximage ;
   private String sGXsfl_101_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtSecFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityKey_Jsonclick ;
   private String edtSecFunctionalityDescription_Jsonclick ;
   private String edtSecParentFunctionalityId_Jsonclick ;
   private String edtSecParentFunctionalityDescript_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV41DynamicFiltersEnabled2 ;
   private boolean AV46DynamicFiltersEnabled3 ;
   private boolean AV36OrderedDsc ;
   private boolean AV52DynamicFiltersIgnoreFirst ;
   private boolean AV51DynamicFiltersRemoving ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV18IsAssociated ;
   private boolean AV19IsAssociatedOld ;
   private boolean n63SecParentFunctionalityId ;
   private boolean A349SecFunctionalityActive ;
   private boolean bGXsfl_101_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV17Success ;
   private String AV13SecFunctionalityIdRemovedXml ;
   private String AV12SecFunctionalityIdAddedXml ;
   private String AV37DynamicFiltersSelector1 ;
   private String AV39SecFunctionalityDescription1 ;
   private String AV53SecParentFunctionalityDescription1 ;
   private String AV42DynamicFiltersSelector2 ;
   private String AV44SecFunctionalityDescription2 ;
   private String AV54SecParentFunctionalityDescription2 ;
   private String AV47DynamicFiltersSelector3 ;
   private String AV49SecFunctionalityDescription3 ;
   private String AV55SecParentFunctionalityDescription3 ;
   private String AV80GridAppliedFilters ;
   private String A64SecFunctionalityKey ;
   private String A350SecFunctionalityDescription ;
   private String A353SecParentFunctionalityDescript ;
   private String lV39SecFunctionalityDescription1 ;
   private String lV53SecParentFunctionalityDescription1 ;
   private String lV44SecFunctionalityDescription2 ;
   private String lV54SecParentFunctionalityDescription2 ;
   private String lV49SecFunctionalityDescription3 ;
   private String lV55SecParentFunctionalityDescription3 ;
   private String A354SecRoleDescription ;
   private GXSimpleCollection<Long> AV11SecFunctionalityIdRemoved ;
   private GXSimpleCollection<Long> AV10SecFunctionalityIdAdded ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private HTMLChoice cmbavSecfunctionalitytype ;
   private HTMLChoice cmbavDynamicfiltersselector1 ;
   private HTMLChoice cmbavDynamicfiltersoperator1 ;
   private HTMLChoice cmbavDynamicfiltersselector2 ;
   private HTMLChoice cmbavDynamicfiltersoperator2 ;
   private HTMLChoice cmbavDynamicfiltersselector3 ;
   private HTMLChoice cmbavDynamicfiltersoperator3 ;
   private ICheckbox chkavIsassociated ;
   private ICheckbox chkavIsassociatedold ;
   private HTMLChoice cmbSecFunctionalityType ;
   private ICheckbox chkSecFunctionalityActive ;
   private IDataStoreProvider pr_default ;
   private long[] H002Y2_A62SecFunctionalityId ;
   private String[] H002Y2_A353SecParentFunctionalityDescript ;
   private boolean[] H002Y2_A349SecFunctionalityActive ;
   private long[] H002Y2_A63SecParentFunctionalityId ;
   private boolean[] H002Y2_n63SecParentFunctionalityId ;
   private byte[] H002Y2_A351SecFunctionalityType ;
   private String[] H002Y2_A350SecFunctionalityDescription ;
   private String[] H002Y2_A64SecFunctionalityKey ;
   private long[] H002Y3_AGRID_nRecordCount ;
   private short[] H002Y4_A65SecRoleId ;
   private String[] H002Y4_A354SecRoleDescription ;
   private long[] H002Y5_A62SecFunctionalityId ;
   private short[] H002Y5_A65SecRoleId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV92GXV5 ;
   private com.genexus.SdtMessages_Message AV20Message ;
   private web.wwpbaseobjects.SdtWWPContext AV74WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtSecFunctionalityRole AV16SecFunctionalityRole ;
   private web.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_DynamicFilter AV34GridStateDynamicFilter ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV71DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class secrolefunroleactionassociationww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002Y2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte AV27SecFunctionalityType ,
                                          String AV37DynamicFiltersSelector1 ,
                                          short AV38DynamicFiltersOperator1 ,
                                          String AV39SecFunctionalityDescription1 ,
                                          String AV53SecParentFunctionalityDescription1 ,
                                          boolean AV41DynamicFiltersEnabled2 ,
                                          String AV42DynamicFiltersSelector2 ,
                                          short AV43DynamicFiltersOperator2 ,
                                          String AV44SecFunctionalityDescription2 ,
                                          String AV54SecParentFunctionalityDescription2 ,
                                          boolean AV46DynamicFiltersEnabled3 ,
                                          String AV47DynamicFiltersSelector3 ,
                                          short AV48DynamicFiltersOperator3 ,
                                          String AV49SecFunctionalityDescription3 ,
                                          String AV55SecParentFunctionalityDescription3 ,
                                          byte A351SecFunctionalityType ,
                                          String A350SecFunctionalityDescription ,
                                          String A353SecParentFunctionalityDescript ,
                                          short AV35OrderedBy ,
                                          boolean AV36OrderedDsc ,
                                          long A63SecParentFunctionalityId ,
                                          long AV29SecParentFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[17];
      Object[] GXv_Object9 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.SecFunctionalityId, T2.SecFunctionalityDescription AS SecParentFunctionalityDescript, T1.SecFunctionalityActive, T1.SecParentFunctionalityId AS SecParentFunctionalityId," ;
      sSelectString += " T1.SecFunctionalityType, T1.SecFunctionalityDescription, T1.SecFunctionalityKey" ;
      sFromString = " FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.SecParentFunctionalityId = ?)");
      if ( ! (0==AV27SecFunctionalityType) )
      {
         addWhere(sWhereString, "(T1.SecFunctionalityType = ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV38DynamicFiltersOperator1 == 0 ) && ( ! (GXutil.strcmp("", AV39SecFunctionalityDescription1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV38DynamicFiltersOperator1 == 1 ) && ( ! (GXutil.strcmp("", AV39SecFunctionalityDescription1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV38DynamicFiltersOperator1 == 0 ) && ( ! (GXutil.strcmp("", AV53SecParentFunctionalityDescription1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV38DynamicFiltersOperator1 == 1 ) && ( ! (GXutil.strcmp("", AV53SecParentFunctionalityDescription1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV41DynamicFiltersEnabled2 && ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV43DynamicFiltersOperator2 == 0 ) && ( ! (GXutil.strcmp("", AV44SecFunctionalityDescription2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV41DynamicFiltersEnabled2 && ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV43DynamicFiltersOperator2 == 1 ) && ( ! (GXutil.strcmp("", AV44SecFunctionalityDescription2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV41DynamicFiltersEnabled2 && ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV43DynamicFiltersOperator2 == 0 ) && ( ! (GXutil.strcmp("", AV54SecParentFunctionalityDescription2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( AV41DynamicFiltersEnabled2 && ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV43DynamicFiltersOperator2 == 1 ) && ( ! (GXutil.strcmp("", AV54SecParentFunctionalityDescription2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( AV46DynamicFiltersEnabled3 && ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV48DynamicFiltersOperator3 == 0 ) && ( ! (GXutil.strcmp("", AV49SecFunctionalityDescription3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( AV46DynamicFiltersEnabled3 && ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV48DynamicFiltersOperator3 == 1 ) && ( ! (GXutil.strcmp("", AV49SecFunctionalityDescription3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( AV46DynamicFiltersEnabled3 && ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV48DynamicFiltersOperator3 == 0 ) && ( ! (GXutil.strcmp("", AV55SecParentFunctionalityDescription3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( AV46DynamicFiltersEnabled3 && ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV48DynamicFiltersOperator3 == 1 ) && ( ! (GXutil.strcmp("", AV55SecParentFunctionalityDescription3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ( AV35OrderedBy == 1 ) && ! AV36OrderedDsc )
      {
         sOrderString += " ORDER BY T1.SecParentFunctionalityId, T1.SecFunctionalityDescription, T1.SecFunctionalityId" ;
      }
      else if ( ( AV35OrderedBy == 1 ) && ( AV36OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.SecParentFunctionalityId DESC, T1.SecFunctionalityDescription DESC, T1.SecFunctionalityId" ;
      }
      else if ( ( AV35OrderedBy == 2 ) && ! AV36OrderedDsc )
      {
         sOrderString += " ORDER BY T1.SecParentFunctionalityId, T1.SecFunctionalityKey" ;
      }
      else if ( ( AV35OrderedBy == 2 ) && ( AV36OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.SecParentFunctionalityId DESC, T1.SecFunctionalityKey DESC" ;
      }
      else if ( ( AV35OrderedBy == 3 ) && ! AV36OrderedDsc )
      {
         sOrderString += " ORDER BY T1.SecParentFunctionalityId, T1.SecFunctionalityType, T1.SecFunctionalityId" ;
      }
      else if ( ( AV35OrderedBy == 3 ) && ( AV36OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.SecParentFunctionalityId DESC, T1.SecFunctionalityType DESC, T1.SecFunctionalityId" ;
      }
      else if ( ( AV35OrderedBy == 4 ) && ! AV36OrderedDsc )
      {
         sOrderString += " ORDER BY T1.SecParentFunctionalityId, T2.SecFunctionalityDescription, T1.SecFunctionalityId" ;
      }
      else if ( ( AV35OrderedBy == 4 ) && ( AV36OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.SecParentFunctionalityId DESC, T2.SecFunctionalityDescription DESC, T1.SecFunctionalityId" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.SecFunctionalityId" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_H002Y3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte AV27SecFunctionalityType ,
                                          String AV37DynamicFiltersSelector1 ,
                                          short AV38DynamicFiltersOperator1 ,
                                          String AV39SecFunctionalityDescription1 ,
                                          String AV53SecParentFunctionalityDescription1 ,
                                          boolean AV41DynamicFiltersEnabled2 ,
                                          String AV42DynamicFiltersSelector2 ,
                                          short AV43DynamicFiltersOperator2 ,
                                          String AV44SecFunctionalityDescription2 ,
                                          String AV54SecParentFunctionalityDescription2 ,
                                          boolean AV46DynamicFiltersEnabled3 ,
                                          String AV47DynamicFiltersSelector3 ,
                                          short AV48DynamicFiltersOperator3 ,
                                          String AV49SecFunctionalityDescription3 ,
                                          String AV55SecParentFunctionalityDescription3 ,
                                          byte A351SecFunctionalityType ,
                                          String A350SecFunctionalityDescription ,
                                          String A353SecParentFunctionalityDescript ,
                                          short AV35OrderedBy ,
                                          boolean AV36OrderedDsc ,
                                          long A63SecParentFunctionalityId ,
                                          long AV29SecParentFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      addWhere(sWhereString, "(T1.SecParentFunctionalityId = ?)");
      if ( ! (0==AV27SecFunctionalityType) )
      {
         addWhere(sWhereString, "(T1.SecFunctionalityType = ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV38DynamicFiltersOperator1 == 0 ) && ( ! (GXutil.strcmp("", AV39SecFunctionalityDescription1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV38DynamicFiltersOperator1 == 1 ) && ( ! (GXutil.strcmp("", AV39SecFunctionalityDescription1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV38DynamicFiltersOperator1 == 0 ) && ( ! (GXutil.strcmp("", AV53SecParentFunctionalityDescription1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV37DynamicFiltersSelector1, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV38DynamicFiltersOperator1 == 1 ) && ( ! (GXutil.strcmp("", AV53SecParentFunctionalityDescription1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV41DynamicFiltersEnabled2 && ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV43DynamicFiltersOperator2 == 0 ) && ( ! (GXutil.strcmp("", AV44SecFunctionalityDescription2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( AV41DynamicFiltersEnabled2 && ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV43DynamicFiltersOperator2 == 1 ) && ( ! (GXutil.strcmp("", AV44SecFunctionalityDescription2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV41DynamicFiltersEnabled2 && ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV43DynamicFiltersOperator2 == 0 ) && ( ! (GXutil.strcmp("", AV54SecParentFunctionalityDescription2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( AV41DynamicFiltersEnabled2 && ( GXutil.strcmp(AV42DynamicFiltersSelector2, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV43DynamicFiltersOperator2 == 1 ) && ( ! (GXutil.strcmp("", AV54SecParentFunctionalityDescription2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( AV46DynamicFiltersEnabled3 && ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV48DynamicFiltersOperator3 == 0 ) && ( ! (GXutil.strcmp("", AV49SecFunctionalityDescription3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( AV46DynamicFiltersEnabled3 && ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV48DynamicFiltersOperator3 == 1 ) && ( ! (GXutil.strcmp("", AV49SecFunctionalityDescription3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV46DynamicFiltersEnabled3 && ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV48DynamicFiltersOperator3 == 0 ) && ( ! (GXutil.strcmp("", AV55SecParentFunctionalityDescription3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( AV46DynamicFiltersEnabled3 && ( GXutil.strcmp(AV47DynamicFiltersSelector3, "SECPARENTFUNCTIONALITYDESCRIPTION") == 0 ) && ( AV48DynamicFiltersOperator3 == 1 ) && ( ! (GXutil.strcmp("", AV55SecParentFunctionalityDescription3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV35OrderedBy == 1 ) && ! AV36OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV35OrderedBy == 1 ) && ( AV36OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV35OrderedBy == 2 ) && ! AV36OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV35OrderedBy == 2 ) && ( AV36OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV35OrderedBy == 3 ) && ! AV36OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV35OrderedBy == 3 ) && ( AV36OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV35OrderedBy == 4 ) && ! AV36OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV35OrderedBy == 4 ) && ( AV36OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_H002Y5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV37DynamicFiltersSelector1 ,
                                          short AV38DynamicFiltersOperator1 ,
                                          String AV53SecParentFunctionalityDescription1 ,
                                          boolean AV41DynamicFiltersEnabled2 ,
                                          String AV42DynamicFiltersSelector2 ,
                                          short AV43DynamicFiltersOperator2 ,
                                          String AV54SecParentFunctionalityDescription2 ,
                                          boolean AV46DynamicFiltersEnabled3 ,
                                          String AV47DynamicFiltersSelector3 ,
                                          short AV48DynamicFiltersOperator3 ,
                                          String AV55SecParentFunctionalityDescription3 ,
                                          String A353SecParentFunctionalityDescript ,
                                          long A62SecFunctionalityId ,
                                          short AV31SecRoleIdParm ,
                                          short A65SecRoleId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[2];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT SecFunctionalityId, SecRoleId FROM SecFunctionalityRole" ;
      addWhere(sWhereString, "(SecFunctionalityId = ? and SecRoleId = ?)");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SecFunctionalityId, SecRoleId" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_H002Y2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Boolean) dynConstraints[5]).booleanValue() , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Boolean) dynConstraints[10]).booleanValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).longValue() , ((Number) dynConstraints[21]).longValue() );
            case 1 :
                  return conditional_H002Y3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Boolean) dynConstraints[5]).booleanValue() , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Boolean) dynConstraints[10]).booleanValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).longValue() , ((Number) dynConstraints[21]).longValue() );
            case 3 :
                  return conditional_H002Y5(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , (String)dynConstraints[2] , ((Boolean) dynConstraints[3]).booleanValue() , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Boolean) dynConstraints[7]).booleanValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002Y2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Y3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Y4", "SELECT SecRoleId, SecRoleDescription FROM SecRole WHERE SecRoleId = ? ORDER BY SecRoleId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H002Y5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
                  stmt.setLong(sIdx, ((Number) parms[17]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[18]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[31]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[32]).intValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[33]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[14]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[2]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               return;
      }
   }

}

